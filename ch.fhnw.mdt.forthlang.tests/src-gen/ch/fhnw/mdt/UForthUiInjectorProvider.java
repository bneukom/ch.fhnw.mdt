/*
 * generated by Xtext
 */
package ch.fhnw.mdt;

import org.eclipse.xtext.junit4.IInjectorProvider;

import com.google.inject.Injector;

public class UForthUiInjectorProvider implements IInjectorProvider {
	
	@Override
	public Injector getInjector() {
		return ch.fhnw.mdt.ui.internal.UForthActivator.getInstance().getInjector("ch.fhnw.mdt.UForth");
	}
	
}
