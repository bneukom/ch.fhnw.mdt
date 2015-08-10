package ch.fhnw.peepholeoptimizer.optimizer.passes.constantfold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import ch.fhnw.peepholeoptimizer.PeepholeOptimizer;
import ch.fhnw.peepholeoptimizer.optimizer.OptimizerPass;

public class ConstantPropagation implements OptimizerPass {

	private static final int FUNCTION = 0;
	private static final int OTHER = 1;

	@Override
	public List<String> pass(List<String> input) {
		PeepholeOptimizer.LOGGER.fine("- Constant Propagation Pass");
		final List<ConstantPropagationOperation> operations = ConstantPropagationOperation.OPERATIONS;
		final LinkedList<Long> previousConstants = new LinkedList<>();
		final ArrayList<String> result = new ArrayList<>(input);
		final ListIterator<String> listIterator = result.listIterator();

		int state = OTHER;
		while (listIterator.hasNext()) {
			final String instruction = (String) listIterator.next();

			switch (state) {
			case OTHER:
				if (instruction.trim().matches(": .*")) {
					state = FUNCTION;
				}
				break;
			case FUNCTION:
				if (instruction.trim().matches(";")) {
					state = OTHER;
					previousConstants.clear();
				} else if (instruction.trim().matches("-?[0-9a-fA-F]+")) {
					previousConstants.addLast(Long.parseLong(instruction, 16));
				} else {
					boolean executed = false;
					for (ConstantPropagationOperation operation : operations) {
						if (operation.isOperation(instruction) && previousConstants.size() >= operation.getRequiredStackSize()) {

							PeepholeOptimizer.LOGGER.fine("\tFold: " + operation);
							List<Long> operationResult = operation
									.apply(previousConstants.subList(previousConstants.size() - operation.getRequiredStackSize(), previousConstants.size()));

							// remove used elements
							int removeStack = operation.getRequiredStackSize();

							// remove the instruction
							listIterator.remove();
							listIterator.previous();

							int prev = removeStack;
							while (removeStack > 0) {
								listIterator.remove();
								previousConstants.removeLast();

								// might have been the very first
								if (listIterator.hasPrevious()) {
									listIterator.previous();
									prev--;
								}

								removeStack--;
							}

							// no need to go forward if the operation has consumed until the very beginning
							if (prev == 0 && listIterator.hasNext()) {
								listIterator.next();
							}

							// add computed elements
							for (Long res : operationResult) {
								listIterator.add(res.toString());
								previousConstants.add(res);
							}

							executed = true;
							break;
						}
					}

					if (!executed) {
						previousConstants.clear();
					}
				}
				break;
			default:
				break;
			}

		}

		PeepholeOptimizer.LOGGER.fine("Size after Constant Propagation: " + result);
		return result;
	}

	public static void main(String[] args) {
		ConstantPropagation po = new ConstantPropagation();
		po.pass(Arrays.asList("1", "2", "1", "swap", "dup", "dup"));
	}

}
