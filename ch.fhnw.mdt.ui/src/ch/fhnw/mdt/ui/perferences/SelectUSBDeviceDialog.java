package ch.fhnw.mdt.ui.perferences;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

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
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

// TODO implement file polling

/**
 * A Dialog which shows all available USB Devices to the user. Call
 * {@link #getSelectedDevice()} after opening the dialog to query the selected
 * (or null) device.
 * 
 */
public class SelectUSBDeviceDialog extends TitleAreaDialog {

	private ListViewer usbDeviceListViewer;
	private String selectedElement;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public SelectUSBDeviceDialog(Shell parentShell) {
		super(parentShell);

	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setMessage("Chose the USB Device you want to run your Application on.");
		setTitle("Chose USB Device");

		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new FormLayout());
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		usbDeviceListViewer = new ListViewer(container, SWT.BORDER | SWT.V_SCROLL);
		usbDeviceListViewer.setContentProvider(ArrayContentProvider.getInstance());

		org.eclipse.swt.widgets.List list = usbDeviceListViewer.getList();
		FormData fd_list = new FormData();
		fd_list.bottom = new FormAttachment(0, 383);
		fd_list.right = new FormAttachment(0, 796);
		fd_list.top = new FormAttachment(0, 10);
		fd_list.left = new FormAttachment(0, 10);
		list.setLayoutData(fd_list);

		try {

			List<String> availableUsbDevices = getAvailableUsbDevices();
			if (!availableUsbDevices.isEmpty()) {
				usbDeviceListViewer.setInput(availableUsbDevices);
			} else {
				setErrorMessage("No available USB device found.");
			}
		} catch (IOException e) {
			e.printStackTrace();
			setErrorMessage("IO Error. Could not retrieve USB devices.");
		}

		usbDeviceListViewer.setSelection(StructuredSelection.EMPTY);
		usbDeviceListViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = event.getSelection();
				getButton(OK).setEnabled(getErrorMessage() == null && !selection.isEmpty());
				IStructuredSelection structuredSelection = (IStructuredSelection) selection;
				selectedElement = (String) structuredSelection.getFirstElement();
			}
		});

		return area;
	}

	@Override
	protected Control createButtonBar(Composite parent) {
		final Control bar = super.createButtonBar(parent);

		getButton(OK).setEnabled(false);

		return bar;
	}

	/**
	 * Returns a {@link List} of all available USB Devices. Available USB device
	 * on Linux have the following pattern /dev/ttyUSB*
	 * 
	 * @return
	 * @throws IOException
	 */
	private static List<String> getAvailableUsbDevices() throws IOException {
		return Files.list(new File("/dev/").toPath()).filter(p -> p.toString().startsWith("/dev/ttyUSB")).map(p -> p.toString()).collect(Collectors.toList());
	}

	/**
	 * Returns the Device which is currently selected. If the dialog has already
	 * been closed, returns the Device which was last selected.
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
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(800, 600);
	}
}
