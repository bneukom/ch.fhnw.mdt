/*
 * generated by Xtext
 */
package ch.fhnw.mdt.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class UForthGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class ForthElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Forth");
		private final Assignment cInstructionsAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cInstructionsGlobalInstructionParserRuleCall_0 = (RuleCall)cInstructionsAssignment.eContents().get(0);
		
		//Forth:
		//	instructions+=GlobalInstruction*;
		@Override public ParserRule getRule() { return rule; }

		//instructions+=GlobalInstruction*
		public Assignment getInstructionsAssignment() { return cInstructionsAssignment; }

		//GlobalInstruction
		public RuleCall getInstructionsGlobalInstructionParserRuleCall_0() { return cInstructionsGlobalInstructionParserRuleCall_0; }
	}

	public class GlobalInstructionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "GlobalInstruction");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cCreateParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cFunctionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cInstructionParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//GlobalInstruction:
		//	Create | Function | Instruction;
		@Override public ParserRule getRule() { return rule; }

		//Create | Function | Instruction
		public Alternatives getAlternatives() { return cAlternatives; }

		//Create
		public RuleCall getCreateParserRuleCall_0() { return cCreateParserRuleCall_0; }

		//Function
		public RuleCall getFunctionParserRuleCall_1() { return cFunctionParserRuleCall_1; }

		//Instruction
		public RuleCall getInstructionParserRuleCall_2() { return cInstructionParserRuleCall_2; }
	}

	public class FunctionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Function");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cColonKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Assignment cWordsAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cWordsInstructionParserRuleCall_2_0 = (RuleCall)cWordsAssignment_2.eContents().get(0);
		private final Keyword cSemicolonKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//Function:
		//	":" name=ID words+=Instruction* ";";
		@Override public ParserRule getRule() { return rule; }

		//":" name=ID words+=Instruction* ";"
		public Group getGroup() { return cGroup; }

		//":"
		public Keyword getColonKeyword_0() { return cColonKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//words+=Instruction*
		public Assignment getWordsAssignment_2() { return cWordsAssignment_2; }

		//Instruction
		public RuleCall getWordsInstructionParserRuleCall_2_0() { return cWordsInstructionParserRuleCall_2_0; }

		//";"
		public Keyword getSemicolonKeyword_3() { return cSemicolonKeyword_3; }
	}

	public class CreateElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Create");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cCreateKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Assignment cLitAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final RuleCall cLitLiteralParserRuleCall_2_0_0 = (RuleCall)cLitAssignment_2_0.eContents().get(0);
		private final Keyword cCommaKeyword_2_1 = (Keyword)cGroup_2.eContents().get(1);
		
		//Create:
		//	"create" name=ID (lit+=Literal ",")*;
		@Override public ParserRule getRule() { return rule; }

		//"create" name=ID (lit+=Literal ",")*
		public Group getGroup() { return cGroup; }

		//"create"
		public Keyword getCreateKeyword_0() { return cCreateKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//(lit+=Literal ",")*
		public Group getGroup_2() { return cGroup_2; }

		//lit+=Literal
		public Assignment getLitAssignment_2_0() { return cLitAssignment_2_0; }

		//Literal
		public RuleCall getLitLiteralParserRuleCall_2_0_0() { return cLitLiteralParserRuleCall_2_0_0; }

		//","
		public Keyword getCommaKeyword_2_1() { return cCommaKeyword_2_1; }
	}

	public class KeywordsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Keywords");
		private final Assignment cNameAssignment = (Assignment)rule.eContents().get(1);
		private final Alternatives cNameAlternatives_0 = (Alternatives)cNameAssignment.eContents().get(0);
		private final Keyword cNameSWAPKeyword_0_0 = (Keyword)cNameAlternatives_0.eContents().get(0);
		private final Keyword cNameOVERKeyword_0_1 = (Keyword)cNameAlternatives_0.eContents().get(1);
		private final Keyword cNameNIPKeyword_0_2 = (Keyword)cNameAlternatives_0.eContents().get(2);
		private final Keyword cNameUNDERKeyword_0_3 = (Keyword)cNameAlternatives_0.eContents().get(3);
		private final Keyword cNameTUCKKeyword_0_4 = (Keyword)cNameAlternatives_0.eContents().get(4);
		private final Keyword cNameROTKeyword_0_5 = (Keyword)cNameAlternatives_0.eContents().get(5);
		private final Keyword cNameROTKeyword_0_6 = (Keyword)cNameAlternatives_0.eContents().get(6);
		private final Keyword cNameNEGATEKeyword_0_7 = (Keyword)cNameAlternatives_0.eContents().get(7);
		private final Keyword cNameDUPKeyword_0_8 = (Keyword)cNameAlternatives_0.eContents().get(8);
		private final Keyword cNameCALLKeyword_0_9 = (Keyword)cNameAlternatives_0.eContents().get(9);
		
		//Keywords:
		//	name=("SWAP" | "OVER" | "NIP" | "UNDER" | "TUCK" | "ROT" | "-ROT" | "NEGATE" | "DUP" | "CALL");
		@Override public ParserRule getRule() { return rule; }

		//name=("SWAP" | "OVER" | "NIP" | "UNDER" | "TUCK" | "ROT" | "-ROT" | "NEGATE" | "DUP" | "CALL")
		public Assignment getNameAssignment() { return cNameAssignment; }

		//"SWAP" | "OVER" | "NIP" | "UNDER" | "TUCK" | "ROT" | "-ROT" | "NEGATE" | "DUP" | "CALL"
		public Alternatives getNameAlternatives_0() { return cNameAlternatives_0; }

		//"SWAP"
		public Keyword getNameSWAPKeyword_0_0() { return cNameSWAPKeyword_0_0; }

		//"OVER"
		public Keyword getNameOVERKeyword_0_1() { return cNameOVERKeyword_0_1; }

		//"NIP"
		public Keyword getNameNIPKeyword_0_2() { return cNameNIPKeyword_0_2; }

		//"UNDER"
		public Keyword getNameUNDERKeyword_0_3() { return cNameUNDERKeyword_0_3; }

		//"TUCK"
		public Keyword getNameTUCKKeyword_0_4() { return cNameTUCKKeyword_0_4; }

		//"ROT"
		public Keyword getNameROTKeyword_0_5() { return cNameROTKeyword_0_5; }

		//"-ROT"
		public Keyword getNameROTKeyword_0_6() { return cNameROTKeyword_0_6; }

		//"NEGATE"
		public Keyword getNameNEGATEKeyword_0_7() { return cNameNEGATEKeyword_0_7; }

		//"DUP"
		public Keyword getNameDUPKeyword_0_8() { return cNameDUPKeyword_0_8; }

		//"CALL"
		public Keyword getNameCALLKeyword_0_9() { return cNameCALLKeyword_0_9; }
	}

	public class InstructionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Instruction");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cKeywordsParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cWordParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cAlternatives.eContents().get(2);
		private final RuleCall cNameLiteralParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		
		//Instruction:
		//	Keywords | Word | name=Literal;
		@Override public ParserRule getRule() { return rule; }

		//Keywords | Word | name=Literal
		public Alternatives getAlternatives() { return cAlternatives; }

		//Keywords
		public RuleCall getKeywordsParserRuleCall_0() { return cKeywordsParserRuleCall_0; }

		//Word
		public RuleCall getWordParserRuleCall_1() { return cWordParserRuleCall_1; }

		//name=Literal
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//Literal
		public RuleCall getNameLiteralParserRuleCall_2_0() { return cNameLiteralParserRuleCall_2_0; }
	}

	public class LiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Literal");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cINTTerminalRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cDOUBLETerminalRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//Literal:
		//	INT | DOUBLE;
		@Override public ParserRule getRule() { return rule; }

		//INT | DOUBLE
		public Alternatives getAlternatives() { return cAlternatives; }

		//INT
		public RuleCall getINTTerminalRuleCall_0() { return cINTTerminalRuleCall_0; }

		//DOUBLE
		public RuleCall getDOUBLETerminalRuleCall_1() { return cDOUBLETerminalRuleCall_1; }
	}

	public class WordElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Word");
		private final Assignment cNameAssignment = (Assignment)rule.eContents().get(1);
		private final Alternatives cNameAlternatives_0 = (Alternatives)cNameAssignment.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAlternatives_0.eContents().get(0);
		private final RuleCall cNameOPERATORTerminalRuleCall_0_1 = (RuleCall)cNameAlternatives_0.eContents().get(1);
		
		//Word:
		//	name=(ID | OPERATOR);
		@Override public ParserRule getRule() { return rule; }

		//name=(ID | OPERATOR)
		public Assignment getNameAssignment() { return cNameAssignment; }

		//ID | OPERATOR
		public Alternatives getNameAlternatives_0() { return cNameAlternatives_0; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }

		//OPERATOR
		public RuleCall getNameOPERATORTerminalRuleCall_0_1() { return cNameOPERATORTerminalRuleCall_0_1; }
	}
	
	
	private final ForthElements pForth;
	private final TerminalRule tDIGIT;
	private final TerminalRule tDECINT;
	private final TerminalRule tSL_COMMENT;
	private final TerminalRule tINT;
	private final TerminalRule tDOUBLE;
	private final TerminalRule tID;
	private final TerminalRule tOPERATOR;
	private final GlobalInstructionElements pGlobalInstruction;
	private final FunctionElements pFunction;
	private final CreateElements pCreate;
	private final KeywordsElements pKeywords;
	private final InstructionElements pInstruction;
	private final LiteralElements pLiteral;
	private final WordElements pWord;
	
	private final Grammar grammar;

	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public UForthGrammarAccess(GrammarProvider grammarProvider,
		TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
		this.pForth = new ForthElements();
		this.tDIGIT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "DIGIT");
		this.tDECINT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "DECINT");
		this.tSL_COMMENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "SL_COMMENT");
		this.tINT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "INT");
		this.tDOUBLE = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "DOUBLE");
		this.tID = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "ID");
		this.tOPERATOR = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "OPERATOR");
		this.pGlobalInstruction = new GlobalInstructionElements();
		this.pFunction = new FunctionElements();
		this.pCreate = new CreateElements();
		this.pKeywords = new KeywordsElements();
		this.pInstruction = new InstructionElements();
		this.pLiteral = new LiteralElements();
		this.pWord = new WordElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("ch.fhnw.mdt.UForth".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	

	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//Forth:
	//	instructions+=GlobalInstruction*;
	public ForthElements getForthAccess() {
		return pForth;
	}
	
	public ParserRule getForthRule() {
		return getForthAccess().getRule();
	}

	//terminal fragment DIGIT:
	//	"0".."9";
	public TerminalRule getDIGITRule() {
		return tDIGIT;
	} 

	//terminal fragment DECINT:
	//	DIGIT+;
	public TerminalRule getDECINTRule() {
		return tDECINT;
	} 

	//terminal SL_COMMENT:
	//	"(" !("\n" | "\r")* ")" WS*;
	public TerminalRule getSL_COMMENTRule() {
		return tSL_COMMENT;
	} 

	//terminal INT returns ecore::EInt:
	//	"-"? ("0".."9" | "A".."F")+;
	public TerminalRule getINTRule() {
		return tINT;
	} 

	//terminal DOUBLE returns ecore::EDouble:
	//	DECINT ("." DIGIT* | ("." DIGIT*)? ("E" | "e") ("-" | "+")? DECINT);
	public TerminalRule getDOUBLERule() {
		return tDOUBLE;
	} 

	//terminal ID:
	//	"^"? ("a".."z" | "A".."Z" | "_" | "!" | "@" | "?" | "," | "<" | ">" | "=") ("a".."z" | "A".."Z" | "_" | "!" | "?" |
	//	"@" | "<" | ">" | "0".."9" | "," | "=")*;
	public TerminalRule getIDRule() {
		return tID;
	} 

	//terminal OPERATOR:
	//	"+" | "-" | "*" | "/";
	public TerminalRule getOPERATORRule() {
		return tOPERATOR;
	} 

	//GlobalInstruction:
	//	Create | Function | Instruction;
	public GlobalInstructionElements getGlobalInstructionAccess() {
		return pGlobalInstruction;
	}
	
	public ParserRule getGlobalInstructionRule() {
		return getGlobalInstructionAccess().getRule();
	}

	//Function:
	//	":" name=ID words+=Instruction* ";";
	public FunctionElements getFunctionAccess() {
		return pFunction;
	}
	
	public ParserRule getFunctionRule() {
		return getFunctionAccess().getRule();
	}

	//Create:
	//	"create" name=ID (lit+=Literal ",")*;
	public CreateElements getCreateAccess() {
		return pCreate;
	}
	
	public ParserRule getCreateRule() {
		return getCreateAccess().getRule();
	}

	//Keywords:
	//	name=("SWAP" | "OVER" | "NIP" | "UNDER" | "TUCK" | "ROT" | "-ROT" | "NEGATE" | "DUP" | "CALL");
	public KeywordsElements getKeywordsAccess() {
		return pKeywords;
	}
	
	public ParserRule getKeywordsRule() {
		return getKeywordsAccess().getRule();
	}

	//Instruction:
	//	Keywords | Word | name=Literal;
	public InstructionElements getInstructionAccess() {
		return pInstruction;
	}
	
	public ParserRule getInstructionRule() {
		return getInstructionAccess().getRule();
	}

	//Literal:
	//	INT | DOUBLE;
	public LiteralElements getLiteralAccess() {
		return pLiteral;
	}
	
	public ParserRule getLiteralRule() {
		return getLiteralAccess().getRule();
	}

	//Word:
	//	name=(ID | OPERATOR);
	public WordElements getWordAccess() {
		return pWord;
	}
	
	public ParserRule getWordRule() {
		return getWordAccess().getRule();
	}

	//terminal STRING:
	//	"\"" ("\\" . / * 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' * / | !("\\" | "\""))* "\"" | "\'" ("\\" .
	//	/ * 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' * / | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//	"/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	} 

	//terminal WS:
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	} 
}
