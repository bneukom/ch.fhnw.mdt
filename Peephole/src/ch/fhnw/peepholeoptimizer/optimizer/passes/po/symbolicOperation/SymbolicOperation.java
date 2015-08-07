package ch.fhnw.peepholeoptimizer.optimizer.passes.po.symbolicOperation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import ch.fhnw.peepholeoptimizer.optimizer.passes.po.Memory;
import ch.fhnw.peepholeoptimizer.values.AbstractValue;
import ch.fhnw.peepholeoptimizer.values.DyadicValue;
import ch.fhnw.peepholeoptimizer.values.SymbolicValue;
import ch.fhnw.peepholeoptimizer.values.DyadicValue.Operator;

public class SymbolicOperation extends AbstractOperation {

	public static final SymbolicOperation NOP = new SymbolicOperation("nop", true, e -> {
	});

	public static final SymbolicOperation DROP = new SymbolicOperation("drop", true, e -> e.stack.pop());

	public static final SymbolicOperation DUP = new SymbolicOperation("dup", true, e -> e.stack.push(e.stack.peek()));

	public static final SymbolicOperation PUSH = new SymbolicOperation("push", false, e -> e.stack.push(new SymbolicValue("$0")));

	public static final SymbolicOperation SWAP = new SymbolicOperation("swap", true, o -> {
		final AbstractValue tos = o.stack.pop();
		final AbstractValue nos = o.stack.pop();
		o.stack.push(tos);
		o.stack.push(nos);
	});

	public static final SymbolicOperation ADD = new SymbolicOperation("+", true, o -> {
		o.stack.push(new DyadicValue(o.stack.pop(), o.stack.pop(), Operator.PLUS));
	});

	public static final SymbolicOperation UNNOKWN = new SymbolicOperation("unknown", false, null);

	public static final SymbolicOperation ROT = new SymbolicOperation("rot", true, e -> {
		final AbstractValue v3 = e.stack.pop();
		final AbstractValue v2 = e.stack.pop();
		final AbstractValue v1 = e.stack.pop();

		e.stack.push(v2);
		e.stack.push(v3);
		e.stack.push(v1);
	});
	
	public static final SymbolicOperation NEG_ROT = new SymbolicOperation("-rot", true, e -> {
		final AbstractValue v3 = e.stack.pop();
		final AbstractValue v2 = e.stack.pop();
		final AbstractValue v1 = e.stack.pop();

		e.stack.push(v3);
		e.stack.push(v1);
		e.stack.push(v2);
	});

	public static final List<SymbolicOperation> OPERATIONS = Arrays.asList(PUSH, DROP, DUP, SWAP, ADD, ROT, NEG_ROT, NOP);

	private final Consumer<Memory> operation;
	private final String name;

	private final boolean matchesName;

	public SymbolicOperation(final String name, final boolean matchesName, final Consumer<Memory> operation) {
		this.name = name;
		this.matchesName = matchesName;
		this.operation = operation;
	}

	@Override
	public void accept(final Memory e) {
		operation.accept(e);
	}

	/**
	 * Returns all possible {@link DyadicSymbolicOperation} combinations except the NOP.
	 * 
	 * @return
	 */
	public static List<DyadicSymbolicOperation> combinations() {
		final List<DyadicSymbolicOperation> combinations = new ArrayList<>(OPERATIONS.size() * OPERATIONS.size());
		for (final SymbolicOperation o1 : OPERATIONS) {
			if (o1 != NOP) {
				for (final SymbolicOperation o2 : OPERATIONS) {
					if (o2 != NOP)
						combinations.add(new DyadicSymbolicOperation(o1, o2));
				}
			}
		}

		return combinations;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean matches(final String... input) {
		if (matchesName)
			return name.equals(input[0]);
		return false;
	}
}
