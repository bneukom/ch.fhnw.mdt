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
		private final RuleCall cInstructionsInstructionParserRuleCall_0 = (RuleCall)cInstructionsAssignment.eContents().get(0);
		
		//Forth:
		//	instructions+=Instruction*;
		@Override public ParserRule getRule() { return rule; }

		//instructions+=Instruction*
		public Assignment getInstructionsAssignment() { return cInstructionsAssignment; }

		//Instruction
		public RuleCall getInstructionsInstructionParserRuleCall_0() { return cInstructionsInstructionParserRuleCall_0; }
	}

	public class InstructionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Instruction");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cCreateParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cFunctionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cWordParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//Instruction:
		//	Create | Function | Word;
		@Override public ParserRule getRule() { return rule; }

		//Create | Function | Word
		public Alternatives getAlternatives() { return cAlternatives; }

		//Create
		public RuleCall getCreateParserRuleCall_0() { return cCreateParserRuleCall_0; }

		//Function
		public RuleCall getFunctionParserRuleCall_1() { return cFunctionParserRuleCall_1; }

		//Word
		public RuleCall getWordParserRuleCall_2() { return cWordParserRuleCall_2; }
	}

	public class FunctionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Function");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cColonKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final RuleCall cWordParserRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Assignment cWordsAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cWordsWordParserRuleCall_2_0 = (RuleCall)cWordsAssignment_2.eContents().get(0);
		private final Keyword cSemicolonKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//Function:
		//	":" Word words+=Word* ";";
		@Override public ParserRule getRule() { return rule; }

		//":" Word words+=Word* ";"
		public Group getGroup() { return cGroup; }

		//":"
		public Keyword getColonKeyword_0() { return cColonKeyword_0; }

		//Word
		public RuleCall getWordParserRuleCall_1() { return cWordParserRuleCall_1; }

		//words+=Word*
		public Assignment getWordsAssignment_2() { return cWordsAssignment_2; }

		//Word
		public RuleCall getWordsWordParserRuleCall_2_0() { return cWordsWordParserRuleCall_2_0; }

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
		private final RuleCall cLitLITERALParserRuleCall_2_0_0 = (RuleCall)cLitAssignment_2_0.eContents().get(0);
		private final Keyword cCommaKeyword_2_1 = (Keyword)cGroup_2.eContents().get(1);
		
		//Create:
		//	"create" name=ID (lit+=LITERAL ",")*;
		@Override public ParserRule getRule() { return rule; }

		//"create" name=ID (lit+=LITERAL ",")*
		public Group getGroup() { return cGroup; }

		//"create"
		public Keyword getCreateKeyword_0() { return cCreateKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//(lit+=LITERAL ",")*
		public Group getGroup_2() { return cGroup_2; }

		//lit+=LITERAL
		public Assignment getLitAssignment_2_0() { return cLitAssignment_2_0; }

		//LITERAL
		public RuleCall getLitLITERALParserRuleCall_2_0_0() { return cLitLITERALParserRuleCall_2_0_0; }

		//","
		public Keyword getCommaKeyword_2_1() { return cCommaKeyword_2_1; }
	}

	public class LITERALElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "LITERAL");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cINTTerminalRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cDOUBLETerminalRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//LITERAL:
		//	INT | DOUBLE;
		@Override public ParserRule getRule() { return rule; }

		//INT | DOUBLE
		public Alternatives getAlternatives() { return cAlternatives; }

		//INT
		public RuleCall getINTTerminalRuleCall_0() { return cINTTerminalRuleCall_0; }

		//DOUBLE
		public RuleCall getDOUBLETerminalRuleCall_1() { return cDOUBLETerminalRuleCall_1; }
	}

	public class IntrinsicBranchWordsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "IntrinsicBranchWords");
		private final Assignment cNameAssignment = (Assignment)rule.eContents().get(1);
		private final Alternatives cNameAlternatives_0 = (Alternatives)cNameAssignment.eContents().get(0);
		private final Keyword cNameJsrKeyword_0_0 = (Keyword)cNameAlternatives_0.eContents().get(0);
		private final Keyword cName0BranchKeyword_0_1 = (Keyword)cNameAlternatives_0.eContents().get(1);
		private final Keyword cName0BranchKeyword_0_2 = (Keyword)cNameAlternatives_0.eContents().get(2);
		private final Keyword cNameBranchKeyword_0_3 = (Keyword)cNameAlternatives_0.eContents().get(3);
		private final Keyword cNameSBranchKeyword_0_4 = (Keyword)cNameAlternatives_0.eContents().get(4);
		private final Keyword cNameNsBranchKeyword_0_5 = (Keyword)cNameAlternatives_0.eContents().get(5);
		private final Keyword cNameNcBranchKeyword_0_6 = (Keyword)cNameAlternatives_0.eContents().get(6);
		private final Keyword cNameNoBranchKeyword_0_7 = (Keyword)cNameAlternatives_0.eContents().get(7);
		private final Keyword cNameTorBranchKeyword_0_8 = (Keyword)cNameAlternatives_0.eContents().get(8);
		private final Keyword cNameZExitKeyword_0_9 = (Keyword)cNameAlternatives_0.eContents().get(9);
		private final Keyword cNameNzExitKeyword_0_10 = (Keyword)cNameAlternatives_0.eContents().get(10);
		
		//IntrinsicBranchWords:
		//	name=("jsr" | "0=branch" | "0<>branch" | "?-branch" | "s-branch" | "ns-branch" | "nc-branch" | "no-branch" |
		//	"tor-branch" | "z-exit" | "nz-exit");
		@Override public ParserRule getRule() { return rule; }

		//name=("jsr" | "0=branch" | "0<>branch" | "?-branch" | "s-branch" | "ns-branch" | "nc-branch" | "no-branch" |
		//"tor-branch" | "z-exit" | "nz-exit")
		public Assignment getNameAssignment() { return cNameAssignment; }

		//"jsr" | "0=branch" | "0<>branch" | "?-branch" | "s-branch" | "ns-branch" | "nc-branch" | "no-branch" | "tor-branch" |
		//"z-exit" | "nz-exit"
		public Alternatives getNameAlternatives_0() { return cNameAlternatives_0; }

		//"jsr"
		public Keyword getNameJsrKeyword_0_0() { return cNameJsrKeyword_0_0; }

		//"0=branch"
		public Keyword getName0BranchKeyword_0_1() { return cName0BranchKeyword_0_1; }

		//"0<>branch"
		public Keyword getName0BranchKeyword_0_2() { return cName0BranchKeyword_0_2; }

		//"?-branch"
		public Keyword getNameBranchKeyword_0_3() { return cNameBranchKeyword_0_3; }

		//"s-branch"
		public Keyword getNameSBranchKeyword_0_4() { return cNameSBranchKeyword_0_4; }

		//"ns-branch"
		public Keyword getNameNsBranchKeyword_0_5() { return cNameNsBranchKeyword_0_5; }

		//"nc-branch"
		public Keyword getNameNcBranchKeyword_0_6() { return cNameNcBranchKeyword_0_6; }

		//"no-branch"
		public Keyword getNameNoBranchKeyword_0_7() { return cNameNoBranchKeyword_0_7; }

		//"tor-branch"
		public Keyword getNameTorBranchKeyword_0_8() { return cNameTorBranchKeyword_0_8; }

		//"z-exit"
		public Keyword getNameZExitKeyword_0_9() { return cNameZExitKeyword_0_9; }

		//"nz-exit"
		public Keyword getNameNzExitKeyword_0_10() { return cNameNzExitKeyword_0_10; }
	}

	public class IntrinsicStackWordsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "IntrinsicStackWords");
		private final Assignment cNameAssignment = (Assignment)rule.eContents().get(1);
		private final Alternatives cNameAlternatives_0 = (Alternatives)cNameAssignment.eContents().get(0);
		private final Keyword cNameCLEARKeyword_0_0 = (Keyword)cNameAlternatives_0.eContents().get(0);
		private final Keyword cNameDROPKeyword_0_1 = (Keyword)cNameAlternatives_0.eContents().get(1);
		private final Keyword cNameDUPKeyword_0_2 = (Keyword)cNameAlternatives_0.eContents().get(2);
		private final Keyword cNameDUPKeyword_0_3 = (Keyword)cNameAlternatives_0.eContents().get(3);
		private final Keyword cNameSWAPKeyword_0_4 = (Keyword)cNameAlternatives_0.eContents().get(4);
		private final Keyword cNameNIPKeyword_0_5 = (Keyword)cNameAlternatives_0.eContents().get(5);
		private final Keyword cNameOVERKeyword_0_6 = (Keyword)cNameAlternatives_0.eContents().get(6);
		private final Keyword cNameROTKeyword_0_7 = (Keyword)cNameAlternatives_0.eContents().get(7);
		private final Keyword cNameROTKeyword_0_8 = (Keyword)cNameAlternatives_0.eContents().get(8);
		private final Keyword cNameTUCKKeyword_0_9 = (Keyword)cNameAlternatives_0.eContents().get(9);
		private final Keyword cNameUNDERKeyword_0_10 = (Keyword)cNameAlternatives_0.eContents().get(10);
		private final Keyword cName2DROPKeyword_0_11 = (Keyword)cNameAlternatives_0.eContents().get(11);
		private final Keyword cName2DUPKeyword_0_12 = (Keyword)cNameAlternatives_0.eContents().get(12);
		private final Keyword cName2SWAPKeyword_0_13 = (Keyword)cNameAlternatives_0.eContents().get(13);
		private final Keyword cName2OVERKeyword_0_14 = (Keyword)cNameAlternatives_0.eContents().get(14);
		private final Keyword cNameRCLEARKeyword_0_15 = (Keyword)cNameAlternatives_0.eContents().get(15);
		private final Keyword cNameRKeyword_0_16 = (Keyword)cNameAlternatives_0.eContents().get(16);
		private final Keyword cNameRKeyword_0_17 = (Keyword)cNameAlternatives_0.eContents().get(17);
		private final Keyword cNameRKeyword_0_18 = (Keyword)cNameAlternatives_0.eContents().get(18);
		private final Keyword cNameRDROPKeyword_0_19 = (Keyword)cNameAlternatives_0.eContents().get(19);
		
		//IntrinsicStackWords:
		//	name=("CLEAR" | "DROP" | "DUP" | "?DUP" | "SWAP" | "NIP" | "OVER" | "ROT" | "-ROT" | "TUCK" | "UNDER" | "2DROP" |
		//	"2DUP" | "2SWAP" | "2OVER" | "RCLEAR" | "R@" | "r>" | ">r" | "RDROP");
		@Override public ParserRule getRule() { return rule; }

		//name=("CLEAR" | "DROP" | "DUP" | "?DUP" | "SWAP" | "NIP" | "OVER" | "ROT" | "-ROT" | "TUCK" | "UNDER" | "2DROP" | "2DUP"
		//| "2SWAP" | "2OVER" | "RCLEAR" | "R@" | "r>" | ">r" | "RDROP")
		public Assignment getNameAssignment() { return cNameAssignment; }

		//"CLEAR" | "DROP" | "DUP" | "?DUP" | "SWAP" | "NIP" | "OVER" | "ROT" | "-ROT" | "TUCK" | "UNDER" | "2DROP" | "2DUP" |
		//"2SWAP" | "2OVER" | "RCLEAR" | "R@" | "r>" | ">r" | "RDROP"
		public Alternatives getNameAlternatives_0() { return cNameAlternatives_0; }

		//"CLEAR"
		public Keyword getNameCLEARKeyword_0_0() { return cNameCLEARKeyword_0_0; }

		//"DROP"
		public Keyword getNameDROPKeyword_0_1() { return cNameDROPKeyword_0_1; }

		//"DUP"
		public Keyword getNameDUPKeyword_0_2() { return cNameDUPKeyword_0_2; }

		//"?DUP"
		public Keyword getNameDUPKeyword_0_3() { return cNameDUPKeyword_0_3; }

		//"SWAP"
		public Keyword getNameSWAPKeyword_0_4() { return cNameSWAPKeyword_0_4; }

		//"NIP"
		public Keyword getNameNIPKeyword_0_5() { return cNameNIPKeyword_0_5; }

		//"OVER"
		public Keyword getNameOVERKeyword_0_6() { return cNameOVERKeyword_0_6; }

		//"ROT"
		public Keyword getNameROTKeyword_0_7() { return cNameROTKeyword_0_7; }

		//"-ROT"
		public Keyword getNameROTKeyword_0_8() { return cNameROTKeyword_0_8; }

		//"TUCK"
		public Keyword getNameTUCKKeyword_0_9() { return cNameTUCKKeyword_0_9; }

		//"UNDER"
		public Keyword getNameUNDERKeyword_0_10() { return cNameUNDERKeyword_0_10; }

		//"2DROP"
		public Keyword getName2DROPKeyword_0_11() { return cName2DROPKeyword_0_11; }

		//"2DUP"
		public Keyword getName2DUPKeyword_0_12() { return cName2DUPKeyword_0_12; }

		//"2SWAP"
		public Keyword getName2SWAPKeyword_0_13() { return cName2SWAPKeyword_0_13; }

		//"2OVER"
		public Keyword getName2OVERKeyword_0_14() { return cName2OVERKeyword_0_14; }

		//"RCLEAR"
		public Keyword getNameRCLEARKeyword_0_15() { return cNameRCLEARKeyword_0_15; }

		//"R@"
		public Keyword getNameRKeyword_0_16() { return cNameRKeyword_0_16; }

		//"r>"
		public Keyword getNameRKeyword_0_17() { return cNameRKeyword_0_17; }

		//">r"
		public Keyword getNameRKeyword_0_18() { return cNameRKeyword_0_18; }

		//"RDROP"
		public Keyword getNameRDROPKeyword_0_19() { return cNameRDROPKeyword_0_19; }
	}

	public class IntrinsicMemoryWordsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "IntrinsicMemoryWords");
		private final Assignment cNameAssignment = (Assignment)rule.eContents().get(1);
		private final Alternatives cNameAlternatives_0 = (Alternatives)cNameAssignment.eContents().get(0);
		private final Keyword cNameLDKeyword_0_0 = (Keyword)cNameAlternatives_0.eContents().get(0);
		private final Keyword cNameCommercialAtKeyword_0_1 = (Keyword)cNameAlternatives_0.eContents().get(1);
		private final Keyword cNameSTKeyword_0_2 = (Keyword)cNameAlternatives_0.eContents().get(2);
		private final Keyword cNameExclamationMarkKeyword_0_3 = (Keyword)cNameAlternatives_0.eContents().get(3);
		private final Keyword cName2Keyword_0_4 = (Keyword)cNameAlternatives_0.eContents().get(4);
		private final Keyword cName2Keyword_0_5 = (Keyword)cNameAlternatives_0.eContents().get(5);
		private final Keyword cNameLLDKeyword_0_6 = (Keyword)cNameAlternatives_0.eContents().get(6);
		private final Keyword cNameLKeyword_0_7 = (Keyword)cNameAlternatives_0.eContents().get(7);
		private final Keyword cNameLSTKeyword_0_8 = (Keyword)cNameAlternatives_0.eContents().get(8);
		private final Keyword cNameLKeyword_0_9 = (Keyword)cNameAlternatives_0.eContents().get(9);
		private final Keyword cNameTLDKeyword_0_10 = (Keyword)cNameAlternatives_0.eContents().get(10);
		private final Keyword cNameTKeyword_0_11 = (Keyword)cNameAlternatives_0.eContents().get(11);
		private final Keyword cNameTSTKeyword_0_12 = (Keyword)cNameAlternatives_0.eContents().get(12);
		private final Keyword cNameTKeyword_0_13 = (Keyword)cNameAlternatives_0.eContents().get(13);
		private final Keyword cNameSTKeyword_0_14 = (Keyword)cNameAlternatives_0.eContents().get(14);
		private final Keyword cNamePlusSignExclamationMarkKeyword_0_15 = (Keyword)cNameAlternatives_0.eContents().get(15);
		private final Keyword cNameINCKeyword_0_16 = (Keyword)cNameAlternatives_0.eContents().get(16);
		private final Keyword cNameDECKeyword_0_17 = (Keyword)cNameAlternatives_0.eContents().get(17);
		private final Keyword cNameONKeyword_0_18 = (Keyword)cNameAlternatives_0.eContents().get(18);
		private final Keyword cNameOFFKeyword_0_19 = (Keyword)cNameAlternatives_0.eContents().get(19);
		private final Keyword cNameERASEKeyword_0_20 = (Keyword)cNameAlternatives_0.eContents().get(20);
		private final Keyword cNameFILLKeyword_0_21 = (Keyword)cNameAlternatives_0.eContents().get(21);
		private final Keyword cNameCOUNTKeyword_0_22 = (Keyword)cNameAlternatives_0.eContents().get(22);
		private final Keyword cNameMOVEKeyword_0_23 = (Keyword)cNameAlternatives_0.eContents().get(23);
		private final Keyword cNamePLACEKeyword_0_24 = (Keyword)cNameAlternatives_0.eContents().get(24);
		
		//IntrinsicMemoryWords:
		//	name=("LD" | "@" | "ST" | "!" | "2@" | "2!" | "LLD" | "L@" | "LST" | "L!" | "TLD" | "T@" | "TST" | "T!" | "+ST" | "+!"
		//	| "INC" | "DEC" | "ON" | "OFF" | "ERASE" | "FILL" | "COUNT" | "MOVE" | "PLACE");
		@Override public ParserRule getRule() { return rule; }

		//name=("LD" | "@" | "ST" | "!" | "2@" | "2!" | "LLD" | "L@" | "LST" | "L!" | "TLD" | "T@" | "TST" | "T!" | "+ST" | "+!" |
		//"INC" | "DEC" | "ON" | "OFF" | "ERASE" | "FILL" | "COUNT" | "MOVE" | "PLACE")
		public Assignment getNameAssignment() { return cNameAssignment; }

		//"LD" | "@" | "ST" | "!" | "2@" | "2!" | "LLD" | "L@" | "LST" | "L!" | "TLD" | "T@" | "TST" | "T!" | "+ST" | "+!" | "INC"
		//| "DEC" | "ON" | "OFF" | "ERASE" | "FILL" | "COUNT" | "MOVE" | "PLACE"
		public Alternatives getNameAlternatives_0() { return cNameAlternatives_0; }

		//"LD"
		public Keyword getNameLDKeyword_0_0() { return cNameLDKeyword_0_0; }

		//"@"
		public Keyword getNameCommercialAtKeyword_0_1() { return cNameCommercialAtKeyword_0_1; }

		//"ST"
		public Keyword getNameSTKeyword_0_2() { return cNameSTKeyword_0_2; }

		//"!"
		public Keyword getNameExclamationMarkKeyword_0_3() { return cNameExclamationMarkKeyword_0_3; }

		//"2@"
		public Keyword getName2Keyword_0_4() { return cName2Keyword_0_4; }

		//"2!"
		public Keyword getName2Keyword_0_5() { return cName2Keyword_0_5; }

		//"LLD"
		public Keyword getNameLLDKeyword_0_6() { return cNameLLDKeyword_0_6; }

		//"L@"
		public Keyword getNameLKeyword_0_7() { return cNameLKeyword_0_7; }

		//"LST"
		public Keyword getNameLSTKeyword_0_8() { return cNameLSTKeyword_0_8; }

		//"L!"
		public Keyword getNameLKeyword_0_9() { return cNameLKeyword_0_9; }

		//"TLD"
		public Keyword getNameTLDKeyword_0_10() { return cNameTLDKeyword_0_10; }

		//"T@"
		public Keyword getNameTKeyword_0_11() { return cNameTKeyword_0_11; }

		//"TST"
		public Keyword getNameTSTKeyword_0_12() { return cNameTSTKeyword_0_12; }

		//"T!"
		public Keyword getNameTKeyword_0_13() { return cNameTKeyword_0_13; }

		//"+ST"
		public Keyword getNameSTKeyword_0_14() { return cNameSTKeyword_0_14; }

		//"+!"
		public Keyword getNamePlusSignExclamationMarkKeyword_0_15() { return cNamePlusSignExclamationMarkKeyword_0_15; }

		//"INC"
		public Keyword getNameINCKeyword_0_16() { return cNameINCKeyword_0_16; }

		//"DEC"
		public Keyword getNameDECKeyword_0_17() { return cNameDECKeyword_0_17; }

		//"ON"
		public Keyword getNameONKeyword_0_18() { return cNameONKeyword_0_18; }

		//"OFF"
		public Keyword getNameOFFKeyword_0_19() { return cNameOFFKeyword_0_19; }

		//"ERASE"
		public Keyword getNameERASEKeyword_0_20() { return cNameERASEKeyword_0_20; }

		//"FILL"
		public Keyword getNameFILLKeyword_0_21() { return cNameFILLKeyword_0_21; }

		//"COUNT"
		public Keyword getNameCOUNTKeyword_0_22() { return cNameCOUNTKeyword_0_22; }

		//"MOVE"
		public Keyword getNameMOVEKeyword_0_23() { return cNameMOVEKeyword_0_23; }

		//"PLACE"
		public Keyword getNamePLACEKeyword_0_24() { return cNamePLACEKeyword_0_24; }
	}

	public class IntrinsicArithmeticWordsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "IntrinsicArithmeticWords");
		private final Assignment cNameAssignment = (Assignment)rule.eContents().get(1);
		private final Alternatives cNameAlternatives_0 = (Alternatives)cNameAssignment.eContents().get(0);
		private final Keyword cNamePlusSignKeyword_0_0 = (Keyword)cNameAlternatives_0.eContents().get(0);
		private final Keyword cNameHyphenMinusKeyword_0_1 = (Keyword)cNameAlternatives_0.eContents().get(1);
		private final Keyword cNameAsteriskKeyword_0_2 = (Keyword)cNameAlternatives_0.eContents().get(2);
		private final Keyword cNameSolidusKeyword_0_3 = (Keyword)cNameAlternatives_0.eContents().get(3);
		private final Keyword cName2Keyword_0_4 = (Keyword)cNameAlternatives_0.eContents().get(4);
		private final Keyword cName2Keyword_0_5 = (Keyword)cNameAlternatives_0.eContents().get(5);
		private final Keyword cNameU2Keyword_0_6 = (Keyword)cNameAlternatives_0.eContents().get(6);
		private final Keyword cNameRORKeyword_0_7 = (Keyword)cNameAlternatives_0.eContents().get(7);
		private final Keyword cNameDRORKeyword_0_8 = (Keyword)cNameAlternatives_0.eContents().get(8);
		private final Keyword cNameROLKeyword_0_9 = (Keyword)cNameAlternatives_0.eContents().get(9);
		private final Keyword cNameDROLKeyword_0_10 = (Keyword)cNameAlternatives_0.eContents().get(10);
		private final Keyword cNamePACKKeyword_0_11 = (Keyword)cNameAlternatives_0.eContents().get(11);
		private final Keyword cNameUNPACKKeyword_0_12 = (Keyword)cNameAlternatives_0.eContents().get(12);
		private final Keyword cNameSHIFTKeyword_0_13 = (Keyword)cNameAlternatives_0.eContents().get(13);
		private final Keyword cNameASHIFTKeyword_0_14 = (Keyword)cNameAlternatives_0.eContents().get(14);
		private final Keyword cName2Keyword_0_15 = (Keyword)cNameAlternatives_0.eContents().get(15);
		private final Keyword cName0Keyword_0_16 = (Keyword)cNameAlternatives_0.eContents().get(16);
		private final Keyword cName0Keyword_0_17 = (Keyword)cNameAlternatives_0.eContents().get(17);
		private final Keyword cName0Keyword_0_18 = (Keyword)cNameAlternatives_0.eContents().get(18);
		private final Keyword cNameD0Keyword_0_19 = (Keyword)cNameAlternatives_0.eContents().get(19);
		private final Keyword cNameNEGATEKeyword_0_20 = (Keyword)cNameAlternatives_0.eContents().get(20);
		private final Keyword cNameDNEGATEKeyword_0_21 = (Keyword)cNameAlternatives_0.eContents().get(21);
		private final Keyword cName1Keyword_0_22 = (Keyword)cNameAlternatives_0.eContents().get(22);
		private final Keyword cName1Keyword_0_23 = (Keyword)cNameAlternatives_0.eContents().get(23);
		private final Keyword cNameTRUEKeyword_0_24 = (Keyword)cNameAlternatives_0.eContents().get(24);
		private final Keyword cNameFALSEKeyword_0_25 = (Keyword)cNameAlternatives_0.eContents().get(25);
		private final Keyword cNameCELLKeyword_0_26 = (Keyword)cNameAlternatives_0.eContents().get(26);
		private final Keyword cNameCELLKeyword_0_27 = (Keyword)cNameAlternatives_0.eContents().get(27);
		private final Keyword cNameCARRY_RESETKeyword_0_28 = (Keyword)cNameAlternatives_0.eContents().get(28);
		private final Keyword cNameCARRYSETKeyword_0_29 = (Keyword)cNameAlternatives_0.eContents().get(29);
		private final Keyword cNameABSKeyword_0_30 = (Keyword)cNameAlternatives_0.eContents().get(30);
		private final Keyword cNameDABSKeyword_0_31 = (Keyword)cNameAlternatives_0.eContents().get(31);
		private final Keyword cNameEXTENDKeyword_0_32 = (Keyword)cNameAlternatives_0.eContents().get(32);
		
		//IntrinsicArithmeticWords:
		//	name=("+" | "-" | "*" | "/" | "2*" | "2/" | "u2/" | "ROR" | "DROR" | "ROL" | "DROL" | "PACK" | "UNPACK" | "SHIFT" |
		//	"ASHIFT" | "2**" | "0=" | "0<>" | "0<" | "d0=" | "NEGATE" | "DNEGATE" | "1+" | "1-" | "TRUE" | "FALSE" | "CELL+" |
		//	"CELL-" | "CARRY_RESET" | "CARRY-SET" | "ABS" | "DABS" | "EXTEND");
		@Override public ParserRule getRule() { return rule; }

		//name=("+" | "-" | "*" | "/" | "2*" | "2/" | "u2/" | "ROR" | "DROR" | "ROL" | "DROL" | "PACK" | "UNPACK" | "SHIFT" |
		//"ASHIFT" | "2**" | "0=" | "0<>" | "0<" | "d0=" | "NEGATE" | "DNEGATE" | "1+" | "1-" | "TRUE" | "FALSE" | "CELL+" |
		//"CELL-" | "CARRY_RESET" | "CARRY-SET" | "ABS" | "DABS" | "EXTEND")
		public Assignment getNameAssignment() { return cNameAssignment; }

		//"+" | "-" | "*" | "/" | "2*" | "2/" | "u2/" | "ROR" | "DROR" | "ROL" | "DROL" | "PACK" | "UNPACK" | "SHIFT" | "ASHIFT" |
		//"2**" | "0=" | "0<>" | "0<" | "d0=" | "NEGATE" | "DNEGATE" | "1+" | "1-" | "TRUE" | "FALSE" | "CELL+" | "CELL-" |
		//"CARRY_RESET" | "CARRY-SET" | "ABS" | "DABS" | "EXTEND"
		public Alternatives getNameAlternatives_0() { return cNameAlternatives_0; }

		//"+"
		public Keyword getNamePlusSignKeyword_0_0() { return cNamePlusSignKeyword_0_0; }

		//"-"
		public Keyword getNameHyphenMinusKeyword_0_1() { return cNameHyphenMinusKeyword_0_1; }

		//"*"
		public Keyword getNameAsteriskKeyword_0_2() { return cNameAsteriskKeyword_0_2; }

		//"/"
		public Keyword getNameSolidusKeyword_0_3() { return cNameSolidusKeyword_0_3; }

		//"2*"
		public Keyword getName2Keyword_0_4() { return cName2Keyword_0_4; }

		//"2/"
		public Keyword getName2Keyword_0_5() { return cName2Keyword_0_5; }

		//"u2/"
		public Keyword getNameU2Keyword_0_6() { return cNameU2Keyword_0_6; }

		//"ROR"
		public Keyword getNameRORKeyword_0_7() { return cNameRORKeyword_0_7; }

		//"DROR"
		public Keyword getNameDRORKeyword_0_8() { return cNameDRORKeyword_0_8; }

		//"ROL"
		public Keyword getNameROLKeyword_0_9() { return cNameROLKeyword_0_9; }

		//"DROL"
		public Keyword getNameDROLKeyword_0_10() { return cNameDROLKeyword_0_10; }

		//"PACK"
		public Keyword getNamePACKKeyword_0_11() { return cNamePACKKeyword_0_11; }

		//"UNPACK"
		public Keyword getNameUNPACKKeyword_0_12() { return cNameUNPACKKeyword_0_12; }

		//"SHIFT"
		public Keyword getNameSHIFTKeyword_0_13() { return cNameSHIFTKeyword_0_13; }

		//"ASHIFT"
		public Keyword getNameASHIFTKeyword_0_14() { return cNameASHIFTKeyword_0_14; }

		//"2**"
		public Keyword getName2Keyword_0_15() { return cName2Keyword_0_15; }

		//"0="
		public Keyword getName0Keyword_0_16() { return cName0Keyword_0_16; }

		//"0<>"
		public Keyword getName0Keyword_0_17() { return cName0Keyword_0_17; }

		//"0<"
		public Keyword getName0Keyword_0_18() { return cName0Keyword_0_18; }

		//"d0="
		public Keyword getNameD0Keyword_0_19() { return cNameD0Keyword_0_19; }

		//"NEGATE"
		public Keyword getNameNEGATEKeyword_0_20() { return cNameNEGATEKeyword_0_20; }

		//"DNEGATE"
		public Keyword getNameDNEGATEKeyword_0_21() { return cNameDNEGATEKeyword_0_21; }

		//"1+"
		public Keyword getName1Keyword_0_22() { return cName1Keyword_0_22; }

		//"1-"
		public Keyword getName1Keyword_0_23() { return cName1Keyword_0_23; }

		//"TRUE"
		public Keyword getNameTRUEKeyword_0_24() { return cNameTRUEKeyword_0_24; }

		//"FALSE"
		public Keyword getNameFALSEKeyword_0_25() { return cNameFALSEKeyword_0_25; }

		//"CELL+"
		public Keyword getNameCELLKeyword_0_26() { return cNameCELLKeyword_0_26; }

		//"CELL-"
		public Keyword getNameCELLKeyword_0_27() { return cNameCELLKeyword_0_27; }

		//"CARRY_RESET"
		public Keyword getNameCARRY_RESETKeyword_0_28() { return cNameCARRY_RESETKeyword_0_28; }

		//"CARRY-SET"
		public Keyword getNameCARRYSETKeyword_0_29() { return cNameCARRYSETKeyword_0_29; }

		//"ABS"
		public Keyword getNameABSKeyword_0_30() { return cNameABSKeyword_0_30; }

		//"DABS"
		public Keyword getNameDABSKeyword_0_31() { return cNameDABSKeyword_0_31; }

		//"EXTEND"
		public Keyword getNameEXTENDKeyword_0_32() { return cNameEXTENDKeyword_0_32; }
	}

	public class WordElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Word");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cIntrinsicBranchWordsParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cIntrinsicStackWordsParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cIntrinsicMemoryWordsParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cIntrinsicArithmeticWordsParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final Assignment cNameAssignment_4 = (Assignment)cAlternatives.eContents().get(4);
		private final RuleCall cNameLITERALParserRuleCall_4_0 = (RuleCall)cNameAssignment_4.eContents().get(0);
		private final Assignment cNameAssignment_5 = (Assignment)cAlternatives.eContents().get(5);
		private final RuleCall cNameIDTerminalRuleCall_5_0 = (RuleCall)cNameAssignment_5.eContents().get(0);
		
		//Word:
		//	IntrinsicBranchWords | IntrinsicStackWords | IntrinsicMemoryWords | IntrinsicArithmeticWords | name=LITERAL | name=ID;
		@Override public ParserRule getRule() { return rule; }

		//IntrinsicBranchWords | IntrinsicStackWords | IntrinsicMemoryWords | IntrinsicArithmeticWords | name=LITERAL | name=ID
		public Alternatives getAlternatives() { return cAlternatives; }

		//IntrinsicBranchWords
		public RuleCall getIntrinsicBranchWordsParserRuleCall_0() { return cIntrinsicBranchWordsParserRuleCall_0; }

		//IntrinsicStackWords
		public RuleCall getIntrinsicStackWordsParserRuleCall_1() { return cIntrinsicStackWordsParserRuleCall_1; }

		//IntrinsicMemoryWords
		public RuleCall getIntrinsicMemoryWordsParserRuleCall_2() { return cIntrinsicMemoryWordsParserRuleCall_2; }

		//IntrinsicArithmeticWords
		public RuleCall getIntrinsicArithmeticWordsParserRuleCall_3() { return cIntrinsicArithmeticWordsParserRuleCall_3; }

		//name=LITERAL
		public Assignment getNameAssignment_4() { return cNameAssignment_4; }

		//LITERAL
		public RuleCall getNameLITERALParserRuleCall_4_0() { return cNameLITERALParserRuleCall_4_0; }

		//name=ID
		public Assignment getNameAssignment_5() { return cNameAssignment_5; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_5_0() { return cNameIDTerminalRuleCall_5_0; }
	}
	
	
	private final ForthElements pForth;
	private final TerminalRule tDIGIT;
	private final TerminalRule tDECINT;
	private final TerminalRule tSL_COMMENT;
	private final TerminalRule tINT;
	private final TerminalRule tDOUBLE;
	private final TerminalRule tID;
	private final InstructionElements pInstruction;
	private final FunctionElements pFunction;
	private final CreateElements pCreate;
	private final LITERALElements pLITERAL;
	private final IntrinsicBranchWordsElements pIntrinsicBranchWords;
	private final IntrinsicStackWordsElements pIntrinsicStackWords;
	private final IntrinsicMemoryWordsElements pIntrinsicMemoryWords;
	private final IntrinsicArithmeticWordsElements pIntrinsicArithmeticWords;
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
		this.pInstruction = new InstructionElements();
		this.pFunction = new FunctionElements();
		this.pCreate = new CreateElements();
		this.pLITERAL = new LITERALElements();
		this.pIntrinsicBranchWords = new IntrinsicBranchWordsElements();
		this.pIntrinsicStackWords = new IntrinsicStackWordsElements();
		this.pIntrinsicMemoryWords = new IntrinsicMemoryWordsElements();
		this.pIntrinsicArithmeticWords = new IntrinsicArithmeticWordsElements();
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
	//	instructions+=Instruction*;
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

	//Instruction:
	//	Create | Function | Word;
	public InstructionElements getInstructionAccess() {
		return pInstruction;
	}
	
	public ParserRule getInstructionRule() {
		return getInstructionAccess().getRule();
	}

	//Function:
	//	":" Word words+=Word* ";";
	public FunctionElements getFunctionAccess() {
		return pFunction;
	}
	
	public ParserRule getFunctionRule() {
		return getFunctionAccess().getRule();
	}

	//Create:
	//	"create" name=ID (lit+=LITERAL ",")*;
	public CreateElements getCreateAccess() {
		return pCreate;
	}
	
	public ParserRule getCreateRule() {
		return getCreateAccess().getRule();
	}

	//LITERAL:
	//	INT | DOUBLE;
	public LITERALElements getLITERALAccess() {
		return pLITERAL;
	}
	
	public ParserRule getLITERALRule() {
		return getLITERALAccess().getRule();
	}

	//IntrinsicBranchWords:
	//	name=("jsr" | "0=branch" | "0<>branch" | "?-branch" | "s-branch" | "ns-branch" | "nc-branch" | "no-branch" |
	//	"tor-branch" | "z-exit" | "nz-exit");
	public IntrinsicBranchWordsElements getIntrinsicBranchWordsAccess() {
		return pIntrinsicBranchWords;
	}
	
	public ParserRule getIntrinsicBranchWordsRule() {
		return getIntrinsicBranchWordsAccess().getRule();
	}

	//IntrinsicStackWords:
	//	name=("CLEAR" | "DROP" | "DUP" | "?DUP" | "SWAP" | "NIP" | "OVER" | "ROT" | "-ROT" | "TUCK" | "UNDER" | "2DROP" |
	//	"2DUP" | "2SWAP" | "2OVER" | "RCLEAR" | "R@" | "r>" | ">r" | "RDROP");
	public IntrinsicStackWordsElements getIntrinsicStackWordsAccess() {
		return pIntrinsicStackWords;
	}
	
	public ParserRule getIntrinsicStackWordsRule() {
		return getIntrinsicStackWordsAccess().getRule();
	}

	//IntrinsicMemoryWords:
	//	name=("LD" | "@" | "ST" | "!" | "2@" | "2!" | "LLD" | "L@" | "LST" | "L!" | "TLD" | "T@" | "TST" | "T!" | "+ST" | "+!"
	//	| "INC" | "DEC" | "ON" | "OFF" | "ERASE" | "FILL" | "COUNT" | "MOVE" | "PLACE");
	public IntrinsicMemoryWordsElements getIntrinsicMemoryWordsAccess() {
		return pIntrinsicMemoryWords;
	}
	
	public ParserRule getIntrinsicMemoryWordsRule() {
		return getIntrinsicMemoryWordsAccess().getRule();
	}

	//IntrinsicArithmeticWords:
	//	name=("+" | "-" | "*" | "/" | "2*" | "2/" | "u2/" | "ROR" | "DROR" | "ROL" | "DROL" | "PACK" | "UNPACK" | "SHIFT" |
	//	"ASHIFT" | "2**" | "0=" | "0<>" | "0<" | "d0=" | "NEGATE" | "DNEGATE" | "1+" | "1-" | "TRUE" | "FALSE" | "CELL+" |
	//	"CELL-" | "CARRY_RESET" | "CARRY-SET" | "ABS" | "DABS" | "EXTEND");
	public IntrinsicArithmeticWordsElements getIntrinsicArithmeticWordsAccess() {
		return pIntrinsicArithmeticWords;
	}
	
	public ParserRule getIntrinsicArithmeticWordsRule() {
		return getIntrinsicArithmeticWordsAccess().getRule();
	}

	//Word:
	//	IntrinsicBranchWords | IntrinsicStackWords | IntrinsicMemoryWords | IntrinsicArithmeticWords | name=LITERAL | name=ID;
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
