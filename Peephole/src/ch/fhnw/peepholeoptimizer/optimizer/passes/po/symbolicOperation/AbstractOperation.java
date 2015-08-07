package ch.fhnw.peepholeoptimizer.optimizer.passes.po.symbolicOperation;

import java.util.function.Consumer;

import ch.fhnw.peepholeoptimizer.optimizer.passes.po.Memory;

public abstract class AbstractOperation implements Consumer<Memory> {

	/**
	 * Returns whether this operation matches the given instructions.
	 * 
	 * For example the input could be
	 * 
	 * <pre>
	 * swap
	 * </pre>
	 * 
	 * and should match a swap operation.
	 * 
	 * @param input
	 * @return
	 */
	public abstract boolean matches(String... input);

}
