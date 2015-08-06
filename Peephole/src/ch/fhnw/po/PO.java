package ch.fhnw.po;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ch.fhnw.po.operation.DyadicOperation;
import ch.fhnw.po.operation.Operation;

public class PO {
	public static void main(String[] args) {
		List<DyadicOperation> combinations = Operation.combinations();
		
		final List<Tuple2<Operation, Memory>> simulatedOperations = Operation.OPERATIONS.stream().map(o -> {
			Memory e = new Memory();
			o.accept(e);
			return new Tuple2<>(o, e);
		}).collect(Collectors.toList());
			
		final List<Pattern> patterns = new ArrayList<>();
		
		for (DyadicOperation dyadicOperation : combinations) {
			final Memory dyadicSimulated = new Memory();
			dyadicOperation.accept(dyadicSimulated);
			
			for (Tuple2<Operation, Memory> operationMemoryTuple : simulatedOperations) {
				if (dyadicSimulated.equals(operationMemoryTuple.y)) {
					patterns.add(new Pattern(dyadicOperation, operationMemoryTuple.x));
				}
			}
		}
		
		System.out.println(patterns);
	}
}
