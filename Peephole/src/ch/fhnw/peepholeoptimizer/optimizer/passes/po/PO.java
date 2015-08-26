package ch.fhnw.peepholeoptimizer.optimizer.passes.po;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import ch.fhnw.peepholeoptimizer.PeepholeOptimizer;
import ch.fhnw.peepholeoptimizer.Tuple2;
import ch.fhnw.peepholeoptimizer.optimizer.OptimizerPass;
import ch.fhnw.peepholeoptimizer.optimizer.passes.po.symbolicOperation.DyadicSymbolicOperation;
import ch.fhnw.peepholeoptimizer.optimizer.passes.po.symbolicOperation.SymbolicOperation;

/**
 * Based on Automatic Generation of Peephole Optimizations by Jack W. Davidson and Christohper W. Fraser.
 * 
 * @author Benjamin
 *
 */
public class PO implements OptimizerPass {
	final List<DyadicSymbolicOperation> combinations = SymbolicOperation.combinations();

	final List<Pattern> patterns = new ArrayList<>();

	private static final int FUNCTION = 0;
	private static final int OTHER = 1;

	public PO() {
		final List<Tuple2<SymbolicOperation, Memory>> simulatedOperations = SymbolicOperation.OPERATIONS.stream().map(o -> {
			Memory e = new Memory();
			o.accept(e);
			return new Tuple2<>(o, e);
		}).collect(Collectors.toList());

		for (DyadicSymbolicOperation dyadicSymbolicOperation : combinations) {
			final Memory dyadicSimulated = new Memory();
			dyadicSymbolicOperation.accept(dyadicSimulated);

			for (Tuple2<SymbolicOperation, Memory> operationMemoryTuple : simulatedOperations) {
				if (dyadicSimulated.equals(operationMemoryTuple.y)) {
					patterns.add(new Pattern(dyadicSymbolicOperation, operationMemoryTuple.x));
				}
			}
		}
	}

	@Override
	public List<String> pass(List<String> input) {
		PeepholeOptimizer.LOGGER.fine("- PO Pass");

		final ArrayList<String> optimized = new ArrayList<>(input);

		ListIterator<String> listIterator = optimized.listIterator();

		String prev = null;
		int state = OTHER;

		while (listIterator.hasNext()) {
			String cur = (String) listIterator.next();

			switch (state) {
			case OTHER:
				if (cur.trim().matches(": .*")) {
					prev = cur;
					state = FUNCTION;
				}
				break;
			case FUNCTION:
				if (cur.trim().matches(";")) {
					prev = null;
					state = OTHER;
				} else {
					if (prev != null) {
						boolean matched = false;
						for (Pattern pattern : patterns) {
							if (pattern.matches(prev, cur)) {
								listIterator.remove();
								listIterator.previous();
								listIterator.remove();
								

								PeepholeOptimizer.LOGGER.fine("\tApplied Pattern: " + pattern.toString());

								// also remove NOP
								if (pattern.getTo() != SymbolicOperation.NOP) {
									listIterator.add(pattern.getTo().toString());
								}

								cur = listIterator.hasPrevious() ? listIterator.previous() : null;
								prev = null;

								matched = true;
								break;
							}
						}

						if (!matched) {
							prev = cur;
						}
					} else {
						prev = cur;
					}

				}
				break;
			default:
				break;
			}

		}

		PeepholeOptimizer.LOGGER.fine("Size after PO:" + optimized);
		return optimized;
	}

	public static void main(String[] args) {
		PO po = new PO();
		po.pass(Arrays.asList("swap", "swap", "call _funa", "-rot", "rot"));
	}
}
