package ch.fhnw.mdt.preferences;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class MDTPreferencesPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "ch.fhnw.mdt.preferences"; //$NON-NLS-1$

	// The shared instance
	private static MDTPreferencesPlugin plugin;

	/**
	 * The constructor
	 */
	public MDTPreferencesPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

		// set default and override value if it is empty
		final String loader = MDTPreferencesPlugin.getDefault().getPreferenceStore().getString(MCorePreferencePage.GFORTH_LOADER_PREFERENCE);

		if (loader == null || loader.isEmpty()) {
			MDTPreferencesPlugin.getDefault().getPreferenceStore().setValue(MCorePreferencePage.GFORTH_LOADER_PREFERENCE, getDefaultLoader());
			MDTPreferencesPlugin.getDefault().getPreferenceStore().setDefault(MCorePreferencePage.GFORTH_LOADER_PREFERENCE, getDefaultLoader());
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static MDTPreferencesPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns the loader with the given input file replacement ($INPUT_FILE in the loader will get replaced).
	 * 
	 * @param inputFile
	 * @param isDebugMode
	 * @return
	 */
	public String getLoader(String inputFile, boolean isDebugMode) {
		String loader = MDTPreferencesPlugin.getDefault().getPreferenceStore().getString(MCorePreferencePage.GFORTH_LOADER_PREFERENCE);
		loader = loader.replace("$INPUT_FILE", inputFile);
		loader = loader.replace("$DEBUG_INCLUDE", isDebugMode ? "include debugCFunction.fs" : "");

		return loader;
	}

	/**
	 * Returns the umbilical set as preference.
	 * 
	 * @return
	 */
	public String getUmbilical() {
		final String umbilical = MDTPreferencesPlugin.getDefault().getPreferenceStore().getString(MCorePreferencePage.USB_DEVICE_NAME_PREFERENCE);
		if (umbilical != null && !umbilical.isEmpty() && Files.exists(Paths.get(umbilical))) {
			return umbilical;
		}

		// TODO check thread access
		// // not set or invalid
		// final SelectUSBDeviceDialog selectUsbDeviceDialog = new SelectUSBDeviceDialog(null);
		// final int response = selectUsbDeviceDialog.open();
		// if (response == SelectUSBDeviceDialog.OK) {
		// final String device = selectUsbDeviceDialog.getSelectedDevice();
		// return device;
		// }

		return null;
	}

	/**
	 * Returns the default loader.
	 * 
	 * @return
	 */
	private static String getDefaultLoader() {
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

}
