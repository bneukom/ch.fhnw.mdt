package ch.fhnw.mdt.forthdebugger.debugmodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IMemoryBlockExtension;
import org.eclipse.debug.core.model.IMemoryBlockRetrievalExtension;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IValue;

import ch.fhnw.mdt.forthdebugger.communication.ProcessCommunicator;
import ch.fhnw.mdt.forthdebugger.debugmodel.extensions.IKillProcessExtension;

/**
 * Forth Debug Target.
 */
public class ForthDebugTarget extends ForthDebugElement implements IDebugTarget, IKillProcessExtension {

	// associated system process
	private final IProcess process;

	// containing launch object
	private final ILaunch launch;

	// forth file name
	private final IFile forthFile;

	// suspend state
	private boolean suspended = false;

	// process communication
	private final ProcessCommunicator processCommunicator;
	private DebugStreamListener debugStreamListener;

	private transient boolean ignoreInput;

	// threads
	private final ForthThread forthThread;
	private final IThread[] threads;
	private List<IValue> dataStack = new ArrayList<IValue>();

	// constants
	private static final String NL = "\n";

	/**
	 * Constructs a new debug target in the given launch for the associated Forth Process.
	 * 
	 * @param forthFile
	 *            the original source file
	 * @param forthSource
	 *            the original forth source code
	 * @param launch
	 *            the associated launch
	 * @param process
	 *            the forth process
	 * @param processCommunicator
	 *            the communicator used to communicate with the process
	 * @throws CoreException
	 */
	public ForthDebugTarget(final IFile forthFile, final List<String> forthSource, final ILaunch launch, final IProcess process, final ProcessCommunicator processCommunicator)
			throws CoreException {
		super(null);
		this.forthFile = forthFile;
		this.launch = launch;
		this.process = process;
		this.processCommunicator = processCommunicator;
		this.target = this;

		this.forthThread = new ForthThread(this, forthFile, forthSource, processCommunicator);
		this.threads = new IThread[] { forthThread };

		try {
			final PipedInputStream in = new PipedInputStream();
			final PipedOutputStream out = new PipedOutputStream(in);

			this.debugStreamListener = new DebugStreamListener(in);
			this.debugStreamListener.start();

			this.processCommunicator.forwardOutput(out);
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
		return forthFile.getName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IDebugTarget#supportsBreakpoint(org.eclipse .debug.core.model.IBreakpoint)
	 */
	@Override
	public boolean supportsBreakpoint(final IBreakpoint breakpoint) {
		return breakpoint.getModelIdentifier().equals(IForthConstants.ID_MDT_DEBUG_MODEL);
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
		try {
			processCommunicator.awaitCommandCompletion();

			// graceful termination
			processCommunicator.sendCommand("bye" + ProcessCommunicator.NL); // exit debugger
			processCommunicator.sendCommand("bye" + ProcessCommunicator.NL); // exit forth
			processCommunicator.sendCommand("exit" + ProcessCommunicator.NL); // exit shell
		} catch (InterruptedException e) {
			// in case of an interrupt kill the process
			kill();
		}
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.fhnw.mdt.forthdebugger.debugmodel.extensions.IKillProcessExtension#kill()
	 */
	@Override
	public void kill() throws DebugException {
		process.terminate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.fhnw.mdt.forthdebugger.debugmodel.extensions.IKillProcessExtension#canKill()
	 */
	@Override
	public boolean canKill() throws DebugException {
		return !getProcess().isTerminated();
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
		forthThread.resume();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#canSuspend()
	 */
	@Override
	public boolean canSuspend() {
		return false;
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
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IMemoryBlockRetrieval#getMemoryBlock(long, long)
	 */
	@Override
	public IMemoryBlock getMemoryBlock(final long startAddress, final long length) throws DebugException {
		return new ForthMemoryBlock(target, startAddress, length, processCommunicator);
	}

	/**
	 * Sets whether the internal debug stream listener should ignore its input.
	 * 
	 * @param ignore
	 */
	void setIgnoreInput(boolean ignore) {
		this.ignoreInput = ignore;
	}

	/**
	 * Returns the values on the data stack (top down)
	 * 
	 * @return the values on the data stack (top down)
	 */
	public List<IValue> getDataStack() throws DebugException {
		return dataStack;
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
	 * Adds a breakpoint for the given function.
	 * 
	 * @param function
	 * @throws DebugException
	 */
	protected void addFunctionBreakpoint(final String function) throws DebugException {
		try {
			processCommunicator.sendCommand("debug _" + function + NL);
		} catch (InterruptedException e) {
			abort("timeout", e);
		}
	}

	/**
	 * Adds a breakpoint for the given function.
	 * 
	 * @param function
	 * @throws DebugException
	 */
	protected void removeFunctionBreakpoint(final String function) throws DebugException {
		try {
			processCommunicator.sendCommand("unbug _" + function + NL);
		} catch (InterruptedException e) {
			abort("timeout", e);
		}
	}

	/**
	 * Listens to the forth process output and reports appropriate events.
	 */
	private class DebugStreamListener extends Thread {

		private final InputStream stream;
		private final Pattern debugFunctionPattern = Pattern.compile("([^\\s]+)(\\s+)(-{15})");

		private final Pattern stepPattern = Pattern
				.compile("([A-Fa-f0-9]{8}): ([A-Fa-f0-9 ]{8}) ?(([^\\s]+ [^\\s]+)|( [^\\s]+[A-Fa-f0-9 ]+ (call))|([^\\s]+))((-?[A-Fa-f0-9 ])*) (>+)");

		public DebugStreamListener(InputStream stream) {
			this.stream = stream;
		}

		@Override
		public void run() {
			StringBuilder line = new StringBuilder();

			boolean fired = false;
			while (true) {
				try {
					final char read = (char) stream.read();

					// ignore
					if (ignoreInput)
						continue;

					line.append(read);

					if (!fired) {
						fired = fireEvents(line.toString());
					}

					if (line.toString().endsWith(NL)) {
						line = new StringBuilder();
						fired = false;
					}

				} catch (IOException e) {
					return;
				}
			}
		}

		// TODO the first line won't contain the uCore> start...
		/**
		 * Fires event based on the output of the forth debugger
		 * 
		 * @param current
		 */
		private boolean fireEvents(String current) {
			final Matcher debugFunctionMatcher = debugFunctionPattern.matcher(current);
			final Matcher stepMatcher = stepPattern.matcher(current);

			if (debugFunctionMatcher.matches()) {
				// breakpoint hit
				functionBegin(debugFunctionMatcher.group(1));
				return true;
			} else if (stepMatcher.matches()) {
				// update stack
				final String stack = stepMatcher.group(8);
				final String[] stackValues = stack.trim().split(" ");
				dataStack = Arrays.stream(stackValues).map(s -> new ForthValue(target, s)).collect(Collectors.toList());
				Collections.reverse(dataStack);

				// step
				singleStep(stepMatcher.group(1));

				// notification of function exit
				if ("exit".equals(stepMatcher.group(3))) {
					functionExit();
				}
				return true;
			} else if (current.endsWith("uCore>")) {
				functionEnd();
			} else if (current.endsWith("bye")) {
				terminated();
			}

			return false;
		}

		/**
		 * Returns whether this line is a function call. A function call has the following pattern
		 * 
		 * <pre>
		 * uCore> _function ok
		 * </pre>
		 * 
		 * where _function can be replaced with any function loaded by the debugger. (Any function from the running C-File).
		 * 
		 * @param current
		 * @return
		 */
		private boolean isFunctionCall(String current) {
			// note that we can not just use a simple Regex here, because we need to check if the function really is a loaded function otherwise
			// a command like "uCore> 3 ok" would pass the Regex too.
			if (current.startsWith("uCore> ") && current.endsWith("ok")) {
				final String function = current.substring(7, current.length() - 3);
				return forthThread.hasFunctionLoaded(function);
			}
			return false;
		}

		/**
		 * Notification that the function has ended.
		 */
		private void functionEnd() {
			forthThread.resumed();
			resumed(DebugEvent.CLIENT_REQUEST);
		}

		/**
		 * Notification a breakpoint was encountered. Determine which breakpoint was hit and fire a suspend event.
		 * 
		 * @param function
		 *            the function
		 */
		private void functionBegin(final String function) {
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

			forthThread.functionEnter(function);
			// TODO if this is here the forth memory block will get loaded earlier than expected (before the single step event).
			// suspended(DebugEvent.BREAKPOINT);
		}

		/**
		 * Notification that the debugger has stepped.
		 *
		 * @param address
		 */
		private void singleStep(String address) {
			forthThread.stepped(address);
			suspended(DebugEvent.STEP_END);
		}

		/**
		 * Notification that the debugger has reached the end of a function and is ready to resume normally.
		 * 
		 * @param address
		 */
		private void functionExit() {
			forthThread.functionExit();
		}

		/**
		 * Called when this debug target terminates.
		 */
		private void terminated() {
			suspended = false;
			DebugPlugin.getDefault().getBreakpointManager().removeBreakpointListener(ForthDebugTarget.this);
			fireTerminateEvent();
		}
	}

}
