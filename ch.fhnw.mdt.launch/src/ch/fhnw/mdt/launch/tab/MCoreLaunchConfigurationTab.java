package ch.fhnw.mdt.launch.tab;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class MCoreLaunchConfigurationTab extends AbstractLaunchConfigurationTab {

	private LaunchConfigurationComposite launchConfigurationComposite;
	
	@Override
	public void createControl(Composite parent) {
		launchConfigurationComposite = new LaunchConfigurationComposite(parent, SWT.NONE);
		setControl(launchConfigurationComposite);
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {

	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {

	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {

	}

	@Override
	public String getName() {
		return "Target";
	}

}
