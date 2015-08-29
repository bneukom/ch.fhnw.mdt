package ch.fhnw.mdt.forthdebugger.debugmodel;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

import ch.fhnw.mdt.forthdebugger.communication.ProcessCommunicator;
import ch.fhnw.mdt.forthdebugger.communication.ProcessCommunicator.CommandTimeOutException;
import ch.fhnw.mdt.forthdebugger.communication.ProcessCommunicator.WaitForMatch;
import ch.fhnw.mdt.forthdebugger.debugmodel.extensions.IAfterExtension;
import ch.fhnw.mdt.forthdebugger.debugmodel.extensions.IJumpExtension;
import ch.fhnw.mdt.forthdebugger.debugmodel.extensions.IKillProcessExtension;

/**
 * A forth thread. Forth Environment is single threaded.
 */
public class ForthThread extends ForthDebugElement implements IThread, IJumpExtension, IAfterExtension, IKillProcessExtension {

	private static final String FORTH_FILE_EXTENSION = ".fs";
	private static final String DISASSEMBLED_PREFIX = "disassembled_";
	private IBreakpoint[] breakpoints;
	private final IFile forthFile;

	// forth communication
	private final ProcessCommunicator processCommunicator;

	// debugger state
	private boolean isStepping = false;
	private volatile String currentAddress;
	private volatile String currentFunction;
	private final LinkedList<ForthStackFrame> stackFrames = new LinkedList<ForthStackFrame>();

	private final LineMapping lineMapping;
	private final Pattern literalPattern = Pattern.compile("([0-9a-fA-F]+) ([0-9a-fA-F]+)");
	private boolean exitFunction;

	private List<String> disassembledFunctions = new ArrayList<>();
	private List<String> initialFunctions = new ArrayList<>();

