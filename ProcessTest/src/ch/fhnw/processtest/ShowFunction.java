package ch.fhnw.processtest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.Pattern;

public class ShowFunction {

	private static final String NL = System.lineSeparator();

	public static void main(final String[] args) throws IOException {
		final ProcessBuilder builder = new ProcessBuilder("gforth", "./load_eclipse.fs");
		builder.directory(new File("/home/bneukom/cd/uForthExtensions/XP2_3212/uForthWS"));
		builder.redirectErrorStream(true);

		final Process process = builder.start();

		final BufferedWriter processWriter = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));

		// TODO capture error messages
		final ForthReader reader = new ForthReader(process.getInputStream());
		reader.forwardOutput(System.out);

		final ForthCommunicator communicator = new ForthCommunicator(processWriter, reader, process);

		// TODO make reader extend thread
		new Thread(reader).start();
		communicator.start();

		communicator.sendCommand("umbilical: /dev/ttyUSB3" + NL, ForthCommunicator.OK);
		communicator.sendCommand("run" + NL, "HANDSHAKE");
//		communicator.sendCommand("show _bar" + NL, "_bar              ---------------");
//
//		final List<String> function = new ArrayList<String>();
//
//		communicator.awaitCommandCompletion();
//		reader.awaitReadCompletion();
//		String currentLine = reader.getCurrentLine();
//
//		while (!currentLine.contains("exit")) {
//
//			function.add(currentLine);
//
//			communicator.sendCommand(ForthCommunicator.ANY, NL);
//			communicator.awaitCommandCompletion();
//			reader.awaitReadCompletion();
//
//			currentLine = reader.getCurrentLine();
//		}
//
//		communicator.sendCommand(ForthCommunicator.CR);
//
//		for (int i = 0; i < 4; ++i) {
//			communicator.sendCommand("debug _foo" + NL, ForthCommunicator.OK);
//			communicator.sendCommand("unbug _foo" + NL, ForthCommunicator.OK);
//		}

		communicator.sendCommand("bye" + NL, ForthCommunicator.OK);

		communicator.sendCommand("bye" + NL);

		communicator.awaitCommandCompletion();
		reader.awaitReadCompletion();

		communicator.shutdown();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			int waitFor = process.waitFor();
			System.out.println(waitFor);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		reader.shutdown();
		
