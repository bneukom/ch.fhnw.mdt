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



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUForthParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CARRY_RESET", "TorBranch", "Branch_2", "CARRYSET", "NcBranch", "NoBranch", "NsBranch", "Branch", "Branch_1", "SBranch", "DNEGATE", "NzExit", "ASHIFT", "EXTEND", "NEGATE", "RCLEAR", "UNPACK", "Create", "ZExit", "DROP_1", "OVER_1", "SWAP_1", "CELL", "CELL_1", "CLEAR", "COUNT", "ERASE", "FALSE", "PLACE", "RDROP", "SHIFT", "UNDER", "ROT_1", "DUP_1", "DUP_2", "DABS", "DROL", "DROP", "DROR", "FILL", "MOVE", "OVER", "PACK", "SWAP", "TRUE", "TUCK", "ST_1", "DigitZeroLessThanSignGreaterThanSign", "DigitTwoAsteriskAsterisk", "ABS", "DEC", "DUP", "INC", "LLD", "LST", "NIP", "OFF", "ROL", "ROR", "ROT", "TLD", "TST", "D0", "Jsr", "U2", "PlusSignExclamationMark", "DigitZeroLessThanSign", "DigitZeroEqualsSign", "DigitOnePlusSign", "DigitOneHyphenMinus", "DigitTwoExclamationMark", "DigitTwoAsterisk", "DigitTwoSolidus", "DigitTwoCommercialAt", "R", "L", "L_1", "LD", "ON", "R_1", "ST", "T", "T_1", "R_2", "ExclamationMark", "Asterisk", "PlusSign", "Comma", "HyphenMinus", "Solidus", "Colon", "Semicolon", "CommercialAt", "RULE_DIGIT", "RULE_DECINT", "RULE_WS", "RULE_SL_COMMENT", "RULE_INT", "RULE_DOUBLE", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_ANY_OTHER"
    };
    public static final int ROT_1=36;
    public static final int DigitTwoExclamationMark=74;
    public static final int NEGATE=18;
    public static final int PlusSignExclamationMark=69;
    public static final int T_1=86;
    public static final int TorBranch=5;
    public static final int SWAP_1=25;
    public static final int DigitZeroLessThanSign=70;
    public static final int ExclamationMark=88;
    public static final int RULE_ID=103;
    public static final int Jsr=67;
    public static final int RULE_DIGIT=97;
    public static final int OVER_1=24;
    public static final int DigitTwoCommercialAt=77;
    public static final int DUP_2=38;
    public static final int PlusSign=90;
    public static final int RULE_INT=101;
    public static final int DUP_1=37;
    public static final int RULE_ML_COMMENT=105;
    public static final int COUNT=29;
    public static final int PACK=46;
    public static final int DigitOnePlusSign=72;
    public static final int L=79;
    public static final int UNPACK=20;
    public static final int OFF=60;
    public static final int Comma=91;
    public static final int ABS=53;
    public static final int R=78;
    public static final int HyphenMinus=92;
    public static final int DROP_1=23;
    public static final int T=85;
    public static final int Solidus=93;
    public static final int RULE_DECINT=98;
    public static final int ASHIFT=16;
    public static final int NoBranch=9;
    public static final int ST=84;
    public static final int DNEGATE=14;
    public static final int UNDER=35;
    public static final int SBranch=13;
    public static final int D0=66;
    public static final int PLACE=32;
    public static final int NcBranch=8;
    public static final int CommercialAt=96;
    public static final int Semicolon=95;
    public static final int ERASE=30;
    public static final int DigitOneHyphenMinus=73;
    public static final int LD=81;
    public static final int CELL=26;
    public static final int U2=68;
    public static final int R_2=87;
    public static final int R_1=83;
    public static final int ZExit=22;
    public static final int TUCK=49;
    public static final int DABS=39;
    public static final int CARRYSET=7;
    public static final int Branch_1=12;
    public static final int Branch_2=6;
    public static final int FILL=43;
    public static final int EXTEND=17;
    public static final int TRUE=48;
    public static final int LST=58;
    public static final int ROL=61;
    public static final int SWAP=47;
    public static final int ROR=62;
    public static final int TST=65;
    public static final int ROT=63;
    public static final int DigitTwoSolidus=76;
    public static final int CARRY_RESET=4;
    public static final int DigitTwoAsteriskAsterisk=52;
    public static final int INC=56;
    public static final int LLD=57;
    public static final int RULE_STRING=104;
    public static final int DROL=40;
    public static final int TLD=64;
    public static final int DROP=41;
    public static final int RULE_SL_COMMENT=100;
    public static final int CELL_1=27;
    public static final int SHIFT=34;
    public static final int DROR=42;
    public static final int RULE_DOUBLE=102;
    public static final int Branch=11;
    public static final int Create=21;
    public static final int NzExit=15;
    public static final int RCLEAR=19;
    public static final int Colon=94;
    public static final int DigitZeroEqualsSign=71;
    public static final int EOF=-1;
    public static final int Asterisk=89;
    public static final int DUP=55;
    public static final int ON=82;
    public static final int RDROP=33;
    public static final int DEC=54;
    public static final int RULE_WS=99;
    public static final int RULE_ANY_OTHER=106;
    public static final int OVER=45;
    public static final int DigitTwoAsterisk=75;
    public static final int DigitZeroLessThanSignGreaterThanSign=51;
    public static final int ST_1=50;
    public static final int NIP=59;
    public static final int MOVE=44;
    public static final int FALSE=31;
    public static final int NsBranch=10;
    public static final int CLEAR=28;
    public static final int L_1=80;

    // delegates
    // delegators


        public InternalUForthParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalUForthParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalUForthParser.tokenNames; }
    public String getGrammarFileName() { return "../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g"; }


     
     	private UForthGrammarAccess grammarAccess;
     	
     	private final Map<String, String> tokenNameToValue = new HashMap<String, String>();
     	
     	{
    		tokenNameToValue.put("ExclamationMark", "'!'");
    		tokenNameToValue.put("Asterisk", "'*'");
    		tokenNameToValue.put("PlusSign", "'+'");
    		tokenNameToValue.put("Comma", "','");
    		tokenNameToValue.put("HyphenMinus", "'-'");
    		tokenNameToValue.put("Solidus", "'/'");
    		tokenNameToValue.put("Colon", "':'");
    		tokenNameToValue.put("Semicolon", "';'");
    		tokenNameToValue.put("CommercialAt", "'@'");
    		tokenNameToValue.put("PlusSignExclamationMark", "'+!'");
    		tokenNameToValue.put("DigitZeroLessThanSign", "'0<'");
    		tokenNameToValue.put("DigitZeroEqualsSign", "'0='");
    		tokenNameToValue.put("DigitOnePlusSign", "'1+'");
    		tokenNameToValue.put("DigitOneHyphenMinus", "'1-'");
    		tokenNameToValue.put("DigitTwoExclamationMark", "'2!'");
    		tokenNameToValue.put("DigitTwoAsterisk", "'2*'");
    		tokenNameToValue.put("DigitTwoSolidus", "'2/'");
    		tokenNameToValue.put("DigitTwoCommercialAt", "'2@'");
    		tokenNameToValue.put("R", "'>r'");
    		tokenNameToValue.put("L", "'L!'");
    		tokenNameToValue.put("L_1", "'L@'");
    		tokenNameToValue.put("LD", "'LD'");
    		tokenNameToValue.put("ON", "'ON'");
    		tokenNameToValue.put("R_1", "'R@'");
    		tokenNameToValue.put("ST", "'ST'");
    		tokenNameToValue.put("T", "'T!'");
    		tokenNameToValue.put("T_1", "'T@'");
    		tokenNameToValue.put("R_2", "'r>'");
    		tokenNameToValue.put("ST_1", "'+ST'");
    		tokenNameToValue.put("DigitZeroLessThanSignGreaterThanSign", "'0<>'");
    		tokenNameToValue.put("DigitTwoAsteriskAsterisk", "'2**'");
    		tokenNameToValue.put("ABS", "'ABS'");
    		tokenNameToValue.put("DEC", "'DEC'");
    		tokenNameToValue.put("DUP", "'DUP'");
    		tokenNameToValue.put("INC", "'INC'");
    		tokenNameToValue.put("LLD", "'LLD'");
    		tokenNameToValue.put("LST", "'LST'");
    		tokenNameToValue.put("NIP", "'NIP'");
    		tokenNameToValue.put("OFF", "'OFF'");
    		tokenNameToValue.put("ROL", "'ROL'");
    		tokenNameToValue.put("ROR", "'ROR'");
    		tokenNameToValue.put("ROT", "'ROT'");
    		tokenNameToValue.put("TLD", "'TLD'");
    		tokenNameToValue.put("TST", "'TST'");
    		tokenNameToValue.put("D0", "'d0='");
    		tokenNameToValue.put("Jsr", "'jsr'");
    		tokenNameToValue.put("U2", "'u2/'");
    		tokenNameToValue.put("ROT_1", "'-ROT'");
    		tokenNameToValue.put("DUP_1", "'2DUP'");
    		tokenNameToValue.put("DUP_2", "'?DUP'");
    		tokenNameToValue.put("DABS", "'DABS'");
    		tokenNameToValue.put("DROL", "'DROL'");
    		tokenNameToValue.put("DROP", "'DROP'");
    		tokenNameToValue.put("DROR", "'DROR'");
    		tokenNameToValue.put("FILL", "'FILL'");
    		tokenNameToValue.put("MOVE", "'MOVE'");
    		tokenNameToValue.put("OVER", "'OVER'");
    		tokenNameToValue.put("PACK", "'PACK'");
    		tokenNameToValue.put("SWAP", "'SWAP'");
    		tokenNameToValue.put("TRUE", "'TRUE'");
    		tokenNameToValue.put("TUCK", "'TUCK'");
    		tokenNameToValue.put("DROP_1", "'2DROP'");
    		tokenNameToValue.put("OVER_1", "'2OVER'");
    		tokenNameToValue.put("SWAP_1", "'2SWAP'");
    		tokenNameToValue.put("CELL", "'CELL+'");
    		tokenNameToValue.put("CELL_1", "'CELL-'");
    		tokenNameToValue.put("CLEAR", "'CLEAR'");
    		tokenNameToValue.put("COUNT", "'COUNT'");
    		tokenNameToValue.put("ERASE", "'ERASE'");
    		tokenNameToValue.put("FALSE", "'FALSE'");
    		tokenNameToValue.put("PLACE", "'PLACE'");
    		tokenNameToValue.put("RDROP", "'RDROP'");
    		tokenNameToValue.put("SHIFT", "'SHIFT'");
    		tokenNameToValue.put("UNDER", "'UNDER'");
    		tokenNameToValue.put("ASHIFT", "'ASHIFT'");
    		tokenNameToValue.put("EXTEND", "'EXTEND'");
    		tokenNameToValue.put("NEGATE", "'NEGATE'");
    		tokenNameToValue.put("RCLEAR", "'RCLEAR'");
    		tokenNameToValue.put("UNPACK", "'UNPACK'");
    		tokenNameToValue.put("Create", "'create'");
    		tokenNameToValue.put("ZExit", "'z-exit'");
    		tokenNameToValue.put("DNEGATE", "'DNEGATE'");
    		tokenNameToValue.put("NzExit", "'nz-exit'");
    		tokenNameToValue.put("Branch", "'0=branch'");
    		tokenNameToValue.put("Branch_1", "'?-branch'");
    		tokenNameToValue.put("SBranch", "'s-branch'");
    		tokenNameToValue.put("Branch_2", "'0<>branch'");
    		tokenNameToValue.put("CARRYSET", "'CARRY-SET'");
    		tokenNameToValue.put("NcBranch", "'nc-branch'");
    		tokenNameToValue.put("NoBranch", "'no-branch'");
    		tokenNameToValue.put("NsBranch", "'ns-branch'");
    		tokenNameToValue.put("TorBranch", "'tor-branch'");
    		tokenNameToValue.put("CARRY_RESET", "'CARRY_RESET'");
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



    // $ANTLR start "entryRuleForth"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:156:1: entryRuleForth : ruleForth EOF ;
    public final void entryRuleForth() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:157:1: ( ruleForth EOF )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:158:1: ruleForth EOF
            {
             before(grammarAccess.getForthRule()); 
            pushFollow(FOLLOW_ruleForth_in_entryRuleForth54);
            ruleForth();

            state._fsp--;

             after(grammarAccess.getForthRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleForth61); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleForth"


    // $ANTLR start "ruleForth"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:165:1: ruleForth : ( ( rule__Forth__InstructionsAssignment )* ) ;
    public final void ruleForth() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:169:5: ( ( ( rule__Forth__InstructionsAssignment )* ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:170:1: ( ( rule__Forth__InstructionsAssignment )* )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:170:1: ( ( rule__Forth__InstructionsAssignment )* )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:171:1: ( rule__Forth__InstructionsAssignment )*
            {
             before(grammarAccess.getForthAccess().getInstructionsAssignment()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:172:1: ( rule__Forth__InstructionsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=CARRY_RESET && LA1_0<=PlusSign)||(LA1_0>=HyphenMinus && LA1_0<=Colon)||LA1_0==CommercialAt||(LA1_0>=RULE_INT && LA1_0<=RULE_ID)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:172:2: rule__Forth__InstructionsAssignment
            	    {
            	    pushFollow(FOLLOW_rule__Forth__InstructionsAssignment_in_ruleForth91);
            	    rule__Forth__InstructionsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getForthAccess().getInstructionsAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleForth"


    // $ANTLR start "entryRuleInstruction"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:184:1: entryRuleInstruction : ruleInstruction EOF ;
    public final void entryRuleInstruction() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:185:1: ( ruleInstruction EOF )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:186:1: ruleInstruction EOF
            {
             before(grammarAccess.getInstructionRule()); 
            pushFollow(FOLLOW_ruleInstruction_in_entryRuleInstruction119);
            ruleInstruction();

            state._fsp--;

             after(grammarAccess.getInstructionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstruction126); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInstruction"


    // $ANTLR start "ruleInstruction"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:193:1: ruleInstruction : ( ( rule__Instruction__Alternatives ) ) ;
    public final void ruleInstruction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:197:5: ( ( ( rule__Instruction__Alternatives ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:198:1: ( ( rule__Instruction__Alternatives ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:198:1: ( ( rule__Instruction__Alternatives ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:199:1: ( rule__Instruction__Alternatives )
            {
             before(grammarAccess.getInstructionAccess().getAlternatives()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:200:1: ( rule__Instruction__Alternatives )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:200:2: rule__Instruction__Alternatives
            {
            pushFollow(FOLLOW_rule__Instruction__Alternatives_in_ruleInstruction156);
            rule__Instruction__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getInstructionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInstruction"


    // $ANTLR start "entryRuleFunction"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:212:1: entryRuleFunction : ruleFunction EOF ;
    public final void entryRuleFunction() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:213:1: ( ruleFunction EOF )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:214:1: ruleFunction EOF
            {
             before(grammarAccess.getFunctionRule()); 
            pushFollow(FOLLOW_ruleFunction_in_entryRuleFunction183);
            ruleFunction();

            state._fsp--;

             after(grammarAccess.getFunctionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunction190); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:221:1: ruleFunction : ( ( rule__Function__Group__0 ) ) ;
    public final void ruleFunction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:225:5: ( ( ( rule__Function__Group__0 ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:226:1: ( ( rule__Function__Group__0 ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:226:1: ( ( rule__Function__Group__0 ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:227:1: ( rule__Function__Group__0 )
            {
             before(grammarAccess.getFunctionAccess().getGroup()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:228:1: ( rule__Function__Group__0 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:228:2: rule__Function__Group__0
            {
            pushFollow(FOLLOW_rule__Function__Group__0_in_ruleFunction220);
            rule__Function__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFunctionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleCreate"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:240:1: entryRuleCreate : ruleCreate EOF ;
    public final void entryRuleCreate() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:241:1: ( ruleCreate EOF )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:242:1: ruleCreate EOF
            {
             before(grammarAccess.getCreateRule()); 
            pushFollow(FOLLOW_ruleCreate_in_entryRuleCreate247);
            ruleCreate();

            state._fsp--;

             after(grammarAccess.getCreateRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCreate254); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCreate"


    // $ANTLR start "ruleCreate"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:249:1: ruleCreate : ( ( rule__Create__Group__0 ) ) ;
    public final void ruleCreate() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:253:5: ( ( ( rule__Create__Group__0 ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:254:1: ( ( rule__Create__Group__0 ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:254:1: ( ( rule__Create__Group__0 ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:255:1: ( rule__Create__Group__0 )
            {
             before(grammarAccess.getCreateAccess().getGroup()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:256:1: ( rule__Create__Group__0 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:256:2: rule__Create__Group__0
            {
            pushFollow(FOLLOW_rule__Create__Group__0_in_ruleCreate284);
            rule__Create__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCreateAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCreate"


    // $ANTLR start "entryRuleLITERAL"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:268:1: entryRuleLITERAL : ruleLITERAL EOF ;
    public final void entryRuleLITERAL() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:269:1: ( ruleLITERAL EOF )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:270:1: ruleLITERAL EOF
            {
             before(grammarAccess.getLITERALRule()); 
            pushFollow(FOLLOW_ruleLITERAL_in_entryRuleLITERAL311);
            ruleLITERAL();

            state._fsp--;

             after(grammarAccess.getLITERALRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLITERAL318); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLITERAL"


    // $ANTLR start "ruleLITERAL"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:277:1: ruleLITERAL : ( ( rule__LITERAL__Alternatives ) ) ;
    public final void ruleLITERAL() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:281:5: ( ( ( rule__LITERAL__Alternatives ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:282:1: ( ( rule__LITERAL__Alternatives ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:282:1: ( ( rule__LITERAL__Alternatives ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:283:1: ( rule__LITERAL__Alternatives )
            {
             before(grammarAccess.getLITERALAccess().getAlternatives()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:284:1: ( rule__LITERAL__Alternatives )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:284:2: rule__LITERAL__Alternatives
            {
            pushFollow(FOLLOW_rule__LITERAL__Alternatives_in_ruleLITERAL348);
            rule__LITERAL__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLITERALAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLITERAL"


    // $ANTLR start "entryRuleIntrinsicBranchWords"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:296:1: entryRuleIntrinsicBranchWords : ruleIntrinsicBranchWords EOF ;
    public final void entryRuleIntrinsicBranchWords() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:297:1: ( ruleIntrinsicBranchWords EOF )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:298:1: ruleIntrinsicBranchWords EOF
            {
             before(grammarAccess.getIntrinsicBranchWordsRule()); 
            pushFollow(FOLLOW_ruleIntrinsicBranchWords_in_entryRuleIntrinsicBranchWords375);
            ruleIntrinsicBranchWords();

            state._fsp--;

             after(grammarAccess.getIntrinsicBranchWordsRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntrinsicBranchWords382); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIntrinsicBranchWords"


    // $ANTLR start "ruleIntrinsicBranchWords"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:305:1: ruleIntrinsicBranchWords : ( ( rule__IntrinsicBranchWords__NameAssignment ) ) ;
    public final void ruleIntrinsicBranchWords() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:309:5: ( ( ( rule__IntrinsicBranchWords__NameAssignment ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:310:1: ( ( rule__IntrinsicBranchWords__NameAssignment ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:310:1: ( ( rule__IntrinsicBranchWords__NameAssignment ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:311:1: ( rule__IntrinsicBranchWords__NameAssignment )
            {
             before(grammarAccess.getIntrinsicBranchWordsAccess().getNameAssignment()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:312:1: ( rule__IntrinsicBranchWords__NameAssignment )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:312:2: rule__IntrinsicBranchWords__NameAssignment
            {
            pushFollow(FOLLOW_rule__IntrinsicBranchWords__NameAssignment_in_ruleIntrinsicBranchWords412);
            rule__IntrinsicBranchWords__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getIntrinsicBranchWordsAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIntrinsicBranchWords"


    // $ANTLR start "entryRuleIntrinsicStackWords"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:324:1: entryRuleIntrinsicStackWords : ruleIntrinsicStackWords EOF ;
    public final void entryRuleIntrinsicStackWords() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:325:1: ( ruleIntrinsicStackWords EOF )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:326:1: ruleIntrinsicStackWords EOF
            {
             before(grammarAccess.getIntrinsicStackWordsRule()); 
            pushFollow(FOLLOW_ruleIntrinsicStackWords_in_entryRuleIntrinsicStackWords439);
            ruleIntrinsicStackWords();

            state._fsp--;

             after(grammarAccess.getIntrinsicStackWordsRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntrinsicStackWords446); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIntrinsicStackWords"


    // $ANTLR start "ruleIntrinsicStackWords"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:333:1: ruleIntrinsicStackWords : ( ( rule__IntrinsicStackWords__NameAssignment ) ) ;
    public final void ruleIntrinsicStackWords() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:337:5: ( ( ( rule__IntrinsicStackWords__NameAssignment ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:338:1: ( ( rule__IntrinsicStackWords__NameAssignment ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:338:1: ( ( rule__IntrinsicStackWords__NameAssignment ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:339:1: ( rule__IntrinsicStackWords__NameAssignment )
            {
             before(grammarAccess.getIntrinsicStackWordsAccess().getNameAssignment()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:340:1: ( rule__IntrinsicStackWords__NameAssignment )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:340:2: rule__IntrinsicStackWords__NameAssignment
            {
            pushFollow(FOLLOW_rule__IntrinsicStackWords__NameAssignment_in_ruleIntrinsicStackWords476);
            rule__IntrinsicStackWords__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getIntrinsicStackWordsAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIntrinsicStackWords"


    // $ANTLR start "entryRuleIntrinsicMemoryWords"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:352:1: entryRuleIntrinsicMemoryWords : ruleIntrinsicMemoryWords EOF ;
    public final void entryRuleIntrinsicMemoryWords() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:353:1: ( ruleIntrinsicMemoryWords EOF )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:354:1: ruleIntrinsicMemoryWords EOF
            {
             before(grammarAccess.getIntrinsicMemoryWordsRule()); 
            pushFollow(FOLLOW_ruleIntrinsicMemoryWords_in_entryRuleIntrinsicMemoryWords503);
            ruleIntrinsicMemoryWords();

            state._fsp--;

             after(grammarAccess.getIntrinsicMemoryWordsRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntrinsicMemoryWords510); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIntrinsicMemoryWords"


    // $ANTLR start "ruleIntrinsicMemoryWords"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:361:1: ruleIntrinsicMemoryWords : ( ( rule__IntrinsicMemoryWords__NameAssignment ) ) ;
    public final void ruleIntrinsicMemoryWords() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:365:5: ( ( ( rule__IntrinsicMemoryWords__NameAssignment ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:366:1: ( ( rule__IntrinsicMemoryWords__NameAssignment ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:366:1: ( ( rule__IntrinsicMemoryWords__NameAssignment ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:367:1: ( rule__IntrinsicMemoryWords__NameAssignment )
            {
             before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameAssignment()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:368:1: ( rule__IntrinsicMemoryWords__NameAssignment )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:368:2: rule__IntrinsicMemoryWords__NameAssignment
            {
            pushFollow(FOLLOW_rule__IntrinsicMemoryWords__NameAssignment_in_ruleIntrinsicMemoryWords540);
            rule__IntrinsicMemoryWords__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIntrinsicMemoryWords"


    // $ANTLR start "entryRuleIntrinsicArithmeticWords"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:380:1: entryRuleIntrinsicArithmeticWords : ruleIntrinsicArithmeticWords EOF ;
    public final void entryRuleIntrinsicArithmeticWords() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:381:1: ( ruleIntrinsicArithmeticWords EOF )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:382:1: ruleIntrinsicArithmeticWords EOF
            {
             before(grammarAccess.getIntrinsicArithmeticWordsRule()); 
            pushFollow(FOLLOW_ruleIntrinsicArithmeticWords_in_entryRuleIntrinsicArithmeticWords567);
            ruleIntrinsicArithmeticWords();

            state._fsp--;

             after(grammarAccess.getIntrinsicArithmeticWordsRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntrinsicArithmeticWords574); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIntrinsicArithmeticWords"


    // $ANTLR start "ruleIntrinsicArithmeticWords"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:389:1: ruleIntrinsicArithmeticWords : ( ( rule__IntrinsicArithmeticWords__NameAssignment ) ) ;
    public final void ruleIntrinsicArithmeticWords() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:393:5: ( ( ( rule__IntrinsicArithmeticWords__NameAssignment ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:394:1: ( ( rule__IntrinsicArithmeticWords__NameAssignment ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:394:1: ( ( rule__IntrinsicArithmeticWords__NameAssignment ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:395:1: ( rule__IntrinsicArithmeticWords__NameAssignment )
            {
             before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameAssignment()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:396:1: ( rule__IntrinsicArithmeticWords__NameAssignment )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:396:2: rule__IntrinsicArithmeticWords__NameAssignment
            {
            pushFollow(FOLLOW_rule__IntrinsicArithmeticWords__NameAssignment_in_ruleIntrinsicArithmeticWords604);
            rule__IntrinsicArithmeticWords__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIntrinsicArithmeticWords"


    // $ANTLR start "entryRuleWord"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:408:1: entryRuleWord : ruleWord EOF ;
    public final void entryRuleWord() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:409:1: ( ruleWord EOF )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:410:1: ruleWord EOF
            {
             before(grammarAccess.getWordRule()); 
            pushFollow(FOLLOW_ruleWord_in_entryRuleWord631);
            ruleWord();

            state._fsp--;

             after(grammarAccess.getWordRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWord638); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleWord"


    // $ANTLR start "ruleWord"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:417:1: ruleWord : ( ( rule__Word__Alternatives ) ) ;
    public final void ruleWord() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:421:5: ( ( ( rule__Word__Alternatives ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:422:1: ( ( rule__Word__Alternatives ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:422:1: ( ( rule__Word__Alternatives ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:423:1: ( rule__Word__Alternatives )
            {
             before(grammarAccess.getWordAccess().getAlternatives()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:424:1: ( rule__Word__Alternatives )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:424:2: rule__Word__Alternatives
            {
            pushFollow(FOLLOW_rule__Word__Alternatives_in_ruleWord668);
            rule__Word__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getWordAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWord"


    // $ANTLR start "rule__Instruction__Alternatives"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:436:1: rule__Instruction__Alternatives : ( ( ruleCreate ) | ( ruleFunction ) | ( ruleWord ) );
    public final void rule__Instruction__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:440:1: ( ( ruleCreate ) | ( ruleFunction ) | ( ruleWord ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case Create:
                {
                alt2=1;
                }
                break;
            case Colon:
                {
                alt2=2;
                }
                break;
            case CARRY_RESET:
            case TorBranch:
            case Branch_2:
            case CARRYSET:
            case NcBranch:
            case NoBranch:
            case NsBranch:
            case Branch:
            case Branch_1:
            case SBranch:
            case DNEGATE:
            case NzExit:
            case ASHIFT:
            case EXTEND:
            case NEGATE:
            case RCLEAR:
            case UNPACK:
            case ZExit:
            case DROP_1:
            case OVER_1:
            case SWAP_1:
            case CELL:
            case CELL_1:
            case CLEAR:
            case COUNT:
            case ERASE:
            case FALSE:
            case PLACE:
            case RDROP:
            case SHIFT:
            case UNDER:
            case ROT_1:
            case DUP_1:
            case DUP_2:
            case DABS:
            case DROL:
            case DROP:
            case DROR:
            case FILL:
            case MOVE:
            case OVER:
            case PACK:
            case SWAP:
            case TRUE:
            case TUCK:
            case ST_1:
            case DigitZeroLessThanSignGreaterThanSign:
            case DigitTwoAsteriskAsterisk:
            case ABS:
            case DEC:
            case DUP:
            case INC:
            case LLD:
            case LST:
            case NIP:
            case OFF:
            case ROL:
            case ROR:
            case ROT:
            case TLD:
            case TST:
            case D0:
            case Jsr:
            case U2:
            case PlusSignExclamationMark:
            case DigitZeroLessThanSign:
            case DigitZeroEqualsSign:
            case DigitOnePlusSign:
            case DigitOneHyphenMinus:
            case DigitTwoExclamationMark:
            case DigitTwoAsterisk:
            case DigitTwoSolidus:
            case DigitTwoCommercialAt:
            case R:
            case L:
            case L_1:
            case LD:
            case ON:
            case R_1:
            case ST:
            case T:
            case T_1:
            case R_2:
            case ExclamationMark:
            case Asterisk:
            case PlusSign:
            case HyphenMinus:
            case Solidus:
            case CommercialAt:
            case RULE_INT:
            case RULE_DOUBLE:
            case RULE_ID:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:441:1: ( ruleCreate )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:441:1: ( ruleCreate )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:442:1: ruleCreate
                    {
                     before(grammarAccess.getInstructionAccess().getCreateParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleCreate_in_rule__Instruction__Alternatives704);
                    ruleCreate();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getCreateParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:447:6: ( ruleFunction )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:447:6: ( ruleFunction )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:448:1: ruleFunction
                    {
                     before(grammarAccess.getInstructionAccess().getFunctionParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleFunction_in_rule__Instruction__Alternatives721);
                    ruleFunction();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getFunctionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:453:6: ( ruleWord )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:453:6: ( ruleWord )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:454:1: ruleWord
                    {
                     before(grammarAccess.getInstructionAccess().getWordParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleWord_in_rule__Instruction__Alternatives738);
                    ruleWord();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getWordParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Alternatives"


    // $ANTLR start "rule__LITERAL__Alternatives"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:464:1: rule__LITERAL__Alternatives : ( ( RULE_INT ) | ( RULE_DOUBLE ) );
    public final void rule__LITERAL__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:468:1: ( ( RULE_INT ) | ( RULE_DOUBLE ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_INT) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_DOUBLE) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:469:1: ( RULE_INT )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:469:1: ( RULE_INT )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:470:1: RULE_INT
                    {
                     before(grammarAccess.getLITERALAccess().getINTTerminalRuleCall_0()); 
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__LITERAL__Alternatives770); 
                     after(grammarAccess.getLITERALAccess().getINTTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:475:6: ( RULE_DOUBLE )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:475:6: ( RULE_DOUBLE )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:476:1: RULE_DOUBLE
                    {
                     before(grammarAccess.getLITERALAccess().getDOUBLETerminalRuleCall_1()); 
                    match(input,RULE_DOUBLE,FOLLOW_RULE_DOUBLE_in_rule__LITERAL__Alternatives787); 
                     after(grammarAccess.getLITERALAccess().getDOUBLETerminalRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LITERAL__Alternatives"


    // $ANTLR start "rule__IntrinsicBranchWords__NameAlternatives_0"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:486:1: rule__IntrinsicBranchWords__NameAlternatives_0 : ( ( Jsr ) | ( Branch ) | ( Branch_2 ) | ( Branch_1 ) | ( SBranch ) | ( NsBranch ) | ( NcBranch ) | ( NoBranch ) | ( TorBranch ) | ( ZExit ) | ( NzExit ) );
    public final void rule__IntrinsicBranchWords__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:490:1: ( ( Jsr ) | ( Branch ) | ( Branch_2 ) | ( Branch_1 ) | ( SBranch ) | ( NsBranch ) | ( NcBranch ) | ( NoBranch ) | ( TorBranch ) | ( ZExit ) | ( NzExit ) )
            int alt4=11;
            switch ( input.LA(1) ) {
            case Jsr:
                {
                alt4=1;
                }
                break;
            case Branch:
                {
                alt4=2;
                }
                break;
            case Branch_2:
                {
                alt4=3;
                }
                break;
            case Branch_1:
                {
                alt4=4;
                }
                break;
            case SBranch:
                {
                alt4=5;
                }
                break;
            case NsBranch:
                {
                alt4=6;
                }
                break;
            case NcBranch:
                {
                alt4=7;
                }
                break;
            case NoBranch:
                {
                alt4=8;
                }
                break;
            case TorBranch:
                {
                alt4=9;
                }
                break;
            case ZExit:
                {
                alt4=10;
                }
                break;
            case NzExit:
                {
                alt4=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:491:1: ( Jsr )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:491:1: ( Jsr )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:492:1: Jsr
                    {
                     before(grammarAccess.getIntrinsicBranchWordsAccess().getNameJsrKeyword_0_0()); 
                    match(input,Jsr,FOLLOW_Jsr_in_rule__IntrinsicBranchWords__NameAlternatives_0820); 
                     after(grammarAccess.getIntrinsicBranchWordsAccess().getNameJsrKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:499:6: ( Branch )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:499:6: ( Branch )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:500:1: Branch
                    {
                     before(grammarAccess.getIntrinsicBranchWordsAccess().getName0BranchKeyword_0_1()); 
                    match(input,Branch,FOLLOW_Branch_in_rule__IntrinsicBranchWords__NameAlternatives_0840); 
                     after(grammarAccess.getIntrinsicBranchWordsAccess().getName0BranchKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:507:6: ( Branch_2 )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:507:6: ( Branch_2 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:508:1: Branch_2
                    {
                     before(grammarAccess.getIntrinsicBranchWordsAccess().getName0BranchKeyword_0_2()); 
                    match(input,Branch_2,FOLLOW_Branch_2_in_rule__IntrinsicBranchWords__NameAlternatives_0860); 
                     after(grammarAccess.getIntrinsicBranchWordsAccess().getName0BranchKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:515:6: ( Branch_1 )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:515:6: ( Branch_1 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:516:1: Branch_1
                    {
                     before(grammarAccess.getIntrinsicBranchWordsAccess().getNameBranchKeyword_0_3()); 
                    match(input,Branch_1,FOLLOW_Branch_1_in_rule__IntrinsicBranchWords__NameAlternatives_0880); 
                     after(grammarAccess.getIntrinsicBranchWordsAccess().getNameBranchKeyword_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:523:6: ( SBranch )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:523:6: ( SBranch )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:524:1: SBranch
                    {
                     before(grammarAccess.getIntrinsicBranchWordsAccess().getNameSBranchKeyword_0_4()); 
                    match(input,SBranch,FOLLOW_SBranch_in_rule__IntrinsicBranchWords__NameAlternatives_0900); 
                     after(grammarAccess.getIntrinsicBranchWordsAccess().getNameSBranchKeyword_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:531:6: ( NsBranch )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:531:6: ( NsBranch )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:532:1: NsBranch
                    {
                     before(grammarAccess.getIntrinsicBranchWordsAccess().getNameNsBranchKeyword_0_5()); 
                    match(input,NsBranch,FOLLOW_NsBranch_in_rule__IntrinsicBranchWords__NameAlternatives_0920); 
                     after(grammarAccess.getIntrinsicBranchWordsAccess().getNameNsBranchKeyword_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:539:6: ( NcBranch )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:539:6: ( NcBranch )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:540:1: NcBranch
                    {
                     before(grammarAccess.getIntrinsicBranchWordsAccess().getNameNcBranchKeyword_0_6()); 
                    match(input,NcBranch,FOLLOW_NcBranch_in_rule__IntrinsicBranchWords__NameAlternatives_0940); 
                     after(grammarAccess.getIntrinsicBranchWordsAccess().getNameNcBranchKeyword_0_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:547:6: ( NoBranch )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:547:6: ( NoBranch )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:548:1: NoBranch
                    {
                     before(grammarAccess.getIntrinsicBranchWordsAccess().getNameNoBranchKeyword_0_7()); 
                    match(input,NoBranch,FOLLOW_NoBranch_in_rule__IntrinsicBranchWords__NameAlternatives_0960); 
                     after(grammarAccess.getIntrinsicBranchWordsAccess().getNameNoBranchKeyword_0_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:555:6: ( TorBranch )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:555:6: ( TorBranch )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:556:1: TorBranch
                    {
                     before(grammarAccess.getIntrinsicBranchWordsAccess().getNameTorBranchKeyword_0_8()); 
                    match(input,TorBranch,FOLLOW_TorBranch_in_rule__IntrinsicBranchWords__NameAlternatives_0980); 
                     after(grammarAccess.getIntrinsicBranchWordsAccess().getNameTorBranchKeyword_0_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:563:6: ( ZExit )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:563:6: ( ZExit )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:564:1: ZExit
                    {
                     before(grammarAccess.getIntrinsicBranchWordsAccess().getNameZExitKeyword_0_9()); 
                    match(input,ZExit,FOLLOW_ZExit_in_rule__IntrinsicBranchWords__NameAlternatives_01000); 
                     after(grammarAccess.getIntrinsicBranchWordsAccess().getNameZExitKeyword_0_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:571:6: ( NzExit )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:571:6: ( NzExit )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:572:1: NzExit
                    {
                     before(grammarAccess.getIntrinsicBranchWordsAccess().getNameNzExitKeyword_0_10()); 
                    match(input,NzExit,FOLLOW_NzExit_in_rule__IntrinsicBranchWords__NameAlternatives_01020); 
                     after(grammarAccess.getIntrinsicBranchWordsAccess().getNameNzExitKeyword_0_10()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntrinsicBranchWords__NameAlternatives_0"


    // $ANTLR start "rule__IntrinsicStackWords__NameAlternatives_0"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:584:1: rule__IntrinsicStackWords__NameAlternatives_0 : ( ( CLEAR ) | ( DROP ) | ( DUP ) | ( DUP_2 ) | ( SWAP ) | ( NIP ) | ( OVER ) | ( ROT ) | ( ROT_1 ) | ( TUCK ) | ( UNDER ) | ( DROP_1 ) | ( DUP_1 ) | ( SWAP_1 ) | ( OVER_1 ) | ( RCLEAR ) | ( R_1 ) | ( R_2 ) | ( R ) | ( RDROP ) );
    public final void rule__IntrinsicStackWords__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:588:1: ( ( CLEAR ) | ( DROP ) | ( DUP ) | ( DUP_2 ) | ( SWAP ) | ( NIP ) | ( OVER ) | ( ROT ) | ( ROT_1 ) | ( TUCK ) | ( UNDER ) | ( DROP_1 ) | ( DUP_1 ) | ( SWAP_1 ) | ( OVER_1 ) | ( RCLEAR ) | ( R_1 ) | ( R_2 ) | ( R ) | ( RDROP ) )
            int alt5=20;
            switch ( input.LA(1) ) {
            case CLEAR:
                {
                alt5=1;
                }
                break;
            case DROP:
                {
                alt5=2;
                }
                break;
            case DUP:
                {
                alt5=3;
                }
                break;
            case DUP_2:
                {
                alt5=4;
                }
                break;
            case SWAP:
                {
                alt5=5;
                }
                break;
            case NIP:
                {
                alt5=6;
                }
                break;
            case OVER:
                {
                alt5=7;
                }
                break;
            case ROT:
                {
                alt5=8;
                }
                break;
            case ROT_1:
                {
                alt5=9;
                }
                break;
            case TUCK:
                {
                alt5=10;
                }
                break;
            case UNDER:
                {
                alt5=11;
                }
                break;
            case DROP_1:
                {
                alt5=12;
                }
                break;
            case DUP_1:
                {
                alt5=13;
                }
                break;
            case SWAP_1:
                {
                alt5=14;
                }
                break;
            case OVER_1:
                {
                alt5=15;
                }
                break;
            case RCLEAR:
                {
                alt5=16;
                }
                break;
            case R_1:
                {
                alt5=17;
                }
                break;
            case R_2:
                {
                alt5=18;
                }
                break;
            case R:
                {
                alt5=19;
                }
                break;
            case RDROP:
                {
                alt5=20;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:589:1: ( CLEAR )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:589:1: ( CLEAR )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:590:1: CLEAR
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getNameCLEARKeyword_0_0()); 
                    match(input,CLEAR,FOLLOW_CLEAR_in_rule__IntrinsicStackWords__NameAlternatives_01055); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getNameCLEARKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:597:6: ( DROP )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:597:6: ( DROP )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:598:1: DROP
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getNameDROPKeyword_0_1()); 
                    match(input,DROP,FOLLOW_DROP_in_rule__IntrinsicStackWords__NameAlternatives_01075); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getNameDROPKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:605:6: ( DUP )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:605:6: ( DUP )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:606:1: DUP
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getNameDUPKeyword_0_2()); 
                    match(input,DUP,FOLLOW_DUP_in_rule__IntrinsicStackWords__NameAlternatives_01095); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getNameDUPKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:613:6: ( DUP_2 )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:613:6: ( DUP_2 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:614:1: DUP_2
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getNameDUPKeyword_0_3()); 
                    match(input,DUP_2,FOLLOW_DUP_2_in_rule__IntrinsicStackWords__NameAlternatives_01115); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getNameDUPKeyword_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:621:6: ( SWAP )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:621:6: ( SWAP )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:622:1: SWAP
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getNameSWAPKeyword_0_4()); 
                    match(input,SWAP,FOLLOW_SWAP_in_rule__IntrinsicStackWords__NameAlternatives_01135); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getNameSWAPKeyword_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:629:6: ( NIP )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:629:6: ( NIP )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:630:1: NIP
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getNameNIPKeyword_0_5()); 
                    match(input,NIP,FOLLOW_NIP_in_rule__IntrinsicStackWords__NameAlternatives_01155); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getNameNIPKeyword_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:637:6: ( OVER )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:637:6: ( OVER )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:638:1: OVER
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getNameOVERKeyword_0_6()); 
                    match(input,OVER,FOLLOW_OVER_in_rule__IntrinsicStackWords__NameAlternatives_01175); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getNameOVERKeyword_0_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:645:6: ( ROT )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:645:6: ( ROT )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:646:1: ROT
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getNameROTKeyword_0_7()); 
                    match(input,ROT,FOLLOW_ROT_in_rule__IntrinsicStackWords__NameAlternatives_01195); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getNameROTKeyword_0_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:653:6: ( ROT_1 )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:653:6: ( ROT_1 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:654:1: ROT_1
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getNameROTKeyword_0_8()); 
                    match(input,ROT_1,FOLLOW_ROT_1_in_rule__IntrinsicStackWords__NameAlternatives_01215); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getNameROTKeyword_0_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:661:6: ( TUCK )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:661:6: ( TUCK )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:662:1: TUCK
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getNameTUCKKeyword_0_9()); 
                    match(input,TUCK,FOLLOW_TUCK_in_rule__IntrinsicStackWords__NameAlternatives_01235); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getNameTUCKKeyword_0_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:669:6: ( UNDER )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:669:6: ( UNDER )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:670:1: UNDER
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getNameUNDERKeyword_0_10()); 
                    match(input,UNDER,FOLLOW_UNDER_in_rule__IntrinsicStackWords__NameAlternatives_01255); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getNameUNDERKeyword_0_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:677:6: ( DROP_1 )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:677:6: ( DROP_1 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:678:1: DROP_1
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getName2DROPKeyword_0_11()); 
                    match(input,DROP_1,FOLLOW_DROP_1_in_rule__IntrinsicStackWords__NameAlternatives_01275); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getName2DROPKeyword_0_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:685:6: ( DUP_1 )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:685:6: ( DUP_1 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:686:1: DUP_1
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getName2DUPKeyword_0_12()); 
                    match(input,DUP_1,FOLLOW_DUP_1_in_rule__IntrinsicStackWords__NameAlternatives_01295); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getName2DUPKeyword_0_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:693:6: ( SWAP_1 )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:693:6: ( SWAP_1 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:694:1: SWAP_1
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getName2SWAPKeyword_0_13()); 
                    match(input,SWAP_1,FOLLOW_SWAP_1_in_rule__IntrinsicStackWords__NameAlternatives_01315); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getName2SWAPKeyword_0_13()); 

                    }


                    }
                    break;
                case 15 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:701:6: ( OVER_1 )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:701:6: ( OVER_1 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:702:1: OVER_1
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getName2OVERKeyword_0_14()); 
                    match(input,OVER_1,FOLLOW_OVER_1_in_rule__IntrinsicStackWords__NameAlternatives_01335); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getName2OVERKeyword_0_14()); 

                    }


                    }
                    break;
                case 16 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:709:6: ( RCLEAR )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:709:6: ( RCLEAR )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:710:1: RCLEAR
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getNameRCLEARKeyword_0_15()); 
                    match(input,RCLEAR,FOLLOW_RCLEAR_in_rule__IntrinsicStackWords__NameAlternatives_01355); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getNameRCLEARKeyword_0_15()); 

                    }


                    }
                    break;
                case 17 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:717:6: ( R_1 )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:717:6: ( R_1 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:718:1: R_1
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getNameRKeyword_0_16()); 
                    match(input,R_1,FOLLOW_R_1_in_rule__IntrinsicStackWords__NameAlternatives_01375); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getNameRKeyword_0_16()); 

                    }


                    }
                    break;
                case 18 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:725:6: ( R_2 )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:725:6: ( R_2 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:726:1: R_2
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getNameRKeyword_0_17()); 
                    match(input,R_2,FOLLOW_R_2_in_rule__IntrinsicStackWords__NameAlternatives_01395); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getNameRKeyword_0_17()); 

                    }


                    }
                    break;
                case 19 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:733:6: ( R )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:733:6: ( R )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:734:1: R
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getNameRKeyword_0_18()); 
                    match(input,R,FOLLOW_R_in_rule__IntrinsicStackWords__NameAlternatives_01415); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getNameRKeyword_0_18()); 

                    }


                    }
                    break;
                case 20 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:741:6: ( RDROP )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:741:6: ( RDROP )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:742:1: RDROP
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getNameRDROPKeyword_0_19()); 
                    match(input,RDROP,FOLLOW_RDROP_in_rule__IntrinsicStackWords__NameAlternatives_01435); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getNameRDROPKeyword_0_19()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntrinsicStackWords__NameAlternatives_0"


    // $ANTLR start "rule__IntrinsicMemoryWords__NameAlternatives_0"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:754:1: rule__IntrinsicMemoryWords__NameAlternatives_0 : ( ( LD ) | ( CommercialAt ) | ( ST ) | ( ExclamationMark ) | ( DigitTwoCommercialAt ) | ( DigitTwoExclamationMark ) | ( LLD ) | ( L_1 ) | ( LST ) | ( L ) | ( TLD ) | ( T_1 ) | ( TST ) | ( T ) | ( ST_1 ) | ( PlusSignExclamationMark ) | ( INC ) | ( DEC ) | ( ON ) | ( OFF ) | ( ERASE ) | ( FILL ) | ( COUNT ) | ( MOVE ) | ( PLACE ) );
    public final void rule__IntrinsicMemoryWords__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:758:1: ( ( LD ) | ( CommercialAt ) | ( ST ) | ( ExclamationMark ) | ( DigitTwoCommercialAt ) | ( DigitTwoExclamationMark ) | ( LLD ) | ( L_1 ) | ( LST ) | ( L ) | ( TLD ) | ( T_1 ) | ( TST ) | ( T ) | ( ST_1 ) | ( PlusSignExclamationMark ) | ( INC ) | ( DEC ) | ( ON ) | ( OFF ) | ( ERASE ) | ( FILL ) | ( COUNT ) | ( MOVE ) | ( PLACE ) )
            int alt6=25;
            switch ( input.LA(1) ) {
            case LD:
                {
                alt6=1;
                }
                break;
            case CommercialAt:
                {
                alt6=2;
                }
                break;
            case ST:
                {
                alt6=3;
                }
                break;
            case ExclamationMark:
                {
                alt6=4;
                }
                break;
            case DigitTwoCommercialAt:
                {
                alt6=5;
                }
                break;
            case DigitTwoExclamationMark:
                {
                alt6=6;
                }
                break;
            case LLD:
                {
                alt6=7;
                }
                break;
            case L_1:
                {
                alt6=8;
                }
                break;
            case LST:
                {
                alt6=9;
                }
                break;
            case L:
                {
                alt6=10;
                }
                break;
            case TLD:
                {
                alt6=11;
                }
                break;
            case T_1:
                {
                alt6=12;
                }
                break;
            case TST:
                {
                alt6=13;
                }
                break;
            case T:
                {
                alt6=14;
                }
                break;
            case ST_1:
                {
                alt6=15;
                }
                break;
            case PlusSignExclamationMark:
                {
                alt6=16;
                }
                break;
            case INC:
                {
                alt6=17;
                }
                break;
            case DEC:
                {
                alt6=18;
                }
                break;
            case ON:
                {
                alt6=19;
                }
                break;
            case OFF:
                {
                alt6=20;
                }
                break;
            case ERASE:
                {
                alt6=21;
                }
                break;
            case FILL:
                {
                alt6=22;
                }
                break;
            case COUNT:
                {
                alt6=23;
                }
                break;
            case MOVE:
                {
                alt6=24;
                }
                break;
            case PLACE:
                {
                alt6=25;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:759:1: ( LD )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:759:1: ( LD )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:760:1: LD
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameLDKeyword_0_0()); 
                    match(input,LD,FOLLOW_LD_in_rule__IntrinsicMemoryWords__NameAlternatives_01470); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameLDKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:767:6: ( CommercialAt )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:767:6: ( CommercialAt )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:768:1: CommercialAt
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameCommercialAtKeyword_0_1()); 
                    match(input,CommercialAt,FOLLOW_CommercialAt_in_rule__IntrinsicMemoryWords__NameAlternatives_01490); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameCommercialAtKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:775:6: ( ST )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:775:6: ( ST )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:776:1: ST
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameSTKeyword_0_2()); 
                    match(input,ST,FOLLOW_ST_in_rule__IntrinsicMemoryWords__NameAlternatives_01510); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameSTKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:783:6: ( ExclamationMark )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:783:6: ( ExclamationMark )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:784:1: ExclamationMark
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameExclamationMarkKeyword_0_3()); 
                    match(input,ExclamationMark,FOLLOW_ExclamationMark_in_rule__IntrinsicMemoryWords__NameAlternatives_01530); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameExclamationMarkKeyword_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:791:6: ( DigitTwoCommercialAt )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:791:6: ( DigitTwoCommercialAt )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:792:1: DigitTwoCommercialAt
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getName2Keyword_0_4()); 
                    match(input,DigitTwoCommercialAt,FOLLOW_DigitTwoCommercialAt_in_rule__IntrinsicMemoryWords__NameAlternatives_01550); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getName2Keyword_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:799:6: ( DigitTwoExclamationMark )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:799:6: ( DigitTwoExclamationMark )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:800:1: DigitTwoExclamationMark
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getName2Keyword_0_5()); 
                    match(input,DigitTwoExclamationMark,FOLLOW_DigitTwoExclamationMark_in_rule__IntrinsicMemoryWords__NameAlternatives_01570); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getName2Keyword_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:807:6: ( LLD )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:807:6: ( LLD )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:808:1: LLD
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameLLDKeyword_0_6()); 
                    match(input,LLD,FOLLOW_LLD_in_rule__IntrinsicMemoryWords__NameAlternatives_01590); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameLLDKeyword_0_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:815:6: ( L_1 )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:815:6: ( L_1 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:816:1: L_1
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameLKeyword_0_7()); 
                    match(input,L_1,FOLLOW_L_1_in_rule__IntrinsicMemoryWords__NameAlternatives_01610); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameLKeyword_0_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:823:6: ( LST )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:823:6: ( LST )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:824:1: LST
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameLSTKeyword_0_8()); 
                    match(input,LST,FOLLOW_LST_in_rule__IntrinsicMemoryWords__NameAlternatives_01630); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameLSTKeyword_0_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:831:6: ( L )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:831:6: ( L )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:832:1: L
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameLKeyword_0_9()); 
                    match(input,L,FOLLOW_L_in_rule__IntrinsicMemoryWords__NameAlternatives_01650); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameLKeyword_0_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:839:6: ( TLD )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:839:6: ( TLD )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:840:1: TLD
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameTLDKeyword_0_10()); 
                    match(input,TLD,FOLLOW_TLD_in_rule__IntrinsicMemoryWords__NameAlternatives_01670); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameTLDKeyword_0_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:847:6: ( T_1 )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:847:6: ( T_1 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:848:1: T_1
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameTKeyword_0_11()); 
                    match(input,T_1,FOLLOW_T_1_in_rule__IntrinsicMemoryWords__NameAlternatives_01690); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameTKeyword_0_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:855:6: ( TST )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:855:6: ( TST )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:856:1: TST
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameTSTKeyword_0_12()); 
                    match(input,TST,FOLLOW_TST_in_rule__IntrinsicMemoryWords__NameAlternatives_01710); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameTSTKeyword_0_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:863:6: ( T )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:863:6: ( T )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:864:1: T
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameTKeyword_0_13()); 
                    match(input,T,FOLLOW_T_in_rule__IntrinsicMemoryWords__NameAlternatives_01730); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameTKeyword_0_13()); 

                    }


                    }
                    break;
                case 15 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:871:6: ( ST_1 )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:871:6: ( ST_1 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:872:1: ST_1
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameSTKeyword_0_14()); 
                    match(input,ST_1,FOLLOW_ST_1_in_rule__IntrinsicMemoryWords__NameAlternatives_01750); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameSTKeyword_0_14()); 

                    }


                    }
                    break;
                case 16 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:879:6: ( PlusSignExclamationMark )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:879:6: ( PlusSignExclamationMark )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:880:1: PlusSignExclamationMark
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNamePlusSignExclamationMarkKeyword_0_15()); 
                    match(input,PlusSignExclamationMark,FOLLOW_PlusSignExclamationMark_in_rule__IntrinsicMemoryWords__NameAlternatives_01770); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNamePlusSignExclamationMarkKeyword_0_15()); 

                    }


                    }
                    break;
                case 17 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:887:6: ( INC )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:887:6: ( INC )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:888:1: INC
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameINCKeyword_0_16()); 
                    match(input,INC,FOLLOW_INC_in_rule__IntrinsicMemoryWords__NameAlternatives_01790); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameINCKeyword_0_16()); 

                    }


                    }
                    break;
                case 18 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:895:6: ( DEC )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:895:6: ( DEC )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:896:1: DEC
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameDECKeyword_0_17()); 
                    match(input,DEC,FOLLOW_DEC_in_rule__IntrinsicMemoryWords__NameAlternatives_01810); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameDECKeyword_0_17()); 

                    }


                    }
                    break;
                case 19 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:903:6: ( ON )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:903:6: ( ON )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:904:1: ON
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameONKeyword_0_18()); 
                    match(input,ON,FOLLOW_ON_in_rule__IntrinsicMemoryWords__NameAlternatives_01830); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameONKeyword_0_18()); 

                    }


                    }
                    break;
                case 20 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:911:6: ( OFF )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:911:6: ( OFF )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:912:1: OFF
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameOFFKeyword_0_19()); 
                    match(input,OFF,FOLLOW_OFF_in_rule__IntrinsicMemoryWords__NameAlternatives_01850); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameOFFKeyword_0_19()); 

                    }


                    }
                    break;
                case 21 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:919:6: ( ERASE )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:919:6: ( ERASE )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:920:1: ERASE
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameERASEKeyword_0_20()); 
                    match(input,ERASE,FOLLOW_ERASE_in_rule__IntrinsicMemoryWords__NameAlternatives_01870); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameERASEKeyword_0_20()); 

                    }


                    }
                    break;
                case 22 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:927:6: ( FILL )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:927:6: ( FILL )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:928:1: FILL
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameFILLKeyword_0_21()); 
                    match(input,FILL,FOLLOW_FILL_in_rule__IntrinsicMemoryWords__NameAlternatives_01890); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameFILLKeyword_0_21()); 

                    }


                    }
                    break;
                case 23 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:935:6: ( COUNT )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:935:6: ( COUNT )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:936:1: COUNT
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameCOUNTKeyword_0_22()); 
                    match(input,COUNT,FOLLOW_COUNT_in_rule__IntrinsicMemoryWords__NameAlternatives_01910); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameCOUNTKeyword_0_22()); 

                    }


                    }
                    break;
                case 24 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:943:6: ( MOVE )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:943:6: ( MOVE )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:944:1: MOVE
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameMOVEKeyword_0_23()); 
                    match(input,MOVE,FOLLOW_MOVE_in_rule__IntrinsicMemoryWords__NameAlternatives_01930); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameMOVEKeyword_0_23()); 

                    }


                    }
                    break;
                case 25 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:951:6: ( PLACE )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:951:6: ( PLACE )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:952:1: PLACE
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNamePLACEKeyword_0_24()); 
                    match(input,PLACE,FOLLOW_PLACE_in_rule__IntrinsicMemoryWords__NameAlternatives_01950); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNamePLACEKeyword_0_24()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntrinsicMemoryWords__NameAlternatives_0"


    // $ANTLR start "rule__IntrinsicArithmeticWords__NameAlternatives_0"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:964:1: rule__IntrinsicArithmeticWords__NameAlternatives_0 : ( ( PlusSign ) | ( HyphenMinus ) | ( Asterisk ) | ( Solidus ) | ( DigitTwoAsterisk ) | ( DigitTwoSolidus ) | ( U2 ) | ( ROR ) | ( DROR ) | ( ROL ) | ( DROL ) | ( PACK ) | ( UNPACK ) | ( SHIFT ) | ( ASHIFT ) | ( DigitTwoAsteriskAsterisk ) | ( DigitZeroEqualsSign ) | ( DigitZeroLessThanSignGreaterThanSign ) | ( DigitZeroLessThanSign ) | ( D0 ) | ( NEGATE ) | ( DNEGATE ) | ( DigitOnePlusSign ) | ( DigitOneHyphenMinus ) | ( TRUE ) | ( FALSE ) | ( CELL ) | ( CELL_1 ) | ( CARRY_RESET ) | ( CARRYSET ) | ( ABS ) | ( DABS ) | ( EXTEND ) );
    public final void rule__IntrinsicArithmeticWords__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:968:1: ( ( PlusSign ) | ( HyphenMinus ) | ( Asterisk ) | ( Solidus ) | ( DigitTwoAsterisk ) | ( DigitTwoSolidus ) | ( U2 ) | ( ROR ) | ( DROR ) | ( ROL ) | ( DROL ) | ( PACK ) | ( UNPACK ) | ( SHIFT ) | ( ASHIFT ) | ( DigitTwoAsteriskAsterisk ) | ( DigitZeroEqualsSign ) | ( DigitZeroLessThanSignGreaterThanSign ) | ( DigitZeroLessThanSign ) | ( D0 ) | ( NEGATE ) | ( DNEGATE ) | ( DigitOnePlusSign ) | ( DigitOneHyphenMinus ) | ( TRUE ) | ( FALSE ) | ( CELL ) | ( CELL_1 ) | ( CARRY_RESET ) | ( CARRYSET ) | ( ABS ) | ( DABS ) | ( EXTEND ) )
            int alt7=33;
            switch ( input.LA(1) ) {
            case PlusSign:
                {
                alt7=1;
                }
                break;
            case HyphenMinus:
                {
                alt7=2;
                }
                break;
            case Asterisk:
                {
                alt7=3;
                }
                break;
            case Solidus:
                {
                alt7=4;
                }
                break;
            case DigitTwoAsterisk:
                {
                alt7=5;
                }
                break;
            case DigitTwoSolidus:
                {
                alt7=6;
                }
                break;
            case U2:
                {
                alt7=7;
                }
                break;
            case ROR:
                {
                alt7=8;
                }
                break;
            case DROR:
                {
                alt7=9;
                }
                break;
            case ROL:
                {
                alt7=10;
                }
                break;
            case DROL:
                {
                alt7=11;
                }
                break;
            case PACK:
                {
                alt7=12;
                }
                break;
            case UNPACK:
                {
                alt7=13;
                }
                break;
            case SHIFT:
                {
                alt7=14;
                }
                break;
            case ASHIFT:
                {
                alt7=15;
                }
                break;
            case DigitTwoAsteriskAsterisk:
                {
                alt7=16;
                }
                break;
            case DigitZeroEqualsSign:
                {
                alt7=17;
                }
                break;
            case DigitZeroLessThanSignGreaterThanSign:
                {
                alt7=18;
                }
                break;
            case DigitZeroLessThanSign:
                {
                alt7=19;
                }
                break;
            case D0:
                {
                alt7=20;
                }
                break;
            case NEGATE:
                {
                alt7=21;
                }
                break;
            case DNEGATE:
                {
                alt7=22;
                }
                break;
            case DigitOnePlusSign:
                {
                alt7=23;
                }
                break;
            case DigitOneHyphenMinus:
                {
                alt7=24;
                }
                break;
            case TRUE:
                {
                alt7=25;
                }
                break;
            case FALSE:
                {
                alt7=26;
                }
                break;
            case CELL:
                {
                alt7=27;
                }
                break;
            case CELL_1:
                {
                alt7=28;
                }
                break;
            case CARRY_RESET:
                {
                alt7=29;
                }
                break;
            case CARRYSET:
                {
                alt7=30;
                }
                break;
            case ABS:
                {
                alt7=31;
                }
                break;
            case DABS:
                {
                alt7=32;
                }
                break;
            case EXTEND:
                {
                alt7=33;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:969:1: ( PlusSign )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:969:1: ( PlusSign )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:970:1: PlusSign
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNamePlusSignKeyword_0_0()); 
                    match(input,PlusSign,FOLLOW_PlusSign_in_rule__IntrinsicArithmeticWords__NameAlternatives_01985); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNamePlusSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:977:6: ( HyphenMinus )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:977:6: ( HyphenMinus )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:978:1: HyphenMinus
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameHyphenMinusKeyword_0_1()); 
                    match(input,HyphenMinus,FOLLOW_HyphenMinus_in_rule__IntrinsicArithmeticWords__NameAlternatives_02005); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameHyphenMinusKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:985:6: ( Asterisk )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:985:6: ( Asterisk )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:986:1: Asterisk
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameAsteriskKeyword_0_2()); 
                    match(input,Asterisk,FOLLOW_Asterisk_in_rule__IntrinsicArithmeticWords__NameAlternatives_02025); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameAsteriskKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:993:6: ( Solidus )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:993:6: ( Solidus )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:994:1: Solidus
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameSolidusKeyword_0_3()); 
                    match(input,Solidus,FOLLOW_Solidus_in_rule__IntrinsicArithmeticWords__NameAlternatives_02045); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameSolidusKeyword_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1001:6: ( DigitTwoAsterisk )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1001:6: ( DigitTwoAsterisk )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1002:1: DigitTwoAsterisk
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getName2Keyword_0_4()); 
                    match(input,DigitTwoAsterisk,FOLLOW_DigitTwoAsterisk_in_rule__IntrinsicArithmeticWords__NameAlternatives_02065); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getName2Keyword_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1009:6: ( DigitTwoSolidus )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1009:6: ( DigitTwoSolidus )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1010:1: DigitTwoSolidus
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getName2Keyword_0_5()); 
                    match(input,DigitTwoSolidus,FOLLOW_DigitTwoSolidus_in_rule__IntrinsicArithmeticWords__NameAlternatives_02085); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getName2Keyword_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1017:6: ( U2 )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1017:6: ( U2 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1018:1: U2
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameU2Keyword_0_6()); 
                    match(input,U2,FOLLOW_U2_in_rule__IntrinsicArithmeticWords__NameAlternatives_02105); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameU2Keyword_0_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1025:6: ( ROR )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1025:6: ( ROR )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1026:1: ROR
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameRORKeyword_0_7()); 
                    match(input,ROR,FOLLOW_ROR_in_rule__IntrinsicArithmeticWords__NameAlternatives_02125); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameRORKeyword_0_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1033:6: ( DROR )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1033:6: ( DROR )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1034:1: DROR
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameDRORKeyword_0_8()); 
                    match(input,DROR,FOLLOW_DROR_in_rule__IntrinsicArithmeticWords__NameAlternatives_02145); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameDRORKeyword_0_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1041:6: ( ROL )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1041:6: ( ROL )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1042:1: ROL
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameROLKeyword_0_9()); 
                    match(input,ROL,FOLLOW_ROL_in_rule__IntrinsicArithmeticWords__NameAlternatives_02165); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameROLKeyword_0_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1049:6: ( DROL )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1049:6: ( DROL )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1050:1: DROL
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameDROLKeyword_0_10()); 
                    match(input,DROL,FOLLOW_DROL_in_rule__IntrinsicArithmeticWords__NameAlternatives_02185); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameDROLKeyword_0_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1057:6: ( PACK )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1057:6: ( PACK )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1058:1: PACK
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNamePACKKeyword_0_11()); 
                    match(input,PACK,FOLLOW_PACK_in_rule__IntrinsicArithmeticWords__NameAlternatives_02205); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNamePACKKeyword_0_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1065:6: ( UNPACK )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1065:6: ( UNPACK )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1066:1: UNPACK
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameUNPACKKeyword_0_12()); 
                    match(input,UNPACK,FOLLOW_UNPACK_in_rule__IntrinsicArithmeticWords__NameAlternatives_02225); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameUNPACKKeyword_0_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1073:6: ( SHIFT )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1073:6: ( SHIFT )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1074:1: SHIFT
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameSHIFTKeyword_0_13()); 
                    match(input,SHIFT,FOLLOW_SHIFT_in_rule__IntrinsicArithmeticWords__NameAlternatives_02245); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameSHIFTKeyword_0_13()); 

                    }


                    }
                    break;
                case 15 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1081:6: ( ASHIFT )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1081:6: ( ASHIFT )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1082:1: ASHIFT
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameASHIFTKeyword_0_14()); 
                    match(input,ASHIFT,FOLLOW_ASHIFT_in_rule__IntrinsicArithmeticWords__NameAlternatives_02265); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameASHIFTKeyword_0_14()); 

                    }


                    }
                    break;
                case 16 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1089:6: ( DigitTwoAsteriskAsterisk )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1089:6: ( DigitTwoAsteriskAsterisk )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1090:1: DigitTwoAsteriskAsterisk
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getName2Keyword_0_15()); 
                    match(input,DigitTwoAsteriskAsterisk,FOLLOW_DigitTwoAsteriskAsterisk_in_rule__IntrinsicArithmeticWords__NameAlternatives_02285); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getName2Keyword_0_15()); 

                    }


                    }
                    break;
                case 17 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1097:6: ( DigitZeroEqualsSign )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1097:6: ( DigitZeroEqualsSign )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1098:1: DigitZeroEqualsSign
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getName0Keyword_0_16()); 
                    match(input,DigitZeroEqualsSign,FOLLOW_DigitZeroEqualsSign_in_rule__IntrinsicArithmeticWords__NameAlternatives_02305); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getName0Keyword_0_16()); 

                    }


                    }
                    break;
                case 18 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1105:6: ( DigitZeroLessThanSignGreaterThanSign )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1105:6: ( DigitZeroLessThanSignGreaterThanSign )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1106:1: DigitZeroLessThanSignGreaterThanSign
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getName0Keyword_0_17()); 
                    match(input,DigitZeroLessThanSignGreaterThanSign,FOLLOW_DigitZeroLessThanSignGreaterThanSign_in_rule__IntrinsicArithmeticWords__NameAlternatives_02325); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getName0Keyword_0_17()); 

                    }


                    }
                    break;
                case 19 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1113:6: ( DigitZeroLessThanSign )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1113:6: ( DigitZeroLessThanSign )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1114:1: DigitZeroLessThanSign
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getName0Keyword_0_18()); 
                    match(input,DigitZeroLessThanSign,FOLLOW_DigitZeroLessThanSign_in_rule__IntrinsicArithmeticWords__NameAlternatives_02345); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getName0Keyword_0_18()); 

                    }


                    }
                    break;
                case 20 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1121:6: ( D0 )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1121:6: ( D0 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1122:1: D0
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameD0Keyword_0_19()); 
                    match(input,D0,FOLLOW_D0_in_rule__IntrinsicArithmeticWords__NameAlternatives_02365); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameD0Keyword_0_19()); 

                    }


                    }
                    break;
                case 21 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1129:6: ( NEGATE )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1129:6: ( NEGATE )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1130:1: NEGATE
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameNEGATEKeyword_0_20()); 
                    match(input,NEGATE,FOLLOW_NEGATE_in_rule__IntrinsicArithmeticWords__NameAlternatives_02385); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameNEGATEKeyword_0_20()); 

                    }


                    }
                    break;
                case 22 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1137:6: ( DNEGATE )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1137:6: ( DNEGATE )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1138:1: DNEGATE
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameDNEGATEKeyword_0_21()); 
                    match(input,DNEGATE,FOLLOW_DNEGATE_in_rule__IntrinsicArithmeticWords__NameAlternatives_02405); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameDNEGATEKeyword_0_21()); 

                    }


                    }
                    break;
                case 23 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1145:6: ( DigitOnePlusSign )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1145:6: ( DigitOnePlusSign )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1146:1: DigitOnePlusSign
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getName1Keyword_0_22()); 
                    match(input,DigitOnePlusSign,FOLLOW_DigitOnePlusSign_in_rule__IntrinsicArithmeticWords__NameAlternatives_02425); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getName1Keyword_0_22()); 

                    }


                    }
                    break;
                case 24 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1153:6: ( DigitOneHyphenMinus )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1153:6: ( DigitOneHyphenMinus )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1154:1: DigitOneHyphenMinus
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getName1Keyword_0_23()); 
                    match(input,DigitOneHyphenMinus,FOLLOW_DigitOneHyphenMinus_in_rule__IntrinsicArithmeticWords__NameAlternatives_02445); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getName1Keyword_0_23()); 

                    }


                    }
                    break;
                case 25 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1161:6: ( TRUE )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1161:6: ( TRUE )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1162:1: TRUE
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameTRUEKeyword_0_24()); 
                    match(input,TRUE,FOLLOW_TRUE_in_rule__IntrinsicArithmeticWords__NameAlternatives_02465); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameTRUEKeyword_0_24()); 

                    }


                    }
                    break;
                case 26 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1169:6: ( FALSE )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1169:6: ( FALSE )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1170:1: FALSE
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameFALSEKeyword_0_25()); 
                    match(input,FALSE,FOLLOW_FALSE_in_rule__IntrinsicArithmeticWords__NameAlternatives_02485); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameFALSEKeyword_0_25()); 

                    }


                    }
                    break;
                case 27 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1177:6: ( CELL )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1177:6: ( CELL )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1178:1: CELL
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameCELLKeyword_0_26()); 
                    match(input,CELL,FOLLOW_CELL_in_rule__IntrinsicArithmeticWords__NameAlternatives_02505); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameCELLKeyword_0_26()); 

                    }


                    }
                    break;
                case 28 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1185:6: ( CELL_1 )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1185:6: ( CELL_1 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1186:1: CELL_1
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameCELLKeyword_0_27()); 
                    match(input,CELL_1,FOLLOW_CELL_1_in_rule__IntrinsicArithmeticWords__NameAlternatives_02525); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameCELLKeyword_0_27()); 

                    }


                    }
                    break;
                case 29 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1193:6: ( CARRY_RESET )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1193:6: ( CARRY_RESET )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1194:1: CARRY_RESET
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameCARRY_RESETKeyword_0_28()); 
                    match(input,CARRY_RESET,FOLLOW_CARRY_RESET_in_rule__IntrinsicArithmeticWords__NameAlternatives_02545); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameCARRY_RESETKeyword_0_28()); 

                    }


                    }
                    break;
                case 30 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1201:6: ( CARRYSET )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1201:6: ( CARRYSET )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1202:1: CARRYSET
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameCARRYSETKeyword_0_29()); 
                    match(input,CARRYSET,FOLLOW_CARRYSET_in_rule__IntrinsicArithmeticWords__NameAlternatives_02565); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameCARRYSETKeyword_0_29()); 

                    }


                    }
                    break;
                case 31 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1209:6: ( ABS )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1209:6: ( ABS )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1210:1: ABS
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameABSKeyword_0_30()); 
                    match(input,ABS,FOLLOW_ABS_in_rule__IntrinsicArithmeticWords__NameAlternatives_02585); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameABSKeyword_0_30()); 

                    }


                    }
                    break;
                case 32 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1217:6: ( DABS )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1217:6: ( DABS )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1218:1: DABS
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameDABSKeyword_0_31()); 
                    match(input,DABS,FOLLOW_DABS_in_rule__IntrinsicArithmeticWords__NameAlternatives_02605); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameDABSKeyword_0_31()); 

                    }


                    }
                    break;
                case 33 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1225:6: ( EXTEND )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1225:6: ( EXTEND )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1226:1: EXTEND
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameEXTENDKeyword_0_32()); 
                    match(input,EXTEND,FOLLOW_EXTEND_in_rule__IntrinsicArithmeticWords__NameAlternatives_02625); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameEXTENDKeyword_0_32()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntrinsicArithmeticWords__NameAlternatives_0"


    // $ANTLR start "rule__Word__Alternatives"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1238:1: rule__Word__Alternatives : ( ( ruleIntrinsicBranchWords ) | ( ruleIntrinsicStackWords ) | ( ruleIntrinsicMemoryWords ) | ( ruleIntrinsicArithmeticWords ) | ( ( rule__Word__NameAssignment_4 ) ) | ( ( rule__Word__NameAssignment_5 ) ) );
    public final void rule__Word__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1242:1: ( ( ruleIntrinsicBranchWords ) | ( ruleIntrinsicStackWords ) | ( ruleIntrinsicMemoryWords ) | ( ruleIntrinsicArithmeticWords ) | ( ( rule__Word__NameAssignment_4 ) ) | ( ( rule__Word__NameAssignment_5 ) ) )
            int alt8=6;
            switch ( input.LA(1) ) {
            case TorBranch:
            case Branch_2:
            case NcBranch:
            case NoBranch:
            case NsBranch:
            case Branch:
            case Branch_1:
            case SBranch:
            case NzExit:
            case ZExit:
            case Jsr:
                {
                alt8=1;
                }
                break;
            case RCLEAR:
            case DROP_1:
            case OVER_1:
            case SWAP_1:
            case CLEAR:
            case RDROP:
            case UNDER:
            case ROT_1:
            case DUP_1:
            case DUP_2:
            case DROP:
            case OVER:
            case SWAP:
            case TUCK:
            case DUP:
            case NIP:
            case ROT:
            case R:
            case R_1:
            case R_2:
                {
                alt8=2;
                }
                break;
            case COUNT:
            case ERASE:
            case PLACE:
            case FILL:
            case MOVE:
            case ST_1:
            case DEC:
            case INC:
            case LLD:
            case LST:
            case OFF:
            case TLD:
            case TST:
            case PlusSignExclamationMark:
            case DigitTwoExclamationMark:
            case DigitTwoCommercialAt:
            case L:
            case L_1:
            case LD:
            case ON:
            case ST:
            case T:
            case T_1:
            case ExclamationMark:
            case CommercialAt:
                {
                alt8=3;
                }
                break;
            case CARRY_RESET:
            case CARRYSET:
            case DNEGATE:
            case ASHIFT:
            case EXTEND:
            case NEGATE:
            case UNPACK:
            case CELL:
            case CELL_1:
            case FALSE:
            case SHIFT:
            case DABS:
            case DROL:
            case DROR:
            case PACK:
            case TRUE:
            case DigitZeroLessThanSignGreaterThanSign:
            case DigitTwoAsteriskAsterisk:
            case ABS:
            case ROL:
            case ROR:
            case D0:
            case U2:
            case DigitZeroLessThanSign:
            case DigitZeroEqualsSign:
            case DigitOnePlusSign:
            case DigitOneHyphenMinus:
            case DigitTwoAsterisk:
            case DigitTwoSolidus:
            case Asterisk:
            case PlusSign:
            case HyphenMinus:
            case Solidus:
                {
                alt8=4;
                }
                break;
            case RULE_INT:
            case RULE_DOUBLE:
                {
                alt8=5;
                }
                break;
            case RULE_ID:
                {
                alt8=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1243:1: ( ruleIntrinsicBranchWords )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1243:1: ( ruleIntrinsicBranchWords )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1244:1: ruleIntrinsicBranchWords
                    {
                     before(grammarAccess.getWordAccess().getIntrinsicBranchWordsParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleIntrinsicBranchWords_in_rule__Word__Alternatives2659);
                    ruleIntrinsicBranchWords();

                    state._fsp--;

                     after(grammarAccess.getWordAccess().getIntrinsicBranchWordsParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1249:6: ( ruleIntrinsicStackWords )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1249:6: ( ruleIntrinsicStackWords )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1250:1: ruleIntrinsicStackWords
                    {
                     before(grammarAccess.getWordAccess().getIntrinsicStackWordsParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleIntrinsicStackWords_in_rule__Word__Alternatives2676);
                    ruleIntrinsicStackWords();

                    state._fsp--;

                     after(grammarAccess.getWordAccess().getIntrinsicStackWordsParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1255:6: ( ruleIntrinsicMemoryWords )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1255:6: ( ruleIntrinsicMemoryWords )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1256:1: ruleIntrinsicMemoryWords
                    {
                     before(grammarAccess.getWordAccess().getIntrinsicMemoryWordsParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleIntrinsicMemoryWords_in_rule__Word__Alternatives2693);
                    ruleIntrinsicMemoryWords();

                    state._fsp--;

                     after(grammarAccess.getWordAccess().getIntrinsicMemoryWordsParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1261:6: ( ruleIntrinsicArithmeticWords )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1261:6: ( ruleIntrinsicArithmeticWords )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1262:1: ruleIntrinsicArithmeticWords
                    {
                     before(grammarAccess.getWordAccess().getIntrinsicArithmeticWordsParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleIntrinsicArithmeticWords_in_rule__Word__Alternatives2710);
                    ruleIntrinsicArithmeticWords();

                    state._fsp--;

                     after(grammarAccess.getWordAccess().getIntrinsicArithmeticWordsParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1267:6: ( ( rule__Word__NameAssignment_4 ) )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1267:6: ( ( rule__Word__NameAssignment_4 ) )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1268:1: ( rule__Word__NameAssignment_4 )
                    {
                     before(grammarAccess.getWordAccess().getNameAssignment_4()); 
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1269:1: ( rule__Word__NameAssignment_4 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1269:2: rule__Word__NameAssignment_4
                    {
                    pushFollow(FOLLOW_rule__Word__NameAssignment_4_in_rule__Word__Alternatives2727);
                    rule__Word__NameAssignment_4();

                    state._fsp--;


                    }

                     after(grammarAccess.getWordAccess().getNameAssignment_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1273:6: ( ( rule__Word__NameAssignment_5 ) )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1273:6: ( ( rule__Word__NameAssignment_5 ) )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1274:1: ( rule__Word__NameAssignment_5 )
                    {
                     before(grammarAccess.getWordAccess().getNameAssignment_5()); 
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1275:1: ( rule__Word__NameAssignment_5 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1275:2: rule__Word__NameAssignment_5
                    {
                    pushFollow(FOLLOW_rule__Word__NameAssignment_5_in_rule__Word__Alternatives2745);
                    rule__Word__NameAssignment_5();

                    state._fsp--;


                    }

                     after(grammarAccess.getWordAccess().getNameAssignment_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Word__Alternatives"


    // $ANTLR start "rule__Function__Group__0"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1286:1: rule__Function__Group__0 : rule__Function__Group__0__Impl rule__Function__Group__1 ;
    public final void rule__Function__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1290:1: ( rule__Function__Group__0__Impl rule__Function__Group__1 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1291:2: rule__Function__Group__0__Impl rule__Function__Group__1
            {
            pushFollow(FOLLOW_rule__Function__Group__0__Impl_in_rule__Function__Group__02776);
            rule__Function__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Function__Group__1_in_rule__Function__Group__02779);
            rule__Function__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__Group__0"


    // $ANTLR start "rule__Function__Group__0__Impl"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1298:1: rule__Function__Group__0__Impl : ( Colon ) ;
    public final void rule__Function__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1302:1: ( ( Colon ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1303:1: ( Colon )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1303:1: ( Colon )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1304:1: Colon
            {
             before(grammarAccess.getFunctionAccess().getColonKeyword_0()); 
            match(input,Colon,FOLLOW_Colon_in_rule__Function__Group__0__Impl2807); 
             after(grammarAccess.getFunctionAccess().getColonKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__Group__0__Impl"


    // $ANTLR start "rule__Function__Group__1"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1317:1: rule__Function__Group__1 : rule__Function__Group__1__Impl rule__Function__Group__2 ;
    public final void rule__Function__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1321:1: ( rule__Function__Group__1__Impl rule__Function__Group__2 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1322:2: rule__Function__Group__1__Impl rule__Function__Group__2
            {
            pushFollow(FOLLOW_rule__Function__Group__1__Impl_in_rule__Function__Group__12838);
            rule__Function__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Function__Group__2_in_rule__Function__Group__12841);
            rule__Function__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__Group__1"


    // $ANTLR start "rule__Function__Group__1__Impl"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1329:1: rule__Function__Group__1__Impl : ( ruleWord ) ;
    public final void rule__Function__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1333:1: ( ( ruleWord ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1334:1: ( ruleWord )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1334:1: ( ruleWord )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1335:1: ruleWord
            {
             before(grammarAccess.getFunctionAccess().getWordParserRuleCall_1()); 
            pushFollow(FOLLOW_ruleWord_in_rule__Function__Group__1__Impl2868);
            ruleWord();

            state._fsp--;

             after(grammarAccess.getFunctionAccess().getWordParserRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__Group__1__Impl"


    // $ANTLR start "rule__Function__Group__2"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1346:1: rule__Function__Group__2 : rule__Function__Group__2__Impl rule__Function__Group__3 ;
    public final void rule__Function__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1350:1: ( rule__Function__Group__2__Impl rule__Function__Group__3 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1351:2: rule__Function__Group__2__Impl rule__Function__Group__3
            {
            pushFollow(FOLLOW_rule__Function__Group__2__Impl_in_rule__Function__Group__22897);
            rule__Function__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Function__Group__3_in_rule__Function__Group__22900);
            rule__Function__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__Group__2"


    // $ANTLR start "rule__Function__Group__2__Impl"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1358:1: rule__Function__Group__2__Impl : ( ( rule__Function__WordsAssignment_2 )* ) ;
    public final void rule__Function__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1362:1: ( ( ( rule__Function__WordsAssignment_2 )* ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1363:1: ( ( rule__Function__WordsAssignment_2 )* )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1363:1: ( ( rule__Function__WordsAssignment_2 )* )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1364:1: ( rule__Function__WordsAssignment_2 )*
            {
             before(grammarAccess.getFunctionAccess().getWordsAssignment_2()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1365:1: ( rule__Function__WordsAssignment_2 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=CARRY_RESET && LA9_0<=UNPACK)||(LA9_0>=ZExit && LA9_0<=PlusSign)||(LA9_0>=HyphenMinus && LA9_0<=Solidus)||LA9_0==CommercialAt||(LA9_0>=RULE_INT && LA9_0<=RULE_ID)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1365:2: rule__Function__WordsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Function__WordsAssignment_2_in_rule__Function__Group__2__Impl2927);
            	    rule__Function__WordsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getFunctionAccess().getWordsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__Group__2__Impl"


    // $ANTLR start "rule__Function__Group__3"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1375:1: rule__Function__Group__3 : rule__Function__Group__3__Impl ;
    public final void rule__Function__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1379:1: ( rule__Function__Group__3__Impl )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1380:2: rule__Function__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Function__Group__3__Impl_in_rule__Function__Group__32958);
            rule__Function__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__Group__3"


    // $ANTLR start "rule__Function__Group__3__Impl"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1386:1: rule__Function__Group__3__Impl : ( Semicolon ) ;
    public final void rule__Function__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1390:1: ( ( Semicolon ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1391:1: ( Semicolon )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1391:1: ( Semicolon )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1392:1: Semicolon
            {
             before(grammarAccess.getFunctionAccess().getSemicolonKeyword_3()); 
            match(input,Semicolon,FOLLOW_Semicolon_in_rule__Function__Group__3__Impl2986); 
             after(grammarAccess.getFunctionAccess().getSemicolonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__Group__3__Impl"


    // $ANTLR start "rule__Create__Group__0"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1413:1: rule__Create__Group__0 : rule__Create__Group__0__Impl rule__Create__Group__1 ;
    public final void rule__Create__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1417:1: ( rule__Create__Group__0__Impl rule__Create__Group__1 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1418:2: rule__Create__Group__0__Impl rule__Create__Group__1
            {
            pushFollow(FOLLOW_rule__Create__Group__0__Impl_in_rule__Create__Group__03025);
            rule__Create__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Create__Group__1_in_rule__Create__Group__03028);
            rule__Create__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Create__Group__0"


    // $ANTLR start "rule__Create__Group__0__Impl"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1425:1: rule__Create__Group__0__Impl : ( Create ) ;
    public final void rule__Create__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1429:1: ( ( Create ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1430:1: ( Create )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1430:1: ( Create )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1431:1: Create
            {
             before(grammarAccess.getCreateAccess().getCreateKeyword_0()); 
            match(input,Create,FOLLOW_Create_in_rule__Create__Group__0__Impl3056); 
             after(grammarAccess.getCreateAccess().getCreateKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Create__Group__0__Impl"


    // $ANTLR start "rule__Create__Group__1"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1444:1: rule__Create__Group__1 : rule__Create__Group__1__Impl rule__Create__Group__2 ;
    public final void rule__Create__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1448:1: ( rule__Create__Group__1__Impl rule__Create__Group__2 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1449:2: rule__Create__Group__1__Impl rule__Create__Group__2
            {
            pushFollow(FOLLOW_rule__Create__Group__1__Impl_in_rule__Create__Group__13087);
            rule__Create__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Create__Group__2_in_rule__Create__Group__13090);
            rule__Create__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Create__Group__1"


    // $ANTLR start "rule__Create__Group__1__Impl"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1456:1: rule__Create__Group__1__Impl : ( ( rule__Create__NameAssignment_1 ) ) ;
    public final void rule__Create__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1460:1: ( ( ( rule__Create__NameAssignment_1 ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1461:1: ( ( rule__Create__NameAssignment_1 ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1461:1: ( ( rule__Create__NameAssignment_1 ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1462:1: ( rule__Create__NameAssignment_1 )
            {
             before(grammarAccess.getCreateAccess().getNameAssignment_1()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1463:1: ( rule__Create__NameAssignment_1 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1463:2: rule__Create__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Create__NameAssignment_1_in_rule__Create__Group__1__Impl3117);
            rule__Create__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getCreateAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Create__Group__1__Impl"


    // $ANTLR start "rule__Create__Group__2"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1473:1: rule__Create__Group__2 : rule__Create__Group__2__Impl ;
    public final void rule__Create__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1477:1: ( rule__Create__Group__2__Impl )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1478:2: rule__Create__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Create__Group__2__Impl_in_rule__Create__Group__23147);
            rule__Create__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Create__Group__2"


    // $ANTLR start "rule__Create__Group__2__Impl"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1484:1: rule__Create__Group__2__Impl : ( ( rule__Create__Group_2__0 )* ) ;
    public final void rule__Create__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1488:1: ( ( ( rule__Create__Group_2__0 )* ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1489:1: ( ( rule__Create__Group_2__0 )* )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1489:1: ( ( rule__Create__Group_2__0 )* )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1490:1: ( rule__Create__Group_2__0 )*
            {
             before(grammarAccess.getCreateAccess().getGroup_2()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1491:1: ( rule__Create__Group_2__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_INT) ) {
                    int LA10_2 = input.LA(2);

                    if ( (LA10_2==Comma) ) {
                        alt10=1;
                    }


                }
                else if ( (LA10_0==RULE_DOUBLE) ) {
                    int LA10_3 = input.LA(2);

                    if ( (LA10_3==Comma) ) {
                        alt10=1;
                    }


                }


                switch (alt10) {
            	case 1 :
            	    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1491:2: rule__Create__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Create__Group_2__0_in_rule__Create__Group__2__Impl3174);
            	    rule__Create__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getCreateAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Create__Group__2__Impl"


    // $ANTLR start "rule__Create__Group_2__0"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1507:1: rule__Create__Group_2__0 : rule__Create__Group_2__0__Impl rule__Create__Group_2__1 ;
    public final void rule__Create__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1511:1: ( rule__Create__Group_2__0__Impl rule__Create__Group_2__1 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1512:2: rule__Create__Group_2__0__Impl rule__Create__Group_2__1
            {
            pushFollow(FOLLOW_rule__Create__Group_2__0__Impl_in_rule__Create__Group_2__03211);
            rule__Create__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Create__Group_2__1_in_rule__Create__Group_2__03214);
            rule__Create__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Create__Group_2__0"


    // $ANTLR start "rule__Create__Group_2__0__Impl"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1519:1: rule__Create__Group_2__0__Impl : ( ( rule__Create__LitAssignment_2_0 ) ) ;
    public final void rule__Create__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1523:1: ( ( ( rule__Create__LitAssignment_2_0 ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1524:1: ( ( rule__Create__LitAssignment_2_0 ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1524:1: ( ( rule__Create__LitAssignment_2_0 ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1525:1: ( rule__Create__LitAssignment_2_0 )
            {
             before(grammarAccess.getCreateAccess().getLitAssignment_2_0()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1526:1: ( rule__Create__LitAssignment_2_0 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1526:2: rule__Create__LitAssignment_2_0
            {
            pushFollow(FOLLOW_rule__Create__LitAssignment_2_0_in_rule__Create__Group_2__0__Impl3241);
            rule__Create__LitAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getCreateAccess().getLitAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Create__Group_2__0__Impl"


    // $ANTLR start "rule__Create__Group_2__1"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1536:1: rule__Create__Group_2__1 : rule__Create__Group_2__1__Impl ;
    public final void rule__Create__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1540:1: ( rule__Create__Group_2__1__Impl )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1541:2: rule__Create__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Create__Group_2__1__Impl_in_rule__Create__Group_2__13271);
            rule__Create__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Create__Group_2__1"


    // $ANTLR start "rule__Create__Group_2__1__Impl"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1547:1: rule__Create__Group_2__1__Impl : ( Comma ) ;
    public final void rule__Create__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1551:1: ( ( Comma ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1552:1: ( Comma )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1552:1: ( Comma )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1553:1: Comma
            {
             before(grammarAccess.getCreateAccess().getCommaKeyword_2_1()); 
            match(input,Comma,FOLLOW_Comma_in_rule__Create__Group_2__1__Impl3299); 
             after(grammarAccess.getCreateAccess().getCommaKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Create__Group_2__1__Impl"


    // $ANTLR start "rule__Forth__InstructionsAssignment"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1571:1: rule__Forth__InstructionsAssignment : ( ruleInstruction ) ;
    public final void rule__Forth__InstructionsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1575:1: ( ( ruleInstruction ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1576:1: ( ruleInstruction )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1576:1: ( ruleInstruction )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1577:1: ruleInstruction
            {
             before(grammarAccess.getForthAccess().getInstructionsInstructionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleInstruction_in_rule__Forth__InstructionsAssignment3339);
            ruleInstruction();

            state._fsp--;

             after(grammarAccess.getForthAccess().getInstructionsInstructionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Forth__InstructionsAssignment"


    // $ANTLR start "rule__Function__WordsAssignment_2"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1586:1: rule__Function__WordsAssignment_2 : ( ruleWord ) ;
    public final void rule__Function__WordsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1590:1: ( ( ruleWord ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1591:1: ( ruleWord )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1591:1: ( ruleWord )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1592:1: ruleWord
            {
             before(grammarAccess.getFunctionAccess().getWordsWordParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleWord_in_rule__Function__WordsAssignment_23370);
            ruleWord();

            state._fsp--;

             after(grammarAccess.getFunctionAccess().getWordsWordParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__WordsAssignment_2"


    // $ANTLR start "rule__Create__NameAssignment_1"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1601:1: rule__Create__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Create__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1605:1: ( ( RULE_ID ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1606:1: ( RULE_ID )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1606:1: ( RULE_ID )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1607:1: RULE_ID
            {
             before(grammarAccess.getCreateAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Create__NameAssignment_13401); 
             after(grammarAccess.getCreateAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Create__NameAssignment_1"


    // $ANTLR start "rule__Create__LitAssignment_2_0"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1616:1: rule__Create__LitAssignment_2_0 : ( ruleLITERAL ) ;
    public final void rule__Create__LitAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1620:1: ( ( ruleLITERAL ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1621:1: ( ruleLITERAL )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1621:1: ( ruleLITERAL )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1622:1: ruleLITERAL
            {
             before(grammarAccess.getCreateAccess().getLitLITERALParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_ruleLITERAL_in_rule__Create__LitAssignment_2_03432);
            ruleLITERAL();

            state._fsp--;

             after(grammarAccess.getCreateAccess().getLitLITERALParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Create__LitAssignment_2_0"


    // $ANTLR start "rule__IntrinsicBranchWords__NameAssignment"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1631:1: rule__IntrinsicBranchWords__NameAssignment : ( ( rule__IntrinsicBranchWords__NameAlternatives_0 ) ) ;
    public final void rule__IntrinsicBranchWords__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1635:1: ( ( ( rule__IntrinsicBranchWords__NameAlternatives_0 ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1636:1: ( ( rule__IntrinsicBranchWords__NameAlternatives_0 ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1636:1: ( ( rule__IntrinsicBranchWords__NameAlternatives_0 ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1637:1: ( rule__IntrinsicBranchWords__NameAlternatives_0 )
            {
             before(grammarAccess.getIntrinsicBranchWordsAccess().getNameAlternatives_0()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1638:1: ( rule__IntrinsicBranchWords__NameAlternatives_0 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1638:2: rule__IntrinsicBranchWords__NameAlternatives_0
            {
            pushFollow(FOLLOW_rule__IntrinsicBranchWords__NameAlternatives_0_in_rule__IntrinsicBranchWords__NameAssignment3463);
            rule__IntrinsicBranchWords__NameAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getIntrinsicBranchWordsAccess().getNameAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntrinsicBranchWords__NameAssignment"


    // $ANTLR start "rule__IntrinsicStackWords__NameAssignment"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1647:1: rule__IntrinsicStackWords__NameAssignment : ( ( rule__IntrinsicStackWords__NameAlternatives_0 ) ) ;
    public final void rule__IntrinsicStackWords__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1651:1: ( ( ( rule__IntrinsicStackWords__NameAlternatives_0 ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1652:1: ( ( rule__IntrinsicStackWords__NameAlternatives_0 ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1652:1: ( ( rule__IntrinsicStackWords__NameAlternatives_0 ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1653:1: ( rule__IntrinsicStackWords__NameAlternatives_0 )
            {
             before(grammarAccess.getIntrinsicStackWordsAccess().getNameAlternatives_0()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1654:1: ( rule__IntrinsicStackWords__NameAlternatives_0 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1654:2: rule__IntrinsicStackWords__NameAlternatives_0
            {
            pushFollow(FOLLOW_rule__IntrinsicStackWords__NameAlternatives_0_in_rule__IntrinsicStackWords__NameAssignment3496);
            rule__IntrinsicStackWords__NameAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getIntrinsicStackWordsAccess().getNameAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntrinsicStackWords__NameAssignment"


    // $ANTLR start "rule__IntrinsicMemoryWords__NameAssignment"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1663:1: rule__IntrinsicMemoryWords__NameAssignment : ( ( rule__IntrinsicMemoryWords__NameAlternatives_0 ) ) ;
    public final void rule__IntrinsicMemoryWords__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1667:1: ( ( ( rule__IntrinsicMemoryWords__NameAlternatives_0 ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1668:1: ( ( rule__IntrinsicMemoryWords__NameAlternatives_0 ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1668:1: ( ( rule__IntrinsicMemoryWords__NameAlternatives_0 ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1669:1: ( rule__IntrinsicMemoryWords__NameAlternatives_0 )
            {
             before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameAlternatives_0()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1670:1: ( rule__IntrinsicMemoryWords__NameAlternatives_0 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1670:2: rule__IntrinsicMemoryWords__NameAlternatives_0
            {
            pushFollow(FOLLOW_rule__IntrinsicMemoryWords__NameAlternatives_0_in_rule__IntrinsicMemoryWords__NameAssignment3529);
            rule__IntrinsicMemoryWords__NameAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntrinsicMemoryWords__NameAssignment"


    // $ANTLR start "rule__IntrinsicArithmeticWords__NameAssignment"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1679:1: rule__IntrinsicArithmeticWords__NameAssignment : ( ( rule__IntrinsicArithmeticWords__NameAlternatives_0 ) ) ;
    public final void rule__IntrinsicArithmeticWords__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1683:1: ( ( ( rule__IntrinsicArithmeticWords__NameAlternatives_0 ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1684:1: ( ( rule__IntrinsicArithmeticWords__NameAlternatives_0 ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1684:1: ( ( rule__IntrinsicArithmeticWords__NameAlternatives_0 ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1685:1: ( rule__IntrinsicArithmeticWords__NameAlternatives_0 )
            {
             before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameAlternatives_0()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1686:1: ( rule__IntrinsicArithmeticWords__NameAlternatives_0 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1686:2: rule__IntrinsicArithmeticWords__NameAlternatives_0
            {
            pushFollow(FOLLOW_rule__IntrinsicArithmeticWords__NameAlternatives_0_in_rule__IntrinsicArithmeticWords__NameAssignment3562);
            rule__IntrinsicArithmeticWords__NameAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntrinsicArithmeticWords__NameAssignment"


    // $ANTLR start "rule__Word__NameAssignment_4"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1695:1: rule__Word__NameAssignment_4 : ( ruleLITERAL ) ;
    public final void rule__Word__NameAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1699:1: ( ( ruleLITERAL ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1700:1: ( ruleLITERAL )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1700:1: ( ruleLITERAL )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1701:1: ruleLITERAL
            {
             before(grammarAccess.getWordAccess().getNameLITERALParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleLITERAL_in_rule__Word__NameAssignment_43595);
            ruleLITERAL();

            state._fsp--;

             after(grammarAccess.getWordAccess().getNameLITERALParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Word__NameAssignment_4"


    // $ANTLR start "rule__Word__NameAssignment_5"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1710:1: rule__Word__NameAssignment_5 : ( RULE_ID ) ;
    public final void rule__Word__NameAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1714:1: ( ( RULE_ID ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1715:1: ( RULE_ID )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1715:1: ( RULE_ID )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1716:1: RULE_ID
            {
             before(grammarAccess.getWordAccess().getNameIDTerminalRuleCall_5_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Word__NameAssignment_53626); 
             after(grammarAccess.getWordAccess().getNameIDTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Word__NameAssignment_5"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleForth_in_entryRuleForth54 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleForth61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Forth__InstructionsAssignment_in_ruleForth91 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF2L,0x000000E177FFFFFFL});
    public static final BitSet FOLLOW_ruleInstruction_in_entryRuleInstruction119 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstruction126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Alternatives_in_ruleInstruction156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_entryRuleFunction183 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunction190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__0_in_ruleFunction220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreate_in_entryRuleCreate247 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCreate254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Create__Group__0_in_ruleCreate284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLITERAL_in_entryRuleLITERAL311 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLITERAL318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LITERAL__Alternatives_in_ruleLITERAL348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntrinsicBranchWords_in_entryRuleIntrinsicBranchWords375 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntrinsicBranchWords382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntrinsicBranchWords__NameAssignment_in_ruleIntrinsicBranchWords412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntrinsicStackWords_in_entryRuleIntrinsicStackWords439 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntrinsicStackWords446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntrinsicStackWords__NameAssignment_in_ruleIntrinsicStackWords476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntrinsicMemoryWords_in_entryRuleIntrinsicMemoryWords503 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntrinsicMemoryWords510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntrinsicMemoryWords__NameAssignment_in_ruleIntrinsicMemoryWords540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntrinsicArithmeticWords_in_entryRuleIntrinsicArithmeticWords567 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntrinsicArithmeticWords574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntrinsicArithmeticWords__NameAssignment_in_ruleIntrinsicArithmeticWords604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWord_in_entryRuleWord631 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWord638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Word__Alternatives_in_ruleWord668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreate_in_rule__Instruction__Alternatives704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_rule__Instruction__Alternatives721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWord_in_rule__Instruction__Alternatives738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__LITERAL__Alternatives770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOUBLE_in_rule__LITERAL__Alternatives787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Jsr_in_rule__IntrinsicBranchWords__NameAlternatives_0820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Branch_in_rule__IntrinsicBranchWords__NameAlternatives_0840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Branch_2_in_rule__IntrinsicBranchWords__NameAlternatives_0860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Branch_1_in_rule__IntrinsicBranchWords__NameAlternatives_0880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SBranch_in_rule__IntrinsicBranchWords__NameAlternatives_0900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NsBranch_in_rule__IntrinsicBranchWords__NameAlternatives_0920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NcBranch_in_rule__IntrinsicBranchWords__NameAlternatives_0940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NoBranch_in_rule__IntrinsicBranchWords__NameAlternatives_0960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TorBranch_in_rule__IntrinsicBranchWords__NameAlternatives_0980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ZExit_in_rule__IntrinsicBranchWords__NameAlternatives_01000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NzExit_in_rule__IntrinsicBranchWords__NameAlternatives_01020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CLEAR_in_rule__IntrinsicStackWords__NameAlternatives_01055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_rule__IntrinsicStackWords__NameAlternatives_01075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DUP_in_rule__IntrinsicStackWords__NameAlternatives_01095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DUP_2_in_rule__IntrinsicStackWords__NameAlternatives_01115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SWAP_in_rule__IntrinsicStackWords__NameAlternatives_01135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NIP_in_rule__IntrinsicStackWords__NameAlternatives_01155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OVER_in_rule__IntrinsicStackWords__NameAlternatives_01175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROT_in_rule__IntrinsicStackWords__NameAlternatives_01195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROT_1_in_rule__IntrinsicStackWords__NameAlternatives_01215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUCK_in_rule__IntrinsicStackWords__NameAlternatives_01235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNDER_in_rule__IntrinsicStackWords__NameAlternatives_01255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_1_in_rule__IntrinsicStackWords__NameAlternatives_01275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DUP_1_in_rule__IntrinsicStackWords__NameAlternatives_01295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SWAP_1_in_rule__IntrinsicStackWords__NameAlternatives_01315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OVER_1_in_rule__IntrinsicStackWords__NameAlternatives_01335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RCLEAR_in_rule__IntrinsicStackWords__NameAlternatives_01355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_R_1_in_rule__IntrinsicStackWords__NameAlternatives_01375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_R_2_in_rule__IntrinsicStackWords__NameAlternatives_01395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_R_in_rule__IntrinsicStackWords__NameAlternatives_01415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RDROP_in_rule__IntrinsicStackWords__NameAlternatives_01435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LD_in_rule__IntrinsicMemoryWords__NameAlternatives_01470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CommercialAt_in_rule__IntrinsicMemoryWords__NameAlternatives_01490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ST_in_rule__IntrinsicMemoryWords__NameAlternatives_01510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ExclamationMark_in_rule__IntrinsicMemoryWords__NameAlternatives_01530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitTwoCommercialAt_in_rule__IntrinsicMemoryWords__NameAlternatives_01550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitTwoExclamationMark_in_rule__IntrinsicMemoryWords__NameAlternatives_01570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LLD_in_rule__IntrinsicMemoryWords__NameAlternatives_01590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_L_1_in_rule__IntrinsicMemoryWords__NameAlternatives_01610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LST_in_rule__IntrinsicMemoryWords__NameAlternatives_01630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_L_in_rule__IntrinsicMemoryWords__NameAlternatives_01650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TLD_in_rule__IntrinsicMemoryWords__NameAlternatives_01670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_1_in_rule__IntrinsicMemoryWords__NameAlternatives_01690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TST_in_rule__IntrinsicMemoryWords__NameAlternatives_01710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_in_rule__IntrinsicMemoryWords__NameAlternatives_01730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ST_1_in_rule__IntrinsicMemoryWords__NameAlternatives_01750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PlusSignExclamationMark_in_rule__IntrinsicMemoryWords__NameAlternatives_01770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INC_in_rule__IntrinsicMemoryWords__NameAlternatives_01790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEC_in_rule__IntrinsicMemoryWords__NameAlternatives_01810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ON_in_rule__IntrinsicMemoryWords__NameAlternatives_01830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OFF_in_rule__IntrinsicMemoryWords__NameAlternatives_01850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ERASE_in_rule__IntrinsicMemoryWords__NameAlternatives_01870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILL_in_rule__IntrinsicMemoryWords__NameAlternatives_01890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COUNT_in_rule__IntrinsicMemoryWords__NameAlternatives_01910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MOVE_in_rule__IntrinsicMemoryWords__NameAlternatives_01930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLACE_in_rule__IntrinsicMemoryWords__NameAlternatives_01950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PlusSign_in_rule__IntrinsicArithmeticWords__NameAlternatives_01985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HyphenMinus_in_rule__IntrinsicArithmeticWords__NameAlternatives_02005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Asterisk_in_rule__IntrinsicArithmeticWords__NameAlternatives_02025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Solidus_in_rule__IntrinsicArithmeticWords__NameAlternatives_02045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitTwoAsterisk_in_rule__IntrinsicArithmeticWords__NameAlternatives_02065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitTwoSolidus_in_rule__IntrinsicArithmeticWords__NameAlternatives_02085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_U2_in_rule__IntrinsicArithmeticWords__NameAlternatives_02105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROR_in_rule__IntrinsicArithmeticWords__NameAlternatives_02125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROR_in_rule__IntrinsicArithmeticWords__NameAlternatives_02145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROL_in_rule__IntrinsicArithmeticWords__NameAlternatives_02165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROL_in_rule__IntrinsicArithmeticWords__NameAlternatives_02185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PACK_in_rule__IntrinsicArithmeticWords__NameAlternatives_02205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNPACK_in_rule__IntrinsicArithmeticWords__NameAlternatives_02225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHIFT_in_rule__IntrinsicArithmeticWords__NameAlternatives_02245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASHIFT_in_rule__IntrinsicArithmeticWords__NameAlternatives_02265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitTwoAsteriskAsterisk_in_rule__IntrinsicArithmeticWords__NameAlternatives_02285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitZeroEqualsSign_in_rule__IntrinsicArithmeticWords__NameAlternatives_02305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitZeroLessThanSignGreaterThanSign_in_rule__IntrinsicArithmeticWords__NameAlternatives_02325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitZeroLessThanSign_in_rule__IntrinsicArithmeticWords__NameAlternatives_02345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_D0_in_rule__IntrinsicArithmeticWords__NameAlternatives_02365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEGATE_in_rule__IntrinsicArithmeticWords__NameAlternatives_02385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DNEGATE_in_rule__IntrinsicArithmeticWords__NameAlternatives_02405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitOnePlusSign_in_rule__IntrinsicArithmeticWords__NameAlternatives_02425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitOneHyphenMinus_in_rule__IntrinsicArithmeticWords__NameAlternatives_02445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_rule__IntrinsicArithmeticWords__NameAlternatives_02465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_rule__IntrinsicArithmeticWords__NameAlternatives_02485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CELL_in_rule__IntrinsicArithmeticWords__NameAlternatives_02505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CELL_1_in_rule__IntrinsicArithmeticWords__NameAlternatives_02525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CARRY_RESET_in_rule__IntrinsicArithmeticWords__NameAlternatives_02545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CARRYSET_in_rule__IntrinsicArithmeticWords__NameAlternatives_02565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ABS_in_rule__IntrinsicArithmeticWords__NameAlternatives_02585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DABS_in_rule__IntrinsicArithmeticWords__NameAlternatives_02605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXTEND_in_rule__IntrinsicArithmeticWords__NameAlternatives_02625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntrinsicBranchWords_in_rule__Word__Alternatives2659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntrinsicStackWords_in_rule__Word__Alternatives2676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntrinsicMemoryWords_in_rule__Word__Alternatives2693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntrinsicArithmeticWords_in_rule__Word__Alternatives2710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Word__NameAssignment_4_in_rule__Word__Alternatives2727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Word__NameAssignment_5_in_rule__Word__Alternatives2745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__0__Impl_in_rule__Function__Group__02776 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000E177FFFFFFL});
    public static final BitSet FOLLOW_rule__Function__Group__1_in_rule__Function__Group__02779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Colon_in_rule__Function__Group__0__Impl2807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__1__Impl_in_rule__Function__Group__12838 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000E1F7FFFFFFL});
    public static final BitSet FOLLOW_rule__Function__Group__2_in_rule__Function__Group__12841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWord_in_rule__Function__Group__1__Impl2868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__2__Impl_in_rule__Function__Group__22897 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000E1F7FFFFFFL});
    public static final BitSet FOLLOW_rule__Function__Group__3_in_rule__Function__Group__22900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__WordsAssignment_2_in_rule__Function__Group__2__Impl2927 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF2L,0x000000E177FFFFFFL});
    public static final BitSet FOLLOW_rule__Function__Group__3__Impl_in_rule__Function__Group__32958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Semicolon_in_rule__Function__Group__3__Impl2986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Create__Group__0__Impl_in_rule__Create__Group__03025 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_rule__Create__Group__1_in_rule__Create__Group__03028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Create_in_rule__Create__Group__0__Impl3056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Create__Group__1__Impl_in_rule__Create__Group__13087 = new BitSet(new long[]{0x0000000000000000L,0x0000006000000000L});
    public static final BitSet FOLLOW_rule__Create__Group__2_in_rule__Create__Group__13090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Create__NameAssignment_1_in_rule__Create__Group__1__Impl3117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Create__Group__2__Impl_in_rule__Create__Group__23147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Create__Group_2__0_in_rule__Create__Group__2__Impl3174 = new BitSet(new long[]{0x0000000000000002L,0x0000006000000000L});
    public static final BitSet FOLLOW_rule__Create__Group_2__0__Impl_in_rule__Create__Group_2__03211 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_rule__Create__Group_2__1_in_rule__Create__Group_2__03214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Create__LitAssignment_2_0_in_rule__Create__Group_2__0__Impl3241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Create__Group_2__1__Impl_in_rule__Create__Group_2__13271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Comma_in_rule__Create__Group_2__1__Impl3299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_rule__Forth__InstructionsAssignment3339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWord_in_rule__Function__WordsAssignment_23370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Create__NameAssignment_13401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLITERAL_in_rule__Create__LitAssignment_2_03432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntrinsicBranchWords__NameAlternatives_0_in_rule__IntrinsicBranchWords__NameAssignment3463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntrinsicStackWords__NameAlternatives_0_in_rule__IntrinsicStackWords__NameAssignment3496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntrinsicMemoryWords__NameAlternatives_0_in_rule__IntrinsicMemoryWords__NameAssignment3529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntrinsicArithmeticWords__NameAlternatives_0_in_rule__IntrinsicArithmeticWords__NameAssignment3562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLITERAL_in_rule__Word__NameAssignment_43595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Word__NameAssignment_53626 = new BitSet(new long[]{0x0000000000000002L});

}