package ch.fhnw.mdt.forthdebugger.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import ch.fhnw.mdt.forthdebugger.communication.process.IProcessDectorator;

/**
 * Can emulate a {@link Process} by writing the appropriate output to the stream received via {@link #getOutputStream()}.
 */
public class TestProcess implements IProcessDectorator {

	private final PipedOutputStream outputStream = new PipedOutputStream();
	private PipedInputStream readFrom;

	private final PipedInputStream inputStream = new PipedInputStream();
	private OutputStreamWriter writeTo;

	private final ProcessFunction processFunction;
	private final ProcessThread processThread = new ProcessThread();

	private static final String LINE_SEPARATOR = System.lineSeparator();

	public TestProcess(ProcessFunction processFunction) {
		this.processFunction = processFunction;

		try {
			readFrom = new PipedInputStream(outputStream);
			writeTo = new OutputStreamWriter(new PipedOutputStream(inputStream));
		} catch (IOException e) {
			e.printStackTrace();
		}

		processThread.start();
	}

	@Override
	public void destroy() {
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		try {
			inputStream.close();
		} catch (IOException e) {
		}
	}

	@Override
	public InputStream getInputStream() {
		return inputStream;
	}

	@Override
	public OutputStream getOutputStream() {
		return outputStream;
	}

	private final class ProcessThread extends Thread {

		@Override
		public void run() {
			final StringBuffer lineBuffer = new StringBuffer();
			while (true) {
				try {
					final char read = (char) readFrom.read();
					lineBuffer.append(read);

					final Output result = processFunction.apply(lineBuffer.toString());

					if (result != null) {
						if (result.delay > 0) {
							try {
								Thread.sleep(result.delay);
							} catch (InterruptedException e) {
							}
						}

						writeTo.write(result.output);
						writeTo.flush();
						lineBuffer.setLength(0); 
					}


				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static interface ProcessFunction {
		public Output apply(String input);
	}

	public static final class Output {
		public final String output;
		public final long delay;

		public Output(String output, long delay) {
			this.output = output;
			this.delay = delay;
		}

	}

}
