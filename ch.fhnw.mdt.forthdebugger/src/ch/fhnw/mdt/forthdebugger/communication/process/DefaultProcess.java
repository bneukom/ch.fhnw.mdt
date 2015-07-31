package ch.fhnw.mdt.forthdebugger.communication.process;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Default implementation which just forwards to a {@link Process}.
 *
 */
public class DefaultProcess implements IProcessDectorator {

	private final Process process;

	public DefaultProcess(Process process) {
		this.process = process;
	}

	@Override
	public void destroy() {
		process.destroy();
	}

	@Override
	public InputStream getInputStream() {
		return process.getInputStream();
	}

	@Override
	public OutputStream getOutputStream() {
		return process.getOutputStream();
	}

}
