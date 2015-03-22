package ch.fhnw.mdt.launch;

import java.io.IOException;

import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;

public class MCoreLauncher {
	public static void launch(ILaunch launch) {
		pwd(launch);
		ls(launch);
//		launchGforth(launch);
	}

	private static void ls(ILaunch launch) {
		ProcessBuilder builder = new ProcessBuilder("ls", "-l");
		Process process;
		try {
			process = builder.start();
			DebugPlugin.newProcess(launch, process, "ls");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void pwd(ILaunch launch) {
		ProcessBuilder builder = new ProcessBuilder("pwd");
		Process process;
		try {
			process = builder.start();
			DebugPlugin.newProcess(launch, process, "pwd");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void launchGforth(ILaunch launch) {
		ProcessBuilder builder = new ProcessBuilder("gforth", "./load_tasks.fs");
		Process process;
		try {
			process = builder.start();
			DebugPlugin.newProcess(launch, process, "gforth");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
