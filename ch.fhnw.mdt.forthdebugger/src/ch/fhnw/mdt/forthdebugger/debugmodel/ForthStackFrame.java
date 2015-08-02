/*******************************************************************************
 * Copyright (c) 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Bjorn Freeman-Benson - initial API and implementation
 *******************************************************************************/
package ch.fhnw.mdt.forthdebugger.debugmodel;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;

import ch.fhnw.mdt.forthdebugger.debugmodel.extensions.IAfterExtension;
import ch.fhnw.mdt.forthdebugger.debugmodel.extensions.IJumpExtension;
import ch.fhnw.mdt.forthdebugger.debugmodel.extensions.IKillProcessExtension;

/**
 * Forth stack frame.
 */
public class ForthStackFrame extends ForthDebugElement implements IStackFrame, IJumpExtension, IAfterExtension, IKillProcessExtension {

	private ForthThread thread;
	private String functionName;
	private String fileName;
	private int lineNumber;
	private int id;
	private String currentAddress;

	/**
	 * Constructs a stack frame in the given thread with the given frame data.
	 * 
	 * @param thread
	 * @param currentAddress
	 * @param id
	 *            stack frame id (0 is the bottom of the stack)
	 */
	public ForthStackFrame(ForthThread thread, String functionName, String fileName, int lineNumber, String currentAddress, int id) {
		super((ForthDebugTarget) thread.getDebugTarget());
		this.id = id;
		this.thread = thread;
		this.fileName = fileName;
		this.functionName = functionName;
		this.lineNumber = lineNumber;
		this.currentAddress = currentAddress;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IStackFrame#getThread()
	 */
	@Override
	public IThread getThread() {
		return thread;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IStackFrame#getVariables()
	 */
	@Override
	public IVariable[] getVariables() throws DebugException {
		return new IVariable[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IStackFrame#hasVariables()
	 */
	@Override
	public boolean hasVariables() throws DebugException {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IStackFrame#getLineNumber()
	 */
	@Override
	public int getLineNumber() throws DebugException {
		return lineNumber;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IStackFrame#getCharStart()
	 */
	@Override
	public int getCharStart() throws DebugException {
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IStackFrame#getCharEnd()
	 */
	@Override
	public int getCharEnd() throws DebugException {
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IStackFrame#getName()
	 */
	@Override
	public String getName() throws DebugException {
		return functionName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IStackFrame#getRegisterGroups()
	 */
	@Override
	public IRegisterGroup[] getRegisterGroups() throws DebugException {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IStackFrame#hasRegisterGroups()
	 */
	@Override
	public boolean hasRegisterGroups() throws DebugException {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IStep#canStepInto()
	 */
	@Override
	public boolean canStepInto() {
		return getThread().canStepInto();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IStep#canStepOver()
	 */
	@Override
	public boolean canStepOver() {
		return getThread().canStepOver();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.fhnw.mdt.forthdebugger.ForthThread#jump()
	 */
	@Override
	public void jump() throws DebugException {
		thread.jump();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.fhnw.mdt.forthdebugger.ForthThread#canJump()
	 */
	@Override
	public boolean canJump() throws DebugException {
		return thread.canJump();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.fhnw.mdt.forthdebugger.debugmodel.extensions.IKillProcessExtension#kill()
	 */
	@Override
	public void kill() throws DebugException {
		thread.kill();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.fhnw.mdt.forthdebugger.debugmodel.extensions.IKillProcessExtension#canKill()
	 */
	@Override
	public boolean canKill() throws DebugException {
		return thread.canKill();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.fhnw.mdt.forthdebugger.debugmodel.extensions.IAfterExtension#after()
	 */
	@Override
	public void after() throws DebugException {
		thread.after();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.fhnw.mdt.forthdebugger.debugmodel.extensions.IAfterExtension#canAfter()
	 */
	@Override
	public boolean canAfter() throws DebugException {
		return thread.canAfter();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IStep#canStepReturn()
	 */
	@Override
	public boolean canStepReturn() {
		return getThread().canStepReturn();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IStep#isStepping()
	 */
	@Override
	public boolean isStepping() {
		return getThread().isStepping();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IStep#stepInto()
	 */
	@Override
	public void stepInto() throws DebugException {
		getThread().stepInto();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IStep#stepOver()
	 */
	@Override
	public void stepOver() throws DebugException {
		getThread().stepOver();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IStep#stepReturn()
	 */
	@Override
	public void stepReturn() throws DebugException {
		getThread().stepReturn();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#canResume()
	 */
	@Override
	public boolean canResume() {
		return getThread().canResume();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#canSuspend()
	 */
	@Override
	public boolean canSuspend() {
		return getThread().canSuspend();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#isSuspended()
	 */
	@Override
	public boolean isSuspended() {
		return getThread().isSuspended();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#resume()
	 */
	@Override
	public void resume() throws DebugException {
		getThread().resume();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#suspend()
	 */
	@Override
	public void suspend() throws DebugException {
		getThread().suspend();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.ITerminate#canTerminate()
	 */
	@Override
	public boolean canTerminate() {
		return getThread().canTerminate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.ITerminate#isTerminated()
	 */
	@Override
	public boolean isTerminated() {
		return getThread().isTerminated();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.ITerminate#terminate()
	 */
	@Override
	public void terminate() throws DebugException {
		getThread().terminate();
	}

	/**
	 * Returns the name of the source file this stack frame is associated with.
	 * 
	 * @return the name of the source file this stack frame is associated with
	 */
	public String getSourceName() {
		return fileName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ForthStackFrame) {
			ForthStackFrame sf = (ForthStackFrame) obj;
			try {
				return sf.getSourceName().equals(getSourceName()) && sf.getLineNumber() == getLineNumber() && sf.id == id;
			} catch (DebugException e) {
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return getSourceName().hashCode() + id;
	}

	/**
	 * Returns this stack frame's unique identifier within its thread
	 * 
	 * @return this stack frame's unique identifier within its thread
	 */
	protected int getIdentifier() {
		return id;
	}

	/**
	 * Returns the function name of this stack frame.
	 * 
	 * @return the function name of this stack frame.
	 */
	public String getFunctionName() {
		return functionName;
	}

	/**
	 * Returns the current address of this stack frame.
	 * 
	 * @return the current address of this stack frame.
	 */
	public String getCurrentAddress() {
		return currentAddress;
	}

}
