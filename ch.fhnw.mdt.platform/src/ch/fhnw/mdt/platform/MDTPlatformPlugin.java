package ch.fhnw.mdt.platform;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class MDTPlatformPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "ch.fhnw.mdt.platform"; //$NON-NLS-1$

	// The shared instance
	private static MDTPlatformPlugin plugin;

	private IMDTPlatform platformStrings;

	/**
	 * The constructor
	 */
	public MDTPlatformPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

		// parse the extension point registry
		parseRegistry();
	}

	private void parseRegistry() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		final IExtensionRegistry registry = Platform.getExtensionRegistry();
		final IExtensionPoint point = registry.getExtensionPoint("ch.fhnw.mdt.platform");
		final IExtension[] extensions = point.getExtensions();
		for (IExtension extension : extensions) {
			IConfigurationElement[] configurationElements = extension.getConfigurationElements();
			for (IConfigurationElement configurationElement : configurationElements) {
				switch (configurationElement.getName()) {
				case "platformStrings":
					platformStrings = (IMDTPlatform) Class.forName(configurationElement.getAttribute("class")).newInstance();
					break;
				}
			}
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
	public static MDTPlatformPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns the {@link IMDTPlatform}.
	 * 
	 * @return
	 */
	public IMDTPlatform getPlatformStrings() {
		return platformStrings;
	}

}
