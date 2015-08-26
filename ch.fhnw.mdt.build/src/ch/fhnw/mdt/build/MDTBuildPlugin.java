package ch.fhnw.mdt.build;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import ch.fhnw.mdt.build.nature.McoreNatureCore;

/**
 * The activator class controls the plug-in life cycle
 */
public class MDTBuildPlugin extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "ch.fhnw.mdt.build"; //$NON-NLS-1$
	
	
	private static MDTBuildPlugin plugin;

	/**
	 * The constructor
	 */
	public MDTBuildPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

		McoreNatureCore.initialize();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
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
	public static MDTBuildPlugin getDefault() {
		return plugin;
	}

}
