package ch.fhnw.mdt.forthdebugger.communication;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ch.fhnw.mdt.forthdebugger.communication.process.IProcessDectorator;
import ch.fhnw.mdt.forthdebugger.util.Either;

/**
 * Class which is able to communicate via {@link Command}s with a process.
 * The typical use case is sending a command and waiting for its result.
 * 
 * <pre>
 * ProcessCommunicator communicator = new ProccessCommunicator();
 * communicator.sendCommandAwaitResult("foo", communicator.newAwaitResult("bar")); // blocks until the process has returned bar or has timed out.
 * </pre>
 */
public class ProcessCommunicator {

	private final ProcessCommandQueue commandQueue;
	private final ProcessReader reader;

	public static final String OK = "ok";
	public static final String NL = "\n";
	public static final String LINE_SEPERATOR = "\n";
	public static final int CR = 13;
	public static final int ANY = 65;

	private IProcessDectorator process;

	private final List<WaitFor> waitQueue = Collections.synchronizedList(new ArrayList<WaitFor>());

	// input stream availability
	private Lock availableLock = new ReentrantLock();
	private Condition availableCondition = availableLock.newCondition();
	private volatile int available = 0;

	// forward output from the process to all these streams
	private final List<OutputStream> forward = Collections.synchronizedList(new ArrayList<OutputStream>());

	// callback list when a complete line has been read
	private List<LineListener> lineListeners = Collections.synchronizedList(new ArrayList<LineListener>());

	// stores all lines
	private final List<String> readLines = new ArrayList<String>();
	private StringBuffer currentLine = new StringBuffer();

	// called after a command request has timed out
	private final List<CommandTimedOutListener> commandTimedOutListeners = new ArrayList<CommandTimedOutListener>();

	// command queue
	private final BlockingQueue<Command> queue = new LinkedBlockingQueue<Command>();
	private final Lock commandCompletionLock = new ReentrantLock();
	private final Condition commandCompletionCondition;
	private transient boolean commandQueueIsWorking = false;
	private long timeoutTime;

	// shutdown
	private final Lock shutdownLock = new ReentrantLock();
	private final Condition shutdownCondition = shutdownLock.newCondition();
	private transient boolean isShutDown = false;

	public ProcessCommunicator(IProcessDectorator process, long timeoutTime) {
		this.process = process;
		this.commandQueue = new ProcessCommandQueue(new BufferedWriter(new OutputStreamWriter(process.getOutputStream())));
		this.reader = new ProcessReader(process.getInputStream());
		this.commandCompletionCondition = commandCompletionLock.newCondition();
		this.timeoutTime = timeoutTime;
		commandQueue.start();
		reader.start();
	}

	/**
	 * Shuts down the {@link ProcessCommunicator} and also closes the underlying
	 * {@link Process}. Notifies all thread which are waiting for shutdown by
	 * calling {@link #awaitShutdown()}. If the {@link ProcessCommunicator} has
	 * already been shut down this method returns immediately. <br>
	 * <br>
	 * Waiting Threads
	 */
	public void shutdown() {
		if (isShutDown) {
			return;
		}

		// notify shutdown
		try {
			shutdownLock.lock();

			isShutDown = true;

			shutdownCondition.signalAll();
		} finally {
			shutdownLock.unlock();
		}

		// terminate internal threads
		reader.terminate();
		commandQueue.terminate();

		// destory the process
		process.destroy();
	}

	/**
	 * Blocks until the {@link ProcessCommunicator} has shutdown via
	 * {@link #shutdown()}.
	 */
	public void awaitShutdown() {
		try {
			shutdownLock.lock();
			while (!isShutDown) {
				shutdownCondition.awaitUninterruptibly();
			}
		} finally {
			shutdownLock.unlock();
		}

	}

	/**
	 * Sends the given command and immediately returns.
	 * 
	 * @param command
	 * @throws InterruptedException
	 */
	public void sendCommand(final String command) {
		sendCommand(new Command(command, null, null, false));
	}

	/**
	 * Sends the given command and blocks until the process has returned the
	 * result expected by the given {@link WaitFor}.
	 * 
	 * @param command
	 * @param waitFor
	 * @throws InterruptedException
	 */
	public void sendCommandAwaitResult(final String command, final WaitFor waitFor) {
		sendCommand(new Command(command, waitFor, null, true));
	}

