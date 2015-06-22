package ch.fhnw.mdt.launch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.cdt.core.envvar.IEnvironmentVariable;
import org.eclipse.cdt.launch.AbstractCLaunchDelegate;
import org.eclipse.cdt.managedbuilder.core.IManagedBuildInfo;
import org.eclipse.cdt.managedbuilder.core.ManagedBuildManager;
import org.eclipse.cdt.managedbuilder.envvar.IEnvironmentVariableProvider;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.RuntimeProcess;

import ch.fhnw.mdt.launch.tab.MCoreLaunchConfigurationTab;
import ch.fhnw.mdt.preferences.MDTPreferencesPlugin;

// TODO implement ILaunchShortcut
// TODO see LocalCDILaunchDelegate
public class MCoreLaunchDelegate extends AbstractCLaunchDelegate {

	public static final String GFORTH_PATH_VARIABLE = "GFORTHPATH";
	private static final String DEBUG_MODE = "debug";

	private static final String DEBUG_FILE_NAME = "debugCFunction.fs";

	@Override
	public void launch(final ILaunchConfiguration configuration, final String mode, final ILaunch launch, final IProgressMonitor monitor) throws CoreException {
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

			final String umbilical = MDTPreferencesPlugin.getDefault().getUmbilical();

			// TODO show error?
			// abort if umbilical is not set
			if (umbilical == null) {
				return;
			}

			final boolean isDebugMode = launch.getLaunchMode().equals(DEBUG_MODE);

			// copy files into working directory
			try {
				final Path executablePath = Paths.get(workingDirectory, executableFile.getName());
				Files.deleteIfExists(executablePath);

				// copy file to execute
				try (InputStream contents = executableFile.getContents(true)) {
					Files.copy(contents, executablePath);
				}

				// generate debug functions for gforth
				if (isDebugMode) {
					final String debugForth = generateDebugCFunctions(executableFile);

					final Path debugFunctions = Paths.get(workingDirectory, DEBUG_FILE_NAME);

					Files.deleteIfExists(debugFunctions);
					Files.write(debugFunctions, debugForth.getBytes());
				}

				final Path eclipseLoaderPath = Paths.get(workingDirectory, "load_eclipse.fs");

				final String loaderFile = MDTPreferencesPlugin.getDefault().getLoader(executableFile.getName(), isDebugMode);
				Files.write(eclipseLoaderPath, loaderFile.getBytes());
			} catch (final IOException e) {
				e.printStackTrace();
			}

			// run gforth
			final MCoreLaunchProcess launchProcess = run(launch, workingDirectory, umbilical, executableFile);

			// start debugger if necessary
			if (isDebugMode) {
				startDebugger(launchProcess, configuration, launch, monitor, project, executableFile);
			}

			// wait for done
			try {
				launchProcess.process.waitFor();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} catch (final CoreException e) {
			e.printStackTrace();
		} finally {
		}
	}

	private void startDebugger(MCoreLaunchProcess launchProcess, final ILaunchConfiguration configuration, final ILaunch launch, final IProgressMonitor monitor,
			final IProject project, final IFile executableFile) throws CoreException, DebugException {

	}

	// TODO close all streams!
	private MCoreLaunchProcess run(final ILaunch launch, final String workingDirectory, final String umbilical, final IFile executableFile) {
		try {
			final ProcessBuilder processBuilder = new ProcessBuilder("/bin/bash");

			final Process process = processBuilder.start();

			@SuppressWarnings("unused")
			final RuntimeProcess launchProcess = (RuntimeProcess) DebugPlugin.newProcess(launch, process, "gforth launch");
			final BufferedWriter processWriter = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
			// final BufferedReader processReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			processWriter.write("cd " + workingDirectory);
			processWriter.newLine();

			processWriter.write("gforth ./load_eclipse.fs");
			processWriter.newLine();

			processWriter.write("umbilical: " + umbilical);
			processWriter.newLine();

			processWriter.flush();

			return new MCoreLaunchProcess(launchProcess, process);

		} catch (final IOException e) {
			e.printStackTrace();
		}

		return null;

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
				}
			}

		} catch (CoreException | IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	protected String getPluginID() {
		return MDTLaunchPlugin.PLUGIN_ID;
	}

	private static class MCoreLaunchProcess {
		private final IProcess wrapper;
		private final Process process;

		public MCoreLaunchProcess(IProcess wrapper, Process process) {
			super();
			this.wrapper = wrapper;
			this.process = process;
		}

	}
}
