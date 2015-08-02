package ch.fhnw.mdt.forthdebugger.ui.commands.kill;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.IRequest;
import org.eclipse.debug.core.commands.AbstractDebugCommand;
import org.eclipse.debug.core.commands.IEnabledStateRequest;

import ch.fhnw.mdt.forthdebugger.debugmodel.extensions.IJumpExtension;
import ch.fhnw.mdt.forthdebugger.debugmodel.extensions.IKillProcessExtension;

public class KillCommand extends AbstractDebugCommand implements IKillHandler {

	@Override
	protected void doExecute(Object[] targets, IProgressMonitor monitor, IRequest request) throws CoreException {
		final IKillProcessExtension thread = (IKillProcessExtension) targets[0];
		
		thread.kill();
	}

	@Override
	protected boolean isExecutable(Object[] targets, IProgressMonitor monitor, IEnabledStateRequest request) throws CoreException {
		final IKillProcessExtension thread = (IKillProcessExtension) targets[0];
		return thread.canKill();
	}

	@Override
	protected Object getTarget(Object element) {
		return element;
	}

}
