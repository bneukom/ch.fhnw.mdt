package ch.fhnw.mdt.forthdebugger;

import java.io.IOException;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.IStreamListener;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.ILineBreakpoint;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IStreamMonitor;
import org.eclipse.debug.core.model.IStreamsProxy;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IValue;

/**
 * PDA Debug Target
 */
public class MDTDebugTarget extends MDTDebugElement implements IDebugTarget {

	// associated system process (VM)
	private final IProcess process;

	// containing launch object
	private final ILaunch launch;

	// program name
	private String programName;

	// suspend state
	private boolean suspended = true;

	// process communication
	private IStreamsProxy processProxy;

	// threads
	private final MDTThread mdtThread;
	private final IThread[] threads;

	// debug commands
	private static final String START_DEBUGGER = "debugger";
	private static final String DEBUG_FUNCTION = "debug";

	private static final String NEW_LINE = System.lineSeparator();

	private enum DebugState {

	}

	/**
	 * Constructs a new debug target in the given launch for the associated PDA
	 * VM process.
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
	public MDTDebugTarget(final ILaunch launch, final IProcess eclipseProcess) throws CoreException {
		super(null);
		this.launch = launch;
		this.process = eclipseProcess;
		this.target = this;

		this.processProxy = eclipseProcess.getStreamsProxy();
		this.processProxy.getOutputStreamMonitor().addListener(new IStreamListener() {

			@Override
			public void streamAppended(String text, IStreamMonitor monitor) {
				System.out.println("event: \"" + text + "\"");
			}
		});

		this.mdtThread = new MDTThread(this);
		this.threads = new IThread[] { mdtThread };

		DebugPlugin.getDefault().getBreakpointManager().addBreakpointListener(this);

		// start the debugger
		// sendCommand(START_DEBUGGER);
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
			programName = "MDT Program";
			try {
				programName = getLaunch().getLaunchConfiguration().getAttribute(IMDTConstants.ATTR_FORTH_EXECUTABLE_FILE, "MDT Program");
			} catch (final CoreException e) {
			}
		}
		return programName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.core.model.IDebugTarget#supportsBreakpoint(org.eclipse
	 * .debug.core.model.IBreakpoint)
	 */
	@Override
	public boolean supportsBreakpoint(final IBreakpoint breakpoint) {
		if (breakpoint.getModelIdentifier().equals(IMDTConstants.ID_MDT_DEBUG_MODEL)) {
			try {
				final String program = getLaunch().getLaunchConfiguration().getAttribute(IMDTConstants.ATTR_FORTH_EXECUTABLE_FILE, (String) null);
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
		sendCommand("resume");
	}

	/**
	 * Notification the target has resumed for the given reason
	 * 
	 * @param detail
	 *            reason for the resume
	 */
	private void resumed(final int detail) {
		suspended = false;
		mdtThread.fireResumeEvent(detail);
	}

	/**
	 * Notification the target has suspended for the given reason
	 * 
	 * @param detail
	 *            reason for the suspend
	 */
	private void suspended(final int detail) {
		suspended = true;
		mdtThread.fireSuspendEvent(detail);
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
	 * @see
	 * org.eclipse.debug.core.IBreakpointListener#breakpointAdded(org.eclipse
	 * .debug.core.model.IBreakpoint)
	 */
	@Override
	public void breakpointAdded(final IBreakpoint breakpoint) {
		if (supportsBreakpoint(breakpoint)) {
			try {
				if (breakpoint.isEnabled()) {
					try {
						addFunctionBreakpoint(breakpoint.getMarker().getAttribute(MDTLineBreakpoint.ATTR_FUNCTION_NAME, ""));
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
	 * @see
	 * org.eclipse.debug.core.IBreakpointListener#breakpointRemoved(org.eclipse
	 * .debug.core.model.IBreakpoint, org.eclipse.core.resources.IMarkerDelta)
	 */
	@Override
	public void breakpointRemoved(final IBreakpoint breakpoint, final IMarkerDelta delta) {
		if (supportsBreakpoint(breakpoint)) {
			try {
				removeFunctionBreakpoint(breakpoint.getMarker().getAttribute(MDTLineBreakpoint.ATTR_FUNCTION_NAME, ""));
			} catch (final CoreException e) {
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.core.IBreakpointListener#breakpointChanged(org.eclipse
	 * .debug.core.model.IBreakpoint, org.eclipse.core.resources.IMarkerDelta)
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
	 * @see
	 * org.eclipse.debug.core.model.IMemoryBlockRetrieval#supportsStorageRetrieval
	 * ()
	 */
	@Override
	public boolean supportsStorageRetrieval() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.core.model.IMemoryBlockRetrieval#getMemoryBlock(long,
	 * long)
	 */
	@Override
	public IMemoryBlock getMemoryBlock(final long startAddress, final long length) throws DebugException {
		return null;
	}

	/**
	 * Notification we have connected to the VM and it has started. Resume the
	 * VM.
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
	 * Install breakpoints that are already registered with the breakpoint
	 * manager.
	 */
	private void installDeferredBreakpoints() {
		final IBreakpoint[] breakpoints = DebugPlugin.getDefault().getBreakpointManager().getBreakpoints(IMDTConstants.ID_MDT_DEBUG_MODEL);
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
		return new IStackFrame[0];
	}

	/**
	 * Adds a breakpoint for the given function.
	 * 
	 * @param function
	 * @throws DebugException
	 */
	protected void addFunctionBreakpoint(String function) throws DebugException {
		sendCommand("debug _" + function);
	}

	/**
	 * Adds a breakpoint for the given function.
	 * 
	 * @param function
	 * @throws DebugException
	 */
	protected void removeFunctionBreakpoint(String function) throws DebugException {
		sendCommand("unbug _" + function);
	}

	/**
	 * Single step the interpreter.
	 * 
	 * @throws DebugException
	 *             if the request fails
	 */
	protected void step() throws DebugException {
		sendCommand("step");
	}

	/**
	 * Returns the current value of the given variable.
	 * 
	 * @param variable
	 * @return variable value
	 * @throws DebugException
	 *             if the request fails
	 */
	protected IValue getVariableValue(final MDTVariable variable) throws DebugException {
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
		return null;
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
		return new IValue[0];
	}

	/**
	 * Sends a request to the PDA VM and waits for an OK.
	 * 
	 * @param request
	 *            debug command
	 * @throws DebugException
	 *             if the request fails
	 */
	private void sendCommand(final String request) throws DebugException {
		try {
			processProxy.write(request + NEW_LINE);
		} catch (IOException e) {
			throw new DebugException(new Status(IStatus.ERROR, ForthDebuggerPlugin.PLUGIN_ID, e.getMessage()));
		}
	}

	/**
	 * Notification a breakpoint was encountered. Determine which breakpoint was
	 * hit and fire a suspend event.
	 * 
	 * @param event
	 *            debug event
	 */
	private void breakpointHit(final String event) {
		// determine which breakpoint was hit, and set the thread's breakpoint
		final int lastSpace = event.lastIndexOf(' ');
		if (lastSpace > 0) {
			final String line = event.substring(lastSpace + 1);
			final int lineNumber = Integer.parseInt(line);
			final IBreakpoint[] breakpoints = DebugPlugin.getDefault().getBreakpointManager().getBreakpoints(IMDTConstants.ID_MDT_DEBUG_MODEL);
			for (int i = 0; i < breakpoints.length; i++) {
				final IBreakpoint breakpoint = breakpoints[i];
				if (supportsBreakpoint(breakpoint)) {
					if (breakpoint instanceof ILineBreakpoint) {
						final ILineBreakpoint lineBreakpoint = (ILineBreakpoint) breakpoint;
						try {
							if (lineBreakpoint.getLineNumber() == lineNumber) {
								mdtThread.setBreakpoints(new IBreakpoint[] { breakpoint });
								break;
							}
						} catch (final CoreException e) {
						}
					}
				}
			}
		}
		suspended(DebugEvent.BREAKPOINT);
	}
}
