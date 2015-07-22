package ch.fhnw.mdt.forthdebugger.debugmodel;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IMemoryBlock;

public class ForthMemoryBlock extends ForthDebugElement implements IMemoryBlock {

	// 00000000: 12 0 7 3B6 10127 5 9 9
	// 00000008: 38F 2 33D 0 2 0 0 0
	private final byte[] memory = new byte[100];
	private long startAddress;
	private long length;

	public ForthMemoryBlock(ForthDebugTarget target, long startAddress, long length, int[] values) {
		super(target);
		this.startAddress = startAddress;
		this.length = length;

		for (int valueIndex = 0; valueIndex < values.length; ++valueIndex) {

			int offset = valueIndex * 4;
			int value = values[valueIndex];
			memory[offset + 0] = (byte) (value >>> 24);
			memory[offset + 1] = (byte) (value >>> 16);
			memory[offset + 2] = (byte) (value >>> 8);
			memory[offset + 3] = (byte) value;
		}

	}
	/*
	 * addInt(0x12, 0); addInt(0x0, 4); addInt(0x7, 8); addInt(0x3B6, 12);
	 * addInt(0x10127, 16); addInt(0x5, 20); addInt(0x9, 24); addInt(0x9, 28);
	 * addInt(0x38F, 32); addInt(0x2, 36); /* }
	 * 
	 * /* private void addInt(int value, int offset) { byte[] array =
	 * ByteBuffer.allocate(4).putInt(value).array(); memory[offset + 0] =
	 * array[0]; memory[offset + 1] = array[1]; memory[offset + 2] = array[2];
	 * memory[offset + 3] = array[3];
	 * 
	 * }
	 */
	@Override
	public long getStartAddress() {
		return startAddress;
	}

	@Override
	public long getLength() {
		return length;
	}

	@Override
	public byte[] getBytes() throws DebugException {
		return memory;
	}

	@Override
	public boolean supportsValueModification() {
		return false;
	}

	@Override
	public void setValue(long offset, byte[] bytes) throws DebugException {

	}

}
