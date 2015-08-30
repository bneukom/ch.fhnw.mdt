/*
 * generated by Xtext
 */
package ch.fhnw.mdt.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import ch.fhnw.mdt.services.UForthGrammarAccess;

public class UForthParser extends AbstractContentAssistParser {
	
	@Inject
	private UForthGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected ch.fhnw.mdt.ui.contentassist.antlr.internal.InternalUForthParser createParser() {
		ch.fhnw.mdt.ui.contentassist.antlr.internal.InternalUForthParser result = new ch.fhnw.mdt.ui.contentassist.antlr.internal.InternalUForthParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getInstructionAccess().getAlternatives(), "rule__Instruction__Alternatives");
					put(grammarAccess.getLITERALAccess().getAlternatives(), "rule__LITERAL__Alternatives");
					put(grammarAccess.getIntrinsicBranchWordsAccess().getNameAlternatives_0(), "rule__IntrinsicBranchWords__NameAlternatives_0");
					put(grammarAccess.getIntrinsicStackWordsAccess().getNameAlternatives_0(), "rule__IntrinsicStackWords__NameAlternatives_0");
					put(grammarAccess.getIntrinsicMemoryWordsAccess().getNameAlternatives_0(), "rule__IntrinsicMemoryWords__NameAlternatives_0");
					put(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameAlternatives_0(), "rule__IntrinsicArithmeticWords__NameAlternatives_0");
					put(grammarAccess.getWordAccess().getAlternatives(), "rule__Word__Alternatives");
					put(grammarAccess.getFunctionAccess().getGroup(), "rule__Function__Group__0");
					put(grammarAccess.getCreateAccess().getGroup(), "rule__Create__Group__0");
					put(grammarAccess.getCreateAccess().getGroup_2(), "rule__Create__Group_2__0");
					put(grammarAccess.getForthAccess().getInstructionsAssignment(), "rule__Forth__InstructionsAssignment");
					put(grammarAccess.getFunctionAccess().getWordsAssignment_2(), "rule__Function__WordsAssignment_2");
					put(grammarAccess.getCreateAccess().getNameAssignment_1(), "rule__Create__NameAssignment_1");
					put(grammarAccess.getCreateAccess().getLitAssignment_2_0(), "rule__Create__LitAssignment_2_0");
					put(grammarAccess.getIntrinsicBranchWordsAccess().getNameAssignment(), "rule__IntrinsicBranchWords__NameAssignment");
					put(grammarAccess.getIntrinsicStackWordsAccess().getNameAssignment(), "rule__IntrinsicStackWords__NameAssignment");
					put(grammarAccess.getIntrinsicMemoryWordsAccess().getNameAssignment(), "rule__IntrinsicMemoryWords__NameAssignment");
					put(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameAssignment(), "rule__IntrinsicArithmeticWords__NameAssignment");
					put(grammarAccess.getWordAccess().getNameAssignment_4(), "rule__Word__NameAssignment_4");
					put(grammarAccess.getWordAccess().getNameAssignment_5(), "rule__Word__NameAssignment_5");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			ch.fhnw.mdt.ui.contentassist.antlr.internal.InternalUForthParser typedParser = (ch.fhnw.mdt.ui.contentassist.antlr.internal.InternalUForthParser) parser;
			typedParser.entryRuleForth();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public UForthGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(UForthGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
