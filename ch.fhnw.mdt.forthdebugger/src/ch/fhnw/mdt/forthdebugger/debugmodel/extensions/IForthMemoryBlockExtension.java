package ch.fhnw.mdt.forthdebugger.debugmodel.extensions;

import org.eclipse.debug.core.model.IMemoryBlock;

/**
 * Extends an {@link IMemoryBlock} to be able to return forth specific memory data.
 *
 */
public interface IForthMemoryBlockExtension {

	/**
	 * Returns the {@link MemoryCell}s read from the forth debugger.
	 * 
	 * @return the {@link MemoryCell}s read from the forth debugger.
	 */
	public MemoryCell[] getMemoryCells();

	/**
	 * Represents one Forth Memory Cell. Contains an address and 8 data cells.
	 *
	 */
	public static final class MemoryCell {
		public final String address;
		public final int[] data;

		public MemoryCell(final String address, final int[] data) {
			this.address = address;
			this.data = data;
		}
	}
}
