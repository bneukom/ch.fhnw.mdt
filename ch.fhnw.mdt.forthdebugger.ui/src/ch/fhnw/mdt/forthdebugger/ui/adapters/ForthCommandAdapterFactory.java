package ch.fhnw.mdt.forthdebugger.ui.adapters;

import org.eclipse.core.runtime.IAdapterFactory;

import ch.fhnw.mdt.forthdebugger.debugmodel.extensions.IAfterExtension;
import ch.fhnw.mdt.forthdebugger.debugmodel.extensions.IJumpExtension;
import ch.fhnw.mdt.forthdebugger.ui.commands.after.AfterCommand;
import ch.fhnw.mdt.forthdebugger.ui.commands.after.IAfterHandler;
import ch.fhnw.mdt.forthdebugger.ui.commands.jump.IJumpHandler;
import ch.fhnw.mdt.forthdebugger.ui.commands.jump.JumpCommand;

public class ForthCommandAdapterFactory implements IAdapterFactory {
	
	private JumpCommand jumpCommand = new JumpCommand();
	private AfterCommand afterCommand = new AfterCommand();

	public ForthCommandAdapterFactory() {
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adapterType == IJumpHandler.class) {
			return jumpCommand;
		} else if (adapterType == IAfterHandler.class) {
			return afterCommand;
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class[] getAdapterList() {
		return new Class[] { IJumpExtension.class, IAfterExtension.class };
	}

}
