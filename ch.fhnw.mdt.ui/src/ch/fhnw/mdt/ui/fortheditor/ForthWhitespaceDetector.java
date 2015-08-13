package ch.fhnw.mdt.ui.fortheditor;

import org.eclipse.jface.text.rules.IWhitespaceDetector;

public class ForthWhitespaceDetector implements IWhitespaceDetector {

	@Override
	public boolean isWhitespace(char c) {
		return (c == ' ' || c == '\t' || c == '\n' || c == '\r');
	}
}
