package ch.fhnw.mdt.build;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

public class MDTProjectBuilder extends IncrementalProjectBuilder {

	public MDTProjectBuilder() {
	}

	@Override
	protected IProject[] build(int kind, Map<String, String> args, IProgressMonitor monitor) throws CoreException {
		// TODO see GNUMAkefileChecker
		
		
		return null;
	}

}
