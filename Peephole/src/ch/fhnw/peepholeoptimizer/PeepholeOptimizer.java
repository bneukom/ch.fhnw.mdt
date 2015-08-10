package ch.fhnw.peepholeoptimizer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import ch.fhnw.peepholeoptimizer.optimizer.OptimizerPass;
import ch.fhnw.peepholeoptimizer.optimizer.passes.constantfold.ConstantPropagation;
import ch.fhnw.peepholeoptimizer.optimizer.passes.po.PO;

public class PeepholeOptimizer {

	private final List<OptimizerPass> passes = Arrays.asList(new PO(), new ConstantPropagation());
	public static final Logger LOGGER = Logger.getLogger(PeepholeOptimizer.class.getName());

	static {
		System.setProperty("java.util.logging.SimpleFormatter.format", "%5$s %n");

		final ConsoleHandler handler = new ConsoleHandler();
		handler.setFormatter(new SimpleFormatter());
		handler.setLevel(Level.ALL);

		LOGGER.addHandler(handler);
	}

	public List<String> optimize(final List<String> file) {
		return passes.stream().reduce(file, (s, p) -> p.pass(s), (s1, s2) -> s1);
	}

	public static void main(final String[] args) throws IOException {
		if (args.length == 1) {
			optimize(args[0]);
		} else if (args.length == 2) {
			if (args[0].equals("-d")) {
				LOGGER.setLevel(Level.ALL);
			} else {
				invalidUsage();
			}
			optimize(args[1]);
		} else {
			invalidUsage();
		}
	}

	private static void optimize(final String path) throws IOException {
		final List<String> source = Files.readAllLines(Paths.get(path));
		LOGGER.fine("Source Size: " + source.size());
		LOGGER.fine("Source: " + source);
		final PeepholeOptimizer optimizer = new PeepholeOptimizer();
		final List<String> optimize = optimizer.optimize(source);
		
		Files.write(Paths.get("optimized.fs"), optimize.stream().reduce((s1, s2) -> s1 + System.lineSeparator() + s2).orElseGet(() -> "").getBytes());

		LOGGER.fine("Optimized Size: " + optimize.size());
	}

	private static final void invalidUsage() {
		System.err.println("Usage: peephole [-d] /foo/bar.fs");
		System.exit(0);
	}
}
