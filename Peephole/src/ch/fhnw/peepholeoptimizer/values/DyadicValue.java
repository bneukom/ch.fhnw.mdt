package ch.fhnw.peepholeoptimizer.values;

public class DyadicValue extends AbstractValue {
	private final AbstractValue v1;
	private final AbstractValue v2;

	private final Operator op;

	public DyadicValue(AbstractValue v1, AbstractValue v2, Operator op) {
		super();
		this.v1 = v1;
		this.v2 = v2;
		this.op = op;
	}

	@Override
	public String toString() {
		return "(" + v1.toString() + op.toString() + v2.toString() + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((op == null) ? 0 : op.hashCode());
		result = prime * result + ((v1 == null) ? 0 : v1.hashCode());
		result = prime * result + ((v2 == null) ? 0 : v2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DyadicValue other = (DyadicValue) obj;

		if (op != other.op)
			return false;
		
		// commutative
		if (v1.equals(other.v1) && v2.equals(other.v2) || v1.equals(other.v2) && v2.equals(other.v1))
			return true;

		return false;
	}

	public enum Operator {
		PLUS("+");

		private final String op;

		private Operator(String op) {
			this.op = op;
		}

		@Override
		public String toString() {
			return op;
		}
	}
}
