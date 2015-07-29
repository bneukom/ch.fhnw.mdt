package ch.fhnw.mdt.forthdebugger.ui.commands;

import org.eclipse.debug.ui.actions.DebugCommandAction;
import org.eclipse.jface.resource.ImageDescriptor;

public class JumpCommandAction extends DebugCommandAction {

	public JumpCommandAction() {
		setActionDefinitionId("ch.fhnw.mdt.forthdebugger.ui.jumpcommand");
	}

	@Override
	protected Class<?> getCommandType() {
		return IJumpHandler.class;
	}

	@Override
	public String getHelpContextId() {
		return null;
	}

	@Override
	public String getId() {
		return null;
	}

	@Override
	public String getText() {
		return "jump";
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
