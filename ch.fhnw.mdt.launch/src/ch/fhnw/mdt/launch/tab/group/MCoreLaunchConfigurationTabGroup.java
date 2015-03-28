package ch.fhnw.mdt.launch.tab.group;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.debug.ui.CommonTab;

import ch.fhnw.mdt.launch.tab.MCoreLaunchConfigurationTab;

public class MCoreLaunchConfigurationTabGroup extends AbstractLaunchConfigurationTabGroup {

	public MCoreLaunchConfigurationTabGroup() {
	}

	@Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		setTabs(new ILaunchConfigurationTab[] { new MCoreLaunchConfigurationTab(), new CommonTab() });
	}

}
