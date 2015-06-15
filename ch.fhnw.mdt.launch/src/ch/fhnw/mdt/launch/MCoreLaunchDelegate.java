package ch.fhnw.mdt.launch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.cdt.core.envvar.IEnvironmentVariable;
import org.eclipse.cdt.debug.core.CDIDebugModel;
import org.eclipse.cdt.debug.core.ICDIDebugger2;
import org.eclipse.cdt.debug.core.ICDTLaunchConfigurationConstants;
import org.eclipse.cdt.debug.core.ICDebugConfiguration;
import org.eclipse.cdt.debug.core.cdi.ICDISession;
import org.eclipse.cdt.debug.core.cdi.model.ICDITarget;
import org.eclipse.cdt.launch.AbstractCLaunchDelegate;
import org.eclipse.cdt.managedbuilder.core.IManagedBuildInfo;
import org.eclipse.cdt.managedbuilder.core.ManagedBuildManager;
import org.eclipse.cdt.managedbuilder.envvar.IEnvironmentVariableProvider;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IProcess;

import ch.fhnw.mdt.launch.tab.MCoreLaunchConfigurationTab;
import ch.fhnw.mdt.preferences.MCorePreferencePage;
import ch.fhnw.mdt.preferences.MDTPreferencesPlugin;

// TODO implement ILaunchShortcut
// TODO see LocalCDILaunchDelegate
public class MCoreLaunchDelegate extends AbstractCLaunchDelegate {

	public static final String GFORTH_PATH_VARIABLE = "GFORTHPATH";
	private static final String DEBUG_MODE = "debug";

