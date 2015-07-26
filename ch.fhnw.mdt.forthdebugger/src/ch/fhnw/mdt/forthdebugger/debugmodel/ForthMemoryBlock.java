package ch.fhnw.mdt.forthdebugger.debugmodel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IMemoryBlock;

import ch.fhnw.mdt.forthdebugger.communication.ForthCommunicator;
import ch.fhnw.mdt.forthdebugger.communication.ForthCommunicator.ForthCommandQueue;

// TODO Forth accepts hex integer values for dump, for eclipse we need byte values. how to convert?
//
public class ForthMemoryBlock extends ForthDebugElement implements IMemoryBlock {

	// 00000000: 12 0 7 3B6 10127 5 9 9
	// 00000008: 38F 2 33D 0 2 0 0 0
	private byte[] memory;
	private final long startAddress;
	private final long length;
	private final ForthCommunicator forthCommunicator;
	
	
	public ForthMemoryBlock(final ForthDebugTarget target, final long startAddress, final long length, final ForthCommunicator forthCommunicator) {
		super(target);
		this.forthCommunicator = forthCommunicator;

		this.startAddress = startAddress;
		this.length = length;

		loadMemory();
	}

	private void loadMemory() {
		System.out.println("LOAD MEM");
		forthCommunicator.awaitCommandCompletion();
		forthCommunicator.awaitReadCompletion();
		
		// let the debug target ignore the input
		target.setIgnoreInput(true);
		forthCommunicator.sendCommandAwaitResult(String.valueOf(startAddress / 4) + " " + String.valueOf(length / 4) + " dump" + ForthCommunicator.NL,
				forthCommunicator.waitForResultLater(">"));
		target.setIgnoreInput(false);

		final List<String> readLines = forthCommunicator.getReadLines();
		
		// read backwards until the word dump is found
		int currentIndex = readLines.size() - 1;
		String line = readLines.get(currentIndex);
		
		// if the memory block was called after the first line of a function call, the function will be outputed to the console too, so ignore this line.
		if (line.endsWith("---------------\n")) { // FIXME line separator
			line = readLines.get(--currentIndex);
		}
		line = line.substring(0, line.length() - 3); // remove the trailing ok
		line = line.substring(9); // remove leading memory address
		
		final List<String> stringMemoryDump = new ArrayList<>();
		while (!line.contains("dump")) {
			stringMemoryDump.add(line);
			line = readLines.get(--currentIndex);
			line = line.substring(9); // remove leading memory address
		}
		Collections.reverse(stringMemoryDump);
		
		// convert the dump into an array
		final List<Integer> memoryDumpValues = new ArrayList<>();
		for (final String dumpLine : stringMemoryDump) {
			final String[] stringValues = dumpLine.trim().split("\\s+");
			
			memoryDumpValues.addAll(Arrays.stream(stringValues).map(s -> Integer.parseInt(s, 16)).collect(Collectors.toList()));
		}
		
		// convert dump to a byte array
		final int[] values = memoryDumpValues.stream().mapToInt(i -> i).toArray();
		memory = new byte[values.length * 4];
		for (int valueIndex = 0; valueIndex < values.length; ++valueIndex) {

			final int offset = valueIndex * 4;
			final int value = values[valueIndex];
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
		return memory.length;
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
	public void setValue(final long offset, final byte[] bytes) throws DebugException {

	}

}
