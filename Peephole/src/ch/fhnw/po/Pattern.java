package ch.fhnw.po;

import ch.fhnw.po.operation.DyadicOperation;
import ch.fhnw.po.operation.Operation;

public class Pattern {
	private final DyadicOperation from;
	private final Operation to;

	public Pattern(DyadicOperation from, Operation to) {
		this.from = from;
		this.to = to;
	}
	
	@Override
	public String toString() {
		return from + " -> " + to;
	}

}
