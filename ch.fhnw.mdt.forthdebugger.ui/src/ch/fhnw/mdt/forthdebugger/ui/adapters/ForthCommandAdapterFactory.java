package ch.fhnw.mdt.forthdebugger.ui.adapters;

import org.eclipse.core.runtime.IAdapterFactory;

import ch.fhnw.mdt.forthdebugger.debugmodel.IJumpExtension;
import ch.fhnw.mdt.forthdebugger.ui.commands.IJumpHandler;
import ch.fhnw.mdt.forthdebugger.ui.commands.JumpCommand;

public class ForthCommandAdapterFactory implements IAdapterFactory {
	
	private JumpCommand jumpCommand = new JumpCommand();
	
	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adapterType == IJumpHandler.class) {
			return jumpCommand;
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class[] getAdapterList() {
		return new Class[] { IJumpExtension.class };
	}

}
