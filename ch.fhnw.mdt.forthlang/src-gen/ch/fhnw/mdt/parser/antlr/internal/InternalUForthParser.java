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
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:159:1: ruleFunction returns [EObject current=null] : (otherlv_0= Colon ( (lv_name_1_0= ruleWord ) ) ( (lv_words_2_0= ruleWord ) )* otherlv_3= Semicolon ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject lv_name_1_0 = null;

        EObject lv_words_2_0 = null;


         enterRule(); 
            
        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:162:28: ( (otherlv_0= Colon ( (lv_name_1_0= ruleWord ) ) ( (lv_words_2_0= ruleWord ) )* otherlv_3= Semicolon ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:163:1: (otherlv_0= Colon ( (lv_name_1_0= ruleWord ) ) ( (lv_words_2_0= ruleWord ) )* otherlv_3= Semicolon )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:163:1: (otherlv_0= Colon ( (lv_name_1_0= ruleWord ) ) ( (lv_words_2_0= ruleWord ) )* otherlv_3= Semicolon )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:164:2: otherlv_0= Colon ( (lv_name_1_0= ruleWord ) ) ( (lv_words_2_0= ruleWord ) )* otherlv_3= Semicolon
            {
            otherlv_0=(Token)match(input,Colon,FOLLOW_Colon_in_ruleFunction350); 

                	newLeafNode(otherlv_0, grammarAccess.getFunctionAccess().getColonKeyword_0());
                
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:168:1: ( (lv_name_1_0= ruleWord ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:169:1: (lv_name_1_0= ruleWord )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:169:1: (lv_name_1_0= ruleWord )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:170:3: lv_name_1_0= ruleWord
            {
             
            	        newCompositeNode(grammarAccess.getFunctionAccess().getNameWordParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleWord_in_ruleFunction370);
            lv_name_1_0=ruleWord();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFunctionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"Word");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:186:2: ( (lv_words_2_0= ruleWord ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=CARRY_RESET && LA3_0<=UNPACK)||(LA3_0>=DROP_1 && LA3_0<=PlusSign)||(LA3_0>=HyphenMinus && LA3_0<=Solidus)||LA3_0==CommercialAt||(LA3_0>=RULE_INT && LA3_0<=RULE_ID)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:187:1: (lv_words_2_0= ruleWord )
            	    {
            	    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:187:1: (lv_words_2_0= ruleWord )
            	    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:188:3: lv_words_2_0= ruleWord
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
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:217:1: entryRuleCreate returns [EObject current=null] : iv_ruleCreate= ruleCreate EOF ;
    public final EObject entryRuleCreate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCreate = null;


        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:218:2: (iv_ruleCreate= ruleCreate EOF )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:219:2: iv_ruleCreate= ruleCreate EOF
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
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:226:1: ruleCreate returns [EObject current=null] : (otherlv_0= Create ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_lit_2_0= ruleLITERAL ) ) otherlv_3= Comma )* ) ;
    public final EObject ruleCreate() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_lit_2_0 = null;


         enterRule(); 
            
        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:229:28: ( (otherlv_0= Create ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_lit_2_0= ruleLITERAL ) ) otherlv_3= Comma )* ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:230:1: (otherlv_0= Create ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_lit_2_0= ruleLITERAL ) ) otherlv_3= Comma )* )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:230:1: (otherlv_0= Create ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_lit_2_0= ruleLITERAL ) ) otherlv_3= Comma )* )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:231:2: otherlv_0= Create ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_lit_2_0= ruleLITERAL ) ) otherlv_3= Comma )*
            {
            otherlv_0=(Token)match(input,Create,FOLLOW_Create_in_ruleCreate487); 

                	newLeafNode(otherlv_0, grammarAccess.getCreateAccess().getCreateKeyword_0());
                
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:235:1: ( (lv_name_1_0= RULE_ID ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:236:1: (lv_name_1_0= RULE_ID )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:236:1: (lv_name_1_0= RULE_ID )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:237:3: lv_name_1_0= RULE_ID
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

            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:253:2: ( ( (lv_lit_2_0= ruleLITERAL ) ) otherlv_3= Comma )*
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
            	    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:253:3: ( (lv_lit_2_0= ruleLITERAL ) ) otherlv_3= Comma
            	    {
            	    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:253:3: ( (lv_lit_2_0= ruleLITERAL ) )
            	    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:254:1: (lv_lit_2_0= ruleLITERAL )
            	    {
            	    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:254:1: (lv_lit_2_0= ruleLITERAL )
            	    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:255:3: lv_lit_2_0= ruleLITERAL
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
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:284:1: entryRuleLITERAL returns [String current=null] : iv_ruleLITERAL= ruleLITERAL EOF ;
    public final String entryRuleLITERAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLITERAL = null;


        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:285:1: (iv_ruleLITERAL= ruleLITERAL EOF )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:286:2: iv_ruleLITERAL= ruleLITERAL EOF
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
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:293:1: ruleLITERAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | this_DOUBLE_1= RULE_DOUBLE ) ;
    public final AntlrDatatypeRuleToken ruleLITERAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token this_DOUBLE_1=null;

         enterRule(); 
            
        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:297:6: ( (this_INT_0= RULE_INT | this_DOUBLE_1= RULE_DOUBLE ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:298:1: (this_INT_0= RULE_INT | this_DOUBLE_1= RULE_DOUBLE )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:298:1: (this_INT_0= RULE_INT | this_DOUBLE_1= RULE_DOUBLE )
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
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:298:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleLITERAL631); 

                    		current.merge(this_INT_0);
                        
                     
                        newLeafNode(this_INT_0, grammarAccess.getLITERALAccess().getINTTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:306:10: this_DOUBLE_1= RULE_DOUBLE
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


    // $ANTLR start "entryRuleIntrinsicStackWords"
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:321:1: entryRuleIntrinsicStackWords returns [EObject current=null] : iv_ruleIntrinsicStackWords= ruleIntrinsicStackWords EOF ;
    public final EObject entryRuleIntrinsicStackWords() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntrinsicStackWords = null;


        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:322:2: (iv_ruleIntrinsicStackWords= ruleIntrinsicStackWords EOF )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:323:2: iv_ruleIntrinsicStackWords= ruleIntrinsicStackWords EOF
            {
             newCompositeNode(grammarAccess.getIntrinsicStackWordsRule()); 
            pushFollow(FOLLOW_ruleIntrinsicStackWords_in_entryRuleIntrinsicStackWords701);
            iv_ruleIntrinsicStackWords=ruleIntrinsicStackWords();

            state._fsp--;

             current =iv_ruleIntrinsicStackWords; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntrinsicStackWords711); 

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
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:330:1: ruleIntrinsicStackWords returns [EObject current=null] : ( () ( ( (lv_name_1_1= CLEAR | lv_name_1_2= DROP | lv_name_1_3= DUP | lv_name_1_4= DUP_2 | lv_name_1_5= SWAP | lv_name_1_6= NIP | lv_name_1_7= OVER | lv_name_1_8= ROT | lv_name_1_9= ROT_1 | lv_name_1_10= TUCK | lv_name_1_11= UNDER | lv_name_1_12= DROP_1 | lv_name_1_13= DUP_1 | lv_name_1_14= SWAP_1 | lv_name_1_15= OVER_1 | lv_name_1_16= RCLEAR | lv_name_1_17= R_1 | lv_name_1_18= R_2 | lv_name_1_19= R | lv_name_1_20= RDROP ) ) ) ) ;
    public final EObject ruleIntrinsicStackWords() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_1=null;
        Token lv_name_1_2=null;
        Token lv_name_1_3=null;
        Token lv_name_1_4=null;
        Token lv_name_1_5=null;
        Token lv_name_1_6=null;
        Token lv_name_1_7=null;
        Token lv_name_1_8=null;
        Token lv_name_1_9=null;
        Token lv_name_1_10=null;
        Token lv_name_1_11=null;
        Token lv_name_1_12=null;
        Token lv_name_1_13=null;
        Token lv_name_1_14=null;
        Token lv_name_1_15=null;
        Token lv_name_1_16=null;
        Token lv_name_1_17=null;
        Token lv_name_1_18=null;
        Token lv_name_1_19=null;
        Token lv_name_1_20=null;

         enterRule(); 
            
        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:333:28: ( ( () ( ( (lv_name_1_1= CLEAR | lv_name_1_2= DROP | lv_name_1_3= DUP | lv_name_1_4= DUP_2 | lv_name_1_5= SWAP | lv_name_1_6= NIP | lv_name_1_7= OVER | lv_name_1_8= ROT | lv_name_1_9= ROT_1 | lv_name_1_10= TUCK | lv_name_1_11= UNDER | lv_name_1_12= DROP_1 | lv_name_1_13= DUP_1 | lv_name_1_14= SWAP_1 | lv_name_1_15= OVER_1 | lv_name_1_16= RCLEAR | lv_name_1_17= R_1 | lv_name_1_18= R_2 | lv_name_1_19= R | lv_name_1_20= RDROP ) ) ) ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:334:1: ( () ( ( (lv_name_1_1= CLEAR | lv_name_1_2= DROP | lv_name_1_3= DUP | lv_name_1_4= DUP_2 | lv_name_1_5= SWAP | lv_name_1_6= NIP | lv_name_1_7= OVER | lv_name_1_8= ROT | lv_name_1_9= ROT_1 | lv_name_1_10= TUCK | lv_name_1_11= UNDER | lv_name_1_12= DROP_1 | lv_name_1_13= DUP_1 | lv_name_1_14= SWAP_1 | lv_name_1_15= OVER_1 | lv_name_1_16= RCLEAR | lv_name_1_17= R_1 | lv_name_1_18= R_2 | lv_name_1_19= R | lv_name_1_20= RDROP ) ) ) )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:334:1: ( () ( ( (lv_name_1_1= CLEAR | lv_name_1_2= DROP | lv_name_1_3= DUP | lv_name_1_4= DUP_2 | lv_name_1_5= SWAP | lv_name_1_6= NIP | lv_name_1_7= OVER | lv_name_1_8= ROT | lv_name_1_9= ROT_1 | lv_name_1_10= TUCK | lv_name_1_11= UNDER | lv_name_1_12= DROP_1 | lv_name_1_13= DUP_1 | lv_name_1_14= SWAP_1 | lv_name_1_15= OVER_1 | lv_name_1_16= RCLEAR | lv_name_1_17= R_1 | lv_name_1_18= R_2 | lv_name_1_19= R | lv_name_1_20= RDROP ) ) ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:334:2: () ( ( (lv_name_1_1= CLEAR | lv_name_1_2= DROP | lv_name_1_3= DUP | lv_name_1_4= DUP_2 | lv_name_1_5= SWAP | lv_name_1_6= NIP | lv_name_1_7= OVER | lv_name_1_8= ROT | lv_name_1_9= ROT_1 | lv_name_1_10= TUCK | lv_name_1_11= UNDER | lv_name_1_12= DROP_1 | lv_name_1_13= DUP_1 | lv_name_1_14= SWAP_1 | lv_name_1_15= OVER_1 | lv_name_1_16= RCLEAR | lv_name_1_17= R_1 | lv_name_1_18= R_2 | lv_name_1_19= R | lv_name_1_20= RDROP ) ) )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:334:2: ()
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:335:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIntrinsicStackWordsAccess().getIntrinsicStackWordsAction_0(),
                        current);
                

            }

            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:340:2: ( ( (lv_name_1_1= CLEAR | lv_name_1_2= DROP | lv_name_1_3= DUP | lv_name_1_4= DUP_2 | lv_name_1_5= SWAP | lv_name_1_6= NIP | lv_name_1_7= OVER | lv_name_1_8= ROT | lv_name_1_9= ROT_1 | lv_name_1_10= TUCK | lv_name_1_11= UNDER | lv_name_1_12= DROP_1 | lv_name_1_13= DUP_1 | lv_name_1_14= SWAP_1 | lv_name_1_15= OVER_1 | lv_name_1_16= RCLEAR | lv_name_1_17= R_1 | lv_name_1_18= R_2 | lv_name_1_19= R | lv_name_1_20= RDROP ) ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:341:1: ( (lv_name_1_1= CLEAR | lv_name_1_2= DROP | lv_name_1_3= DUP | lv_name_1_4= DUP_2 | lv_name_1_5= SWAP | lv_name_1_6= NIP | lv_name_1_7= OVER | lv_name_1_8= ROT | lv_name_1_9= ROT_1 | lv_name_1_10= TUCK | lv_name_1_11= UNDER | lv_name_1_12= DROP_1 | lv_name_1_13= DUP_1 | lv_name_1_14= SWAP_1 | lv_name_1_15= OVER_1 | lv_name_1_16= RCLEAR | lv_name_1_17= R_1 | lv_name_1_18= R_2 | lv_name_1_19= R | lv_name_1_20= RDROP ) )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:341:1: ( (lv_name_1_1= CLEAR | lv_name_1_2= DROP | lv_name_1_3= DUP | lv_name_1_4= DUP_2 | lv_name_1_5= SWAP | lv_name_1_6= NIP | lv_name_1_7= OVER | lv_name_1_8= ROT | lv_name_1_9= ROT_1 | lv_name_1_10= TUCK | lv_name_1_11= UNDER | lv_name_1_12= DROP_1 | lv_name_1_13= DUP_1 | lv_name_1_14= SWAP_1 | lv_name_1_15= OVER_1 | lv_name_1_16= RCLEAR | lv_name_1_17= R_1 | lv_name_1_18= R_2 | lv_name_1_19= R | lv_name_1_20= RDROP ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:342:1: (lv_name_1_1= CLEAR | lv_name_1_2= DROP | lv_name_1_3= DUP | lv_name_1_4= DUP_2 | lv_name_1_5= SWAP | lv_name_1_6= NIP | lv_name_1_7= OVER | lv_name_1_8= ROT | lv_name_1_9= ROT_1 | lv_name_1_10= TUCK | lv_name_1_11= UNDER | lv_name_1_12= DROP_1 | lv_name_1_13= DUP_1 | lv_name_1_14= SWAP_1 | lv_name_1_15= OVER_1 | lv_name_1_16= RCLEAR | lv_name_1_17= R_1 | lv_name_1_18= R_2 | lv_name_1_19= R | lv_name_1_20= RDROP )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:342:1: (lv_name_1_1= CLEAR | lv_name_1_2= DROP | lv_name_1_3= DUP | lv_name_1_4= DUP_2 | lv_name_1_5= SWAP | lv_name_1_6= NIP | lv_name_1_7= OVER | lv_name_1_8= ROT | lv_name_1_9= ROT_1 | lv_name_1_10= TUCK | lv_name_1_11= UNDER | lv_name_1_12= DROP_1 | lv_name_1_13= DUP_1 | lv_name_1_14= SWAP_1 | lv_name_1_15= OVER_1 | lv_name_1_16= RCLEAR | lv_name_1_17= R_1 | lv_name_1_18= R_2 | lv_name_1_19= R | lv_name_1_20= RDROP )
            int alt6=20;
            switch ( input.LA(1) ) {
            case CLEAR:
                {
                alt6=1;
                }
                break;
            case DROP:
                {
                alt6=2;
                }
                break;
            case DUP:
                {
                alt6=3;
                }
                break;
            case DUP_2:
                {
                alt6=4;
                }
                break;
            case SWAP:
                {
                alt6=5;
                }
                break;
            case NIP:
                {
                alt6=6;
                }
                break;
            case OVER:
                {
                alt6=7;
                }
                break;
            case ROT:
                {
                alt6=8;
                }
                break;
            case ROT_1:
                {
                alt6=9;
                }
                break;
            case TUCK:
                {
                alt6=10;
                }
                break;
            case UNDER:
                {
                alt6=11;
                }
                break;
            case DROP_1:
                {
                alt6=12;
                }
                break;
            case DUP_1:
                {
                alt6=13;
                }
                break;
            case SWAP_1:
                {
                alt6=14;
                }
                break;
            case OVER_1:
                {
                alt6=15;
                }
                break;
            case RCLEAR:
                {
                alt6=16;
                }
                break;
            case R_1:
                {
                alt6=17;
                }
                break;
            case R_2:
                {
                alt6=18;
                }
                break;
            case R:
                {
                alt6=19;
                }
                break;
            case RDROP:
                {
                alt6=20;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:343:3: lv_name_1_1= CLEAR
                    {
                    lv_name_1_1=(Token)match(input,CLEAR,FOLLOW_CLEAR_in_ruleIntrinsicStackWords766); 

                            newLeafNode(lv_name_1_1, grammarAccess.getIntrinsicStackWordsAccess().getNameCLEARKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:356:8: lv_name_1_2= DROP
                    {
                    lv_name_1_2=(Token)match(input,DROP,FOLLOW_DROP_in_ruleIntrinsicStackWords794); 

                            newLeafNode(lv_name_1_2, grammarAccess.getIntrinsicStackWordsAccess().getNameDROPKeyword_1_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:369:8: lv_name_1_3= DUP
                    {
                    lv_name_1_3=(Token)match(input,DUP,FOLLOW_DUP_in_ruleIntrinsicStackWords822); 

                            newLeafNode(lv_name_1_3, grammarAccess.getIntrinsicStackWordsAccess().getNameDUPKeyword_1_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_3, null);
                    	    

                    }
                    break;
                case 4 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:382:8: lv_name_1_4= DUP_2
                    {
                    lv_name_1_4=(Token)match(input,DUP_2,FOLLOW_DUP_2_in_ruleIntrinsicStackWords850); 

                            newLeafNode(lv_name_1_4, grammarAccess.getIntrinsicStackWordsAccess().getNameDUPKeyword_1_0_3());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_4, null);
                    	    

                    }
                    break;
                case 5 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:395:8: lv_name_1_5= SWAP
                    {
                    lv_name_1_5=(Token)match(input,SWAP,FOLLOW_SWAP_in_ruleIntrinsicStackWords878); 

                            newLeafNode(lv_name_1_5, grammarAccess.getIntrinsicStackWordsAccess().getNameSWAPKeyword_1_0_4());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_5, null);
                    	    

                    }
                    break;
                case 6 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:408:8: lv_name_1_6= NIP
                    {
                    lv_name_1_6=(Token)match(input,NIP,FOLLOW_NIP_in_ruleIntrinsicStackWords906); 

                            newLeafNode(lv_name_1_6, grammarAccess.getIntrinsicStackWordsAccess().getNameNIPKeyword_1_0_5());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_6, null);
                    	    

                    }
                    break;
                case 7 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:421:8: lv_name_1_7= OVER
                    {
                    lv_name_1_7=(Token)match(input,OVER,FOLLOW_OVER_in_ruleIntrinsicStackWords934); 

                            newLeafNode(lv_name_1_7, grammarAccess.getIntrinsicStackWordsAccess().getNameOVERKeyword_1_0_6());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_7, null);
                    	    

                    }
                    break;
                case 8 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:434:8: lv_name_1_8= ROT
                    {
                    lv_name_1_8=(Token)match(input,ROT,FOLLOW_ROT_in_ruleIntrinsicStackWords962); 

                            newLeafNode(lv_name_1_8, grammarAccess.getIntrinsicStackWordsAccess().getNameROTKeyword_1_0_7());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_8, null);
                    	    

                    }
                    break;
                case 9 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:447:8: lv_name_1_9= ROT_1
                    {
                    lv_name_1_9=(Token)match(input,ROT_1,FOLLOW_ROT_1_in_ruleIntrinsicStackWords990); 

                            newLeafNode(lv_name_1_9, grammarAccess.getIntrinsicStackWordsAccess().getNameROTKeyword_1_0_8());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_9, null);
                    	    

                    }
                    break;
                case 10 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:460:8: lv_name_1_10= TUCK
                    {
                    lv_name_1_10=(Token)match(input,TUCK,FOLLOW_TUCK_in_ruleIntrinsicStackWords1018); 

                            newLeafNode(lv_name_1_10, grammarAccess.getIntrinsicStackWordsAccess().getNameTUCKKeyword_1_0_9());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_10, null);
                    	    

                    }
                    break;
                case 11 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:473:8: lv_name_1_11= UNDER
                    {
                    lv_name_1_11=(Token)match(input,UNDER,FOLLOW_UNDER_in_ruleIntrinsicStackWords1046); 

                            newLeafNode(lv_name_1_11, grammarAccess.getIntrinsicStackWordsAccess().getNameUNDERKeyword_1_0_10());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_11, null);
                    	    

                    }
                    break;
                case 12 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:486:8: lv_name_1_12= DROP_1
                    {
                    lv_name_1_12=(Token)match(input,DROP_1,FOLLOW_DROP_1_in_ruleIntrinsicStackWords1074); 

                            newLeafNode(lv_name_1_12, grammarAccess.getIntrinsicStackWordsAccess().getName2DROPKeyword_1_0_11());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_12, null);
                    	    

                    }
                    break;
                case 13 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:499:8: lv_name_1_13= DUP_1
                    {
                    lv_name_1_13=(Token)match(input,DUP_1,FOLLOW_DUP_1_in_ruleIntrinsicStackWords1102); 

                            newLeafNode(lv_name_1_13, grammarAccess.getIntrinsicStackWordsAccess().getName2DUPKeyword_1_0_12());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_13, null);
                    	    

                    }
                    break;
                case 14 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:512:8: lv_name_1_14= SWAP_1
                    {
                    lv_name_1_14=(Token)match(input,SWAP_1,FOLLOW_SWAP_1_in_ruleIntrinsicStackWords1130); 

                            newLeafNode(lv_name_1_14, grammarAccess.getIntrinsicStackWordsAccess().getName2SWAPKeyword_1_0_13());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_14, null);
                    	    

                    }
                    break;
                case 15 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:525:8: lv_name_1_15= OVER_1
                    {
                    lv_name_1_15=(Token)match(input,OVER_1,FOLLOW_OVER_1_in_ruleIntrinsicStackWords1158); 

                            newLeafNode(lv_name_1_15, grammarAccess.getIntrinsicStackWordsAccess().getName2OVERKeyword_1_0_14());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_15, null);
                    	    

                    }
                    break;
                case 16 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:538:8: lv_name_1_16= RCLEAR
                    {
                    lv_name_1_16=(Token)match(input,RCLEAR,FOLLOW_RCLEAR_in_ruleIntrinsicStackWords1186); 

                            newLeafNode(lv_name_1_16, grammarAccess.getIntrinsicStackWordsAccess().getNameRCLEARKeyword_1_0_15());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_16, null);
                    	    

                    }
                    break;
                case 17 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:551:8: lv_name_1_17= R_1
                    {
                    lv_name_1_17=(Token)match(input,R_1,FOLLOW_R_1_in_ruleIntrinsicStackWords1214); 

                            newLeafNode(lv_name_1_17, grammarAccess.getIntrinsicStackWordsAccess().getNameRKeyword_1_0_16());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_17, null);
                    	    

                    }
                    break;
                case 18 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:564:8: lv_name_1_18= R_2
                    {
                    lv_name_1_18=(Token)match(input,R_2,FOLLOW_R_2_in_ruleIntrinsicStackWords1242); 

                            newLeafNode(lv_name_1_18, grammarAccess.getIntrinsicStackWordsAccess().getNameRKeyword_1_0_17());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_18, null);
                    	    

                    }
                    break;
                case 19 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:577:8: lv_name_1_19= R
                    {
                    lv_name_1_19=(Token)match(input,R,FOLLOW_R_in_ruleIntrinsicStackWords1270); 

                            newLeafNode(lv_name_1_19, grammarAccess.getIntrinsicStackWordsAccess().getNameRKeyword_1_0_18());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_19, null);
                    	    

                    }
                    break;
                case 20 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:590:8: lv_name_1_20= RDROP
                    {
                    lv_name_1_20=(Token)match(input,RDROP,FOLLOW_RDROP_in_ruleIntrinsicStackWords1298); 

                            newLeafNode(lv_name_1_20, grammarAccess.getIntrinsicStackWordsAccess().getNameRDROPKeyword_1_0_19());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicStackWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_20, null);
                    	    

                    }
                    break;

            }


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
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:614:1: entryRuleIntrinsicMemoryWords returns [EObject current=null] : iv_ruleIntrinsicMemoryWords= ruleIntrinsicMemoryWords EOF ;
    public final EObject entryRuleIntrinsicMemoryWords() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntrinsicMemoryWords = null;


        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:615:2: (iv_ruleIntrinsicMemoryWords= ruleIntrinsicMemoryWords EOF )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:616:2: iv_ruleIntrinsicMemoryWords= ruleIntrinsicMemoryWords EOF
            {
             newCompositeNode(grammarAccess.getIntrinsicMemoryWordsRule()); 
            pushFollow(FOLLOW_ruleIntrinsicMemoryWords_in_entryRuleIntrinsicMemoryWords1347);
            iv_ruleIntrinsicMemoryWords=ruleIntrinsicMemoryWords();

            state._fsp--;

             current =iv_ruleIntrinsicMemoryWords; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntrinsicMemoryWords1357); 

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
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:623:1: ruleIntrinsicMemoryWords returns [EObject current=null] : ( () ( ( (lv_name_1_1= LD | lv_name_1_2= CommercialAt | lv_name_1_3= ST | lv_name_1_4= ExclamationMark | lv_name_1_5= DigitTwoCommercialAt | lv_name_1_6= DigitTwoExclamationMark | lv_name_1_7= LLD | lv_name_1_8= L_1 | lv_name_1_9= LST | lv_name_1_10= L | lv_name_1_11= TLD | lv_name_1_12= T_1 | lv_name_1_13= TST | lv_name_1_14= T | lv_name_1_15= ST_1 | lv_name_1_16= PlusSignExclamationMark | lv_name_1_17= INC | lv_name_1_18= DEC | lv_name_1_19= ON | lv_name_1_20= OFF | lv_name_1_21= ERASE | lv_name_1_22= FILL | lv_name_1_23= COUNT | lv_name_1_24= MOVE | lv_name_1_25= PLACE ) ) ) ) ;
    public final EObject ruleIntrinsicMemoryWords() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_1=null;
        Token lv_name_1_2=null;
        Token lv_name_1_3=null;
        Token lv_name_1_4=null;
        Token lv_name_1_5=null;
        Token lv_name_1_6=null;
        Token lv_name_1_7=null;
        Token lv_name_1_8=null;
        Token lv_name_1_9=null;
        Token lv_name_1_10=null;
        Token lv_name_1_11=null;
        Token lv_name_1_12=null;
        Token lv_name_1_13=null;
        Token lv_name_1_14=null;
        Token lv_name_1_15=null;
        Token lv_name_1_16=null;
        Token lv_name_1_17=null;
        Token lv_name_1_18=null;
        Token lv_name_1_19=null;
        Token lv_name_1_20=null;
        Token lv_name_1_21=null;
        Token lv_name_1_22=null;
        Token lv_name_1_23=null;
        Token lv_name_1_24=null;
        Token lv_name_1_25=null;

         enterRule(); 
            
        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:626:28: ( ( () ( ( (lv_name_1_1= LD | lv_name_1_2= CommercialAt | lv_name_1_3= ST | lv_name_1_4= ExclamationMark | lv_name_1_5= DigitTwoCommercialAt | lv_name_1_6= DigitTwoExclamationMark | lv_name_1_7= LLD | lv_name_1_8= L_1 | lv_name_1_9= LST | lv_name_1_10= L | lv_name_1_11= TLD | lv_name_1_12= T_1 | lv_name_1_13= TST | lv_name_1_14= T | lv_name_1_15= ST_1 | lv_name_1_16= PlusSignExclamationMark | lv_name_1_17= INC | lv_name_1_18= DEC | lv_name_1_19= ON | lv_name_1_20= OFF | lv_name_1_21= ERASE | lv_name_1_22= FILL | lv_name_1_23= COUNT | lv_name_1_24= MOVE | lv_name_1_25= PLACE ) ) ) ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:627:1: ( () ( ( (lv_name_1_1= LD | lv_name_1_2= CommercialAt | lv_name_1_3= ST | lv_name_1_4= ExclamationMark | lv_name_1_5= DigitTwoCommercialAt | lv_name_1_6= DigitTwoExclamationMark | lv_name_1_7= LLD | lv_name_1_8= L_1 | lv_name_1_9= LST | lv_name_1_10= L | lv_name_1_11= TLD | lv_name_1_12= T_1 | lv_name_1_13= TST | lv_name_1_14= T | lv_name_1_15= ST_1 | lv_name_1_16= PlusSignExclamationMark | lv_name_1_17= INC | lv_name_1_18= DEC | lv_name_1_19= ON | lv_name_1_20= OFF | lv_name_1_21= ERASE | lv_name_1_22= FILL | lv_name_1_23= COUNT | lv_name_1_24= MOVE | lv_name_1_25= PLACE ) ) ) )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:627:1: ( () ( ( (lv_name_1_1= LD | lv_name_1_2= CommercialAt | lv_name_1_3= ST | lv_name_1_4= ExclamationMark | lv_name_1_5= DigitTwoCommercialAt | lv_name_1_6= DigitTwoExclamationMark | lv_name_1_7= LLD | lv_name_1_8= L_1 | lv_name_1_9= LST | lv_name_1_10= L | lv_name_1_11= TLD | lv_name_1_12= T_1 | lv_name_1_13= TST | lv_name_1_14= T | lv_name_1_15= ST_1 | lv_name_1_16= PlusSignExclamationMark | lv_name_1_17= INC | lv_name_1_18= DEC | lv_name_1_19= ON | lv_name_1_20= OFF | lv_name_1_21= ERASE | lv_name_1_22= FILL | lv_name_1_23= COUNT | lv_name_1_24= MOVE | lv_name_1_25= PLACE ) ) ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:627:2: () ( ( (lv_name_1_1= LD | lv_name_1_2= CommercialAt | lv_name_1_3= ST | lv_name_1_4= ExclamationMark | lv_name_1_5= DigitTwoCommercialAt | lv_name_1_6= DigitTwoExclamationMark | lv_name_1_7= LLD | lv_name_1_8= L_1 | lv_name_1_9= LST | lv_name_1_10= L | lv_name_1_11= TLD | lv_name_1_12= T_1 | lv_name_1_13= TST | lv_name_1_14= T | lv_name_1_15= ST_1 | lv_name_1_16= PlusSignExclamationMark | lv_name_1_17= INC | lv_name_1_18= DEC | lv_name_1_19= ON | lv_name_1_20= OFF | lv_name_1_21= ERASE | lv_name_1_22= FILL | lv_name_1_23= COUNT | lv_name_1_24= MOVE | lv_name_1_25= PLACE ) ) )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:627:2: ()
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:628:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIntrinsicMemoryWordsAccess().getIntrinsicMemoryWordsAction_0(),
                        current);
                

            }

            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:633:2: ( ( (lv_name_1_1= LD | lv_name_1_2= CommercialAt | lv_name_1_3= ST | lv_name_1_4= ExclamationMark | lv_name_1_5= DigitTwoCommercialAt | lv_name_1_6= DigitTwoExclamationMark | lv_name_1_7= LLD | lv_name_1_8= L_1 | lv_name_1_9= LST | lv_name_1_10= L | lv_name_1_11= TLD | lv_name_1_12= T_1 | lv_name_1_13= TST | lv_name_1_14= T | lv_name_1_15= ST_1 | lv_name_1_16= PlusSignExclamationMark | lv_name_1_17= INC | lv_name_1_18= DEC | lv_name_1_19= ON | lv_name_1_20= OFF | lv_name_1_21= ERASE | lv_name_1_22= FILL | lv_name_1_23= COUNT | lv_name_1_24= MOVE | lv_name_1_25= PLACE ) ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:634:1: ( (lv_name_1_1= LD | lv_name_1_2= CommercialAt | lv_name_1_3= ST | lv_name_1_4= ExclamationMark | lv_name_1_5= DigitTwoCommercialAt | lv_name_1_6= DigitTwoExclamationMark | lv_name_1_7= LLD | lv_name_1_8= L_1 | lv_name_1_9= LST | lv_name_1_10= L | lv_name_1_11= TLD | lv_name_1_12= T_1 | lv_name_1_13= TST | lv_name_1_14= T | lv_name_1_15= ST_1 | lv_name_1_16= PlusSignExclamationMark | lv_name_1_17= INC | lv_name_1_18= DEC | lv_name_1_19= ON | lv_name_1_20= OFF | lv_name_1_21= ERASE | lv_name_1_22= FILL | lv_name_1_23= COUNT | lv_name_1_24= MOVE | lv_name_1_25= PLACE ) )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:634:1: ( (lv_name_1_1= LD | lv_name_1_2= CommercialAt | lv_name_1_3= ST | lv_name_1_4= ExclamationMark | lv_name_1_5= DigitTwoCommercialAt | lv_name_1_6= DigitTwoExclamationMark | lv_name_1_7= LLD | lv_name_1_8= L_1 | lv_name_1_9= LST | lv_name_1_10= L | lv_name_1_11= TLD | lv_name_1_12= T_1 | lv_name_1_13= TST | lv_name_1_14= T | lv_name_1_15= ST_1 | lv_name_1_16= PlusSignExclamationMark | lv_name_1_17= INC | lv_name_1_18= DEC | lv_name_1_19= ON | lv_name_1_20= OFF | lv_name_1_21= ERASE | lv_name_1_22= FILL | lv_name_1_23= COUNT | lv_name_1_24= MOVE | lv_name_1_25= PLACE ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:635:1: (lv_name_1_1= LD | lv_name_1_2= CommercialAt | lv_name_1_3= ST | lv_name_1_4= ExclamationMark | lv_name_1_5= DigitTwoCommercialAt | lv_name_1_6= DigitTwoExclamationMark | lv_name_1_7= LLD | lv_name_1_8= L_1 | lv_name_1_9= LST | lv_name_1_10= L | lv_name_1_11= TLD | lv_name_1_12= T_1 | lv_name_1_13= TST | lv_name_1_14= T | lv_name_1_15= ST_1 | lv_name_1_16= PlusSignExclamationMark | lv_name_1_17= INC | lv_name_1_18= DEC | lv_name_1_19= ON | lv_name_1_20= OFF | lv_name_1_21= ERASE | lv_name_1_22= FILL | lv_name_1_23= COUNT | lv_name_1_24= MOVE | lv_name_1_25= PLACE )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:635:1: (lv_name_1_1= LD | lv_name_1_2= CommercialAt | lv_name_1_3= ST | lv_name_1_4= ExclamationMark | lv_name_1_5= DigitTwoCommercialAt | lv_name_1_6= DigitTwoExclamationMark | lv_name_1_7= LLD | lv_name_1_8= L_1 | lv_name_1_9= LST | lv_name_1_10= L | lv_name_1_11= TLD | lv_name_1_12= T_1 | lv_name_1_13= TST | lv_name_1_14= T | lv_name_1_15= ST_1 | lv_name_1_16= PlusSignExclamationMark | lv_name_1_17= INC | lv_name_1_18= DEC | lv_name_1_19= ON | lv_name_1_20= OFF | lv_name_1_21= ERASE | lv_name_1_22= FILL | lv_name_1_23= COUNT | lv_name_1_24= MOVE | lv_name_1_25= PLACE )
            int alt7=25;
            switch ( input.LA(1) ) {
            case LD:
                {
                alt7=1;
                }
                break;
            case CommercialAt:
                {
                alt7=2;
                }
                break;
            case ST:
                {
                alt7=3;
                }
                break;
            case ExclamationMark:
                {
                alt7=4;
                }
                break;
            case DigitTwoCommercialAt:
                {
                alt7=5;
                }
                break;
            case DigitTwoExclamationMark:
                {
                alt7=6;
                }
                break;
            case LLD:
                {
                alt7=7;
                }
                break;
            case L_1:
                {
                alt7=8;
                }
                break;
            case LST:
                {
                alt7=9;
                }
                break;
            case L:
                {
                alt7=10;
                }
                break;
            case TLD:
                {
                alt7=11;
                }
                break;
            case T_1:
                {
                alt7=12;
                }
                break;
            case TST:
                {
                alt7=13;
                }
                break;
            case T:
                {
                alt7=14;
                }
                break;
            case ST_1:
                {
                alt7=15;
                }
                break;
            case PlusSignExclamationMark:
                {
                alt7=16;
                }
                break;
            case INC:
                {
                alt7=17;
                }
                break;
            case DEC:
                {
                alt7=18;
                }
                break;
            case ON:
                {
                alt7=19;
                }
                break;
            case OFF:
                {
                alt7=20;
                }
                break;
            case ERASE:
                {
                alt7=21;
                }
                break;
            case FILL:
                {
                alt7=22;
                }
                break;
            case COUNT:
                {
                alt7=23;
                }
                break;
            case MOVE:
                {
                alt7=24;
                }
                break;
            case PLACE:
                {
                alt7=25;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:636:3: lv_name_1_1= LD
                    {
                    lv_name_1_1=(Token)match(input,LD,FOLLOW_LD_in_ruleIntrinsicMemoryWords1412); 

                            newLeafNode(lv_name_1_1, grammarAccess.getIntrinsicMemoryWordsAccess().getNameLDKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:649:8: lv_name_1_2= CommercialAt
                    {
                    lv_name_1_2=(Token)match(input,CommercialAt,FOLLOW_CommercialAt_in_ruleIntrinsicMemoryWords1440); 

                            newLeafNode(lv_name_1_2, grammarAccess.getIntrinsicMemoryWordsAccess().getNameCommercialAtKeyword_1_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:662:8: lv_name_1_3= ST
                    {
                    lv_name_1_3=(Token)match(input,ST,FOLLOW_ST_in_ruleIntrinsicMemoryWords1468); 

                            newLeafNode(lv_name_1_3, grammarAccess.getIntrinsicMemoryWordsAccess().getNameSTKeyword_1_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_3, null);
                    	    

                    }
                    break;
                case 4 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:675:8: lv_name_1_4= ExclamationMark
                    {
                    lv_name_1_4=(Token)match(input,ExclamationMark,FOLLOW_ExclamationMark_in_ruleIntrinsicMemoryWords1496); 

                            newLeafNode(lv_name_1_4, grammarAccess.getIntrinsicMemoryWordsAccess().getNameExclamationMarkKeyword_1_0_3());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_4, null);
                    	    

                    }
                    break;
                case 5 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:688:8: lv_name_1_5= DigitTwoCommercialAt
                    {
                    lv_name_1_5=(Token)match(input,DigitTwoCommercialAt,FOLLOW_DigitTwoCommercialAt_in_ruleIntrinsicMemoryWords1524); 

                            newLeafNode(lv_name_1_5, grammarAccess.getIntrinsicMemoryWordsAccess().getName2Keyword_1_0_4());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_5, null);
                    	    

                    }
                    break;
                case 6 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:701:8: lv_name_1_6= DigitTwoExclamationMark
                    {
                    lv_name_1_6=(Token)match(input,DigitTwoExclamationMark,FOLLOW_DigitTwoExclamationMark_in_ruleIntrinsicMemoryWords1552); 

                            newLeafNode(lv_name_1_6, grammarAccess.getIntrinsicMemoryWordsAccess().getName2Keyword_1_0_5());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_6, null);
                    	    

                    }
                    break;
                case 7 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:714:8: lv_name_1_7= LLD
                    {
                    lv_name_1_7=(Token)match(input,LLD,FOLLOW_LLD_in_ruleIntrinsicMemoryWords1580); 

                            newLeafNode(lv_name_1_7, grammarAccess.getIntrinsicMemoryWordsAccess().getNameLLDKeyword_1_0_6());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_7, null);
                    	    

                    }
                    break;
                case 8 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:727:8: lv_name_1_8= L_1
                    {
                    lv_name_1_8=(Token)match(input,L_1,FOLLOW_L_1_in_ruleIntrinsicMemoryWords1608); 

                            newLeafNode(lv_name_1_8, grammarAccess.getIntrinsicMemoryWordsAccess().getNameLKeyword_1_0_7());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_8, null);
                    	    

                    }
                    break;
                case 9 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:740:8: lv_name_1_9= LST
                    {
                    lv_name_1_9=(Token)match(input,LST,FOLLOW_LST_in_ruleIntrinsicMemoryWords1636); 

                            newLeafNode(lv_name_1_9, grammarAccess.getIntrinsicMemoryWordsAccess().getNameLSTKeyword_1_0_8());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_9, null);
                    	    

                    }
                    break;
                case 10 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:753:8: lv_name_1_10= L
                    {
                    lv_name_1_10=(Token)match(input,L,FOLLOW_L_in_ruleIntrinsicMemoryWords1664); 

                            newLeafNode(lv_name_1_10, grammarAccess.getIntrinsicMemoryWordsAccess().getNameLKeyword_1_0_9());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_10, null);
                    	    

                    }
                    break;
                case 11 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:766:8: lv_name_1_11= TLD
                    {
                    lv_name_1_11=(Token)match(input,TLD,FOLLOW_TLD_in_ruleIntrinsicMemoryWords1692); 

                            newLeafNode(lv_name_1_11, grammarAccess.getIntrinsicMemoryWordsAccess().getNameTLDKeyword_1_0_10());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_11, null);
                    	    

                    }
                    break;
                case 12 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:779:8: lv_name_1_12= T_1
                    {
                    lv_name_1_12=(Token)match(input,T_1,FOLLOW_T_1_in_ruleIntrinsicMemoryWords1720); 

                            newLeafNode(lv_name_1_12, grammarAccess.getIntrinsicMemoryWordsAccess().getNameTKeyword_1_0_11());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_12, null);
                    	    

                    }
                    break;
                case 13 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:792:8: lv_name_1_13= TST
                    {
                    lv_name_1_13=(Token)match(input,TST,FOLLOW_TST_in_ruleIntrinsicMemoryWords1748); 

                            newLeafNode(lv_name_1_13, grammarAccess.getIntrinsicMemoryWordsAccess().getNameTSTKeyword_1_0_12());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_13, null);
                    	    

                    }
                    break;
                case 14 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:805:8: lv_name_1_14= T
                    {
                    lv_name_1_14=(Token)match(input,T,FOLLOW_T_in_ruleIntrinsicMemoryWords1776); 

                            newLeafNode(lv_name_1_14, grammarAccess.getIntrinsicMemoryWordsAccess().getNameTKeyword_1_0_13());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_14, null);
                    	    

                    }
                    break;
                case 15 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:818:8: lv_name_1_15= ST_1
                    {
                    lv_name_1_15=(Token)match(input,ST_1,FOLLOW_ST_1_in_ruleIntrinsicMemoryWords1804); 

                            newLeafNode(lv_name_1_15, grammarAccess.getIntrinsicMemoryWordsAccess().getNameSTKeyword_1_0_14());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_15, null);
                    	    

                    }
                    break;
                case 16 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:831:8: lv_name_1_16= PlusSignExclamationMark
                    {
                    lv_name_1_16=(Token)match(input,PlusSignExclamationMark,FOLLOW_PlusSignExclamationMark_in_ruleIntrinsicMemoryWords1832); 

                            newLeafNode(lv_name_1_16, grammarAccess.getIntrinsicMemoryWordsAccess().getNamePlusSignExclamationMarkKeyword_1_0_15());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_16, null);
                    	    

                    }
                    break;
                case 17 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:844:8: lv_name_1_17= INC
                    {
                    lv_name_1_17=(Token)match(input,INC,FOLLOW_INC_in_ruleIntrinsicMemoryWords1860); 

                            newLeafNode(lv_name_1_17, grammarAccess.getIntrinsicMemoryWordsAccess().getNameINCKeyword_1_0_16());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_17, null);
                    	    

                    }
                    break;
                case 18 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:857:8: lv_name_1_18= DEC
                    {
                    lv_name_1_18=(Token)match(input,DEC,FOLLOW_DEC_in_ruleIntrinsicMemoryWords1888); 

                            newLeafNode(lv_name_1_18, grammarAccess.getIntrinsicMemoryWordsAccess().getNameDECKeyword_1_0_17());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_18, null);
                    	    

                    }
                    break;
                case 19 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:870:8: lv_name_1_19= ON
                    {
                    lv_name_1_19=(Token)match(input,ON,FOLLOW_ON_in_ruleIntrinsicMemoryWords1916); 

                            newLeafNode(lv_name_1_19, grammarAccess.getIntrinsicMemoryWordsAccess().getNameONKeyword_1_0_18());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_19, null);
                    	    

                    }
                    break;
                case 20 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:883:8: lv_name_1_20= OFF
                    {
                    lv_name_1_20=(Token)match(input,OFF,FOLLOW_OFF_in_ruleIntrinsicMemoryWords1944); 

                            newLeafNode(lv_name_1_20, grammarAccess.getIntrinsicMemoryWordsAccess().getNameOFFKeyword_1_0_19());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_20, null);
                    	    

                    }
                    break;
                case 21 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:896:8: lv_name_1_21= ERASE
                    {
                    lv_name_1_21=(Token)match(input,ERASE,FOLLOW_ERASE_in_ruleIntrinsicMemoryWords1972); 

                            newLeafNode(lv_name_1_21, grammarAccess.getIntrinsicMemoryWordsAccess().getNameERASEKeyword_1_0_20());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_21, null);
                    	    

                    }
                    break;
                case 22 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:909:8: lv_name_1_22= FILL
                    {
                    lv_name_1_22=(Token)match(input,FILL,FOLLOW_FILL_in_ruleIntrinsicMemoryWords2000); 

                            newLeafNode(lv_name_1_22, grammarAccess.getIntrinsicMemoryWordsAccess().getNameFILLKeyword_1_0_21());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_22, null);
                    	    

                    }
                    break;
                case 23 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:922:8: lv_name_1_23= COUNT
                    {
                    lv_name_1_23=(Token)match(input,COUNT,FOLLOW_COUNT_in_ruleIntrinsicMemoryWords2028); 

                            newLeafNode(lv_name_1_23, grammarAccess.getIntrinsicMemoryWordsAccess().getNameCOUNTKeyword_1_0_22());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_23, null);
                    	    

                    }
                    break;
                case 24 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:935:8: lv_name_1_24= MOVE
                    {
                    lv_name_1_24=(Token)match(input,MOVE,FOLLOW_MOVE_in_ruleIntrinsicMemoryWords2056); 

                            newLeafNode(lv_name_1_24, grammarAccess.getIntrinsicMemoryWordsAccess().getNameMOVEKeyword_1_0_23());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_24, null);
                    	    

                    }
                    break;
                case 25 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:948:8: lv_name_1_25= PLACE
                    {
                    lv_name_1_25=(Token)match(input,PLACE,FOLLOW_PLACE_in_ruleIntrinsicMemoryWords2084); 

                            newLeafNode(lv_name_1_25, grammarAccess.getIntrinsicMemoryWordsAccess().getNamePLACEKeyword_1_0_24());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicMemoryWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_25, null);
                    	    

                    }
                    break;

            }


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
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:972:1: entryRuleIntrinsicArithmeticWords returns [EObject current=null] : iv_ruleIntrinsicArithmeticWords= ruleIntrinsicArithmeticWords EOF ;
    public final EObject entryRuleIntrinsicArithmeticWords() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntrinsicArithmeticWords = null;


        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:973:2: (iv_ruleIntrinsicArithmeticWords= ruleIntrinsicArithmeticWords EOF )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:974:2: iv_ruleIntrinsicArithmeticWords= ruleIntrinsicArithmeticWords EOF
            {
             newCompositeNode(grammarAccess.getIntrinsicArithmeticWordsRule()); 
            pushFollow(FOLLOW_ruleIntrinsicArithmeticWords_in_entryRuleIntrinsicArithmeticWords2133);
            iv_ruleIntrinsicArithmeticWords=ruleIntrinsicArithmeticWords();

            state._fsp--;

             current =iv_ruleIntrinsicArithmeticWords; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntrinsicArithmeticWords2143); 

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
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:981:1: ruleIntrinsicArithmeticWords returns [EObject current=null] : ( () ( ( (lv_name_1_1= PlusSign | lv_name_1_2= HyphenMinus | lv_name_1_3= Asterisk | lv_name_1_4= Solidus | lv_name_1_5= DigitTwoAsterisk | lv_name_1_6= DigitTwoSolidus | lv_name_1_7= U2 | lv_name_1_8= ROR | lv_name_1_9= DROR | lv_name_1_10= ROL | lv_name_1_11= DROL | lv_name_1_12= PACK | lv_name_1_13= UNPACK | lv_name_1_14= SHIFT | lv_name_1_15= ASHIFT | lv_name_1_16= DigitTwoAsteriskAsterisk | lv_name_1_17= DigitZeroEqualsSign | lv_name_1_18= DigitZeroLessThanSignGreaterThanSign | lv_name_1_19= DigitZeroLessThanSign | lv_name_1_20= D0 | lv_name_1_21= NEGATE | lv_name_1_22= DNEGATE | lv_name_1_23= DigitOnePlusSign | lv_name_1_24= DigitOneHyphenMinus | lv_name_1_25= TRUE | lv_name_1_26= FALSE | lv_name_1_27= CELL | lv_name_1_28= CELL_1 | lv_name_1_29= CARRY_RESET | lv_name_1_30= CARRYSET | lv_name_1_31= ABS | lv_name_1_32= DABS | lv_name_1_33= EXTEND ) ) ) ) ;
    public final EObject ruleIntrinsicArithmeticWords() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_1=null;
        Token lv_name_1_2=null;
        Token lv_name_1_3=null;
        Token lv_name_1_4=null;
        Token lv_name_1_5=null;
        Token lv_name_1_6=null;
        Token lv_name_1_7=null;
        Token lv_name_1_8=null;
        Token lv_name_1_9=null;
        Token lv_name_1_10=null;
        Token lv_name_1_11=null;
        Token lv_name_1_12=null;
        Token lv_name_1_13=null;
        Token lv_name_1_14=null;
        Token lv_name_1_15=null;
        Token lv_name_1_16=null;
        Token lv_name_1_17=null;
        Token lv_name_1_18=null;
        Token lv_name_1_19=null;
        Token lv_name_1_20=null;
        Token lv_name_1_21=null;
        Token lv_name_1_22=null;
        Token lv_name_1_23=null;
        Token lv_name_1_24=null;
        Token lv_name_1_25=null;
        Token lv_name_1_26=null;
        Token lv_name_1_27=null;
        Token lv_name_1_28=null;
        Token lv_name_1_29=null;
        Token lv_name_1_30=null;
        Token lv_name_1_31=null;
        Token lv_name_1_32=null;
        Token lv_name_1_33=null;

         enterRule(); 
            
        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:984:28: ( ( () ( ( (lv_name_1_1= PlusSign | lv_name_1_2= HyphenMinus | lv_name_1_3= Asterisk | lv_name_1_4= Solidus | lv_name_1_5= DigitTwoAsterisk | lv_name_1_6= DigitTwoSolidus | lv_name_1_7= U2 | lv_name_1_8= ROR | lv_name_1_9= DROR | lv_name_1_10= ROL | lv_name_1_11= DROL | lv_name_1_12= PACK | lv_name_1_13= UNPACK | lv_name_1_14= SHIFT | lv_name_1_15= ASHIFT | lv_name_1_16= DigitTwoAsteriskAsterisk | lv_name_1_17= DigitZeroEqualsSign | lv_name_1_18= DigitZeroLessThanSignGreaterThanSign | lv_name_1_19= DigitZeroLessThanSign | lv_name_1_20= D0 | lv_name_1_21= NEGATE | lv_name_1_22= DNEGATE | lv_name_1_23= DigitOnePlusSign | lv_name_1_24= DigitOneHyphenMinus | lv_name_1_25= TRUE | lv_name_1_26= FALSE | lv_name_1_27= CELL | lv_name_1_28= CELL_1 | lv_name_1_29= CARRY_RESET | lv_name_1_30= CARRYSET | lv_name_1_31= ABS | lv_name_1_32= DABS | lv_name_1_33= EXTEND ) ) ) ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:985:1: ( () ( ( (lv_name_1_1= PlusSign | lv_name_1_2= HyphenMinus | lv_name_1_3= Asterisk | lv_name_1_4= Solidus | lv_name_1_5= DigitTwoAsterisk | lv_name_1_6= DigitTwoSolidus | lv_name_1_7= U2 | lv_name_1_8= ROR | lv_name_1_9= DROR | lv_name_1_10= ROL | lv_name_1_11= DROL | lv_name_1_12= PACK | lv_name_1_13= UNPACK | lv_name_1_14= SHIFT | lv_name_1_15= ASHIFT | lv_name_1_16= DigitTwoAsteriskAsterisk | lv_name_1_17= DigitZeroEqualsSign | lv_name_1_18= DigitZeroLessThanSignGreaterThanSign | lv_name_1_19= DigitZeroLessThanSign | lv_name_1_20= D0 | lv_name_1_21= NEGATE | lv_name_1_22= DNEGATE | lv_name_1_23= DigitOnePlusSign | lv_name_1_24= DigitOneHyphenMinus | lv_name_1_25= TRUE | lv_name_1_26= FALSE | lv_name_1_27= CELL | lv_name_1_28= CELL_1 | lv_name_1_29= CARRY_RESET | lv_name_1_30= CARRYSET | lv_name_1_31= ABS | lv_name_1_32= DABS | lv_name_1_33= EXTEND ) ) ) )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:985:1: ( () ( ( (lv_name_1_1= PlusSign | lv_name_1_2= HyphenMinus | lv_name_1_3= Asterisk | lv_name_1_4= Solidus | lv_name_1_5= DigitTwoAsterisk | lv_name_1_6= DigitTwoSolidus | lv_name_1_7= U2 | lv_name_1_8= ROR | lv_name_1_9= DROR | lv_name_1_10= ROL | lv_name_1_11= DROL | lv_name_1_12= PACK | lv_name_1_13= UNPACK | lv_name_1_14= SHIFT | lv_name_1_15= ASHIFT | lv_name_1_16= DigitTwoAsteriskAsterisk | lv_name_1_17= DigitZeroEqualsSign | lv_name_1_18= DigitZeroLessThanSignGreaterThanSign | lv_name_1_19= DigitZeroLessThanSign | lv_name_1_20= D0 | lv_name_1_21= NEGATE | lv_name_1_22= DNEGATE | lv_name_1_23= DigitOnePlusSign | lv_name_1_24= DigitOneHyphenMinus | lv_name_1_25= TRUE | lv_name_1_26= FALSE | lv_name_1_27= CELL | lv_name_1_28= CELL_1 | lv_name_1_29= CARRY_RESET | lv_name_1_30= CARRYSET | lv_name_1_31= ABS | lv_name_1_32= DABS | lv_name_1_33= EXTEND ) ) ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:985:2: () ( ( (lv_name_1_1= PlusSign | lv_name_1_2= HyphenMinus | lv_name_1_3= Asterisk | lv_name_1_4= Solidus | lv_name_1_5= DigitTwoAsterisk | lv_name_1_6= DigitTwoSolidus | lv_name_1_7= U2 | lv_name_1_8= ROR | lv_name_1_9= DROR | lv_name_1_10= ROL | lv_name_1_11= DROL | lv_name_1_12= PACK | lv_name_1_13= UNPACK | lv_name_1_14= SHIFT | lv_name_1_15= ASHIFT | lv_name_1_16= DigitTwoAsteriskAsterisk | lv_name_1_17= DigitZeroEqualsSign | lv_name_1_18= DigitZeroLessThanSignGreaterThanSign | lv_name_1_19= DigitZeroLessThanSign | lv_name_1_20= D0 | lv_name_1_21= NEGATE | lv_name_1_22= DNEGATE | lv_name_1_23= DigitOnePlusSign | lv_name_1_24= DigitOneHyphenMinus | lv_name_1_25= TRUE | lv_name_1_26= FALSE | lv_name_1_27= CELL | lv_name_1_28= CELL_1 | lv_name_1_29= CARRY_RESET | lv_name_1_30= CARRYSET | lv_name_1_31= ABS | lv_name_1_32= DABS | lv_name_1_33= EXTEND ) ) )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:985:2: ()
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:986:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIntrinsicArithmeticWordsAccess().getIntrinsicArithmeticWordsAction_0(),
                        current);
                

            }

            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:991:2: ( ( (lv_name_1_1= PlusSign | lv_name_1_2= HyphenMinus | lv_name_1_3= Asterisk | lv_name_1_4= Solidus | lv_name_1_5= DigitTwoAsterisk | lv_name_1_6= DigitTwoSolidus | lv_name_1_7= U2 | lv_name_1_8= ROR | lv_name_1_9= DROR | lv_name_1_10= ROL | lv_name_1_11= DROL | lv_name_1_12= PACK | lv_name_1_13= UNPACK | lv_name_1_14= SHIFT | lv_name_1_15= ASHIFT | lv_name_1_16= DigitTwoAsteriskAsterisk | lv_name_1_17= DigitZeroEqualsSign | lv_name_1_18= DigitZeroLessThanSignGreaterThanSign | lv_name_1_19= DigitZeroLessThanSign | lv_name_1_20= D0 | lv_name_1_21= NEGATE | lv_name_1_22= DNEGATE | lv_name_1_23= DigitOnePlusSign | lv_name_1_24= DigitOneHyphenMinus | lv_name_1_25= TRUE | lv_name_1_26= FALSE | lv_name_1_27= CELL | lv_name_1_28= CELL_1 | lv_name_1_29= CARRY_RESET | lv_name_1_30= CARRYSET | lv_name_1_31= ABS | lv_name_1_32= DABS | lv_name_1_33= EXTEND ) ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:992:1: ( (lv_name_1_1= PlusSign | lv_name_1_2= HyphenMinus | lv_name_1_3= Asterisk | lv_name_1_4= Solidus | lv_name_1_5= DigitTwoAsterisk | lv_name_1_6= DigitTwoSolidus | lv_name_1_7= U2 | lv_name_1_8= ROR | lv_name_1_9= DROR | lv_name_1_10= ROL | lv_name_1_11= DROL | lv_name_1_12= PACK | lv_name_1_13= UNPACK | lv_name_1_14= SHIFT | lv_name_1_15= ASHIFT | lv_name_1_16= DigitTwoAsteriskAsterisk | lv_name_1_17= DigitZeroEqualsSign | lv_name_1_18= DigitZeroLessThanSignGreaterThanSign | lv_name_1_19= DigitZeroLessThanSign | lv_name_1_20= D0 | lv_name_1_21= NEGATE | lv_name_1_22= DNEGATE | lv_name_1_23= DigitOnePlusSign | lv_name_1_24= DigitOneHyphenMinus | lv_name_1_25= TRUE | lv_name_1_26= FALSE | lv_name_1_27= CELL | lv_name_1_28= CELL_1 | lv_name_1_29= CARRY_RESET | lv_name_1_30= CARRYSET | lv_name_1_31= ABS | lv_name_1_32= DABS | lv_name_1_33= EXTEND ) )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:992:1: ( (lv_name_1_1= PlusSign | lv_name_1_2= HyphenMinus | lv_name_1_3= Asterisk | lv_name_1_4= Solidus | lv_name_1_5= DigitTwoAsterisk | lv_name_1_6= DigitTwoSolidus | lv_name_1_7= U2 | lv_name_1_8= ROR | lv_name_1_9= DROR | lv_name_1_10= ROL | lv_name_1_11= DROL | lv_name_1_12= PACK | lv_name_1_13= UNPACK | lv_name_1_14= SHIFT | lv_name_1_15= ASHIFT | lv_name_1_16= DigitTwoAsteriskAsterisk | lv_name_1_17= DigitZeroEqualsSign | lv_name_1_18= DigitZeroLessThanSignGreaterThanSign | lv_name_1_19= DigitZeroLessThanSign | lv_name_1_20= D0 | lv_name_1_21= NEGATE | lv_name_1_22= DNEGATE | lv_name_1_23= DigitOnePlusSign | lv_name_1_24= DigitOneHyphenMinus | lv_name_1_25= TRUE | lv_name_1_26= FALSE | lv_name_1_27= CELL | lv_name_1_28= CELL_1 | lv_name_1_29= CARRY_RESET | lv_name_1_30= CARRYSET | lv_name_1_31= ABS | lv_name_1_32= DABS | lv_name_1_33= EXTEND ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:993:1: (lv_name_1_1= PlusSign | lv_name_1_2= HyphenMinus | lv_name_1_3= Asterisk | lv_name_1_4= Solidus | lv_name_1_5= DigitTwoAsterisk | lv_name_1_6= DigitTwoSolidus | lv_name_1_7= U2 | lv_name_1_8= ROR | lv_name_1_9= DROR | lv_name_1_10= ROL | lv_name_1_11= DROL | lv_name_1_12= PACK | lv_name_1_13= UNPACK | lv_name_1_14= SHIFT | lv_name_1_15= ASHIFT | lv_name_1_16= DigitTwoAsteriskAsterisk | lv_name_1_17= DigitZeroEqualsSign | lv_name_1_18= DigitZeroLessThanSignGreaterThanSign | lv_name_1_19= DigitZeroLessThanSign | lv_name_1_20= D0 | lv_name_1_21= NEGATE | lv_name_1_22= DNEGATE | lv_name_1_23= DigitOnePlusSign | lv_name_1_24= DigitOneHyphenMinus | lv_name_1_25= TRUE | lv_name_1_26= FALSE | lv_name_1_27= CELL | lv_name_1_28= CELL_1 | lv_name_1_29= CARRY_RESET | lv_name_1_30= CARRYSET | lv_name_1_31= ABS | lv_name_1_32= DABS | lv_name_1_33= EXTEND )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:993:1: (lv_name_1_1= PlusSign | lv_name_1_2= HyphenMinus | lv_name_1_3= Asterisk | lv_name_1_4= Solidus | lv_name_1_5= DigitTwoAsterisk | lv_name_1_6= DigitTwoSolidus | lv_name_1_7= U2 | lv_name_1_8= ROR | lv_name_1_9= DROR | lv_name_1_10= ROL | lv_name_1_11= DROL | lv_name_1_12= PACK | lv_name_1_13= UNPACK | lv_name_1_14= SHIFT | lv_name_1_15= ASHIFT | lv_name_1_16= DigitTwoAsteriskAsterisk | lv_name_1_17= DigitZeroEqualsSign | lv_name_1_18= DigitZeroLessThanSignGreaterThanSign | lv_name_1_19= DigitZeroLessThanSign | lv_name_1_20= D0 | lv_name_1_21= NEGATE | lv_name_1_22= DNEGATE | lv_name_1_23= DigitOnePlusSign | lv_name_1_24= DigitOneHyphenMinus | lv_name_1_25= TRUE | lv_name_1_26= FALSE | lv_name_1_27= CELL | lv_name_1_28= CELL_1 | lv_name_1_29= CARRY_RESET | lv_name_1_30= CARRYSET | lv_name_1_31= ABS | lv_name_1_32= DABS | lv_name_1_33= EXTEND )
            int alt8=33;
            switch ( input.LA(1) ) {
            case PlusSign:
                {
                alt8=1;
                }
                break;
            case HyphenMinus:
                {
                alt8=2;
                }
                break;
            case Asterisk:
                {
                alt8=3;
                }
                break;
            case Solidus:
                {
                alt8=4;
                }
                break;
            case DigitTwoAsterisk:
                {
                alt8=5;
                }
                break;
            case DigitTwoSolidus:
                {
                alt8=6;
                }
                break;
            case U2:
                {
                alt8=7;
                }
                break;
            case ROR:
                {
                alt8=8;
                }
                break;
            case DROR:
                {
                alt8=9;
                }
                break;
            case ROL:
                {
                alt8=10;
                }
                break;
            case DROL:
                {
                alt8=11;
                }
                break;
            case PACK:
                {
                alt8=12;
                }
                break;
            case UNPACK:
                {
                alt8=13;
                }
                break;
            case SHIFT:
                {
                alt8=14;
                }
                break;
            case ASHIFT:
                {
                alt8=15;
                }
                break;
            case DigitTwoAsteriskAsterisk:
                {
                alt8=16;
                }
                break;
            case DigitZeroEqualsSign:
                {
                alt8=17;
                }
                break;
            case DigitZeroLessThanSignGreaterThanSign:
                {
                alt8=18;
                }
                break;
            case DigitZeroLessThanSign:
                {
                alt8=19;
                }
                break;
            case D0:
                {
                alt8=20;
                }
                break;
            case NEGATE:
                {
                alt8=21;
                }
                break;
            case DNEGATE:
                {
                alt8=22;
                }
                break;
            case DigitOnePlusSign:
                {
                alt8=23;
                }
                break;
            case DigitOneHyphenMinus:
                {
                alt8=24;
                }
                break;
            case TRUE:
                {
                alt8=25;
                }
                break;
            case FALSE:
                {
                alt8=26;
                }
                break;
            case CELL:
                {
                alt8=27;
                }
                break;
            case CELL_1:
                {
                alt8=28;
                }
                break;
            case CARRY_RESET:
                {
                alt8=29;
                }
                break;
            case CARRYSET:
                {
                alt8=30;
                }
                break;
            case ABS:
                {
                alt8=31;
                }
                break;
            case DABS:
                {
                alt8=32;
                }
                break;
            case EXTEND:
                {
                alt8=33;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:994:3: lv_name_1_1= PlusSign
                    {
                    lv_name_1_1=(Token)match(input,PlusSign,FOLLOW_PlusSign_in_ruleIntrinsicArithmeticWords2198); 

                            newLeafNode(lv_name_1_1, grammarAccess.getIntrinsicArithmeticWordsAccess().getNamePlusSignKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1007:8: lv_name_1_2= HyphenMinus
                    {
                    lv_name_1_2=(Token)match(input,HyphenMinus,FOLLOW_HyphenMinus_in_ruleIntrinsicArithmeticWords2226); 

                            newLeafNode(lv_name_1_2, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameHyphenMinusKeyword_1_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1020:8: lv_name_1_3= Asterisk
                    {
                    lv_name_1_3=(Token)match(input,Asterisk,FOLLOW_Asterisk_in_ruleIntrinsicArithmeticWords2254); 

                            newLeafNode(lv_name_1_3, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameAsteriskKeyword_1_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_3, null);
                    	    

                    }
                    break;
                case 4 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1033:8: lv_name_1_4= Solidus
                    {
                    lv_name_1_4=(Token)match(input,Solidus,FOLLOW_Solidus_in_ruleIntrinsicArithmeticWords2282); 

                            newLeafNode(lv_name_1_4, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameSolidusKeyword_1_0_3());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_4, null);
                    	    

                    }
                    break;
                case 5 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1046:8: lv_name_1_5= DigitTwoAsterisk
                    {
                    lv_name_1_5=(Token)match(input,DigitTwoAsterisk,FOLLOW_DigitTwoAsterisk_in_ruleIntrinsicArithmeticWords2310); 

                            newLeafNode(lv_name_1_5, grammarAccess.getIntrinsicArithmeticWordsAccess().getName2Keyword_1_0_4());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_5, null);
                    	    

                    }
                    break;
                case 6 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1059:8: lv_name_1_6= DigitTwoSolidus
                    {
                    lv_name_1_6=(Token)match(input,DigitTwoSolidus,FOLLOW_DigitTwoSolidus_in_ruleIntrinsicArithmeticWords2338); 

                            newLeafNode(lv_name_1_6, grammarAccess.getIntrinsicArithmeticWordsAccess().getName2Keyword_1_0_5());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_6, null);
                    	    

                    }
                    break;
                case 7 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1072:8: lv_name_1_7= U2
                    {
                    lv_name_1_7=(Token)match(input,U2,FOLLOW_U2_in_ruleIntrinsicArithmeticWords2366); 

                            newLeafNode(lv_name_1_7, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameU2Keyword_1_0_6());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_7, null);
                    	    

                    }
                    break;
                case 8 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1085:8: lv_name_1_8= ROR
                    {
                    lv_name_1_8=(Token)match(input,ROR,FOLLOW_ROR_in_ruleIntrinsicArithmeticWords2394); 

                            newLeafNode(lv_name_1_8, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameRORKeyword_1_0_7());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_8, null);
                    	    

                    }
                    break;
                case 9 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1098:8: lv_name_1_9= DROR
                    {
                    lv_name_1_9=(Token)match(input,DROR,FOLLOW_DROR_in_ruleIntrinsicArithmeticWords2422); 

                            newLeafNode(lv_name_1_9, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameDRORKeyword_1_0_8());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_9, null);
                    	    

                    }
                    break;
                case 10 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1111:8: lv_name_1_10= ROL
                    {
                    lv_name_1_10=(Token)match(input,ROL,FOLLOW_ROL_in_ruleIntrinsicArithmeticWords2450); 

                            newLeafNode(lv_name_1_10, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameROLKeyword_1_0_9());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_10, null);
                    	    

                    }
                    break;
                case 11 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1124:8: lv_name_1_11= DROL
                    {
                    lv_name_1_11=(Token)match(input,DROL,FOLLOW_DROL_in_ruleIntrinsicArithmeticWords2478); 

                            newLeafNode(lv_name_1_11, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameDROLKeyword_1_0_10());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_11, null);
                    	    

                    }
                    break;
                case 12 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1137:8: lv_name_1_12= PACK
                    {
                    lv_name_1_12=(Token)match(input,PACK,FOLLOW_PACK_in_ruleIntrinsicArithmeticWords2506); 

                            newLeafNode(lv_name_1_12, grammarAccess.getIntrinsicArithmeticWordsAccess().getNamePACKKeyword_1_0_11());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_12, null);
                    	    

                    }
                    break;
                case 13 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1150:8: lv_name_1_13= UNPACK
                    {
                    lv_name_1_13=(Token)match(input,UNPACK,FOLLOW_UNPACK_in_ruleIntrinsicArithmeticWords2534); 

                            newLeafNode(lv_name_1_13, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameUNPACKKeyword_1_0_12());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_13, null);
                    	    

                    }
                    break;
                case 14 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1163:8: lv_name_1_14= SHIFT
                    {
                    lv_name_1_14=(Token)match(input,SHIFT,FOLLOW_SHIFT_in_ruleIntrinsicArithmeticWords2562); 

                            newLeafNode(lv_name_1_14, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameSHIFTKeyword_1_0_13());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_14, null);
                    	    

                    }
                    break;
                case 15 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1176:8: lv_name_1_15= ASHIFT
                    {
                    lv_name_1_15=(Token)match(input,ASHIFT,FOLLOW_ASHIFT_in_ruleIntrinsicArithmeticWords2590); 

                            newLeafNode(lv_name_1_15, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameASHIFTKeyword_1_0_14());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_15, null);
                    	    

                    }
                    break;
                case 16 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1189:8: lv_name_1_16= DigitTwoAsteriskAsterisk
                    {
                    lv_name_1_16=(Token)match(input,DigitTwoAsteriskAsterisk,FOLLOW_DigitTwoAsteriskAsterisk_in_ruleIntrinsicArithmeticWords2618); 

                            newLeafNode(lv_name_1_16, grammarAccess.getIntrinsicArithmeticWordsAccess().getName2Keyword_1_0_15());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_16, null);
                    	    

                    }
                    break;
                case 17 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1202:8: lv_name_1_17= DigitZeroEqualsSign
                    {
                    lv_name_1_17=(Token)match(input,DigitZeroEqualsSign,FOLLOW_DigitZeroEqualsSign_in_ruleIntrinsicArithmeticWords2646); 

                            newLeafNode(lv_name_1_17, grammarAccess.getIntrinsicArithmeticWordsAccess().getName0Keyword_1_0_16());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_17, null);
                    	    

                    }
                    break;
                case 18 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1215:8: lv_name_1_18= DigitZeroLessThanSignGreaterThanSign
                    {
                    lv_name_1_18=(Token)match(input,DigitZeroLessThanSignGreaterThanSign,FOLLOW_DigitZeroLessThanSignGreaterThanSign_in_ruleIntrinsicArithmeticWords2674); 

                            newLeafNode(lv_name_1_18, grammarAccess.getIntrinsicArithmeticWordsAccess().getName0Keyword_1_0_17());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_18, null);
                    	    

                    }
                    break;
                case 19 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1228:8: lv_name_1_19= DigitZeroLessThanSign
                    {
                    lv_name_1_19=(Token)match(input,DigitZeroLessThanSign,FOLLOW_DigitZeroLessThanSign_in_ruleIntrinsicArithmeticWords2702); 

                            newLeafNode(lv_name_1_19, grammarAccess.getIntrinsicArithmeticWordsAccess().getName0Keyword_1_0_18());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_19, null);
                    	    

                    }
                    break;
                case 20 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1241:8: lv_name_1_20= D0
                    {
                    lv_name_1_20=(Token)match(input,D0,FOLLOW_D0_in_ruleIntrinsicArithmeticWords2730); 

                            newLeafNode(lv_name_1_20, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameD0Keyword_1_0_19());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_20, null);
                    	    

                    }
                    break;
                case 21 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1254:8: lv_name_1_21= NEGATE
                    {
                    lv_name_1_21=(Token)match(input,NEGATE,FOLLOW_NEGATE_in_ruleIntrinsicArithmeticWords2758); 

                            newLeafNode(lv_name_1_21, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameNEGATEKeyword_1_0_20());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_21, null);
                    	    

                    }
                    break;
                case 22 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1267:8: lv_name_1_22= DNEGATE
                    {
                    lv_name_1_22=(Token)match(input,DNEGATE,FOLLOW_DNEGATE_in_ruleIntrinsicArithmeticWords2786); 

                            newLeafNode(lv_name_1_22, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameDNEGATEKeyword_1_0_21());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_22, null);
                    	    

                    }
                    break;
                case 23 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1280:8: lv_name_1_23= DigitOnePlusSign
                    {
                    lv_name_1_23=(Token)match(input,DigitOnePlusSign,FOLLOW_DigitOnePlusSign_in_ruleIntrinsicArithmeticWords2814); 

                            newLeafNode(lv_name_1_23, grammarAccess.getIntrinsicArithmeticWordsAccess().getName1Keyword_1_0_22());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_23, null);
                    	    

                    }
                    break;
                case 24 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1293:8: lv_name_1_24= DigitOneHyphenMinus
                    {
                    lv_name_1_24=(Token)match(input,DigitOneHyphenMinus,FOLLOW_DigitOneHyphenMinus_in_ruleIntrinsicArithmeticWords2842); 

                            newLeafNode(lv_name_1_24, grammarAccess.getIntrinsicArithmeticWordsAccess().getName1Keyword_1_0_23());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_24, null);
                    	    

                    }
                    break;
                case 25 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1306:8: lv_name_1_25= TRUE
                    {
                    lv_name_1_25=(Token)match(input,TRUE,FOLLOW_TRUE_in_ruleIntrinsicArithmeticWords2870); 

                            newLeafNode(lv_name_1_25, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameTRUEKeyword_1_0_24());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_25, null);
                    	    

                    }
                    break;
                case 26 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1319:8: lv_name_1_26= FALSE
                    {
                    lv_name_1_26=(Token)match(input,FALSE,FOLLOW_FALSE_in_ruleIntrinsicArithmeticWords2898); 

                            newLeafNode(lv_name_1_26, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameFALSEKeyword_1_0_25());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_26, null);
                    	    

                    }
                    break;
                case 27 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1332:8: lv_name_1_27= CELL
                    {
                    lv_name_1_27=(Token)match(input,CELL,FOLLOW_CELL_in_ruleIntrinsicArithmeticWords2926); 

                            newLeafNode(lv_name_1_27, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameCELLKeyword_1_0_26());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_27, null);
                    	    

                    }
                    break;
                case 28 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1345:8: lv_name_1_28= CELL_1
                    {
                    lv_name_1_28=(Token)match(input,CELL_1,FOLLOW_CELL_1_in_ruleIntrinsicArithmeticWords2954); 

                            newLeafNode(lv_name_1_28, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameCELLKeyword_1_0_27());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_28, null);
                    	    

                    }
                    break;
                case 29 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1358:8: lv_name_1_29= CARRY_RESET
                    {
                    lv_name_1_29=(Token)match(input,CARRY_RESET,FOLLOW_CARRY_RESET_in_ruleIntrinsicArithmeticWords2982); 

                            newLeafNode(lv_name_1_29, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameCARRY_RESETKeyword_1_0_28());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_29, null);
                    	    

                    }
                    break;
                case 30 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1371:8: lv_name_1_30= CARRYSET
                    {
                    lv_name_1_30=(Token)match(input,CARRYSET,FOLLOW_CARRYSET_in_ruleIntrinsicArithmeticWords3010); 

                            newLeafNode(lv_name_1_30, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameCARRYSETKeyword_1_0_29());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_30, null);
                    	    

                    }
                    break;
                case 31 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1384:8: lv_name_1_31= ABS
                    {
                    lv_name_1_31=(Token)match(input,ABS,FOLLOW_ABS_in_ruleIntrinsicArithmeticWords3038); 

                            newLeafNode(lv_name_1_31, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameABSKeyword_1_0_30());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_31, null);
                    	    

                    }
                    break;
                case 32 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1397:8: lv_name_1_32= DABS
                    {
                    lv_name_1_32=(Token)match(input,DABS,FOLLOW_DABS_in_ruleIntrinsicArithmeticWords3066); 

                            newLeafNode(lv_name_1_32, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameDABSKeyword_1_0_31());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_32, null);
                    	    

                    }
                    break;
                case 33 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1410:8: lv_name_1_33= EXTEND
                    {
                    lv_name_1_33=(Token)match(input,EXTEND,FOLLOW_EXTEND_in_ruleIntrinsicArithmeticWords3094); 

                            newLeafNode(lv_name_1_33, grammarAccess.getIntrinsicArithmeticWordsAccess().getNameEXTENDKeyword_1_0_32());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntrinsicArithmeticWordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_33, null);
                    	    

                    }
                    break;

            }


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
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1434:1: entryRuleWord returns [EObject current=null] : iv_ruleWord= ruleWord EOF ;
    public final EObject entryRuleWord() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWord = null;


        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1435:2: (iv_ruleWord= ruleWord EOF )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1436:2: iv_ruleWord= ruleWord EOF
            {
             newCompositeNode(grammarAccess.getWordRule()); 
            pushFollow(FOLLOW_ruleWord_in_entryRuleWord3143);
            iv_ruleWord=ruleWord();

            state._fsp--;

             current =iv_ruleWord; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWord3153); 

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
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1443:1: ruleWord returns [EObject current=null] : (this_IntrinsicStackWords_0= ruleIntrinsicStackWords | this_IntrinsicMemoryWords_1= ruleIntrinsicMemoryWords | this_IntrinsicArithmeticWords_2= ruleIntrinsicArithmeticWords | ( (lv_name_3_0= ruleLITERAL ) ) | ( (lv_name_4_0= RULE_ID ) ) ) ;
    public final EObject ruleWord() throws RecognitionException {
        EObject current = null;

        Token lv_name_4_0=null;
        EObject this_IntrinsicStackWords_0 = null;

        EObject this_IntrinsicMemoryWords_1 = null;

        EObject this_IntrinsicArithmeticWords_2 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;


         enterRule(); 
            
        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1446:28: ( (this_IntrinsicStackWords_0= ruleIntrinsicStackWords | this_IntrinsicMemoryWords_1= ruleIntrinsicMemoryWords | this_IntrinsicArithmeticWords_2= ruleIntrinsicArithmeticWords | ( (lv_name_3_0= ruleLITERAL ) ) | ( (lv_name_4_0= RULE_ID ) ) ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1447:1: (this_IntrinsicStackWords_0= ruleIntrinsicStackWords | this_IntrinsicMemoryWords_1= ruleIntrinsicMemoryWords | this_IntrinsicArithmeticWords_2= ruleIntrinsicArithmeticWords | ( (lv_name_3_0= ruleLITERAL ) ) | ( (lv_name_4_0= RULE_ID ) ) )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1447:1: (this_IntrinsicStackWords_0= ruleIntrinsicStackWords | this_IntrinsicMemoryWords_1= ruleIntrinsicMemoryWords | this_IntrinsicArithmeticWords_2= ruleIntrinsicArithmeticWords | ( (lv_name_3_0= ruleLITERAL ) ) | ( (lv_name_4_0= RULE_ID ) ) )
            int alt9=5;
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
                alt9=1;
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
                alt9=2;
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
                alt9=3;
                }
                break;
            case RULE_INT:
            case RULE_DOUBLE:
                {
                alt9=4;
                }
                break;
            case RULE_ID:
                {
                alt9=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1448:5: this_IntrinsicStackWords_0= ruleIntrinsicStackWords
                    {
                     
                            newCompositeNode(grammarAccess.getWordAccess().getIntrinsicStackWordsParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleIntrinsicStackWords_in_ruleWord3200);
                    this_IntrinsicStackWords_0=ruleIntrinsicStackWords();

                    state._fsp--;


                            current = this_IntrinsicStackWords_0;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1458:5: this_IntrinsicMemoryWords_1= ruleIntrinsicMemoryWords
                    {
                     
                            newCompositeNode(grammarAccess.getWordAccess().getIntrinsicMemoryWordsParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleIntrinsicMemoryWords_in_ruleWord3227);
                    this_IntrinsicMemoryWords_1=ruleIntrinsicMemoryWords();

                    state._fsp--;


                            current = this_IntrinsicMemoryWords_1;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1468:5: this_IntrinsicArithmeticWords_2= ruleIntrinsicArithmeticWords
                    {
                     
                            newCompositeNode(grammarAccess.getWordAccess().getIntrinsicArithmeticWordsParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleIntrinsicArithmeticWords_in_ruleWord3254);
                    this_IntrinsicArithmeticWords_2=ruleIntrinsicArithmeticWords();

                    state._fsp--;


                            current = this_IntrinsicArithmeticWords_2;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1477:6: ( (lv_name_3_0= ruleLITERAL ) )
                    {
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1477:6: ( (lv_name_3_0= ruleLITERAL ) )
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1478:1: (lv_name_3_0= ruleLITERAL )
                    {
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1478:1: (lv_name_3_0= ruleLITERAL )
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1479:3: lv_name_3_0= ruleLITERAL
                    {
                     
                    	        newCompositeNode(grammarAccess.getWordAccess().getNameLITERALParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleLITERAL_in_ruleWord3280);
                    lv_name_3_0=ruleLITERAL();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getWordRule());
                    	        }
                           		set(
                           			current, 
                           			"name",
                            		lv_name_3_0, 
                            		"LITERAL");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1496:6: ( (lv_name_4_0= RULE_ID ) )
                    {
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1496:6: ( (lv_name_4_0= RULE_ID ) )
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1497:1: (lv_name_4_0= RULE_ID )
                    {
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1497:1: (lv_name_4_0= RULE_ID )
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:1498:3: lv_name_4_0= RULE_ID
                    {
                    lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleWord3303); 

                    			newLeafNode(lv_name_4_0, grammarAccess.getWordAccess().getNameIDTerminalRuleCall_4_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getWordRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_4_0, 
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
    public static final BitSet FOLLOW_ruleInstruction_in_ruleForth122 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF2L,0x000000001C2EFFFFL});
    public static final BitSet FOLLOW_ruleInstruction_in_entryRuleInstruction157 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstruction167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreate_in_ruleInstruction214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_ruleInstruction241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWord_in_ruleInstruction268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_entryRuleFunction302 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunction312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Colon_in_ruleFunction350 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000001C3EFFFFL});
    public static final BitSet FOLLOW_ruleWord_in_ruleFunction370 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000001C3EFFFFL});
    public static final BitSet FOLLOW_ruleWord_in_ruleFunction391 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000001C3EFFFFL});
    public static final BitSet FOLLOW_Semicolon_in_ruleFunction405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreate_in_entryRuleCreate439 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCreate449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Create_in_ruleCreate487 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCreate503 = new BitSet(new long[]{0x0000000000000002L,0x000000000C000000L});
    public static final BitSet FOLLOW_ruleLITERAL_in_ruleCreate530 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_Comma_in_ruleCreate543 = new BitSet(new long[]{0x0000000000000002L,0x000000000C000000L});
    public static final BitSet FOLLOW_ruleLITERAL_in_entryRuleLITERAL580 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLITERAL591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleLITERAL631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOUBLE_in_ruleLITERAL657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntrinsicStackWords_in_entryRuleIntrinsicStackWords701 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntrinsicStackWords711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CLEAR_in_ruleIntrinsicStackWords766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_ruleIntrinsicStackWords794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DUP_in_ruleIntrinsicStackWords822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DUP_2_in_ruleIntrinsicStackWords850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SWAP_in_ruleIntrinsicStackWords878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NIP_in_ruleIntrinsicStackWords906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OVER_in_ruleIntrinsicStackWords934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROT_in_ruleIntrinsicStackWords962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROT_1_in_ruleIntrinsicStackWords990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUCK_in_ruleIntrinsicStackWords1018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNDER_in_ruleIntrinsicStackWords1046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_1_in_ruleIntrinsicStackWords1074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DUP_1_in_ruleIntrinsicStackWords1102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SWAP_1_in_ruleIntrinsicStackWords1130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OVER_1_in_ruleIntrinsicStackWords1158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RCLEAR_in_ruleIntrinsicStackWords1186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_R_1_in_ruleIntrinsicStackWords1214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_R_2_in_ruleIntrinsicStackWords1242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_R_in_ruleIntrinsicStackWords1270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RDROP_in_ruleIntrinsicStackWords1298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntrinsicMemoryWords_in_entryRuleIntrinsicMemoryWords1347 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntrinsicMemoryWords1357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LD_in_ruleIntrinsicMemoryWords1412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CommercialAt_in_ruleIntrinsicMemoryWords1440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ST_in_ruleIntrinsicMemoryWords1468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ExclamationMark_in_ruleIntrinsicMemoryWords1496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitTwoCommercialAt_in_ruleIntrinsicMemoryWords1524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitTwoExclamationMark_in_ruleIntrinsicMemoryWords1552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LLD_in_ruleIntrinsicMemoryWords1580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_L_1_in_ruleIntrinsicMemoryWords1608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LST_in_ruleIntrinsicMemoryWords1636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_L_in_ruleIntrinsicMemoryWords1664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TLD_in_ruleIntrinsicMemoryWords1692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_1_in_ruleIntrinsicMemoryWords1720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TST_in_ruleIntrinsicMemoryWords1748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_in_ruleIntrinsicMemoryWords1776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ST_1_in_ruleIntrinsicMemoryWords1804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PlusSignExclamationMark_in_ruleIntrinsicMemoryWords1832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INC_in_ruleIntrinsicMemoryWords1860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEC_in_ruleIntrinsicMemoryWords1888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ON_in_ruleIntrinsicMemoryWords1916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OFF_in_ruleIntrinsicMemoryWords1944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ERASE_in_ruleIntrinsicMemoryWords1972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILL_in_ruleIntrinsicMemoryWords2000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COUNT_in_ruleIntrinsicMemoryWords2028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MOVE_in_ruleIntrinsicMemoryWords2056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLACE_in_ruleIntrinsicMemoryWords2084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntrinsicArithmeticWords_in_entryRuleIntrinsicArithmeticWords2133 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntrinsicArithmeticWords2143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PlusSign_in_ruleIntrinsicArithmeticWords2198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HyphenMinus_in_ruleIntrinsicArithmeticWords2226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Asterisk_in_ruleIntrinsicArithmeticWords2254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Solidus_in_ruleIntrinsicArithmeticWords2282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitTwoAsterisk_in_ruleIntrinsicArithmeticWords2310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitTwoSolidus_in_ruleIntrinsicArithmeticWords2338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_U2_in_ruleIntrinsicArithmeticWords2366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROR_in_ruleIntrinsicArithmeticWords2394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROR_in_ruleIntrinsicArithmeticWords2422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROL_in_ruleIntrinsicArithmeticWords2450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROL_in_ruleIntrinsicArithmeticWords2478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PACK_in_ruleIntrinsicArithmeticWords2506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNPACK_in_ruleIntrinsicArithmeticWords2534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHIFT_in_ruleIntrinsicArithmeticWords2562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASHIFT_in_ruleIntrinsicArithmeticWords2590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitTwoAsteriskAsterisk_in_ruleIntrinsicArithmeticWords2618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitZeroEqualsSign_in_ruleIntrinsicArithmeticWords2646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitZeroLessThanSignGreaterThanSign_in_ruleIntrinsicArithmeticWords2674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitZeroLessThanSign_in_ruleIntrinsicArithmeticWords2702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_D0_in_ruleIntrinsicArithmeticWords2730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEGATE_in_ruleIntrinsicArithmeticWords2758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DNEGATE_in_ruleIntrinsicArithmeticWords2786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitOnePlusSign_in_ruleIntrinsicArithmeticWords2814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DigitOneHyphenMinus_in_ruleIntrinsicArithmeticWords2842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_ruleIntrinsicArithmeticWords2870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_ruleIntrinsicArithmeticWords2898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CELL_in_ruleIntrinsicArithmeticWords2926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CELL_1_in_ruleIntrinsicArithmeticWords2954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CARRY_RESET_in_ruleIntrinsicArithmeticWords2982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CARRYSET_in_ruleIntrinsicArithmeticWords3010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ABS_in_ruleIntrinsicArithmeticWords3038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DABS_in_ruleIntrinsicArithmeticWords3066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXTEND_in_ruleIntrinsicArithmeticWords3094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWord_in_entryRuleWord3143 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWord3153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntrinsicStackWords_in_ruleWord3200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntrinsicMemoryWords_in_ruleWord3227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntrinsicArithmeticWords_in_ruleWord3254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLITERAL_in_ruleWord3280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleWord3303 = new BitSet(new long[]{0x0000000000000002L});

}