package ch.fhnw.mdt.forthdebugger.debugmodel.extensions;

import org.eclipse.debug.core.DebugException;

public interface IJumpExtension {

	/**
	 * Jumps over the current instruction.
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
