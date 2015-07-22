package ch.fhnw.mdt.forthdebugger.ui;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.ui.memory.IMemoryRenderingBindingsListener;
import org.eclipse.debug.ui.memory.IMemoryRenderingBindingsProvider;
import org.eclipse.debug.ui.memory.IMemoryRenderingType;

public class ForthMemoryRenderingBindingProvider implements IMemoryRenderingBindingsProvider {

	public ForthMemoryRenderingBindingProvider() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IMemoryRenderingType[] getRenderingTypes(IMemoryBlock block) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMemoryRenderingType[] getDefaultRenderingTypes(IMemoryBlock block) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMemoryRenderingType getPrimaryRenderingType(IMemoryBlock block) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addListener(IMemoryRenderingBindingsListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeListener(IMemoryRenderingBindingsListener listener) {
		// TODO Auto-generated method stub

	}

}
