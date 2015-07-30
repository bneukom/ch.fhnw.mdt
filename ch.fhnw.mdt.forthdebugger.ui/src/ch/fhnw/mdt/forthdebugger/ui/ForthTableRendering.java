package ch.fhnw.mdt.forthdebugger.ui;

import java.math.BigInteger;

import org.eclipse.debug.core.model.MemoryByte;
import org.eclipse.debug.ui.memory.AbstractTableRendering;

public class ForthTableRendering extends AbstractTableRendering {

	public ForthTableRendering(String renderingId) {
		super(renderingId);
	}
	
	@Override
	public int getAddressableUnitPerLine() {
		return 8;
	}
	
	@Override
	public int getBytesPerLine() {
		return super.getBytesPerLine();
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
