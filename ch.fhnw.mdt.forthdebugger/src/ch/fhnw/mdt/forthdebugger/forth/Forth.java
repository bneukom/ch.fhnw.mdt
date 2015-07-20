package ch.fhnw.mdt.forthdebugger.forth;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;

import ch.fhnw.mdt.forthdebugger.forth.ForthCommandQueue.Command;
import ch.fhnw.mdt.forthdebugger.forth.ForthCommandQueue.TimedOutListener;
import ch.fhnw.mdt.forthdebugger.forth.ForthReader.LineListener;
import ch.fhnw.mdt.forthdebugger.forth.ForthReader.WaitFor;
import ch.fhnw.mdt.forthdebugger.forth.ForthReader.WaitForMatch;
import ch.fhnw.mdt.forthdebugger.forth.ForthReader.WaitForResult;

public class Forth {

	private final ForthCommandQueue commandQueue;
	private final ForthReader reader;
	private Process process;

	public Forth(BufferedWriter processWriter, InputStream input, Process process) {
		this.process = process;
		this.commandQueue = new ForthCommandQueue(processWriter, process);
		this.reader = new ForthReader(input);
		
		commandQueue.start();
		reader.start();
	}

	/**
	 * Shuts down Forth and also closes the underlying Forth {@link Process}.
	 */
	public void shutdown() {
		commandQueue.shutdown();
		reader.shutdown();
		
		process.destroy();
	}

	/**
	 * @param listener
	 * @see ch.fhnw.mdt.forthdebugger.forth.ForthCommandQueue#addShutdownListener(ch.fhnw.mdt.forthdebugger.forth.ForthCommandQueue.TimedOutListener)
	 */
	public void addShutdownListener(TimedOutListener listener) {
		commandQueue.addShutdownListener(listener);
	}

	/**
	 * @param command
	 * @see ch.fhnw.mdt.forthdebugger.forth.ForthCommandQueue#sendCommand(java.lang.String)
	 */
	public void sendCommand(String command) {
		commandQueue.sendCommand(command);
	}

	/**
	 * @param command
	 * @param waitFor
	 * @see ch.fhnw.mdt.forthdebugger.forth.ForthCommandQueue#sendCommandAwaitResult(java.lang.String,
	 *      ch.fhnw.mdt.forthdebugger.forth.ForthReader.WaitFor)
	 */
	public void sendCommandAwaitResult(String command, WaitFor waitFor) {
		commandQueue.sendCommandAwaitResult(command, waitFor);
	}

	/**
	 * @param command
	 * @see ch.fhnw.mdt.forthdebugger.forth.ForthCommandQueue#sendCommand(int)
	 */
	public void sendCommand(int command) {
		commandQueue.sendCommand(command);
	}

	/**
	 * @param command
	 * @param waitFor
	 * @see ch.fhnw.mdt.forthdebugger.forth.ForthCommandQueue#sendCommandAwaitResult(int,
	 *      ch.fhnw.mdt.forthdebugger.forth.ForthReader.WaitFor)
	 */
	public void sendCommandAwaitResult(int command, WaitFor waitFor) {
		commandQueue.sendCommandAwaitResult(command, waitFor);
	}

	/**
	 * @param command
	 * @see ch.fhnw.mdt.forthdebugger.forth.ForthCommandQueue#sendCommand(ch.fhnw.mdt.forthdebugger.forth.ForthCommandQueue.Command)
	 */
	public void sendCommand(Command command) {
		commandQueue.sendCommand(command);
	}

	/**
	 * 
	 * @see ch.fhnw.mdt.forthdebugger.forth.ForthCommandQueue#awaitCommandCompletion()
	 */
	public void awaitCommandCompletion() {
		commandQueue.awaitCommandCompletion();
	}

	/**
	 * @return
	 * @see ch.fhnw.mdt.forthdebugger.forth.ForthReader#getNumberOfReadLines()
	 */
	public int getNumberOfReadLines() {
		return reader.getNumberOfReadLines();
	}

	/**
	 * @param index
	 * @return
	 * @see ch.fhnw.mdt.forthdebugger.forth.ForthReader#getLineAt(int)
	 */
	public String getLineAt(int index) {
		return reader.getLineAt(index);
	}

	/**
	 * @return
	 * @see ch.fhnw.mdt.forthdebugger.forth.ForthReader#getLastLine()
	 */
	public String getLastLine() {
		return reader.getLastLine();
	}

	/**
	 * @return
	 * @see ch.fhnw.mdt.forthdebugger.forth.ForthReader#getCurrentLine()
	 */
	public String getCurrentLine() {
		return reader.getCurrentLine();
	}

	/**
	 * @param out
	 * @see ch.fhnw.mdt.forthdebugger.forth.ForthReader#forwardOutput(java.io.OutputStream)
	 */
	public void forwardOutput(OutputStream out) {
		reader.forwardOutput(out);
	}

	/**
	 * @param lineListener
	 * @see ch.fhnw.mdt.forthdebugger.forth.ForthReader#addLineListener(ch.fhnw.mdt.forthdebugger.forth.ForthReader.LineListener)
	 */
	public void addLineListener(LineListener lineListener) {
		reader.addLineListener(lineListener);
	}

	/**
	 * 
	 * @see ch.fhnw.mdt.forthdebugger.forth.ForthReader#awaitReadCompletion()
	 */
	public void awaitReadCompletion() {
		reader.awaitReadCompletion();
	}

	/**
	 * @param result
	 * @return
	 * @see ch.fhnw.mdt.forthdebugger.forth.ForthReader#waitForResultLater(java.lang.String)
	 */
	public WaitForResult waitForResultLater(String result) {
		return reader.waitForResultLater(result);
	}

	/**
	 * @param regex
	 * @return
	 * @see ch.fhnw.mdt.forthdebugger.forth.ForthReader#waitForMatchLater(java.lang.String)
	 */
	public WaitForMatch waitForMatchLater(String regex) {
		return reader.waitForMatchLater(regex);
	}

}
