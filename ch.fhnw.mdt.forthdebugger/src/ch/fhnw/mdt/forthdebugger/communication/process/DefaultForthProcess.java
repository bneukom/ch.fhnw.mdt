package ch.fhnw.mdt.forthdebugger.communication.process;

import java.io.InputStream;
import java.io.OutputStream;

public class DefaultForthProcess implements IForthProcess {

	private final Process process;

	public DefaultForthProcess(Process process) {
		super();
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
