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
package ch.fhnw.mdt.forthdebugger;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

/**
 * Value of a PDA variable.
 */
public class MDTValue extends MDTDebugElement implements IValue {

	private String value;

	public MDTValue(MDTDebugTarget target, String value) {
		super(target);
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IValue#getReferenceTypeName()
	 */
	@Override
	public String getReferenceTypeName() throws DebugException {
		try {
			Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return "text";
		}
		return "integer";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IValue#getValueString()
	 */
	@Override
	public String getValueString() throws DebugException {
		return value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IValue#isAllocated()
	 */
	@Override
	public boolean isAllocated() throws DebugException {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IValue#getVariables()
	 */
	@Override
	public IVariable[] getVariables() throws DebugException {
		return new IVariable[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IValue#hasVariables()
	 */
	@Override
	public boolean hasVariables() throws DebugException {
		return false;
	}
}
