package ch.fhnw.mdt.forthdebugger.communication;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import ch.fhnw.mdt.forthdebugger.communication.ForthCommandQueue.Command;
import ch.fhnw.mdt.forthdebugger.communication.ForthCommandQueue.TimedOutListener;
import ch.fhnw.mdt.forthdebugger.communication.ForthReader.LineListener;
import ch.fhnw.mdt.forthdebugger.communication.ForthReader.WaitFor;
import ch.fhnw.mdt.forthdebugger.communication.ForthReader.WaitForMatch;
import ch.fhnw.mdt.forthdebugger.communication.ForthReader.WaitForResult;

// TODO somehow merge all three classes so we dont have to forward all methods
public class ForthCommunicator {

	private final ForthCommandQueue commandQueue;
	private final ForthReader reader;
	private Process process;

	public ForthCommunicator(BufferedWriter processWriter, InputStream input, Process process) {
		this.process = process;
		this.commandQueue = new ForthCommandQueue(processWriter, process);
		this.reader = new ForthReader(input);

		commandQueue.start();
		reader.start();

		// TODO does this really work?
		commandQueue.addTimeOutListener(() -> {
			shutdown();
		});
	}

	/**
	 * Shuts down Forth and also closes the underlying Forth {@link Process}.
	 */
	public void shutdown() {

		// TODO closing lies hand in hand, probably make these classes static
		// inner classes.
		commandQueue.shutdown();
		reader.shutdown();

		process.destroy();
	}

	/**
	 * @param listener
	 * @see ch.fhnw.mdt.forthdebugger.communication.ForthCommandQueue#addTimeOutListener(ch.fhnw.mdt.forthdebugger.communication.ForthCommandQueue.TimedOutListener)
	 */
	public void addTimeOutListener(TimedOutListener listener) {
		commandQueue.addTimeOutListener(listener);
	}

	/**
	 * @param command
	 * @see ch.fhnw.mdt.forthdebugger.communication.ForthCommandQueue#sendCommand(java.lang.String)
	 */
	public void sendCommand(String command) {
		commandQueue.sendCommand(command);
	}

	/**
	 * @param command
	 * @param waitFor
	 * @see ch.fhnw.mdt.forthdebugger.communication.ForthCommandQueue#sendCommandAwaitResult(java.lang.String,
	 *      ch.fhnw.mdt.forthdebugger.communication.ForthReader.WaitFor)
	 */
	public void sendCommandAwaitResult(String command, WaitFor waitFor) {
		commandQueue.sendCommandAwaitResult(command, waitFor);
	}

	/**
	 * @param command
	 * @see ch.fhnw.mdt.forthdebugger.communication.ForthCommandQueue#sendCommand(int)
	 */
	public void sendCommand(int command) {
		commandQueue.sendCommand(command);
	}

	/**
	 * @param command
	 * @param waitFor
	 * @see ch.fhnw.mdt.forthdebugger.communication.ForthCommandQueue#sendCommandAwaitResult(int,
	 *      ch.fhnw.mdt.forthdebugger.communication.ForthReader.WaitFor)
	 */
	public void sendCommandAwaitResult(int command, WaitFor waitFor) {
		commandQueue.sendCommandAwaitResult(command, waitFor);
	}

	/**
	 * @param command
	 * @see ch.fhnw.mdt.forthdebugger.communication.ForthCommandQueue#sendCommand(ch.fhnw.mdt.forthdebugger.communication.ForthCommandQueue.Command)
	 */
	public void sendCommand(Command command) {
		commandQueue.sendCommand(command);
	}

	/**
	 * 
	 * @see ch.fhnw.mdt.forthdebugger.communication.ForthCommandQueue#awaitCommandCompletion()
	 */
	public void awaitCommandCompletion() {
		commandQueue.awaitCommandCompletion();
	}

	/**
	 * @return
	 * @see ch.fhnw.mdt.forthdebugger.communication.ForthReader#getNumberOfReadLines()
	 */
	public int getNumberOfReadLines() {
		return reader.getNumberOfReadLines();
	}

	/**
	 * @param index
	 * @return
	 * @see ch.fhnw.mdt.forthdebugger.communication.ForthReader#getLineAt(int)
	 */
	public String getLineAt(int index) {
		return reader.getLineAt(index);
	}

	/**
	 * @return
	 * @see ch.fhnw.mdt.forthdebugger.communication.ForthReader#getLastLine()
	 */
	public String getLastLine() {
		return reader.getLastLine();
	}

	/**
	 * @return
	 * @see ch.fhnw.mdt.forthdebugger.communication.ForthReader#getCurrentLine()
	 */
	public String getCurrentLine() {
		return reader.getCurrentLine();
	}

	/**
	 * @param out
	 * @see ch.fhnw.mdt.forthdebugger.communication.ForthReader#forwardOutput(java.io.OutputStream)
	 */
	public void forwardOutput(OutputStream out) {
		reader.forwardOutput(out);
	}

	/**
	 * @param lineListener
	 * @see ch.fhnw.mdt.forthdebugger.communication.ForthReader#addLineListener(ch.fhnw.mdt.forthdebugger.communication.ForthReader.LineListener)
	 */
	public void addLineListener(LineListener lineListener) {
		reader.addLineListener(lineListener);
	}

	/**
	 * @return
	 * @see ch.fhnw.mdt.forthdebugger.communication.ForthReader#getReadLines()
	 */
	public List<String> getReadLines() {
		return reader.getReadLines();
	}

	/**
	 * 
	 * @see ch.fhnw.mdt.forthdebugger.communication.ForthReader#awaitReadCompletion()
	 */
	public void awaitReadCompletion() {
		reader.awaitReadCompletion();
	}

	/**
	 * @param result
	 * @return
	 * @see ch.fhnw.mdt.forthdebugger.communication.ForthReader#waitForResultLater(java.lang.String)
	 */
	public WaitForResult waitForResultLater(String result) {
		return reader.waitForResultLater(result);
	}

	/**
	 * @param regex
	 * @return
	 * @see ch.fhnw.mdt.forthdebugger.communication.ForthReader#waitForMatchLater(java.lang.String)
	 */
	public WaitForMatch waitForMatchLater(String regex) {
		return reader.waitForMatchLater(regex);
	}

}
