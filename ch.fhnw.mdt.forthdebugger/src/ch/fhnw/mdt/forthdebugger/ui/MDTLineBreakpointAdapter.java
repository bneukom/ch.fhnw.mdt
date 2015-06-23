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
package ch.fhnw.mdt.forthdebugger.ui;

import org.eclipse.cdt.core.dom.ast.IASTDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTFileLocation;
import org.eclipse.cdt.core.dom.ast.IASTFunctionDefinition;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.model.ITranslationUnit;
import org.eclipse.cdt.ui.CDTUITools;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IBreakpointListener;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.ILineBreakpoint;
import org.eclipse.debug.ui.actions.IToggleBreakpointsTarget;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.texteditor.ITextEditor;

import ch.fhnw.mdt.forthdebugger.ForthDebuggerPlugin;
import ch.fhnw.mdt.forthdebugger.IMDTConstants;
import ch.fhnw.mdt.forthdebugger.MDTLineBreakpoint;
import ch.fhnw.mdt.forthdebugger.util.ASTUtil;

/**
 * Adapter to create breakpoints in PDA files.
 */
public class MDTLineBreakpointAdapter implements IToggleBreakpointsTarget {

	public MDTLineBreakpointAdapter() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.ui.actions.IToggleBreakpointsTarget#toggleLineBreakpoints(org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void toggleLineBreakpoints(final IWorkbenchPart part, final ISelection selection) throws CoreException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.ui.actions.IToggleBreakpointsTarget#canToggleLineBreakpoints(org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public boolean canToggleLineBreakpoints(final IWorkbenchPart part, final ISelection selection) {
		return false;
	}

	/**
	 * Returns the editor being used to edit a PDA file, associated with the given part, or <code>null</code> if none.
	 * 
	 * @param part
	 *            workbench part
	 * @return the editor being used to edit a PDA file, associated with the given part, or <code>null</code> if none
	 */
	private ITextEditor getEditor(final IWorkbenchPart part) {
		if (part instanceof ITextEditor) {
			final ITextEditor editorPart = (ITextEditor) part;
			final IResource resource = (IResource) editorPart.getEditorInput().getAdapter(IResource.class);
			if (resource != null) {
				final String extension = resource.getFileExtension();
				if (extension != null && extension.equals("c")) {
					return editorPart;
				}
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.ui.actions.IToggleBreakpointsTarget#toggleMethodBreakpoints(org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void toggleMethodBreakpoints(final IWorkbenchPart part, final ISelection selection) throws CoreException {
		final ITextEditor textEditor = getEditor(part);

		if (textEditor != null) {
			final IResource resource = (IResource) textEditor.getEditorInput().getAdapter(IResource.class);
			final ITextSelection textSelection = (ITextSelection) selection;
			final int lineNumber = textSelection.getStartLine();
			final IBreakpoint[] breakpoints = DebugPlugin.getDefault().getBreakpointManager().getBreakpoints(IMDTConstants.ID_MDT_DEBUG_MODEL);

			// remove old break point if there was a breakpoint here already
			for (int i = 0; i < breakpoints.length; i++) {
				final IBreakpoint breakpoint = breakpoints[i];
				if (resource.equals(breakpoint.getMarker().getResource())) {
					if (((ILineBreakpoint) breakpoint).getLineNumber() == (lineNumber + 1)) {
						// remove
						breakpoint.delete();
						return;
					}
				}
			}

			// create line breakpoint (doc line numbers start at 0)
			final ITranslationUnit element = (ITranslationUnit) CDTUITools.getEditorInputCElement(textEditor.getEditorInput());

			final IASTTranslationUnit ast = element.getAST();

			final IASTFunctionDefinition functionDefinition = ASTUtil.getFunctionDefinition(ast, lineNumber + 1);
			if (functionDefinition != null) {
				final String functionName = functionDefinition.getDeclarator().getName().toString();
				final MDTLineBreakpoint lineBreakpoint = new MDTLineBreakpoint(resource, functionName, lineNumber + 1);
				DebugPlugin.getDefault().getBreakpointManager().addBreakpoint(lineBreakpoint);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.ui.actions.IToggleBreakpointsTarget#canToggleMethodBreakpoints(org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public boolean canToggleMethodBreakpoints(final IWorkbenchPart part, final ISelection selection) {
		return getEditor(part) != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.ui.actions.IToggleBreakpointsTarget#toggleWatchpoints(org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void toggleWatchpoints(final IWorkbenchPart part, final ISelection selection) throws CoreException {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.ui.actions.IToggleBreakpointsTarget#canToggleWatchpoints(org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public boolean canToggleWatchpoints(final IWorkbenchPart part, final ISelection selection) {
		return false;
	}
}
