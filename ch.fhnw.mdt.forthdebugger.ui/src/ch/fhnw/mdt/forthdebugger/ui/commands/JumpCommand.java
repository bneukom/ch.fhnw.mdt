package ch.fhnw.mdt.forthdebugger.ui.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.IRequest;
import org.eclipse.debug.core.commands.AbstractDebugCommand;
import org.eclipse.debug.core.commands.IEnabledStateRequest;

import ch.fhnw.mdt.forthdebugger.debugmodel.ForthThread;
import ch.fhnw.mdt.forthdebugger.debugmodel.IJumpExtension;

public class JumpCommand extends AbstractDebugCommand implements IJumpHandler {

	@Override
	protected void doExecute(Object[] targets, IProgressMonitor monitor, IRequest request) throws CoreException {
		final IJumpExtension thread = (IJumpExtension) targets[0];
		
		thread.jump();
	}

	@Override
	protected boolean isExecutable(Object[] targets, IProgressMonitor monitor, IEnabledStateRequest request) throws CoreException {
		final IJumpExtension thread = (IJumpExtension) targets[0];
		return thread.canJump();
	}

	@Override
	protected Object getTarget(Object element) {
		return element;
	}

}
