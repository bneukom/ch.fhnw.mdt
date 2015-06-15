package ch.fhnw.mdt.debugger.lcc;

import java.io.File;

import org.eclipse.cdt.core.IBinaryParser.IBinaryObject;
import org.eclipse.cdt.debug.core.ICDIDebugger2;
import org.eclipse.cdt.debug.core.cdi.ICDISession;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;

// TODO use https://wiki.eclipse.org/CDT/cdt-debug-dsf-gdb-extensibility ??
// TODO use mi commands?
public class LCCDebugger implements ICDIDebugger2 {

	public LCCDebugger() {
	}

	@Override
	public ICDISession createSession(ILaunch launch, File executable, IProgressMonitor monitor) throws CoreException {
		return new LCCSession();
	}

	@Override
	public ICDISession createDebuggerSession(ILaunch launch, IBinaryObject exe, IProgressMonitor monitor) throws CoreException {
		return new LCCSession();
	}


}
