/*
 * generated by Xtext
 */
parser grammar InternalUForthParser;

options {
	tokenVocab=InternalUForthLexer;
	superClass=AbstractInternalContentAssistParser;
	
}

@header {
package ch.fhnw.mdt.ui.contentassist.antlr.internal; 

import java.util.Map;
import java.util.HashMap;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import ch.fhnw.mdt.services.UForthGrammarAccess;

}

@members {
 
 	private UForthGrammarAccess grammarAccess;
 	
 	private final Map<String, String> tokenNameToValue = new HashMap<String, String>();
 	
 	{
		tokenNameToValue.put("Comma", "','");
		tokenNameToValue.put("Colon", "':'");
		tokenNameToValue.put("Semicolon", "';'");
		tokenNameToValue.put("DUP", "'DUP'");
		tokenNameToValue.put("NIP", "'NIP'");
		tokenNameToValue.put("ROT", "'ROT'");
		tokenNameToValue.put("ROT_1", "'-ROT'");
		tokenNameToValue.put("CALL", "'CALL'");
		tokenNameToValue.put("OVER", "'OVER'");
		tokenNameToValue.put("SWAP", "'SWAP'");
		tokenNameToValue.put("TUCK", "'TUCK'");
		tokenNameToValue.put("UNDER", "'UNDER'");
		tokenNameToValue.put("NEGATE", "'NEGATE'");
		tokenNameToValue.put("Create", "'create'");
 	}
 	
    public void setGrammarAccess(UForthGrammarAccess grammarAccess) {
    	this.grammarAccess = grammarAccess;
    }
    
    @Override
    protected Grammar getGrammar() {
    	return grammarAccess.getGrammar();
    }

	@Override
    protected String getValueForTokenName(String tokenName) {
    	String result = tokenNameToValue.get(tokenName);
    	if (result == null)
    		result = tokenName;
    	return result;
    }
}




// Entry rule entryRuleForth
entryRuleForth 
:
{ before(grammarAccess.getForthRule()); }
	 ruleForth
{ after(grammarAccess.getForthRule()); } 
	 EOF 
;

