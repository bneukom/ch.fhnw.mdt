package ch.fhnw.mdt.forthdebugger.ui.commands.after;

import org.eclipse.debug.ui.actions.DebugCommandAction;
import org.eclipse.jface.resource.ImageDescriptor;

public class AfterCommandAction extends DebugCommandAction {

	public AfterCommandAction() {
		setActionDefinitionId("ch.fhnw.mdt.forthdebugger.ui.aftercommand");
	}

	@Override
	protected Class<?> getCommandType() {
		return IAfterHandler.class;
	}

	@Override
	public String getHelpContextId() {
		return null;
	}

	@Override
	public String getId() {
		return "ch.fhnw.mdt.forthdebugger.ui.afteraction";
	}

	@Override
	public String getText() {
		return "After";
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
