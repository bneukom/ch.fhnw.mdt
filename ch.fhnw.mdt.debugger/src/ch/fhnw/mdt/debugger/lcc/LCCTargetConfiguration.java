package ch.fhnw.mdt.debugger.lcc;

import org.eclipse.cdt.debug.core.cdi.event.ICDIEvent;
import org.eclipse.cdt.debug.core.cdi.model.ICDITarget;
import org.eclipse.cdt.debug.core.cdi.model.ICDITargetConfiguration3;

public class LCCTargetConfiguration implements ICDITargetConfiguration3 {

	private LCCTarget target;

	public LCCTargetConfiguration(LCCTarget target) {
		super();
		this.target = target;
	}

	@Override
	public boolean supportsThreadControl() {
		return false;
	}

	@Override
	public boolean supportsPassiveVariableUpdate() {
		return false;
	}

	@Override
	public boolean supportsRuntimeTypeIdentification() {
		return false;
	}

	@Override
	public boolean supportsAddressBreaksOnStartup() {
		return false;
	}

	@Override
	public boolean supportsTerminate() {
		return true;
	}

	@Override
	public boolean supportsDisconnect() {
		return false;
	}

	@Override
	public boolean supportsSuspend() {
		return true;
	}

	@Override
	public boolean supportsResume() {
		return true;
	}

	@Override
	public boolean supportsRestart() {
		return false;
	}

	@Override
	public boolean supportsStepping() {
		return true;
	}

	@Override
	public boolean supportsInstructionStepping() {
		return false;
	}

	@Override
	public boolean supportsBreakpoints() {
		return true;
	}

	@Override
	public boolean supportsRegisters() {
		return false;
	}

	@Override
	public boolean supportsRegisterModification() {
		return false;
	}

	@Override
	public boolean supportsSharedLibrary() {
		return false;
	}

	@Override
	public boolean supportsMemoryRetrieval() {
		return true;
	}

	@Override
	public boolean supportsMemoryModification() {
		return false;
	}

	@Override
	public boolean supportsExpressionEvaluation() {
		return true;
	}

	@Override
	public ICDITarget getTarget() {
		return target;
	}

	@Override
	public boolean needsVariablesUpdated(ICDIEvent event) {
		return false;
	}

	@Override
	public boolean needsRegistersUpdated(ICDIEvent event) {
		return false;
	}

}
