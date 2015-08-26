package ch.fhnw.mdt.preferences;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import ch.fhnw.mdt.platform.IPlatformStrings;
import ch.fhnw.mdt.platform.MDTPlatformPlugin;

/**
 * A Dialog which shows all available USB Devices to the user. Call
 * {@link #getSelectedDevice()} after opening the dialog to query the selected
 * (or null) device.
 * 
 */
public class SelectUmbilicalPortDialog extends TitleAreaDialog {

	private ListViewer usbDeviceListViewer;
	private String selectedElement;
	private final Timer pollTimer = new Timer();
	private final TimerTask pollTask = new TimerTask() {

		@Override
		public void run() {
			final List<String> comPorts = platformStrings.listComPorts();

			Display.getDefault().asyncExec(() -> {
				final ISelection previousSelection = usbDeviceListViewer.getSelection();

				if (!comPorts.equals(usbDeviceListViewer.getInput())) {
					usbDeviceListViewer.setInput(comPorts);
					usbDeviceListViewer.setSelection(previousSelection);

					if (comPorts.isEmpty()) {
						setErrorMessage("No available port found.");
					} else {
						setErrorMessage(null);
					}

					getButton(OK).setEnabled(!usbDeviceListViewer.getSelection().isEmpty());
				}
			});
		}
	};

	private final IPlatformStrings platformStrings = MDTPlatformPlugin.getDefault().getPlatformStrings();

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public SelectUmbilicalPortDialog(final Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(final Composite parent) {
		setMessage("Chose the port you want your Application to run on.");
		setTitle("Chose Port");

		final Composite area = (Composite) super.createDialogArea(parent);
		final Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new FormLayout());
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		usbDeviceListViewer = new ListViewer(container, SWT.BORDER | SWT.V_SCROLL);
		usbDeviceListViewer.setContentProvider(ArrayContentProvider.getInstance());

		final org.eclipse.swt.widgets.List list = usbDeviceListViewer.getList();
		final FormData listFormData = new FormData();
		listFormData.bottom = new FormAttachment(100, -10);
		listFormData.right = new FormAttachment(100, -10);
		listFormData.top = new FormAttachment(0, 10);
		listFormData.left = new FormAttachment(0, 10);
		list.setLayoutData(listFormData);

		final List<String> availableUsbDevices = platformStrings.listComPorts();
		usbDeviceListViewer.setInput(availableUsbDevices);
		if (availableUsbDevices.isEmpty()) {
			setErrorMessage("No available port found.");
		}

		usbDeviceListViewer.setSelection(StructuredSelection.EMPTY);
		usbDeviceListViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(final SelectionChangedEvent event) {
				final ISelection selection = event.getSelection();
				getButton(OK).setEnabled(!selection.isEmpty());
				final IStructuredSelection structuredSelection = (IStructuredSelection) selection;
				selectedElement = (String) structuredSelection.getFirstElement();
			}
		});
		
		usbDeviceListViewer.getList().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent e) {
			}
			
			@Override
			public void mouseDown(MouseEvent e) {
			}
			
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				okPressed();
			}
		});

		pollTimer.schedule(pollTask, 0, 500);
		
		return area;
	}

	@Override
	protected Control createButtonBar(final Composite parent) {
		final Control bar = super.createButtonBar(parent);

		getButton(OK).setEnabled(false);

		return bar;
	}

	/**
	 * Returns the device which is currently selected. If the dialog has already
	 * been closed, returns the device which was last selected.
	 * 
	 * @return
	 */
	public String getSelectedDevice() {
		return selectedElement;
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(final Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	@Override
	protected void configureShell(final Shell newShell) {
		super.configureShell(newShell);

		newShell.addListener(SWT.Dispose, (e) -> {
			pollTimer.cancel();
		});

	}

}
