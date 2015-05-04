package ch.fhnw.mdt.launch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.eclipse.cdt.core.envvar.IEnvironmentVariable;
import org.eclipse.cdt.managedbuilder.core.IManagedBuildInfo;
import org.eclipse.cdt.managedbuilder.core.ManagedBuildManager;
import org.eclipse.cdt.managedbuilder.envvar.IEnvironmentVariableProvider;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IProcess;

import ch.fhnw.mdt.launch.tab.MCoreLaunchConfigurationTab;
import ch.fhnw.mdt.preferences.MCorePreferencePage;
import ch.fhnw.mdt.preferences.MDTPreferencesPlugin;

// TODO http://stackoverflow.com/questions/10476025/how-to-set-the-caret-of-the-ioconsole
// TODO http://stackoverflow.com/questions/18711112/eclipse-iconsole-caret-position
public class MCoreLauncher {
	public static final String GFORTH_PATH_VARIABLE = "GFORTHPATH";

	public static void launch(final ILaunch launch) {
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

			// TODO umbilical needs to be set (otherwise throw error in pre check)
			// check of launch)
			final String umbilical = MDTPreferencesPlugin.getDefault().getPreferenceStore().getString(MCorePreferencePage.USB_DEVICE_NAME_PREFERENCE);

			launchGforth(launch, workingDirectory, umbilical, executableFile);
		} catch (final CoreException e) {
			e.printStackTrace();
		}
	}

	// TODO close all streams!
	private static void launchGforth(final ILaunch launch, final String workingDirectory, final String umbilical, final IFile executableFile) {
		try {
			final ProcessBuilder processBuilder = new ProcessBuilder("/bin/bash");

			
			final Process process = processBuilder.start();
			final IProcess launchProcess = DebugPlugin.newProcess(launch, process, "gforth launch");

//			final IOConsole launchConsole = (IOConsole) DebugUITools.getConsole(launchProcess);
//			final BufferedWriter consoleWriter = new BufferedWriter(new OutputStreamWriter(launchConsole.newOutputStream()));
			
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
			
			// wait for the process to finish (will finish after exiting the bash or closing the launch)
			try {
				process.waitFor();
			} catch (InterruptedException e) {
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
}
