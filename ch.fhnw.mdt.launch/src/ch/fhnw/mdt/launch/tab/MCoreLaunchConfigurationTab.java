package ch.fhnw.mdt.launch.tab;

import org.eclipse.cdt.debug.core.ICDTLaunchConfigurationConstants;
import org.eclipse.cdt.launch.ui.CLaunchConfigurationTab;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class MCoreLaunchConfigurationTab extends CLaunchConfigurationTab {

	private LaunchConfigurationComposite launchConfigurationComposite;
	/**
	 * Property for the project name of the project to be launched.
	 */
	public static final String PROJECT_ATTRIBUTE = "projectName";
	
	/**
	 * Property for the file name to be executed. 
	 */
	public static final String EXECUTABLE_FILE_PATH = "executableFilePath";
	
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
	
		// TODO make configurabele!
		configuration.setAttribute(ICDTLaunchConfigurationConstants.ATTR_DEBUGGER_ID, "ch.fhnw.mdt.debugger.lccdebugger");
		configuration.setAttribute(ICDTLaunchConfigurationConstants.ATTR_PROGRAM_NAME, "hello.c");
		configuration.setAttribute(ICDTLaunchConfigurationConstants.ATTR_PLATFORM, "linux");

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
