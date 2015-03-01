package ch.fhnw.mdt.build;
import java.io.OutputStream;
import java.util.Properties;

import org.eclipse.cdt.core.ICommandLauncher;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;


public class MCoreCommandLauncher implements ICommandLauncher {

	public MCoreCommandLauncher() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setProject(IProject project) {
		
	}

	@Override
	public IProject getProject() {
		return null;
	}

	@Override
	public void showCommand(boolean show) {
		
	}

	@Override
	public String getErrorMessage() {
		return null;
	}

	@Override
	public void setErrorMessage(String error) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[] getCommandArgs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Properties getEnvironment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCommandLine() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Process execute(IPath commandPath, String[] args, String[] env,
			IPath workingDirectory, IProgressMonitor monitor)
			throws CoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int waitAndRead(OutputStream out, OutputStream err) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int waitAndRead(OutputStream output, OutputStream err,
			IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		return 0;
	}

}
