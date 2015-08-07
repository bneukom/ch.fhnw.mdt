package ch.fhnw.peepholeoptimizer.optimizer.passes.po;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import ch.fhnw.peepholeoptimizer.Tuple2;
import ch.fhnw.peepholeoptimizer.optimizer.OptimizerPass;
import ch.fhnw.peepholeoptimizer.optimizer.passes.po.symbolicOperation.DyadicSymbolicOperation;
import ch.fhnw.peepholeoptimizer.optimizer.passes.po.symbolicOperation.SymbolicOperation;

public class PO implements OptimizerPass {
	public static void main(String[] args) {
		PO po = new PO();
		po.pass(Arrays.asList("swap", "swap", "call _funa", "-rot", "rot"));
	}

	@Override
	public List<String> pass(List<String> input) {
		final List<DyadicSymbolicOperation> combinations = SymbolicOperation.combinations();

		final List<Tuple2<SymbolicOperation, Memory>> simulatedOperations = SymbolicOperation.OPERATIONS.stream().map(o -> {
			Memory e = new Memory();
			o.accept(e);
			return new Tuple2<>(o, e);
		}).collect(Collectors.toList());

		final List<Pattern> patterns = new ArrayList<>();

		for (DyadicSymbolicOperation dyadicSymbolicOperation : combinations) {
			final Memory dyadicSimulated = new Memory();
			dyadicSymbolicOperation.accept(dyadicSimulated);

			for (Tuple2<SymbolicOperation, Memory> operationMemoryTuple : simulatedOperations) {
				if (dyadicSimulated.equals(operationMemoryTuple.y)) {
					patterns.add(new Pattern(dyadicSymbolicOperation, operationMemoryTuple.x));
				}
			}
		}

		final ArrayList<String> optimized = new ArrayList<>(input);

		ListIterator<String> listIterator = optimized.listIterator();

		String prev = listIterator.next();
		while (listIterator.hasNext()) {
			String cur = (String) listIterator.next();

			if (prev != null) {
				for (Pattern pattern : patterns) {
					if (pattern.matches(prev, cur)) {
						System.out.println("applied: " + pattern);
						listIterator.remove();
						listIterator.previous();
						listIterator.remove();
						
						cur = listIterator.hasNext() ? listIterator.next() : null;

						// also remove NOP
						if (pattern.getTo() != SymbolicOperation.NOP) {
							listIterator.add(pattern.getTo().toString());
						}
						
						break;
					}
				}
			} 
			
			prev = cur;
		}
		
		System.out.println(optimized);

		return optimized;
	}
}
