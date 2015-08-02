package ch.fhnw.mdt.forthdebugger.ui.commands.kill;

import org.eclipse.debug.ui.actions.DebugCommandHandler;

public class KillCommandHandler extends DebugCommandHandler {

	@Override
	protected Class<?> getCommandType() {
		return IKillHandler.class;
	}

}
