package ch.fhnw.mdt.platform;

import java.util.List;

/**
 * Returns platform specific strings.
 *
 */
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

	/**
	 * Returns whether this string represents a variable inside a path. For
	 * example on Unix $FOO is a variable inside a path.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isPathVariable(String input);

	/**
	 * Returns the name of the Path variable. For example on Unix the name of
	 * the variable $FOO is FOO.
	 * 
	 * @param input
	 * @return
	 */
	public String getVariableName(String input);

	/**
	 * Returns all available com ports.
	 * 
	 * @return all available com ports
	 */
	public List<String> listComPorts();
}
