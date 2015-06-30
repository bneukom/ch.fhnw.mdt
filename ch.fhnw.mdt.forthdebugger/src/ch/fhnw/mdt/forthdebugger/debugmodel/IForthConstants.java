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

/**
 * Constants for the MDT debugger.
 */
public interface IForthConstants {

	/**
	 * Unique identifier for the MDT debug model
	 */
	public static final String ID_MDT_DEBUG_MODEL = "ch.fhnw.mdt.forthdebugger.mdtDebugModelPresentation";

	/**
	 * Property for the project name of the project to be launched.
	 */
	public static final String ATTR_PROJECT = "projectName";
	
	/**
	 * Property for the file name to be executed. 
	 */
	public static final String ATTR_FORTH_EXECUTABLE_FILE = "executableFilePath";
}
