package ch.fhnw.mdt.forthdebugger;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import ch.fhnw.mdt.forthdebugger.ForthReader.WaitFor;
import ch.fhnw.mdt.forthdebugger.util.Either;

/**
 * Thread safe communication for the forth process. TODO implement timeout!
 */
public final class ForthCommunicator extends Thread {

	private final BlockingQueue<Command> commandQueue = new LinkedBlockingQueue<Command>();
	private final BufferedWriter processWriter;
	private final ForthReader forthReader;
	private final Process process;

	private final Lock commandCompletionLock = new ReentrantLock();
	private final Condition commandCompletionCondition;

	public static final String OK = "ok";
	public static final String NL = System.lineSeparator();

	public static final int CR = 13;

	public static final int ANY = 65;

	public ForthCommunicator(final BufferedWriter processWriter, final ForthReader forthReader, final Process process) {
		this.processWriter = processWriter;
		this.forthReader = forthReader;
		this.process = process;

		this.commandCompletionCondition = commandCompletionLock.newCondition();
	}

	/**
	 * Shuts the communication down and closes all streams.
	 */
	public void shutdown() {
		interrupt();

		try {
			processWriter.close();
		} catch (final IOException e) {
			e.printStackTrace();
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
	 * Sends the given command and blocks until the process has returned the given result.
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
	 * Sends the given command and blocks until the process has returned the given result.
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
	 * Awaits until the command queue has been completed meaning all commands have been written and if necessary recieved their results.
	 */
	public void awaitCommandCompletion() {
		try {
			commandCompletionLock.lock();
			while (!commandQueue.isEmpty()) {
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
		while (process.isAlive()) {
			try {
				// get next command or wait if there are none
				final Command command = commandQueue.take();

				try {
					if (command.waitFor != null) {
						// register for waiting, this needs to be done before the actual command has been sent
						// The WaitFor object no receives all output from the process and after await has been called
						// final WaitFor wait = forthReader.waitForLater(command.result);

						writeCommand(command);

						// wait for the result
						command.waitFor.await();
					} else {
						writeCommand(command);
					}

					try {
						commandCompletionLock.lock();

						// signal commandQueue empty
						if (commandQueue.isEmpty()) {
							commandCompletionCondition.signalAll();
						}
					} finally {
						commandCompletionLock.unlock();
					}

				} catch (final IOException e) {
					e.printStackTrace();
				}

			} catch (final InterruptedException e) {
				return;
			}

		}
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
}