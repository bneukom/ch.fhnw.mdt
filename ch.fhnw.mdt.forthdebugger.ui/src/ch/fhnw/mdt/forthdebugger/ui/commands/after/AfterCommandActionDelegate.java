package ch.fhnw.mdt.forthdebugger.ui.commands.after;

import org.eclipse.debug.internal.ui.commands.actions.DebugCommandActionDelegate;

@SuppressWarnings("restriction")
public class AfterCommandActionDelegate extends DebugCommandActionDelegate {
	public AfterCommandActionDelegate() {
		setAction(new AfterCommandAction());
	}
}
