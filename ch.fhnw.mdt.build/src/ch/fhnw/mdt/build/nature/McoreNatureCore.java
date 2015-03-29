package ch.fhnw.mdt.build.nature;

import java.util.Arrays;

import org.eclipse.cdt.managedbuilder.core.IManagedBuildInfo;
import org.eclipse.cdt.managedbuilder.core.ManagedBuildManager;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;

import ch.fhnw.mdt.build.Activator;

public class McoreNatureCore {

	public static final String MCORE_EXECUTABLE_NAME = "MCore Executable";

	/**
	 * Initializes the MCore Nature. MCore Natures will be added to all
	 * {@link IProject} added to the workspace with an MCore Tool-Chain set.
	 */
	public static void initialize() {
		ResourcesPlugin.getWorkspace().addResourceChangeListener(new IResourceChangeListener() {

			@Override
			public void resourceChanged(final IResourceChangeEvent event) {
				final IResource resource = event.getResource();

				if (event.getDelta().getKind() == IResourceDelta.CHANGED) {
					final IResourceDelta[] affectedChildren = event.getDelta().getAffectedChildren();
					if (affectedChildren.length > 0) {
						final IResource affectedResource = event.getDelta().getAffectedChildren()[0].getResource();

						final IManagedBuildInfo buildInfo = ManagedBuildManager.getBuildInfo(affectedResource);

						if (buildInfo.getManagedProject().getName().equals(MCORE_EXECUTABLE_NAME)) {
							final IProject project = (IProject) affectedResource;

							final WorkspaceJob job = new WorkspaceJob("Add Mcore Nature") {

								@Override
								public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
									addMCoreNature(project);
									
									return new Status(IStatus.OK, Activator.PLUGIN_ID, null);
								}
							};

							job.schedule();

						}
					}
				}
			}
		}, IResourceChangeEvent.POST_CHANGE);
	}

	private static void addMCoreNature(final IProject project) throws CoreException {
		final IProjectDescription description = project.getDescription();
		final String[] natures = description.getNatureIds();

		// check if it has already been added
		if (Arrays.stream(natures).anyMatch(nature -> nature.equals(MCoreNature.NATURE_ID))) {
			return;
		}
		
		final String[] newNatures = new String[natures.length + 1];
		System.arraycopy(natures, 0, newNatures, 0, natures.length);
		newNatures[natures.length] = MCoreNature.NATURE_ID;
		description.setNatureIds(newNatures);
		project.setDescription(description, null);

	}
}