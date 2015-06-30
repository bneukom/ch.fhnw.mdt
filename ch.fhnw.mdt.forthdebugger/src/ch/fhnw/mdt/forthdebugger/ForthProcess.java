package ch.fhnw.mdt.forthdebugger;

import java.io.IOException;
import java.util.Map;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.IStreamListener;
import org.eclipse.debug.core.model.IStreamMonitor;
import org.eclipse.debug.core.model.IStreamsProxy;
import org.eclipse.debug.core.model.RuntimeProcess;

public class ForthProcess extends RuntimeProcess {

	private ForthStreamProxy forthStreamProxy = new ForthStreamProxy();
	
	public ForthProcess(ILaunch launch, Process process, String name, Map<String, String> attributes) {
		super(launch, process, name, attributes);
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
