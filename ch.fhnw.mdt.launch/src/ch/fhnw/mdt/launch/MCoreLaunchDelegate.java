package ch.fhnw.mdt.launch;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;

import ch.fhnw.mdt.launch.tab.MCoreLaunchConfigurationTab;

// TODO implement ILaunchShortcut
public class MCoreLaunchDelegate extends LaunchConfigurationDelegate {

	@Override
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
		MCoreLauncher.launch(launch);		
	}
}
