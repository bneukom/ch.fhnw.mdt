/*
 * generated by Xtext
 */
package ch.fhnw.mdt.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import ch.fhnw.mdt.ui.internal.UForthActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class UForthExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return UForthActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return UForthActivator.getInstance().getInjector(UForthActivator.CH_FHNW_MDT_UFORTH);
	}
	
}