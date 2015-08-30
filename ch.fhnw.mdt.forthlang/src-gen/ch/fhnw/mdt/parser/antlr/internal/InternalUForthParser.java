package ch.fhnw.mdt.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import ch.fhnw.mdt.services.UForthGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUForthParser extends AbstractInternalAntlrParser {
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
    public String getGrammarFileName() { return "../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g"; }




    	private UForthGrammarAccess grammarAccess;
    	 	
    	public InternalUForthParser(TokenStream input, UForthGrammarAccess grammarAccess) {
    		this(input);
    		this.grammarAccess = grammarAccess;
    		registerRules(grammarAccess.getGrammar());
    	}
    	
    	@Override
    	protected String getFirstRuleName() {
    		return "Forth";	
    	} 
    	   	   	
    	@Override
    	protected UForthGrammarAccess getGrammarAccess() {
    		return grammarAccess;
    	}



    // $ANTLR start "entryRuleForth"
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:61:1: entryRuleForth returns [EObject current=null] : iv_ruleForth= ruleForth EOF ;
    public final EObject entryRuleForth() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForth = null;


        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:62:2: (iv_ruleForth= ruleForth EOF )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:63:2: iv_ruleForth= ruleForth EOF
            {
             newCompositeNode(grammarAccess.getForthRule()); 
            pushFollow(FOLLOW_ruleForth_in_entryRuleForth67);
            iv_ruleForth=ruleForth();

            state._fsp--;

             current =iv_ruleForth; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleForth77); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleForth"


    // $ANTLR start "ruleForth"
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:70:1: ruleForth returns [EObject current=null] : ( (lv_instructions_0_0= ruleInstruction ) )* ;
    public final EObject ruleForth() throws RecognitionException {
        EObject current = null;

        EObject lv_instructions_0_0 = null;


         enterRule(); 
            
        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:73:28: ( ( (lv_instructions_0_0= ruleInstruction ) )* )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:74:1: ( (lv_instructions_0_0= ruleInstruction ) )*
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:74:1: ( (lv_instructions_0_0= ruleInstruction ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=CARRY_RESET && LA1_0<=PlusSign)||(LA1_0>=HyphenMinus && LA1_0<=Colon)||LA1_0==CommercialAt||(LA1_0>=RULE_INT && LA1_0<=RULE_ID)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:75:1: (lv_instructions_0_0= ruleInstruction )
            	    {
            	    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:75:1: (lv_instructions_0_0= ruleInstruction )
            	    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:76:3: lv_instructions_0_0= ruleInstruction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getForthAccess().getInstructionsInstructionParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleInstruction_in_ruleForth122);
            	    lv_instructions_0_0=ruleInstruction();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getForthRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"instructions",
            	            		lv_instructions_0_0, 
            	            		"Instruction");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForth"


    // $ANTLR start "entryRuleInstruction"
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:100:1: entryRuleInstruction returns [EObject current=null] : iv_ruleInstruction= ruleInstruction EOF ;
    public final EObject entryRuleInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstruction = null;


        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:101:2: (iv_ruleInstruction= ruleInstruction EOF )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:102:2: iv_ruleInstruction= ruleInstruction EOF
            {
             newCompositeNode(grammarAccess.getInstructionRule()); 
            pushFollow(FOLLOW_ruleInstruction_in_entryRuleInstruction157);
            iv_ruleInstruction=ruleInstruction();

            state._fsp--;

             current =iv_ruleInstruction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstruction167); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInstruction"


    // $ANTLR start "ruleInstruction"
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:109:1: ruleInstruction returns [EObject current=null] : (this_Create_0= ruleCreate | this_Function_1= ruleFunction | this_Word_2= ruleWord ) ;
    public final EObject ruleInstruction() throws RecognitionException {
        EObject current = null;

        EObject this_Create_0 = null;

        EObject this_Function_1 = null;

        EObject this_Word_2 = null;


         enterRule(); 
            
        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:112:28: ( (this_Create_0= ruleCreate | this_Function_1= ruleFunction | this_Word_2= ruleWord ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:113:1: (this_Create_0= ruleCreate | this_Function_1= ruleFunction | this_Word_2= ruleWord )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:113:1: (this_Create_0= ruleCreate | this_Function_1= ruleFunction | this_Word_2= ruleWord )
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
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:114:5: this_Create_0= ruleCreate
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getCreateParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleCreate_in_ruleInstruction214);
                    this_Create_0=ruleCreate();

                    state._fsp--;


                            current = this_Create_0;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:124:5: this_Function_1= ruleFunction
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getFunctionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleFunction_in_ruleInstruction241);
                    this_Function_1=ruleFunction();

                    state._fsp--;


                            current = this_Function_1;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:134:5: this_Word_2= ruleWord
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getWordParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleWord_in_ruleInstruction268);
                    this_Word_2=ruleWord();

                    state._fsp--;


                            current = this_Word_2;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInstruction"


    // $ANTLR start "entryRuleFunction"
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:150:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:151:2: (iv_ruleFunction= ruleFunction EOF )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:152:2: iv_ruleFunction= ruleFunction EOF
            {
             newCompositeNode(grammarAccess.getFunctionRule()); 
            pushFollow(FOLLOW_ruleFunction_in_entryRuleFunction302);
            iv_ruleFunction=ruleFunction();

            state._fsp--;

             current =iv_ruleFunction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunction312); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:159:1: ruleFunction returns [EObject current=null] : (otherlv_0= Colon this_Word_1= ruleWord ( (lv_words_2_0= ruleWord ) )* otherlv_3= Semicolon ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject this_Word_1 = null;

        EObject lv_words_2_0 = null;


         enterRule(); 
            
        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:162:28: ( (otherlv_0= Colon this_Word_1= ruleWord ( (lv_words_2_0= ruleWord ) )* otherlv_3= Semicolon ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:163:1: (otherlv_0= Colon this_Word_1= ruleWord ( (lv_words_2_0= ruleWord ) )* otherlv_3= Semicolon )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:163:1: (otherlv_0= Colon this_Word_1= ruleWord ( (lv_words_2_0= ruleWord ) )* otherlv_3= Semicolon )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:164:2: otherlv_0= Colon this_Word_1= ruleWord ( (lv_words_2_0= ruleWord ) )* otherlv_3= Semicolon
            {
            otherlv_0=(Token)match(input,Colon,FOLLOW_Colon_in_ruleFunction350); 

                	newLeafNode(otherlv_0, grammarAccess.getFunctionAccess().getColonKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getFunctionAccess().getWordParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleWord_in_ruleFunction371);
            this_Word_1=ruleWord();

            state._fsp--;


                    current = this_Word_1;
                    afterParserOrEnumRuleCall();
                
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:177:1: ( (lv_words_2_0= ruleWord ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=CARRY_RESET && LA3_0<=UNPACK)||(LA3_0>=ZExit && LA3_0<=PlusSign)||(LA3_0>=HyphenMinus && LA3_0<=Solidus)||LA3_0==CommercialAt||(LA3_0>=RULE_INT && LA3_0<=RULE_ID)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:178:1: (lv_words_2_0= ruleWord )
            	    {
            	    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:178:1: (lv_words_2_0= ruleWord )
            	    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:179:3: lv_words_2_0= ruleWord
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getFunctionAccess().getWordsWordParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleWord_in_ruleFunction391);
            	    lv_words_2_0=ruleWord();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getFunctionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"words",
            	            		lv_words_2_0, 
            	            		"Word");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_3=(Token)match(input,Semicolon,FOLLOW_Semicolon_in_ruleFunction405); 

                	newLeafNode(otherlv_3, grammarAccess.getFunctionAccess().getSemicolonKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleCreate"
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:208:1: entryRuleCreate returns [EObject current=null] : iv_ruleCreate= ruleCreate EOF ;
    public final EObject entryRuleCreate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCreate = null;


        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:209:2: (iv_ruleCreate= ruleCreate EOF )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:210:2: iv_ruleCreate= ruleCreate EOF
            {
             newCompositeNode(grammarAccess.getCreateRule()); 
            pushFollow(FOLLOW_ruleCreate_in_entryRuleCreate439);
            iv_ruleCreate=ruleCreate();

            state._fsp--;

             current =iv_ruleCreate; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCreate449); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCreate"


    // $ANTLR start "ruleCreate"
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:217:1: ruleCreate returns [EObject current=null] : (otherlv_0= Create ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_lit_2_0= ruleLITERAL ) ) otherlv_3= Comma )* ) ;
    public final EObject ruleCreate() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_lit_2_0 = null;


         enterRule(); 
            
        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:220:28: ( (otherlv_0= Create ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_lit_2_0= ruleLITERAL ) ) otherlv_3= Comma )* ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:221:1: (otherlv_0= Create ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_lit_2_0= ruleLITERAL ) ) otherlv_3= Comma )* )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:221:1: (otherlv_0= Create ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_lit_2_0= ruleLITERAL ) ) otherlv_3= Comma )* )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:222:2: otherlv_0= Create ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_lit_2_0= ruleLITERAL ) ) otherlv_3= Comma )*
            {
            otherlv_0=(Token)match(input,Create,FOLLOW_Create_in_ruleCreate487); 

                	newLeafNode(otherlv_0, grammarAccess.getCreateAccess().getCreateKeyword_0());
                
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:226:1: ( (lv_name_1_0= RULE_ID ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:227:1: (lv_name_1_0= RULE_ID )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:227:1: (lv_name_1_0= RULE_ID )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:228:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCreate503); 

            			newLeafNode(lv_name_1_0, grammarAccess.getCreateAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCreateRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:244:2: ( ( (lv_lit_2_0= ruleLITERAL ) ) otherlv_3= Comma )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_INT) ) {
                    int LA4_2 = input.LA(2);

                    if ( (LA4_2==Comma) ) {
                        alt4=1;
                    }


                }
                else if ( (LA4_0==RULE_DOUBLE) ) {
                    int LA4_3 = input.LA(2);

                    if ( (LA4_3==Comma) ) {
                        alt4=1;
                    }


                }


                switch (alt4) {
            	case 1 :
            	    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:244:3: ( (lv_lit_2_0= ruleLITERAL ) ) otherlv_3= Comma
            	    {
            	    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:244:3: ( (lv_lit_2_0= ruleLITERAL ) )
            	    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:245:1: (lv_lit_2_0= ruleLITERAL )
            	    {
            	    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:245:1: (lv_lit_2_0= ruleLITERAL )
            	    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:246:3: lv_lit_2_0= ruleLITERAL
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCreateAccess().getLitLITERALParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleLITERAL_in_ruleCreate530);
            	    lv_lit_2_0=ruleLITERAL();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCreateRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"lit",
            	            		lv_lit_2_0, 
            	            		"LITERAL");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    otherlv_3=(Token)match(input,Comma,FOLLOW_Comma_in_ruleCreate543); 

            	        	newLeafNode(otherlv_3, grammarAccess.getCreateAccess().getCommaKeyword_2_1());
            	        

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCreate"


    // $ANTLR start "entryRuleLITERAL"
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:275:1: entryRuleLITERAL returns [String current=null] : iv_ruleLITERAL= ruleLITERAL EOF ;
    public final String entryRuleLITERAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLITERAL = null;


        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:276:1: (iv_ruleLITERAL= ruleLITERAL EOF )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:277:2: iv_ruleLITERAL= ruleLITERAL EOF
            {
             newCompositeNode(grammarAccess.getLITERALRule()); 
            pushFollow(FOLLOW_ruleLITERAL_in_entryRuleLITERAL580);
            iv_ruleLITERAL=ruleLITERAL();

            state._fsp--;

             current =iv_ruleLITERAL.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLITERAL591); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLITERAL"


    // $ANTLR start "ruleLITERAL"
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:284:1: ruleLITERAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | this_DOUBLE_1= RULE_DOUBLE ) ;
    public final AntlrDatatypeRuleToken ruleLITERAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token this_DOUBLE_1=null;

         enterRule(); 
            
        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:288:6: ( (this_INT_0= RULE_INT | this_DOUBLE_1= RULE_DOUBLE ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:289:1: (this_INT_0= RULE_INT | this_DOUBLE_1= RULE_DOUBLE )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:289:1: (this_INT_0= RULE_INT | this_DOUBLE_1= RULE_DOUBLE )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_INT) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_DOUBLE) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:289:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleLITERAL631); 

                    		current.merge(this_INT_0);
                        
                     
                        newLeafNode(this_INT_0, grammarAccess.getLITERALAccess().getINTTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:297:10: this_DOUBLE_1= RULE_DOUBLE
                    {
                    this_DOUBLE_1=(Token)match(input,RULE_DOUBLE,FOLLOW_RULE_DOUBLE_in_ruleLITERAL657); 

                    		current.merge(this_DOUBLE_1);
                        
                     
                        newLeafNode(this_DOUBLE_1, grammarAccess.getLITERALAccess().getDOUBLETerminalRuleCall_1()); 
                        

                    }
                    break;

            }


            }

             leaveRule();
                
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLITERAL"


    // $ANTLR start "entryRuleIntrinsicBranchWords"
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:312:1: entryRuleIntrinsicBranchWords returns [EObject current=null] : iv_ruleIntrinsicBranchWords= ruleIntrinsicBranchWords EOF ;
    public final EObject entryRuleIntrinsicBranchWords() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntrinsicBranchWords = null;


        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:313:2: (iv_ruleIntrinsicBranchWords= ruleIntrinsicBranchWords EOF )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:314:2: iv_ruleIntrinsicBranchWords= ruleIntrinsicBranchWords EOF
            {
             newCompositeNode(grammarAccess.getIntrinsicBranchWordsRule()); 
            pushFollow(FOLLOW_ruleIntrinsicBranchWords_in_entryRuleIntrinsicBranchWords701);
            iv_ruleIntrinsicBranchWords=ruleIntrinsicBranchWords();

            state._fsp--;

             current =iv_ruleIntrinsicBranchWords; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntrinsicBranchWords711); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntrinsicBranchWords"


    // $ANTLR start "ruleIntrinsicBranchWords"
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:321:1: ruleIntrinsicBranchWords returns [EObject current=null] : ( ( (lv_name_0_1= Jsr | lv_name_0_2= Branch | lv_name_0_3= Branch_2 | lv_name_0_4= Branch_1 | lv_name_0_5= SBranch | lv_name_0_6= NsBranch | lv_name_0_7= NcBranch | lv_name_0_8= NoBranch | lv_name_0_9= TorBranch | lv_name_0_10= ZExit | lv_name_0_11= NzExit ) ) ) ;
    public final EObject ruleIntrinsicBranchWords() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token lv_name_0_3=null;
        Token lv_name_0_4=null;
        Token lv_name_0_5=null;
        Token lv_name_0_6=null;
        Token lv_name_0_7=null;
        Token lv_name_0_8=null;
        Token lv_name_0_9=null;
        Token lv_name_0_10=null;
        Token lv_name_0_11=null;

         enterRule(); 
            
        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:324:28: ( ( ( (lv_name_0_1= Jsr | lv_name_0_2= Branch | lv_name_0_3= Branch_2 | lv_name_0_4= Branch_1 | lv_name_0_5= SBranch | lv_name_0_6= NsBranch | lv_name_0_7= NcBranch | lv_name_0_8= NoBranch | lv_name_0_9= TorBranch | lv_name_0_10= ZExit | lv_name_0_11= NzExit ) ) ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:325:1: ( ( (lv_name_0_1= Jsr | lv_name_0_2= Branch | lv_name_0_3= Branch_2 | lv_name_0_4= Branch_1 | lv_name_0_5= SBranch | lv_name_0_6= NsBranch | lv_name_0_7= NcBranch | lv_name_0_8= NoBranch | lv_name_0_9= TorBranch | lv_name_0_10= ZExit | lv_name_0_11= NzExit ) ) )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:325:1: ( ( (lv_name_0_1= Jsr | lv_name_0_2= Branch | lv_name_0_3= Branch_2 | lv_name_0_4= Branch_1 | lv_name_0_5= SBranch | lv_name_0_6= NsBranch | lv_name_0_7= NcBranch | lv_name_0_8= NoBranch | lv_name_0_9= TorBranch | lv_name_0_10= ZExit | lv_name_0_11= NzExit ) ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:326:1: ( (lv_name_0_1= Jsr | lv_name_0_2= Branch | lv_name_0_3= Branch_2 | lv_name_0_4= Branch_1 | lv_name_0_5= SBranch | lv_name_0_6= NsBranch | lv_name_0_7= NcBranch | lv_name_0_8= NoBranch | lv_name_0_9= TorBranch | lv_name_0_10= ZExit | lv_name_0_11= NzExit ) )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:326:1: ( (lv_name_0_1= Jsr | lv_name_0_2= Branch | lv_name_0_3= Branch_2 | lv_name_0_4= Branch_1 | lv_name_0_5= SBranch | lv_name_0_6= NsBranch | lv_name_0_7= NcBranch | lv_name_0_8= NoBranch | lv_name_0_9= TorBranch | lv_name_0_10= ZExit | lv_name_0_11= NzExit ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:327:1: (lv_name_0_1= Jsr | lv_name_0_2= Branch | lv_name_0_3= Branch_2 | lv_name_0_4= Branch_1 | lv_name_0_5= SBranch | lv_name_0_6= NsBranch | lv_name_0_7= NcBranch | lv_name_0_8= NoBranch | lv_name_0_9= TorBranch | lv_name_0_10= ZExit | lv_name_0_11= NzExit )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:327:1: (lv_name_0_1= Jsr | lv_name_0_2= Branch | lv_name_0_3= Branch_2 | lv_name_0_4= Branch_1 | lv_name_0_5= SBranch | lv_name_0_6= NsBranch | lv_name_0_7= NcBranch | lv_name_0_8= NoBranch | lv_name_0_9= TorBranch | lv_name_0_10= ZExit | lv_name_0_11= NzExit )
            int alt6=11;
            switch ( input.LA(1) ) {
            case Jsr:
                {
                alt6=1;
                }
                break;
            case Branch:
                {
                alt6=2;
                }
                break;
            case Branch_2:
                {
                alt6=3;
                }
                break;
            case Branch_1:
                {
                alt6=4;
                }
                break;
            case SBranch:
                {
                alt6=5;
                }
                break;
            case NsBranch:
                {
                alt6=6;
                }
                break;
            case NcBranch:
                {
                alt6=7;
                }
                break;
            case NoBranch:
                {
                alt6=8;
                }
                break;
            case TorBranch:
                {
                alt6=9;
                }
                break;
            case ZExit:
                {
                alt6=10;
                }
                break;
            case NzExit:
                {
                alt6=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:328:3: lv_name_0_1= Jsr
                    {
                    lv_name_0_1=(Token)match(input,Jsr,FOLLOW_Jsr_in_ruleIntrinsicBranchWords756); 

                            newLeafNode(lv_name_0_1, grammarAccess.getIntrinsicBranchWordsAccess().getNameJsrKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicBranchWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:341:8: lv_name_0_2= Branch
                    {
                    lv_name_0_2=(Token)match(input,Branch,FOLLOW_Branch_in_ruleIntrinsicBranchWords784); 

                            newLeafNode(lv_name_0_2, grammarAccess.getIntrinsicBranchWordsAccess().getName0BranchKeyword_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicBranchWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:354:8: lv_name_0_3= Branch_2
                    {
                    lv_name_0_3=(Token)match(input,Branch_2,FOLLOW_Branch_2_in_ruleIntrinsicBranchWords812); 

                            newLeafNode(lv_name_0_3, grammarAccess.getIntrinsicBranchWordsAccess().getName0BranchKeyword_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicBranchWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_3, null);
                    	    

                    }
                    break;
                case 4 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:367:8: lv_name_0_4= Branch_1
                    {
                    lv_name_0_4=(Token)match(input,Branch_1,FOLLOW_Branch_1_in_ruleIntrinsicBranchWords840); 

                            newLeafNode(lv_name_0_4, grammarAccess.getIntrinsicBranchWordsAccess().getNameBranchKeyword_0_3());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicBranchWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_4, null);
                    	    

                    }
                    break;
                case 5 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:380:8: lv_name_0_5= SBranch
                    {
                    lv_name_0_5=(Token)match(input,SBranch,FOLLOW_SBranch_in_ruleIntrinsicBranchWords868); 

                            newLeafNode(lv_name_0_5, grammarAccess.getIntrinsicBranchWordsAccess().getNameSBranchKeyword_0_4());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicBranchWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_5, null);
                    	    

                    }
                    break;
                case 6 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:393:8: lv_name_0_6= NsBranch
                    {
                    lv_name_0_6=(Token)match(input,NsBranch,FOLLOW_NsBranch_in_ruleIntrinsicBranchWords896); 

                            newLeafNode(lv_name_0_6, grammarAccess.getIntrinsicBranchWordsAccess().getNameNsBranchKeyword_0_5());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicBranchWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_6, null);
                    	    

                    }
                    break;
                case 7 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:406:8: lv_name_0_7= NcBranch
                    {
                    lv_name_0_7=(Token)match(input,NcBranch,FOLLOW_NcBranch_in_ruleIntrinsicBranchWords924); 

                            newLeafNode(lv_name_0_7, grammarAccess.getIntrinsicBranchWordsAccess().getNameNcBranchKeyword_0_6());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicBranchWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_7, null);
                    	    

                    }
                    break;
                case 8 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:419:8: lv_name_0_8= NoBranch
                    {
                    lv_name_0_8=(Token)match(input,NoBranch,FOLLOW_NoBranch_in_ruleIntrinsicBranchWords952); 

                            newLeafNode(lv_name_0_8, grammarAccess.getIntrinsicBranchWordsAccess().getNameNoBranchKeyword_0_7());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicBranchWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_8, null);
                    	    

                    }
                    break;
                case 9 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:432:8: lv_name_0_9= TorBranch
                    {
                    lv_name_0_9=(Token)match(input,TorBranch,FOLLOW_TorBranch_in_ruleIntrinsicBranchWords980); 

                            newLeafNode(lv_name_0_9, grammarAccess.getIntrinsicBranchWordsAccess().getNameTorBranchKeyword_0_8());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicBranchWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_9, null);
                    	    

                    }
                    break;
                case 10 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:445:8: lv_name_0_10= ZExit
                    {
                    lv_name_0_10=(Token)match(input,ZExit,FOLLOW_ZExit_in_ruleIntrinsicBranchWords1008); 

                            newLeafNode(lv_name_0_10, grammarAccess.getIntrinsicBranchWordsAccess().getNameZExitKeyword_0_9());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicBranchWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_10, null);
                    	    

                    }
                    break;
                case 11 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:458:8: lv_name_0_11= NzExit
                    {
                    lv_name_0_11=(Token)match(input,NzExit,FOLLOW_NzExit_in_ruleIntrinsicBranchWords1036); 

                            newLeafNode(lv_name_0_11, grammarAccess.getIntrinsicBranchWordsAccess().getNameNzExitKeyword_0_10());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicBranchWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_11, null);
                    	    

                    }
                    break;

            }


            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntrinsicBranchWords"


    // $ANTLR start "entryRuleIntrinsicStackWords"
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:482:1: entryRuleIntrinsicStackWords returns [EObject current=null] : iv_ruleIntrinsicStackWords= ruleIntrinsicStackWords EOF ;
    public final EObject entryRuleIntrinsicStackWords() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntrinsicStackWords = null;


        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:483:2: (iv_ruleIntrinsicStackWords= ruleIntrinsicStackWords EOF )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:484:2: iv_ruleIntrinsicStackWords= ruleIntrinsicStackWords EOF
            {
             newCompositeNode(grammarAccess.getIntrinsicStackWordsRule()); 
            pushFollow(FOLLOW_ruleIntrinsicStackWords_in_entryRuleIntrinsicStackWords1084);
            iv_ruleIntrinsicStackWords=ruleIntrinsicStackWords();

            state._fsp--;

             current =iv_ruleIntrinsicStackWords; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntrinsicStackWords1094); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntrinsicStackWords"


    // $ANTLR start "ruleIntrinsicStackWords"
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:491:1: ruleIntrinsicStackWords returns [EObject current=null] : ( ( (lv_name_0_1= CLEAR | lv_name_0_2= DROP | lv_name_0_3= DUP | lv_name_0_4= DUP_2 | lv_name_0_5= SWAP | lv_name_0_6= NIP | lv_name_0_7= OVER | lv_name_0_8= ROT | lv_name_0_9= ROT_1 | lv_name_0_10= TUCK | lv_name_0_11= UNDER | lv_name_0_12= DROP_1 | lv_name_0_13= DUP_1 | lv_name_0_14= SWAP_1 | lv_name_0_15= OVER_1 | lv_name_0_16= RCLEAR | lv_name_0_17= R_1 | lv_name_0_18= R_2 | lv_name_0_19= R | lv_name_0_20= RDROP ) ) ) ;
    public final EObject ruleIntrinsicStackWords() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token lv_name_0_3=null;
        Token lv_name_0_4=null;
        Token lv_name_0_5=null;
        Token lv_name_0_6=null;
        Token lv_name_0_7=null;
        Token lv_name_0_8=null;
        Token lv_name_0_9=null;
        Token lv_name_0_10=null;
        Token lv_name_0_11=null;
        Token lv_name_0_12=null;
        Token lv_name_0_13=null;
        Token lv_name_0_14=null;
        Token lv_name_0_15=null;
        Token lv_name_0_16=null;
        Token lv_name_0_17=null;
        Token lv_name_0_18=null;
        Token lv_name_0_19=null;
        Token lv_name_0_20=null;

         enterRule(); 
            
        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:494:28: ( ( ( (lv_name_0_1= CLEAR | lv_name_0_2= DROP | lv_name_0_3= DUP | lv_name_0_4= DUP_2 | lv_name_0_5= SWAP | lv_name_0_6= NIP | lv_name_0_7= OVER | lv_name_0_8= ROT | lv_name_0_9= ROT_1 | lv_name_0_10= TUCK | lv_name_0_11= UNDER | lv_name_0_12= DROP_1 | lv_name_0_13= DUP_1 | lv_name_0_14= SWAP_1 | lv_name_0_15= OVER_1 | lv_name_0_16= RCLEAR | lv_name_0_17= R_1 | lv_name_0_18= R_2 | lv_name_0_19= R | lv_name_0_20= RDROP ) ) ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:495:1: ( ( (lv_name_0_1= CLEAR | lv_name_0_2= DROP | lv_name_0_3= DUP | lv_name_0_4= DUP_2 | lv_name_0_5= SWAP | lv_name_0_6= NIP | lv_name_0_7= OVER | lv_name_0_8= ROT | lv_name_0_9= ROT_1 | lv_name_0_10= TUCK | lv_name_0_11= UNDER | lv_name_0_12= DROP_1 | lv_name_0_13= DUP_1 | lv_name_0_14= SWAP_1 | lv_name_0_15= OVER_1 | lv_name_0_16= RCLEAR | lv_name_0_17= R_1 | lv_name_0_18= R_2 | lv_name_0_19= R | lv_name_0_20= RDROP ) ) )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:495:1: ( ( (lv_name_0_1= CLEAR | lv_name_0_2= DROP | lv_name_0_3= DUP | lv_name_0_4= DUP_2 | lv_name_0_5= SWAP | lv_name_0_6= NIP | lv_name_0_7= OVER | lv_name_0_8= ROT | lv_name_0_9= ROT_1 | lv_name_0_10= TUCK | lv_name_0_11= UNDER | lv_name_0_12= DROP_1 | lv_name_0_13= DUP_1 | lv_name_0_14= SWAP_1 | lv_name_0_15= OVER_1 | lv_name_0_16= RCLEAR | lv_name_0_17= R_1 | lv_name_0_18= R_2 | lv_name_0_19= R | lv_name_0_20= RDROP ) ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:496:1: ( (lv_name_0_1= CLEAR | lv_name_0_2= DROP | lv_name_0_3= DUP | lv_name_0_4= DUP_2 | lv_name_0_5= SWAP | lv_name_0_6= NIP | lv_name_0_7= OVER | lv_name_0_8= ROT | lv_name_0_9= ROT_1 | lv_name_0_10= TUCK | lv_name_0_11= UNDER | lv_name_0_12= DROP_1 | lv_name_0_13= DUP_1 | lv_name_0_14= SWAP_1 | lv_name_0_15= OVER_1 | lv_name_0_16= RCLEAR | lv_name_0_17= R_1 | lv_name_0_18= R_2 | lv_name_0_19= R | lv_name_0_20= RDROP ) )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:496:1: ( (lv_name_0_1= CLEAR | lv_name_0_2= DROP | lv_name_0_3= DUP | lv_name_0_4= DUP_2 | lv_name_0_5= SWAP | lv_name_0_6= NIP | lv_name_0_7= OVER | lv_name_0_8= ROT | lv_name_0_9= ROT_1 | lv_name_0_10= TUCK | lv_name_0_11= UNDER | lv_name_0_12= DROP_1 | lv_name_0_13= DUP_1 | lv_name_0_14= SWAP_1 | lv_name_0_15= OVER_1 | lv_name_0_16= RCLEAR | lv_name_0_17= R_1 | lv_name_0_18= R_2 | lv_name_0_19= R | lv_name_0_20= RDROP ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:497:1: (lv_name_0_1= CLEAR | lv_name_0_2= DROP | lv_name_0_3= DUP | lv_name_0_4= DUP_2 | lv_name_0_5= SWAP | lv_name_0_6= NIP | lv_name_0_7= OVER | lv_name_0_8= ROT | lv_name_0_9= ROT_1 | lv_name_0_10= TUCK | lv_name_0_11= UNDER | lv_name_0_12= DROP_1 | lv_name_0_13= DUP_1 | lv_name_0_14= SWAP_1 | lv_name_0_15= OVER_1 | lv_name_0_16= RCLEAR | lv_name_0_17= R_1 | lv_name_0_18= R_2 | lv_name_0_19= R | lv_name_0_20= RDROP )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:497:1: (lv_name_0_1= CLEAR | lv_name_0_2= DROP | lv_name_0_3= DUP | lv_name_0_4= DUP_2 | lv_name_0_5= SWAP | lv_name_0_6= NIP | lv_name_0_7= OVER | lv_name_0_8= ROT | lv_name_0_9= ROT_1 | lv_name_0_10= TUCK | lv_name_0_11= UNDER | lv_name_0_12= DROP_1 | lv_name_0_13= DUP_1 | lv_name_0_14= SWAP_1 | lv_name_0_15= OVER_1 | lv_name_0_16= RCLEAR | lv_name_0_17= R_1 | lv_name_0_18= R_2 | lv_name_0_19= R | lv_name_0_20= RDROP )
            int alt7=20;
            switch ( input.LA(1) ) {
            case CLEAR:
                {
                alt7=1;
                }
                break;
            case DROP:
                {
                alt7=2;
                }
                break;
            case DUP:
                {
                alt7=3;
                }
                break;
            case DUP_2:
                {
                alt7=4;
                }
                break;
            case SWAP:
                {
                alt7=5;
                }
                break;
            case NIP:
                {
                alt7=6;
                }
                break;
            case OVER:
                {
                alt7=7;
                }
                break;
            case ROT:
                {
                alt7=8;
                }
                break;
            case ROT_1:
                {
                alt7=9;
                }
                break;
            case TUCK:
                {
                alt7=10;
                }
                break;
            case UNDER:
                {
                alt7=11;
                }
                break;
            case DROP_1:
                {
                alt7=12;
                }
                break;
            case DUP_1:
                {
                alt7=13;
                }
                break;
            case SWAP_1:
                {
                alt7=14;
                }
                break;
            case OVER_1:
                {
                alt7=15;
                }
                break;
            case RCLEAR:
                {
                alt7=16;
                }
                break;
            case R_1:
                {
                alt7=17;
                }
                break;
            case R_2:
                {
                alt7=18;
                }
                break;
            case R:
                {
                alt7=19;
                }
                break;
            case RDROP:
                {
                alt7=20;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:498:3: lv_name_0_1= CLEAR
                    {
                    lv_name_0_1=(Token)match(input,CLEAR,FOLLOW_CLEAR_in_ruleIntrinsicStackWords1139); 

                            newLeafNode(lv_name_0_1, grammarAccess.getIntrinsicStackWordsAccess().getNameCLEARKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:511:8: lv_name_0_2= DROP
                    {
                    lv_name_0_2=(Token)match(input,DROP,FOLLOW_DROP_in_ruleIntrinsicStackWords1167); 

                            newLeafNode(lv_name_0_2, grammarAccess.getIntrinsicStackWordsAccess().getNameDROPKeyword_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:524:8: lv_name_0_3= DUP
                    {
                    lv_name_0_3=(Token)match(input,DUP,FOLLOW_DUP_in_ruleIntrinsicStackWords1195); 

                            newLeafNode(lv_name_0_3, grammarAccess.getIntrinsicStackWordsAccess().getNameDUPKeyword_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_3, null);
                    	    

                    }
                    break;
                case 4 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:537:8: lv_name_0_4= DUP_2
                    {
                    lv_name_0_4=(Token)match(input,DUP_2,FOLLOW_DUP_2_in_ruleIntrinsicStackWords1223); 

                            newLeafNode(lv_name_0_4, grammarAccess.getIntrinsicStackWordsAccess().getNameDUPKeyword_0_3());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_4, null);
                    	    

                    }
                    break;
                case 5 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:550:8: lv_name_0_5= SWAP
                    {
                    lv_name_0_5=(Token)match(input,SWAP,FOLLOW_SWAP_in_ruleIntrinsicStackWords1251); 

                            newLeafNode(lv_name_0_5, grammarAccess.getIntrinsicStackWordsAccess().getNameSWAPKeyword_0_4());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_5, null);
                    	    

                    }
                    break;
                case 6 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:563:8: lv_name_0_6= NIP
                    {
                    lv_name_0_6=(Token)match(input,NIP,FOLLOW_NIP_in_ruleIntrinsicStackWords1279); 

                            newLeafNode(lv_name_0_6, grammarAccess.getIntrinsicStackWordsAccess().getNameNIPKeyword_0_5());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_6, null);
                    	    

                    }
                    break;
                case 7 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:576:8: lv_name_0_7= OVER
                    {
                    lv_name_0_7=(Token)match(input,OVER,FOLLOW_OVER_in_ruleIntrinsicStackWords1307); 

                            newLeafNode(lv_name_0_7, grammarAccess.getIntrinsicStackWordsAccess().getNameOVERKeyword_0_6());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_7, null);
                    	    

                    }
                    break;
                case 8 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:589:8: lv_name_0_8= ROT
                    {
                    lv_name_0_8=(Token)match(input,ROT,FOLLOW_ROT_in_ruleIntrinsicStackWords1335); 

                            newLeafNode(lv_name_0_8, grammarAccess.getIntrinsicStackWordsAccess().getNameROTKeyword_0_7());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_8, null);
                    	    

                    }
                    break;
                case 9 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:602:8: lv_name_0_9= ROT_1
                    {
                    lv_name_0_9=(Token)match(input,ROT_1,FOLLOW_ROT_1_in_ruleIntrinsicStackWords1363); 

                            newLeafNode(lv_name_0_9, grammarAccess.getIntrinsicStackWordsAccess().getNameROTKeyword_0_8());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_9, null);
                    	    

                    }
                    break;
                case 10 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:615:8: lv_name_0_10= TUCK
                    {
                    lv_name_0_10=(Token)match(input,TUCK,FOLLOW_TUCK_in_ruleIntrinsicStackWords1391); 

                            newLeafNode(lv_name_0_10, grammarAccess.getIntrinsicStackWordsAccess().getNameTUCKKeyword_0_9());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_10, null);
                    	    

                    }
                    break;
                case 11 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:628:8: lv_name_0_11= UNDER
                    {
                    lv_name_0_11=(Token)match(input,UNDER,FOLLOW_UNDER_in_ruleIntrinsicStackWords1419); 

                            newLeafNode(lv_name_0_11, grammarAccess.getIntrinsicStackWordsAccess().getNameUNDERKeyword_0_10());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_11, null);
                    	    

                    }
                    break;
                case 12 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:641:8: lv_name_0_12= DROP_1
                    {
                    lv_name_0_12=(Token)match(input,DROP_1,FOLLOW_DROP_1_in_ruleIntrinsicStackWords1447); 

                            newLeafNode(lv_name_0_12, grammarAccess.getIntrinsicStackWordsAccess().getName2DROPKeyword_0_11());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_12, null);
                    	    

                    }
                    break;
                case 13 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:654:8: lv_name_0_13= DUP_1
                    {
                    lv_name_0_13=(Token)match(input,DUP_1,FOLLOW_DUP_1_in_ruleIntrinsicStackWords1475); 

                            newLeafNode(lv_name_0_13, grammarAccess.getIntrinsicStackWordsAccess().getName2DUPKeyword_0_12());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_13, null);
                    	    

                    }
                    break;
                case 14 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:667:8: lv_name_0_14= SWAP_1
                    {
                    lv_name_0_14=(Token)match(input,SWAP_1,FOLLOW_SWAP_1_in_ruleIntrinsicStackWords1503); 

                            newLeafNode(lv_name_0_14, grammarAccess.getIntrinsicStackWordsAccess().getName2SWAPKeyword_0_13());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_14, null);
                    	    

                    }
                    break;
                case 15 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:680:8: lv_name_0_15= OVER_1
                    {
                    lv_name_0_15=(Token)match(input,OVER_1,FOLLOW_OVER_1_in_ruleIntrinsicStackWords1531); 

                            newLeafNode(lv_name_0_15, grammarAccess.getIntrinsicStackWordsAccess().getName2OVERKeyword_0_14());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_15, null);
                    	    

                    }
                    break;
                case 16 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:693:8: lv_name_0_16= RCLEAR
                    {
                    lv_name_0_16=(Token)match(input,RCLEAR,FOLLOW_RCLEAR_in_ruleIntrinsicStackWords1559); 

                            newLeafNode(lv_name_0_16, grammarAccess.getIntrinsicStackWordsAccess().getNameRCLEARKeyword_0_15());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_16, null);
                    	    

                    }
                    break;
                case 17 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:706:8: lv_name_0_17= R_1
                    {
                    lv_name_0_17=(Token)match(input,R_1,FOLLOW_R_1_in_ruleIntrinsicStackWords1587); 

                            newLeafNode(lv_name_0_17, grammarAccess.getIntrinsicStackWordsAccess().getNameRKeyword_0_16());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_17, null);
                    	    

                    }
                    break;
                case 18 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:719:8: lv_name_0_18= R_2
                    {
                    lv_name_0_18=(Token)match(input,R_2,FOLLOW_R_2_in_ruleIntrinsicStackWords1615); 

                            newLeafNode(lv_name_0_18, grammarAccess.getIntrinsicStackWordsAccess().getNameRKeyword_0_17());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_18, null);
                    	    

                    }
                    break;
                case 19 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:732:8: lv_name_0_19= R
                    {
                    lv_name_0_19=(Token)match(input,R,FOLLOW_R_in_ruleIntrinsicStackWords1643); 

                            newLeafNode(lv_name_0_19, grammarAccess.getIntrinsicStackWordsAccess().getNameRKeyword_0_18());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_19, null);
                    	    

                    }
                    break;
                case 20 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:745:8: lv_name_0_20= RDROP
                    {
                    lv_name_0_20=(Token)match(input,RDROP,FOLLOW_RDROP_in_ruleIntrinsicStackWords1671); 

                            newLeafNode(lv_name_0_20, grammarAccess.getIntrinsicStackWordsAccess().getNameRDROPKeyword_0_19());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_20, null);
                    	    

                    }
                    break;

            }


            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntrinsicStackWords"


    // $ANTLR start "entryRuleIntrinsicMemoryWords"
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:769:1: entryRuleIntrinsicMemoryWords returns [EObject current=null] : iv_ruleIntrinsicMemoryWords= ruleIntrinsicMemoryWords EOF ;
    public final EObject entryRuleIntrinsicMemoryWords() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntrinsicMemoryWords = null;


        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:770:2: (iv_ruleIntrinsicMemoryWords= ruleIntrinsicMemoryWords EOF )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:771:2: iv_ruleIntrinsicMemoryWords= ruleIntrinsicMemoryWords EOF
            {
             newCompositeNode(grammarAccess.getIntrinsicMemoryWordsRule()); 
            pushFollow(FOLLOW_ruleIntrinsicMemoryWords_in_entryRuleIntrinsicMemoryWords1719);
            iv_ruleIntrinsicMemoryWords=ruleIntrinsicMemoryWords();

            state._fsp--;

             current =iv_ruleIntrinsicMemoryWords; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntrinsicMemoryWords1729); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntrinsicMemoryWords"


    // $ANTLR start "ruleIntrinsicMemoryWords"
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:778:1: ruleIntrinsicMemoryWords returns [EObject current=null] : ( ( (lv_name_0_1= LD | lv_name_0_2= CommercialAt | lv_name_0_3= ST | lv_name_0_4= ExclamationMark | lv_name_0_5= DigitTwoCommercialAt | lv_name_0_6= DigitTwoExclamationMark | lv_name_0_7= LLD | lv_name_0_8= L_1 | lv_name_0_9= LST | lv_name_0_10= L | lv_name_0_11= TLD | lv_name_0_12= T_1 | lv_name_0_13= TST | lv_name_0_14= T | lv_name_0_15= ST_1 | lv_name_0_16= PlusSignExclamationMark | lv_name_0_17= INC | lv_name_0_18= DEC | lv_name_0_19= ON | lv_name_0_20= OFF | lv_name_0_21= ERASE | lv_name_0_22= FILL | lv_name_0_23= COUNT | lv_name_0_24= MOVE | lv_name_0_25= PLACE ) ) ) ;
    public final EObject ruleIntrinsicMemoryWords() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token lv_name_0_3=null;
        Token lv_name_0_4=null;
        Token lv_name_0_5=null;
        Token lv_name_0_6=null;
        Token lv_name_0_7=null;
        Token lv_name_0_8=null;
        Token lv_name_0_9=null;
        Token lv_name_0_10=null;
        Token lv_name_0_11=null;
        Token lv_name_0_12=null;
        Token lv_name_0_13=null;
        Token lv_name_0_14=null;
        Token lv_name_0_15=null;
        Token lv_name_0_16=null;
        Token lv_name_0_17=null;
        Token lv_name_0_18=null;
        Token lv_name_0_19=null;
        Token lv_name_0_20=null;
        Token lv_name_0_21=null;
        Token lv_name_0_22=null;
        Token lv_name_0_23=null;
        Token lv_name_0_24=null;
        Token lv_name_0_25=null;

         enterRule(); 
            
        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:781:28: ( ( ( (lv_name_0_1= LD | lv_name_0_2= CommercialAt | lv_name_0_3= ST | lv_name_0_4= ExclamationMark | lv_name_0_5= DigitTwoCommercialAt | lv_name_0_6= DigitTwoExclamationMark | lv_name_0_7= LLD | lv_name_0_8= L_1 | lv_name_0_9= LST | lv_name_0_10= L | lv_name_0_11= TLD | lv_name_0_12= T_1 | lv_name_0_13= TST | lv_name_0_14= T | lv_name_0_15= ST_1 | lv_name_0_16= PlusSignExclamationMark | lv_name_0_17= INC | lv_name_0_18= DEC | lv_name_0_19= ON | lv_name_0_20= OFF | lv_name_0_21= ERASE | lv_name_0_22= FILL | lv_name_0_23= COUNT | lv_name_0_24= MOVE | lv_name_0_25= PLACE ) ) ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:782:1: ( ( (lv_name_0_1= LD | lv_name_0_2= CommercialAt | lv_name_0_3= ST | lv_name_0_4= ExclamationMark | lv_name_0_5= DigitTwoCommercialAt | lv_name_0_6= DigitTwoExclamationMark | lv_name_0_7= LLD | lv_name_0_8= L_1 | lv_name_0_9= LST | lv_name_0_10= L | lv_name_0_11= TLD | lv_name_0_12= T_1 | lv_name_0_13= TST | lv_name_0_14= T | lv_name_0_15= ST_1 | lv_name_0_16= PlusSignExclamationMark | lv_name_0_17= INC | lv_name_0_18= DEC | lv_name_0_19= ON | lv_name_0_20= OFF | lv_name_0_21= ERASE | lv_name_0_22= FILL | lv_name_0_23= COUNT | lv_name_0_24= MOVE | lv_name_0_25= PLACE ) ) )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:782:1: ( ( (lv_name_0_1= LD | lv_name_0_2= CommercialAt | lv_name_0_3= ST | lv_name_0_4= ExclamationMark | lv_name_0_5= DigitTwoCommercialAt | lv_name_0_6= DigitTwoExclamationMark | lv_name_0_7= LLD | lv_name_0_8= L_1 | lv_name_0_9= LST | lv_name_0_10= L | lv_name_0_11= TLD | lv_name_0_12= T_1 | lv_name_0_13= TST | lv_name_0_14= T | lv_name_0_15= ST_1 | lv_name_0_16= PlusSignExclamationMark | lv_name_0_17= INC | lv_name_0_18= DEC | lv_name_0_19= ON | lv_name_0_20= OFF | lv_name_0_21= ERASE | lv_name_0_22= FILL | lv_name_0_23= COUNT | lv_name_0_24= MOVE | lv_name_0_25= PLACE ) ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:783:1: ( (lv_name_0_1= LD | lv_name_0_2= CommercialAt | lv_name_0_3= ST | lv_name_0_4= ExclamationMark | lv_name_0_5= DigitTwoCommercialAt | lv_name_0_6= DigitTwoExclamationMark | lv_name_0_7= LLD | lv_name_0_8= L_1 | lv_name_0_9= LST | lv_name_0_10= L | lv_name_0_11= TLD | lv_name_0_12= T_1 | lv_name_0_13= TST | lv_name_0_14= T | lv_name_0_15= ST_1 | lv_name_0_16= PlusSignExclamationMark | lv_name_0_17= INC | lv_name_0_18= DEC | lv_name_0_19= ON | lv_name_0_20= OFF | lv_name_0_21= ERASE | lv_name_0_22= FILL | lv_name_0_23= COUNT | lv_name_0_24= MOVE | lv_name_0_25= PLACE ) )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:783:1: ( (lv_name_0_1= LD | lv_name_0_2= CommercialAt | lv_name_0_3= ST | lv_name_0_4= ExclamationMark | lv_name_0_5= DigitTwoCommercialAt | lv_name_0_6= DigitTwoExclamationMark | lv_name_0_7= LLD | lv_name_0_8= L_1 | lv_name_0_9= LST | lv_name_0_10= L | lv_name_0_11= TLD | lv_name_0_12= T_1 | lv_name_0_13= TST | lv_name_0_14= T | lv_name_0_15= ST_1 | lv_name_0_16= PlusSignExclamationMark | lv_name_0_17= INC | lv_name_0_18= DEC | lv_name_0_19= ON | lv_name_0_20= OFF | lv_name_0_21= ERASE | lv_name_0_22= FILL | lv_name_0_23= COUNT | lv_name_0_24= MOVE | lv_name_0_25= PLACE ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:784:1: (lv_name_0_1= LD | lv_name_0_2= CommercialAt | lv_name_0_3= ST | lv_name_0_4= ExclamationMark | lv_name_0_5= DigitTwoCommercialAt | lv_name_0_6= DigitTwoExclamationMark | lv_name_0_7= LLD | lv_name_0_8= L_1 | lv_name_0_9= LST | lv_name_0_10= L | lv_name_0_11= TLD | lv_name_0_12= T_1 | lv_name_0_13= TST | lv_name_0_14= T | lv_name_0_15= ST_1 | lv_name_0_16= PlusSignExclamationMark | lv_name_0_17= INC | lv_name_0_18= DEC | lv_name_0_19= ON | lv_name_0_20= OFF | lv_name_0_21= ERASE | lv_name_0_22= FILL | lv_name_0_23= COUNT | lv_name_0_24= MOVE | lv_name_0_25= PLACE )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:784:1: (lv_name_0_1= LD | lv_name_0_2= CommercialAt | lv_name_0_3= ST | lv_name_0_4= ExclamationMark | lv_name_0_5= DigitTwoCommercialAt | lv_name_0_6= DigitTwoExclamationMark | lv_name_0_7= LLD | lv_name_0_8= L_1 | lv_name_0_9= LST | lv_name_0_10= L | lv_name_0_11= TLD | lv_name_0_12= T_1 | lv_name_0_13= TST | lv_name_0_14= T | lv_name_0_15= ST_1 | lv_name_0_16= PlusSignExclamationMark | lv_name_0_17= INC | lv_name_0_18= DEC | lv_name_0_19= ON | lv_name_0_20= OFF | lv_name_0_21= ERASE | lv_name_0_22= FILL | lv_name_0_23= COUNT | lv_name_0_24= MOVE | lv_name_0_25= PLACE )
            int alt8=25;
            switch ( input.LA(1) ) {
            case LD:
                {
                alt8=1;
                }
                break;
            case CommercialAt:
                {
                alt8=2;
                }
                break;
            case ST:
                {
                alt8=3;
                }
                break;
            case ExclamationMark:
                {
                alt8=4;
                }
                break;
            case DigitTwoCommercialAt:
                {
                alt8=5;
                }
                break;
            case DigitTwoExclamationMark:
                {
                alt8=6;
                }
                break;
            case LLD:
                {
                alt8=7;
                }
                break;
            case L_1:
                {
                alt8=8;
                }
                break;
            case LST:
                {
                alt8=9;
                }
                break;
            case L:
                {
                alt8=10;
                }
                break;
            case TLD:
                {
                alt8=11;
                }
                break;
            case T_1:
                {
                alt8=12;
                }
                break;
            case TST:
                {
                alt8=13;
                }
                break;
            case T:
                {
                alt8=14;
                }
                break;
            case ST_1:
                {
                alt8=15;
                }
                break;
            case PlusSignExclamationMark:
                {
                alt8=16;
                }
                break;
            case INC:
                {
                alt8=17;
                }
                break;
            case DEC:
                {
                alt8=18;
                }
                break;
            case ON:
                {
                alt8=19;
                }
                break;
            case OFF:
                {
                alt8=20;
                }
                break;
            case ERASE:
                {
                alt8=21;
                }
                break;
            case FILL:
                {
                alt8=22;
                }
                break;
            case COUNT:
                {
                alt8=23;
                }
                break;
            case MOVE:
                {
                alt8=24;
                }
                break;
            case PLACE:
                {
                alt8=25;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:785:3: lv_name_0_1= LD
                    {
                    lv_name_0_1=(Token)match(input,LD,FOLLOW_LD_in_ruleIntrinsicMemoryWords1774); 

                            newLeafNode(lv_name_0_1, grammarAccess.getIntrinsicMemoryWordsAccess().getNameLDKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:798:8: lv_name_0_2= CommercialAt
                    {
                    lv_name_0_2=(Token)match(input,CommercialAt,FOLLOW_CommercialAt_in_ruleIntrinsicMemoryWords1802); 

                            newLeafNode(lv_name_0_2, grammarAccess.getIntrinsicMemoryWordsAccess().getNameCommercialAtKeyword_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:811:8: lv_name_0_3= ST
                    {
                    lv_name_0_3=(Token)match(input,ST,FOLLOW_ST_in_ruleIntrinsicMemoryWords1830); 

                            newLeafNode(lv_name_0_3, grammarAccess.getIntrinsicMemoryWordsAccess().getNameSTKeyword_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_3, null);
                    	    

                    }
                    break;
                case 4 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:824:8: lv_name_0_4= ExclamationMark
                    {
                    lv_name_0_4=(Token)match(input,ExclamationMark,FOLLOW_ExclamationMark_in_ruleIntrinsicMemoryWords1858); 

                            newLeafNode(lv_name_0_4, grammarAccess.getIntrinsicMemoryWordsAccess().getNameExclamationMarkKeyword_0_3());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_4, null);
                    	    

                    }
                    break;
                case 5 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:837:8: lv_name_0_5= DigitTwoCommercialAt
                    {
                    lv_name_0_5=(Token)match(input,DigitTwoCommercialAt,FOLLOW_DigitTwoCommercialAt_in_ruleIntrinsicMemoryWords1886); 

                            newLeafNode(lv_name_0_5, grammarAccess.getIntrinsicMemoryWordsAccess().getName2Keyword_0_4());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_5, null);
                    	    

                    }
                    break;
                case 6 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:850:8: lv_name_0_6= DigitTwoExclamationMark
                    {
                    lv_name_0_6=(Token)match(input,DigitTwoExclamationMark,FOLLOW_DigitTwoExclamationMark_in_ruleIntrinsicMemoryWords1914); 

                            newLeafNode(lv_name_0_6, grammarAccess.getIntrinsicMemoryWordsAccess().getName2Keyword_0_5());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_6, null);
                    	    

                    }
                    break;
                case 7 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:863:8: lv_name_0_7= LLD
                    {
                    lv_name_0_7=(Token)match(input,LLD,FOLLOW_LLD_in_ruleIntrinsicMemoryWords1942); 

                            newLeafNode(lv_name_0_7, grammarAccess.getIntrinsicMemoryWordsAccess().getNameLLDKeyword_0_6());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_7, null);
                    	    

                    }
                    break;
                case 8 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:876:8: lv_name_0_8= L_1
                    {
                    lv_name_0_8=(Token)match(input,L_1,FOLLOW_L_1_in_ruleIntrinsicMemoryWords1970); 

                            newLeafNode(lv_name_0_8, grammarAccess.getIntrinsicMemoryWordsAccess().getNameLKeyword_0_7());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_8, null);
                    	    

                    }
                    break;
                case 9 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:889:8: lv_name_0_9= LST
                    {
                    lv_name_0_9=(Token)match(input,LST,FOLLOW_LST_in_ruleIntrinsicMemoryWords1998); 

                            newLeafNode(lv_name_0_9, grammarAccess.getIntrinsicMemoryWordsAccess().getNameLSTKeyword_0_8());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_9, null);
                    	    

                    }
                    break;
                case 10 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:902:8: lv_name_0_10= L
                    {
                    lv_name_0_10=(Token)match(input,L,FOLLOW_L_in_ruleIntrinsicMemoryWords2026); 

                            newLeafNode(lv_name_0_10, grammarAccess.getIntrinsicMemoryWordsAccess().getNameLKeyword_0_9());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_10, null);
                    	    

                    }
                    break;
                case 11 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:915:8: lv_name_0_11= TLD
                    {
                    lv_name_0_11=(Token)match(input,TLD,FOLLOW_TLD_in_ruleIntrinsicMemoryWords2054); 

                            newLeafNode(lv_name_0_11, grammarAccess.getIntrinsicMemoryWordsAccess().getNameTLDKeyword_0_10());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_11, null);
                    	    

                    }
                    break;
                case 12 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:928:8: lv_name_0_12= T_1
                    {
                    lv_name_0_12=(Token)match(input,T_1,FOLLOW_T_1_in_ruleIntrinsicMemoryWords2082); 

                            newLeafNode(lv_name_0_12, grammarAccess.getIntrinsicMemoryWordsAccess().getNameTKeyword_0_11());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_12, null);
                    	    

                    }
                    break;
                case 13 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:941:8: lv_name_0_13= TST
                    {
                    lv_name_0_13=(Token)match(input,TST,FOLLOW_TST_in_ruleIntrinsicMemoryWords2110); 

                            newLeafNode(lv_name_0_13, grammarAccess.getIntrinsicMemoryWordsAccess().getNameTSTKeyword_0_12());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_13, null);
                    	    

                    }
                    break;
                case 14 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:954:8: lv_name_0_14= T
                    {
                    lv_name_0_14=(Token)match(input,T,FOLLOW_T_in_ruleIntrinsicMemoryWords2138); 

                            newLeafNode(lv_name_0_14, grammarAccess.getIntrinsicMemoryWordsAccess().getNameTKeyword_0_13());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_14, null);
                    	    

                    }
                    break;
                case 15 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:967:8: lv_name_0_15= ST_1
                    {
                    lv_name_0_15=(Token)match(input,ST_1,FOLLOW_ST_1_in_ruleIntrinsicMemoryWords2166); 

                            newLeafNode(lv_name_0_15, grammarAccess.getIntrinsicMemoryWordsAccess().getNameSTKeyword_0_14());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_15, null);
                    	    

                    }
                    break;
                case 16 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:980:8: lv_name_0_16= PlusSignExclamationMark
                    {
                    lv_name_0_16=(Token)match(input,PlusSignExclamationMark,FOLLOW_PlusSignExclamationMark_in_ruleIntrinsicMemoryWords2194); 

                            newLeafNode(lv_name_0_16, grammarAccess.getIntrinsicMemoryWordsAccess().getNamePlusSignExclamationMarkKeyword_0_15());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_16, null);
                    	    

                    }
                    break;
                case 17 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:993:8: lv_name_0_17= INC
                    {
                    lv_name_0_17=(Token)match(input,INC,FOLLOW_INC_in_ruleIntrinsicMemoryWords2222); 

                            newLeafNode(lv_name_0_17, grammarAccess.getIntrinsicMemoryWordsAccess().getNameINCKeyword_0_16());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_17, null);
                    	    

                    }
                    break;
                case 18 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1006:8: lv_name_0_18= DEC
                    {
                    lv_name_0_18=(Token)match(input,DEC,FOLLOW_DEC_in_ruleIntrinsicMemoryWords2250); 

                            newLeafNode(lv_name_0_18, grammarAccess.getIntrinsicMemoryWordsAccess().getNameDECKeyword_0_17());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_18, null);
                    	    

                    }
                    break;
                case 19 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1019:8: lv_name_0_19= ON
                    {
                    lv_name_0_19=(Token)match(input,ON,FOLLOW_ON_in_ruleIntrinsicMemoryWords2278); 

                            newLeafNode(lv_name_0_19, grammarAccess.getIntrinsicMemoryWordsAccess().getNameONKeyword_0_18());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_19, null);
                    	    

                    }
                    break;
                case 20 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1032:8: lv_name_0_20= OFF
                    {
                    lv_name_0_20=(Token)match(input,OFF,FOLLOW_OFF_in_ruleIntrinsicMemoryWords2306); 

                            newLeafNode(lv_name_0_20, grammarAccess.getIntrinsicMemoryWordsAccess().getNameOFFKeyword_0_19());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_20, null);
                    	    

                    }
                    break;
                case 21 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1045:8: lv_name_0_21= ERASE
                    {
                    lv_name_0_21=(Token)match(input,ERASE,FOLLOW_ERASE_in_ruleIntrinsicMemoryWords2334); 

                            newLeafNode(lv_name_0_21, grammarAccess.getIntrinsicMemoryWordsAccess().getNameERASEKeyword_0_20());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_21, null);
                    	    

                    }
                    break;
                case 22 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1058:8: lv_name_0_22= FILL
                    {
                    lv_name_0_22=(Token)match(input,FILL,FOLLOW_FILL_in_ruleIntrinsicMemoryWords2362); 

                            newLeafNode(lv_name_0_22, grammarAccess.getIntrinsicMemoryWordsAccess().getNameFILLKeyword_0_21());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_22, null);
                    	    

                    }
                    break;
                case 23 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1071:8: lv_name_0_23= COUNT
                    {
                    lv_name_0_23=(Token)match(input,COUNT,FOLLOW_COUNT_in_ruleIntrinsicMemoryWords2390); 

                            newLeafNode(lv_name_0_23, grammarAccess.getIntrinsicMemoryWordsAccess().getNameCOUNTKeyword_0_22());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_23, null);
                    	    

                    }
                    break;
                case 24 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1084:8: lv_name_0_24= MOVE
                    {
                    lv_name_0_24=(Token)match(input,MOVE,FOLLOW_MOVE_in_ruleIntrinsicMemoryWords2418); 

                            newLeafNode(lv_name_0_24, grammarAccess.getIntrinsicMemoryWordsAccess().getNameMOVEKeyword_0_23());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_24, null);
                    	    

                    }
                    break;
                case 25 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1097:8: lv_name_0_25= PLACE
                    {
                    lv_name_0_25=(Token)match(input,PLACE,FOLLOW_PLACE_in_ruleIntrinsicMemoryWords2446); 

                            newLeafNode(lv_name_0_25, grammarAccess.getIntrinsicMemoryWordsAccess().getNamePLACEKeyword_0_24());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_25, null);
                    	    

                    }
                    break;

            }


            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntrinsicMemoryWords"


    // $ANTLR start "entryRuleIntrinsicArithmeticWords"
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1121:1: entryRuleIntrinsicArithmeticWords returns [EObject current=null] : iv_ruleIntrinsicArithmeticWords= ruleIntrinsicArithmeticWords EOF ;
    public final EObject entryRuleIntrinsicArithmeticWords() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntrinsicArithmeticWords = null;


        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1122:2: (iv_ruleIntrinsicArithmeticWords= ruleIntrinsicArithmeticWords EOF )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1123:2: iv_ruleIntrinsicArithmeticWords= ruleIntrinsicArithmeticWords EOF
            {
             newCompositeNode(grammarAccess.getIntrinsicArithmeticWordsRule()); 
            pushFollow(FOLLOW_ruleIntrinsicArithmeticWords_in_entryRuleIntrinsicArithmeticWords2494);
            iv_ruleIntrinsicArithmeticWords=ruleIntrinsicArithmeticWords();

            state._fsp--;

             current =iv_ruleIntrinsicArithmeticWords; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntrinsicArithmeticWords2504); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntrinsicArithmeticWords"


    // $ANTLR start "ruleIntrinsicArithmeticWords"
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1130:1: ruleIntrinsicArithmeticWords returns [EObject current=null] : ( ( (lv_name_0_1= PlusSign | lv_name_0_2= HyphenMinus | lv_name_0_3= Asterisk | lv_name_0_4= Solidus | lv_name_0_5= DigitTwoAsterisk | lv_name_0_6= DigitTwoSolidus | lv_name_0_7= U2 | lv_name_0_8= ROR | lv_name_0_9= DROR | lv_name_0_10= ROL | lv_name_0_11= DROL | lv_name_0_12= PACK | lv_name_0_13= UNPACK | lv_name_0_14= SHIFT | lv_name_0_15= ASHIFT | lv_name_0_16= DigitTwoAsteriskAsterisk | lv_name_0_17= DigitZeroEqualsSign | lv_name_0_18= DigitZeroLessThanSignGreaterThanSign | lv_name_0_19= DigitZeroLessThanSign | lv_name_0_20= D0 | lv_name_0_21= NEGATE | lv_name_0_22= DNEGATE | lv_name_0_23= DigitOnePlusSign | lv_name_0_24= DigitOneHyphenMinus | lv_name_0_25= TRUE | lv_name_0_26= FALSE | lv_name_0_27= CELL | lv_name_0_28= CELL_1 | lv_name_0_29= CARRY_RESET | lv_name_0_30= CARRYSET | lv_name_0_31= ABS | lv_name_0_32= DABS | lv_name_0_33= EXTEND ) ) ) ;
    public final EObject ruleIntrinsicArithmeticWords() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token lv_name_0_3=null;
        Token lv_name_0_4=null;
        Token lv_name_0_5=null;
        Token lv_name_0_6=null;
        Token lv_name_0_7=null;
        Token lv_name_0_8=null;
        Token lv_name_0_9=null;
        Token lv_name_0_10=null;
        Token lv_name_0_11=null;
        Token lv_name_0_12=null;
        Token lv_name_0_13=null;
        Token lv_name_0_14=null;
        Token lv_name_0_15=null;
        Token lv_name_0_16=null;
        Token lv_name_0_17=null;
        Token lv_name_0_18=null;
        Token lv_name_0_19=null;
        Token lv_name_0_20=null;
        Token lv_name_0_21=null;
        Token lv_name_0_22=null;
        Token lv_name_0_23=null;
        Token lv_name_0_24=null;
        Token lv_name_0_25=null;
        Token lv_name_0_26=null;
        Token lv_name_0_27=null;
        Token lv_name_0_28=null;
        Token lv_name_0_29=null;
        Token lv_name_0_30=null;
        Token lv_name_0_31=null;
        Token lv_name_0_32=null;
        Token lv_name_0_33=null;

         enterRule(); 
            
        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1133:28: ( ( ( (lv_name_0_1= PlusSign | lv_name_0_2= HyphenMinus | lv_name_0_3= Asterisk | lv_name_0_4= Solidus | lv_name_0_5= DigitTwoAsterisk | lv_name_0_6= DigitTwoSolidus | lv_name_0_7= U2 | lv_name_0_8= ROR | lv_name_0_9= DROR | lv_name_0_10= ROL | lv_name_0_11= DROL | lv_name_0_12= PACK | lv_name_0_13= UNPACK | lv_name_0_14= SHIFT | lv_name_0_15= ASHIFT | lv_name_0_16= DigitTwoAsteriskAsterisk | lv_name_0_17= DigitZeroEqualsSign | lv_name_0_18= DigitZeroLessThanSignGreaterThanSign | lv_name_0_19= DigitZeroLessThanSign | lv_name_0_20= D0 | lv_name_0_21= NEGATE | lv_name_0_22= DNEGATE | lv_name_0_23= DigitOnePlusSign | lv_name_0_24= DigitOneHyphenMinus | lv_name_0_25= TRUE | lv_name_0_26= FALSE | lv_name_0_27= CELL | lv_name_0_28= CELL_1 | lv_name_0_29= CARRY_RESET | lv_name_0_30= CARRYSET | lv_name_0_31= ABS | lv_name_0_32= DABS | lv_name_0_33= EXTEND ) ) ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1134:1: ( ( (lv_name_0_1= PlusSign | lv_name_0_2= HyphenMinus | lv_name_0_3= Asterisk | lv_name_0_4= Solidus | lv_name_0_5= DigitTwoAsterisk | lv_name_0_6= DigitTwoSolidus | lv_name_0_7= U2 | lv_name_0_8= ROR | lv_name_0_9= DROR | lv_name_0_10= ROL | lv_name_0_11= DROL | lv_name_0_12= PACK | lv_name_0_13= UNPACK | lv_name_0_14= SHIFT | lv_name_0_15= ASHIFT | lv_name_0_16= DigitTwoAsteriskAsterisk | lv_name_0_17= DigitZeroEqualsSign | lv_name_0_18= DigitZeroLessThanSignGreaterThanSign | lv_name_0_19= DigitZeroLessThanSign | lv_name_0_20= D0 | lv_name_0_21= NEGATE | lv_name_0_22= DNEGATE | lv_name_0_23= DigitOnePlusSign | lv_name_0_24= DigitOneHyphenMinus | lv_name_0_25= TRUE | lv_name_0_26= FALSE | lv_name_0_27= CELL | lv_name_0_28= CELL_1 | lv_name_0_29= CARRY_RESET | lv_name_0_30= CARRYSET | lv_name_0_31= ABS | lv_name_0_32= DABS | lv_name_0_33= EXTEND ) ) )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1134:1: ( ( (lv_name_0_1= PlusSign | lv_name_0_2= HyphenMinus | lv_name_0_3= Asterisk | lv_name_0_4= Solidus | lv_name_0_5= DigitTwoAsterisk | lv_name_0_6= DigitTwoSolidus | lv_name_0_7= U2 | lv_name_0_8= ROR | lv_name_0_9= DROR | lv_name_0_10= ROL | lv_name_0_11= DROL | lv_name_0_12= PACK | lv_name_0_13= UNPACK | lv_name_0_14= SHIFT | lv_name_0_15= ASHIFT | lv_name_0_16= DigitTwoAsteriskAsterisk | lv_name_0_17= DigitZeroEqualsSign | lv_name_0_18= DigitZeroLessThanSignGreaterThanSign | lv_name_0_19= DigitZeroLessThanSign | lv_name_0_20= D0 | lv_name_0_21= NEGATE | lv_name_0_22= DNEGATE | lv_name_0_23= DigitOnePlusSign | lv_name_0_24= DigitOneHyphenMinus | lv_name_0_25= TRUE | lv_name_0_26= FALSE | lv_name_0_27= CELL | lv_name_0_28= CELL_1 | lv_name_0_29= CARRY_RESET | lv_name_0_30= CARRYSET | lv_name_0_31= ABS | lv_name_0_32= DABS | lv_name_0_33= EXTEND ) ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1135:1: ( (lv_name_0_1= PlusSign | lv_name_0_2= HyphenMinus | lv_name_0_3= Asterisk | lv_name_0_4= Solidus | lv_name_0_5= DigitTwoAsterisk | lv_name_0_6= DigitTwoSolidus | lv_name_0_7= U2 | lv_name_0_8= ROR | lv_name_0_9= DROR | lv_name_0_10= ROL | lv_name_0_11= DROL | lv_name_0_12= PACK | lv_name_0_13= UNPACK | lv_name_0_14= SHIFT | lv_name_0_15= ASHIFT | lv_name_0_16= DigitTwoAsteriskAsterisk | lv_name_0_17= DigitZeroEqualsSign | lv_name_0_18= DigitZeroLessThanSignGreaterThanSign | lv_name_0_19= DigitZeroLessThanSign | lv_name_0_20= D0 | lv_name_0_21= NEGATE | lv_name_0_22= DNEGATE | lv_name_0_23= DigitOnePlusSign | lv_name_0_24= DigitOneHyphenMinus | lv_name_0_25= TRUE | lv_name_0_26= FALSE | lv_name_0_27= CELL | lv_name_0_28= CELL_1 | lv_name_0_29= CARRY_RESET | lv_name_0_30= CARRYSET | lv_name_0_31= ABS | lv_name_0_32= DABS | lv_name_0_33= EXTEND ) )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1135:1: ( (lv_name_0_1= PlusSign | lv_name_0_2= HyphenMinus | lv_name_0_3= Asterisk | lv_name_0_4= Solidus | lv_name_0_5= DigitTwoAsterisk | lv_name_0_6= DigitTwoSolidus | lv_name_0_7= U2 | lv_name_0_8= ROR | lv_name_0_9= DROR | lv_name_0_10= ROL | lv_name_0_11= DROL | lv_name_0_12= PACK | lv_name_0_13= UNPACK | lv_name_0_14= SHIFT | lv_name_0_15= ASHIFT | lv_name_0_16= DigitTwoAsteriskAsterisk | lv_name_0_17= DigitZeroEqualsSign | lv_name_0_18= DigitZeroLessThanSignGreaterThanSign | lv_name_0_19= DigitZeroLessThanSign | lv_name_0_20= D0 | lv_name_0_21= NEGATE | lv_name_0_22= DNEGATE | lv_name_0_23= DigitOnePlusSign | lv_name_0_24= DigitOneHyphenMinus | lv_name_0_25= TRUE | lv_name_0_26= FALSE | lv_name_0_27= CELL | lv_name_0_28= CELL_1 | lv_name_0_29= CARRY_RESET | lv_name_0_30= CARRYSET | lv_name_0_31= ABS | lv_name_0_32= DABS | lv_name_0_33= EXTEND ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1136:1: (lv_name_0_1= PlusSign | lv_name_0_2= HyphenMinus | lv_name_0_3= Asterisk | lv_name_0_4= Solidus | lv_name_0_5= DigitTwoAsterisk | lv_name_0_6= DigitTwoSolidus | lv_name_0_7= U2 | lv_name_0_8= ROR | lv_name_0_9= DROR | lv_name_0_10= ROL | lv_name_0_11= DROL | lv_name_0_12= PACK | lv_name_0_13= UNPACK | lv_name_0_14= SHIFT | lv_name_0_15= ASHIFT | lv_name_0_16= DigitTwoAsteriskAsterisk | lv_name_0_17= DigitZeroEqualsSign | lv_name_0_18= DigitZeroLessThanSignGreaterThanSign | lv_name_0_19= DigitZeroLessThanSign | lv_name_0_20= D0 | lv_name_0_21= NEGATE | lv_name_0_22= DNEGATE | lv_name_0_23= DigitOnePlusSign | lv_name_0_24= DigitOneHyphenMinus | lv_name_0_25= TRUE | lv_name_0_26= FALSE | lv_name_0_27= CELL | lv_name_0_28= CELL_1 | lv_name_0_29= CARRY_RESET | lv_name_0_30= CARRYSET | lv_name_0_31= ABS | lv_name_0_32= DABS | lv_name_0_33= EXTEND )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1136:1: (lv_name_0_1= PlusSign | lv_name_0_2= HyphenMinus | lv_name_0_3= Asterisk | lv_name_0_4= Solidus | lv_name_0_5= DigitTwoAsterisk | lv_name_0_6= DigitTwoSolidus | lv_name_0_7= U2 | lv_name_0_8= ROR | lv_name_0_9= DROR | lv_name_0_10= ROL | lv_name_0_11= DROL | lv_name_0_12= PACK | lv_name_0_13= UNPACK | lv_name_0_14= SHIFT | lv_name_0_15= ASHIFT | lv_name_0_16= DigitTwoAsteriskAsterisk | lv_name_0_17= DigitZeroEqualsSign | lv_name_0_18= DigitZeroLessThanSignGreaterThanSign | lv_name_0_19= DigitZeroLessThanSign | lv_name_0_20= D0 | lv_name_0_21= NEGATE | lv_name_0_22= DNEGATE | lv_name_0_23= DigitOnePlusSign | lv_name_0_24= DigitOneHyphenMinus | lv_name_0_25= TRUE | lv_name_0_26= FALSE | lv_name_0_27= CELL | lv_name_0_28= CELL_1 | lv_name_0_29= CARRY_RESET | lv_name_0_30= CARRYSET | lv_name_0_31= ABS | lv_name_0_32= DABS | lv_name_0_33= EXTEND )
            int alt9=33;
            switch ( input.LA(1) ) {
            case PlusSign:
                {
                alt9=1;
                }
                break;
            case HyphenMinus:
                {
                alt9=2;
                }
                break;
            case Asterisk:
                {
                alt9=3;
                }
                break;
            case Solidus:
                {
                alt9=4;
                }
                break;
            case DigitTwoAsterisk:
                {
                alt9=5;
                }
                break;
            case DigitTwoSolidus:
                {
                alt9=6;
                }
                break;
            case U2:
                {
                alt9=7;
                }
                break;
            case ROR:
                {
                alt9=8;
                }
                break;
            case DROR:
                {
                alt9=9;
                }
                break;
            case ROL:
                {
                alt9=10;
                }
                break;
            case DROL:
                {
                alt9=11;
                }
                break;
            case PACK:
                {
                alt9=12;
                }
                break;
            case UNPACK:
                {
                alt9=13;
                }
                break;
            case SHIFT:
                {
                alt9=14;
                }
                break;
            case ASHIFT:
                {
                alt9=15;
                }
                break;
            case DigitTwoAsteriskAsterisk:
                {
                alt9=16;
                }
                break;
            case DigitZeroEqualsSign:
                {
                alt9=17;
                }
                break;
            case DigitZeroLessThanSignGreaterThanSign:
                {
                alt9=18;
                }
                break;
            case DigitZeroLessThanSign:
                {
                alt9=19;
                }
                break;
            case D0:
                {
                alt9=20;
                }
                break;
            case NEGATE:
                {
                alt9=21;
                }
                break;
            case DNEGATE:
                {
                alt9=22;
                }
                break;
            case DigitOnePlusSign:
                {
                alt9=23;
                }
                break;
            case DigitOneHyphenMinus:
                {
                alt9=24;
                }
                break;
            case TRUE:
                {
                alt9=25;
                }
                break;
            case FALSE:
                {
                alt9=26;
                }
                break;
            case CELL:
                {
                alt9=27;
                }
                break;
            case CELL_1:
                {
                alt9=28;
                }
                break;
            case CARRY_RESET:
                {
                alt9=29;
                }
                break;
            case CARRYSET:
                {
                alt9=30;
                }
                break;
            case ABS:
                {
                alt9=31;
                }
                break;
            case DABS:
                {
                alt9=32;
                }
                break;
            case EXTEND:
                {
                alt9=33;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1137:3: lv_name_0_1= PlusSign
                    {
                    lv_name_0_1=(Token)match(input,PlusSign,FOLLOW_PlusSign_in_ruleIntrinsicArithmeticWords2549); 

                            newLeafNode(lv_name_0_1, grammarAccess.getIntrinsicArithmeticWordsAccess().getNamePlusSignKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1150:8: lv_name_0_2= HyphenMinus
                    {
                    lv_name_0_2=(Token)match(input,HyphenMinus,FOLLOW_HyphenMinus_in_ruleIntrinsicArithmeticWords2577); 

                            newLeafNode(lv_name_0_2, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameHyphenMinusKeyword_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1163:8: lv_name_0_3= Asterisk
                    {
                    lv_name_0_3=(Token)match(input,Asterisk,FOLLOW_Asterisk_in_ruleIntrinsicArithmeticWords2605); 

                            newLeafNode(lv_name_0_3, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameAsteriskKeyword_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_3, null);
                    	    

                    }
                    break;
                case 4 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1176:8: lv_name_0_4= Solidus
                    {
                    lv_name_0_4=(Token)match(input,Solidus,FOLLOW_Solidus_in_ruleIntrinsicArithmeticWords2633); 

                            newLeafNode(lv_name_0_4, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameSolidusKeyword_0_3());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_4, null);
                    	    

                    }
                    break;
                case 5 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1189:8: lv_name_0_5= DigitTwoAsterisk
                    {
                    lv_name_0_5=(Token)match(input,DigitTwoAsterisk,FOLLOW_DigitTwoAsterisk_in_ruleIntrinsicArithmeticWords2661); 

                            newLeafNode(lv_name_0_5, grammarAccess.getIntrinsicArithmeticWordsAccess().getName2Keyword_0_4());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_5, null);
                    	    

                    }
                    break;
                case 6 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1202:8: lv_name_0_6= DigitTwoSolidus
                    {
                    lv_name_0_6=(Token)match(input,DigitTwoSolidus,FOLLOW_DigitTwoSolidus_in_ruleIntrinsicArithmeticWords2689); 

                            newLeafNode(lv_name_0_6, grammarAccess.getIntrinsicArithmeticWordsAccess().getName2Keyword_0_5());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_6, null);
                    	    

                    }
                    break;
                case 7 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1215:8: lv_name_0_7= U2
                    {
                    lv_name_0_7=(Token)match(input,U2,FOLLOW_U2_in_ruleIntrinsicArithmeticWords2717); 

                            newLeafNode(lv_name_0_7, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameU2Keyword_0_6());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_7, null);
                    	    

                    }
                    break;
                case 8 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1228:8: lv_name_0_8= ROR
                    {
                    lv_name_0_8=(Token)match(input,ROR,FOLLOW_ROR_in_ruleIntrinsicArithmeticWords2745); 

                            newLeafNode(lv_name_0_8, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameRORKeyword_0_7());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_8, null);
                    	    

                    }
                    break;
                case 9 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1241:8: lv_name_0_9= DROR
                    {
                    lv_name_0_9=(Token)match(input,DROR,FOLLOW_DROR_in_ruleIntrinsicArithmeticWords2773); 

                            newLeafNode(lv_name_0_9, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameDRORKeyword_0_8());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_9, null);
                    	    

                    }
                    break;
                case 10 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1254:8: lv_name_0_10= ROL
                    {
                    lv_name_0_10=(Token)match(input,ROL,FOLLOW_ROL_in_ruleIntrinsicArithmeticWords2801); 

                            newLeafNode(lv_name_0_10, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameROLKeyword_0_9());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_10, null);
                    	    

                    }
                    break;
                case 11 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1267:8: lv_name_0_11= DROL
                    {
                    lv_name_0_11=(Token)match(input,DROL,FOLLOW_DROL_in_ruleIntrinsicArithmeticWords2829); 

                            newLeafNode(lv_name_0_11, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameDROLKeyword_0_10());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_11, null);
                    	    

                    }
                    break;
                case 12 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1280:8: lv_name_0_12= PACK
                    {
                    lv_name_0_12=(Token)match(input,PACK,FOLLOW_PACK_in_ruleIntrinsicArithmeticWords2857); 

                            newLeafNode(lv_name_0_12, grammarAccess.getIntrinsicArithmeticWordsAccess().getNamePACKKeyword_0_11());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_12, null);
                    	    

                    }
                    break;
                case 13 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1293:8: lv_name_0_13= UNPACK
                    {
                    lv_name_0_13=(Token)match(input,UNPACK,FOLLOW_UNPACK_in_ruleIntrinsicArithmeticWords2885); 

                            newLeafNode(lv_name_0_13, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameUNPACKKeyword_0_12());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_13, null);
                    	    

                    }
                    break;
                case 14 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1306:8: lv_name_0_14= SHIFT
                    {
                    lv_name_0_14=(Token)match(input,SHIFT,FOLLOW_SHIFT_in_ruleIntrinsicArithmeticWords2913); 

                            newLeafNode(lv_name_0_14, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameSHIFTKeyword_0_13());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_14, null);
                    	    

                    }
                    break;
                case 15 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1319:8: lv_name_0_15= ASHIFT
                    {
                    lv_name_0_15=(Token)match(input,ASHIFT,FOLLOW_ASHIFT_in_ruleIntrinsicArithmeticWords2941); 

                            newLeafNode(lv_name_0_15, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameASHIFTKeyword_0_14());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_15, null);
                    	    

                    }
                    break;
                case 16 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1332:8: lv_name_0_16= DigitTwoAsteriskAsterisk
                    {
                    lv_name_0_16=(Token)match(input,DigitTwoAsteriskAsterisk,FOLLOW_DigitTwoAsteriskAsterisk_in_ruleIntrinsicArithmeticWords2969); 

                            newLeafNode(lv_name_0_16, grammarAccess.getIntrinsicArithmeticWordsAccess().getName2Keyword_0_15());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_16, null);
                    	    

                    }
                    break;
                case 17 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1345:8: lv_name_0_17= DigitZeroEqualsSign
                    {
                    lv_name_0_17=(Token)match(input,DigitZeroEqualsSign,FOLLOW_DigitZeroEqualsSign_in_ruleIntrinsicArithmeticWords2997); 

                            newLeafNode(lv_name_0_17, grammarAccess.getIntrinsicArithmeticWordsAccess().getName0Keyword_0_16());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_17, null);
                    	    

                    }
                    break;
                case 18 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1358:8: lv_name_0_18= DigitZeroLessThanSignGreaterThanSign
                    {
                    lv_name_0_18=(Token)match(input,DigitZeroLessThanSignGreaterThanSign,FOLLOW_DigitZeroLessThanSignGreaterThanSign_in_ruleIntrinsicArithmeticWords3025); 

                            newLeafNode(lv_name_0_18, grammarAccess.getIntrinsicArithmeticWordsAccess().getName0Keyword_0_17());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_18, null);
                    	    

                    }
                    break;
                case 19 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1371:8: lv_name_0_19= DigitZeroLessThanSign
                    {
                    lv_name_0_19=(Token)match(input,DigitZeroLessThanSign,FOLLOW_DigitZeroLessThanSign_in_ruleIntrinsicArithmeticWords3053); 

                            newLeafNode(lv_name_0_19, grammarAccess.getIntrinsicArithmeticWordsAccess().getName0Keyword_0_18());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_19, null);
                    	    

                    }
                    break;
                case 20 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1384:8: lv_name_0_20= D0
                    {
                    lv_name_0_20=(Token)match(input,D0,FOLLOW_D0_in_ruleIntrinsicArithmeticWords3081); 

                            newLeafNode(lv_name_0_20, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameD0Keyword_0_19());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_20, null);
                    	    

                    }
                    break;
                case 21 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1397:8: lv_name_0_21= NEGATE
                    {
                    lv_name_0_21=(Token)match(input,NEGATE,FOLLOW_NEGATE_in_ruleIntrinsicArithmeticWords3109); 

                            newLeafNode(lv_name_0_21, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameNEGATEKeyword_0_20());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_21, null);
                    	    

                    }
                    break;
                case 22 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1410:8: lv_name_0_22= DNEGATE
                    {
                    lv_name_0_22=(Token)match(input,DNEGATE,FOLLOW_DNEGATE_in_ruleIntrinsicArithmeticWords3137); 

                            newLeafNode(lv_name_0_22, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameDNEGATEKeyword_0_21());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_22, null);
                    	    

                    }
                    break;
                case 23 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1423:8: lv_name_0_23= DigitOnePlusSign
                    {
                    lv_name_0_23=(Token)match(input,DigitOnePlusSign,FOLLOW_DigitOnePlusSign_in_ruleIntrinsicArithmeticWords3165); 

                            newLeafNode(lv_name_0_23, grammarAccess.getIntrinsicArithmeticWordsAccess().getName1Keyword_0_22());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_23, null);
                    	    

                    }
                    break;
                case 24 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1436:8: lv_name_0_24= DigitOneHyphenMinus
                    {
                    lv_name_0_24=(Token)match(input,DigitOneHyphenMinus,FOLLOW_DigitOneHyphenMinus_in_ruleIntrinsicArithmeticWords3193); 

                            newLeafNode(lv_name_0_24, grammarAccess.getIntrinsicArithmeticWordsAccess().getName1Keyword_0_23());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_24, null);
                    	    

                    }
                    break;
                case 25 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1449:8: lv_name_0_25= TRUE
                    {
                    lv_name_0_25=(Token)match(input,TRUE,FOLLOW_TRUE_in_ruleIntrinsicArithmeticWords3221); 

                            newLeafNode(lv_name_0_25, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameTRUEKeyword_0_24());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_25, null);
                    	    

                    }
                    break;
                case 26 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1462:8: lv_name_0_26= FALSE
                    {
                    lv_name_0_26=(Token)match(input,FALSE,FOLLOW_FALSE_in_ruleIntrinsicArithmeticWords3249); 

                            newLeafNode(lv_name_0_26, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameFALSEKeyword_0_25());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_26, null);
                    	    

                    }
                    break;
                case 27 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1475:8: lv_name_0_27= CELL
                    {
                    lv_name_0_27=(Token)match(input,CELL,FOLLOW_CELL_in_ruleIntrinsicArithmeticWords3277); 

                            newLeafNode(lv_name_0_27, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameCELLKeyword_0_26());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_27, null);
                    	    

                    }
                    break;
                case 28 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1488:8: lv_name_0_28= CELL_1
                    {
                    lv_name_0_28=(Token)match(input,CELL_1,FOLLOW_CELL_1_in_ruleIntrinsicArithmeticWords3305); 

                            newLeafNode(lv_name_0_28, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameCELLKeyword_0_27());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_28, null);
                    	    

                    }
                    break;
                case 29 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1501:8: lv_name_0_29= CARRY_RESET
                    {
                    lv_name_0_29=(Token)match(input,CARRY_RESET,FOLLOW_CARRY_RESET_in_ruleIntrinsicArithmeticWords3333); 

                            newLeafNode(lv_name_0_29, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameCARRY_RESETKeyword_0_28());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_29, null);
                    	    

                    }
                    break;
                case 30 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1514:8: lv_name_0_30= CARRYSET
                    {
                    lv_name_0_30=(Token)match(input,CARRYSET,FOLLOW_CARRYSET_in_ruleIntrinsicArithmeticWords3361); 

                            newLeafNode(lv_name_0_30, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameCARRYSETKeyword_0_29());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_30, null);
                    	    

                    }
                    break;
                case 31 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1527:8: lv_name_0_31= ABS
                    {
                    lv_name_0_31=(Token)match(input,ABS,FOLLOW_ABS_in_ruleIntrinsicArithmeticWords3389); 

                            newLeafNode(lv_name_0_31, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameABSKeyword_0_30());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_31, null);
                    	    

                    }
                    break;
                case 32 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1540:8: lv_name_0_32= DABS
                    {
                    lv_name_0_32=(Token)match(input,DABS,FOLLOW_DABS_in_ruleIntrinsicArithmeticWords3417); 

                            newLeafNode(lv_name_0_32, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameDABSKeyword_0_31());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_32, null);
                    	    

                    }
                    break;
                case 33 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1553:8: lv_name_0_33= EXTEND
                    {
                    lv_name_0_33=(Token)match(input,EXTEND,FOLLOW_EXTEND_in_ruleIntrinsicArithmeticWords3445); 

                            newLeafNode(lv_name_0_33, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameEXTENDKeyword_0_32());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_33, null);
                    	    

                    }
                    break;

            }


            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntrinsicArithmeticWords"


    // $ANTLR start "entryRuleWord"
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1577:1: entryRuleWord returns [EObject current=null] : iv_ruleWord= ruleWord EOF ;
    public final EObject entryRuleWord() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWord = null;


        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1578:2: (iv_ruleWord= ruleWord EOF )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1579:2: iv_ruleWord= ruleWord EOF
            {
             newCompositeNode(grammarAccess.getWordRule()); 
            pushFollow(FOLLOW_ruleWord_in_entryRuleWord3493);
            iv_ruleWord=ruleWord();

            state._fsp--;

             current =iv_ruleWord; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWord3503); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWord"


    // $ANTLR start "ruleWord"
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1586:1: ruleWord returns [EObject current=null] : (this_IntrinsicBranchWords_0= ruleIntrinsicBranchWords | this_IntrinsicStackWords_1= ruleIntrinsicStackWords | this_IntrinsicMemoryWords_2= ruleIntrinsicMemoryWords | this_IntrinsicArithmeticWords_3= ruleIntrinsicArithmeticWords | ( (lv_name_4_0= ruleLITERAL ) ) | ( (lv_name_5_0= RULE_ID ) ) ) ;
    public final EObject ruleWord() throws RecognitionException {
        EObject current = null;

        Token lv_name_5_0=null;
        EObject this_IntrinsicBranchWords_0 = null;

        EObject this_IntrinsicStackWords_1 = null;

        EObject this_IntrinsicMemoryWords_2 = null;

        EObject this_IntrinsicArithmeticWords_3 = null;

        AntlrDatatypeRuleToken lv_name_4_0 = null;


         enterRule(); 
            
        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1589:28: ( (this_IntrinsicBranchWords_0= ruleIntrinsicBranchWords | this_IntrinsicStackWords_1= ruleIntrinsicStackWords | this_IntrinsicMemoryWords_2= ruleIntrinsicMemoryWords | this_IntrinsicArithmeticWords_3= ruleIntrinsicArithmeticWords | ( (lv_name_4_0= ruleLITERAL ) ) | ( (lv_name_5_0= RULE_ID ) ) ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1590:1: (this_IntrinsicBranchWords_0= ruleIntrinsicBranchWords | this_IntrinsicStackWords_1= ruleIntrinsicStackWords | this_IntrinsicMemoryWords_2= ruleIntrinsicMemoryWords | this_IntrinsicArithmeticWords_3= ruleIntrinsicArithmeticWords | ( (lv_name_4_0= ruleLITERAL ) ) | ( (lv_name_5_0= RULE_ID ) ) )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1590:1: (this_IntrinsicBranchWords_0= ruleIntrinsicBranchWords | this_IntrinsicStackWords_1= ruleIntrinsicStackWords | this_IntrinsicMemoryWords_2= ruleIntrinsicMemoryWords | this_IntrinsicArithmeticWords_3= ruleIntrinsicArithmeticWords | ( (lv_name_4_0= ruleLITERAL ) ) | ( (lv_name_5_0= RULE_ID ) ) )
            int alt10=6;
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
                alt10=1;
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
                alt10=2;
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
                alt10=3;
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
                alt10=4;
                }
                break;
            case RULE_INT:
            case RULE_DOUBLE:
                {
                alt10=5;
                }
                break;
            case RULE_ID:
                {
                alt10=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1591:5: this_IntrinsicBranchWords_0= ruleIntrinsicBranchWords
                    {
                     
                            newCompositeNode(grammarAccess.getWordAccess().getIntrinsicBranchWordsParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleIntrinsicBranchWords_in_ruleWord3550);
                    this_IntrinsicBranchWords_0=ruleIntrinsicBranchWords();

                    state._fsp--;


                            current = this_IntrinsicBranchWords_0;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1601:5: this_IntrinsicStackWords_1= ruleIntrinsicStackWords
                    {
                     
                            newCompositeNode(grammarAccess.getWordAccess().getIntrinsicStackWordsParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleIntrinsicStackWords_in_ruleWord3577);
                    this_IntrinsicStackWords_1=ruleIntrinsicStackWords();

                    state._fsp--;


                            current = this_IntrinsicStackWords_1;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1611:5: this_IntrinsicMemoryWords_2= ruleIntrinsicMemoryWords
                    {
                     
                            newCompositeNode(grammarAccess.getWordAccess().getIntrinsicMemoryWordsParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleIntrinsicMemoryWords_in_ruleWord3604);
                    this_IntrinsicMemoryWords_2=ruleIntrinsicMemoryWords();

                    state._fsp--;


                            current = this_IntrinsicMemoryWords_2;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1621:5: this_IntrinsicArithmeticWords_3= ruleIntrinsicArithmeticWords
                    {
                     
                            newCompositeNode(grammarAccess.getWordAccess().getIntrinsicArithmeticWordsParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleIntrinsicArithmeticWords_in_ruleWord3631);
                    this_IntrinsicArithmeticWords_3=ruleIntrinsicArithmeticWords();

                    state._fsp--;


                            current = this_IntrinsicArithmeticWords_3;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1630:6: ( (lv_name_4_0= ruleLITERAL ) )
                    {
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1630:6: ( (lv_name_4_0= ruleLITERAL ) )
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1631:1: (lv_name_4_0= ruleLITERAL )
                    {
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1631:1: (lv_name_4_0= ruleLITERAL )
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1632:3: lv_name_4_0= ruleLITERAL
                    {
                     
                    	        newCompositeNode(grammarAccess.getWordAccess().getNameLITERALParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleLITERAL_in_ruleWord3657);
                    lv_name_4_0=ruleLITERAL();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getWordRule());
                    	        }
                           		set(
                           			current, 
                           			"name",
                            		lv_name_4_0, 
                            		"LITERAL");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 6 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1649:6: ( (lv_name_5_0= RULE_ID ) )
                    {
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1649:6: ( (lv_name_5_0= RULE_ID ) )
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1650:1: (lv_name_5_0= RULE_ID )
                    {
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1650:1: (lv_name_5_0= RULE_ID )
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1651:3: lv_name_5_0= RULE_ID
                    {
                    lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleWord3680); 

                    			newLeafNode(lv_name_5_0, grammarAccess.getWordAccess().getNameIDTerminalRuleCall_5_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getWordRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_5_0, 
                            		"ID");
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWord"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleForth_in_entryRuleForth67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleForth77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleForth122 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF2L,0x000000E177FFFFFFL});
    public static final BitSet FOLLOW_ruleInstruction_in_entryRuleInstruction157 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstruction167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreate_in_ruleInstruction214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_ruleInstruction241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWord_in_ruleInstruction268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_entryRuleFunction302 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunction312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Colon_in_ruleFunction350 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000E1F7FFFFFFL});
    public static final BitSet FOLLOW_ruleWord_in_ruleFunction371 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000E1F7FFFFFFL});
    public static final BitSet FOLLOW_ruleWord_in_ruleFunction391 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000E1F7FFFFFFL});
    public static final BitSet FOLLOW_Semicolon_in_ruleFunction405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreate_in_entryRuleCreate439 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCreate449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Create_in_ruleCreate487 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCreate503 = new BitSet(new long[]{0x0000000000000002L,0x0000006000000000L});
    public static final BitSet FOLLOW_ruleLITERAL_in_ruleCreate530 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_Comma_in_ruleCreate543 = new BitSet(new long[]{0x0000000000000002L,0x0000006000000000L});
    public static final BitSet FOLLOW_ruleLITERAL_in_entryRuleLITERAL580 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLITERAL591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleLITERAL631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOUBLE_in_ruleLITERAL657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntrinsicBranchWords_in_entryRuleIntrinsicBranchWords701 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntrinsicBranchWords711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Jsr_in_ruleIntrinsicBranchWords756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Branch_in_ruleIntrinsicBranchWords784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Branch_2_in_ruleIntrinsicBranchWords812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Branch_1_in_ruleIntrinsicBranchWords840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SBranch_in_ruleIntrinsicBranchWords868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NsBranch_in_ruleIntrinsicBranchWords896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NcBranch_in_ruleIntrinsicBranchWords924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NoBranch_in_ruleIntrinsicBranchWords952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TorBranch_in_ruleIntrinsicBranchWords980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ZExit_in_ruleIntrinsicBranchWords1008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NzExit_in_ruleIntrinsicBranchWords1036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntrinsicStackWords_in_entryRuleIntrinsicStackWords1084 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntrinsicStackWords1094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CLEAR_in_ruleIntrinsicStackWords1139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_ruleIntrinsicStackWords1167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DUP_in_ruleIntrinsicStackWords1195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DUP_2_in_ruleIntrinsicStackWords1223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SWAP_in_ruleIntrinsicStackWords1251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NIP_in_ruleIntrinsicStackWords1279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OVER_in_ruleIntrinsicStackWords1307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROT_in_ruleIntrinsicStackWords1335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROT_1_in_ruleIntrinsicStackWords1363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUCK_in_ruleIntrinsicStackWords1391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNDER_in_ruleIntrinsicStackWords1419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_1_in_ruleIntrinsicStackWords1447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DUP_1_in_ruleIntrinsicStackWords1475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SWAP_1_in_ruleIntrinsicStackWords1503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OVER_1_in_ruleIntrinsicStackWords1531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RCLEAR_in_ruleIntrinsicStackWords1559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_R_1_in_ruleIntrinsicStackWords1587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_R_2_in_ruleIntrinsicStackWords1615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_R_in_ruleIntrinsicStackWords1643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RDROP_in_ruleIntrinsicStackWords1671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntrinsicMemoryWords_in_entryRuleIntrinsicMemoryWords1719 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntrinsicMemoryWords1729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LD_in_ruleIntrinsicMemoryWords1774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CommercialAt_in_ruleIntrinsicMemoryWords1802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ST_in_ruleIntrinsicMemoryWords1830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ExclamationMark_in_ruleIntrinsicMemoryWords1858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitTwoCommercialAt_in_ruleIntrinsicMemoryWords1886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitTwoExclamationMark_in_ruleIntrinsicMemoryWords1914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LLD_in_ruleIntrinsicMemoryWords1942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_L_1_in_ruleIntrinsicMemoryWords1970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LST_in_ruleIntrinsicMemoryWords1998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_L_in_ruleIntrinsicMemoryWords2026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TLD_in_ruleIntrinsicMemoryWords2054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_1_in_ruleIntrinsicMemoryWords2082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TST_in_ruleIntrinsicMemoryWords2110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_in_ruleIntrinsicMemoryWords2138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ST_1_in_ruleIntrinsicMemoryWords2166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PlusSignExclamationMark_in_ruleIntrinsicMemoryWords2194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INC_in_ruleIntrinsicMemoryWords2222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEC_in_ruleIntrinsicMemoryWords2250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ON_in_ruleIntrinsicMemoryWords2278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OFF_in_ruleIntrinsicMemoryWords2306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ERASE_in_ruleIntrinsicMemoryWords2334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILL_in_ruleIntrinsicMemoryWords2362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COUNT_in_ruleIntrinsicMemoryWords2390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MOVE_in_ruleIntrinsicMemoryWords2418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLACE_in_ruleIntrinsicMemoryWords2446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntrinsicArithmeticWords_in_entryRuleIntrinsicArithmeticWords2494 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntrinsicArithmeticWords2504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PlusSign_in_ruleIntrinsicArithmeticWords2549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HyphenMinus_in_ruleIntrinsicArithmeticWords2577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Asterisk_in_ruleIntrinsicArithmeticWords2605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Solidus_in_ruleIntrinsicArithmeticWords2633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitTwoAsterisk_in_ruleIntrinsicArithmeticWords2661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitTwoSolidus_in_ruleIntrinsicArithmeticWords2689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_U2_in_ruleIntrinsicArithmeticWords2717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROR_in_ruleIntrinsicArithmeticWords2745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROR_in_ruleIntrinsicArithmeticWords2773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROL_in_ruleIntrinsicArithmeticWords2801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROL_in_ruleIntrinsicArithmeticWords2829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PACK_in_ruleIntrinsicArithmeticWords2857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNPACK_in_ruleIntrinsicArithmeticWords2885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHIFT_in_ruleIntrinsicArithmeticWords2913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASHIFT_in_ruleIntrinsicArithmeticWords2941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitTwoAsteriskAsterisk_in_ruleIntrinsicArithmeticWords2969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitZeroEqualsSign_in_ruleIntrinsicArithmeticWords2997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitZeroLessThanSignGreaterThanSign_in_ruleIntrinsicArithmeticWords3025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitZeroLessThanSign_in_ruleIntrinsicArithmeticWords3053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_D0_in_ruleIntrinsicArithmeticWords3081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEGATE_in_ruleIntrinsicArithmeticWords3109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DNEGATE_in_ruleIntrinsicArithmeticWords3137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitOnePlusSign_in_ruleIntrinsicArithmeticWords3165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitOneHyphenMinus_in_ruleIntrinsicArithmeticWords3193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_ruleIntrinsicArithmeticWords3221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_ruleIntrinsicArithmeticWords3249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CELL_in_ruleIntrinsicArithmeticWords3277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CELL_1_in_ruleIntrinsicArithmeticWords3305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CARRY_RESET_in_ruleIntrinsicArithmeticWords3333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CARRYSET_in_ruleIntrinsicArithmeticWords3361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ABS_in_ruleIntrinsicArithmeticWords3389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DABS_in_ruleIntrinsicArithmeticWords3417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXTEND_in_ruleIntrinsicArithmeticWords3445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWord_in_entryRuleWord3493 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWord3503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntrinsicBranchWords_in_ruleWord3550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntrinsicStackWords_in_ruleWord3577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntrinsicMemoryWords_in_ruleWord3604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntrinsicArithmeticWords_in_ruleWord3631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLITERAL_in_ruleWord3657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleWord3680 = new BitSet(new long[]{0x0000000000000002L});

}