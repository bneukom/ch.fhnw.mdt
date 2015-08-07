package ch.fhnw.peepholeoptimizer.optimizer.passes.po;

import ch.fhnw.peepholeoptimizer.optimizer.passes.po.symbolicOperation.DyadicSymbolicOperation;
import ch.fhnw.peepholeoptimizer.optimizer.passes.po.symbolicOperation.SymbolicOperation;

public class Pattern {
	private final DyadicSymbolicOperation from;
	private final SymbolicOperation to;

	public Pattern(DyadicSymbolicOperation from, SymbolicOperation to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public String toString() {
		return from + " -> " + to;
	}

	public SymbolicOperation getTo() {
		return to;
	}

	public boolean matches(String prev, String curr) {
		return from.matches(prev, curr);
	}

}
