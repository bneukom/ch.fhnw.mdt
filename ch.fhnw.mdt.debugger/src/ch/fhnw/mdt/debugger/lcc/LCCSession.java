package ch.fhnw.mdt.debugger.lcc;

import org.eclipse.cdt.debug.core.cdi.CDIException;
import org.eclipse.cdt.debug.core.cdi.ICDIEventManager;
import org.eclipse.cdt.debug.core.cdi.ICDISession;
import org.eclipse.cdt.debug.core.cdi.ICDISessionConfiguration;
import org.eclipse.cdt.debug.core.cdi.model.ICDITarget;

public class LCCSession implements ICDISession {

	private final LCCTarget target ;
	private final LCCEventManager eventManager;
	
	public LCCSession() {
		eventManager = new LCCEventManager(this);
		target = new LCCTarget(this);
	}
	
	@Override
	public ICDITarget[] getTargets() {
		return new ICDITarget[] { target };
	}

	@Override
	public void setAttribute(String key, String value) {
	}

	@Override
	public String getAttribute(String key) {
		return "";
	}

	@Override
	public ICDIEventManager getEventManager() {
		return eventManager;
	}
	
	public LCCEventManager getLCCEventManager() {
		return eventManager;
	}

	@Override
	public ICDISessionConfiguration getConfiguration() {
		return null;
	}

	@Override
	public void terminate() throws CDIException {

	}

	@Override
	public Process getSessionProcess() throws CDIException {
		return target.getProcess();
	}

}
