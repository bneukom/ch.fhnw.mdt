package ch.fhnw.mdt.forthdebugger.communication.process;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Decorates an underlying {@link Process}. Can be used to implement a dummy process for testing.
 *
 * @see DefaultProcess
 */
public interface IProcessDectorator {

	/**
	 * @see Process#destroy()
	 */
	public void destroy();

	/**
	 * @see Process#getInputStream()
	 */
	public InputStream getInputStream();
	
	/**
	 * @see Process#getOutputStream() 
	 */
	public OutputStream getOutputStream();
}
