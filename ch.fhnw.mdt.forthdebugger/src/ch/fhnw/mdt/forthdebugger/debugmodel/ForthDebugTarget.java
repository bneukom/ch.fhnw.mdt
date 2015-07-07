package ch.fhnw.mdt.forthdebugger.debugmodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;

import ch.fhnw.mdt.forthdebugger.ForthCommunicator;
import ch.fhnw.mdt.forthdebugger.ForthReader;

/**
 * PDA Debug Target
 */
public class ForthDebugTarget extends ForthDebugElement implements IDebugTarget {

	// associated system process (VM)
	private final IProcess process;

	// containing launch object
	private final ILaunch launch;

	// forth file name
	private final String forthFileName;

	// suspend state
	private boolean suspended = true;

	// process communication
	private final ForthReader reader;
	private final ForthCommunicator forthCommunicator;

	// threads
	private final ForthThread forthThread;
	private final IThread[] threads;

	// debugger state
	private String currentAddress;
	private String currentFunction;

	private DebugStreamListener debugStreamListener;
	private final SourceMapping sourceMapping;

	private static final String NL = System.lineSeparator();

	/**
	 * Constructs a new debug target in the given launch for the associated PDA VM process.
	 * 
	 * @param launch
	 *            containing launch
	 * @param requestPort
	 *            port to send requests to the VM
	 * @param eventPort
	 *            port to read events from
	 * @exception CoreException
	 *                if unable to connect to host
	 */
	public ForthDebugTarget(final String forthFileName, final List<String> forthSource, final ILaunch launch, final IProcess process, final ForthCommunicator communicator,
			final ForthReader reader) throws CoreException {
		super(null);
		this.forthFileName = forthFileName;
		this.launch = launch;
		this.process = process;
		this.forthCommunicator = communicator;
		this.reader = reader;
		this.target = this;

		this.sourceMapping = new SourceMapping(forthSource, communicator, reader);

		this.forthThread = new ForthThread(this);
		this.threads = new IThread[] { forthThread };

		try {
			final PipedInputStream in = new PipedInputStream();
			final PipedOutputStream out = new PipedOutputStream(in);

			this.debugStreamListener = new DebugStreamListener(in);
			this.debugStreamListener.start();

			this.reader.forwardOutput(out);
		} catch (IOException e) {
			e.printStackTrace();
		}

		DebugPlugin.getDefault().getBreakpointManager().addBreakpointListener(this);

		started();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IDebugTarget#getProcess()
	 */
	@Override
	public IProcess getProcess() {
		return process;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IDebugTarget#getThreads()
	 */
	@Override
	public IThread[] getThreads() throws DebugException {
		return threads;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IDebugTarget#hasThreads()
	 */
	@Override
	public boolean hasThreads() throws DebugException {
		return true; // WTB Changed per bug #138600
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IDebugTarget#getName()
	 */
	@Override
	public String getName() throws DebugException {
		return forthFileName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IDebugTarget#supportsBreakpoint(org.eclipse .debug.core.model.IBreakpoint)
	 */
	@Override
	public boolean supportsBreakpoint(final IBreakpoint breakpoint) {
		if (breakpoint.getModelIdentifier().equals(IForthConstants.ID_MDT_DEBUG_MODEL)) {
			try {
				final String program = getLaunch().getLaunchConfiguration().getAttribute(IForthConstants.ATTR_FORTH_EXECUTABLE_FILE, (String) null);
				if (program != null) {
					final IMarker marker = breakpoint.getMarker();
					if (marker != null) {
						final IPath p = new Path(program);
						return true;
						// TODO implement marker checking to see if we are in a
						// valid file
						// return marker.getResource().getFullPath().equals(p);
					}
				}
			} catch (final CoreException e) {
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IDebugElement#getDebugTarget()
	 */
	@Override
	public IDebugTarget getDebugTarget() {
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IDebugElement#getLaunch()
	 */
	@Override
	public ILaunch getLaunch() {
		return launch;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.ITerminate#canTerminate()
	 */
	@Override
	public boolean canTerminate() {
		return getProcess().canTerminate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.ITerminate#isTerminated()
	 */
	@Override
	public boolean isTerminated() {
		return getProcess().isTerminated();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.ITerminate#terminate()
	 */
	@Override
	public void terminate() throws DebugException {
		process.terminate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#canResume()
	 */
	@Override
	public boolean canResume() {
		return !isTerminated() && isSuspended();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#canSuspend()
	 */
	@Override
	public boolean canSuspend() {
		return !isTerminated() && !isSuspended();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#isSuspended()
	 */
	@Override
	public boolean isSuspended() {
		return suspended;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#resume()
	 */
	@Override
	public void resume() throws DebugException {
		// TODO implement
	}

	/**
	 * Notification the target has resumed for the given reason
	 * 
	 * @param detail
	 *            reason for the resume
	 */
	private void resumed(final int detail) {
		suspended = false;
		forthThread.fireResumeEvent(detail);
	}

	/**
	 * Notification the target has suspended for the given reason
	 * 
	 * @param detail
	 *            reason for the suspend
	 */
	private void suspended(final int detail) {
		suspended = true;
		forthThread.fireSuspendEvent(detail);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#suspend()
	 */
	@Override
	public void suspend() throws DebugException {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.IBreakpointListener#breakpointAdded(org.eclipse .debug.core.model.IBreakpoint)
	 */
	@Override
	public void breakpointAdded(final IBreakpoint breakpoint) {
		if (supportsBreakpoint(breakpoint)) {
			try {
				if (breakpoint.isEnabled()) {
					try {
						addFunctionBreakpoint(breakpoint.getMarker().getAttribute(ForthLineBreakpoint.ATTR_FUNCTION_NAME, ""));
					} catch (final CoreException e) {
					}
				}
			} catch (final CoreException e) {
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.IBreakpointListener#breakpointRemoved(org.eclipse .debug.core.model.IBreakpoint, org.eclipse.core.resources.IMarkerDelta)
	 */
	@Override
	public void breakpointRemoved(final IBreakpoint breakpoint, final IMarkerDelta delta) {
		if (supportsBreakpoint(breakpoint)) {
			try {
				removeFunctionBreakpoint(breakpoint.getMarker().getAttribute(ForthLineBreakpoint.ATTR_FUNCTION_NAME, ""));
			} catch (final CoreException e) {
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.IBreakpointListener#breakpointChanged(org.eclipse .debug.core.model.IBreakpoint, org.eclipse.core.resources.IMarkerDelta)
	 */
	@Override
	public void breakpointChanged(final IBreakpoint breakpoint, final IMarkerDelta delta) {
		if (supportsBreakpoint(breakpoint)) {
			try {
				if (breakpoint.isEnabled()) {
					breakpointAdded(breakpoint);
				} else {
					breakpointRemoved(breakpoint, null);
				}
			} catch (final CoreException e) {
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IDisconnect#canDisconnect()
	 */
	@Override
	public boolean canDisconnect() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IDisconnect#disconnect()
	 */
	@Override
	public void disconnect() throws DebugException {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IDisconnect#isDisconnected()
	 */
	@Override
	public boolean isDisconnected() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IMemoryBlockRetrieval#supportsStorageRetrieval ()
	 */
	@Override
	public boolean supportsStorageRetrieval() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IMemoryBlockRetrieval#getMemoryBlock(long, long)
	 */
	@Override
	public IMemoryBlock getMemoryBlock(final long startAddress, final long length) throws DebugException {
		return null;
	}

	/**
	 * Called after the debugger has started, sets up everything necessary.
	 */
	private void started() {
		fireCreationEvent();
		installDeferredBreakpoints();
		try {
			resume();
		} catch (final DebugException e) {
		}
	}

	/**
	 * Install breakpoints that are already registered with the breakpoint manager.
	 */
	private void installDeferredBreakpoints() {
		final IBreakpoint[] breakpoints = DebugPlugin.getDefault().getBreakpointManager().getBreakpoints(IForthConstants.ID_MDT_DEBUG_MODEL);
		for (int i = 0; i < breakpoints.length; i++) {
			breakpointAdded(breakpoints[i]);
		}
	}

	/**
	 * Called when this debug target terminates.
	 */
	private void terminated() {
		suspended = false;
		DebugPlugin.getDefault().getBreakpointManager().removeBreakpointListener(this);
		fireTerminateEvent();
	}

	/**
	 * Returns the current stack frames in the target.
	 * 
	 * @return the current stack frames in the target
	 * @throws DebugException
	 *             if unable to perform the request
	 */
	protected IStackFrame[] getStackFrames() throws DebugException {
		if (forthThread.isStepping()) {
			final int lineNumber = sourceMapping.getLineNumber(currentAddress);

			return new IStackFrame[] { new ForthStackFrame(forthThread, currentFunction, forthFileName, lineNumber, 0) };
		}

		return new IStackFrame[0];
	}

	/**
	 * Adds a breakpoint for the given function.
	 * 
	 * @param function
	 * @throws DebugException
	 */
	protected void addFunctionBreakpoint(final String function) throws DebugException {
		forthCommunicator.sendCommand("debug _" + function + NL);
	}

	/**
	 * Adds a breakpoint for the given function.
	 * 
	 * @param function
	 * @throws DebugException
	 */
	protected void removeFunctionBreakpoint(final String function) throws DebugException {
		forthCommunicator.sendCommand("unbug _" + function + NL);
	}

	/**
	 * Single step the interpreter.
	 * 
	 * @throws DebugException
	 *             if the request fails
	 */
	protected void step() throws DebugException {
		forthCommunicator.sendCommand(ForthCommunicator.CR);
	}

	/**
	 * Listens to the forth process output and reports appropriate events.
	 *
	 */
	private class DebugStreamListener extends Thread {

		private final InputStream stream;
		private final Pattern functionPattern = Pattern.compile("([^\\s]+)(\\s+)(-{15})");
		private final Pattern stepPattern = Pattern.compile("([A-Fa-f0-9]{8}):(.*)>");

		public DebugStreamListener(InputStream stream) {
			this.stream = stream;
		}

		@Override
		public void run() {
			StringBuilder line = new StringBuilder();

			while (true) {
				try {
					final char read = (char) stream.read();
					line.append(read);

					fireEvents(line.toString());

					if (line.toString().endsWith(NL)) {
						line = new StringBuilder();
					}

				} catch (IOException e) {
					return;
				}
			}
		}

		private void fireEvents(String current) {
			final Matcher functionMatcher = functionPattern.matcher(current);
			final Matcher stepMatcher = stepPattern.matcher(current);

			if (functionMatcher.matches()) {
				// breakpoint hit
				breakpointHit(functionMatcher.group(1));
			} else if (stepMatcher.matches()) {
				// step
				stepped(stepMatcher.group(1));
			} else if (current.startsWith("uCore>")) {
				// step end
				functionEnded();
			}
		}

		/**
		 * Notification a breakpoint was encountered. Determine which breakpoint was hit and fire a suspend event.
		 * 
		 * @param function
		 *            the function
		 */
		private void breakpointHit(final String function) {
			// determine which breakpoint was hit, and set the thread's breakpoint
			final IBreakpoint[] breakpoints = DebugPlugin.getDefault().getBreakpointManager().getBreakpoints(IForthConstants.ID_MDT_DEBUG_MODEL);
			for (int i = 0; i < breakpoints.length; i++) {
				final IBreakpoint breakpoint = breakpoints[i];
				if (supportsBreakpoint(breakpoint)) {
					if (breakpoint instanceof ForthLineBreakpoint) {
						final ForthLineBreakpoint lineBreakpoint = (ForthLineBreakpoint) breakpoint;
						try {
							if (function.equals("_" + lineBreakpoint.getMarker().getAttribute(ForthLineBreakpoint.ATTR_FUNCTION_NAME))) {
								forthThread.setBreakpoints(new IBreakpoint[] { breakpoint });
								currentFunction = function;
								break;
							}
						} catch (final CoreException e) {
						}
					}
				}
			}
			suspended(DebugEvent.BREAKPOINT);
		}

		/**
		 * Notification that the debugger has stepped.
		 * 
		 * @param address
		 *            the address to which the debugger has stepped
		 */
		private void stepped(final String address) {
			currentAddress = address;
			forthThread.setStepping(true);

			suspended(DebugEvent.STEP_END);
		}

		/**
		 * Notification that the debugger has reached the end of a function and is ready to resume normally.
		 */
		private void functionEnded() {
			currentAddress = null;
			currentFunction = null;
			forthThread.setStepping(false);

			resumed(DebugEvent.RESUME);
		}

	}

	/**
	 * Maps runtime addresses to the corresponding line number of the source code.
	 *
	 */
	private static class SourceMapping {

		private final List<String> forthSource;
		private ForthCommunicator communicator;
		private ForthReader reader;

		private final Map<String, Integer> lineMapping;

		public SourceMapping(List<String> forthSource, ForthCommunicator communicator, ForthReader reader) {
			this.forthSource = forthSource;
			this.communicator = communicator;
			this.reader = reader;
			this.lineMapping = createLineMapping();
		}

		private Map<String, Integer> createLineMapping() {
			final Map<String, Integer> forthFunctions = getForthFunctions(forthSource);
			final Map<String, Integer> lineMapping = new HashMap<String, Integer>();
			final Pattern disasemblerLinePattern = Pattern.compile("([A-Fa-f0-9]{8}): ([A-Fa-f0-9 ]{8}) ?([^\\s]+)(.*)");
			

			for (final Entry<String, Integer> function : forthFunctions.entrySet()) {
				// the code for the function starts two lines after the actual function defintion
				final int startCodeLineNumber = function.getValue() + 2;
				final String functionName = function.getKey();

				communicator.sendCommandAwaitResult("show " + functionName + NL, "---------------");

				communicator.awaitCommandCompletion();
				reader.awaitReadCompletion();
				

				String currentLine = reader.getCurrentLine();
				int lineNumber = startCodeLineNumber;
				lineNumber = insertLine(currentLine, lineNumber, disasemblerLinePattern, lineMapping);

				while (!currentLine.contains("exit")) {
					communicator.sendCommandAwaitResult(ForthCommunicator.ANY, NL);
					communicator.awaitCommandCompletion();
					reader.awaitReadCompletion();

					currentLine = reader.getCurrentLine();
					lineNumber = insertLine(currentLine, lineNumber, disasemblerLinePattern, lineMapping);
					
				}

				communicator.sendCommand(ForthCommunicator.CR);
			}

			return lineMapping;
		}
		
		private int insertLine(String currentLine, int currentLineNumber, Pattern disasemblerLinePattern, Map<String, Integer> lineMapping) {
			final Matcher lineMatcher = disasemblerLinePattern.matcher(currentLine);
			lineMatcher.find();

			final String address = lineMatcher.group(1);
			String word = lineMatcher.group(3);
			
			try {
				int intValue = Integer.parseUnsignedInt(word, 16);
				word = Integer.toString(intValue);
			} catch (NumberFormatException e) {
				// ignore
			}
			
			// search for the line in the original source, this needs to be done to achieve the following things:
			// - skip empty lines
			// - skip comments
			// - skip labels
			// - sometimes forth merges some words (swap \n - becomes swap-)
			String line = forthSource.get(currentLineNumber - 1); // -1 because in the array lines are not one based
			while (!line.startsWith(word)) {
				currentLineNumber++;
				line = forthSource.get(currentLineNumber - 1); // -1 because in the array lines are not one based
			}
			
			lineMapping.put(address, ++currentLineNumber);
			
			return currentLineNumber;
		}

		/**
		 * Returns the line number for the given address. An Address is an 8 digit hex number (e.g. 0000067A).
		 * 
		 * @param address
		 * @return
		 */
		public int getLineNumber(final String address) {
			return lineMapping.get(address);
		}

		/**
		 * Returns all forth functions and their corresponding line number (one based) for the given forth source. This method does not return the forth function with the name any.
		 * 
		 * @param forthSource
		 * @return
		 */
		private static Map<String, Integer> getForthFunctions(final List<String> forthSource) {

			final Map<String, Integer> forthFunctions = new HashMap<String, Integer>();

			for (int lineIndex = 0; lineIndex < forthSource.size(); ++lineIndex) {
				final String line = forthSource.get(lineIndex);

				if (line.startsWith(":")) {
					final int lineNumber = lineIndex + 1;
					final String functionName = line.replaceAll(":\\s+", "");

					if (!functionName.equals("any"))
						forthFunctions.put(functionName, lineNumber);
				}
			}

			return forthFunctions;
		}
	}
}
