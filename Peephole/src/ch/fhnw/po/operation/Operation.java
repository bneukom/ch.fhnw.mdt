package ch.fhnw.po.operation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import ch.fhnw.po.Memory;
import ch.fhnw.po.values.DyadicValue;
import ch.fhnw.po.values.SymbolicValue;
import ch.fhnw.po.values.DyadicValue.Operator;
import ch.fhnw.po.values.AbstractValue;

public class Operation extends AbstractOperation {

	
	public static final Operation NOP = new Operation("NOP", e -> {
	});

	public static final Operation DROP = new Operation("DROP", e -> e.stack.pop());
	
	public static final Operation DUP = new Operation("DUP", e -> e.stack.push(e.stack.peek()));

	public static final Operation PUSH = new Operation("PUSH", e -> e.stack.push(new SymbolicValue("$0")));
	
	public static final Operation SWAP = new Operation("SWAP", o -> {
		final AbstractValue tos = o.stack.pop();
		final AbstractValue nos = o.stack.pop();
		o.stack.push(tos);
		o.stack.push(nos);
	});

	public static final Operation ADD = new Operation("ADD", o -> {
		o.stack.push(new DyadicValue(o.stack.pop(), o.stack.pop(), Operator.PLUS));
	});
	
	// TODO ROT -ROT

	public static final List<Operation> OPERATIONS = Arrays.asList(PUSH, DROP, DUP,  SWAP, ADD, NOP);

	private final Consumer<Memory> operation;
	private final String name;

	public Operation(final String name, final Consumer<Memory> operation) {
		this.name = name;
		this.operation = operation;
	}

	@Override
	public void accept(Memory e) {
		operation.accept(e);
	}

	public static List<DyadicOperation> combinations() {
		final List<DyadicOperation> combinations = new ArrayList<>(OPERATIONS.size() * OPERATIONS.size());
		for (Operation o1 : OPERATIONS) {
			for (Operation o2 : OPERATIONS) {
				combinations.add(new DyadicOperation(o1, o2));
			}
		}
		
		return combinations;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
