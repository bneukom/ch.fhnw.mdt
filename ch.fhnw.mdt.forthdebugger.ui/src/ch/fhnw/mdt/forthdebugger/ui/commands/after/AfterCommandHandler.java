package ch.fhnw.mdt.forthdebugger.ui.commands.after;

import org.eclipse.debug.ui.actions.DebugCommandHandler;

public class AfterCommandHandler extends DebugCommandHandler {

	@Override
	protected Class<?> getCommandType() {
		return IAfterHandler.class;
	}

}
