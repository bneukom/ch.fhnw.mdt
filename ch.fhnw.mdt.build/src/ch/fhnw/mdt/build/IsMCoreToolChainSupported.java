package ch.fhnw.mdt.build;
import java.util.List;

import org.eclipse.cdt.managedbuilder.core.IManagedIsToolChainSupported;
import org.eclipse.cdt.managedbuilder.core.IToolChain;
import org.osgi.framework.Version;


public class IsMCoreToolChainSupported implements IManagedIsToolChainSupported {

	@Override
	public boolean isSupported(IToolChain toolChain, Version version,
			String instance) {
		return false;
	}

}
