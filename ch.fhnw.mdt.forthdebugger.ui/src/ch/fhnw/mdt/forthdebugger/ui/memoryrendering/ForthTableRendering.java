package ch.fhnw.mdt.forthdebugger.ui.memoryrendering;

import java.math.BigInteger;

import org.eclipse.debug.core.model.MemoryByte;
import org.eclipse.debug.ui.memory.AbstractTableRendering;

public class ForthTableRendering extends AbstractTableRendering {

	public ForthTableRendering(String renderingId) {
		super(renderingId);
	}
	
	@Override
	public int getAddressableUnitPerLine() {
		return 1;
	}
	
	@Override
	public int getAddressableSize() {
		return 1;
	}
	
	@Override
	public int getBytesPerColumn() {
		return 1;
	}
	
	@Override
	public int getAddressableUnitPerColumn() {
		return 1;
	}
	
	@Override
	public int getBytesPerLine() {
		return 32;
	}

	@Override
	public String getString(String renderingTypeId, BigInteger address, MemoryByte[] data) {
		return "lol";
	}

	@Override
	public byte[] getBytes(String renderingTypeId, BigInteger address, MemoryByte[] currentValues, String newValue) {
		return new byte[0];
	}

}
