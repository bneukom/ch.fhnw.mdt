package ch.fhnw.mdt.forthdebugger.debugmodel;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;

import ch.fhnw.mdt.forthdebugger.ForthCommunicator;
import ch.fhnw.mdt.forthdebugger.ForthReader;
import ch.fhnw.mdt.forthdebugger.ForthReader.WaitFor;

/**
 * A forth thread. Forth Environment is single threaded.
 */
public class ForthThread extends ForthDebugElement implements IThread {

	private IBreakpoint[] breakpoints;
	private IFile forthFile;

	// forth communication
	private ForthCommunicator forthCommunicator;
	private ForthReader reader;

	// debugger state
	private boolean isStepping = false;
	private String currentAddress;
	private String currentFunction;
	private LinkedList<ForthStackFrame> stackFrames = new LinkedList<ForthStackFrame>();

	private LineMapping addressMapping;

	/**
	 * Constructs a new thread for the given target
	 * 
	 * @param target
	 * @param reader
	 * @param forthCommunicator
	 * @param forthSource
	 */
	public ForthThread(ForthDebugTarget target, IFile forthFile, List<String> forthSource, ForthCommunicator forthCommunicator, ForthReader reader) {
		super(target);
		this.forthFile = forthFile;
		this.forthCommunicator = forthCommunicator;
		this.reader = reader;

		this.addressMapping = new LineMapping();

		disassemble(forthSource);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IThread#getStackFrames()
	 */
	@Override
	public IStackFrame[] getStackFrames() throws DebugException {
		if (isSuspended() && isStepping && currentAddress != null && currentFunction != null) {

			final IStackFrame[] resultFrames = new IStackFrame[stackFrames.size() + 1];
			resultFrames[0] = new ForthStackFrame(this, currentFunction, currentFunction + ".fs", addressMapping.getLineNumber(currentFunction, currentAddress), currentAddress, 0);

			int resultIndex = 1;
			for (IStackFrame frame : stackFrames) {
				resultFrames[resultIndex++] = frame;
			}

			return resultFrames;
		} else {
			return new IStackFrame[0];
		}
	}
	
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IThread#hasStackFrames()
	 */
	@Override
	public boolean hasStackFrames() throws DebugException {
		return isSuspended();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IThread#getPriority()
	 */
	@Override
	public int getPriority() throws DebugException {
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IThread#getTopStackFrame()
	 */
	@Override
	public IStackFrame getTopStackFrame() throws DebugException {
		IStackFrame[] frames = getStackFrames();
		if (frames.length > 0) {
			return frames[0];
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IThread#getName()
	 */
	@Override
	public String getName() throws DebugException {
		return "Forth Thread";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IThread#getBreakpoints()
	 */
	@Override
	public IBreakpoint[] getBreakpoints() {
		if (breakpoints == null) {
			return new IBreakpoint[0];
		}
		return breakpoints;
	}

	/**
	 * Sets the breakpoints this thread is suspended at, or <code>null</code> if none.
	 * 
	 * @param breakpoints
	 *            the breakpoints this thread is suspended at, or <code>null</code> if none
	 */
	protected void setBreakpoints(IBreakpoint[] breakpoints) {
		this.breakpoints = breakpoints;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#canResume()
	 */
	@Override
	public boolean canResume() {
		return isSuspended();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#canSuspend()
	 */
	@Override
	public boolean canSuspend() {
		return !isSuspended();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#isSuspended()
	 */
	@Override
	public boolean isSuspended() {
		return getDebugTarget().isSuspended();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#resume()
	 */
	@Override
	public void resume() throws DebugException {
		getDebugTarget().resume();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#suspend()
	 */
	@Override
	public void suspend() throws DebugException {
		getDebugTarget().suspend();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IStep#canStepInto()
	 */
	@Override
	public boolean canStepInto() {
		return isSuspended();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IStep#canStepOver()
	 */
	@Override
	public boolean canStepOver() {
		return isSuspended();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IStep#canStepReturn()
	 */
	@Override
	public boolean canStepReturn() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IStep#isStepping()
	 */
	@Override
	public boolean isStepping() {
		return isStepping;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IStep#stepInto()
	 */
	@Override
	public void stepInto() throws DebugException {
		forthCommunicator.sendCommand("nest" + ForthCommunicator.NL);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IStep#stepOver()
	 */
	@Override
	public void stepOver() throws DebugException {
		forthCommunicator.sendCommand(ForthCommunicator.CR);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IStep#stepReturn()
	 */
	@Override
	public void stepReturn() throws DebugException {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.ITerminate#canTerminate()
	 */
	@Override
	public boolean canTerminate() {
		return !isTerminated();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.ITerminate#isTerminated()
	 */
	@Override
	public boolean isTerminated() {
		return getDebugTarget().isTerminated();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.ITerminate#terminate()
	 */
	@Override
	public void terminate() throws DebugException {
		getDebugTarget().terminate();
	}

	/**
	 * Enters the currently executed function.
	 * 
	 * @param function
	 */
	public void functionEnter(String function) {
		// save old stack frame
		if (currentFunction != null && currentAddress != null) {
			stackFrames.add(new ForthStackFrame(this, currentFunction, currentFunction + ".fs", addressMapping.getLineNumber(currentFunction, currentAddress), currentAddress,
					stackFrames.size() + 1));
		}

		// set new stack frame
		currentFunction = function;
		currentAddress = null;
	}

	/**
	 * Notifies this thread that the debugger has exited the current function.
	 */
	public void functionExit() {
		isStepping = false;
		currentAddress = null;

		if (!stackFrames.isEmpty()) {
			final ForthStackFrame previousFrame = stackFrames.pop();
			currentFunction = previousFrame.getFunctionName();
			currentAddress = previousFrame.getCurrentAddress();
		} else {
			breakpoints = null;
		}
	}

	/**
	 * Notifies that the debugger has stepped to the given address.
	 * 
	 * @param address
	 */
	public void stepped(String address) {
		isStepping = true;
		currentAddress = address;
	}

	/**
	 * Creates files with disassembled source code for the debugger.
	 * 
	 * @param forthSource
	 *            the original source file used to read all the function names from
	 */
	private void disassemble(List<String> forthSource) {
		final Map<String, Integer> forthFunctions = getForthFunctions(forthSource);
		
		// TODO better pattern
		final Pattern disasemblerLinePattern = Pattern.compile("([A-Fa-f0-9]{8}): ([A-Fa-f0-9 ]{8}) ?(.*)");

		for (final Entry<String, Integer> function : forthFunctions.entrySet()) {
			// the code for the function starts two lines after the actual function defintion
			final String functionName = function.getKey();
			final List<String> disassembledFunction = new ArrayList<String>();

			forthCommunicator.sendCommandAwaitResult("show " + functionName + ForthCommunicator.NL, reader.waitForResultLater("---------------"));
			reader.awaitReadCompletion();

			String currentLine = reader.getCurrentLine();

			int lineNumber = 1;
			lineRead(disasemblerLinePattern, disassembledFunction, functionName, currentLine, lineNumber++);

			// one based line numbering
			while (!currentLine.contains("exit")) {
				forthCommunicator.sendCommandAwaitResult(ForthCommunicator.ANY, reader.waitForResultLater(ForthCommunicator.NL));
				reader.awaitReadCompletion();

				currentLine = reader.getCurrentLine();

				lineRead(disasemblerLinePattern, disassembledFunction, functionName, currentLine, lineNumber++);
			}

			forthCommunicator.sendCommand(ForthCommunicator.CR);

			final IPath debugFolderPath = forthFile.getParent().getFullPath().append("debugger");
			final IPath debugFile = debugFolderPath.append(functionName).addFileExtension("fs");

			final IFolder debugFolder = ResourcesPlugin.getWorkspace().getRoot().getFolder(debugFolderPath);
			final IProgressMonitor monitor = new NullProgressMonitor();

			// create debug folder if it does not exist
			if (!debugFolder.exists()) {
				try {
					debugFolder.create(true, true, monitor);
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}

			// create the file with the disassembled function
			final String debugFileContent = disassembledFunction.stream().reduce("", (a, b) -> a + b + System.lineSeparator());
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(debugFile);
			try {
				// delete old file
				if (file.exists()) {
					file.delete(true, false, monitor);
				}
				file.create(new ByteArrayInputStream(debugFileContent.getBytes(StandardCharsets.UTF_8)), true, monitor);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Adds a line to the debug output file.
	 * 
	 * @param disasemblerLinePattern
	 * @param disassembledFunction
	 * @param currentLine
	 * @param lineNumber
	 */
	private void lineRead(final Pattern disasemblerLinePattern, final List<String> disassembledFunction, String function, String currentLine, int lineNumber) {
		final Matcher matcher = disasemblerLinePattern.matcher(currentLine);
		matcher.find();

		final String address = matcher.group(1);
		final String word = matcher.group(3);
		disassembledFunction.add(word);

		addressMapping.mapAddress(function, address, lineNumber);

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

	/**
	 * Maps forth addresses to their line numbers.
	 *
	 */
	private static class LineMapping {

		private Map<String, Map<String, Integer>> functionLineMap = new HashMap<String, Map<String, Integer>>();

		/**
		 * Maps the given address of the given function to the given line number
		 * 
		 * @param function
		 * @param address
		 * @param lineNumber
		 */
		public void mapAddress(String function, String address, int lineNumber) {
			functionLineMap.putIfAbsent(function, new HashMap<String, Integer>());
			functionLineMap.get(function).put(address, lineNumber);
		}

		/**
		 * Returns the line number of the given function at the given address.
		 * 
		 * @param currentFunction
		 * @param currentAddress
		 * @return
		 */
		public int getLineNumber(String currentFunction, String currentAddress) {
			return functionLineMap.get(currentFunction).get(currentAddress);
		}
	}
}
