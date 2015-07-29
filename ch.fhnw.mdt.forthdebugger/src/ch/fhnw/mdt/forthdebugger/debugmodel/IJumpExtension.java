package ch.fhnw.mdt.forthdebugger.debugmodel;

import org.eclipse.debug.core.DebugException;


public interface IJumpExtension {

	/**
	 * Jumps until after the next branch instruction therefore jumping out of a loop.
	 * 
	 * @throws DebugException
	 */
	public void jump() throws DebugException;

	/**
	 * Returns <code>true</code> if {@link #jump()}ing is currently enabled.
	 * 
	 * @return <code>true</code> if {@link #jump()}ing is currently enabled.
	 * @throws DebugException
	 */
	public boolean canJump() throws DebugException;
}
