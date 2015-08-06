package ch.fhnw.po;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

import ch.fhnw.po.values.SymbolicValue;
import ch.fhnw.po.values.AbstractValue;

public class Memory {
	public final LinkedList<AbstractValue> stack = new LinkedList<>();

	public Memory() {
		stack.addAll(Arrays.asList(
				new SymbolicValue("$1"),
				new SymbolicValue("$2"),
				new SymbolicValue("$3"),
				new SymbolicValue("$4"),
				new SymbolicValue("$5")));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stack == null) ? 0 : stack.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Memory other = (Memory) obj;

		if (other.stack.size() != stack.size())
			return false;

		final Iterator<AbstractValue> i1 = stack.iterator();
		final Iterator<AbstractValue> i2 = other.stack.iterator();

		while (i1.hasNext()) {
			final AbstractValue next1 = i1.next();
			final AbstractValue next2 = i2.next();

			if (!next1.equals(next2))
				return false;
		}

		return true;
	}
	
	@Override
	public String toString() {
		return "S" + stack.toString();
	}

}
