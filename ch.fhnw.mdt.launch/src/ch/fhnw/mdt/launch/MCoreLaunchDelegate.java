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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

import ch.fhnw.mdt.forthdebugger.ForthDebuggerPlugin;
import ch.fhnw.mdt.forthdebugger.IMDTConstants;
import ch.fhnw.mdt.forthdebugger.MDTDebugTarget;
import ch.fhnw.mdt.preferences.MDTPreferencesPlugin;

// TODO implement ILaunchShortcut
// TODO see LocalCDILaunchDelegate
public class MCoreLaunchDelegate extends AbstractCLaunchDelegate {

	public static final String GFORTH_PATH_VARIABLE = "GFORTHPATH";
	private static final String DEBUG_MODE = "debug";
	private static final String DEBUG_FILE_NAME = "debugCFunction.fs";

	private static final String NEW_LINE = System.lineSeparator();

	@Override
	public void launch(final ILaunchConfiguration configuration, final String mode, final ILaunch launch, final IProgressMonitor monitor) throws CoreException {
		try {

			final String projectName = launch.getLaunchConfiguration().getAttribute(IMDTConstants.ATTR_PROJECT, "");
			final IProject project = (IProject) ResourcesPlugin.getWorkspace().getRoot().findMember(projectName);

			final IEnvironmentVariableProvider environmentVariableProvider = ManagedBuildManager.getEnvironmentVariableProvider();
			final IManagedBuildInfo buildInfo = ManagedBuildManager.getBuildInfo(project);
			final IEnvironmentVariable gforthPathEnvironmentVariable = environmentVariableProvider.getVariable(GFORTH_PATH_VARIABLE, buildInfo.getManagedProject()
					.getConfigurations()[0], true);

			final String[] gforthPaths = gforthPathEnvironmentVariable.getValue().split(":");
			final String workingDirectory = gforthPaths[gforthPaths.length - 1];
			final String executableFilePath = launch.getLaunchConfiguration().getAttribute(IMDTConstants.ATTR_FORTH_EXECUTABLE_FILE, "");
			final IFile executableFile = (IFile) project.findMember(executableFilePath);

			final String umbilical = MDTPreferencesPlugin.getDefault().getCheckedUmbilical();
			final boolean isDebugMode = launch.getLaunchMode().equals(DEBUG_MODE);

			// abort if umbilical is not set
			if (umbilical == null) {

				Display.getDefault().asyncExec(new Runnable() {

					@Override
					public void run() {
						MessageDialog.openError(Display.getDefault().getActiveShell(), "Invalid Umbilical", "The umbilical port " + MDTPreferencesPlugin.getDefault().getUmbilical() + " is invalid. Open MCore Preferences and set a valid umbilical port.");
					}
				});

				return;
			}

			// set up working directory with all files necessary
			initializeWorkingDirectory(workingDirectory, executableFile, isDebugMode);

			// launch
			final LaunchJob launchJob = new LaunchJob(isDebugMode, launch, workingDirectory, umbilical, executableFile);
			launchJob.schedule();

		} catch (final CoreException e) {
			e.printStackTrace();
		} finally {
		}
	}

	/**
	 * Initializes the working directory with all files needed for a launch.
	 * 
	 * @param workingDirectory
	 * @param executableFile
	 * @param isDebugMode
	 * @throws CoreException
	 */
	private void initializeWorkingDirectory(final String workingDirectory, final IFile executableFile, final boolean isDebugMode) throws CoreException {
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
	}

	/**
	 * Generates the debug file which maps forth and c function names together and can be used while debugging.
	 * 
	 * @param forthFile
	 *            the forth file to generate function mappings for.
	 * @return
	 */
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

	/**
	 * Wraps a {@link Process} and the corresponding {@link IProcess}.
	 *
	 */
	private static class MCoreLaunchProcess {
		private final IProcess wrapper;
		private final Process process;

		public MCoreLaunchProcess(IProcess wrapper, Process process) {
			super();
			this.wrapper = wrapper;
			this.process = process;
		}

	}

	/**
	 * Launches gforth and the debugger if necessary.
	 */
	private static class LaunchJob extends Job {

		private boolean isDebugMode;
		private ILaunch launch;
		private String workingDirectory;
		private String umbilical;
		private IFile executableFile;

		public LaunchJob(boolean isDebugMode, ILaunch launch, String workingDirectory, String umbilical, IFile executableFile) {
			super("Launch");
			this.isDebugMode = isDebugMode;
			this.launch = launch;
			this.workingDirectory = workingDirectory;
			this.umbilical = umbilical;
			this.executableFile = executableFile;

			setSystem(true);
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {
			// start gforth
			final MCoreLaunchProcess launchProcess = startGforth(launch, workingDirectory, umbilical, executableFile);

			// start debugger if necessary
			if (isDebugMode) {
				try {
					startDebugger(launch, launchProcess);
				} catch (CoreException e) {
					return new Status(IStatus.ERROR, ForthDebuggerPlugin.PLUGIN_ID, e.getMessage());
				}
			}

			// wait for done
			try {
				launchProcess.process.waitFor();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			return new Status(IStatus.OK, ForthDebuggerPlugin.PLUGIN_ID, "");
		}

		/**
		 * Starts the gforth debugger. This must be called after {@link #startGforth(ILaunch, String, String, IFile)}
		 * 
		 * @param launch
		 * @param launchProcess
		 * @throws CoreException
		 */
		private void startDebugger(final ILaunch launch, final MCoreLaunchProcess launchProcess) throws CoreException {
			IDebugTarget target = new MDTDebugTarget(launch, launchProcess.wrapper);
			launch.addDebugTarget(target);
		}

		/**
		 * Starts gforth
		 * 
		 * @param launch
		 * @param workingDirectory
		 * @param umbilical
		 * @param executableFile
		 * @return
		 */
		private MCoreLaunchProcess startGforth(final ILaunch launch, final String workingDirectory, final String umbilical, final IFile executableFile) {
			try {
				final ProcessBuilder processBuilder = new ProcessBuilder("/bin/bash");

				final Process process = processBuilder.start();

				final IProcess launchProcess = DebugPlugin.newProcess(launch, process, "gforth process");

				final BufferedWriter processWriter = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
				processWriter.write("cd " + workingDirectory);
				processWriter.newLine();
				processWriter.flush();

				processWriter.write("gforth ./load_eclipse.fs");
				processWriter.newLine();
				processWriter.flush();

				processWriter.write("umbilical: " + umbilical);
				processWriter.newLine();
				processWriter.flush();

				processWriter.write("run");
				processWriter.newLine();
				processWriter.flush();

				return new MCoreLaunchProcess(launchProcess, process);

			} catch (final IOException e) {
				e.printStackTrace();
			}

			return null;

		}
	}

}
