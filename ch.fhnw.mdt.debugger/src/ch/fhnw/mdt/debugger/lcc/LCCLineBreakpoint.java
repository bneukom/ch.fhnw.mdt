package ch.fhnw.mdt.debugger.lcc;

import java.math.BigInteger;

import org.eclipse.cdt.debug.core.cdi.CDIException;
import org.eclipse.cdt.debug.core.cdi.ICDICondition;
import org.eclipse.cdt.debug.core.cdi.ICDILocator;
import org.eclipse.cdt.debug.core.cdi.model.ICDILineBreakpoint;
import org.eclipse.cdt.debug.core.cdi.model.ICDITarget;

public class LCCLineBreakpoint implements ICDILineBreakpoint {

	private final String file;
	private final String function;
	private final BigInteger address;
	private final int lineNumber;
	private final ICDITarget target;
	private boolean enabled;

	public LCCLineBreakpoint(String file, String function, BigInteger address, int lineNumber, ICDITarget target) {
		this.file = file;
		this.function = function;
		this.address = address;
		this.lineNumber = lineNumber;
		this.target = target;
	}

	@Override
	public ICDILocator getLocator() {
		return new LCCLocator(file, function, address, lineNumber);
	}

	@Override
	public boolean isTemporary() {
		return false;
	}

	@Override
	public boolean isHardware() {
		return false;
	}

	@Override
	public boolean isEnabled() throws CDIException {
		return enabled;
	}

	@Override
	public void setEnabled(boolean enabled) throws CDIException {
		this.enabled = enabled;
	}

	@Override
	public ICDICondition getCondition() throws CDIException {
		return null;
	}

	@Override
	public void setCondition(ICDICondition condition) throws CDIException {

	}

	@Override
	public ICDITarget getTarget() {
		return target;
	}

}