package ch.fhnw.mdt.forthdebugger.communication;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

public final class ForthReader extends Thread {

	private final List<WaitFor> waitQueue = Collections.synchronizedList(new ArrayList<WaitFor>());
	private final List<OutputStream> forward = Collections.synchronizedList(new ArrayList<OutputStream>());

	private final InputStream input;

	private volatile boolean isRunning;

	private final List<String> readLines = new ArrayList<String>();
	private StringBuffer currentLine = new StringBuffer();

	// XXX WINDOWS WORKAROUND
//	private static final String LINE_SEPERATOR = System.lineSeparator();
	private static final String LINE_SEPERATOR = "\n";

	private Lock availableLock = new ReentrantLock();
	private Condition availableCondition = availableLock.newCondition();
	private volatile int available = 0;

	private List<LineListener> lineListeners = Collections.synchronizedList(new ArrayList<LineListener>());

	public ForthReader(final InputStream input) {
		super();
		this.input = input;
		this.isRunning = true;

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
	 * @return
	 */
	public List<String> getReadLines() {
		synchronized (readLines) {
			return Collections.unmodifiableList(readLines);
		}
	}

	/**
	 * Returns the line which is currently being read. This line might not be
	 * complete.
	 * 
	 * @return
	 */
	public String getCurrentLine() {
		return currentLine.toString();
	}

	/**
	 * Stops this reader.
	 */
	public void shutdown() {
		try {
			isRunning = false;
			input.close();

			// TODO is this as clean as it should be?
			// all waiting objects will timeout eventually

		} catch (final IOException e) {
			e.printStackTrace();
		}
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

	@Override
	public void run() {
		while (isRunning) {

			try {
				// read next char
				final int nextCharacter = input.read();

				// TODO ordering is important due to clearing (how to make that
				// consistent)
				// notify everyone who was waiting for the available count to
				// hit zero
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
				return;
			}
		}
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
	 * Callback after a whole line has been read from the reader.
	 *
	 */
	public static interface LineListener {
		public void lineRead(String line);
	}

	/**
	 * Creates a {@link WaitForResult} object which can be used to wait for a
	 * given result from the forth process reader at a later time. Call {@link WaitFor#await()} to wait.
	 * 
	 * @param result
	 * @return
	 */
	public synchronized WaitForResult waitForResultLater(final String result) {
		final WaitForResult wait = new WaitForResult(result);

		synchronized (waitQueue) {
			waitQueue.add(wait);
		}

		return wait;
	}

	/**
	 * Creates a {@link WaitForMatch} object which can be used to wait for a
	 * given match from the forth process reader at a later time. Call {@link WaitFor#await()} to wait.
	 * 
	 * @param result
	 * @return
	 */
	public synchronized WaitForMatch waitForMatchLater(final String regex) {
		final WaitForMatch wait = new WaitForMatch(regex);

		synchronized (waitQueue) {
			waitQueue.add(wait);
		}

		return wait;
	}

	/**
	 * Abstract base class for all possible await classes.
	 *
	 */
	public static abstract class WaitFor {
		protected final Lock lock = new ReentrantLock();
		protected Condition waitCondition;

		protected volatile boolean isWaiting;

		public static final int DEFAULT_TIME_OUT_MILLIS = 10000_000;

		public WaitFor() {
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
		public abstract void await() throws InterruptedException;

	}

	/**
	 * Waits for the line to match the given {@link String}. Avoid complex Regex
	 * since they will be evaluated for every new character read.
	 *
	 */
	public static final class WaitForMatch extends WaitFor {

		private final Pattern pattern;

		private StringBuffer current = new StringBuffer();

		public WaitForMatch(final String regex) {
			pattern = Pattern.compile(regex);
		}

		@Override
		public void nextInput(final int nextCharacter) {
			try {
				lock.lock();
				current.append((char) nextCharacter);

				if (pattern.matcher(current).matches()) {
					isWaiting = false;
					waitCondition.signalAll();
				}

				if (current.toString().endsWith(LINE_SEPERATOR)) {
					current = new StringBuffer();
				}
			} finally {
				lock.unlock();
			}
		}

		@Override
		public void await() throws InterruptedException {
			try {
				lock.lock();

				while (isWaiting) {
					boolean finished = waitCondition.await(DEFAULT_TIME_OUT_MILLIS, TimeUnit.MILLISECONDS);

					if (!finished) {
						throw new InterruptedException();
					}
				}
			} finally {
				lock.unlock();
			}
		}

	}

	public static final class WaitForResult extends WaitFor {
		private final String waitFor;
		private final StringBuffer current = new StringBuffer();

		public WaitForResult(final String waitFor) {
			this.waitFor = waitFor;
		}

		@Override
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

		@Override
		public void await() throws InterruptedException {
			try {
				lock.lock();

				while (isWaiting) {
					boolean finished = waitCondition.await(DEFAULT_TIME_OUT_MILLIS, TimeUnit.MILLISECONDS);

					if (!finished) {
						throw new InterruptedException();
					}
				}

			} finally {
				lock.unlock();
			}
		}
	}

}