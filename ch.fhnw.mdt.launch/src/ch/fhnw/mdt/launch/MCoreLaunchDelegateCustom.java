package ch.fhnw.mdt.launch;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
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
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IOConsole;
import org.eclipse.ui.console.IOConsoleOutputStream;

import ch.fhnw.mdt.forthdebugger.IMDTConstants;
import ch.fhnw.mdt.forthdebugger.MDTDebugTarget;
import ch.fhnw.mdt.launch.tab.MCoreLaunchConfigurationTab;
import ch.fhnw.mdt.preferences.MDTPreferencesPlugin;

// TODO implement ILaunchShortcut
// TODO see LocalCDILaunchDelegate
public class MCoreLaunchDelegateCustom extends AbstractCLaunchDelegate {

	public static final String GFORTH_PATH_VARIABLE = "GFORTHPATH";
	private static final String DEBUG_MODE = "debug";
	private static final String DEBUG_FILE_NAME = "debugCFunction.fs";

	private static final String NEWLINE = System.lineSeparator();

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
				return;
			}

			// set up working directory with all files necessary
			initializeWorkingDirectory(workingDirectory, executableFile, isDebugMode);

			// launch

			// start gforth
			final ForthCommunicator launchProcess = startGforth(launch, workingDirectory, umbilical, executableFile);

			// start debugger if necessary
			if (isDebugMode) {
				// try {
				// startDebugger(launch, launchProcess);
				// } catch (CoreException e) {
				// e.printStackTrace();
				// }
			}

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
	private ForthCommunicator startGforth(final ILaunch launch, final String workingDirectory, final String umbilical, final IFile executableFile) {
		try {
			final ProcessBuilder processBuilder = new ProcessBuilder("/bin/bash");

			final Process process = processBuilder.start();
			final ForthCommunicator forthCommunicator = new ForthCommunicator(process);
			final IOConsole ioConsole = new IOConsole("gforth console", null);

			final IOConsoleOutputStream consoleOutputStream = ioConsole.newOutputStream();
			final IOConsoleOutputStream errorStream = ioConsole.newOutputStream();

			forthCommunicator.forward(consoleOutputStream);
			forthCommunicator.forwardError(errorStream);
			forthCommunicator.readFrom(ioConsole.getInputStream());

			ConsolePlugin.getDefault().getConsoleManager().addConsoles(new IConsole[] { ioConsole });

			// forthCommunicator.sendCommand("cd " + workingDirectory, (c, r) -> {
			// });

			return forthCommunicator;

			// final IProcess launchProceses = DebugPlugin.newProcess(launch, process, "gforth process");
			//
			// final BufferedWriter processWriter = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
			// processWriter.write("cd " + workingDirectory);
			// processWriter.newLine();
			//
			// processWriter.write("gforth ./load_eclipse.fs");
			// processWriter.newLine();
			//
			// processWriter.write("umbilical: " + umbilical);
			// processWriter.newLine();
			//
			// processWriter.write("run");
			// processWriter.newLine();
			//
			// processWriter.flush();

		} catch (final IOException e) {
			e.printStackTrace();
		}

		return null;

	}

	public static class ForthCommunicator {
		private final Process process;
		private final BufferedInputStream processInputStream;
		private final BufferedInputStream processErrorStream;
		private final OutputStream processOutputStream;
		private final BufferedWriter processWriter;

		private final List<OutputStream> forwardedStreams = new ArrayList<OutputStream>();
		private final List<OutputStream> forwardedErrorStreams = new ArrayList<OutputStream>();
		private final List<InputStream> readFrom = new ArrayList<InputStream>();

		private final Job forwardJob = new Job("read") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				while (process.isAlive()) {
					for (OutputStream outputStream : forwardedStreams) {
						try {
							int read = processInputStream.read();
							outputStream.write(read);
							outputStream.flush();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}

				return null;
			}
		};

		private final Job forwardErrorJob = new Job("error") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				while (process.isAlive()) {
					for (OutputStream outputStream : forwardedErrorStreams) {
						try {
							int read = processInputStream.read();
							outputStream.write(read);
							outputStream.flush();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				return null;
			}
		};

		public ForthCommunicator(final Process process) {
			this.process = process;
			this.processInputStream = new BufferedInputStream(process.getInputStream());
			this.processErrorStream = new BufferedInputStream(process.getErrorStream());
			this.processWriter = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
			this.processOutputStream = process.getOutputStream();

			this.forwardErrorJob.setSystem(true);
			this.forwardErrorJob.schedule();

			this.forwardJob.setSystem(true);
			this.forwardJob.schedule();
		}

		public void sendCommand(String command, OnResult result) {
			try {
				processWriter.write(command);
				processWriter.newLine();
				processWriter.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void readFrom(InputStream inputStream) {
			final Job readJob = new Job("read") {

				@Override
				protected IStatus run(IProgressMonitor monitor) {
					while (process.isAlive()) {
						try {
							int read = inputStream.read();
							processOutputStream.write(read);
							processOutputStream.flush();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					return null;
				}
			};

			readJob.setSystem(true);
			readJob.schedule();
		}

		public void forward(OutputStream outputStream) {
			forwardedStreams.add(outputStream);
		}

		public void forwardError(OutputStream outputStream) {
			// forwardedErrorStreams.add(outputStream);
		}
	}

	public static interface OnResult {
		public void onResult(String command, String result);
	}
}
