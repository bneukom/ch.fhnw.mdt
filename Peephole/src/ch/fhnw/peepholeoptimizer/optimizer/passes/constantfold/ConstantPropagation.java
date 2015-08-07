package ch.fhnw.peepholeoptimizer.optimizer.passes.constantfold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import ch.fhnw.peepholeoptimizer.optimizer.OptimizerPass;

public class ConstantPropagation implements OptimizerPass {

	@Override
	public List<String> pass(List<String> input) {

		List<ConstantPropagationOperation> operations = ConstantPropagationOperation.OPERATIONS;

		final LinkedList<Integer> previousConstants = new LinkedList<>();
		final ArrayList<String> result = new ArrayList<>(input);
		ListIterator<String> listIterator = result.listIterator();

		while (listIterator.hasNext()) {
			final String instruction = (String) listIterator.next();

			if (instruction.matches("-?[0-9a-fA-F]+")) {
				previousConstants.addLast(Integer.parseInt(instruction, 16));
			} else {
				boolean executed = false;
				for (ConstantPropagationOperation operation : operations) {
					if (operation.isOperation(instruction) && previousConstants.size() >= operation.getRequiredStackSize()) {

						List<Integer> operationResult = operation
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
						for (Integer res : operationResult) {
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
		}

		System.out.println(result);
		return result;
	}

	public static void main(String[] args) {
		ConstantPropagation po = new ConstantPropagation();
		po.pass(Arrays.asList("1", "2", "1", "swap", "dup", "dup"));
	}

}
