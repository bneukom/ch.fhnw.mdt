package ch.fhnw.mdt.build;
import org.eclipse.cdt.managedbuilder.core.IManagedBuildInfo;
import org.eclipse.cdt.managedbuilder.makegen.IManagedBuilderMakefileGenerator;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.MultiStatus;

// TODO with this builder, the compiler tool wont be needed anymore?
public class LCCMakeFileGenerator implements IManagedBuilderMakefileGenerator {

	private IProject project;
	private IManagedBuildInfo info;
	private IProgressMonitor monitor;

	@Override
	public void generateDependencies() throws CoreException {
		// TODO Auto-generated method stub

	}

	@Override
	public MultiStatus generateMakefiles(IResourceDelta delta) throws CoreException {
		
		// TODO walk project
		// TODO get all .c files
		// TODO get the MCore Compiler Tool for all the right output (add line like lcc-mcore -S -Q input -o output)
		
		return null;
	}

	@Override
	public IPath getBuildWorkingDir() {
		return null;
	}

	@Override
	public String getMakefileName() {
		return "makefile";
	}

	@Override
	public void initialize(IProject project, IManagedBuildInfo info, IProgressMonitor monitor) {
		this.project = project;
		this.info = info;
		this.monitor = monitor;

	}

	@Override
	public boolean isGeneratedResource(IResource resource) {
		
		// TODO implement
		
		return false;
	}

	@Override
	public void regenerateDependencies(boolean force) throws CoreException {
		// TODO what to do here?
	}

	@Override
	public MultiStatus regenerateMakefiles() throws CoreException {
		// TODO what to do here?
		return null;
	}

}
