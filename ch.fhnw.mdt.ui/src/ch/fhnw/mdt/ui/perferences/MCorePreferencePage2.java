package ch.fhnw.mdt.ui.perferences;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ch.fhnw.mdt.launch.ui.SelectUSBDeviceDialog;
import org.eclipse.wb.swt.SWTResourceManager;

public class MCorePreferencePage2 extends PreferencePage implements IWorkbenchPreferencePage {
	private Text usbDeviceText;
	private Text gforthLoaderText;

	/**
	 * Create the preference page.
	 */
	public MCorePreferencePage2() {
	}

	/**
	 * Create contents of the preference page.
	 * 
	 * @param parent
	 */
	@Override
	public Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		container.setLayout(new FormLayout());

		Label lblUsbDevice = new Label(container, SWT.NONE);
		FormData fd_lblUsbDevice = new FormData();
		fd_lblUsbDevice.bottom = new FormAttachment(0, 43);
		fd_lblUsbDevice.right = new FormAttachment(0, 130);
		lblUsbDevice.setLayoutData(fd_lblUsbDevice);
		lblUsbDevice.setText("USB Device");

		usbDeviceText = new Text(container, SWT.BORDER);
		fd_lblUsbDevice.top = new FormAttachment(usbDeviceText, 0, SWT.TOP);
		FormData fd_text = new FormData();
		fd_text.left = new FormAttachment(0, 146);
		fd_text.top = new FormAttachment(0, 10);
		usbDeviceText.setLayoutData(fd_text);

		Button selectUSBDeviceButton = new Button(container, SWT.NONE);
		selectUSBDeviceButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final SelectUSBDeviceDialog selectUsbDeviceDialog = new SelectUSBDeviceDialog(getShell());
				final int response = selectUsbDeviceDialog.open();
				if (response == SelectUSBDeviceDialog.OK) {
					final String device = selectUsbDeviceDialog.getSelectedDevice();
					usbDeviceText.setText(device);
				}
			}
		});
		fd_text.right = new FormAttachment(selectUSBDeviceButton, -6);
		FormData fd_btnNewButton = new FormData();
		fd_btnNewButton.top = new FormAttachment(0, 8);
		fd_btnNewButton.right = new FormAttachment(100, -10);
		selectUSBDeviceButton.setLayoutData(fd_btnNewButton);
		selectUSBDeviceButton.setText("Search Device...");

		gforthLoaderText = new Text(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI | SWT.CANCEL);
		fd_lblUsbDevice.left = new FormAttachment(gforthLoaderText, 0, SWT.LEFT);
		FormData fd_text_1 = new FormData();
		fd_text_1.bottom = new FormAttachment(100, -10);
		fd_text_1.right = new FormAttachment(selectUSBDeviceButton, 0, SWT.RIGHT);
		fd_text_1.left = new FormAttachment(0);
		gforthLoaderText.setLayoutData(fd_text_1);

		Label label = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		FormData fd_label = new FormData();
		fd_label.top = new FormAttachment(usbDeviceText, 6);
		fd_label.left = new FormAttachment(0);
		fd_label.right = new FormAttachment(100, -10);
		label.setLayoutData(fd_label);

		Label lblGforthLoader = new Label(container, SWT.NONE);
		fd_label.bottom = new FormAttachment(lblGforthLoader, -4);
		FormData fd_lblGforthLoader = new FormData();
		fd_lblGforthLoader.left = new FormAttachment(lblUsbDevice, 0, SWT.LEFT);
		lblGforthLoader.setLayoutData(fd_lblGforthLoader);
		lblGforthLoader.setText("GForth Loader");
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		fd_lblGforthLoader.bottom = new FormAttachment(lblNewLabel, -6);
		fd_text_1.top = new FormAttachment(0, 141);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
		FormData fd_lblNewLabel = new FormData();
		fd_lblNewLabel.bottom = new FormAttachment(gforthLoaderText, -6);
		fd_lblNewLabel.left = new FormAttachment(gforthLoaderText, 0, SWT.LEFT);
		lblNewLabel.setLayoutData(fd_lblNewLabel);
		lblNewLabel.setText("The $INPUT_FILE will be replaced by the actual file name.");

		return container;
	}

	/**
	 * Initialize the preference page.
	 */
	public void init(IWorkbench workbench) {
		// Initialize the preference page
	}
}
