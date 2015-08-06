package ch.fhnw.po.operation;

import ch.fhnw.po.Memory;

public class DyadicOperation extends AbstractOperation {
	private final Operation o1;
	private final Operation o2;

	public DyadicOperation(Operation o1, Operation o2) {
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
}