	/**
	 * Sends the given command and returns immediately. Calls the
	 * {@link CommandCompleted} callback when the process has returned the
	 * expected result for the given {@link WaitFor}.
	 * 
	 * @param command
	 * @param waitFor
	 * @throws InterruptedException
	 */
	public void sendCommandForResult(final String command, final WaitFor waitFor, CommandCompleted commandCompleted) {
		sendCommand(new Command(command, waitFor, commandCompleted, false));
	}

	/**
	 * Sends the given command and immediately returns.
	 * 
	 * @param command
	 * @throws InterruptedException
	 */
	public void sendCommand(final int command) {
		sendCommand(new Command(command, null, null, false));
	}

	/**
	 * Sends the given command and blocks until the process has returned the
	 * result expected by the given {@link WaitFor}.
	 * 
	 * @param command
	 * @param waitFor
	 * @throws InterruptedException
	 */
	public void sendCommandAwaitResult(final int command, final WaitFor waitFor) {
		sendCommand(new Command(command, waitFor, null, true));
	}

	/**
	 * Sends the given command and returns immediately. Calls the
	 * {@link CommandCompleted} callback when the process has returned the
	 * expected result for the given {@link WaitFor}.
	 * 
	 * @param command
	 * @param waitFor
	 * @throws InterruptedException
	 */
	public void sendCommandForResult(final int command, final WaitFor waitFor, CommandCompleted commandCompleted) {
		sendCommand(new Command(command, waitFor, commandCompleted, false));
	}

	/**
	 * Adds the given {@link CommandTimedOutListener} callback which will get
	 * called when a command has timed out.
	 * 
	 * 
	 * @param listener
	 */
	public void addCommandTimeOutListener(CommandTimedOutListener listener) {
		synchronized (commandTimedOutListeners) {
			commandTimedOutListeners.add(listener);
		}
	}

	/**
	 * Sends the given {@link Command}.
	 * 
	 * @param command
	 */
	private void sendCommand(final Command command) throws CommandTimeOutException {
		if (isShutDown) {
			return;
		}

		try {
			commandCompletionLock.lock();

			commandQueueIsWorking = true;

			queue.put(command);

			// block if necessary
			if (command.blocks) {
				awaitCommandCompletion();

				if (command.hasTimedOut()) {
					throw new CommandTimeOutException();
				}
			}
		} catch (InterruptedException e) {

		} finally {
			commandCompletionLock.unlock();
		}
	}

	/**
	 * Awaits until the command queue has been completed, meaning all commands
	 * have been written and if necessary received their results. Note that this
	 * does not mean that the result of the reader is ready to process unless an appropriate
	 * {@link WaitFor} has been supplied to the command.
	 * 
	 */
	public void awaitCommandCompletion() {
		if (isShutDown) {
			return;
		}

		try {
			commandCompletionLock.lock();

			while (commandQueueIsWorking) {
				commandCompletionCondition.awaitUninterruptibly();
			}
		} finally {
			commandCompletionLock.unlock();
		}
	}

	/**
	 * Returns the number of lines which have been read since this reader has
	 * been started.
	 * 
	 * @return
	 */
	public int getNumberOfReadLines() {
		synchronized (readLines) {
			return readLines.size();
		}
	}

	/**
	 * Returns the line read at the given index.
	 * 
	 * @param index
	 * @return
	 */
	public String getLineAt(final int index) {
		synchronized (readLines) {
			return readLines.get(index);
		}
	}

	/**
	 * Returns the last read line.
	 * 
	 * @return
	 */
	public String getLastLine() {
		synchronized (readLines) {
			return readLines.get(readLines.size() - 1);
		}
	}

	/**
	 * Returns a copy of all read lines.
	 * 
	 * @return
	 */
	public List<String> getReadLines() {
		synchronized (readLines) {
			return Collections.unmodifiableList(readLines);
		}
	}

	/**
	 * Returns the line which is currently being read. This line might not be
	 * complete, so be careful using it.
	 * 
	 * @return
	 */
	public String getCurrentLine() {
		return currentLine.toString();
	}

	/**
	 * Forwards the output from the reader to the given {@link OutputStream}.
	 * Note that caller must make sure the stream gets closed correctly.
	 * 
	 * @param out
	 */
	public void forwardOutput(final OutputStream out) {
		synchronized (forward) {
			forward.add(out);
		}
	}