	/**
	 * Constructs a new thread for the given target
	 * 
	 * @param target
	 * @param reader
	 * @param forthCommandQueue
	 * @param forthSource
	 */
	public ForthThread(final ForthDebugTarget target, final IFile forthFile, final List<String> forthSource, final ProcessCommunicator processCommunicator) {
		super(target);
		this.forthFile = forthFile;
		this.processCommunicator = processCommunicator;

		this.lineMapping = new LineMapping();

		// initial forth file disassemble
		final List<String> functionNames = getForthFunctions(forthSource);

		this.initialFunctions.addAll(functionNames);
		disassemble(functionNames, createDissasemblyFileName());

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
			resultFrames[0] = createStackFrame(0);

			int resultIndex = 1;
			for (final IStackFrame frame : stackFrames) {
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
		final IStackFrame[] frames = getStackFrames();
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
	 * Sets the breakpoints this thread is suspended at, or <code>null</code> if
	 * none.
	 * 
	 * @param breakpoints
	 *            the breakpoints this thread is suspended at, or
	 *            <code>null</code> if none
	 */
	protected void setBreakpoints(final IBreakpoint[] breakpoints) {
		this.breakpoints = breakpoints;
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
	 * @see org.eclipse.debug.core.model.ISuspendResume#canResume()
	 */
	@Override
	public boolean canResume() {
		return getDebugTarget().canResume();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#resume()
	 */
	@Override
	public void resume() throws DebugException {
		if (isSuspended()) {
			try {
				processCommunicator.sendCommand("end-trace" + ProcessCommunicator.NL);
			} catch (CommandTimeOutException e) {
				abort("timeout", e);
			}
		}
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
	 * @see org.eclipse.debug.core.model.ISuspendResume#canSuspend()
	 */
	@Override
	public boolean canSuspend() {
		return false;
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
	 * @see
	 * ch.fhnw.mdt.forthdebugger.debugmodel.extensions.IJumpExtension#canJump()
	 */
	@Override
	public boolean canJump() throws DebugException {
		return isSuspended();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.fhnw.mdt.forthdebugger.debugmodel.extensions.IAfterExtension#canAfter(
	 * )
	 */
	@Override
	public boolean canAfter() throws DebugException {
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
		try {
			processCommunicator.sendCommand("nest" + ProcessCommunicator.NL);
		} catch (CommandTimeOutException e) {
			abort("timeout", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IStep#stepOver()
	 */
	@Override
	public void stepOver() throws DebugException {
		try {
			processCommunicator.sendCommand(ProcessCommunicator.CR);
		} catch (CommandTimeOutException e) {
			abort("timeout", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IStep#stepOver()
	 */
	@Override
	public void jump() throws DebugException {
		try {
			processCommunicator.sendCommand("jump" + ProcessCommunicator.NL);
		} catch (CommandTimeOutException e) {
			abort("timeout", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.fhnw.mdt.forthdebugger.debugmodel.extensions.IAfterExtension#after()
	 */
	@Override
	public void after() throws DebugException {
		try {
			processCommunicator.sendCommand("after" + ProcessCommunicator.NL);
		} catch (CommandTimeOutException e) {
			abort("timeout", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.fhnw.mdt.forthdebugger.debugmodel.extensions.IKillProcessExtension#
	 * kill()
	 */
	@Override
	public void kill() throws DebugException {
		target.kill();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.fhnw.mdt.forthdebugger.debugmodel.extensions.IKillProcessExtension#
	 * canKill()
	 */
	@Override
	public boolean canKill() throws DebugException {
		return target.canKill();
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
	public void functionEnter(final String function) {
		// save old stack frame
		if (currentFunction != null && currentAddress != null) {
			stackFrames.add(createStackFrame(stackFrames.size() + 1));
		}

		// if the function has not been disassembled, disassemble it now
		if (!disassembledFunctions.contains(function)) {
			disassemble(Arrays.asList(function), DISASSEMBLED_PREFIX + function + FORTH_FILE_EXTENSION);
		}

		// set new stack frame
		currentFunction = function;
		currentAddress = null;
	}

	/**
	 * Notifies the thread of a step to the given address.
	 * 
	 * @param address
	 */
	public void stepped(String address) {
		// exit the previous stack frame
		if (exitFunction && stackFrames.size() > 0) {
			final ForthStackFrame previousFrame = stackFrames.pop();
			currentFunction = previousFrame.getFunctionName();
			currentAddress = previousFrame.getCurrentAddress();

			exitFunction = false;
		}

		// update the current address
		if (!address.equals(currentAddress)) {
			isStepping = true;

			currentAddress = address;
		}
	}

	/**
	 * Notifies the thread that the program has resumed and is not debugging
	 * anymore.
	 */
	public void resumed() {
		isStepping = false;
		currentAddress = null;
		currentFunction = null;
		breakpoints = null;
		exitFunction = false;

		stackFrames.clear();
	}

	/**
	 * Notifies this thread that the debugger has exited the current function.
	 */
	public void functionExit() {
		exitFunction = true;
	}

	/**
	 * Returns whether this thread has the given function loaded.
	 * 
	 * @param function
	 */
	public boolean hasFunctionLoaded(String function) {
		return lineMapping.getFunctions().contains(function);
	}

	/**
	 * Returns the current line number or -1 if the {@link ForthThread} is not
	 * active.
	 * 
	 * @return
	 */
	public int getCurrentLineNumber() {
		if (currentFunction == null || currentAddress == null) {
			return -1;
		}
		return lineMapping.getLineNumber(currentFunction, currentAddress);
	}

	/**
	 * Returns the start line number of the currently active function or -1 if
	 * the {@link ForthThread} is not active.
	 * 
	 * @return
	 */
	public int getCurrentFunctionStartLine() {
		if (currentFunction == null || currentAddress == null) {
			return -1;
		}

		return lineMapping.getFunctionStart(currentFunction);
	}

	/**
	 * Disassembles the given functions the resulting code is stored in the
	 * debug folder of the project into the given filename.
	 * 
	 * @param functions
	 * @param fileName
	 */
	private void disassemble(final List<String> functions, String fileName) {
		final Pattern disasemblerLinePattern = Pattern.compile("([A-Fa-f0-9]{8}): ([A-Fa-f0-9 ]{8}) ?(.*)");

		final List<String> disassembledSource = new ArrayList<>();
		int lineNumber = 1;

		for (final String functionName : functions) {
			disassembledSource.add(": " + functionName);
			lineNumber++;

			lineMapping.mapFunction(functionName, lineNumber);
			disassembledFunctions.add(functionName);

			final WaitForMatch waitForMatchLater = processCommunicator
					.newAwaitMatch("([A-Fa-f0-9]{8}): ([A-Fa-f0-9 ]{8}) ?(([A-Fa-f0-9]+ [A-Fa-f0-9]+)|( [^\\s]+[A-Fa-f0-9 ]+ (call))|([^\\s]+))");
			try {
				processCommunicator.sendCommandAwaitResult("show " + functionName + ProcessCommunicator.NL, waitForMatchLater);
			} catch (CommandTimeOutException e) {
				return;
			}
			processCommunicator.awaitReadCompletion();

			String currentLine = processCommunicator.getCurrentLine();

			lineRead(disasemblerLinePattern, disassembledSource, functionName, currentLine, lineNumber++);

			// one based line numbering
			while (!currentLine.contains("exit")) {
				processCommunicator.awaitReadCompletion();
				try {
					processCommunicator.sendCommandAwaitResult(ProcessCommunicator.ANY, processCommunicator.newAwaitResult(ProcessCommunicator.NL));
				} catch (CommandTimeOutException e) {
					return;
				}
				processCommunicator.awaitReadCompletion();

				currentLine = processCommunicator.getCurrentLine();

				lineRead(disasemblerLinePattern, disassembledSource, functionName, currentLine, lineNumber++);
			}

			try {
				processCommunicator.sendCommand(ProcessCommunicator.CR);
			} catch (CommandTimeOutException e) {
				return;
			}

			disassembledSource.add(";");
			lineNumber++;

		}

		final IPath debugFolderPath = forthFile.getParent().getFullPath().append("debugger");
		final IPath debugFile = debugFolderPath.append(fileName);

		final IFolder debugFolder = ResourcesPlugin.getWorkspace().getRoot().getFolder(debugFolderPath);
		final IProgressMonitor monitor = new NullProgressMonitor();

		// create debug folder if it does not exist
		if (!debugFolder.exists()) {
			try {
				debugFolder.create(true, true, monitor);
			} catch (final CoreException e) {
				e.printStackTrace();
			}
		}

		// create the file with the disassembled function
		final String debugFileContent = disassembledSource.stream().reduce("", (a, b) -> a + b + System.lineSeparator());
		final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(debugFile);
		try {
			// delete old file
			if (file.exists()) {
				file.delete(true, false, monitor);
			}
			file.create(new ByteArrayInputStream(debugFileContent.getBytes(StandardCharsets.UTF_8)), true, monitor);
		} catch (final CoreException e) {
			e.printStackTrace();
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
	private void lineRead(final Pattern disasemblerLinePattern, final List<String> disassembledFunction, final String function, final String currentLine, final int lineNumber) {
		final Matcher matcher = disasemblerLinePattern.matcher(currentLine);
		matcher.find();

		final String address = matcher.group(1);
		final String group = matcher.group(3);

		final Matcher literalMatcher = literalPattern.matcher(group.trim());
		literalMatcher.find();

		// the debugger returns the same literal twice but we only need one
		if (literalMatcher.matches()) {
			disassembledFunction.add(literalMatcher.group(1));
		} else {
			disassembledFunction.add(group);
		}

		lineMapping.mapAddress(function, address, lineNumber);
	}

	/**
	 * Returns all Forth function names of the given source code {@link List}.
	 * 
	 * @param forthSource
	 * @return
	 */
	private static List<String> getForthFunctions(final List<String> forthSource) {
		final List<String> forthFunctions = new ArrayList<String>();

		for (int lineIndex = 0; lineIndex < forthSource.size(); ++lineIndex) {
			final String line = forthSource.get(lineIndex);

			if (line.startsWith(":")) {
				final String functionName = line.replaceAll(":\\s+", "");
				forthFunctions.add(functionName);
			}
		}

		return forthFunctions;
	}

	/**
	 * Creates a new {@link ForthStackFrame} with the given id.
	 * 
	 * @param id
	 * @return
	 */
	private ForthStackFrame createStackFrame(int id) {
		final String sourceFileName;

		// if the function is from the original source file, set the source file
		// to the original disassembly file
		// otherwise it has been disassembled on the fly and is in an own file
		if (initialFunctions.contains(currentFunction)) {
			sourceFileName = createDissasemblyFileName();
		} else {
			sourceFileName = DISASSEMBLED_PREFIX + currentFunction + FORTH_FILE_EXTENSION;
		}

		return new ForthStackFrame(this, currentFunction, sourceFileName, lineMapping.getLineNumber(currentFunction, currentAddress), currentAddress, id);
	}

	/**
	 * Creates the name used for the disassembly file.
	 */
	private String createDissasemblyFileName() {
		final String sourceFile = forthFile.getName().substring(0, forthFile.getName().length() - 1 - forthFile.getFileExtension().length());

		return DISASSEMBLED_PREFIX + sourceFile + "." + forthFile.getFileExtension();
	}

	/**
	 * Maps forth addresses to their line numbers.
	 *
	 */
	private static class LineMapping {

		private final Map<String, Map<String, Integer>> functionLineMap = new HashMap<String, Map<String, Integer>>();
		private final Map<String, Integer> functionMap = new HashMap<>();

		/**
		 * Maps the given address of the given function to the given line number
		 * 
		 * @param function
		 * @param address
		 * @param lineNumber
		 */
		public void mapAddress(final String function, final String address, final int lineNumber) {
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
		public int getLineNumber(final String currentFunction, final String currentAddress) {
			return functionLineMap.get(currentFunction).get(currentAddress);
		}

		/**
		 * Returns all functions which have a line numbers associated
		 * 
		 * @return
		 */
		public Set<String> getFunctions() {
			return functionLineMap.keySet();
		}

		/**
		 * Maps the given function to the given start address.
		 * 
		 * @param function
		 * @param lineNumber
		 */
		public void mapFunction(String function, int lineNumber) {
			functionMap.put(function, lineNumber);
		}

		/**
		 * Returns the start line number of the given function
		 * 
		 * @param function
		 * @param address
		 * @return
		 */
		public int getFunctionStart(String function) {
			return functionMap.get(function);
		}
	}

}
