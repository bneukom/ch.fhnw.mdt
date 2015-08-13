package ch.fhnw.mdt.ui.fortheditor.scanners;

import org.eclipse.jface.text.rules.*;

import ch.fhnw.mdt.ui.fortheditor.ColorManager;
import ch.fhnw.mdt.ui.fortheditor.ForthWhitespaceDetector;
import ch.fhnw.mdt.ui.fortheditor.IForthColorConstants;

import org.eclipse.jface.text.*;

public class ForthScanner extends RuleBasedScanner {

	public ForthScanner(ColorManager manager) {
		IToken procInstr = new Token(new TextAttribute(manager.getColor(IForthColorConstants.PROC_INSTR)));

		IRule[] rules = new IRule[2];
		// Add rule for processing instructions
		rules[0] = new SingleLineRule("<?", "?>", procInstr);
		// Add generic whitespace rule.
		rules[1] = new WhitespaceRule(new ForthWhitespaceDetector());

		setRules(rules);
	}
}
