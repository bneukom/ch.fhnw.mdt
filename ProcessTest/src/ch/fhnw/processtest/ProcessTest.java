package ch.fhnw.processtest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

public class ProcessTest {

	public static void main(String[] args) throws IOException {
		ProcessBuilder builder = new ProcessBuilder("gforth", "./load_eclipse.fs");
		builder.directory(new File("/home/bneukom/cd/uForthExtensions/XP2_3212/uForthWS"));
		Process process = builder.start();

		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
		InputStream stream = process.getInputStream();
		
		while (stream.available() > 0) {
			int read = stream.read();
			System.out.print((char) read);
		}


		bufferedWriter.write("umbilical: /dev/ttyUSB28");
		bufferedWriter.newLine();
		bufferedWriter.flush();
		
		System.out.print((char) stream.read());

		while (stream.available() > 0) {
			int read = stream.read();
			System.out.print((char) read);
		}

		bufferedWriter.write("run");
		bufferedWriter.newLine();
		bufferedWriter.flush();
		System.out.print((char) stream.read());
		while (stream.available() > 0) {
			int read = stream.read();
			System.out.print((char) read);
		}

		bufferedWriter.write("bye");
		bufferedWriter.newLine();
		bufferedWriter.flush();

		System.out.print((char) stream.read());
		while (stream.available() > 0) {
			int read = stream.read();
			System.out.print((char) read);
		}

		bufferedWriter.write("bye");
		bufferedWriter.newLine();
		bufferedWriter.flush();

		while (stream.available() > 0) {
			int read = stream.read();
			System.out.print((char) read);
		}

		// try {
		// Thread.sleep(5000);
		// } catch (InterruptedException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		//
		// bufferedWriter.write("run");
		// bufferedWriter.newLine();
		// bufferedWriter.flush();

		// try {
		// Thread.sleep(5000);
		// } catch (InterruptedException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		//
		// bufferedWriter.write("debugger");
		// bufferedWriter.newLine();
		// bufferedWriter.flush();
		//
		// try {
		// Thread.sleep(5000);
		// } catch (InterruptedException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		//
		// new Thread(() -> {
		// boolean debug = true;
		// while (process.isAlive()) {
		// try {
		// Thread.sleep(200);
		// bufferedWriter.write((debug ? "debug" : "unbug") + " _foo");
		// bufferedWriter.newLine();
		// bufferedWriter.flush();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		//
		// debug = !debug;
		// }
		// }).start();

	}
}
