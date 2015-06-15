package ch.fhnw.mdt.debugger.lcc;

import java.math.BigInteger;

import org.eclipse.cdt.debug.core.cdi.ICDILocation;
import org.eclipse.cdt.debug.core.cdi.ICDILocator;

public class LCCLocator implements ICDILocator {

	private final String file;
	private final String function;
	private final BigInteger address;
	private final int lineNumber;

	public LCCLocator(String file, String function, BigInteger address, int lineNumber) {
		this.file = file;
		this.function = function;
		this.address = address;
		this.lineNumber = lineNumber;
	}

	@Override
	public String getFile() {
		return file;
	}

	@Override
	public int getLineNumber() {
		return lineNumber;
	}

	@Override
	public String getFunction() {
		return function;
	}

	@Override
	public BigInteger getAddress() {
		return address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((file == null) ? 0 : file.hashCode());
		result = prime * result + ((function == null) ? 0 : function.hashCode());
		result = prime * result + lineNumber;
		return result;
	}

	@Override
	public boolean equals(ICDILocation obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LCCLocator other = (LCCLocator) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (file == null) {
			if (other.file != null)
				return false;
		} else if (!file.equals(other.file))
			return false;
		if (function == null) {
			if (other.function != null)
				return false;
		} else if (!function.equals(other.function))
			return false;
		if (lineNumber != other.lineNumber)
			return false;
		return true;
	}

}
