package ch.fhnw.mdt.forthdebugger.debugmodel.extensions;

import org.eclipse.debug.core.DebugException;

public interface IKillProcessExtension {

	/**
	 * Kills the forth process.
	 * 
	 * @throws DebugException
	 */
	public void kill() throws DebugException;

	/**
	 * Returns <code>true</code> if {@link #kill()}ing is currently enabled.
	 * 
	 * @return <code>true</code> if {@link #kill()}ing is currently enabled.
	 * @throws DebugException
	 */
	public boolean canKill() throws DebugException;
}
