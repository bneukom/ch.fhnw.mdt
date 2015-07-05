package ch.fhnw.mdt.forthdebugger.debugmodel;

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
import org.eclipse.debug.core.model.IValue;

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

	// program name
	private String programName;

	// suspend state
	private boolean suspended = true;

	// process communication
	private final ForthReader reader;
	private final ForthCommunicator forthCommunicator;

	// threads
	private final ForthThread forthThread;
	private final IThread[] threads;

	private final DebuggerLineListener debugLineListener;

	// the
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
	public ForthDebugTarget(final List<String> forthSource, final ILaunch launch, final IProcess process, final ForthCommunicator communicator, final ForthReader reader)
			throws CoreException {
		super(null);
		this.launch = launch;
		this.process = process;
		this.forthCommunicator = communicator;
		this.reader = reader;
		this.target = this;

		this.sourceMapping = new SourceMapping(forthSource, communicator, reader);

		this.forthThread = new ForthThread(this);
		this.threads = new IThread[] { forthThread };

		this.debugLineListener = new DebuggerLineListener();

		this.reader.addLineListener(debugLineListener);

		DebugPlugin.getDefault().getBreakpointManager().addBreakpointListener(this);

		// started();

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
		if (programName == null) {
			programName = "Forth Program";
			try {
				programName = getLaunch().getLaunchConfiguration().getAttribute(IForthConstants.ATTR_FORTH_EXECUTABLE_FILE, "Forth Program");
			} catch (final CoreException e) {
			}
		}
		return programName;
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
		// fRequestWriter.println("stack");
		// fRequestWriter.flush();
		// try {
		// final String framesData = fRequestReader.readLine();
		// if (framesData != null) {
		// final String[] frames = framesData.split("#");
		// final IStackFrame[] theFrames = new IStackFrame[frames.length];
		// for (int i = 0; i < frames.length; i++) {
		// final String data = frames[i];
		// theFrames[frames.length - i - 1] = new MDTStackFrame(mdtThread, data,
		// i);
		// }
		// return theFrames;
		// }
		// } catch (final IOException e) {
		// abort("Unable to retrieve stack frames", e);
		// }

		return new IStackFrame[] { new ForthStackFrame(forthThread, "", 1) };
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
		// TODO implement
	}

	/**
	 * Returns the current value of the given variable.
	 * 
	 * @param variable
	 * @return variable value
	 * @throws DebugException
	 *             if the request fails
	 */
	protected IValue getVariableValue(final ForthVariable variable) throws DebugException {
		// synchronized (fRequestSocket) {
		// fRequestWriter.println("var " +
		// variable.getStackFrame().getIdentifier() + " " + variable.getName());
		// fRequestWriter.flush();
		// try {
		// final String value = fRequestReader.readLine();
		// return new MDTValue(this, value);
		// } catch (final IOException e) {
		// abort(MessageFormat.format("Unable to retrieve value for variable {0}",
		// variable.getName()), e);
		// }
		// }
		return new ForthValue(this, "100");
	}

	/**
	 * Returns the values on the data stack (top down)
	 * 
	 * @return the values on the data stack (top down)
	 */
	public IValue[] getDataStack() throws DebugException {
		// synchronized (fRequestSocket) {
		// fRequestWriter.println("data");
		// fRequestWriter.flush();
		// try {
		// final String valueString = fRequestReader.readLine();
		// if (valueString != null && valueString.length() > 0) {
		// final String[] values = valueString.split("\\|");
		// final IValue[] theValues = new IValue[values.length];
		// for (int i = 0; i < values.length; i++) {
		// final String value = values[values.length - i - 1];
		// theValues[i] = new MDTValue(this, value);
		// }
		// return theValues;
		// }
		// } catch (final IOException e) {
		// abort("Unable to retrieve data stack", e);
		// }
		// }
		return new IValue[] { new ForthValue(this, "42") };
	}

	/**
	 * Notification a breakpoint was encountered. Determine which breakpoint was hit and fire a suspend event.
	 * 
	 * @param function
	 *            debug event
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
	 * Listens to the stream from the device and fires appropriate events.
	 *
	 */
	private class DebuggerLineListener implements ForthReader.LineListener {
		final Pattern functionPattern = Pattern.compile("([^\\s]+)(\\s+)(-{15})\\n");

		@Override
		public void lineRead(final String line) {
			// breakpoint hit
			final Matcher functionMatcher = functionPattern.matcher(line);
			if (functionMatcher.matches()) {
				forthThread.setStepping(true);
				breakpointHit(functionMatcher.group(1));
			}
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

			for (final Entry<String, Integer> function : forthFunctions.entrySet()) {
				// the code for the function starts two lines after the actual function defintion
				final int startCodeLineNumber = function.getValue() + 2;
				final String functionName = function.getKey();

				communicator.sendCommand("show " + functionName + NL);

				communicator.awaitCommandCompletion();
				reader.awaitReadCompletion();

				String currentLine = reader.getCurrentLine();
				int lineNumber = startCodeLineNumber;
				while (!currentLine.contains("exit")) {

					lineMapping.put(currentLine.substring(0, 8), lineNumber);

					communicator.sendCommandForResult(ForthCommunicator.ANY, NL);
					communicator.awaitCommandCompletion();
					reader.awaitReadCompletion();

					currentLine = reader.getCurrentLine();
					lineNumber++;
				}

				communicator.sendCommand(ForthCommunicator.CR);
			}

			return lineMapping;
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
