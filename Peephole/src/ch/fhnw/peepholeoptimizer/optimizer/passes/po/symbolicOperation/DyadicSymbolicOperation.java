package ch.fhnw.peepholeoptimizer.optimizer.passes.po.symbolicOperation;

import ch.fhnw.peepholeoptimizer.optimizer.passes.po.Memory;

public class DyadicSymbolicOperation extends AbstractOperation {
	private final SymbolicOperation o1;
	private final SymbolicOperation o2;

	public DyadicSymbolicOperation(SymbolicOperation o1, SymbolicOperation o2) {
		this.o1 = o1;
		this.o2 = o2;
	}

	@Override
	public void accept(Memory e) {
		o1.accept(e);
		o2.accept(e);
	}
	
	@Override
	public String toString() {
		return "[" + o1 + ", " + o2 + "]";
	}

	@Override
	public boolean matches(String... input) {
		return o1.matches(input[0]) && o2.matches(input[1]);
	}
}
