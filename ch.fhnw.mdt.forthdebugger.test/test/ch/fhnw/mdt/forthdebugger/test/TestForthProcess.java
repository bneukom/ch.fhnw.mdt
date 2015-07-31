package ch.fhnw.mdt.forthdebugger.test;

import java.io.InputStream;
import java.io.OutputStream;

import ch.fhnw.mdt.forthdebugger.communication.process.IForthProcess;

/**
 * Can emulate a Forth Process by writing the appropriate output to the stream recieved via {@link #getOutputStream()}.
 */
public class TestForthProcess implements IForthProcess {

	@Override
	public void destroy() {
		// ignore
	}

	@Override
	public InputStream getInputStream() {
		return null;
	}

	@Override
	public OutputStream getOutputStream() {
		return null;
	}

}
