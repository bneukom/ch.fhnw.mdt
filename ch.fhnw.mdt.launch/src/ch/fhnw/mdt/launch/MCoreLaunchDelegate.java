package ch.fhnw.mdt.launch;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.cdt.core.CCorePlugin;
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
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IOConsole;
import org.eclipse.ui.console.IOConsoleOutputStream;

import ch.fhnw.mdt.forthdebugger.ForthDebuggerPlugin;
import ch.fhnw.mdt.forthdebugger.ForthProcess;
import ch.fhnw.mdt.forthdebugger.communication.ProcessCommunicator;
import ch.fhnw.mdt.forthdebugger.communication.ProcessCommunicator.CommandTimeOutException;
import ch.fhnw.mdt.forthdebugger.communication.process.DefaultProcessDecorator;
import ch.fhnw.mdt.forthdebugger.debugmodel.ForthDebugTarget;
import ch.fhnw.mdt.forthdebugger.debugmodel.IForthConstants;
import ch.fhnw.mdt.platform.IMDTPlatform;
import ch.fhnw.mdt.platform.MDTPlatformPlugin;
import ch.fhnw.mdt.preferences.MDTPreferencesPlugin;
import ch.fhnw.mdt.preferences.SelectUmbilicalPortDialog;

public class MCoreLaunchDelegate extends AbstractCLaunchDelegate implements ILaunchShortcut {

	public static final String GFORTH_PATH_VARIABLE = "GFORTHPATH";
	private static final String DEBUG_MODE = "debug";
	private static final String DEBUG_FILE_NAME = "debugCFunction.fs";

	private final IMDTPlatform platformStrings = MDTPlatformPlugin.getDefault().getPlatformStrings();

	@Override
	public void launch(final ILaunchConfiguration configuration, final String mode, final ILaunch launch, final IProgressMonitor monitor) throws CoreException {
		try {
			final String projectName = launch.getLaunchConfiguration().getAttribute(IForthConstants.ATTR_PROJECT, "");
			final IProject project = (IProject) ResourcesPlugin.getWorkspace().getRoot().findMember(projectName);

			final IEnvironmentVariableProvider environmentVariableProvider = ManagedBuildManager.getEnvironmentVariableProvider();
			final IManagedBuildInfo buildInfo = ManagedBuildManager.getBuildInfo(project);
			final IEnvironmentVariable gforthPathEnvironmentVariable = environmentVariableProvider.getVariable(GFORTH_PATH_VARIABLE,
					buildInfo.getManagedProject().getConfigurations()[0], true);

			final String[] gforthPaths = gforthPathEnvironmentVariable.getValue().split(platformStrings.getEnvironmentSeparators());
			final String workingDirectory = gforthPaths[gforthPaths.length - 1];
			final String executableFilePath = launch.getLaunchConfiguration().getAttribute(IForthConstants.ATTR_FORTH_EXECUTABLE_FILE, "");
			final IFile executableFile = (IFile) project.findMember(executableFilePath);
			final boolean isDebugMode = launch.getLaunchMode().equals(DEBUG_MODE);
			final MDTPreferencesPlugin preferencePlugin = MDTPreferencesPlugin.getDefault();

			String umbilical = preferencePlugin.getCheckedUmbilical();

			// ask user for new umbilical port if it has been set in the
			// preference but is not valid
			if (umbilical == null && preferencePlugin.isUmbilicalPortPreferenceActive()) {
				final SelectUmbilicalPortDialog selectPortDialog = new SelectUmbilicalPortDialog(null);

				Display.getDefault().syncExec(() -> {
					selectPortDialog.open();
				});

				umbilical = selectPortDialog.getSelectedDevice();
			}

			// abort in case we are in debug mode and the port is still not
			// valid
			if (isDebugMode && !preferencePlugin.isValidUmbilical(umbilical)) {
				Display.getDefault().asyncExec(new Runnable() {

					@Override
					public void run() {
						MessageDialog.openError(Display.getDefault().getActiveShell(), "Invalid Umbilical", "The umbilical port " + MDTPreferencesPlugin.getDefault().getUmbilical()
								+ " is invalid. For a debug launch the port must be set. Open MCore Preference Page and set a valid umbilical port.");
					}
				});

				return;
			}

			// set up working directory with all files necessary
			initializeWorkingDirectory(workingDirectory, executableFile, isDebugMode);

			// launch
			final List<String> forthSourceCode = Files.readAllLines(executableFile.getLocation().toFile().toPath());
			final LaunchJob launchJob = new LaunchJob(isDebugMode, launch, workingDirectory, umbilical, forthSourceCode, executableFile);
			launchJob.schedule();

		} catch (final CoreException | IOException e) {
			e.printStackTrace();
		} finally {
		}
	}

