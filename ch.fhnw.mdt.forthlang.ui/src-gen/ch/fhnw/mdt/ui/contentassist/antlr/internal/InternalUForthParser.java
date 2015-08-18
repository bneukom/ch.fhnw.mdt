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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CARRY_RESET", "CARRYSET", "DNEGATE", "ASHIFT", "EXTEND", "NEGATE", "RCLEAR", "UNPACK", "Create", "DROP_1", "OVER_1", "SWAP_1", "CELL", "CELL_1", "CLEAR", "COUNT", "ERASE", "FALSE", "PLACE", "RDROP", "SHIFT", "UNDER", "ROT_1", "DUP_1", "DUP_2", "DABS", "DROL", "DROP", "DROR", "FILL", "MOVE", "OVER", "PACK", "SWAP", "TRUE", "TUCK", "ST_1", "DigitZeroLessThanSignGreaterThanSign", "DigitTwoAsteriskAsterisk", "ABS", "DEC", "DUP", "INC", "LLD", "LST", "NIP", "OFF", "ROL", "ROR", "ROT", "TLD", "TST", "D0", "U2", "PlusSignExclamationMark", "DigitZeroLessThanSign", "DigitZeroEqualsSign", "DigitOnePlusSign", "DigitOneHyphenMinus", "DigitTwoExclamationMark", "DigitTwoAsterisk", "DigitTwoSolidus", "DigitTwoCommercialAt", "R", "L", "L_1", "LD", "ON", "R_1", "ST", "T", "T_1", "R_2", "ExclamationMark", "Asterisk", "PlusSign", "Comma", "HyphenMinus", "Solidus", "Colon", "Semicolon", "CommercialAt", "RULE_DIGIT", "RULE_DECINT", "RULE_WS", "RULE_SL_COMMENT", "RULE_INT", "RULE_DOUBLE", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_ANY_OTHER"
    };
    public static final int ROT_1=26;
    public static final int DigitTwoExclamationMark=63;
    public static final int NEGATE=9;
    public static final int PlusSignExclamationMark=58;
    public static final int T_1=75;
    public static final int SWAP_1=15;
    public static final int DigitZeroLessThanSign=59;
    public static final int ExclamationMark=77;
    public static final int RULE_ID=92;
    public static final int RULE_DIGIT=86;
    public static final int OVER_1=14;
    public static final int DigitTwoCommercialAt=66;
    public static final int DUP_2=28;
    public static final int PlusSign=79;
    public static final int RULE_INT=90;
    public static final int DUP_1=27;
    public static final int RULE_ML_COMMENT=94;
    public static final int COUNT=19;
    public static final int PACK=36;
    public static final int DigitOnePlusSign=61;
    public static final int L=68;
    public static final int UNPACK=11;
    public static final int OFF=50;
    public static final int Comma=80;
    public static final int ABS=43;
    public static final int R=67;
    public static final int HyphenMinus=81;
    public static final int DROP_1=13;
    public static final int T=74;
    public static final int Solidus=82;
    public static final int RULE_DECINT=87;
    public static final int ASHIFT=7;
    public static final int ST=73;
    public static final int DNEGATE=6;
    public static final int UNDER=25;
    public static final int D0=56;
    public static final int PLACE=22;
    public static final int CommercialAt=85;
    public static final int Semicolon=84;
    public static final int ERASE=20;
    public static final int DigitOneHyphenMinus=62;
    public static final int LD=70;
    public static final int CELL=16;
    public static final int U2=57;
    public static final int R_2=76;
    public static final int R_1=72;
    public static final int TUCK=39;
    public static final int DABS=29;
    public static final int CARRYSET=5;
    public static final int FILL=33;
    public static final int EXTEND=8;
    public static final int TRUE=38;
    public static final int LST=48;
    public static final int ROL=51;
    public static final int SWAP=37;
    public static final int ROR=52;
    public static final int TST=55;
    public static final int ROT=53;
    public static final int DigitTwoSolidus=65;
    public static final int CARRY_RESET=4;
    public static final int DigitTwoAsteriskAsterisk=42;
    public static final int INC=46;
    public static final int LLD=47;
    public static final int RULE_STRING=93;
    public static final int DROL=30;
    public static final int TLD=54;
    public static final int DROP=31;
    public static final int RULE_SL_COMMENT=89;
    public static final int CELL_1=17;
    public static final int SHIFT=24;
    public static final int DROR=32;
    public static final int RULE_DOUBLE=91;
    public static final int Create=12;
    public static final int RCLEAR=10;
    public static final int Colon=83;
    public static final int DigitZeroEqualsSign=60;
    public static final int EOF=-1;
    public static final int Asterisk=78;
    public static final int DUP=45;
    public static final int ON=71;
    public static final int RDROP=23;
    public static final int DEC=44;
    public static final int RULE_WS=88;
    public static final int RULE_ANY_OTHER=95;
    public static final int OVER=35;
    public static final int DigitTwoAsterisk=64;
    public static final int DigitZeroLessThanSignGreaterThanSign=41;
    public static final int ST_1=40;
    public static final int NIP=49;
    public static final int MOVE=34;
    public static final int FALSE=21;
    public static final int CLEAR=18;
    public static final int L_1=69;

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
    		tokenNameToValue.put("DNEGATE", "'DNEGATE'");
    		tokenNameToValue.put("CARRYSET", "'CARRY-SET'");
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:145:1: entryRuleForth : ruleForth EOF ;
    public final void entryRuleForth() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:146:1: ( ruleForth EOF )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:147:1: ruleForth EOF
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:154:1: ruleForth : ( ( rule__Forth__InstructionsAssignment )* ) ;
    public final void ruleForth() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:158:5: ( ( ( rule__Forth__InstructionsAssignment )* ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:159:1: ( ( rule__Forth__InstructionsAssignment )* )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:159:1: ( ( rule__Forth__InstructionsAssignment )* )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:160:1: ( rule__Forth__InstructionsAssignment )*
            {
             before(grammarAccess.getForthAccess().getInstructionsAssignment()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:161:1: ( rule__Forth__InstructionsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=CARRY_RESET && LA1_0<=PlusSign)||(LA1_0>=HyphenMinus && LA1_0<=Colon)||LA1_0==CommercialAt||(LA1_0>=RULE_INT && LA1_0<=RULE_ID)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:161:2: rule__Forth__InstructionsAssignment
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


    // $ANTLR start "entryRuleGlobalInstruction"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:173:1: entryRuleGlobalInstruction : ruleGlobalInstruction EOF ;
    public final void entryRuleGlobalInstruction() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:174:1: ( ruleGlobalInstruction EOF )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:175:1: ruleGlobalInstruction EOF
            {
             before(grammarAccess.getGlobalInstructionRule()); 
            pushFollow(FOLLOW_ruleGlobalInstruction_in_entryRuleGlobalInstruction119);
            ruleGlobalInstruction();

            state._fsp--;

             after(grammarAccess.getGlobalInstructionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGlobalInstruction126); 

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
    // $ANTLR end "entryRuleGlobalInstruction"


    // $ANTLR start "ruleGlobalInstruction"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:182:1: ruleGlobalInstruction : ( ( rule__GlobalInstruction__Alternatives ) ) ;
    public final void ruleGlobalInstruction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:186:5: ( ( ( rule__GlobalInstruction__Alternatives ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:187:1: ( ( rule__GlobalInstruction__Alternatives ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:187:1: ( ( rule__GlobalInstruction__Alternatives ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:188:1: ( rule__GlobalInstruction__Alternatives )
            {
             before(grammarAccess.getGlobalInstructionAccess().getAlternatives()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:189:1: ( rule__GlobalInstruction__Alternatives )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:189:2: rule__GlobalInstruction__Alternatives
            {
            pushFollow(FOLLOW_rule__GlobalInstruction__Alternatives_in_ruleGlobalInstruction156);
            rule__GlobalInstruction__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getGlobalInstructionAccess().getAlternatives()); 

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
    // $ANTLR end "ruleGlobalInstruction"


    // $ANTLR start "entryRuleFunction"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:201:1: entryRuleFunction : ruleFunction EOF ;
    public final void entryRuleFunction() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:202:1: ( ruleFunction EOF )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:203:1: ruleFunction EOF
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:210:1: ruleFunction : ( ( rule__Function__Group__0 ) ) ;
    public final void ruleFunction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:214:5: ( ( ( rule__Function__Group__0 ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:215:1: ( ( rule__Function__Group__0 ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:215:1: ( ( rule__Function__Group__0 ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:216:1: ( rule__Function__Group__0 )
            {
             before(grammarAccess.getFunctionAccess().getGroup()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:217:1: ( rule__Function__Group__0 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:217:2: rule__Function__Group__0
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:229:1: entryRuleCreate : ruleCreate EOF ;
    public final void entryRuleCreate() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:230:1: ( ruleCreate EOF )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:231:1: ruleCreate EOF
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:238:1: ruleCreate : ( ( rule__Create__Group__0 ) ) ;
    public final void ruleCreate() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:242:5: ( ( ( rule__Create__Group__0 ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:243:1: ( ( rule__Create__Group__0 ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:243:1: ( ( rule__Create__Group__0 ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:244:1: ( rule__Create__Group__0 )
            {
             before(grammarAccess.getCreateAccess().getGroup()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:245:1: ( rule__Create__Group__0 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:245:2: rule__Create__Group__0
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:257:1: entryRuleLITERAL : ruleLITERAL EOF ;
    public final void entryRuleLITERAL() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:258:1: ( ruleLITERAL EOF )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:259:1: ruleLITERAL EOF
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:266:1: ruleLITERAL : ( ( rule__LITERAL__Alternatives ) ) ;
    public final void ruleLITERAL() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:270:5: ( ( ( rule__LITERAL__Alternatives ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:271:1: ( ( rule__LITERAL__Alternatives ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:271:1: ( ( rule__LITERAL__Alternatives ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:272:1: ( rule__LITERAL__Alternatives )
            {
             before(grammarAccess.getLITERALAccess().getAlternatives()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:273:1: ( rule__LITERAL__Alternatives )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:273:2: rule__LITERAL__Alternatives
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


    // $ANTLR start "entryRuleIntrinsicStackWords"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:285:1: entryRuleIntrinsicStackWords : ruleIntrinsicStackWords EOF ;
    public final void entryRuleIntrinsicStackWords() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:286:1: ( ruleIntrinsicStackWords EOF )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:287:1: ruleIntrinsicStackWords EOF
            {
             before(grammarAccess.getIntrinsicStackWordsRule()); 
            pushFollow(FOLLOW_ruleIntrinsicStackWords_in_entryRuleIntrinsicStackWords375);
            ruleIntrinsicStackWords();

            state._fsp--;

             after(grammarAccess.getIntrinsicStackWordsRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntrinsicStackWords382); 

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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:294:1: ruleIntrinsicStackWords : ( ( rule__IntrinsicStackWords__Group__0 ) ) ;
    public final void ruleIntrinsicStackWords() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:298:5: ( ( ( rule__IntrinsicStackWords__Group__0 ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:299:1: ( ( rule__IntrinsicStackWords__Group__0 ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:299:1: ( ( rule__IntrinsicStackWords__Group__0 ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:300:1: ( rule__IntrinsicStackWords__Group__0 )
            {
             before(grammarAccess.getIntrinsicStackWordsAccess().getGroup()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:301:1: ( rule__IntrinsicStackWords__Group__0 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:301:2: rule__IntrinsicStackWords__Group__0
            {
            pushFollow(FOLLOW_rule__IntrinsicStackWords__Group__0_in_ruleIntrinsicStackWords412);
            rule__IntrinsicStackWords__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIntrinsicStackWordsAccess().getGroup()); 

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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:313:1: entryRuleIntrinsicMemoryWords : ruleIntrinsicMemoryWords EOF ;
    public final void entryRuleIntrinsicMemoryWords() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:314:1: ( ruleIntrinsicMemoryWords EOF )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:315:1: ruleIntrinsicMemoryWords EOF
            {
             before(grammarAccess.getIntrinsicMemoryWordsRule()); 
            pushFollow(FOLLOW_ruleIntrinsicMemoryWords_in_entryRuleIntrinsicMemoryWords439);
            ruleIntrinsicMemoryWords();

            state._fsp--;

             after(grammarAccess.getIntrinsicMemoryWordsRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntrinsicMemoryWords446); 

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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:322:1: ruleIntrinsicMemoryWords : ( ( rule__IntrinsicMemoryWords__Group__0 ) ) ;
    public final void ruleIntrinsicMemoryWords() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:326:5: ( ( ( rule__IntrinsicMemoryWords__Group__0 ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:327:1: ( ( rule__IntrinsicMemoryWords__Group__0 ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:327:1: ( ( rule__IntrinsicMemoryWords__Group__0 ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:328:1: ( rule__IntrinsicMemoryWords__Group__0 )
            {
             before(grammarAccess.getIntrinsicMemoryWordsAccess().getGroup()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:329:1: ( rule__IntrinsicMemoryWords__Group__0 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:329:2: rule__IntrinsicMemoryWords__Group__0
            {
            pushFollow(FOLLOW_rule__IntrinsicMemoryWords__Group__0_in_ruleIntrinsicMemoryWords476);
            rule__IntrinsicMemoryWords__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIntrinsicMemoryWordsAccess().getGroup()); 

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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:341:1: entryRuleIntrinsicArithmeticWords : ruleIntrinsicArithmeticWords EOF ;
    public final void entryRuleIntrinsicArithmeticWords() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:342:1: ( ruleIntrinsicArithmeticWords EOF )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:343:1: ruleIntrinsicArithmeticWords EOF
            {
             before(grammarAccess.getIntrinsicArithmeticWordsRule()); 
            pushFollow(FOLLOW_ruleIntrinsicArithmeticWords_in_entryRuleIntrinsicArithmeticWords503);
            ruleIntrinsicArithmeticWords();

            state._fsp--;

             after(grammarAccess.getIntrinsicArithmeticWordsRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntrinsicArithmeticWords510); 

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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:350:1: ruleIntrinsicArithmeticWords : ( ( rule__IntrinsicArithmeticWords__Group__0 ) ) ;
    public final void ruleIntrinsicArithmeticWords() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:354:5: ( ( ( rule__IntrinsicArithmeticWords__Group__0 ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:355:1: ( ( rule__IntrinsicArithmeticWords__Group__0 ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:355:1: ( ( rule__IntrinsicArithmeticWords__Group__0 ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:356:1: ( rule__IntrinsicArithmeticWords__Group__0 )
            {
             before(grammarAccess.getIntrinsicArithmeticWordsAccess().getGroup()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:357:1: ( rule__IntrinsicArithmeticWords__Group__0 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:357:2: rule__IntrinsicArithmeticWords__Group__0
            {
            pushFollow(FOLLOW_rule__IntrinsicArithmeticWords__Group__0_in_ruleIntrinsicArithmeticWords540);
            rule__IntrinsicArithmeticWords__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIntrinsicArithmeticWordsAccess().getGroup()); 

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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:369:1: entryRuleWord : ruleWord EOF ;
    public final void entryRuleWord() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:370:1: ( ruleWord EOF )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:371:1: ruleWord EOF
            {
             before(grammarAccess.getWordRule()); 
            pushFollow(FOLLOW_ruleWord_in_entryRuleWord567);
            ruleWord();

            state._fsp--;

             after(grammarAccess.getWordRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWord574); 

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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:378:1: ruleWord : ( ( rule__Word__Alternatives ) ) ;
    public final void ruleWord() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:382:5: ( ( ( rule__Word__Alternatives ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:383:1: ( ( rule__Word__Alternatives ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:383:1: ( ( rule__Word__Alternatives ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:384:1: ( rule__Word__Alternatives )
            {
             before(grammarAccess.getWordAccess().getAlternatives()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:385:1: ( rule__Word__Alternatives )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:385:2: rule__Word__Alternatives
            {
            pushFollow(FOLLOW_rule__Word__Alternatives_in_ruleWord604);
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


    // $ANTLR start "rule__GlobalInstruction__Alternatives"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:397:1: rule__GlobalInstruction__Alternatives : ( ( ruleCreate ) | ( ruleFunction ) | ( ruleWord ) );
    public final void rule__GlobalInstruction__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:401:1: ( ( ruleCreate ) | ( ruleFunction ) | ( ruleWord ) )
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
            case CARRYSET:
            case DNEGATE:
            case ASHIFT:
            case EXTEND:
            case NEGATE:
            case RCLEAR:
            case UNPACK:
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
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:402:1: ( ruleCreate )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:402:1: ( ruleCreate )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:403:1: ruleCreate
                    {
                     before(grammarAccess.getGlobalInstructionAccess().getCreateParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleCreate_in_rule__GlobalInstruction__Alternatives640);
                    ruleCreate();

                    state._fsp--;

                     after(grammarAccess.getGlobalInstructionAccess().getCreateParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:408:6: ( ruleFunction )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:408:6: ( ruleFunction )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:409:1: ruleFunction
                    {
                     before(grammarAccess.getGlobalInstructionAccess().getFunctionParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleFunction_in_rule__GlobalInstruction__Alternatives657);
                    ruleFunction();

                    state._fsp--;

                     after(grammarAccess.getGlobalInstructionAccess().getFunctionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:414:6: ( ruleWord )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:414:6: ( ruleWord )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:415:1: ruleWord
                    {
                     before(grammarAccess.getGlobalInstructionAccess().getWordParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleWord_in_rule__GlobalInstruction__Alternatives674);
                    ruleWord();

                    state._fsp--;

                     after(grammarAccess.getGlobalInstructionAccess().getWordParserRuleCall_2()); 

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
    // $ANTLR end "rule__GlobalInstruction__Alternatives"


    // $ANTLR start "rule__LITERAL__Alternatives"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:425:1: rule__LITERAL__Alternatives : ( ( RULE_INT ) | ( RULE_DOUBLE ) );
    public final void rule__LITERAL__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:429:1: ( ( RULE_INT ) | ( RULE_DOUBLE ) )
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
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:430:1: ( RULE_INT )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:430:1: ( RULE_INT )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:431:1: RULE_INT
                    {
                     before(grammarAccess.getLITERALAccess().getINTTerminalRuleCall_0()); 
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__LITERAL__Alternatives706); 
                     after(grammarAccess.getLITERALAccess().getINTTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:436:6: ( RULE_DOUBLE )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:436:6: ( RULE_DOUBLE )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:437:1: RULE_DOUBLE
                    {
                     before(grammarAccess.getLITERALAccess().getDOUBLETerminalRuleCall_1()); 
                    match(input,RULE_DOUBLE,FOLLOW_RULE_DOUBLE_in_rule__LITERAL__Alternatives723); 
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


    // $ANTLR start "rule__IntrinsicStackWords__NameAlternatives_1_0"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:447:1: rule__IntrinsicStackWords__NameAlternatives_1_0 : ( ( CLEAR ) | ( DROP ) | ( DUP ) | ( DUP_2 ) | ( SWAP ) | ( NIP ) | ( OVER ) | ( ROT ) | ( ROT_1 ) | ( TUCK ) | ( UNDER ) | ( DROP_1 ) | ( DUP_1 ) | ( SWAP_1 ) | ( OVER_1 ) | ( RCLEAR ) | ( R_1 ) | ( R_2 ) | ( R ) | ( RDROP ) );
    public final void rule__IntrinsicStackWords__NameAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:451:1: ( ( CLEAR ) | ( DROP ) | ( DUP ) | ( DUP_2 ) | ( SWAP ) | ( NIP ) | ( OVER ) | ( ROT ) | ( ROT_1 ) | ( TUCK ) | ( UNDER ) | ( DROP_1 ) | ( DUP_1 ) | ( SWAP_1 ) | ( OVER_1 ) | ( RCLEAR ) | ( R_1 ) | ( R_2 ) | ( R ) | ( RDROP ) )
            int alt4=20;
            switch ( input.LA(1) ) {
            case CLEAR:
                {
                alt4=1;
                }
                break;
            case DROP:
                {
                alt4=2;
                }
                break;
            case DUP:
                {
                alt4=3;
                }
                break;
            case DUP_2:
                {
                alt4=4;
                }
                break;
            case SWAP:
                {
                alt4=5;
                }
                break;
            case NIP:
                {
                alt4=6;
                }
                break;
            case OVER:
                {
                alt4=7;
                }
                break;
            case ROT:
                {
                alt4=8;
                }
                break;
            case ROT_1:
                {
                alt4=9;
                }
                break;
            case TUCK:
                {
                alt4=10;
                }
                break;
            case UNDER:
                {
                alt4=11;
                }
                break;
            case DROP_1:
                {
                alt4=12;
                }
                break;
            case DUP_1:
                {
                alt4=13;
                }
                break;
            case SWAP_1:
                {
                alt4=14;
                }
                break;
            case OVER_1:
                {
                alt4=15;
                }
                break;
            case RCLEAR:
                {
                alt4=16;
                }
                break;
            case R_1:
                {
                alt4=17;
                }
                break;
            case R_2:
                {
                alt4=18;
                }
                break;
            case R:
                {
                alt4=19;
                }
                break;
            case RDROP:
                {
                alt4=20;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:452:1: ( CLEAR )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:452:1: ( CLEAR )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:453:1: CLEAR
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getNameCLEARKeyword_1_0_0()); 
                    match(input,CLEAR,FOLLOW_CLEAR_in_rule__IntrinsicStackWords__NameAlternatives_1_0756); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getNameCLEARKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:460:6: ( DROP )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:460:6: ( DROP )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:461:1: DROP
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getNameDROPKeyword_1_0_1()); 
                    match(input,DROP,FOLLOW_DROP_in_rule__IntrinsicStackWords__NameAlternatives_1_0776); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getNameDROPKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:468:6: ( DUP )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:468:6: ( DUP )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:469:1: DUP
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getNameDUPKeyword_1_0_2()); 
                    match(input,DUP,FOLLOW_DUP_in_rule__IntrinsicStackWords__NameAlternatives_1_0796); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getNameDUPKeyword_1_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:476:6: ( DUP_2 )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:476:6: ( DUP_2 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:477:1: DUP_2
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getNameDUPKeyword_1_0_3()); 
                    match(input,DUP_2,FOLLOW_DUP_2_in_rule__IntrinsicStackWords__NameAlternatives_1_0816); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getNameDUPKeyword_1_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:484:6: ( SWAP )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:484:6: ( SWAP )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:485:1: SWAP
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getNameSWAPKeyword_1_0_4()); 
                    match(input,SWAP,FOLLOW_SWAP_in_rule__IntrinsicStackWords__NameAlternatives_1_0836); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getNameSWAPKeyword_1_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:492:6: ( NIP )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:492:6: ( NIP )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:493:1: NIP
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getNameNIPKeyword_1_0_5()); 
                    match(input,NIP,FOLLOW_NIP_in_rule__IntrinsicStackWords__NameAlternatives_1_0856); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getNameNIPKeyword_1_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:500:6: ( OVER )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:500:6: ( OVER )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:501:1: OVER
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getNameOVERKeyword_1_0_6()); 
                    match(input,OVER,FOLLOW_OVER_in_rule__IntrinsicStackWords__NameAlternatives_1_0876); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getNameOVERKeyword_1_0_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:508:6: ( ROT )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:508:6: ( ROT )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:509:1: ROT
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getNameROTKeyword_1_0_7()); 
                    match(input,ROT,FOLLOW_ROT_in_rule__IntrinsicStackWords__NameAlternatives_1_0896); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getNameROTKeyword_1_0_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:516:6: ( ROT_1 )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:516:6: ( ROT_1 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:517:1: ROT_1
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getNameROTKeyword_1_0_8()); 
                    match(input,ROT_1,FOLLOW_ROT_1_in_rule__IntrinsicStackWords__NameAlternatives_1_0916); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getNameROTKeyword_1_0_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:524:6: ( TUCK )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:524:6: ( TUCK )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:525:1: TUCK
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getNameTUCKKeyword_1_0_9()); 
                    match(input,TUCK,FOLLOW_TUCK_in_rule__IntrinsicStackWords__NameAlternatives_1_0936); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getNameTUCKKeyword_1_0_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:532:6: ( UNDER )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:532:6: ( UNDER )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:533:1: UNDER
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getNameUNDERKeyword_1_0_10()); 
                    match(input,UNDER,FOLLOW_UNDER_in_rule__IntrinsicStackWords__NameAlternatives_1_0956); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getNameUNDERKeyword_1_0_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:540:6: ( DROP_1 )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:540:6: ( DROP_1 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:541:1: DROP_1
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getName2DROPKeyword_1_0_11()); 
                    match(input,DROP_1,FOLLOW_DROP_1_in_rule__IntrinsicStackWords__NameAlternatives_1_0976); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getName2DROPKeyword_1_0_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:548:6: ( DUP_1 )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:548:6: ( DUP_1 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:549:1: DUP_1
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getName2DUPKeyword_1_0_12()); 
                    match(input,DUP_1,FOLLOW_DUP_1_in_rule__IntrinsicStackWords__NameAlternatives_1_0996); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getName2DUPKeyword_1_0_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:556:6: ( SWAP_1 )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:556:6: ( SWAP_1 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:557:1: SWAP_1
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getName2SWAPKeyword_1_0_13()); 
                    match(input,SWAP_1,FOLLOW_SWAP_1_in_rule__IntrinsicStackWords__NameAlternatives_1_01016); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getName2SWAPKeyword_1_0_13()); 

                    }


                    }
                    break;
                case 15 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:564:6: ( OVER_1 )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:564:6: ( OVER_1 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:565:1: OVER_1
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getName2OVERKeyword_1_0_14()); 
                    match(input,OVER_1,FOLLOW_OVER_1_in_rule__IntrinsicStackWords__NameAlternatives_1_01036); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getName2OVERKeyword_1_0_14()); 

                    }


                    }
                    break;
                case 16 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:572:6: ( RCLEAR )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:572:6: ( RCLEAR )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:573:1: RCLEAR
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getNameRCLEARKeyword_1_0_15()); 
                    match(input,RCLEAR,FOLLOW_RCLEAR_in_rule__IntrinsicStackWords__NameAlternatives_1_01056); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getNameRCLEARKeyword_1_0_15()); 

                    }


                    }
                    break;
                case 17 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:580:6: ( R_1 )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:580:6: ( R_1 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:581:1: R_1
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getNameRKeyword_1_0_16()); 
                    match(input,R_1,FOLLOW_R_1_in_rule__IntrinsicStackWords__NameAlternatives_1_01076); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getNameRKeyword_1_0_16()); 

                    }


                    }
                    break;
                case 18 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:588:6: ( R_2 )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:588:6: ( R_2 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:589:1: R_2
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getNameRKeyword_1_0_17()); 
                    match(input,R_2,FOLLOW_R_2_in_rule__IntrinsicStackWords__NameAlternatives_1_01096); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getNameRKeyword_1_0_17()); 

                    }


                    }
                    break;
                case 19 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:596:6: ( R )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:596:6: ( R )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:597:1: R
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getNameRKeyword_1_0_18()); 
                    match(input,R,FOLLOW_R_in_rule__IntrinsicStackWords__NameAlternatives_1_01116); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getNameRKeyword_1_0_18()); 

                    }


                    }
                    break;
                case 20 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:604:6: ( RDROP )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:604:6: ( RDROP )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:605:1: RDROP
                    {
                     before(grammarAccess.getIntrinsicStackWordsAccess().getNameRDROPKeyword_1_0_19()); 
                    match(input,RDROP,FOLLOW_RDROP_in_rule__IntrinsicStackWords__NameAlternatives_1_01136); 
                     after(grammarAccess.getIntrinsicStackWordsAccess().getNameRDROPKeyword_1_0_19()); 

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
    // $ANTLR end "rule__IntrinsicStackWords__NameAlternatives_1_0"


    // $ANTLR start "rule__IntrinsicMemoryWords__NameAlternatives_1_0"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:617:1: rule__IntrinsicMemoryWords__NameAlternatives_1_0 : ( ( LD ) | ( CommercialAt ) | ( ST ) | ( ExclamationMark ) | ( DigitTwoCommercialAt ) | ( DigitTwoExclamationMark ) | ( LLD ) | ( L_1 ) | ( LST ) | ( L ) | ( TLD ) | ( T_1 ) | ( TST ) | ( T ) | ( ST_1 ) | ( PlusSignExclamationMark ) | ( INC ) | ( DEC ) | ( ON ) | ( OFF ) | ( ERASE ) | ( FILL ) | ( COUNT ) | ( MOVE ) | ( PLACE ) );
    public final void rule__IntrinsicMemoryWords__NameAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:621:1: ( ( LD ) | ( CommercialAt ) | ( ST ) | ( ExclamationMark ) | ( DigitTwoCommercialAt ) | ( DigitTwoExclamationMark ) | ( LLD ) | ( L_1 ) | ( LST ) | ( L ) | ( TLD ) | ( T_1 ) | ( TST ) | ( T ) | ( ST_1 ) | ( PlusSignExclamationMark ) | ( INC ) | ( DEC ) | ( ON ) | ( OFF ) | ( ERASE ) | ( FILL ) | ( COUNT ) | ( MOVE ) | ( PLACE ) )
            int alt5=25;
            switch ( input.LA(1) ) {
            case LD:
                {
                alt5=1;
                }
                break;
            case CommercialAt:
                {
                alt5=2;
                }
                break;
            case ST:
                {
                alt5=3;
                }
                break;
            case ExclamationMark:
                {
                alt5=4;
                }
                break;
            case DigitTwoCommercialAt:
                {
                alt5=5;
                }
                break;
            case DigitTwoExclamationMark:
                {
                alt5=6;
                }
                break;
            case LLD:
                {
                alt5=7;
                }
                break;
            case L_1:
                {
                alt5=8;
                }
                break;
            case LST:
                {
                alt5=9;
                }
                break;
            case L:
                {
                alt5=10;
                }
                break;
            case TLD:
                {
                alt5=11;
                }
                break;
            case T_1:
                {
                alt5=12;
                }
                break;
            case TST:
                {
                alt5=13;
                }
                break;
            case T:
                {
                alt5=14;
                }
                break;
            case ST_1:
                {
                alt5=15;
                }
                break;
            case PlusSignExclamationMark:
                {
                alt5=16;
                }
                break;
            case INC:
                {
                alt5=17;
                }
                break;
            case DEC:
                {
                alt5=18;
                }
                break;
            case ON:
                {
                alt5=19;
                }
                break;
            case OFF:
                {
                alt5=20;
                }
                break;
            case ERASE:
                {
                alt5=21;
                }
                break;
            case FILL:
                {
                alt5=22;
                }
                break;
            case COUNT:
                {
                alt5=23;
                }
                break;
            case MOVE:
                {
                alt5=24;
                }
                break;
            case PLACE:
                {
                alt5=25;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:622:1: ( LD )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:622:1: ( LD )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:623:1: LD
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameLDKeyword_1_0_0()); 
                    match(input,LD,FOLLOW_LD_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01171); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameLDKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:630:6: ( CommercialAt )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:630:6: ( CommercialAt )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:631:1: CommercialAt
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameCommercialAtKeyword_1_0_1()); 
                    match(input,CommercialAt,FOLLOW_CommercialAt_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01191); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameCommercialAtKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:638:6: ( ST )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:638:6: ( ST )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:639:1: ST
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameSTKeyword_1_0_2()); 
                    match(input,ST,FOLLOW_ST_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01211); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameSTKeyword_1_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:646:6: ( ExclamationMark )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:646:6: ( ExclamationMark )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:647:1: ExclamationMark
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameExclamationMarkKeyword_1_0_3()); 
                    match(input,ExclamationMark,FOLLOW_ExclamationMark_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01231); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameExclamationMarkKeyword_1_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:654:6: ( DigitTwoCommercialAt )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:654:6: ( DigitTwoCommercialAt )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:655:1: DigitTwoCommercialAt
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getName2Keyword_1_0_4()); 
                    match(input,DigitTwoCommercialAt,FOLLOW_DigitTwoCommercialAt_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01251); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getName2Keyword_1_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:662:6: ( DigitTwoExclamationMark )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:662:6: ( DigitTwoExclamationMark )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:663:1: DigitTwoExclamationMark
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getName2Keyword_1_0_5()); 
                    match(input,DigitTwoExclamationMark,FOLLOW_DigitTwoExclamationMark_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01271); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getName2Keyword_1_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:670:6: ( LLD )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:670:6: ( LLD )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:671:1: LLD
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameLLDKeyword_1_0_6()); 
                    match(input,LLD,FOLLOW_LLD_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01291); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameLLDKeyword_1_0_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:678:6: ( L_1 )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:678:6: ( L_1 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:679:1: L_1
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameLKeyword_1_0_7()); 
                    match(input,L_1,FOLLOW_L_1_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01311); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameLKeyword_1_0_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:686:6: ( LST )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:686:6: ( LST )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:687:1: LST
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameLSTKeyword_1_0_8()); 
                    match(input,LST,FOLLOW_LST_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01331); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameLSTKeyword_1_0_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:694:6: ( L )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:694:6: ( L )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:695:1: L
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameLKeyword_1_0_9()); 
                    match(input,L,FOLLOW_L_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01351); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameLKeyword_1_0_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:702:6: ( TLD )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:702:6: ( TLD )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:703:1: TLD
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameTLDKeyword_1_0_10()); 
                    match(input,TLD,FOLLOW_TLD_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01371); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameTLDKeyword_1_0_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:710:6: ( T_1 )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:710:6: ( T_1 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:711:1: T_1
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameTKeyword_1_0_11()); 
                    match(input,T_1,FOLLOW_T_1_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01391); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameTKeyword_1_0_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:718:6: ( TST )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:718:6: ( TST )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:719:1: TST
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameTSTKeyword_1_0_12()); 
                    match(input,TST,FOLLOW_TST_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01411); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameTSTKeyword_1_0_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:726:6: ( T )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:726:6: ( T )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:727:1: T
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameTKeyword_1_0_13()); 
                    match(input,T,FOLLOW_T_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01431); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameTKeyword_1_0_13()); 

                    }


                    }
                    break;
                case 15 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:734:6: ( ST_1 )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:734:6: ( ST_1 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:735:1: ST_1
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameSTKeyword_1_0_14()); 
                    match(input,ST_1,FOLLOW_ST_1_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01451); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameSTKeyword_1_0_14()); 

                    }


                    }
                    break;
                case 16 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:742:6: ( PlusSignExclamationMark )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:742:6: ( PlusSignExclamationMark )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:743:1: PlusSignExclamationMark
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNamePlusSignExclamationMarkKeyword_1_0_15()); 
                    match(input,PlusSignExclamationMark,FOLLOW_PlusSignExclamationMark_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01471); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNamePlusSignExclamationMarkKeyword_1_0_15()); 

                    }


                    }
                    break;
                case 17 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:750:6: ( INC )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:750:6: ( INC )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:751:1: INC
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameINCKeyword_1_0_16()); 
                    match(input,INC,FOLLOW_INC_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01491); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameINCKeyword_1_0_16()); 

                    }


                    }
                    break;
                case 18 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:758:6: ( DEC )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:758:6: ( DEC )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:759:1: DEC
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameDECKeyword_1_0_17()); 
                    match(input,DEC,FOLLOW_DEC_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01511); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameDECKeyword_1_0_17()); 

                    }


                    }
                    break;
                case 19 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:766:6: ( ON )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:766:6: ( ON )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:767:1: ON
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameONKeyword_1_0_18()); 
                    match(input,ON,FOLLOW_ON_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01531); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameONKeyword_1_0_18()); 

                    }


                    }
                    break;
                case 20 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:774:6: ( OFF )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:774:6: ( OFF )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:775:1: OFF
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameOFFKeyword_1_0_19()); 
                    match(input,OFF,FOLLOW_OFF_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01551); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameOFFKeyword_1_0_19()); 

                    }


                    }
                    break;
                case 21 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:782:6: ( ERASE )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:782:6: ( ERASE )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:783:1: ERASE
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameERASEKeyword_1_0_20()); 
                    match(input,ERASE,FOLLOW_ERASE_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01571); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameERASEKeyword_1_0_20()); 

                    }


                    }
                    break;
                case 22 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:790:6: ( FILL )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:790:6: ( FILL )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:791:1: FILL
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameFILLKeyword_1_0_21()); 
                    match(input,FILL,FOLLOW_FILL_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01591); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameFILLKeyword_1_0_21()); 

                    }


                    }
                    break;
                case 23 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:798:6: ( COUNT )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:798:6: ( COUNT )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:799:1: COUNT
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameCOUNTKeyword_1_0_22()); 
                    match(input,COUNT,FOLLOW_COUNT_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01611); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameCOUNTKeyword_1_0_22()); 

                    }


                    }
                    break;
                case 24 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:806:6: ( MOVE )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:806:6: ( MOVE )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:807:1: MOVE
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameMOVEKeyword_1_0_23()); 
                    match(input,MOVE,FOLLOW_MOVE_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01631); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameMOVEKeyword_1_0_23()); 

                    }


                    }
                    break;
                case 25 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:814:6: ( PLACE )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:814:6: ( PLACE )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:815:1: PLACE
                    {
                     before(grammarAccess.getIntrinsicMemoryWordsAccess().getNamePLACEKeyword_1_0_24()); 
                    match(input,PLACE,FOLLOW_PLACE_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01651); 
                     after(grammarAccess.getIntrinsicMemoryWordsAccess().getNamePLACEKeyword_1_0_24()); 

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
    // $ANTLR end "rule__IntrinsicMemoryWords__NameAlternatives_1_0"


    // $ANTLR start "rule__IntrinsicArithmeticWords__NameAlternatives_1_0"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:827:1: rule__IntrinsicArithmeticWords__NameAlternatives_1_0 : ( ( PlusSign ) | ( HyphenMinus ) | ( Asterisk ) | ( Solidus ) | ( DigitTwoAsterisk ) | ( DigitTwoSolidus ) | ( U2 ) | ( ROR ) | ( DROR ) | ( ROL ) | ( DROL ) | ( PACK ) | ( UNPACK ) | ( SHIFT ) | ( ASHIFT ) | ( DigitTwoAsteriskAsterisk ) | ( DigitZeroEqualsSign ) | ( DigitZeroLessThanSignGreaterThanSign ) | ( DigitZeroLessThanSign ) | ( D0 ) | ( NEGATE ) | ( DNEGATE ) | ( DigitOnePlusSign ) | ( DigitOneHyphenMinus ) | ( TRUE ) | ( FALSE ) | ( CELL ) | ( CELL_1 ) | ( CARRY_RESET ) | ( CARRYSET ) | ( ABS ) | ( DABS ) | ( EXTEND ) );
    public final void rule__IntrinsicArithmeticWords__NameAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:831:1: ( ( PlusSign ) | ( HyphenMinus ) | ( Asterisk ) | ( Solidus ) | ( DigitTwoAsterisk ) | ( DigitTwoSolidus ) | ( U2 ) | ( ROR ) | ( DROR ) | ( ROL ) | ( DROL ) | ( PACK ) | ( UNPACK ) | ( SHIFT ) | ( ASHIFT ) | ( DigitTwoAsteriskAsterisk ) | ( DigitZeroEqualsSign ) | ( DigitZeroLessThanSignGreaterThanSign ) | ( DigitZeroLessThanSign ) | ( D0 ) | ( NEGATE ) | ( DNEGATE ) | ( DigitOnePlusSign ) | ( DigitOneHyphenMinus ) | ( TRUE ) | ( FALSE ) | ( CELL ) | ( CELL_1 ) | ( CARRY_RESET ) | ( CARRYSET ) | ( ABS ) | ( DABS ) | ( EXTEND ) )
            int alt6=33;
            switch ( input.LA(1) ) {
            case PlusSign:
                {
                alt6=1;
                }
                break;
            case HyphenMinus:
                {
                alt6=2;
                }
                break;
            case Asterisk:
                {
                alt6=3;
                }
                break;
            case Solidus:
                {
                alt6=4;
                }
                break;
            case DigitTwoAsterisk:
                {
                alt6=5;
                }
                break;
            case DigitTwoSolidus:
                {
                alt6=6;
                }
                break;
            case U2:
                {
                alt6=7;
                }
                break;
            case ROR:
                {
                alt6=8;
                }
                break;
            case DROR:
                {
                alt6=9;
                }
                break;
            case ROL:
                {
                alt6=10;
                }
                break;
            case DROL:
                {
                alt6=11;
                }
                break;
            case PACK:
                {
                alt6=12;
                }
                break;
            case UNPACK:
                {
                alt6=13;
                }
                break;
            case SHIFT:
                {
                alt6=14;
                }
                break;
            case ASHIFT:
                {
                alt6=15;
                }
                break;
            case DigitTwoAsteriskAsterisk:
                {
                alt6=16;
                }
                break;
            case DigitZeroEqualsSign:
                {
                alt6=17;
                }
                break;
            case DigitZeroLessThanSignGreaterThanSign:
                {
                alt6=18;
                }
                break;
            case DigitZeroLessThanSign:
                {
                alt6=19;
                }
                break;
            case D0:
                {
                alt6=20;
                }
                break;
            case NEGATE:
                {
                alt6=21;
                }
                break;
            case DNEGATE:
                {
                alt6=22;
                }
                break;
            case DigitOnePlusSign:
                {
                alt6=23;
                }
                break;
            case DigitOneHyphenMinus:
                {
                alt6=24;
                }
                break;
            case TRUE:
                {
                alt6=25;
                }
                break;
            case FALSE:
                {
                alt6=26;
                }
                break;
            case CELL:
                {
                alt6=27;
                }
                break;
            case CELL_1:
                {
                alt6=28;
                }
                break;
            case CARRY_RESET:
                {
                alt6=29;
                }
                break;
            case CARRYSET:
                {
                alt6=30;
                }
                break;
            case ABS:
                {
                alt6=31;
                }
                break;
            case DABS:
                {
                alt6=32;
                }
                break;
            case EXTEND:
                {
                alt6=33;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:832:1: ( PlusSign )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:832:1: ( PlusSign )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:833:1: PlusSign
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNamePlusSignKeyword_1_0_0()); 
                    match(input,PlusSign,FOLLOW_PlusSign_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_01686); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNamePlusSignKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:840:6: ( HyphenMinus )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:840:6: ( HyphenMinus )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:841:1: HyphenMinus
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameHyphenMinusKeyword_1_0_1()); 
                    match(input,HyphenMinus,FOLLOW_HyphenMinus_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_01706); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameHyphenMinusKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:848:6: ( Asterisk )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:848:6: ( Asterisk )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:849:1: Asterisk
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameAsteriskKeyword_1_0_2()); 
                    match(input,Asterisk,FOLLOW_Asterisk_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_01726); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameAsteriskKeyword_1_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:856:6: ( Solidus )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:856:6: ( Solidus )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:857:1: Solidus
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameSolidusKeyword_1_0_3()); 
                    match(input,Solidus,FOLLOW_Solidus_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_01746); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameSolidusKeyword_1_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:864:6: ( DigitTwoAsterisk )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:864:6: ( DigitTwoAsterisk )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:865:1: DigitTwoAsterisk
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getName2Keyword_1_0_4()); 
                    match(input,DigitTwoAsterisk,FOLLOW_DigitTwoAsterisk_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_01766); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getName2Keyword_1_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:872:6: ( DigitTwoSolidus )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:872:6: ( DigitTwoSolidus )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:873:1: DigitTwoSolidus
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getName2Keyword_1_0_5()); 
                    match(input,DigitTwoSolidus,FOLLOW_DigitTwoSolidus_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_01786); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getName2Keyword_1_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:880:6: ( U2 )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:880:6: ( U2 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:881:1: U2
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameU2Keyword_1_0_6()); 
                    match(input,U2,FOLLOW_U2_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_01806); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameU2Keyword_1_0_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:888:6: ( ROR )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:888:6: ( ROR )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:889:1: ROR
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameRORKeyword_1_0_7()); 
                    match(input,ROR,FOLLOW_ROR_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_01826); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameRORKeyword_1_0_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:896:6: ( DROR )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:896:6: ( DROR )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:897:1: DROR
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameDRORKeyword_1_0_8()); 
                    match(input,DROR,FOLLOW_DROR_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_01846); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameDRORKeyword_1_0_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:904:6: ( ROL )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:904:6: ( ROL )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:905:1: ROL
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameROLKeyword_1_0_9()); 
                    match(input,ROL,FOLLOW_ROL_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_01866); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameROLKeyword_1_0_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:912:6: ( DROL )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:912:6: ( DROL )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:913:1: DROL
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameDROLKeyword_1_0_10()); 
                    match(input,DROL,FOLLOW_DROL_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_01886); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameDROLKeyword_1_0_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:920:6: ( PACK )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:920:6: ( PACK )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:921:1: PACK
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNamePACKKeyword_1_0_11()); 
                    match(input,PACK,FOLLOW_PACK_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_01906); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNamePACKKeyword_1_0_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:928:6: ( UNPACK )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:928:6: ( UNPACK )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:929:1: UNPACK
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameUNPACKKeyword_1_0_12()); 
                    match(input,UNPACK,FOLLOW_UNPACK_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_01926); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameUNPACKKeyword_1_0_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:936:6: ( SHIFT )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:936:6: ( SHIFT )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:937:1: SHIFT
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameSHIFTKeyword_1_0_13()); 
                    match(input,SHIFT,FOLLOW_SHIFT_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_01946); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameSHIFTKeyword_1_0_13()); 

                    }


                    }
                    break;
                case 15 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:944:6: ( ASHIFT )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:944:6: ( ASHIFT )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:945:1: ASHIFT
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameASHIFTKeyword_1_0_14()); 
                    match(input,ASHIFT,FOLLOW_ASHIFT_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_01966); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameASHIFTKeyword_1_0_14()); 

                    }


                    }
                    break;
                case 16 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:952:6: ( DigitTwoAsteriskAsterisk )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:952:6: ( DigitTwoAsteriskAsterisk )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:953:1: DigitTwoAsteriskAsterisk
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getName2Keyword_1_0_15()); 
                    match(input,DigitTwoAsteriskAsterisk,FOLLOW_DigitTwoAsteriskAsterisk_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_01986); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getName2Keyword_1_0_15()); 

                    }


                    }
                    break;
                case 17 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:960:6: ( DigitZeroEqualsSign )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:960:6: ( DigitZeroEqualsSign )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:961:1: DigitZeroEqualsSign
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getName0Keyword_1_0_16()); 
                    match(input,DigitZeroEqualsSign,FOLLOW_DigitZeroEqualsSign_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_02006); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getName0Keyword_1_0_16()); 

                    }


                    }
                    break;
                case 18 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:968:6: ( DigitZeroLessThanSignGreaterThanSign )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:968:6: ( DigitZeroLessThanSignGreaterThanSign )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:969:1: DigitZeroLessThanSignGreaterThanSign
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getName0Keyword_1_0_17()); 
                    match(input,DigitZeroLessThanSignGreaterThanSign,FOLLOW_DigitZeroLessThanSignGreaterThanSign_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_02026); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getName0Keyword_1_0_17()); 

                    }


                    }
                    break;
                case 19 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:976:6: ( DigitZeroLessThanSign )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:976:6: ( DigitZeroLessThanSign )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:977:1: DigitZeroLessThanSign
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getName0Keyword_1_0_18()); 
                    match(input,DigitZeroLessThanSign,FOLLOW_DigitZeroLessThanSign_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_02046); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getName0Keyword_1_0_18()); 

                    }


                    }
                    break;
                case 20 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:984:6: ( D0 )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:984:6: ( D0 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:985:1: D0
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameD0Keyword_1_0_19()); 
                    match(input,D0,FOLLOW_D0_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_02066); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameD0Keyword_1_0_19()); 

                    }


                    }
                    break;
                case 21 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:992:6: ( NEGATE )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:992:6: ( NEGATE )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:993:1: NEGATE
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameNEGATEKeyword_1_0_20()); 
                    match(input,NEGATE,FOLLOW_NEGATE_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_02086); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameNEGATEKeyword_1_0_20()); 

                    }


                    }
                    break;
                case 22 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1000:6: ( DNEGATE )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1000:6: ( DNEGATE )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1001:1: DNEGATE
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameDNEGATEKeyword_1_0_21()); 
                    match(input,DNEGATE,FOLLOW_DNEGATE_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_02106); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameDNEGATEKeyword_1_0_21()); 

                    }


                    }
                    break;
                case 23 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1008:6: ( DigitOnePlusSign )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1008:6: ( DigitOnePlusSign )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1009:1: DigitOnePlusSign
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getName1Keyword_1_0_22()); 
                    match(input,DigitOnePlusSign,FOLLOW_DigitOnePlusSign_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_02126); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getName1Keyword_1_0_22()); 

                    }


                    }
                    break;
                case 24 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1016:6: ( DigitOneHyphenMinus )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1016:6: ( DigitOneHyphenMinus )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1017:1: DigitOneHyphenMinus
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getName1Keyword_1_0_23()); 
                    match(input,DigitOneHyphenMinus,FOLLOW_DigitOneHyphenMinus_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_02146); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getName1Keyword_1_0_23()); 

                    }


                    }
                    break;
                case 25 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1024:6: ( TRUE )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1024:6: ( TRUE )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1025:1: TRUE
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameTRUEKeyword_1_0_24()); 
                    match(input,TRUE,FOLLOW_TRUE_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_02166); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameTRUEKeyword_1_0_24()); 

                    }


                    }
                    break;
                case 26 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1032:6: ( FALSE )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1032:6: ( FALSE )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1033:1: FALSE
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameFALSEKeyword_1_0_25()); 
                    match(input,FALSE,FOLLOW_FALSE_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_02186); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameFALSEKeyword_1_0_25()); 

                    }


                    }
                    break;
                case 27 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1040:6: ( CELL )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1040:6: ( CELL )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1041:1: CELL
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameCELLKeyword_1_0_26()); 
                    match(input,CELL,FOLLOW_CELL_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_02206); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameCELLKeyword_1_0_26()); 

                    }


                    }
                    break;
                case 28 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1048:6: ( CELL_1 )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1048:6: ( CELL_1 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1049:1: CELL_1
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameCELLKeyword_1_0_27()); 
                    match(input,CELL_1,FOLLOW_CELL_1_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_02226); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameCELLKeyword_1_0_27()); 

                    }


                    }
                    break;
                case 29 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1056:6: ( CARRY_RESET )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1056:6: ( CARRY_RESET )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1057:1: CARRY_RESET
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameCARRY_RESETKeyword_1_0_28()); 
                    match(input,CARRY_RESET,FOLLOW_CARRY_RESET_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_02246); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameCARRY_RESETKeyword_1_0_28()); 

                    }


                    }
                    break;
                case 30 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1064:6: ( CARRYSET )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1064:6: ( CARRYSET )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1065:1: CARRYSET
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameCARRYSETKeyword_1_0_29()); 
                    match(input,CARRYSET,FOLLOW_CARRYSET_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_02266); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameCARRYSETKeyword_1_0_29()); 

                    }


                    }
                    break;
                case 31 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1072:6: ( ABS )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1072:6: ( ABS )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1073:1: ABS
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameABSKeyword_1_0_30()); 
                    match(input,ABS,FOLLOW_ABS_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_02286); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameABSKeyword_1_0_30()); 

                    }


                    }
                    break;
                case 32 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1080:6: ( DABS )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1080:6: ( DABS )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1081:1: DABS
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameDABSKeyword_1_0_31()); 
                    match(input,DABS,FOLLOW_DABS_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_02306); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameDABSKeyword_1_0_31()); 

                    }


                    }
                    break;
                case 33 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1088:6: ( EXTEND )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1088:6: ( EXTEND )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1089:1: EXTEND
                    {
                     before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameEXTENDKeyword_1_0_32()); 
                    match(input,EXTEND,FOLLOW_EXTEND_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_02326); 
                     after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameEXTENDKeyword_1_0_32()); 

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
    // $ANTLR end "rule__IntrinsicArithmeticWords__NameAlternatives_1_0"


    // $ANTLR start "rule__Word__Alternatives"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1101:1: rule__Word__Alternatives : ( ( ruleIntrinsicStackWords ) | ( ruleIntrinsicMemoryWords ) | ( ruleIntrinsicArithmeticWords ) | ( ( rule__Word__NameAssignment_3 ) ) | ( ( rule__Word__NameAssignment_4 ) ) );
    public final void rule__Word__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1105:1: ( ( ruleIntrinsicStackWords ) | ( ruleIntrinsicMemoryWords ) | ( ruleIntrinsicArithmeticWords ) | ( ( rule__Word__NameAssignment_3 ) ) | ( ( rule__Word__NameAssignment_4 ) ) )
            int alt7=5;
            switch ( input.LA(1) ) {
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
                alt7=1;
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
                alt7=2;
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
                alt7=3;
                }
                break;
            case RULE_INT:
            case RULE_DOUBLE:
                {
                alt7=4;
                }
                break;
            case RULE_ID:
                {
                alt7=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1106:1: ( ruleIntrinsicStackWords )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1106:1: ( ruleIntrinsicStackWords )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1107:1: ruleIntrinsicStackWords
                    {
                     before(grammarAccess.getWordAccess().getIntrinsicStackWordsParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleIntrinsicStackWords_in_rule__Word__Alternatives2360);
                    ruleIntrinsicStackWords();

                    state._fsp--;

                     after(grammarAccess.getWordAccess().getIntrinsicStackWordsParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1112:6: ( ruleIntrinsicMemoryWords )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1112:6: ( ruleIntrinsicMemoryWords )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1113:1: ruleIntrinsicMemoryWords
                    {
                     before(grammarAccess.getWordAccess().getIntrinsicMemoryWordsParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleIntrinsicMemoryWords_in_rule__Word__Alternatives2377);
                    ruleIntrinsicMemoryWords();

                    state._fsp--;

                     after(grammarAccess.getWordAccess().getIntrinsicMemoryWordsParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1118:6: ( ruleIntrinsicArithmeticWords )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1118:6: ( ruleIntrinsicArithmeticWords )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1119:1: ruleIntrinsicArithmeticWords
                    {
                     before(grammarAccess.getWordAccess().getIntrinsicArithmeticWordsParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleIntrinsicArithmeticWords_in_rule__Word__Alternatives2394);
                    ruleIntrinsicArithmeticWords();

                    state._fsp--;

                     after(grammarAccess.getWordAccess().getIntrinsicArithmeticWordsParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1124:6: ( ( rule__Word__NameAssignment_3 ) )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1124:6: ( ( rule__Word__NameAssignment_3 ) )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1125:1: ( rule__Word__NameAssignment_3 )
                    {
                     before(grammarAccess.getWordAccess().getNameAssignment_3()); 
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1126:1: ( rule__Word__NameAssignment_3 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1126:2: rule__Word__NameAssignment_3
                    {
                    pushFollow(FOLLOW_rule__Word__NameAssignment_3_in_rule__Word__Alternatives2411);
                    rule__Word__NameAssignment_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getWordAccess().getNameAssignment_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1130:6: ( ( rule__Word__NameAssignment_4 ) )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1130:6: ( ( rule__Word__NameAssignment_4 ) )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1131:1: ( rule__Word__NameAssignment_4 )
                    {
                     before(grammarAccess.getWordAccess().getNameAssignment_4()); 
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1132:1: ( rule__Word__NameAssignment_4 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1132:2: rule__Word__NameAssignment_4
                    {
                    pushFollow(FOLLOW_rule__Word__NameAssignment_4_in_rule__Word__Alternatives2429);
                    rule__Word__NameAssignment_4();

                    state._fsp--;


                    }

                     after(grammarAccess.getWordAccess().getNameAssignment_4()); 

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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1143:1: rule__Function__Group__0 : rule__Function__Group__0__Impl rule__Function__Group__1 ;
    public final void rule__Function__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1147:1: ( rule__Function__Group__0__Impl rule__Function__Group__1 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1148:2: rule__Function__Group__0__Impl rule__Function__Group__1
            {
            pushFollow(FOLLOW_rule__Function__Group__0__Impl_in_rule__Function__Group__02460);
            rule__Function__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Function__Group__1_in_rule__Function__Group__02463);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1155:1: rule__Function__Group__0__Impl : ( Colon ) ;
    public final void rule__Function__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1159:1: ( ( Colon ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1160:1: ( Colon )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1160:1: ( Colon )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1161:1: Colon
            {
             before(grammarAccess.getFunctionAccess().getColonKeyword_0()); 
            match(input,Colon,FOLLOW_Colon_in_rule__Function__Group__0__Impl2491); 
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1174:1: rule__Function__Group__1 : rule__Function__Group__1__Impl rule__Function__Group__2 ;
    public final void rule__Function__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1178:1: ( rule__Function__Group__1__Impl rule__Function__Group__2 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1179:2: rule__Function__Group__1__Impl rule__Function__Group__2
            {
            pushFollow(FOLLOW_rule__Function__Group__1__Impl_in_rule__Function__Group__12522);
            rule__Function__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Function__Group__2_in_rule__Function__Group__12525);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1186:1: rule__Function__Group__1__Impl : ( ( rule__Function__NameAssignment_1 ) ) ;
    public final void rule__Function__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1190:1: ( ( ( rule__Function__NameAssignment_1 ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1191:1: ( ( rule__Function__NameAssignment_1 ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1191:1: ( ( rule__Function__NameAssignment_1 ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1192:1: ( rule__Function__NameAssignment_1 )
            {
             before(grammarAccess.getFunctionAccess().getNameAssignment_1()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1193:1: ( rule__Function__NameAssignment_1 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1193:2: rule__Function__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Function__NameAssignment_1_in_rule__Function__Group__1__Impl2552);
            rule__Function__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getFunctionAccess().getNameAssignment_1()); 

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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1203:1: rule__Function__Group__2 : rule__Function__Group__2__Impl rule__Function__Group__3 ;
    public final void rule__Function__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1207:1: ( rule__Function__Group__2__Impl rule__Function__Group__3 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1208:2: rule__Function__Group__2__Impl rule__Function__Group__3
            {
            pushFollow(FOLLOW_rule__Function__Group__2__Impl_in_rule__Function__Group__22582);
            rule__Function__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Function__Group__3_in_rule__Function__Group__22585);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1215:1: rule__Function__Group__2__Impl : ( ( rule__Function__WordsAssignment_2 )* ) ;
    public final void rule__Function__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1219:1: ( ( ( rule__Function__WordsAssignment_2 )* ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1220:1: ( ( rule__Function__WordsAssignment_2 )* )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1220:1: ( ( rule__Function__WordsAssignment_2 )* )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1221:1: ( rule__Function__WordsAssignment_2 )*
            {
             before(grammarAccess.getFunctionAccess().getWordsAssignment_2()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1222:1: ( rule__Function__WordsAssignment_2 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=CARRY_RESET && LA8_0<=UNPACK)||(LA8_0>=DROP_1 && LA8_0<=PlusSign)||(LA8_0>=HyphenMinus && LA8_0<=Solidus)||LA8_0==CommercialAt||(LA8_0>=RULE_INT && LA8_0<=RULE_ID)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1222:2: rule__Function__WordsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Function__WordsAssignment_2_in_rule__Function__Group__2__Impl2612);
            	    rule__Function__WordsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1232:1: rule__Function__Group__3 : rule__Function__Group__3__Impl ;
    public final void rule__Function__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1236:1: ( rule__Function__Group__3__Impl )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1237:2: rule__Function__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Function__Group__3__Impl_in_rule__Function__Group__32643);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1243:1: rule__Function__Group__3__Impl : ( Semicolon ) ;
    public final void rule__Function__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1247:1: ( ( Semicolon ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1248:1: ( Semicolon )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1248:1: ( Semicolon )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1249:1: Semicolon
            {
             before(grammarAccess.getFunctionAccess().getSemicolonKeyword_3()); 
            match(input,Semicolon,FOLLOW_Semicolon_in_rule__Function__Group__3__Impl2671); 
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1270:1: rule__Create__Group__0 : rule__Create__Group__0__Impl rule__Create__Group__1 ;
    public final void rule__Create__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1274:1: ( rule__Create__Group__0__Impl rule__Create__Group__1 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1275:2: rule__Create__Group__0__Impl rule__Create__Group__1
            {
            pushFollow(FOLLOW_rule__Create__Group__0__Impl_in_rule__Create__Group__02710);
            rule__Create__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Create__Group__1_in_rule__Create__Group__02713);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1282:1: rule__Create__Group__0__Impl : ( Create ) ;
    public final void rule__Create__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1286:1: ( ( Create ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1287:1: ( Create )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1287:1: ( Create )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1288:1: Create
            {
             before(grammarAccess.getCreateAccess().getCreateKeyword_0()); 
            match(input,Create,FOLLOW_Create_in_rule__Create__Group__0__Impl2741); 
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1301:1: rule__Create__Group__1 : rule__Create__Group__1__Impl rule__Create__Group__2 ;
    public final void rule__Create__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1305:1: ( rule__Create__Group__1__Impl rule__Create__Group__2 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1306:2: rule__Create__Group__1__Impl rule__Create__Group__2
            {
            pushFollow(FOLLOW_rule__Create__Group__1__Impl_in_rule__Create__Group__12772);
            rule__Create__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Create__Group__2_in_rule__Create__Group__12775);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1313:1: rule__Create__Group__1__Impl : ( ( rule__Create__NameAssignment_1 ) ) ;
    public final void rule__Create__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1317:1: ( ( ( rule__Create__NameAssignment_1 ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1318:1: ( ( rule__Create__NameAssignment_1 ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1318:1: ( ( rule__Create__NameAssignment_1 ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1319:1: ( rule__Create__NameAssignment_1 )
            {
             before(grammarAccess.getCreateAccess().getNameAssignment_1()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1320:1: ( rule__Create__NameAssignment_1 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1320:2: rule__Create__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Create__NameAssignment_1_in_rule__Create__Group__1__Impl2802);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1330:1: rule__Create__Group__2 : rule__Create__Group__2__Impl ;
    public final void rule__Create__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1334:1: ( rule__Create__Group__2__Impl )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1335:2: rule__Create__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Create__Group__2__Impl_in_rule__Create__Group__22832);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1341:1: rule__Create__Group__2__Impl : ( ( rule__Create__Group_2__0 )* ) ;
    public final void rule__Create__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1345:1: ( ( ( rule__Create__Group_2__0 )* ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1346:1: ( ( rule__Create__Group_2__0 )* )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1346:1: ( ( rule__Create__Group_2__0 )* )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1347:1: ( rule__Create__Group_2__0 )*
            {
             before(grammarAccess.getCreateAccess().getGroup_2()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1348:1: ( rule__Create__Group_2__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_INT) ) {
                    int LA9_2 = input.LA(2);

                    if ( (LA9_2==Comma) ) {
                        alt9=1;
                    }


                }
                else if ( (LA9_0==RULE_DOUBLE) ) {
                    int LA9_3 = input.LA(2);

                    if ( (LA9_3==Comma) ) {
                        alt9=1;
                    }


                }


                switch (alt9) {
            	case 1 :
            	    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1348:2: rule__Create__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Create__Group_2__0_in_rule__Create__Group__2__Impl2859);
            	    rule__Create__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1364:1: rule__Create__Group_2__0 : rule__Create__Group_2__0__Impl rule__Create__Group_2__1 ;
    public final void rule__Create__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1368:1: ( rule__Create__Group_2__0__Impl rule__Create__Group_2__1 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1369:2: rule__Create__Group_2__0__Impl rule__Create__Group_2__1
            {
            pushFollow(FOLLOW_rule__Create__Group_2__0__Impl_in_rule__Create__Group_2__02896);
            rule__Create__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Create__Group_2__1_in_rule__Create__Group_2__02899);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1376:1: rule__Create__Group_2__0__Impl : ( ( rule__Create__LitAssignment_2_0 ) ) ;
    public final void rule__Create__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1380:1: ( ( ( rule__Create__LitAssignment_2_0 ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1381:1: ( ( rule__Create__LitAssignment_2_0 ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1381:1: ( ( rule__Create__LitAssignment_2_0 ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1382:1: ( rule__Create__LitAssignment_2_0 )
            {
             before(grammarAccess.getCreateAccess().getLitAssignment_2_0()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1383:1: ( rule__Create__LitAssignment_2_0 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1383:2: rule__Create__LitAssignment_2_0
            {
            pushFollow(FOLLOW_rule__Create__LitAssignment_2_0_in_rule__Create__Group_2__0__Impl2926);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1393:1: rule__Create__Group_2__1 : rule__Create__Group_2__1__Impl ;
    public final void rule__Create__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1397:1: ( rule__Create__Group_2__1__Impl )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1398:2: rule__Create__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Create__Group_2__1__Impl_in_rule__Create__Group_2__12956);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1404:1: rule__Create__Group_2__1__Impl : ( Comma ) ;
    public final void rule__Create__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1408:1: ( ( Comma ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1409:1: ( Comma )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1409:1: ( Comma )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1410:1: Comma
            {
             before(grammarAccess.getCreateAccess().getCommaKeyword_2_1()); 
            match(input,Comma,FOLLOW_Comma_in_rule__Create__Group_2__1__Impl2984); 
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


    // $ANTLR start "rule__IntrinsicStackWords__Group__0"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1427:1: rule__IntrinsicStackWords__Group__0 : rule__IntrinsicStackWords__Group__0__Impl rule__IntrinsicStackWords__Group__1 ;
    public final void rule__IntrinsicStackWords__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1431:1: ( rule__IntrinsicStackWords__Group__0__Impl rule__IntrinsicStackWords__Group__1 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1432:2: rule__IntrinsicStackWords__Group__0__Impl rule__IntrinsicStackWords__Group__1
            {
            pushFollow(FOLLOW_rule__IntrinsicStackWords__Group__0__Impl_in_rule__IntrinsicStackWords__Group__03019);
            rule__IntrinsicStackWords__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IntrinsicStackWords__Group__1_in_rule__IntrinsicStackWords__Group__03022);
            rule__IntrinsicStackWords__Group__1();

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
    // $ANTLR end "rule__IntrinsicStackWords__Group__0"


    // $ANTLR start "rule__IntrinsicStackWords__Group__0__Impl"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1439:1: rule__IntrinsicStackWords__Group__0__Impl : ( () ) ;
    public final void rule__IntrinsicStackWords__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1443:1: ( ( () ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1444:1: ( () )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1444:1: ( () )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1445:1: ()
            {
             before(grammarAccess.getIntrinsicStackWordsAccess().getIntrinsicStackWordsAction_0()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1446:1: ()
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1448:1: 
            {
            }

             after(grammarAccess.getIntrinsicStackWordsAccess().getIntrinsicStackWordsAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntrinsicStackWords__Group__0__Impl"


    // $ANTLR start "rule__IntrinsicStackWords__Group__1"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1458:1: rule__IntrinsicStackWords__Group__1 : rule__IntrinsicStackWords__Group__1__Impl ;
    public final void rule__IntrinsicStackWords__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1462:1: ( rule__IntrinsicStackWords__Group__1__Impl )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1463:2: rule__IntrinsicStackWords__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__IntrinsicStackWords__Group__1__Impl_in_rule__IntrinsicStackWords__Group__13080);
            rule__IntrinsicStackWords__Group__1__Impl();

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
    // $ANTLR end "rule__IntrinsicStackWords__Group__1"


    // $ANTLR start "rule__IntrinsicStackWords__Group__1__Impl"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1469:1: rule__IntrinsicStackWords__Group__1__Impl : ( ( rule__IntrinsicStackWords__NameAssignment_1 ) ) ;
    public final void rule__IntrinsicStackWords__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1473:1: ( ( ( rule__IntrinsicStackWords__NameAssignment_1 ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1474:1: ( ( rule__IntrinsicStackWords__NameAssignment_1 ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1474:1: ( ( rule__IntrinsicStackWords__NameAssignment_1 ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1475:1: ( rule__IntrinsicStackWords__NameAssignment_1 )
            {
             before(grammarAccess.getIntrinsicStackWordsAccess().getNameAssignment_1()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1476:1: ( rule__IntrinsicStackWords__NameAssignment_1 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1476:2: rule__IntrinsicStackWords__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__IntrinsicStackWords__NameAssignment_1_in_rule__IntrinsicStackWords__Group__1__Impl3107);
            rule__IntrinsicStackWords__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getIntrinsicStackWordsAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__IntrinsicStackWords__Group__1__Impl"


    // $ANTLR start "rule__IntrinsicMemoryWords__Group__0"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1490:1: rule__IntrinsicMemoryWords__Group__0 : rule__IntrinsicMemoryWords__Group__0__Impl rule__IntrinsicMemoryWords__Group__1 ;
    public final void rule__IntrinsicMemoryWords__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1494:1: ( rule__IntrinsicMemoryWords__Group__0__Impl rule__IntrinsicMemoryWords__Group__1 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1495:2: rule__IntrinsicMemoryWords__Group__0__Impl rule__IntrinsicMemoryWords__Group__1
            {
            pushFollow(FOLLOW_rule__IntrinsicMemoryWords__Group__0__Impl_in_rule__IntrinsicMemoryWords__Group__03141);
            rule__IntrinsicMemoryWords__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IntrinsicMemoryWords__Group__1_in_rule__IntrinsicMemoryWords__Group__03144);
            rule__IntrinsicMemoryWords__Group__1();

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
    // $ANTLR end "rule__IntrinsicMemoryWords__Group__0"


    // $ANTLR start "rule__IntrinsicMemoryWords__Group__0__Impl"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1502:1: rule__IntrinsicMemoryWords__Group__0__Impl : ( () ) ;
    public final void rule__IntrinsicMemoryWords__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1506:1: ( ( () ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1507:1: ( () )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1507:1: ( () )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1508:1: ()
            {
             before(grammarAccess.getIntrinsicMemoryWordsAccess().getIntrinsicMemoryWordsAction_0()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1509:1: ()
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1511:1: 
            {
            }

             after(grammarAccess.getIntrinsicMemoryWordsAccess().getIntrinsicMemoryWordsAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntrinsicMemoryWords__Group__0__Impl"


    // $ANTLR start "rule__IntrinsicMemoryWords__Group__1"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1521:1: rule__IntrinsicMemoryWords__Group__1 : rule__IntrinsicMemoryWords__Group__1__Impl ;
    public final void rule__IntrinsicMemoryWords__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1525:1: ( rule__IntrinsicMemoryWords__Group__1__Impl )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1526:2: rule__IntrinsicMemoryWords__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__IntrinsicMemoryWords__Group__1__Impl_in_rule__IntrinsicMemoryWords__Group__13202);
            rule__IntrinsicMemoryWords__Group__1__Impl();

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
    // $ANTLR end "rule__IntrinsicMemoryWords__Group__1"


    // $ANTLR start "rule__IntrinsicMemoryWords__Group__1__Impl"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1532:1: rule__IntrinsicMemoryWords__Group__1__Impl : ( ( rule__IntrinsicMemoryWords__NameAssignment_1 ) ) ;
    public final void rule__IntrinsicMemoryWords__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1536:1: ( ( ( rule__IntrinsicMemoryWords__NameAssignment_1 ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1537:1: ( ( rule__IntrinsicMemoryWords__NameAssignment_1 ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1537:1: ( ( rule__IntrinsicMemoryWords__NameAssignment_1 ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1538:1: ( rule__IntrinsicMemoryWords__NameAssignment_1 )
            {
             before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameAssignment_1()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1539:1: ( rule__IntrinsicMemoryWords__NameAssignment_1 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1539:2: rule__IntrinsicMemoryWords__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__IntrinsicMemoryWords__NameAssignment_1_in_rule__IntrinsicMemoryWords__Group__1__Impl3229);
            rule__IntrinsicMemoryWords__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__IntrinsicMemoryWords__Group__1__Impl"


    // $ANTLR start "rule__IntrinsicArithmeticWords__Group__0"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1553:1: rule__IntrinsicArithmeticWords__Group__0 : rule__IntrinsicArithmeticWords__Group__0__Impl rule__IntrinsicArithmeticWords__Group__1 ;
    public final void rule__IntrinsicArithmeticWords__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1557:1: ( rule__IntrinsicArithmeticWords__Group__0__Impl rule__IntrinsicArithmeticWords__Group__1 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1558:2: rule__IntrinsicArithmeticWords__Group__0__Impl rule__IntrinsicArithmeticWords__Group__1
            {
            pushFollow(FOLLOW_rule__IntrinsicArithmeticWords__Group__0__Impl_in_rule__IntrinsicArithmeticWords__Group__03263);
            rule__IntrinsicArithmeticWords__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IntrinsicArithmeticWords__Group__1_in_rule__IntrinsicArithmeticWords__Group__03266);
            rule__IntrinsicArithmeticWords__Group__1();

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
    // $ANTLR end "rule__IntrinsicArithmeticWords__Group__0"


    // $ANTLR start "rule__IntrinsicArithmeticWords__Group__0__Impl"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1565:1: rule__IntrinsicArithmeticWords__Group__0__Impl : ( () ) ;
    public final void rule__IntrinsicArithmeticWords__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1569:1: ( ( () ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1570:1: ( () )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1570:1: ( () )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1571:1: ()
            {
             before(grammarAccess.getIntrinsicArithmeticWordsAccess().getIntrinsicArithmeticWordsAction_0()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1572:1: ()
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1574:1: 
            {
            }

             after(grammarAccess.getIntrinsicArithmeticWordsAccess().getIntrinsicArithmeticWordsAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntrinsicArithmeticWords__Group__0__Impl"


    // $ANTLR start "rule__IntrinsicArithmeticWords__Group__1"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1584:1: rule__IntrinsicArithmeticWords__Group__1 : rule__IntrinsicArithmeticWords__Group__1__Impl ;
    public final void rule__IntrinsicArithmeticWords__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1588:1: ( rule__IntrinsicArithmeticWords__Group__1__Impl )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1589:2: rule__IntrinsicArithmeticWords__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__IntrinsicArithmeticWords__Group__1__Impl_in_rule__IntrinsicArithmeticWords__Group__13324);
            rule__IntrinsicArithmeticWords__Group__1__Impl();

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
    // $ANTLR end "rule__IntrinsicArithmeticWords__Group__1"


    // $ANTLR start "rule__IntrinsicArithmeticWords__Group__1__Impl"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1595:1: rule__IntrinsicArithmeticWords__Group__1__Impl : ( ( rule__IntrinsicArithmeticWords__NameAssignment_1 ) ) ;
    public final void rule__IntrinsicArithmeticWords__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1599:1: ( ( ( rule__IntrinsicArithmeticWords__NameAssignment_1 ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1600:1: ( ( rule__IntrinsicArithmeticWords__NameAssignment_1 ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1600:1: ( ( rule__IntrinsicArithmeticWords__NameAssignment_1 ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1601:1: ( rule__IntrinsicArithmeticWords__NameAssignment_1 )
            {
             before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameAssignment_1()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1602:1: ( rule__IntrinsicArithmeticWords__NameAssignment_1 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1602:2: rule__IntrinsicArithmeticWords__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__IntrinsicArithmeticWords__NameAssignment_1_in_rule__IntrinsicArithmeticWords__Group__1__Impl3351);
            rule__IntrinsicArithmeticWords__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__IntrinsicArithmeticWords__Group__1__Impl"


    // $ANTLR start "rule__Forth__InstructionsAssignment"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1617:1: rule__Forth__InstructionsAssignment : ( ruleGlobalInstruction ) ;
    public final void rule__Forth__InstructionsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1621:1: ( ( ruleGlobalInstruction ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1622:1: ( ruleGlobalInstruction )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1622:1: ( ruleGlobalInstruction )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1623:1: ruleGlobalInstruction
            {
             before(grammarAccess.getForthAccess().getInstructionsGlobalInstructionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleGlobalInstruction_in_rule__Forth__InstructionsAssignment3390);
            ruleGlobalInstruction();

            state._fsp--;

             after(grammarAccess.getForthAccess().getInstructionsGlobalInstructionParserRuleCall_0()); 

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


    // $ANTLR start "rule__Function__NameAssignment_1"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1632:1: rule__Function__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Function__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1636:1: ( ( RULE_ID ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1637:1: ( RULE_ID )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1637:1: ( RULE_ID )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1638:1: RULE_ID
            {
             before(grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Function__NameAssignment_13421); 
             after(grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__Function__NameAssignment_1"


    // $ANTLR start "rule__Function__WordsAssignment_2"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1647:1: rule__Function__WordsAssignment_2 : ( ruleWord ) ;
    public final void rule__Function__WordsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1651:1: ( ( ruleWord ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1652:1: ( ruleWord )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1652:1: ( ruleWord )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1653:1: ruleWord
            {
             before(grammarAccess.getFunctionAccess().getWordsWordParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleWord_in_rule__Function__WordsAssignment_23452);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1662:1: rule__Create__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Create__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1666:1: ( ( RULE_ID ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1667:1: ( RULE_ID )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1667:1: ( RULE_ID )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1668:1: RULE_ID
            {
             before(grammarAccess.getCreateAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Create__NameAssignment_13483); 
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1677:1: rule__Create__LitAssignment_2_0 : ( ruleLITERAL ) ;
    public final void rule__Create__LitAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1681:1: ( ( ruleLITERAL ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1682:1: ( ruleLITERAL )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1682:1: ( ruleLITERAL )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1683:1: ruleLITERAL
            {
             before(grammarAccess.getCreateAccess().getLitLITERALParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_ruleLITERAL_in_rule__Create__LitAssignment_2_03514);
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


    // $ANTLR start "rule__IntrinsicStackWords__NameAssignment_1"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1692:1: rule__IntrinsicStackWords__NameAssignment_1 : ( ( rule__IntrinsicStackWords__NameAlternatives_1_0 ) ) ;
    public final void rule__IntrinsicStackWords__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1696:1: ( ( ( rule__IntrinsicStackWords__NameAlternatives_1_0 ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1697:1: ( ( rule__IntrinsicStackWords__NameAlternatives_1_0 ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1697:1: ( ( rule__IntrinsicStackWords__NameAlternatives_1_0 ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1698:1: ( rule__IntrinsicStackWords__NameAlternatives_1_0 )
            {
             before(grammarAccess.getIntrinsicStackWordsAccess().getNameAlternatives_1_0()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1699:1: ( rule__IntrinsicStackWords__NameAlternatives_1_0 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1699:2: rule__IntrinsicStackWords__NameAlternatives_1_0
            {
            pushFollow(FOLLOW_rule__IntrinsicStackWords__NameAlternatives_1_0_in_rule__IntrinsicStackWords__NameAssignment_13545);
            rule__IntrinsicStackWords__NameAlternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getIntrinsicStackWordsAccess().getNameAlternatives_1_0()); 

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
    // $ANTLR end "rule__IntrinsicStackWords__NameAssignment_1"


    // $ANTLR start "rule__IntrinsicMemoryWords__NameAssignment_1"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1708:1: rule__IntrinsicMemoryWords__NameAssignment_1 : ( ( rule__IntrinsicMemoryWords__NameAlternatives_1_0 ) ) ;
    public final void rule__IntrinsicMemoryWords__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1712:1: ( ( ( rule__IntrinsicMemoryWords__NameAlternatives_1_0 ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1713:1: ( ( rule__IntrinsicMemoryWords__NameAlternatives_1_0 ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1713:1: ( ( rule__IntrinsicMemoryWords__NameAlternatives_1_0 ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1714:1: ( rule__IntrinsicMemoryWords__NameAlternatives_1_0 )
            {
             before(grammarAccess.getIntrinsicMemoryWordsAccess().getNameAlternatives_1_0()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1715:1: ( rule__IntrinsicMemoryWords__NameAlternatives_1_0 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1715:2: rule__IntrinsicMemoryWords__NameAlternatives_1_0
            {
            pushFollow(FOLLOW_rule__IntrinsicMemoryWords__NameAlternatives_1_0_in_rule__IntrinsicMemoryWords__NameAssignment_13578);
            rule__IntrinsicMemoryWords__NameAlternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getIntrinsicMemoryWordsAccess().getNameAlternatives_1_0()); 

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
    // $ANTLR end "rule__IntrinsicMemoryWords__NameAssignment_1"


    // $ANTLR start "rule__IntrinsicArithmeticWords__NameAssignment_1"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1724:1: rule__IntrinsicArithmeticWords__NameAssignment_1 : ( ( rule__IntrinsicArithmeticWords__NameAlternatives_1_0 ) ) ;
    public final void rule__IntrinsicArithmeticWords__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1728:1: ( ( ( rule__IntrinsicArithmeticWords__NameAlternatives_1_0 ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1729:1: ( ( rule__IntrinsicArithmeticWords__NameAlternatives_1_0 ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1729:1: ( ( rule__IntrinsicArithmeticWords__NameAlternatives_1_0 ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1730:1: ( rule__IntrinsicArithmeticWords__NameAlternatives_1_0 )
            {
             before(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameAlternatives_1_0()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1731:1: ( rule__IntrinsicArithmeticWords__NameAlternatives_1_0 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1731:2: rule__IntrinsicArithmeticWords__NameAlternatives_1_0
            {
            pushFollow(FOLLOW_rule__IntrinsicArithmeticWords__NameAlternatives_1_0_in_rule__IntrinsicArithmeticWords__NameAssignment_13611);
            rule__IntrinsicArithmeticWords__NameAlternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getIntrinsicArithmeticWordsAccess().getNameAlternatives_1_0()); 

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
    // $ANTLR end "rule__IntrinsicArithmeticWords__NameAssignment_1"


    // $ANTLR start "rule__Word__NameAssignment_3"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1740:1: rule__Word__NameAssignment_3 : ( ruleLITERAL ) ;
    public final void rule__Word__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1744:1: ( ( ruleLITERAL ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1745:1: ( ruleLITERAL )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1745:1: ( ruleLITERAL )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1746:1: ruleLITERAL
            {
             before(grammarAccess.getWordAccess().getNameLITERALParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleLITERAL_in_rule__Word__NameAssignment_33644);
            ruleLITERAL();

            state._fsp--;

             after(grammarAccess.getWordAccess().getNameLITERALParserRuleCall_3_0()); 

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
    // $ANTLR end "rule__Word__NameAssignment_3"


    // $ANTLR start "rule__Word__NameAssignment_4"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1755:1: rule__Word__NameAssignment_4 : ( RULE_ID ) ;
    public final void rule__Word__NameAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1759:1: ( ( RULE_ID ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1760:1: ( RULE_ID )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1760:1: ( RULE_ID )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:1761:1: RULE_ID
            {
             before(grammarAccess.getWordAccess().getNameIDTerminalRuleCall_4_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Word__NameAssignment_43675); 
             after(grammarAccess.getWordAccess().getNameIDTerminalRuleCall_4_0()); 

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

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleForth_in_entryRuleForth54 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleForth61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Forth__InstructionsAssignment_in_ruleForth91 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF2L,0x000000001C2EFFFFL});
    public static final BitSet FOLLOW_ruleGlobalInstruction_in_entryRuleGlobalInstruction119 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGlobalInstruction126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GlobalInstruction__Alternatives_in_ruleGlobalInstruction156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_entryRuleFunction183 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunction190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__0_in_ruleFunction220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreate_in_entryRuleCreate247 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCreate254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Create__Group__0_in_ruleCreate284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLITERAL_in_entryRuleLITERAL311 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLITERAL318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LITERAL__Alternatives_in_ruleLITERAL348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntrinsicStackWords_in_entryRuleIntrinsicStackWords375 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntrinsicStackWords382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntrinsicStackWords__Group__0_in_ruleIntrinsicStackWords412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntrinsicMemoryWords_in_entryRuleIntrinsicMemoryWords439 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntrinsicMemoryWords446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntrinsicMemoryWords__Group__0_in_ruleIntrinsicMemoryWords476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntrinsicArithmeticWords_in_entryRuleIntrinsicArithmeticWords503 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntrinsicArithmeticWords510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntrinsicArithmeticWords__Group__0_in_ruleIntrinsicArithmeticWords540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWord_in_entryRuleWord567 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWord574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Word__Alternatives_in_ruleWord604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreate_in_rule__GlobalInstruction__Alternatives640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_rule__GlobalInstruction__Alternatives657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWord_in_rule__GlobalInstruction__Alternatives674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__LITERAL__Alternatives706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOUBLE_in_rule__LITERAL__Alternatives723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CLEAR_in_rule__IntrinsicStackWords__NameAlternatives_1_0756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_rule__IntrinsicStackWords__NameAlternatives_1_0776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DUP_in_rule__IntrinsicStackWords__NameAlternatives_1_0796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DUP_2_in_rule__IntrinsicStackWords__NameAlternatives_1_0816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SWAP_in_rule__IntrinsicStackWords__NameAlternatives_1_0836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NIP_in_rule__IntrinsicStackWords__NameAlternatives_1_0856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OVER_in_rule__IntrinsicStackWords__NameAlternatives_1_0876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROT_in_rule__IntrinsicStackWords__NameAlternatives_1_0896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROT_1_in_rule__IntrinsicStackWords__NameAlternatives_1_0916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUCK_in_rule__IntrinsicStackWords__NameAlternatives_1_0936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNDER_in_rule__IntrinsicStackWords__NameAlternatives_1_0956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_1_in_rule__IntrinsicStackWords__NameAlternatives_1_0976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DUP_1_in_rule__IntrinsicStackWords__NameAlternatives_1_0996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SWAP_1_in_rule__IntrinsicStackWords__NameAlternatives_1_01016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OVER_1_in_rule__IntrinsicStackWords__NameAlternatives_1_01036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RCLEAR_in_rule__IntrinsicStackWords__NameAlternatives_1_01056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_R_1_in_rule__IntrinsicStackWords__NameAlternatives_1_01076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_R_2_in_rule__IntrinsicStackWords__NameAlternatives_1_01096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_R_in_rule__IntrinsicStackWords__NameAlternatives_1_01116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RDROP_in_rule__IntrinsicStackWords__NameAlternatives_1_01136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LD_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CommercialAt_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ST_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ExclamationMark_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitTwoCommercialAt_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitTwoExclamationMark_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LLD_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_L_1_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LST_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_L_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TLD_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_1_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TST_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ST_1_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PlusSignExclamationMark_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INC_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEC_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ON_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OFF_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ERASE_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILL_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COUNT_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MOVE_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLACE_in_rule__IntrinsicMemoryWords__NameAlternatives_1_01651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PlusSign_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_01686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HyphenMinus_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_01706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Asterisk_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_01726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Solidus_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_01746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitTwoAsterisk_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_01766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitTwoSolidus_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_01786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_U2_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_01806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROR_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_01826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROR_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_01846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROL_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_01866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROL_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_01886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PACK_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_01906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNPACK_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_01926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHIFT_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_01946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASHIFT_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_01966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitTwoAsteriskAsterisk_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_01986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitZeroEqualsSign_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_02006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitZeroLessThanSignGreaterThanSign_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_02026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitZeroLessThanSign_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_02046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_D0_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_02066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEGATE_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_02086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DNEGATE_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_02106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitOnePlusSign_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_02126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitOneHyphenMinus_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_02146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_02166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_02186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CELL_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_02206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CELL_1_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_02226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CARRY_RESET_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_02246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CARRYSET_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_02266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ABS_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_02286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DABS_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_02306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXTEND_in_rule__IntrinsicArithmeticWords__NameAlternatives_1_02326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntrinsicStackWords_in_rule__Word__Alternatives2360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntrinsicMemoryWords_in_rule__Word__Alternatives2377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntrinsicArithmeticWords_in_rule__Word__Alternatives2394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Word__NameAssignment_3_in_rule__Word__Alternatives2411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Word__NameAssignment_4_in_rule__Word__Alternatives2429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__0__Impl_in_rule__Function__Group__02460 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_rule__Function__Group__1_in_rule__Function__Group__02463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Colon_in_rule__Function__Group__0__Impl2491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__1__Impl_in_rule__Function__Group__12522 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000001C3EFFFFL});
    public static final BitSet FOLLOW_rule__Function__Group__2_in_rule__Function__Group__12525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__NameAssignment_1_in_rule__Function__Group__1__Impl2552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__2__Impl_in_rule__Function__Group__22582 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000001C3EFFFFL});
    public static final BitSet FOLLOW_rule__Function__Group__3_in_rule__Function__Group__22585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__WordsAssignment_2_in_rule__Function__Group__2__Impl2612 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF2L,0x000000001C2EFFFFL});
    public static final BitSet FOLLOW_rule__Function__Group__3__Impl_in_rule__Function__Group__32643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Semicolon_in_rule__Function__Group__3__Impl2671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Create__Group__0__Impl_in_rule__Create__Group__02710 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_rule__Create__Group__1_in_rule__Create__Group__02713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Create_in_rule__Create__Group__0__Impl2741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Create__Group__1__Impl_in_rule__Create__Group__12772 = new BitSet(new long[]{0x0000000000000000L,0x000000000C000000L});
    public static final BitSet FOLLOW_rule__Create__Group__2_in_rule__Create__Group__12775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Create__NameAssignment_1_in_rule__Create__Group__1__Impl2802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Create__Group__2__Impl_in_rule__Create__Group__22832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Create__Group_2__0_in_rule__Create__Group__2__Impl2859 = new BitSet(new long[]{0x0000000000000002L,0x000000000C000000L});
    public static final BitSet FOLLOW_rule__Create__Group_2__0__Impl_in_rule__Create__Group_2__02896 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Create__Group_2__1_in_rule__Create__Group_2__02899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Create__LitAssignment_2_0_in_rule__Create__Group_2__0__Impl2926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Create__Group_2__1__Impl_in_rule__Create__Group_2__12956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Comma_in_rule__Create__Group_2__1__Impl2984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntrinsicStackWords__Group__0__Impl_in_rule__IntrinsicStackWords__Group__03019 = new BitSet(new long[]{0x002220A89E84E400L,0x0000000000001108L});
    public static final BitSet FOLLOW_rule__IntrinsicStackWords__Group__1_in_rule__IntrinsicStackWords__Group__03022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntrinsicStackWords__Group__1__Impl_in_rule__IntrinsicStackWords__Group__13080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntrinsicStackWords__NameAssignment_1_in_rule__IntrinsicStackWords__Group__1__Impl3107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntrinsicMemoryWords__Group__0__Impl_in_rule__IntrinsicMemoryWords__Group__03141 = new BitSet(new long[]{0x84C5D10600580000L,0x0000000000202EF4L});
    public static final BitSet FOLLOW_rule__IntrinsicMemoryWords__Group__1_in_rule__IntrinsicMemoryWords__Group__03144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntrinsicMemoryWords__Group__1__Impl_in_rule__IntrinsicMemoryWords__Group__13202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntrinsicMemoryWords__NameAssignment_1_in_rule__IntrinsicMemoryWords__Group__1__Impl3229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntrinsicArithmeticWords__Group__0__Impl_in_rule__IntrinsicArithmeticWords__Group__03263 = new BitSet(new long[]{0x7B180E5161230BF0L,0x000000000006C003L});
    public static final BitSet FOLLOW_rule__IntrinsicArithmeticWords__Group__1_in_rule__IntrinsicArithmeticWords__Group__03266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntrinsicArithmeticWords__Group__1__Impl_in_rule__IntrinsicArithmeticWords__Group__13324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntrinsicArithmeticWords__NameAssignment_1_in_rule__IntrinsicArithmeticWords__Group__1__Impl3351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGlobalInstruction_in_rule__Forth__InstructionsAssignment3390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Function__NameAssignment_13421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWord_in_rule__Function__WordsAssignment_23452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Create__NameAssignment_13483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLITERAL_in_rule__Create__LitAssignment_2_03514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntrinsicStackWords__NameAlternatives_1_0_in_rule__IntrinsicStackWords__NameAssignment_13545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntrinsicMemoryWords__NameAlternatives_1_0_in_rule__IntrinsicMemoryWords__NameAssignment_13578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntrinsicArithmeticWords__NameAlternatives_1_0_in_rule__IntrinsicArithmeticWords__NameAssignment_13611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLITERAL_in_rule__Word__NameAssignment_33644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Word__NameAssignment_43675 = new BitSet(new long[]{0x0000000000000002L});

}