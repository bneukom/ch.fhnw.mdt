package ch.fhnw.processtest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.ProcessBuilder.Redirect;

public class ProcessTest2 {

	public static void main(String[] args) throws IOException {
		ProcessBuilder builder = new ProcessBuilder("gforth", "./load_eclipse.fs");
		builder.directory(new File("/home/bneukom/cd/uForthExtensions/XP2_3212/uForthWS"));
		Process process = builder.start();

		try {

			BufferedReader inputStream = new BufferedReader(new InputStreamReader(process.getInputStream()));
			BufferedReader errorStream = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			new Thread(() -> {
				while (process.isAlive()) {
					try {
						if (inputStream.ready()) {
							int read = inputStream.read();
							System.out.print((char) read);
						}
					} catch (Exception e) {
						e.printStackTrace();
						return;
					}
				}
			}).start();

			new Thread(() -> {
				while (process.isAlive()) {
					try {
						if (errorStream.ready()) {
							int read = errorStream.read();
							System.out.print((char) read);
						}
					} catch (Exception e) {
						e.printStackTrace();
						return;
					}
				}
			}).start();

			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));

			bufferedWriter.write("umbilical: /dev/ttyUSB32");
			bufferedWriter.newLine();
			bufferedWriter.flush();

			bufferedWriter.write("run");
			bufferedWriter.newLine();
			bufferedWriter.flush();

			bufferedWriter.write("bye");
			bufferedWriter.newLine();
			bufferedWriter.flush();

			bufferedWriter.write("bye");
			bufferedWriter.newLine();
			bufferedWriter.flush();

			try {
				Thread.sleep(10000);
				inputStream.close();
				errorStream.close();
				
				process.destroy();
				
			} catch (InterruptedException e1) {
				e1.printStackTrace();
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

			try {
				process.waitFor();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}

	}
}
