package ch.fhnw.mdt.build.nature;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import org.eclipse.cdt.core.envvar.IEnvironmentVariable;
import org.eclipse.cdt.managedbuilder.core.IManagedBuildInfo;
import org.eclipse.cdt.managedbuilder.core.ManagedBuildManager;
import org.eclipse.cdt.managedbuilder.envvar.IEnvironmentVariableProvider;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

public class MCoreProjectBuilder extends IncrementalProjectBuilder {

	public static final String GFORTH_PATH_VARIABLE = "GFORTHPATH";

	public static final String BUILDER_ID = "ch.fhnw.mdt.build.mcoreProjectBuilder";

	private static final String MDT_PROBLEM = "ch.fhnw.mdt.build.pathProblem";

	@Override
	protected IProject[] build(final int kind, final Map<String, String> args, final IProgressMonitor monitor) throws CoreException {
		final IEnvironmentVariableProvider environmentVariableProvider = ManagedBuildManager.getEnvironmentVariableProvider();
		final IProject project = getProject();
		final IManagedBuildInfo buildInfo = ManagedBuildManager.getBuildInfo(project);
		final IEnvironmentVariable[] variables = environmentVariableProvider.getVariables(buildInfo.getManagedProject().getConfigurations()[0], true);

		project.deleteMarkers(MDT_PROBLEM, false, 1);

		for (final IEnvironmentVariable environmentVariable : variables) {
			if (environmentVariable.getName().equals(GFORTH_PATH_VARIABLE)) {
				final String value = environmentVariable.getValue();
				if (!Files.exists(Paths.get(value))) {
					IMarker invalidPath = project.createMarker(MDT_PROBLEM);
					invalidPath.setAttribute(IMarker.MESSAGE, "GFORTHPATH points to an invalid");
					invalidPath.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
					invalidPath.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
				}

				return null; // found
			}
		}

		// gforth path not found in environment
		IMarker pathNotFoundMarker = project.createMarker(MDT_PROBLEM);

		pathNotFoundMarker.setAttribute(IMarker.MESSAGE, "GFORTHPATH could not be found in environment");
		pathNotFoundMarker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
		pathNotFoundMarker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
		return null;
	}

}
