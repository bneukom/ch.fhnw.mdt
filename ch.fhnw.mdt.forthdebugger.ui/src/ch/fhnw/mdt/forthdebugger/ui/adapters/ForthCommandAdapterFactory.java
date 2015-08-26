package ch.fhnw.mdt.forthdebugger.ui.adapters;

import org.eclipse.core.runtime.IAdapterFactory;

import ch.fhnw.mdt.forthdebugger.debugmodel.extensions.IAfterExtension;
import ch.fhnw.mdt.forthdebugger.debugmodel.extensions.IJumpExtension;
import ch.fhnw.mdt.forthdebugger.debugmodel.extensions.IKillProcessExtension;
import ch.fhnw.mdt.forthdebugger.ui.commands.after.AfterCommand;
import ch.fhnw.mdt.forthdebugger.ui.commands.after.IAfterHandler;
import ch.fhnw.mdt.forthdebugger.ui.commands.jump.IJumpHandler;
import ch.fhnw.mdt.forthdebugger.ui.commands.jump.JumpCommand;
import ch.fhnw.mdt.forthdebugger.ui.commands.kill.IKillHandler;
import ch.fhnw.mdt.forthdebugger.ui.commands.kill.KillCommand;

public class ForthCommandAdapterFactory implements IAdapterFactory {
	
	private JumpCommand jumpCommand = new JumpCommand();
	private AfterCommand afterCommand = new AfterCommand();
	private KillCommand killCommand = new KillCommand();

	public ForthCommandAdapterFactory() {
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adapterType == IJumpHandler.class) {
			return jumpCommand;
		} else if (adapterType == IAfterHandler.class) {
			return afterCommand;
		} else if (adapterType == IKillHandler.class) {
			return killCommand;
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Class[] getAdapterList() {
		return new Class[] { IJumpExtension.class, IAfterExtension.class, IKillProcessExtension.class };
	}

}
