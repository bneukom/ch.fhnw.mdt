package ch.fhnw.mdt.build;

import org.eclipse.cdt.core.IMarkerGenerator;
import org.eclipse.cdt.core.resources.IConsole;
import org.eclipse.cdt.managedbuilder.core.IBuilder;
import org.eclipse.cdt.managedbuilder.core.IConfiguration;
import org.eclipse.cdt.managedbuilder.core.InternalBuildRunner;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;

public class LCCBuildRunner extends InternalBuildRunner {
	@Override
	public boolean invokeBuild(int kind, IProject project, IConfiguration configuration, IBuilder builder, IConsole console, IMarkerGenerator markerGenerator,
			IncrementalProjectBuilder projectBuilder, IProgressMonitor monitor) throws CoreException {

		final IPath buildPath = builder.getBuildLocation();
		final IResource buildLocationResource = ResourcesPlugin.getWorkspace().getRoot()
				.findMember(buildPath.makeRelativeTo(ResourcesPlugin.getWorkspace().getRoot().getLocation()));

		// TODO don't do this always!
		// remove old files
//		if (buildLocationResource != null) {
//			buildLocationResource.accept((res) -> {
//				if (!res.equals(buildLocationResource)) {
//					res.delete(true, monitor);
//				}
//				return true;
//			});
//		}

		// build project
		super.invokeBuild(kind, project, configuration, builder, console, markerGenerator, projectBuilder, monitor);

		// rename output files
		if (buildLocationResource != null) {
			buildLocationResource.accept((res) -> {
				if (res instanceof IFile) {
					final IFile file = (IFile) res;
					if (file.getFileExtension().equals("s")) {
						final IPath newFilePath = file.getFullPath().removeFileExtension().addFileExtension("fs");
						final IFile newFile = ResourcesPlugin.getWorkspace().getRoot().getFile(newFilePath);
						if (newFile.exists()) {
							newFile.delete(true, monitor);
						}
						file.move(newFilePath, true, monitor);
					}
					return false;
				}

				return true;
			});
		}

		return false;

	}
}
