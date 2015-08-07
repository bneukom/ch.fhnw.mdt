package ch.fhnw.peepholeoptimizer.optimizer.passes.constantfold;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ConstantPropagationOperation implements Function<List<Integer>, List<Integer>> {
	private final int requiredStackSize;
	private final String operationName;
	private final Function<List<Integer>, List<Integer>> function;

	public ConstantPropagationOperation(int requiredStackSize, String operationName, Function<List<Integer>, List<Integer>> function) {
		this.requiredStackSize = requiredStackSize;
		this.operationName = operationName;
		this.function = function;
	}

	public static final ConstantPropagationOperation SWAP = new ConstantPropagationOperation(2, "swap", i -> Arrays.asList(i.get(1), i.get(0)));
	public static final ConstantPropagationOperation DUP = new ConstantPropagationOperation(1, "dup", i -> Arrays.asList(i.get(0), i.get(0)));
	public static final ConstantPropagationOperation ROT = new ConstantPropagationOperation(3, "rot", i -> Arrays.asList(i.get(1), i.get(2), i.get(0)));
	public static final ConstantPropagationOperation NEG_ROT = new ConstantPropagationOperation(3, "-rot", i -> Arrays.asList(i.get(2), i.get(0), i.get(1)));
	public static final ConstantPropagationOperation NEGATE = new ConstantPropagationOperation(1, "negate", i -> Arrays.asList(-i.get(0)));
	public static final ConstantPropagationOperation ADD = new ConstantPropagationOperation(2, "+", i -> Arrays.asList(i.get(0) + i.get(1)));
	public static final ConstantPropagationOperation MUL = new ConstantPropagationOperation(2, "*", i -> Arrays.asList(i.get(0) * i.get(1)));

	public static final List<ConstantPropagationOperation> OPERATIONS = Arrays.asList(SWAP, DUP, ROT, NEG_ROT, ADD, MUL, NEGATE);

	public int getRequiredStackSize() {
		return requiredStackSize;
	}

	public boolean isOperation(String line) {
		return line.equals(operationName);
	}

	@Override
	public List<Integer> apply(List<Integer> t) {
		return function.apply(t);
	}

}