	/**
	 * Creates a {@link WaitForResult} object which can be used to wait for a
	 * given result from the forth process reader at a later time. Call
	 * {@link WaitFor#await()} to wait.
	 * 
	 * @param result
	 * @return
	 */
	public synchronized WaitForResult newAwaitResult(final String result) {
		final WaitForResult wait = new WaitForResult(result, timeoutTime);

		synchronized (waitQueue) {
			waitQueue.add(wait);
		}

		return wait;
	}

	/**
	 * Creates a {@link WaitForMatch} object which can be used to wait for a
	 * given match from the forth process reader at a later time. Call
	 * {@link WaitFor#await()} to wait.
	 * 
	 * @param result
	 * @return
	 */
	public synchronized WaitForMatch newAwaitMatch(final String regex) {
		final WaitForMatch wait = new WaitForMatch(regex, timeoutTime);

		synchronized (waitQueue) {
			waitQueue.add(wait);
		}

		return wait;
	}

	/**
	 * Adds the given {@link LineListener} callback.
	 * 
	 * @param lineListener
	 */
	public void addLineListener(LineListener lineListener) {
		synchronized (lineListeners) {
			lineListeners.add(lineListener);
		}
	}

	/**
	 * Awaits until the reader has read everything from its current buffer.
	 * Immediately returns if there is nothing to read.
	 */
	public void awaitReadCompletion() {
		if (isShutDown) {
			return;
		}

		try {
			availableLock.lock();
			while (available > 0) {
				try {
					availableCondition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		} finally {
			availableLock.unlock();
		}
	}

	/**
	 * Thread safe communication for a process.
	 */
	private final class ProcessCommandQueue extends Thread {
		private final BufferedWriter processWriter;
		private volatile boolean terminated = false;
		private volatile Command current;

		public ProcessCommandQueue(final BufferedWriter processWriter) {
			this.processWriter = processWriter;
		}

		private void terminate() {
			terminated = true;
			try {
				processWriter.close();
			} catch (IOException e) {
			}

			interrupt();
		}

		@Override
		public void run() {
			while (!terminated) {
				try {
					// get next command or wait if there are none
					current = queue.take();

					try {
						if (current.waitFor != null) {
							writeCommand(current);

							// wait for the result before processing further commands
							current.waitFor.await();

							// after we are finished with waiting apply callback
							if (current.commandCompleted != null) {
								current.commandCompleted.commandCompleted(current.waitFor);
							}
						} else {
							writeCommand(current);
						}

						try {
							commandCompletionLock.lock();

							// signal commandQueue empty
							if (queue.isEmpty()) {
								commandQueueIsWorking = false;
								commandCompletionCondition.signalAll();
							}
						} finally {
							commandCompletionLock.unlock();
						}

					} catch (final IOException e) {
						return;
					}

				} catch (final InterruptedException e) {
					return;
				}
			}
		}

		private void writeCommand(final Command command) throws IOException {
			// write request
			reader.scheduleTimeout();

			command.request.apply(s -> {
				try {
					processWriter.write(s);
				} catch (final IOException e) {
					e.printStackTrace();
				}
			} , i -> {
				try {
					processWriter.write(i);
				} catch (final IOException e) {
					e.printStackTrace();
				}
			});
			processWriter.flush();

		}

	}

	/**
	 * Thread which reads from the Forth process.
	 *
	 */
	private final class ProcessReader extends Thread {

		private final InputStream input;

		private volatile boolean terminated;

		private volatile Timer timeoutTimer = new Timer();
		private volatile TimerTask currentTask;

		public ProcessReader(final InputStream input) {
			this.input = input;
		}

		/**
		 * Terminates the reader and closes its associated input stream.
		 */
		private void terminate() {
			terminated = true;
			try {
				input.close();
			} catch (IOException e) {
			}
		}

		/**
		 * Starts the timeout timer which will get canceled once the process has read its next character.
		 */
		private void scheduleTimeout() {
			synchronized (timeoutTimer) {
				if (currentTask != null) {
					currentTask.cancel();
				}
				currentTask = new TimeoutTask();
				timeoutTimer.schedule(currentTask, timeoutTime);
			}
		}

		@Override
		public void run() {
			while (!terminated) {

				try {
					// read next char
					final int nextCharacter = input.read();

					synchronized (timeoutTimer) {
						if (currentTask != null) {
							currentTask.cancel();
						}
					}

					// shutdown command queue if the end of the stream has been
					// reached
					if (nextCharacter == -1) {
						shutdown();
						return;
					}

					// abort in case is terminate has been called while a read
					// was blocked or the end of the stream has been reached
					if (terminated) {
						return;
					}

					// notify everyone who was waiting for the available count to hit zero
					try {
						availableLock.lock();

						available = input.available();

						if (available == 0) {
							availableCondition.signalAll();
						}
					} finally {
						availableLock.unlock();
					}

					// remember read lines and current lines
					currentLine.append((char) nextCharacter);

					if (currentLine.toString().endsWith(LINE_SEPERATOR)) {
						synchronized (readLines) {
							readLines.add(currentLine.toString());
						}

						synchronized (lineListeners) {
							for (LineListener lineListener : lineListeners) {
								lineListener.lineRead(currentLine.toString());
							}
						}

						// clear
						currentLine = new StringBuffer();
					}

					// forward output
					synchronized (forward) {
						for (final OutputStream outputStream : forward) {
							outputStream.write(nextCharacter);
							outputStream.flush();
						}
					}

					// update waiter
					synchronized (waitQueue) {
						final Iterator<WaitFor> iterator = waitQueue.iterator();

						while (iterator.hasNext()) {
							final WaitFor waitFor = iterator.next();
							if (waitFor.isWaiting) {
								waitFor.nextInput(nextCharacter);
							} else {
								iterator.remove();
							}
						}
					}

				} catch (final IOException e) {
					// notify that nothing more is available
					try {
						availableLock.lock();
						available = 0;
						availableCondition.signalAll();
					} finally {
						availableLock.unlock();
					}

					// shut down process communicator
					shutdown();
					
					// abort and in case of input error
					break;
				}
			}
		}

		private final class TimeoutTask extends TimerTask {
			@Override
			public void run() {
				shutdown();

				// signal all threads which might be waiting for the command queue to clear up as
				// the command queue might not be empty
				try {
					commandCompletionLock.lock();

					// set timeout of current command and all all
					commandQueue.current.timedOut();
					queue.forEach(c -> c.timedOut());
					queue.clear();

					commandQueueIsWorking = false;
					commandCompletionCondition.signalAll();
				} finally {
					commandCompletionLock.unlock();
				}

				// if the thread has not been terminated we need to fire time out events
				synchronized (commandTimedOutListeners) {
					for (CommandTimedOutListener commandTimedOutListener : commandTimedOutListeners) {
						commandTimedOutListener.timedOut();
					}
				}
			}
		}

	}

	/**
	 * Represents a command which can be sent to the process.
	 *
	 */
	public static final class Command {
		public final Either<String, Integer> request;
		public final WaitFor waitFor;
		public final boolean blocks;
		public final CommandCompleted commandCompleted;
		private volatile boolean hasTimedOut = false;

		public Command(final String request, final WaitFor waitFor, CommandCompleted commandCompleted, boolean block) {
			this.commandCompleted = commandCompleted;
			this.blocks = block;
			this.request = Either.left(request);
			this.waitFor = waitFor;
		}

		public Command(final int request, final WaitFor waitFor, CommandCompleted commandCompleted, boolean block) {
			super();
			this.commandCompleted = commandCompleted;
			this.blocks = block;
			this.request = Either.right(request);
			this.waitFor = waitFor;
		}

		@Override
		public String toString() {
			return request.map(s -> s, i -> String.valueOf(i));
		}

		public boolean hasTimedOut() {
			return hasTimedOut;
		}

		public void timedOut() {
			hasTimedOut = true;
		}
	}

	/**
	 * Exception thrown when a {@link Command} sent to the {@link ProcessCommunicator} has timed out.
	 *
	 */
	public static final class CommandTimeOutException extends RuntimeException {

		private static final long serialVersionUID = 7373433288586293807L;
		
		public CommandTimeOutException() {
			super("A request to the process has timed out.");
		}
	}

	/**
	 * Abstract base class for all possible {@link WaitFor} classes. A {@link WaitFor} is used to wait for a result from the thread.
	 * They must be supplied to the {@link ProcessCommunicator#sendCommandAwaitResult(int, WaitFor) and {@link ProcessCommunicator#sendCommandAwaitResult(String, WaitFor)}
	 * functions.
	 * 
	 */
	public static abstract class WaitFor {
		protected final Lock lock = new ReentrantLock();
		protected Condition waitCondition;

		protected volatile boolean isWaiting;

		// await for 10 seconds before time out
		public static final int DEFAULT_TIME_OUT_MILLIS = 10_000;

		private WaitFor() {
			this.isWaiting = true;
			this.waitCondition = lock.newCondition();
		}

		/**
		 * Sends the next input character read from output of the process.
		 * 
		 * @param nextCharacter
		 */
		public abstract void nextInput(final int nextCharacter);

		/**
		 * Awaits a given output from the process.
		 * 
		 * @throws InterruptedException
		 */
		public abstract void await();

		/**
		 * Returns the result which has been waited for. <b>Note</b> that the result might contain
		 * preceding characters which the caller is not interested in, since the {@link WaitFor} Class 
		 * had to be created before the command has been sent to the process.
		 * 
		 * @return
		 */
		public abstract String getResult();

	}

	/**
	 * Waits for the line to match the given {@link String}. Avoid complex Regex
	 * since they will be evaluated for every new character read.
	 *
	 */
	public static final class WaitForMatch extends WaitFor {

		private final Pattern pattern;

		private StringBuffer currentLine = new StringBuffer();
		private Matcher currentMatcher;

		private long timeout;

		private WaitForMatch(final String regex, long timeout) {
			this.timeout = timeout;
			this.pattern = Pattern.compile(regex);
		}

		@Override
		public void nextInput(final int nextCharacter) {
			try {
				lock.lock();
				currentLine.append((char) nextCharacter);

				currentMatcher = pattern.matcher(currentLine);
				if (currentMatcher.matches()) {
					isWaiting = false;
					waitCondition.signalAll();
				}

				if (currentLine.toString().endsWith(LINE_SEPERATOR)) {
					currentLine = new StringBuffer();
				}
			} finally {
				lock.unlock();
			}
		}

		@Override
		public void await() {
			try {
				lock.lock();

				while (isWaiting) {
					try {
						waitCondition.await(timeout, TimeUnit.MILLISECONDS);
					} catch (InterruptedException e) {
					}
				}
			} finally {
				lock.unlock();
			}
		}

		@Override
		public String getResult() {
			return currentLine.toString();
		}
	}

	/**
	 * Waits for the given {@link String} result.
	 *
	 */
	public static final class WaitForResult extends WaitFor {
		private final String waitFor;
		private final StringBuffer currentLine = new StringBuffer();
		private long timeout;

		private WaitForResult(final String waitFor, long timeout) {
			this.waitFor = waitFor;
			this.timeout = timeout;
		}

		@Override
		public void nextInput(final int nextCharacter) {
			try {
				lock.lock();
				currentLine.append((char) nextCharacter);

				if (currentLine.toString().endsWith(waitFor)) {
					isWaiting = false;
					waitCondition.signalAll();
				}
			} finally {
				lock.unlock();
			}
		}

		@Override
		public void await() {
			try {
				lock.lock();

				while (isWaiting) {
					try {
						waitCondition.await(timeout, TimeUnit.MILLISECONDS);
					} catch (InterruptedException e) {
					}

				}

			} finally {
				lock.unlock();
			}
		}

		@Override
		public String getResult() {
			return currentLine.toString();
		}
	}

	/**
	 * Callback when {@link WaitFor} await has completed.
	 *
	 */
	@FunctionalInterface
	public interface CommandCompleted {
		/**
		 * Finished waiting.
		 * 
		 * @param waitFor
		 */
		public void commandCompleted(WaitFor waitFor);
	}

	/**
	 * Callback called after a request has timed out.
	 *
	 */
	@FunctionalInterface
	public interface CommandTimedOutListener {

		/**
		 * Callback when a {@link Command} has timed out.
		 */
		public void timedOut();
	}

	/**
	 * Callback after a whole line has been read from the reader.
	 *
	 */
	@FunctionalInterface
	public static interface LineListener {

		/**
		 * Callback when the main Forth Process reader has read a complete line.
		 * 
		 * @param line
		 */
		public void lineRead(String line);
	}

}
