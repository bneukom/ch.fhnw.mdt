package ch.fhnw.mdt.forthdebugger;

import java.util.Map;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.IProcessFactory;
import org.eclipse.debug.core.model.IProcess;

public class ForthProcessFactory implements IProcessFactory {

	@Override
	public IProcess newProcess(ILaunch launch, Process process, String label, Map<String, String> attributes) {
		return new ForthProcess(launch, process, label, attributes);
	}

}
