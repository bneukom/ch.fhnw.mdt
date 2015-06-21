package ch.fhnw.mdt.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.wb.swt.SWTResourceManager;

public class MCorePreferencePage extends PreferencePage implements IWorkbenchPreferencePage {
	private Text usbDeviceText;
	private Text gforthLoaderText;
	private Button selectUSBDeviceButton;

	public static final String USB_DEVICE_NAME_PREFERENCE = "usbDeviceNamePreference";
	public static final String GFORTH_LOADER_PREFERENCE = "gforthLoader";
	private Button useUSBDeviceButton;

	/**
	 * Create the preference page.
	 */
	public MCorePreferencePage() {
	}

	/**
	 * Create contents of the preference page.
	 * 
	 * @param parent
	 */
	@Override
	public Control createContents(final Composite parent) {
		final Composite container = new Composite(parent, SWT.NULL);
		container.setLayout(new GridLayout(3, false));

		final String usbDeviceName = getPreferenceStore().getString(USB_DEVICE_NAME_PREFERENCE);

		useUSBDeviceButton = new Button(container, SWT.CHECK);
		useUSBDeviceButton.setText("USB Device");
		useUSBDeviceButton.setSelection(!usbDeviceName.equals(""));
		useUSBDeviceButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				usbDeviceText.setText("");
				usbDeviceText.setEnabled(useUSBDeviceButton.getSelection());
				selectUSBDeviceButton.setEnabled(useUSBDeviceButton.getSelection());
			}
		});

		usbDeviceText = new Text(container, SWT.BORDER);
		usbDeviceText.setEnabled(!usbDeviceName.equals(""));
		usbDeviceText.setText(usbDeviceName);
		usbDeviceText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		selectUSBDeviceButton = new Button(container, SWT.NONE);
		selectUSBDeviceButton.setEnabled(!usbDeviceName.equals(""));
		selectUSBDeviceButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				final SelectUSBDeviceDialog selectUsbDeviceDialog = new SelectUSBDeviceDialog(getShell());
				final int response = selectUsbDeviceDialog.open();
				if (response == SelectUSBDeviceDialog.OK) {
					final String device = selectUsbDeviceDialog.getSelectedDevice();
					usbDeviceText.setText(device);
				}
			}
		});
		selectUSBDeviceButton.setText("Search Device...");

		final Label label = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));

		final Label lblGforthLoader = new Label(container, SWT.NONE);
		lblGforthLoader.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		lblGforthLoader.setText("GForth Loader");
		new Label(container, SWT.NONE);

		final Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
		lblNewLabel.setText("The $INPUT_FILE will be replaced by the actual file name.");
		new Label(container, SWT.NONE);

		gforthLoaderText = new Text(container, SWT.BORDER | SWT.V_SCROLL | SWT.MULTI);
		GridData gd_gforthLoaderText = new GridData(SWT.FILL, SWT.FILL, false, true, 3, 1);
		gd_gforthLoaderText.heightHint = 426;
		gforthLoaderText.setLayoutData(gd_gforthLoaderText);

		gforthLoaderText.setText(getPreferenceStore().getString(GFORTH_LOADER_PREFERENCE));

		return container;
	}

	@Override
	protected IPreferenceStore doGetPreferenceStore() {
		return MDTPreferencesPlugin.getDefault().getPreferenceStore();
	}

	@Override
	public boolean performOk() {

		if (useUSBDeviceButton.getSelection())
			getPreferenceStore().setValue(USB_DEVICE_NAME_PREFERENCE, usbDeviceText.getText());
		getPreferenceStore().setValue(GFORTH_LOADER_PREFERENCE, gforthLoaderText.getText());

		return true;
	}

	/**
	 * Initialize the preference page.
	 */
	public void init(final IWorkbench workbench) {
	}
}
