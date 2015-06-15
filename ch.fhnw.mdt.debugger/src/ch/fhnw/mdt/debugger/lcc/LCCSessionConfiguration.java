package ch.fhnw.mdt.debugger.lcc;

import org.eclipse.cdt.debug.core.cdi.ICDISession;
import org.eclipse.cdt.debug.core.cdi.ICDISessionConfiguration;

public class LCCSessionConfiguration implements ICDISessionConfiguration {

	@Override
	public ICDISession getSession() {
		return null;
	}

	@Override
	public boolean terminateSessionOnExit() {
		// TODO Auto-generated method stub
		return false;
	}

}
