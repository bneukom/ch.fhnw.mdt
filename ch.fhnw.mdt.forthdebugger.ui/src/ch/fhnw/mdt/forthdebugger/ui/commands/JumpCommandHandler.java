package ch.fhnw.mdt.forthdebugger.ui.commands;

import org.eclipse.debug.ui.actions.DebugCommandHandler;

public class JumpCommandHandler extends DebugCommandHandler {

	@Override
	protected Class<?> getCommandType() {
		return IJumpHandler.class;
	}

}
