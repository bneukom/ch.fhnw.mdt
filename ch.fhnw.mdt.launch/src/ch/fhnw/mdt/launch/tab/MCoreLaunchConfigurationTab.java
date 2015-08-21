package ch.fhnw.mdt.launch.tab;

import org.eclipse.cdt.debug.core.ICDTLaunchConfigurationConstants;
import org.eclipse.cdt.launch.ui.CLaunchConfigurationTab;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import ch.fhnw.mdt.forthdebugger.debugmodel.IForthConstants;

public class MCoreLaunchConfigurationTab extends CLaunchConfigurationTab {

	private LaunchConfigurationComposite launchConfigurationComposite;

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
			launchConfigurationComposite.setProject(configuration.getAttribute(IForthConstants.ATTR_PROJECT, ""));
			launchConfigurationComposite.setExecutableFile(configuration.getAttribute(IForthConstants.ATTR_FORTH_EXECUTABLE_FILE, ""));

		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(IForthConstants.ATTR_PROJECT, launchConfigurationComposite.getProjectName());
		configuration.setAttribute(IForthConstants.ATTR_FORTH_EXECUTABLE_FILE, launchConfigurationComposite.getExecutableFilePath());
		configuration.setAttribute(DebugPlugin.ATTR_PROCESS_FACTORY_ID, "ch.fhnw.mdt.forthdebugger.forthprocessfactory");

		if (launchConfigurationComposite.getExecutableFile() != null) {
			configuration.setAttribute(ICDTLaunchConfigurationConstants.ATTR_PROGRAM_NAME, launchConfigurationComposite.getExecutableFile().getName());
		}
	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		return super.isValid(launchConfig);
	}

	@Override
	public String getName() {
		return "Target";
	}

}
