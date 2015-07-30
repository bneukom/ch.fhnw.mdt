package ch.fhnw.mdt.forthdebugger.ui.commands.after;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.IRequest;
import org.eclipse.debug.core.commands.AbstractDebugCommand;
import org.eclipse.debug.core.commands.IEnabledStateRequest;

import ch.fhnw.mdt.forthdebugger.debugmodel.extensions.IAfterExtension;

public class AfterCommand extends AbstractDebugCommand implements IAfterHandler {

	@Override
	protected void doExecute(Object[] targets, IProgressMonitor monitor, IRequest request) throws CoreException {
		final IAfterExtension thread = (IAfterExtension) targets[0];

		thread.after();
	}

	@Override
	protected boolean isExecutable(Object[] targets, IProgressMonitor monitor, IEnabledStateRequest request) throws CoreException {
		final IAfterExtension thread = (IAfterExtension) targets[0];
		return thread.canAfter();
	}

	@Override
	protected Object getTarget(Object element) {
		return element;
	}

}
