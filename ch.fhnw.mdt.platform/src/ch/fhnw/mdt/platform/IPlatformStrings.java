package ch.fhnw.mdt.platform;

public interface IPlatformStrings {
	/**
	 * Returns the separator for environment variables.
	 * 
	 * @return the separator for environment variables
	 */
	public String getEnvironmentSeparators();

	/**
	 * Returns the path to the OS shell.
	 * 
	 * @return the path to the OS shell
	 */
	public String getShellPath();
}
