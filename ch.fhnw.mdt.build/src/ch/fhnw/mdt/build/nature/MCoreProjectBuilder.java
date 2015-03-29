package ch.fhnw.mdt.build.nature;

import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.cdt.core.envvar.IEnvironmentVariable;
import org.eclipse.cdt.managedbuilder.core.IManagedBuildInfo;
import org.eclipse.cdt.managedbuilder.core.ManagedBuildManager;
import org.eclipse.cdt.managedbuilder.envvar.IEnvironmentVariableProvider;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class MCoreProjectBuilder extends IncrementalProjectBuilder {

	private static final String GFORTH_PATH_VARIABLE = "GFORTHPATH";

	public static final String BUILDER_ID = "ch.fhnw.mdt.build.mcoreProjectBuilder";

	private static final String MARKER_TYPE = "ch.fhnw.mdt.build.pathProblem";

	@Override
	protected IProject[] build(final int kind, final Map<String, String> args, final IProgressMonitor monitor) throws CoreException {
		final IEnvironmentVariableProvider environmentVariableProvider = ManagedBuildManager.getEnvironmentVariableProvider();
		final IProject project = getProject();
		final IManagedBuildInfo buildInfo = ManagedBuildManager.getBuildInfo(project);
		final IEnvironmentVariable[] variables = environmentVariableProvider.getVariables(buildInfo.getManagedProject().getConfigurations()[0], true);

		project.deleteMarkers(MARKER_TYPE, false, 1);

		for (final IEnvironmentVariable environmentVariable : variables) {
			if (environmentVariable.getName().equals(GFORTH_PATH_VARIABLE)) {
				// TODO location, check if it exists, persistent?
				
				return null; // found
			}
		}

		// gforth path not found in environment
		IMarker pathNotFoundMarker = project.createMarker(MARKER_TYPE);

		pathNotFoundMarker.setAttribute(IMarker.MESSAGE, "GFORTHPATH could not be found in environment");
		pathNotFoundMarker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
		pathNotFoundMarker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
		return null;
	}

}