// Rule Forth
ruleForth 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getForthAccess().getInstructionsAssignment()); }
(rule__Forth__InstructionsAssignment)*
{ after(grammarAccess.getForthAccess().getInstructionsAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleGlobalInstruction
entryRuleGlobalInstruction 
:
{ before(grammarAccess.getGlobalInstructionRule()); }
	 ruleGlobalInstruction
{ after(grammarAccess.getGlobalInstructionRule()); } 
	 EOF 
;

// Rule GlobalInstruction
ruleGlobalInstruction 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getGlobalInstructionAccess().getAlternatives()); }
(rule__GlobalInstruction__Alternatives)
{ after(grammarAccess.getGlobalInstructionAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleFunction
entryRuleFunction 
:
{ before(grammarAccess.getFunctionRule()); }
	 ruleFunction
{ after(grammarAccess.getFunctionRule()); } 
	 EOF 
;

// Rule Function
ruleFunction 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getFunctionAccess().getGroup()); }
(rule__Function__Group__0)
{ after(grammarAccess.getFunctionAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleCreate
entryRuleCreate 
:
{ before(grammarAccess.getCreateRule()); }
	 ruleCreate
{ after(grammarAccess.getCreateRule()); } 
	 EOF 
;

// Rule Create
ruleCreate 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getCreateAccess().getGroup()); }
(rule__Create__Group__0)
{ after(grammarAccess.getCreateAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleKeywords
entryRuleKeywords 
:
{ before(grammarAccess.getKeywordsRule()); }
	 ruleKeywords
{ after(grammarAccess.getKeywordsRule()); } 
	 EOF 
;

// Rule Keywords
ruleKeywords 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getKeywordsAccess().getNameAssignment()); }
(rule__Keywords__NameAssignment)
{ after(grammarAccess.getKeywordsAccess().getNameAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleInstruction
entryRuleInstruction 
:
{ before(grammarAccess.getInstructionRule()); }
	 ruleInstruction
{ after(grammarAccess.getInstructionRule()); } 
	 EOF 
;

// Rule Instruction
ruleInstruction 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getInstructionAccess().getAlternatives()); }
(rule__Instruction__Alternatives)
{ after(grammarAccess.getInstructionAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleLiteral
entryRuleLiteral 
:
{ before(grammarAccess.getLiteralRule()); }
	 ruleLiteral
{ after(grammarAccess.getLiteralRule()); } 
	 EOF 
;

// Rule Literal
ruleLiteral 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getLiteralAccess().getAlternatives()); }
(rule__Literal__Alternatives)
{ after(grammarAccess.getLiteralAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleWord
entryRuleWord 
:
{ before(grammarAccess.getWordRule()); }
	 ruleWord
{ after(grammarAccess.getWordRule()); } 
	 EOF 
;

// Rule Word
ruleWord 
    @init {
		int stackSize = keepStackSize();
    }
    :
(
{ before(grammarAccess.getWordAccess().getNameAssignment()); }
(rule__Word__NameAssignment)
{ after(grammarAccess.getWordAccess().getNameAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__GlobalInstruction__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getGlobalInstructionAccess().getCreateParserRuleCall_0()); }
	ruleCreate
{ after(grammarAccess.getGlobalInstructionAccess().getCreateParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getGlobalInstructionAccess().getFunctionParserRuleCall_1()); }
	ruleFunction
{ after(grammarAccess.getGlobalInstructionAccess().getFunctionParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getGlobalInstructionAccess().getInstructionParserRuleCall_2()); }
	ruleInstruction
{ after(grammarAccess.getGlobalInstructionAccess().getInstructionParserRuleCall_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Keywords__NameAlternatives_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getKeywordsAccess().getNameSWAPKeyword_0_0()); }

	SWAP 

{ after(grammarAccess.getKeywordsAccess().getNameSWAPKeyword_0_0()); }
)

    |(
{ before(grammarAccess.getKeywordsAccess().getNameOVERKeyword_0_1()); }

	OVER 

{ after(grammarAccess.getKeywordsAccess().getNameOVERKeyword_0_1()); }
)

    |(
{ before(grammarAccess.getKeywordsAccess().getNameNIPKeyword_0_2()); }

	NIP 

{ after(grammarAccess.getKeywordsAccess().getNameNIPKeyword_0_2()); }
)

    |(
{ before(grammarAccess.getKeywordsAccess().getNameUNDERKeyword_0_3()); }

	UNDER 

{ after(grammarAccess.getKeywordsAccess().getNameUNDERKeyword_0_3()); }
)

    |(
{ before(grammarAccess.getKeywordsAccess().getNameTUCKKeyword_0_4()); }

	TUCK 

{ after(grammarAccess.getKeywordsAccess().getNameTUCKKeyword_0_4()); }
)

    |(
{ before(grammarAccess.getKeywordsAccess().getNameROTKeyword_0_5()); }

	ROT 

{ after(grammarAccess.getKeywordsAccess().getNameROTKeyword_0_5()); }
)

    |(
{ before(grammarAccess.getKeywordsAccess().getNameROTKeyword_0_6()); }

	ROT_1 

{ after(grammarAccess.getKeywordsAccess().getNameROTKeyword_0_6()); }
)

    |(
{ before(grammarAccess.getKeywordsAccess().getNameNEGATEKeyword_0_7()); }

	NEGATE 

{ after(grammarAccess.getKeywordsAccess().getNameNEGATEKeyword_0_7()); }
)

    |(
{ before(grammarAccess.getKeywordsAccess().getNameDUPKeyword_0_8()); }

	DUP 

{ after(grammarAccess.getKeywordsAccess().getNameDUPKeyword_0_8()); }
)

    |(
{ before(grammarAccess.getKeywordsAccess().getNameCALLKeyword_0_9()); }

	CALL 

{ after(grammarAccess.getKeywordsAccess().getNameCALLKeyword_0_9()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Instruction__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInstructionAccess().getKeywordsParserRuleCall_0()); }
	ruleKeywords
{ after(grammarAccess.getInstructionAccess().getKeywordsParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getInstructionAccess().getWordParserRuleCall_1()); }
	ruleWord
{ after(grammarAccess.getInstructionAccess().getWordParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getInstructionAccess().getNameAssignment_2()); }
(rule__Instruction__NameAssignment_2)
{ after(grammarAccess.getInstructionAccess().getNameAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Literal__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getLiteralAccess().getINTTerminalRuleCall_0()); }
	RULE_INT
{ after(grammarAccess.getLiteralAccess().getINTTerminalRuleCall_0()); }
)

    |(
{ before(grammarAccess.getLiteralAccess().getDOUBLETerminalRuleCall_1()); }
	RULE_DOUBLE
{ after(grammarAccess.getLiteralAccess().getDOUBLETerminalRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Word__NameAlternatives_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWordAccess().getNameIDTerminalRuleCall_0_0()); }
	RULE_ID
{ after(grammarAccess.getWordAccess().getNameIDTerminalRuleCall_0_0()); }
)

    |(
{ before(grammarAccess.getWordAccess().getNameOPERATORTerminalRuleCall_0_1()); }
	RULE_OPERATOR
{ after(grammarAccess.getWordAccess().getNameOPERATORTerminalRuleCall_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}



rule__Function__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Function__Group__0__Impl
	rule__Function__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Function__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFunctionAccess().getColonKeyword_0()); }

	Colon 

{ after(grammarAccess.getFunctionAccess().getColonKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Function__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Function__Group__1__Impl
	rule__Function__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Function__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFunctionAccess().getNameAssignment_1()); }
(rule__Function__NameAssignment_1)
{ after(grammarAccess.getFunctionAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Function__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Function__Group__2__Impl
	rule__Function__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Function__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFunctionAccess().getWordsAssignment_2()); }
(rule__Function__WordsAssignment_2)*
{ after(grammarAccess.getFunctionAccess().getWordsAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Function__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Function__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Function__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFunctionAccess().getSemicolonKeyword_3()); }

	Semicolon 

{ after(grammarAccess.getFunctionAccess().getSemicolonKeyword_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__Create__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Create__Group__0__Impl
	rule__Create__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Create__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCreateAccess().getCreateKeyword_0()); }

	Create 

{ after(grammarAccess.getCreateAccess().getCreateKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Create__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Create__Group__1__Impl
	rule__Create__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Create__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCreateAccess().getNameAssignment_1()); }
(rule__Create__NameAssignment_1)
{ after(grammarAccess.getCreateAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Create__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Create__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Create__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCreateAccess().getGroup_2()); }
(rule__Create__Group_2__0)*
{ after(grammarAccess.getCreateAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__Create__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Create__Group_2__0__Impl
	rule__Create__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Create__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCreateAccess().getLitAssignment_2_0()); }
(rule__Create__LitAssignment_2_0)
{ after(grammarAccess.getCreateAccess().getLitAssignment_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Create__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Create__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Create__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCreateAccess().getCommaKeyword_2_1()); }

	Comma 

{ after(grammarAccess.getCreateAccess().getCommaKeyword_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}







rule__Forth__InstructionsAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getForthAccess().getInstructionsGlobalInstructionParserRuleCall_0()); }
	ruleGlobalInstruction{ after(grammarAccess.getForthAccess().getInstructionsGlobalInstructionParserRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Function__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Function__WordsAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getFunctionAccess().getWordsInstructionParserRuleCall_2_0()); }
	ruleInstruction{ after(grammarAccess.getFunctionAccess().getWordsInstructionParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Create__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCreateAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getCreateAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Create__LitAssignment_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getCreateAccess().getLitLiteralParserRuleCall_2_0_0()); }
	ruleLiteral{ after(grammarAccess.getCreateAccess().getLitLiteralParserRuleCall_2_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Keywords__NameAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getKeywordsAccess().getNameAlternatives_0()); }
(rule__Keywords__NameAlternatives_0)
{ after(grammarAccess.getKeywordsAccess().getNameAlternatives_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Instruction__NameAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getInstructionAccess().getNameLiteralParserRuleCall_2_0()); }
	ruleLiteral{ after(grammarAccess.getInstructionAccess().getNameLiteralParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Word__NameAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWordAccess().getNameAlternatives_0()); }
(rule__Word__NameAlternatives_0)
{ after(grammarAccess.getWordAccess().getNameAlternatives_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

