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

}
