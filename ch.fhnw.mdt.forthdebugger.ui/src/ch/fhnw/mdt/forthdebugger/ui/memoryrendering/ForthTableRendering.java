package ch.fhnw.mdt.forthdebugger.ui.memoryrendering;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IDebugEventSetListener;
import org.eclipse.debug.ui.memory.AbstractMemoryRendering;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableColumn;

import ch.fhnw.mdt.forthdebugger.debugmodel.ForthThread;
import ch.fhnw.mdt.forthdebugger.debugmodel.extensions.IForthMemoryBlockExtension;
import ch.fhnw.mdt.forthdebugger.debugmodel.extensions.IForthMemoryBlockExtension.MemoryCell;

/**
 * Can render a Forth dump in a table.
 */
public class ForthTableRendering extends AbstractMemoryRendering {

	private TableViewer tableViewer;
	private IDebugEventSetListener debugListener = new StepListener();

	public ForthTableRendering(String renderingId) {
		super(renderingId);
	}

	@Override
	public Control createControl(Composite parent) {
		tableViewer = new TableViewer(parent, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.HIDE_SELECTION | SWT.BORDER | SWT.FULL_SELECTION);
		tableViewer.setLabelProvider(new ForthMemoryLabelProvider());
		tableViewer.setContentProvider(new ForthMemoryContentProvider());

		tableViewer.getTable().setFont(JFaceResources.getFont(JFaceResources.TEXT_FONT));

		// address
		final TableColumn addressColumn = new TableColumn(tableViewer.getTable(), SWT.LEFT);
		addressColumn.setText("Address");
		addressColumn.setWidth(75);

		// data
		for (int i = 0; i < 8; ++i) {
			final TableColumn dataColumn = new TableColumn(tableViewer.getTable(), SWT.RIGHT);
			dataColumn.setWidth(60);
		}

		tableViewer.setInput(getMemoryBlock());

		return tableViewer.getControl();
	}

	@Override
	public Control getControl() {
		return tableViewer.getControl();
	}

	@Override
	public void becomesVisible() {
		super.becomesVisible();

		DebugPlugin.getDefault().addDebugEventListener(debugListener);
	}

	@Override
	public void becomesHidden() {
		super.becomesHidden();

		DebugPlugin.getDefault().removeDebugEventListener(debugListener);
	}

	@Override
	public void dispose() {
		super.dispose();

		DebugPlugin.getDefault().removeDebugEventListener(debugListener);
	}

	private final class StepListener implements IDebugEventSetListener {
		@Override
		public void handleDebugEvents(DebugEvent[] events) {
			if (tableViewer == null || tableViewer.getTable().isDisposed()) {
				return;
			}

			for (DebugEvent debugEvent : events) {
				if (debugEvent.getSource() instanceof ForthThread) {
					Display.getDefault().asyncExec(() -> tableViewer.refresh());
					return;
				}
			}
		}
	}

	private static final class ForthMemoryLabelProvider extends LabelProvider implements ITableLabelProvider {

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			final MemoryCell cell = (MemoryCell) element;
			if (columnIndex == 0) {
				return cell.address;
			} else {
				return Integer.toHexString(cell.data[columnIndex - 1]);
			}
		}

	}

	private static final class ForthMemoryContentProvider implements IStructuredContentProvider {

		@Override
		public void dispose() {
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		@Override
		public Object[] getElements(Object inputElement) {
			final IForthMemoryBlockExtension forthMemoryBlockExtension = (IForthMemoryBlockExtension) inputElement;
			return forthMemoryBlockExtension.getMemoryCells();
		}
	}

}
