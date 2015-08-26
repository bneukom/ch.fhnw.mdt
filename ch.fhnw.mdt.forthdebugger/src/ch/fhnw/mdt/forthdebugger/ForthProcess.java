package ch.fhnw.mdt.forthdebugger;

import java.io.IOException;
import java.util.Map;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.IStreamListener;
import org.eclipse.debug.core.model.IStreamMonitor;
import org.eclipse.debug.core.model.IStreamsProxy;
import org.eclipse.debug.core.model.ITerminate;
import org.eclipse.debug.core.model.RuntimeProcess;

import ch.fhnw.mdt.forthdebugger.debugmodel.extensions.IKillProcessExtension;

/**
 * Forth specific process. The internal {@link IStreamsProxy} ignores
 */
public class ForthProcess extends RuntimeProcess implements IKillProcessExtension, ITerminate {

	private ForthStreamProxy forthStreamProxy = new ForthStreamProxy();
	private Process process;

	public ForthProcess(ILaunch launch, Process process, String name, Map<String, String> attributes) {
		super(launch, process, name, attributes);
		this.process = process;
	}

	@Override
	public void kill() throws DebugException {
		super.terminate();
	}
	
	@Override
	public void terminate() throws DebugException {
		try {
			process.getOutputStream().write(("bye" + System.lineSeparator() + "bye" + System.lineSeparator()).getBytes());
			process.getOutputStream().flush();
		} catch (IOException e) {
			super.terminate();
		}
	}

	@Override
	public boolean canKill() throws DebugException {
		return !super.isTerminated();
	}

	@Override
	protected IStreamsProxy createStreamsProxy() {
		return forthStreamProxy;
	}

	private static class ForthStreamProxy implements IStreamsProxy {

		private ForthStreamMonitor monitor = new ForthStreamMonitor();

		@Override
		public IStreamMonitor getErrorStreamMonitor() {
			return monitor;
		}

		@Override
		public IStreamMonitor getOutputStreamMonitor() {
			return monitor;
		}

		@Override
		public void write(String input) throws IOException {
			// ignore
		}

		private static class ForthStreamMonitor implements IStreamMonitor {

			@Override
			public void addListener(IStreamListener listener) {

			}

			@Override
			public String getContents() {
				return "";
			}

			@Override
			public void removeListener(IStreamListener listener) {

			}
		}
	}

}
