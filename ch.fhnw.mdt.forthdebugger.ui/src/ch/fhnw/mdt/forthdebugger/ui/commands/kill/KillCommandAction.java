package ch.fhnw.mdt.forthdebugger.ui.commands.kill;

import org.eclipse.debug.ui.actions.DebugCommandAction;
import org.eclipse.jface.resource.ImageDescriptor;

public class KillCommandAction extends DebugCommandAction {

	public KillCommandAction() {
		setActionDefinitionId("ch.fhnw.mdt.forthdebugger.ui.killcommand");
	}

	@Override
	protected Class<?> getCommandType() {
		return IKillHandler.class;
	}

	@Override
	public String getHelpContextId() {
		return "ch.fhnw.mdt.forthdebugger.ui.killaction";
	}

	@Override
	public String getId() {
		return null;
	}

	@Override
	public String getText() {
		return "kill";
	}

	@Override
	public String getToolTipText() {
		return null;
	}

	@Override
	public ImageDescriptor getDisabledImageDescriptor() {
		return null;
	}

	@Override
	public ImageDescriptor getHoverImageDescriptor() {
		return null;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return null;
	}

}
