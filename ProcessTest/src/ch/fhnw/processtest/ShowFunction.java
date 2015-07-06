package ch.fhnw.processtest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

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
		reader.start();
		communicator.start();

		communicator.sendCommandAwaitResult("umbilical: /dev/ttyUSB0" + NL, ForthCommunicator.OK);
		communicator.sendCommandAwaitResult("run" + NL, "HANDSHAKE");
		
		
		for (int i = 0; i < 10; ++i) {
			communicator.sendCommandAwaitResult("show " + (Math.random() < 0.5 ? "_bar" : "_foo") + NL, "----");

			final List<String> function = new ArrayList<String>();

			communicator.awaitCommandCompletion();
			reader.awaitReadCompletion();
			String currentLine = reader.getCurrentLine();

			while (!currentLine.contains("exit")) {
				System.out.println("\t\t\t\t--> Line: \"" + currentLine + "\"");

				function.add(currentLine);

				communicator.sendCommandAwaitResult(ForthCommunicator.ANY, NL);
				communicator.awaitCommandCompletion();
				reader.awaitReadCompletion();

				currentLine = reader.getCurrentLine();
			}

			communicator.sendCommand(ForthCommunicator.CR);
		}

		for (int i = 0; i < 4; ++i) {
			communicator.sendCommandAwaitResult("debug _foo" + NL, ForthCommunicator.OK);
			communicator.sendCommandAwaitResult("unbug _foo" + NL, ForthCommunicator.OK);
		}

		communicator.sendCommandAwaitResult("bye" + NL, ForthCommunicator.OK);

		communicator.sendCommand("bye" + NL);

		communicator.awaitCommandCompletion();
		reader.awaitReadCompletion();

		communicator.shutdown();

		try {
			int waitFor = process.waitFor();
			System.out.println(waitFor);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		reader.shutdown();

		// System.out.println("===");
		// for (String string : function) {
		// System.out.println(string);
		// }
	}

}
