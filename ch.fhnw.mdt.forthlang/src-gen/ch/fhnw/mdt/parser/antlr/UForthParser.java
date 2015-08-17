/*
 * generated by Xtext
 */
package ch.fhnw.mdt.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import ch.fhnw.mdt.services.UForthGrammarAccess;

public class UForthParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private UForthGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected ch.fhnw.mdt.parser.antlr.internal.InternalUForthParser createParser(XtextTokenStream stream) {
		return new ch.fhnw.mdt.parser.antlr.internal.InternalUForthParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "Forth";
	}
	
	public UForthGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(UForthGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
