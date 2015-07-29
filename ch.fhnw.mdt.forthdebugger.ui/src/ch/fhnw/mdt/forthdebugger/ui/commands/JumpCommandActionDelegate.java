package ch.fhnw.mdt.forthdebugger.ui.commands;

import org.eclipse.debug.internal.ui.commands.actions.DebugCommandActionDelegate;

@SuppressWarnings("restriction")
public class JumpCommandActionDelegate extends DebugCommandActionDelegate {
	public JumpCommandActionDelegate() {
		setAction(new JumpCommandAction());
	}
}
