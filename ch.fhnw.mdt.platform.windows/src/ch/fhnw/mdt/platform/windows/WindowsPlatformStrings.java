package ch.fhnw.mdt.platform.windows;

import ch.fhnw.mdt.platform.PlatformStrings;

public class WindowsPlatformStrings implements PlatformStrings {

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
