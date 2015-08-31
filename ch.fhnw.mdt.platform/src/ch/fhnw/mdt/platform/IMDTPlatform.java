package ch.fhnw.mdt.platform;

import java.util.List;

/**
 * Platform specific operations.
 *
 */
public interface IMDTPlatform {

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
	 * Returns all available umbilical ports.
	 * 
	 * @return all available umbilical ports
	 */
	public List<String> listUmbilicalPorts();

	/**
	 * Returns <code>true</code> if the given port is valid.
	 * 
	 * @return
	 */
	public default boolean isValidUmbilicalPort(String port) {
		return listUmbilicalPorts().contains(port);
	}
}
