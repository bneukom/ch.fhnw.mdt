package ch.fhnw.mdt.launch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.lang.ProcessBuilder.Redirect;

import org.eclipse.cdt.core.envvar.IEnvironmentVariable;
import org.eclipse.cdt.managedbuilder.core.IManagedBuildInfo;
import org.eclipse.cdt.managedbuilder.core.ManagedBuildManager;
import org.eclipse.cdt.managedbuilder.envvar.IEnvironmentVariableProvider;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.internal.ui.DebugUIPlugin;
import org.eclipse.debug.internal.ui.views.console.ProcessConsole;
import org.eclipse.debug.internal.ui.views.console.ProcessConsoleManager;

import ch.fhnw.mdt.build.Activator;
import ch.fhnw.mdt.launch.tab.MCoreLaunchConfigurationTab;
import ch.fhnw.mdt.preferences.MCorePreferencePage;
import ch.fhnw.mdt.preferences.MDTPreferencesPlugin;

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

			// TODO umbilical needs to be set (otherwise throw error in pre
			// check of launch)
			final String umbilical = MDTPreferencesPlugin.getDefault().getPreferenceStore().getString(MCorePreferencePage.USB_DEVICE_NAME_PREFERENCE);

			launchGforth(launch, workingDirectory, umbilical, executableFile);
		} catch (final CoreException e) {
			e.printStackTrace();
		}
	}

	// TODO job needed?
	// TODO exception on close
	private static final class ReadProcessJob extends Job {

		private final BufferedReader reader;
		private BufferedWriter consoleWriter;
		private BufferedWriter processWriter;
		private String umbilical;
		private String workingDirectory;
		private IFile executableFile;

		public ReadProcessJob(BufferedReader processReader, BufferedWriter processWriter, BufferedWriter consoleWriter, String umbilical, IFile executableFile,
				String workingDirectory) {
			super("GForth Process IO");

			this.reader = processReader;
			this.processWriter = processWriter;
			this.consoleWriter = consoleWriter;
			this.umbilical = umbilical;
			this.executableFile = executableFile;
			this.workingDirectory = workingDirectory;
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {
			try {
				// TODO umbilical needs to be set (otherwise throw error in pre
				// check of launch)
				final boolean umbilicalSet = umbilical != null && umbilical.length() > 0;
				consoleWriter.write("launch " + executableFile.getName() + " in working directory " + workingDirectory);
				consoleWriter.newLine();
				if (umbilicalSet) {
					consoleWriter.write("umbilical is set to " + umbilical);
					consoleWriter.newLine();
				}

				processWriter.write("cd " + workingDirectory);
				processWriter.newLine();

				processWriter.write("gforth ./load_tasks.fs");
				processWriter.newLine();

				if (umbilicalSet) {
					processWriter.write("umbilical: " + umbilical);
					processWriter.newLine();

				}

				processWriter.flush();
				consoleWriter.flush();

				// read
				int nextChar;
				while ((nextChar = reader.read()) != -1) {
					consoleWriter.write(nextChar);
					consoleWriter.flush();
				}
				// String line;
				// while ((line = reader.readLine()) != null) {
				// consoleWriter.write(line + " reader!");
				// consoleWriter.newLine();
				// consoleWriter.flush();
				// }
				System.out.println("Process Done!");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return new Status(IStatus.OK, Activator.PLUGIN_ID, null);
		}
	}

	// TODO close streams!
	@SuppressWarnings("restriction")
	private static void launchGforth(final ILaunch launch, final String workingDirectory, final String umbilical, final IFile executableFile) {
		try {
			final ProcessBuilder processBuilder = new ProcessBuilder("/bin/bash");

			final Process process = processBuilder.start();
			final ProcessConsoleManager consoleManager = DebugUIPlugin.getDefault().getProcessConsoleManager();
			final IProcess launchProcess = DebugPlugin.newProcess(launch, process, "gforth launch");

			final ProcessConsole launchConsole = (ProcessConsole) consoleManager.getConsole(launchProcess);

			final BufferedWriter consoleWriter = new BufferedWriter(new OutputStreamWriter(launchConsole.newOutputStream()));
			final BufferedWriter processWriter = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));

			final ReadProcessJob readProcessJob = new ReadProcessJob(new BufferedReader(new InputStreamReader(process.getInputStream())), processWriter, consoleWriter, umbilical,
					executableFile, workingDirectory);
			readProcessJob.schedule();

			try {
				process.waitFor();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

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