	// TODO implement launch shortcut
	@Override
	public void launch(final ISelection selection, final String mode) {
		final IStructuredSelection structuredSelection = (IStructuredSelection) selection;

		final Object firstElement = structuredSelection.getFirstElement();

		final IFile file;

		if (firstElement instanceof IFile) {
			file = (IFile) firstElement;

			if (CCorePlugin.getContentType(file.getName()) != null) {
				System.out.println("c file");
			}
		} else if (firstElement instanceof IProject) {
			file = null;
		} else {
			file = null;
		}

		if (file == null) {
			return;
		}

		final ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
		final ILaunchConfigurationType type = launchManager.getLaunchConfigurationType("ch.fhnw.mdt.launch.mcorelaunch");

		try {
			final ILaunchConfigurationWorkingCopy workingCopy = type.newInstance(null, file.getName().toString());
			workingCopy.setAttribute(IForthConstants.ATTR_PROJECT, file.getProject().getName());
			workingCopy.setAttribute(IForthConstants.ATTR_FORTH_EXECUTABLE_FILE, file.getProjectRelativePath().toString());
			final ILaunchConfiguration configuration = workingCopy.doSave();
			configuration.launch(mode, null);
			// DebugUITools.launch(configuration, mode);
		} catch (final CoreException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void launch(final IEditorPart editor, final String mode) {

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
	 * Generates the debug file which maps forth and c function names together
	 * and can be used while debugging.
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
		return MCoreLaunchPlugin.PLUGIN_ID;
	}

	/**
	 * Launches gforth process and the debugger if necessary.
	 */
	private class LaunchJob extends Job {

		private final boolean isDebugMode;
		private final ILaunch launch;
		private final String workingDirectory;
		private final String umbilical;
		private final IFile executableFile;
		private final List<String> forthSource;

		public LaunchJob(final boolean isDebugMode, final ILaunch launch, final String workingDirectory, final String umbilical, final List<String> forthSource,
				final IFile executableFile) {
			super("Launch MicroCore");
			this.isDebugMode = isDebugMode;
			this.launch = launch;
			this.workingDirectory = workingDirectory;
			this.umbilical = umbilical;
			this.forthSource = forthSource;
			this.executableFile = executableFile;

			setSystem(true);
		}

		@Override
		protected IStatus run(final IProgressMonitor monitor) {
			// start gforth
			try {
				final MCoreLaunch mcoreLaunch = startGforth(launch, workingDirectory, umbilical, executableFile);

				// start debugger if necessary
				if (isDebugMode) {
					startDebugger(launch, mcoreLaunch);
				}

				// wait for done
				mcoreLaunch.await();

				return new Status(IStatus.OK, ForthDebuggerPlugin.PLUGIN_ID, "");

			} catch (Exception e) {
				return new Status(IStatus.ERROR, ForthDebuggerPlugin.PLUGIN_ID, e.getMessage());
			}
		}

		/**
		 * Starts the gforth debugger. This must be called after
		 * {@link #startGforth(ILaunch, String, String, IFile)}
		 * 
		 * @param launch
		 * @param mcoreLaunch
		 * @throws CoreException
		 */
		private void startDebugger(final ILaunch launch, final MCoreLaunch mcoreLaunch) throws CoreException {
			final IDebugTarget target = new ForthDebugTarget(executableFile, forthSource, launch, mcoreLaunch.eclipseProcess, mcoreLaunch.processCommunicator);
			launch.addDebugTarget(target);
		}

		/**
		 * Starts gforth. This method blocks until gforth has been completely
		 * set up. Returns null in case forth could not be started.
		 * 
		 * @param launch
		 * @param workingDirectory
		 * @param umbilical
		 * @param executableFile
		 * @return
		 */
		private MCoreLaunch startGforth(final ILaunch launch, final String workingDirectory, final String umbilical, final IFile executableFile) throws Exception {
			launch.setAttribute(DebugPlugin.ATTR_PROCESS_FACTORY_ID, "ch.fhnw.mdt.launch.forthprocessfactory");

			final ProcessBuilder processBuilder = new ProcessBuilder("gforth", "./load_eclipse.fs");
			processBuilder.redirectErrorStream(true);

			processBuilder.directory(new File(workingDirectory));

			final Process process = processBuilder.start();
			final ForthProcess eclipseProcess = (ForthProcess) DebugPlugin.newProcess(launch, process, "gforth");

			final IOConsole gforthConsole = new IOConsole("gforth console", null);
			ConsolePlugin.getDefault().getConsoleManager().addConsoles(new IConsole[] { gforthConsole });

			final ProcessCommunicator processCommunicator = new ProcessCommunicator(new DefaultProcessDecorator(process), 10000);

			final InputThread inputThread = new InputThread(gforthConsole.getInputStream(), processCommunicator);
			inputThread.start();

			final IOConsoleOutputStream consoleOutputStream = gforthConsole.newOutputStream();
			processCommunicator.forwardOutput(System.out);
			processCommunicator.forwardOutput(consoleOutputStream);

			// display timeout
			processCommunicator.addCommandTimeOutListener(() -> {
				Display.getDefault().asyncExec(() -> {
					try {
						consoleOutputStream.write(System.lineSeparator() + System.lineSeparator() + "The process has timed out.");
						consoleOutputStream.flush();
					} catch (final Exception e) {
						// ignore in case of write error
					}
				});
			});

			processCommunicator.sendCommand("include load_eclipse.fs" + ProcessCommunicator.NL);
			processCommunicator.awaitReadCompletion();

			// can only run if the umbilical port is not null
			if (umbilical != null) {
				processCommunicator.sendCommandAwaitResult("umbilical: " + umbilical + ProcessCommunicator.NL, processCommunicator.newAwaitResult(ProcessCommunicator.OK));
				processCommunicator.sendCommandAwaitResult("run" + ProcessCommunicator.NL, processCommunicator.newAwaitResult("HANDSHAKE"));
			}

			return new MCoreLaunch(eclipseProcess, consoleOutputStream, processCommunicator);

		}
	}

	/**
	 * Reads from the Console and passes the input as commands to
	 * {@link ProcessCommunicator}.
	 */
	private static class InputThread extends Thread {

		private final InputStream inputStream;
		private final ProcessCommunicator processCommunicator;
		private static final char CR = 10;

		public InputThread(final InputStream inputStream, final ProcessCommunicator forthCommandQueue) {
			this.inputStream = inputStream;
			this.processCommunicator = forthCommandQueue;
		}

		@Override
		public void run() {
			final StringBuffer commandBuffer = new StringBuffer();
			while (true) {
				try {
					final char read = (char) inputStream.read();

					// done
					if (read == -1) {
						return;
					}

					if (read == CR) {
						try {
							processCommunicator.sendCommand(commandBuffer.toString().trim() + ProcessCommunicator.NL);
						} catch (final CommandTimeOutException e) {
							return;
						}
						commandBuffer.setLength(0);
					} else {
						commandBuffer.append(read);
					}

				} catch (final IOException e) {
					// stream was closed
					return;
				}
			}
		}
	}

	/**
	 * Contains all necessary information for the launched process.
	 *
	 */
	private static class MCoreLaunch {
		private final IProcess eclipseProcess;
		private final ProcessCommunicator processCommunicator;
		private final IOConsoleOutputStream consoleOutputStream;

		public MCoreLaunch(final IProcess eclipseProcess, final IOConsoleOutputStream consoleOutputStream, final ProcessCommunicator processCommunicator) {
			this.eclipseProcess = eclipseProcess;
			this.consoleOutputStream = consoleOutputStream;
			this.processCommunicator = processCommunicator;
		}

		/**
		 * Waits until the process has finished and then does a cleanup.
		 */
		public void await() {

			// wait until the process communicator has been shut down
			processCommunicator.awaitShutdown();

			try {
				consoleOutputStream.close();
			} catch (final IOException e) {
				// ignore if can not close
			}
		}
	}
}
