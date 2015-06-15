package ch.fhnw.mdt.debugger.lcc;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.cdt.debug.core.cdi.ICDIEventManager;
import org.eclipse.cdt.debug.core.cdi.ICDISession;
import org.eclipse.cdt.debug.core.cdi.event.ICDIEvent;
import org.eclipse.cdt.debug.core.cdi.event.ICDIEventListener;

class LCCEventManager implements ICDIEventManager {

	private LCCSession session;
	private List<ICDIEventListener> listeners = new ArrayList<ICDIEventListener>();

	public LCCEventManager(LCCSession session) {
		super();
		this.session = session;
	}

	@Override
	public ICDISession getSession() {
		return session;
	}

	@Override
	public void addEventListener(ICDIEventListener listener) {
		listeners.add(listener);
	}

	@Override
	public void removeEventListener(ICDIEventListener listener) {
		listeners.remove(listener);
	}

	public void fireEvent(ICDIEvent event) {
		listeners.forEach(e -> e.handleDebugEvents(new ICDIEvent[] { event }));
	}

}