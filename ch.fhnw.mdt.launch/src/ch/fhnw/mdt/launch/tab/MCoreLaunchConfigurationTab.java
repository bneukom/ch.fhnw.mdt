package ch.fhnw.mdt.launch.tab;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class MCoreLaunchConfigurationTab extends AbstractLaunchConfigurationTab {

	private LaunchConfigurationComposite launchConfigurationComposite;
	
	private static final String PROJECT_ATTRIBUTE = "projectName";
	private static final String EXECUTABLE_FILE_PATH = "executableFilePath";
	
	@Override
	public void createControl(Composite parent) {
		launchConfigurationComposite = new LaunchConfigurationComposite(this, parent, SWT.NONE);
		setControl(launchConfigurationComposite);
	}
	
	/**
	 * Updates the launch configuration dialog.
	 */
	public void update() {
		updateLaunchConfigurationDialog();
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			launchConfigurationComposite.setProject(configuration.getAttribute(PROJECT_ATTRIBUTE, ""));
			launchConfigurationComposite.setExecutableFile(configuration.getAttribute(EXECUTABLE_FILE_PATH, ""));
			
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(PROJECT_ATTRIBUTE, launchConfigurationComposite.getProjectName());
		configuration.setAttribute(EXECUTABLE_FILE_PATH, launchConfigurationComposite.getExecutableFilePath());
	}
	
	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		// TODO implement
		return super.isValid(launchConfig);
	}

	@Override
	public String getName() {
		return "Target";
	}

}
