package ch.fhnw.mdt.build;
import org.eclipse.cdt.managedbuilder.core.IManagedCommandLineGenerator;
import org.eclipse.cdt.managedbuilder.core.IManagedCommandLineInfo;
import org.eclipse.cdt.managedbuilder.core.ITool;


public class MCoreCommandLineGenerator implements IManagedCommandLineGenerator {

	public MCoreCommandLineGenerator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IManagedCommandLineInfo generateCommandLineInfo(ITool tool, String commandName, String[] flags, String outputFlag, String outputPrefix, String outputName,
			String[] inputResources, String commandLinePattern) {
		return null;
	}

}
