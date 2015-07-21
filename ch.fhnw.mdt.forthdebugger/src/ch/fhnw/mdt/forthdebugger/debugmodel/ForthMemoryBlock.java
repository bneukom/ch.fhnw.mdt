package ch.fhnw.mdt.forthdebugger.debugmodel;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IMemoryBlock;

public class ForthMemoryBlock extends ForthDebugElement implements IMemoryBlock {

	public ForthMemoryBlock(ForthDebugTarget target) {
		super(target);
	}

	@Override
	public long getStartAddress() {
		return 0;
	}

	@Override
	public long getLength() {
		return 10;
	}

	@Override
	public byte[] getBytes() throws DebugException {
		return new byte[] { 43, 10, 100, 5, 10, 0, 7, 44, 2, 73 };
	}

	@Override
	public boolean supportsValueModification() {
		return false;
	}

	@Override
	public void setValue(long offset, byte[] bytes) throws DebugException {

	}

}
