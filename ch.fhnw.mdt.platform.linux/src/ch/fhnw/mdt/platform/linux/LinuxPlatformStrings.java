package ch.fhnw.mdt.platform.linux;

import ch.fhnw.mdt.platform.IPlatformStrings;

public class LinuxPlatformStrings implements IPlatformStrings {

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