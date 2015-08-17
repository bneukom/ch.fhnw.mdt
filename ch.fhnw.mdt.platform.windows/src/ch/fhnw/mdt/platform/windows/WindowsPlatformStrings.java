package ch.fhnw.mdt.platform.windows;

import ch.fhnw.mdt.platform.IPlatformStrings;

public class WindowsPlatformStrings implements IPlatformStrings {

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

}
