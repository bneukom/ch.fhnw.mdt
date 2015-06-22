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

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.LineBreakpoint;

/**
 * http://alvinalexander.com/java/jwarehouse/eclipse/org.eclipse.debug.examples.core/plugin.xml.shtml
 * PDA line breakpoint
 */
public class MDTLineBreakpoint extends LineBreakpoint {

	private static final String MDT_DEBUG_MARKER = "ch.fhnw.mdt.forthdebugger.mdtBreakpointMarker";

	/**
	 * Default constructor is required for the breakpoint manager to re-create persisted breakpoints. After instantiating a breakpoint, the <code>setMarker(...)</code> method is
	 * called to restore this breakpoint's attributes.
	 */
	public MDTLineBreakpoint() {
	}

	/**
	 * Constructs a line breakpoint on the given resource at the given line number. The line number is 1-based (i.e. the first line of a file is line number 1). The PDA VM uses
	 * 0-based line numbers, so this line number translation is done at breakpoint install time.
	 * 
	 * @param resource
	 *            file on which to set the breakpoint
	 * @param lineNumber
	 *            1-based line number of the breakpoint
	 * @throws CoreException
	 *             if unable to create the breakpoint
	 */
	public MDTLineBreakpoint(final IResource resource, final int lineNumber) throws CoreException {
		IWorkspaceRunnable runnable = new IWorkspaceRunnable() {
			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				IMarker marker = resource.createMarker(MDT_DEBUG_MARKER);
				setMarker(marker);
				marker.setAttribute(IBreakpoint.ENABLED, Boolean.TRUE);
				marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
				marker.setAttribute(IBreakpoint.ID, getModelIdentifier());
				marker.setAttribute(IMarker.MESSAGE, "MDT Breakpoint: " + resource.getName() + " [line: " + lineNumber + "]");
			}
		};
		run(getMarkerRule(resource), runnable);
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IBreakpoint#getModelIdentifier()
	 */
	@Override
	public String getModelIdentifier() {
		return IMDTConstants.ID_MDT_DEBUG_MODEL;
	}
}
