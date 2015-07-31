package ch.fhnw.mdt.forthdebugger.ui.memoryrendering;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.ui.memory.IMemoryRendering;
import org.eclipse.debug.ui.memory.IMemoryRenderingTypeDelegate;

public class ForthMemoryRenderingTypeDelegate implements IMemoryRenderingTypeDelegate {

	public ForthMemoryRenderingTypeDelegate() {
	}

	@Override
	public IMemoryRendering createRendering(String id) throws CoreException {
		return new ForthTableRendering2(id);
	}

}
