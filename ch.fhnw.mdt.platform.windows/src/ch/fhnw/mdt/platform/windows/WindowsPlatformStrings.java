package ch.fhnw.mdt.platform.windows;

import java.util.List;

import ch.fhnw.mdt.platform.IPlatformStrings;

public class WindowsPlatformStrings implements IPlatformStrings {
	
	private final ComPortEnumerator comPortEnumerator = new ComPortEnumerator();
	
	public WindowsPlatformStrings() {
	}

	@Override
	public String getEnvironmentSeparators() {
		return ";";
	}

	@Override
	public String getShellPath() {
		return "cmd";
	}

	@Override
	public boolean isPathVariable(String input) {
		return input.startsWith("%") && input.endsWith("%");
	}

	@Override
	public String getVariableName(String input) {
		return input.substring(1, input.length() - 1);
	}

	@Override
	public List<String> listComPorts() {
		return comPortEnumerator.listPorts();
	}

}
