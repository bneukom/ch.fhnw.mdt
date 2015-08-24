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
	private Timer pollTimer = new Timer();
	private TimerTask pollTask = new TimerTask() {

		@Override
		public void run() {
			final List<String> comPorts = platformStrings.listComPorts();

			Display.getDefault().asyncExec(() -> {
				ISelection previousSelection = usbDeviceListViewer.getSelection();
				usbDeviceListViewer.setInput(comPorts);
				usbDeviceListViewer.setSelection(previousSelection);
				
				if (comPorts.isEmpty()) {
					setErrorMessage("No available port found.");
				}
			});
		}
	};

	private IPlatformStrings platformStrings = MDTPlatformPlugin.getDefault().getPlatformStrings();

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public SelectUmbilicalPortDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setMessage("Chose the port you want your Application to run on.");
		setTitle("Chose Port");

		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new FormLayout());
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		usbDeviceListViewer = new ListViewer(container, SWT.BORDER | SWT.V_SCROLL);
		usbDeviceListViewer.setContentProvider(ArrayContentProvider.getInstance());

		org.eclipse.swt.widgets.List list = usbDeviceListViewer.getList();
		FormData listFormData = new FormData();
		listFormData.bottom = new FormAttachment(100, -10);
		listFormData.right = new FormAttachment(100, -10);
		listFormData.top = new FormAttachment(0, 10);
		listFormData.left = new FormAttachment(0, 10);
		list.setLayoutData(listFormData);

		List<String> availableUsbDevices = platformStrings.listComPorts();
		usbDeviceListViewer.setInput(availableUsbDevices);
		if (availableUsbDevices.isEmpty()) {
			setErrorMessage("No available port found.");
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

		pollTimer.schedule(pollTask, 0, 500);

		return area;
	}

	@Override
	protected Control createButtonBar(Composite parent) {
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
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		
		System.out.println(Display.getDefault().getDPI());
		Point dpi = Display.getDefault().getDPI();
		return new Point(dpi.x * 3, dpi.y * 4);
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);

		newShell.addListener(SWT.Dispose, (e) -> {
			pollTimer.cancel();
		});

	}

}
