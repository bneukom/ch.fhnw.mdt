package ch.fhnw.mdt.build.nature;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import org.eclipse.cdt.core.envvar.IEnvironmentVariable;
import org.eclipse.cdt.managedbuilder.core.IConfiguration;
import org.eclipse.cdt.managedbuilder.core.IManagedBuildInfo;
import org.eclipse.cdt.managedbuilder.core.ManagedBuildManager;
import org.eclipse.cdt.managedbuilder.envvar.IEnvironmentVariableProvider;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import ch.fhnw.mdt.platform.IPlatformStrings;
import ch.fhnw.mdt.platform.MDTPlatformPlugin;

public class MCoreProjectBuilder extends IncrementalProjectBuilder {

	public static final String GFORTH_PATH_VARIABLE = "GFORTHPATH";

	public static final String BUILDER_ID = "ch.fhnw.mdt.build.mcoreProjectBuilder";

	private static final String MDT_PROBLEM = "ch.fhnw.mdt.build.pathProblem";

	private final IPlatformStrings platformStrings = MDTPlatformPlugin.getDefault().getPlatformStrings();
	
	@Override
	protected IProject[] build(final int kind, final Map<String, String> args, final IProgressMonitor monitor) throws CoreException {
		final IEnvironmentVariableProvider environmentVariableProvider = ManagedBuildManager.getEnvironmentVariableProvider();
		final IProject project = getProject();
		final IManagedBuildInfo buildInfo = ManagedBuildManager.getBuildInfo(project);
		final String separator = MDTPlatformPlugin.getDefault().getPlatformStrings().getEnvironmentSeparators();

		project.deleteMarkers(MDT_PROBLEM, false, 1);

		final IConfiguration buildConfig = buildInfo.getManagedProject().getConfigurations()[0];
		final String path = environmentVariableProvider.getVariable("PATH", buildInfo.getManagedProject().getConfigurations()[0], true).getValue();
		
		if (!isInResolvedPath(path, "lcc-mcore", environmentVariableProvider, buildConfig)) {
			final IMarker invalidPath = project.createMarker(MDT_PROBLEM);
			invalidPath.setAttribute(IMarker.MESSAGE, "lcc-mcore not found in PATH=" + path);
			invalidPath.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
			invalidPath.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
		}
		
		final IEnvironmentVariable gforthPathVar = environmentVariableProvider.getVariable(GFORTH_PATH_VARIABLE, buildConfig, true);
		if (gforthPathVar != null) {
			final String gforthPath = gforthPathVar.getValue();
			final String[] gforthPaths = gforthPath.split(separator);
			final String workspace = gforthPaths[gforthPaths.length - 1];
			if (!Files.exists(Paths.get(workspace))) {
				final IMarker invalidPath = project.createMarker(MDT_PROBLEM);
				invalidPath.setAttribute(IMarker.MESSAGE, "The last location (" + workspace + ") GFORTHPATH=" + gforthPath + " points to an invalid location.");
				invalidPath.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
				invalidPath.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
			}

		} else {
			final IMarker pathNotFoundMarker = project.createMarker(MDT_PROBLEM);

			pathNotFoundMarker.setAttribute(IMarker.MESSAGE, "GFORTHPATH could not be found in environment.");
			pathNotFoundMarker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
			pathNotFoundMarker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
		}

		return null;
	}

	private boolean isInResolvedPath(final String path, final String file, final IEnvironmentVariableProvider environmentVariableProvider, final IConfiguration config) {
		final String separator = platformStrings.getEnvironmentSeparators();
		final String[] paths = path.split(separator);
		for (final String subPath : paths) {
			if (platformStrings.isPathVariable(subPath)) {
				final IEnvironmentVariable variable = environmentVariableProvider.getVariable(platformStrings.getVariableName(subPath), config, true);
				if (variable != null) {
					final boolean isInResolvedPath = isInResolvedPath(variable.getValue(), file, environmentVariableProvider, config);
					if (isInResolvedPath) {
						return true;
					}
				}
			} else {
				if (Files.exists(Paths.get(subPath, file))) {
					return true;
				}
			}
		}
		
		
		return false;
	}

}
