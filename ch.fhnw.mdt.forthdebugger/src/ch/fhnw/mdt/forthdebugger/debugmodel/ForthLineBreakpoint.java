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

import org.eclipse.cdt.core.dom.ast.IASTFunctionDefinition;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.model.CoreModel;
import org.eclipse.cdt.core.model.ITranslationUnit;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IBreakpointListener;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.LineBreakpoint;

import ch.fhnw.mdt.forthdebugger.util.ASTUtil;

/**
 * http://alvinalexander.com/java/jwarehouse/eclipse/org.eclipse.debug.examples.core/plugin.xml.shtml PDA line breakpoint
 */
public class ForthLineBreakpoint extends LineBreakpoint {

	private static final String MDT_DEBUG_MARKER = "ch.fhnw.mdt.forthdebugger.mdtBreakpointMarker";
	public static final String ATTR_FUNCTION_NAME = "functionName";

	private ITranslationUnit translationUnit;

	/**
	 * Default constructor is required for the breakpoint manager to re-create persisted breakpoints. After instantiating a breakpoint, the <code>setMarker(...)</code> method is
	 * called to restore this breakpoint's attributes.
	 */
	public ForthLineBreakpoint() {
		initializeBreakpointListener();
	}

	/**
	 * Constructs a line breakpoint on the given resource at the given line number. The line number is 1-based (i.e. the first line of a file is line number 1). The PDA VM uses
	 * 0-based line numbers, so this line number translation is done at breakpoint install time.
	 * 
	 * @param resource
	 *            file on which to set the breakpoint
	 * @param editorInput
	 * @param lineNumber
	 *            1-based line number of the breakpoint
	 * @throws CoreException
	 *             if unable to create the breakpoint
	 */
	public ForthLineBreakpoint(final IResource resource, final String functionName, final int lineNumber) throws CoreException {

		IWorkspaceRunnable runnable = new IWorkspaceRunnable() {
			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				IMarker marker = resource.createMarker(MDT_DEBUG_MARKER);
				setMarker(marker);
				marker.setAttribute(IBreakpoint.ENABLED, Boolean.TRUE);
				marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
				marker.setAttribute(ATTR_FUNCTION_NAME, functionName);
				marker.setAttribute(IBreakpoint.ID, getModelIdentifier());
				marker.setAttribute(IMarker.MESSAGE, "MDT Breakpoint: " + resource.getName() + " [line: " + lineNumber + ", function: " + functionName + "]");
			}
		};

		run(getMarkerRule(resource), runnable);
		initializeBreakpointListener();
	}

	/**
	 * Initializes the breakpoint listener which will remove breakpoints which are no longer valid due to updates.
	 */
	private void initializeBreakpointListener() {
		translationUnit = (ITranslationUnit) CoreModel.getDefault().create(getMarker().getResource());

		DebugPlugin.getDefault().getBreakpointManager().addBreakpointListener(new IBreakpointListener() {

			@Override
			public void breakpointRemoved(final IBreakpoint breakpoint, final IMarkerDelta delta) {
			}

			@Override
			public void breakpointChanged(final IBreakpoint breakpoint, final IMarkerDelta delta) {
				if (breakpoint == ForthLineBreakpoint.this) {
					try {
						final int lineNumber = (int) breakpoint.getMarker().getAttribute(IMarker.LINE_NUMBER);
						final IASTTranslationUnit ast = translationUnit.getAST();
						final IASTFunctionDefinition functionDefinition = ASTUtil.getFunctionDefinition(ast, lineNumber);

						if (functionDefinition == null) {
							delete();
							DebugPlugin.getDefault().getBreakpointManager().removeBreakpointListener(this);
						} else {
							// TODO update marker?
						}

					} catch (CoreException coreException) {
						coreException.printStackTrace();
					}
				}

			}

			@Override
			public void breakpointAdded(final IBreakpoint breakpoint) {
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.IBreakpoint#getModelIdentifier()
	 */
	@Override
	public String getModelIdentifier() {
		return IForthConstants.ID_MDT_DEBUG_MODEL;
	}
}
