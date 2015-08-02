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
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;

import ch.fhnw.mdt.forthdebugger.debugmodel.ForthDebugTarget;
import ch.fhnw.mdt.forthdebugger.debugmodel.ForthValue;
import ch.fhnw.mdt.forthdebugger.debugmodel.IForthConstants;

/**
 * View which is able to display the data stack for the Forth Debugger.
 */
public class DataStackView extends AbstractDebugView implements ISelectionListener {

	private TableViewer viewer;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.ui.AbstractDebugView#createViewer(org.eclipse.swt.
	 * widgets.Composite)
	 */
	protected Viewer createViewer(final Composite parent) {

		viewer = new TableViewer(parent);
		final Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setFont(JFaceResources.getFont(JFaceResources.TEXT_FONT));

		TableColumnLayout tableColumnLayout = new TableColumnLayout();
		parent.setLayout(tableColumnLayout);

		final TableViewerColumn tosColumn = new TableViewerColumn(viewer, SWT.NONE);
		tosColumn.getColumn().setText("TOS");
		tosColumn.getColumn().setResizable(true);
		tosColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(final Object element) {
				if (element instanceof ForthValue) {
					try {
						return ((ForthValue) element).getValueString();
					} catch (final DebugException e) {
					}
				}
				return element.toString();
			}
		});
		tableColumnLayout.setColumnData(tosColumn.getColumn(), new ColumnWeightData(20, 200, true));

		viewer.setContentProvider(new IStructuredContentProvider() {

			@Override
			public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
			}

			@Override
			public void dispose() {
			}

			@Override
			public Object[] getElements(final Object inputElement) {
				if (inputElement instanceof ForthDebugTarget) {
					try {
						return ((ForthDebugTarget) inputElement).getDataStack().toArray();
					} catch (final DebugException e) {
					}
				}
				return new Object[0];
			}
		});

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
	 * @see
	 * org.eclipse.debug.ui.AbstractDebugView#fillContextMenu(org.eclipse.jface.
	 * action.IMenuManager)
	 */
	protected void fillContextMenu(final IMenuManager menu) {
		menu.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.AbstractDebugView#configureToolBar(org.eclipse.jface
	 * .action.IToolBarManager)
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
	 * @see org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.
	 * IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(final IWorkbenchPart part, final ISelection selection) {
		final IAdaptable adaptable = DebugUITools.getDebugContext();
		Object input = null;
		if (adaptable != null) {
			final IDebugElement element = (IDebugElement) adaptable.getAdapter(IDebugElement.class);
			if (element != null) {
				if (element.getModelIdentifier().equals(IForthConstants.ID_MDT_DEBUG_MODEL)) {
					final IDebugTarget debugTarget = element.getDebugTarget();
					input = debugTarget;

					viewer.getTable().setEnabled(debugTarget.isSuspended());
				}
			}
		}
		getViewer().setInput(input);
	}
}
