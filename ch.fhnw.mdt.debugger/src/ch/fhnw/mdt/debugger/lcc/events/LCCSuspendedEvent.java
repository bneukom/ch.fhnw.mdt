package ch.fhnw.mdt.debugger.lcc.events;

import org.eclipse.cdt.debug.core.cdi.ICDIBreakpointHit;
import org.eclipse.cdt.debug.core.cdi.ICDISession;
import org.eclipse.cdt.debug.core.cdi.ICDISessionObject;
import org.eclipse.cdt.debug.core.cdi.event.ICDISuspendedEvent;
import org.eclipse.cdt.debug.core.cdi.model.ICDIBreakpoint;
import org.eclipse.cdt.debug.core.cdi.model.ICDIObject;

import ch.fhnw.mdt.debugger.lcc.LCCSession;
import ch.fhnw.mdt.debugger.lcc.LCCTarget;

public class LCCSuspendedEvent implements ICDISuspendedEvent {

	private final LCCSession session;
	private final LCCTarget target;

	public LCCSuspendedEvent(LCCSession session, LCCTarget target) {
		super();
		this.session = session;
		this.target = target;
	}

	@Override
	public ICDIObject getSource() {
		return target;
	}

	@Override
	public ICDISessionObject getReason() {
		return new LCCBreakpointHitEvent(session);
	}
	
	private static class LCCBreakpointHitEvent implements ICDIBreakpointHit {

		private final LCCSession session;
		
		
		public LCCBreakpointHitEvent(LCCSession session) {
			super();
			this.session = session;
		}

		@Override
		public ICDISession getSession() {
			return session;
		}

		@Override
		public ICDIBreakpoint getBreakpoint() {
			return null;
		}

		
	}

}
