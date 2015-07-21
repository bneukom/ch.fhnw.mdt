package ch.fhnw.mdt.forthdebugger.ui;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.ui.AbstractDebugView;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;

import ch.fhnw.mdt.forthdebugger.debugmodel.ForthDebugTarget;
import ch.fhnw.mdt.forthdebugger.debugmodel.IForthConstants;

public class DataStackView extends AbstractDebugView implements ISelectionListener {

	class StackViewContentProvider implements ITreeContentProvider {

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
		 */
		public Object[] getChildren(final Object parentElement) {
			if (parentElement instanceof ForthDebugTarget) {
				try {
					return ((ForthDebugTarget) parentElement).getDataStack().toArray();
				} catch (DebugException e) {
				}
			}
			return new Object[0];
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
		 */
		public Object getParent(final Object element) {
			if (element instanceof IDebugTarget) {
				return null;
			} else {
				return ((IDebugElement) element).getDebugTarget();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
		 */
		public boolean hasChildren(final Object element) {
			if (element instanceof IDebugElement) {
				return getChildren(element).length > 0;
			}
			return false;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
		 */
		public Object[] getElements(final Object inputElement) {
			return getChildren(inputElement);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
		 */
		public void dispose() {
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
		 */
		public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.ui.AbstractDebugView#createViewer(org.eclipse.swt.widgets.Composite)
	 */
	protected Viewer createViewer(final Composite parent) {
		final TreeViewer viewer = new TreeViewer(parent);
		viewer.setLabelProvider(DebugUITools.newDebugModelPresentation());
		viewer.setContentProvider(new StackViewContentProvider());
		getSite().getWorkbenchWindow().getSelectionService().addSelectionListener(IDebugUIConstants.ID_DEBUG_VIEW, this);
		return viewer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.ui.AbstractDebugView#createActions()
	 */
	protected void createActions() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.ui.AbstractDebugView#getHelpContextId()
	 */
	protected String getHelpContextId() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.ui.AbstractDebugView#fillContextMenu(org.eclipse.jface.action.IMenuManager)
	 */
	protected void fillContextMenu(final IMenuManager menu) {
		menu.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.ui.AbstractDebugView#configureToolBar(org.eclipse.jface.action.IToolBarManager)
	 */
	protected void configureToolBar(final IToolBarManager tbm) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchPart#dispose()
	 */
	public void dispose() {
		getSite().getWorkbenchWindow().getSelectionService().removeSelectionListener(IDebugUIConstants.ID_DEBUG_VIEW, this);
		super.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(final IWorkbenchPart part, final ISelection selection) {
		final IAdaptable adaptable = DebugUITools.getDebugContext();
		Object input = null;
		if (adaptable != null) {
			final IDebugElement element = (IDebugElement) adaptable.getAdapter(IDebugElement.class);
			if (element != null) {
				if (element.getModelIdentifier().equals(IForthConstants.ID_MDT_DEBUG_MODEL)) {
					input = element.getDebugTarget();
				}
			}
		}
		getViewer().setInput(input);
	}
}
