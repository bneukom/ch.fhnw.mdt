package ch.fhnw.mdt.forthdebugger.ui.commands.kill;

import org.eclipse.debug.internal.ui.commands.actions.DebugCommandActionDelegate;

@SuppressWarnings("restriction")
public class KillCommandActionDelegate extends DebugCommandActionDelegate {
	public KillCommandActionDelegate() {
		setAction(new KillCommandAction());
	}
}