	@SuppressWarnings("unchecked")
	@Override
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
		try {

			final String projectName = launch.getLaunchConfiguration().getAttribute(MCoreLaunchConfigurationTab.PROJECT_ATTRIBUTE, "");
			final IProject project = (IProject) ResourcesPlugin.getWorkspace().getRoot().findMember(projectName);

			final IEnvironmentVariableProvider environmentVariableProvider = ManagedBuildManager.getEnvironmentVariableProvider();
			final IManagedBuildInfo buildInfo = ManagedBuildManager.getBuildInfo(project);
			final IEnvironmentVariable gforthPathEnvironmentVariable = environmentVariableProvider.getVariable(GFORTH_PATH_VARIABLE, buildInfo.getManagedProject()
					.getConfigurations()[0], true);

			final String[] gforthPaths = gforthPathEnvironmentVariable.getValue().split(":");
			final String workingDirectory = gforthPaths[gforthPaths.length - 1];
			final String executableFilePath = launch.getLaunchConfiguration().getAttribute(MCoreLaunchConfigurationTab.EXECUTABLE_FILE_PATH, "");
			final IFile executableFile = (IFile) project.findMember(executableFilePath);

			if (launch.getLaunchMode().equals(DEBUG_MODE)) {
				// generate debug functions for gforth
				final String debugForth = generateDebugCFunctions(executableFile);

				final InputStream stream = new ByteArrayInputStream(debugForth.getBytes(StandardCharsets.UTF_8));
				final IPath debugPath = executableFile.getParent().getFullPath().append("debugCFunction.fs");

				final IFile debugFile = ResourcesPlugin.getWorkspace().getRoot().getFile(debugPath);
				if (debugFile.exists()) {
					debugFile.delete(true, new NullProgressMonitor());
				}
				debugFile.create(stream, true, new NullProgressMonitor());

				// start debugger
				ICDebugConfiguration debugConfig = getDebugConfig(configuration);
				final ICDIDebugger2 debugger = (ICDIDebugger2) debugConfig.createDebugger();
				final ICDISession session= debugger.createSession(launch, executableFile.getFullPath().toFile(), monitor);

				boolean stopInMain = launch.getLaunchConfiguration().getAttribute(ICDTLaunchConfigurationConstants.ATTR_DEBUGGER_STOP_AT_MAIN, false);
				String stopSymbol = null;
				if (stopInMain)
					stopSymbol = launch.getLaunchConfiguration().getAttribute(ICDTLaunchConfigurationConstants.ATTR_DEBUGGER_STOP_AT_MAIN_SYMBOL, ICDTLaunchConfigurationConstants.DEBUGGER_STOP_AT_MAIN_SYMBOL_DEFAULT);
				ICDITarget[] targets = session.getTargets();
				for(int i = 0; i < targets.length; i++) {
					Process process = targets[i].getProcess();
					IProcess iprocess = null;
					if (process != null) {
						iprocess = DebugPlugin.newProcess(launch, process, "debugger", getDefaultProcessMap());
					}
					
					
					CDIDebugModel.newDebugTarget(launch, project.getProject(), targets[i], renderTargetLabel(debugConfig), iprocess, null, true, false, stopSymbol, true);
				}
			}

			// TODO umbilical needs to be set (otherwise throw error in pre check)
			// check of launch)
			final String umbilical = MDTPreferencesPlugin.getDefault().getPreferenceStore().getString(MCorePreferencePage.USB_DEVICE_NAME_PREFERENCE);

			// TODO copy release files into workingDirectory?

			launchGforth(launch, workingDirectory, umbilical, executableFile);
		} catch (final CoreException e) {
			e.printStackTrace();
		} finally {
		}
	}

	private static String generateDebugCFunctions(final IFile forthFile) {
		String result = "";
		try {

			final BufferedReader reader = new BufferedReader(new InputStreamReader(forthFile.getContents()));
			final Pattern functionPattern = Pattern.compile(": _(.*)");
			String line = null;
			while ((line = reader.readLine()) != null) {
				final Matcher matcher = functionPattern.matcher(line);

				// is function
				if (matcher.matches()) {
					final String functionName = matcher.group(1);
					final String entry = "Host T definitions H 2Variable _" + functionName + System.lineSeparator() + "Host s\"" + functionName + "\" _" + functionName + "H 2!";

					result += entry;
					result += System.lineSeparator();

					// Host T definitions H 2Variable C2ForthFunctionName1
					// Host s" _CFunctionName" T C2ForthFunctionName1 H 2!
				}
			}

		} catch (CoreException | IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	// TODO close all streams!
	private static void launchGforth(final ILaunch launch, final String workingDirectory, final String umbilical, final IFile executableFile) {
		try {
			final ProcessBuilder processBuilder = new ProcessBuilder("/bin/bash");

			final Process process = processBuilder.start();

			@SuppressWarnings("unused")
			final IProcess launchProcess = DebugPlugin.newProcess(launch, process, "gforth launch");

			// final IOConsole launchConsole = (IOConsole)
			// DebugUITools.getConsole(launchProcess);
			// final BufferedWriter consoleWriter = new BufferedWriter(new
			// OutputStreamWriter(launchConsole.newOutputStream()));

			final BufferedWriter processWriter = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));

			final BufferedReader processReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			// schedule job for IO
			// readProcessJob.schedule();

			processWriter.write("cd " + workingDirectory);
			processWriter.newLine();

			processWriter.write("gforth ./load_tasks.fs");
			processWriter.newLine();

			processWriter.write("umbilical: " + umbilical);
			processWriter.newLine();

			processWriter.flush();

			// wait for the process to finish (will finish after exiting the
			// bash or closing the launch)
			try {
				process.waitFor();
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}

			// close the process reader, this will automatically stop the job
			processReader.close();

		} catch (final IOException e) {
			e.printStackTrace();
		}

		// TODO get gforth workspace
		// TODO copy ./load_tasks into gforth workspace (eclipse_loader.fs)
		// TODO launch eclipse_loader
		// TODO use
		// http://www.programcreek.com/java-api-examples/index.php?api=org.eclipse.ui.console.IOConsole
		// ?
		// TODO can we change load_tasks to include umbilical port?

		// ProcessBuilder builder = new ProcessBuilder("gforth",
		// "./load_tasks.fs");
		// Process process;
		// try {
		// process = builder.start();
		// DebugPlugin.newProcess(launch, process, "gforth");
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
	}

	@Override
	protected String getPluginID() {
		return MDTLaunchPlugin.PLUGIN_ID;
	}
}
