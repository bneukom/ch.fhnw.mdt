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
package ch.fhnw.mdt.forthdebugger.model;

/**
 * Constants for the PDA debugger.
 */
public interface IMDTConstants {

	/**
	 * Unique identifier for the PDA debug model
	 */
	public static final String ID_MDT_DEBUG_MODEL = "ch.fhnw.mdt.forthdebugger.mdtDebugModelPresentation";

	/**
	 * Launch configuration key.
	 */
	public static final String ATTR_PDA_PROGRAM = ID_MDT_DEBUG_MODEL + ".ATTR_PDA_PROGRAM";
}
