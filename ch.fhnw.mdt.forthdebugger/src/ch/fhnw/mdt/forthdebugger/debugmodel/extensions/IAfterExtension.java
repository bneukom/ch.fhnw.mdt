package ch.fhnw.mdt.forthdebugger.debugmodel.extensions;

import org.eclipse.debug.core.DebugException;

public interface IAfterExtension {
	/**
	 * Jumps until after the next branch instruction therefore jumping out of a loop.
	 * 
	 * @throws DebugException
	 */
	public void after() throws DebugException;

	/**
	 * Returns <code>true</code> if {@link #jump()}ing is currently enabled.
	 * 
	 * @return <code>true</code> if {@link #jump()}ing is currently enabled.
	 * @throws DebugException
	 */
	public boolean canAfter() throws DebugException;
}
