package ch.fhnw.mdt.forthdebugger.forth;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import ch.fhnw.mdt.forthdebugger.forth.ForthReader.WaitFor;
import ch.fhnw.mdt.forthdebugger.util.Either;

/**
 * Thread safe communication for the forth process. TODO implement timeout!
 */
public final class ForthCommandQueue extends Thread {

	private final BlockingQueue<Command> commandQueue = new LinkedBlockingQueue<Command>();
	private transient boolean isWorking = false;

	private final BufferedWriter processWriter;
	private final Process process;
	private volatile boolean shutdown = false;

	private final List<TimedOutListener> timedOutListeners = new ArrayList<TimedOutListener>();

	private final Lock commandCompletionLock = new ReentrantLock();
	private final Condition commandCompletionCondition;

	public static final String OK = "ok";
	public static final String NL = System.lineSeparator();

	public static final int CR = 13;

	public static final int ANY = 65;

	public ForthCommandQueue(final BufferedWriter processWriter, final Process process) {
		this.processWriter = processWriter;
		this.process = process;

		this.commandCompletionCondition = commandCompletionLock.newCondition();
	}

	/**
	 * Shuts the communication down and closes all streams.
	 */
	public void shutdown() {
		shutdown = true;
		interrupt();

		try {
			processWriter.close();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Adds the given {@link TimedOutListener} callback which will get called
	 * after the command queue has terminated.
	 * 
	 * @param listener
	 */
	public void addShutdownListener(TimedOutListener listener) {
		synchronized (timedOutListeners) {
			timedOutListeners.add(listener);
		}
	}

	/**
	 * Sends the given command and immediately returns.
	 * 
	 * @param command
	 */
	public void sendCommand(final String command) {
		sendCommand(new Command(command, null));
	}

	/**
	 * Sends the given command and blocks until the process has returned the
	 * given result.
	 * 
	 * @param command
	 * @param waitFor
	 */
	public void sendCommandAwaitResult(final String command, final WaitFor waitFor) {
		sendCommand(new Command(command, waitFor));
	}

	/**
	 * Sends the given command and immediately returns.
	 * 
	 * @param command
	 */
	public void sendCommand(final int command) {
		sendCommand(new Command(command, null));
	}

	/**
	 * Sends the given command and blocks until the process has returned the
	 * given result.
	 * 
	 * @param command
	 * @param waitFor
	 */
	public void sendCommandAwaitResult(final int command, final WaitFor waitFor) {
		sendCommand(new Command(command, waitFor));
	}

	/**
	 * Sends the given {@link Command}.
	 * 
	 * @param command
	 */
	public void sendCommand(final Command command) {
		try {
			commandCompletionLock.lock();

			isWorking = true;
			commandQueue.put(command);

			// await the result
			if (command.waitFor != null) {
				awaitCommandCompletion();
			}
		} catch (final InterruptedException e) {
			e.printStackTrace();
		} finally {
			commandCompletionLock.unlock();
		}

	}

	/**
	 * Awaits until the command queue has been completed meaning all commands
	 * have been written and if necessary received their results.
	 */
	public void awaitCommandCompletion() {
		try {
			commandCompletionLock.lock();

			while (isWorking) {
				commandCompletionCondition.await();
			}
		} catch (final InterruptedException e) {
			e.printStackTrace();
		} finally {
			commandCompletionLock.unlock();
		}
	}

	@Override
	public void run() {
		while (!shutdown) {
			try {
				// get next command or wait if there are none
				final Command command = commandQueue.take();

				try {
					if (command.waitFor != null) {
						writeCommand(command);

						// wait for the result before processing further
						// commands
						try {
							command.waitFor.await();
						} catch (InterruptedException e) {
							synchronized (timedOutListeners) {
								for (TimedOutListener timedOutListener : timedOutListeners) {
									timedOutListener.shutdown(shutdown ? null : reason);
								}
							}
						}
					} else {
						writeCommand(command);
					}

					try {
						commandCompletionLock.lock();

						// signal commandQueue empty
						if (commandQueue.isEmpty()) {
							isWorking = false;
							commandCompletionCondition.signalAll();
						}
					} finally {
						commandCompletionLock.unlock();
					}

				} catch (final IOException e) {
					break;
				}

			} catch (final InterruptedException e) {
				break;
			}
		}

	

		shutdown = true;
	}

	private void writeCommand(final Command command) throws IOException {
		// write request
		command.request.apply(s -> {
			try {
				processWriter.write(s);
			} catch (final IOException e) {
				e.printStackTrace();
			}
		}, i -> {
			try {
				processWriter.write(i);
			} catch (final IOException e) {
				e.printStackTrace();
			}
		});
		processWriter.flush();

	}

	/**
	 * Represents a command which can be sent to the process.
	 *
	 */
	public static final class Command {
		public final Either<String, Integer> request;
		public final WaitFor waitFor;

		public Command(final String request, final WaitFor waitFor) {
			super();
			this.request = Either.left(request);
			this.waitFor = waitFor;

		}

		public Command(final int request, final WaitFor waitFor) {
			super();
			this.request = Either.right(request);
			this.waitFor = waitFor;
		}
	}

	public interface TimedOutListener {
		public void shutdown(Exception reason);
	}
}