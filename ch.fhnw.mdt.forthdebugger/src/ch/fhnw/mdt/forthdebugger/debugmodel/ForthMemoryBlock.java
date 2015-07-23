package ch.fhnw.mdt.forthdebugger.debugmodel;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IMemoryBlock;

import ch.fhnw.mdt.forthdebugger.communication.ForthCommunicator;
import ch.fhnw.mdt.forthdebugger.communication.ForthCommunicator.ForthCommandQueue;

public class ForthMemoryBlock extends ForthDebugElement implements IMemoryBlock {

	// 00000000: 12 0 7 3B6 10127 5 9 9
	// 00000008: 38F 2 33D 0 2 0 0 0
	private final byte[] memory = new byte[100];
	private long startAddress;
	private long length;
	private ForthCommunicator forthCommunicator;

	public ForthMemoryBlock(ForthDebugTarget target, long startAddress, long length, ForthCommunicator forthCommunicator) {
		super(target);
		this.forthCommunicator = forthCommunicator;

		this.startAddress = startAddress;
		this.length = length;

		loadMemory();
	}

	private void loadMemory() {

		forthCommunicator.awaitReadCompletion();

		forthCommunicator.sendCommandAwaitResult(String.valueOf(startAddress) + " " + String.valueOf(length) + " dump" + ForthCommunicator.NL,
				forthCommunicator.waitForResultLater(ForthCommunicator.OK));

		final int[] values = new int[0];

		for (int valueIndex = 0; valueIndex < values.length; ++valueIndex) {

			int offset = valueIndex * 4;
			int value = values[valueIndex];
			memory[offset + 0] = (byte) (value >>> 24);
			memory[offset + 1] = (byte) (value >>> 16);
			memory[offset + 2] = (byte) (value >>> 8);
			memory[offset + 3] = (byte) value;
		}
	}

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

		loadMemory();

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
