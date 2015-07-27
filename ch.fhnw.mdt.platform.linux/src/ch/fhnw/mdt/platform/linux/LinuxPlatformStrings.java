package ch.fhnw.mdt.platform.linux;

import ch.fhnw.mdt.platform.PlatformStrings;

public class LinuxPlatformStrings implements PlatformStrings {

	public LinuxPlatformStrings() {
	}

	@Override
	public String getEnvironmentSeparators() {
		return ":";
	}

	@Override
	public String getShellPath() {
		return "/bin/bash";
	}

}
