package ch.fhnw.peepholeoptimizer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import ch.fhnw.peepholeoptimizer.optimizer.OptimizerPass;
import ch.fhnw.peepholeoptimizer.optimizer.passes.constantfold.ConstantPropagation;
import ch.fhnw.peepholeoptimizer.optimizer.passes.po.PO;

public class PeepholeOptimizer {

	private final List<OptimizerPass> passes = Arrays.asList(new PO(), new ConstantPropagation());
	// private final List<OptimizerPass> passes = Arrays.asList(new PO());

	public List<String> optimize(final List<String> file) {
		return passes.stream().reduce(file, (s, p) -> p.pass(s), (s1, s2) -> s1);
	}

	public static void main(final String[] args) throws IOException {
		if (args.length == 1) {
			final List<String> source = Files.readAllLines(Paths.get(args[0]));
			System.out.println(source.size());
			final PeepholeOptimizer optimizer = new PeepholeOptimizer();
			final List<String> optimize = optimizer.optimize(source);
			System.out.println(optimize);
			System.out.println(optimize.size());
		} else {
			// final PeepholeOptimizer optimizer = new PeepholeOptimizer();
			// final List<String> optimize = optimizer.optimize(Arrays.asList("1", "2", "swap", "negate", "dup", "+", "+"));
			// System.out.println(optimize);
		}

	}
}
