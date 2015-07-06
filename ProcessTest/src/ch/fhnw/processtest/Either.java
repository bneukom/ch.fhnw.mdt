package ch.fhnw.processtest;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public final class Either<L, R> {
	public static <L, R> Either<L, R> left(final L value) {
		return new Either<>(Optional.of(value), Optional.empty());
	}

	public static <L, R> Either<L, R> right(final R value) {
		return new Either<>(Optional.empty(), Optional.of(value));
	}

	private final Optional<L> left;
	private final Optional<R> right;

	private Either(final Optional<L> l, final Optional<R> r) {
		left = l;
		right = r;
	}

	public <T> T map(final Function<? super L, ? extends T> lFunc, final Function<? super R, ? extends T> rFunc) {
		return left.map(lFunc).orElseGet(() -> right.map(rFunc).get());
	}

	public <T> Either<T, R> mapLeft(final Function<? super L, ? extends T> lFunc) {
		return new Either<>(left.map(lFunc), right);
	}

	public <T> Either<L, T> mapRight(final Function<? super R, ? extends T> rFunc) {
		return new Either<>(left, right.map(rFunc));
	}

	public void apply(final Consumer<? super L> lFunc, final Consumer<? super R> rFunc) {
		left.ifPresent(lFunc);
		right.ifPresent(rFunc);
	}
}