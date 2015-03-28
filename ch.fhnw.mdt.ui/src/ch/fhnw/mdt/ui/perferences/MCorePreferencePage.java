package ch.fhnw.mdt.ui.perferences;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
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
import org.osgi.framework.Bundle;

public class MCorePreferencePage extends PreferencePage implements IWorkbenchPreferencePage {
	private Text usbDeviceText;
	private Text gforthLoaderText;

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

		final Label lblUsbDevice = new Label(container, SWT.NONE);
		lblUsbDevice.setText("USB Device");

		usbDeviceText = new Text(container, SWT.BORDER);
		usbDeviceText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		final Button selectUSBDeviceButton = new Button(container, SWT.NONE);
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

		gforthLoaderText.setText(getDefaultLoader());
		
		return container;
	}
	
	private String getDefaultLoader() {
		final Bundle bundle = Platform.getBundle("ch.fhnw.mdt.ui");
		final URL fileURL = bundle.getEntry("loaders/loader.fs");
		
		String loader = "";
		
		try {
			final File file = new File(FileLocator.resolve(fileURL).toURI());
			
			try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
				String line;
				while ((line = reader.readLine()) != null) {
					loader += line;
					loader += System.lineSeparator();
				}
			}
			
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}
		return loader;
	}

	/**
	 * Initialize the preference page.
	 */
	public void init(final IWorkbench workbench) {
		// Initialize the preference page
	}
}
