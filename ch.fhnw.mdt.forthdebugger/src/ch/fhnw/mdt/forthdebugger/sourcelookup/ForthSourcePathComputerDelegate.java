package ch.fhnw.mdt.forthdebugger.sourcelookup;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.sourcelookup.ISourceContainer;
import org.eclipse.debug.core.sourcelookup.ISourcePathComputerDelegate;
import org.eclipse.debug.core.sourcelookup.containers.WorkspaceSourceContainer;

/**
 * Computes the default source lookup path for a PDA launch configuration. The default source lookup path is the folder or project containing the PDA program being launched. If the
 * program is not specified, the workspace is searched by default.
 */
public class ForthSourcePathComputerDelegate implements ISourcePathComputerDelegate {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.internal.core.sourcelookup.ISourcePathComputerDelegate#computeSourceContainers(org.eclipse.debug.core.ILaunchConfiguration,
	 * org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public ISourceContainer[] computeSourceContainers(ILaunchConfiguration configuration, IProgressMonitor monitor) throws CoreException {
		ISourceContainer sourceContainer = null;
		// TODO implement how?
		// String path = configuration.getAttribute(IMDTConstants.ATTR_PDA_PROGRAM, (String)null);
		// if (path != null) {
		// IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(path));
		// if (resource != null) {
		// IContainer container = resource.getParent();
		// if (container.getType() == IResource.PROJECT) {
		// sourceContainer = new ProjectSourceContainer((IProject)container, false);
		// } else if (container.getType() == IResource.FOLDER) {
		// sourceContainer = new FolderSourceContainer(container, false);
		// }
		// }
		// }
		if (sourceContainer == null) {
			sourceContainer = new WorkspaceSourceContainer();
		}
		return new ISourceContainer[] { sourceContainer };
	}
}
