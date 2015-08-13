package ch.fhnw.mdt.ui.fortheditor;

import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;

import ch.fhnw.mdt.ui.fortheditor.rules.NumberRule;

public class ForthPartitionScanner extends RuleBasedPartitionScanner {
	public final static String FORTH_COMMENT = "__forth_comment";
	public final static String FORTH_NUMBER = "__forht_number";

	public ForthPartitionScanner() {

		IToken xmlComment = new Token(FORTH_COMMENT);
		IToken tag = new Token(FORTH_NUMBER);

		IPredicateRule[] rules = new IPredicateRule[2];

		rules[0] = new SingleLineRule("(", ")", xmlComment);
		rules[1] = new NumberRule(tag);

		setPredicateRules(rules);
	}
}
