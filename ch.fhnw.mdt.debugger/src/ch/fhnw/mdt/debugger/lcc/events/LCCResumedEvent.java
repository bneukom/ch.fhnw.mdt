package ch.fhnw.mdt.debugger.lcc.events;

import org.eclipse.cdt.debug.core.cdi.event.ICDIResumedEvent;
import org.eclipse.cdt.debug.core.cdi.model.ICDIObject;
import org.eclipse.cdt.debug.core.cdi.model.ICDITarget;

public class LCCResumedEvent implements ICDIResumedEvent {

	private final ICDITarget source;

	public LCCResumedEvent(ICDITarget source) {
		super();
		this.source = source;
	}

	@Override
	public ICDIObject getSource() {
		return source;
	}

	@Override
	public int getType() {
		return STEP_OVER;
	}

}