//		System.out.println("===");
//		for (String string : function) {
//			System.out.println(string);
//		}
	}

	/**
	 * Thread safe communication for the forth process. TODO implement timeout!
	 */
	private static final class ForthCommunicator extends Thread {

		private final BlockingQueue<Command> commandQueue = new LinkedBlockingQueue<ShowFunction.Command>();
		private final BufferedWriter processWriter;
		private final ForthReader forthReader;
		private final Process process;

		private final Lock commandCompletionLock = new ReentrantLock();
		private final Condition commandCompletionCondition;

		public static final String OK = "ok";

		public static final int CR = 13;

		public static final int ANY = 65;

		public ForthCommunicator(final BufferedWriter processWriter, final ForthReader forthReader, final Process process) {
			this.processWriter = processWriter;
			this.forthReader = forthReader;
			this.process = process;

			this.commandCompletionCondition = commandCompletionLock.newCondition();
		}

		public void shutdown() {
			interrupt();

			try {
				processWriter.close();
			} catch (final IOException e) {
				e.printStackTrace();
			}
		}

		public void sendCommand(final String command) {
			sendCommand(new Command(command, null));
		}

		public void sendCommand(final String command, final String result) {
			sendCommand(new Command(command, result));
		}

		public void sendCommand(final int command) {
			sendCommand(new Command(command, null));
		}

		public void sendCommand(final int command, final String result) {
			sendCommand(new Command(command, result));
		}

		public void sendCommand(final Command command) {
			try {
				commandCompletionLock.lock();

				commandQueue.put(command);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			} finally {
				commandCompletionLock.unlock();
			}
		}

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
						if (command.result != null) {
							// register for waiting, this needs to be done before the actual command has been sent
							// The WaitFor object no receives all output from the process and after await has been called
							final WaitFor wait = forthReader.waitForLater(command.result);

							writeCommand(command);

							// wait for the result
							wait.await();
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
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}, i -> {
				try {
					processWriter.write(i);
				} catch (final Exception e) {
					e.printStackTrace();
				}
			});
			processWriter.flush();

		}
	}

	private static final class Command {
		public final Either<String, Integer> request;
		public final String result;

		public Command(final String request, final String result) {
			super();
			this.request = Either.left(request);
			this.result = result;
		}

		public Command(final int request, final String result) {
			super();
			this.request = Either.right(request);
			this.result = result;
		}
	}

	private static final class ForthReader implements Runnable {

		private final List<WaitFor> waitQueue = Collections.synchronizedList(new ArrayList<WaitFor>());
		private final List<OutputStream> forward = Collections.synchronizedList(new ArrayList<OutputStream>());

		private final InputStream input;

		private volatile boolean isRunning;

		private final List<String> readLines = new ArrayList<String>();
		private final StringBuffer currentLine = new StringBuffer();

		private static final String LINE_SEPERATOR = System.lineSeparator();

		private Lock availableLock = new ReentrantLock();
		private Condition availableCondition = availableLock.newCondition();
		private volatile int available = 0;

		public ForthReader(final InputStream input) {
			super();
			this.input = input;
			this.isRunning = true;

		}

		public int getNumberOfReadLines() {
			return readLines.size();
		}

		public String getLineAt(final int index) {
			return readLines.get(index);
		}

		public String getLastLine() {
			return readLines.get(readLines.size() - 1);
		}

		public String getCurrentLine() {
			return currentLine.toString();
		}

		public void shutdown() {
			try {
				isRunning = false;
				input.close();
			} catch (final IOException e) {
				e.printStackTrace();
			}
		}

		public void forwardOutput(final OutputStream out) {
			synchronized (forward) {
				forward.add(out);
			}
		}

		@Override
		public void run() {
			while (isRunning) {

				try {
					// read next char
					final int nextCharacter = input.read();

					// remember read lines and current lines
					currentLine.append((char) nextCharacter);

					if (currentLine.toString().endsWith(LINE_SEPERATOR)) {
						synchronized (readLines) {
							readLines.add(currentLine.toString());
						}

						// clear
						currentLine.setLength(0);
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
							final ShowFunction.WaitFor waitFor = (ShowFunction.WaitFor) iterator.next();
							if (waitFor.isWaiting) {
								waitFor.nextInput(nextCharacter);
							} else {
								iterator.remove();
							}
						}
					}

				} catch (final IOException e) {
					return;
				}
			}
		}

		public void awaitReadCompletion() {
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

		public synchronized WaitFor waitForLater(final String result) {
			final WaitFor wait = new WaitForResult(result);

			synchronized (waitQueue) {
				waitQueue.add(wait);
			}

			return wait;
		}

	}

	private static abstract class WaitFor {
		protected final Lock lock = new ReentrantLock();
		protected Condition waitCondition;

		protected volatile boolean isWaiting;

		public WaitFor() {
			this.isWaiting = true;
			this.waitCondition = lock.newCondition();
		}

		public abstract void nextInput(final int nextCharacter);

		public abstract void await();

	}

	private static final class WaitForResult extends WaitFor {
		private final String waitFor;
		private final StringBuffer current = new StringBuffer();

		public WaitForResult(final String waitFor) {
			this.waitFor = waitFor;
		}

		public void nextInput(final int nextCharacter) {
			try {
				lock.lock();
				current.append((char) nextCharacter);

				if (current.toString().endsWith(waitFor)) {
					isWaiting = false;
					waitCondition.signalAll();
				}
			} finally {
				lock.unlock();
			}
		}

		public void await() {
			try {
				lock.lock();

				while (isWaiting) {
					try {
						waitCondition.await();
					} catch (final InterruptedException e) {
						e.printStackTrace();
					}
				}
			} finally {
				lock.unlock();
			}
		}
	}

	public static final class Either<L, R> {
		public static <L, R> Either<L, R> left(final L value) {
			return new Either<>(Optional.of(value), Optional.empty());
		}

		public static <L, R> Either<L, R> right(final R value) {
			return new Either<>(Optional.empty(), Optional.of(value));
		}

		private final Optional<L> left;
		private final Optional<R> right;

		private Either(final Optional<L> l, final Optional<R> r) {
			left = l;
			right = r;
		}

		public <T> T map(final Function<? super L, ? extends T> lFunc, final Function<? super R, ? extends T> rFunc) {
			return left.map(lFunc).orElseGet(() -> right.map(rFunc).get());
		}

		public <T> Either<T, R> mapLeft(final Function<? super L, ? extends T> lFunc) {
			return new Either<>(left.map(lFunc), right);
		}

		public <T> Either<L, T> mapRight(final Function<? super R, ? extends T> rFunc) {
			return new Either<>(left, right.map(rFunc));
		}

		public void apply(final Consumer<? super L> lFunc, final Consumer<? super R> rFunc) {
			left.ifPresent(lFunc);
			right.ifPresent(rFunc);
		}
	}
}
