package ch.fhnw.mdt.platform.linux;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import ch.fhnw.mdt.platform.IMDTPlatform;

public class LinuxMDTPlatform implements IMDTPlatform {

	public LinuxMDTPlatform() {
	}

	@Override
	public String getEnvironmentSeparators() {
		return ":";
	}

	@Override
	public String getShellPath() {
		return "/bin/bash";
	}

	@Override
	public boolean isPathVariable(String input) {
		return input.startsWith("$");
	}

	@Override
	public String getVariableName(String input) {
		return input.substring(1);
	}

	@Override
	public List<String> listUmbilicalPorts() {
		try {
			return Files.list(new File("/dev/").toPath()).filter(p -> p.toString().startsWith("/dev/ttyUSB")).map(p -> p.toString()).collect(Collectors.toList());
		} catch (IOException e) {
		}
		return Collections.emptyList();
	}

}
