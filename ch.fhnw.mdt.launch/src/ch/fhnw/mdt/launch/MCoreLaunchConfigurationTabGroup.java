package ch.fhnw.mdt.launch;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.debug.ui.CommonTab;

public class MCoreLaunchConfigurationTabGroup extends AbstractLaunchConfigurationTabGroup {

	public MCoreLaunchConfigurationTabGroup() {
	}

	@Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		setTabs(new ILaunchConfigurationTab[] { new CommonTab() });
	}

}
