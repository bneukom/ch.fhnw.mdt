package ch.fhnw.peepholeoptimizer.optimizer;

import java.util.List;

public interface OptimizerPass {

	/**
	 * Executes this pass of the optimizer.
	 * 
	 * @param input
	 * @return
	 */
	public List<String> pass(final List<String> input);
}
