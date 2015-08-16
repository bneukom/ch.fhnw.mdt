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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NEGATE", "Create", "UNDER", "ROT_1", "CALL", "OVER", "SWAP", "TUCK", "DUP", "NIP", "ROT", "Comma", "Colon", "Semicolon", "RULE_DIGIT", "RULE_DECINT", "RULE_WS", "RULE_SL_COMMENT", "RULE_INT", "RULE_DOUBLE", "RULE_ID", "RULE_OPERATOR", "RULE_STRING", "RULE_ML_COMMENT", "RULE_ANY_OTHER"
    };
    public static final int ROT_1=7;
    public static final int CALL=8;
    public static final int NEGATE=4;
    public static final int RULE_STRING=26;
    public static final int TUCK=11;
    public static final int RULE_SL_COMMENT=21;
    public static final int Comma=15;
    public static final int RULE_DOUBLE=23;
    public static final int Create=5;
    public static final int Colon=16;
    public static final int RULE_DECINT=19;
    public static final int EOF=-1;
    public static final int DUP=12;
    public static final int RULE_OPERATOR=25;
    public static final int RULE_ID=24;
    public static final int RULE_WS=20;
    public static final int RULE_DIGIT=18;
    public static final int UNDER=6;
    public static final int RULE_ANY_OTHER=28;
    public static final int Semicolon=17;
    public static final int OVER=9;
    public static final int SWAP=10;
    public static final int NIP=13;
    public static final int ROT=14;
    public static final int RULE_INT=22;
    public static final int RULE_ML_COMMENT=27;

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
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:70:1: ruleForth returns [EObject current=null] : ( (lv_instructions_0_0= ruleGlobalInstruction ) )* ;
    public final EObject ruleForth() throws RecognitionException {
        EObject current = null;

        EObject lv_instructions_0_0 = null;


         enterRule(); 
            
        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:73:28: ( ( (lv_instructions_0_0= ruleGlobalInstruction ) )* )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:74:1: ( (lv_instructions_0_0= ruleGlobalInstruction ) )*
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:74:1: ( (lv_instructions_0_0= ruleGlobalInstruction ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=NEGATE && LA1_0<=ROT)||LA1_0==Colon||(LA1_0>=RULE_INT && LA1_0<=RULE_OPERATOR)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:75:1: (lv_instructions_0_0= ruleGlobalInstruction )
            	    {
            	    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:75:1: (lv_instructions_0_0= ruleGlobalInstruction )
            	    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:76:3: lv_instructions_0_0= ruleGlobalInstruction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getForthAccess().getInstructionsGlobalInstructionParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleGlobalInstruction_in_ruleForth122);
            	    lv_instructions_0_0=ruleGlobalInstruction();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getForthRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"instructions",
            	            		lv_instructions_0_0, 
            	            		"GlobalInstruction");
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


    // $ANTLR start "entryRuleGlobalInstruction"
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:100:1: entryRuleGlobalInstruction returns [EObject current=null] : iv_ruleGlobalInstruction= ruleGlobalInstruction EOF ;
    public final EObject entryRuleGlobalInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGlobalInstruction = null;


        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:101:2: (iv_ruleGlobalInstruction= ruleGlobalInstruction EOF )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:102:2: iv_ruleGlobalInstruction= ruleGlobalInstruction EOF
            {
             newCompositeNode(grammarAccess.getGlobalInstructionRule()); 
            pushFollow(FOLLOW_ruleGlobalInstruction_in_entryRuleGlobalInstruction157);
            iv_ruleGlobalInstruction=ruleGlobalInstruction();

            state._fsp--;

             current =iv_ruleGlobalInstruction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGlobalInstruction167); 

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
    // $ANTLR end "entryRuleGlobalInstruction"


    // $ANTLR start "ruleGlobalInstruction"
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:109:1: ruleGlobalInstruction returns [EObject current=null] : (this_Create_0= ruleCreate | this_Function_1= ruleFunction | this_Instruction_2= ruleInstruction ) ;
    public final EObject ruleGlobalInstruction() throws RecognitionException {
        EObject current = null;

        EObject this_Create_0 = null;

        EObject this_Function_1 = null;

        EObject this_Instruction_2 = null;


         enterRule(); 
            
        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:112:28: ( (this_Create_0= ruleCreate | this_Function_1= ruleFunction | this_Instruction_2= ruleInstruction ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:113:1: (this_Create_0= ruleCreate | this_Function_1= ruleFunction | this_Instruction_2= ruleInstruction )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:113:1: (this_Create_0= ruleCreate | this_Function_1= ruleFunction | this_Instruction_2= ruleInstruction )
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
            case NEGATE:
            case UNDER:
            case ROT_1:
            case CALL:
            case OVER:
            case SWAP:
            case TUCK:
            case DUP:
            case NIP:
            case ROT:
            case RULE_INT:
            case RULE_DOUBLE:
            case RULE_ID:
            case RULE_OPERATOR:
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
                     
                            newCompositeNode(grammarAccess.getGlobalInstructionAccess().getCreateParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleCreate_in_ruleGlobalInstruction214);
                    this_Create_0=ruleCreate();

                    state._fsp--;


                            current = this_Create_0;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:124:5: this_Function_1= ruleFunction
                    {
                     
                            newCompositeNode(grammarAccess.getGlobalInstructionAccess().getFunctionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleFunction_in_ruleGlobalInstruction241);
                    this_Function_1=ruleFunction();

                    state._fsp--;


                            current = this_Function_1;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:134:5: this_Instruction_2= ruleInstruction
                    {
                     
                            newCompositeNode(grammarAccess.getGlobalInstructionAccess().getInstructionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleInstruction_in_ruleGlobalInstruction268);
                    this_Instruction_2=ruleInstruction();

                    state._fsp--;


                            current = this_Instruction_2;
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
    // $ANTLR end "ruleGlobalInstruction"


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
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:159:1: ruleFunction returns [EObject current=null] : (otherlv_0= Colon ( (lv_name_1_0= RULE_ID ) ) ( (lv_words_2_0= ruleInstruction ) )* otherlv_3= Semicolon ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        EObject lv_words_2_0 = null;


         enterRule(); 
            
        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:162:28: ( (otherlv_0= Colon ( (lv_name_1_0= RULE_ID ) ) ( (lv_words_2_0= ruleInstruction ) )* otherlv_3= Semicolon ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:163:1: (otherlv_0= Colon ( (lv_name_1_0= RULE_ID ) ) ( (lv_words_2_0= ruleInstruction ) )* otherlv_3= Semicolon )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:163:1: (otherlv_0= Colon ( (lv_name_1_0= RULE_ID ) ) ( (lv_words_2_0= ruleInstruction ) )* otherlv_3= Semicolon )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:164:2: otherlv_0= Colon ( (lv_name_1_0= RULE_ID ) ) ( (lv_words_2_0= ruleInstruction ) )* otherlv_3= Semicolon
            {
            otherlv_0=(Token)match(input,Colon,FOLLOW_Colon_in_ruleFunction350); 

                	newLeafNode(otherlv_0, grammarAccess.getFunctionAccess().getColonKeyword_0());
                
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:168:1: ( (lv_name_1_0= RULE_ID ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:169:1: (lv_name_1_0= RULE_ID )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:169:1: (lv_name_1_0= RULE_ID )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:170:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFunction366); 

            			newLeafNode(lv_name_1_0, grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFunctionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:186:2: ( (lv_words_2_0= ruleInstruction ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==NEGATE||(LA3_0>=UNDER && LA3_0<=ROT)||(LA3_0>=RULE_INT && LA3_0<=RULE_OPERATOR)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:187:1: (lv_words_2_0= ruleInstruction )
            	    {
            	    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:187:1: (lv_words_2_0= ruleInstruction )
            	    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:188:3: lv_words_2_0= ruleInstruction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getFunctionAccess().getWordsInstructionParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleInstruction_in_ruleFunction392);
            	    lv_words_2_0=ruleInstruction();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getFunctionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"words",
            	            		lv_words_2_0, 
            	            		"Instruction");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_3=(Token)match(input,Semicolon,FOLLOW_Semicolon_in_ruleFunction406); 

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
            pushFollow(FOLLOW_ruleCreate_in_entryRuleCreate440);
            iv_ruleCreate=ruleCreate();

            state._fsp--;

             current =iv_ruleCreate; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCreate450); 

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
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:226:1: ruleCreate returns [EObject current=null] : (otherlv_0= Create ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_lit_2_0= ruleLiteral ) ) otherlv_3= Comma )* ) ;
    public final EObject ruleCreate() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_lit_2_0 = null;


         enterRule(); 
            
        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:229:28: ( (otherlv_0= Create ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_lit_2_0= ruleLiteral ) ) otherlv_3= Comma )* ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:230:1: (otherlv_0= Create ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_lit_2_0= ruleLiteral ) ) otherlv_3= Comma )* )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:230:1: (otherlv_0= Create ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_lit_2_0= ruleLiteral ) ) otherlv_3= Comma )* )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:231:2: otherlv_0= Create ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_lit_2_0= ruleLiteral ) ) otherlv_3= Comma )*
            {
            otherlv_0=(Token)match(input,Create,FOLLOW_Create_in_ruleCreate488); 

                	newLeafNode(otherlv_0, grammarAccess.getCreateAccess().getCreateKeyword_0());
                
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:235:1: ( (lv_name_1_0= RULE_ID ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:236:1: (lv_name_1_0= RULE_ID )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:236:1: (lv_name_1_0= RULE_ID )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:237:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCreate504); 

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

            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:253:2: ( ( (lv_lit_2_0= ruleLiteral ) ) otherlv_3= Comma )*
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
            	    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:253:3: ( (lv_lit_2_0= ruleLiteral ) ) otherlv_3= Comma
            	    {
            	    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:253:3: ( (lv_lit_2_0= ruleLiteral ) )
            	    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:254:1: (lv_lit_2_0= ruleLiteral )
            	    {
            	    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:254:1: (lv_lit_2_0= ruleLiteral )
            	    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:255:3: lv_lit_2_0= ruleLiteral
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCreateAccess().getLitLiteralParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleLiteral_in_ruleCreate531);
            	    lv_lit_2_0=ruleLiteral();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCreateRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"lit",
            	            		lv_lit_2_0, 
            	            		"Literal");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    otherlv_3=(Token)match(input,Comma,FOLLOW_Comma_in_ruleCreate544); 

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


    // $ANTLR start "entryRuleKeywords"
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:284:1: entryRuleKeywords returns [EObject current=null] : iv_ruleKeywords= ruleKeywords EOF ;
    public final EObject entryRuleKeywords() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeywords = null;


        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:285:2: (iv_ruleKeywords= ruleKeywords EOF )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:286:2: iv_ruleKeywords= ruleKeywords EOF
            {
             newCompositeNode(grammarAccess.getKeywordsRule()); 
            pushFollow(FOLLOW_ruleKeywords_in_entryRuleKeywords580);
            iv_ruleKeywords=ruleKeywords();

            state._fsp--;

             current =iv_ruleKeywords; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeywords590); 

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
    // $ANTLR end "entryRuleKeywords"


    // $ANTLR start "ruleKeywords"
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:293:1: ruleKeywords returns [EObject current=null] : ( ( (lv_name_0_1= SWAP | lv_name_0_2= OVER | lv_name_0_3= NIP | lv_name_0_4= UNDER | lv_name_0_5= TUCK | lv_name_0_6= ROT | lv_name_0_7= ROT_1 | lv_name_0_8= NEGATE | lv_name_0_9= DUP | lv_name_0_10= CALL ) ) ) ;
    public final EObject ruleKeywords() throws RecognitionException {
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

         enterRule(); 
            
        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:296:28: ( ( ( (lv_name_0_1= SWAP | lv_name_0_2= OVER | lv_name_0_3= NIP | lv_name_0_4= UNDER | lv_name_0_5= TUCK | lv_name_0_6= ROT | lv_name_0_7= ROT_1 | lv_name_0_8= NEGATE | lv_name_0_9= DUP | lv_name_0_10= CALL ) ) ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:297:1: ( ( (lv_name_0_1= SWAP | lv_name_0_2= OVER | lv_name_0_3= NIP | lv_name_0_4= UNDER | lv_name_0_5= TUCK | lv_name_0_6= ROT | lv_name_0_7= ROT_1 | lv_name_0_8= NEGATE | lv_name_0_9= DUP | lv_name_0_10= CALL ) ) )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:297:1: ( ( (lv_name_0_1= SWAP | lv_name_0_2= OVER | lv_name_0_3= NIP | lv_name_0_4= UNDER | lv_name_0_5= TUCK | lv_name_0_6= ROT | lv_name_0_7= ROT_1 | lv_name_0_8= NEGATE | lv_name_0_9= DUP | lv_name_0_10= CALL ) ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:298:1: ( (lv_name_0_1= SWAP | lv_name_0_2= OVER | lv_name_0_3= NIP | lv_name_0_4= UNDER | lv_name_0_5= TUCK | lv_name_0_6= ROT | lv_name_0_7= ROT_1 | lv_name_0_8= NEGATE | lv_name_0_9= DUP | lv_name_0_10= CALL ) )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:298:1: ( (lv_name_0_1= SWAP | lv_name_0_2= OVER | lv_name_0_3= NIP | lv_name_0_4= UNDER | lv_name_0_5= TUCK | lv_name_0_6= ROT | lv_name_0_7= ROT_1 | lv_name_0_8= NEGATE | lv_name_0_9= DUP | lv_name_0_10= CALL ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:299:1: (lv_name_0_1= SWAP | lv_name_0_2= OVER | lv_name_0_3= NIP | lv_name_0_4= UNDER | lv_name_0_5= TUCK | lv_name_0_6= ROT | lv_name_0_7= ROT_1 | lv_name_0_8= NEGATE | lv_name_0_9= DUP | lv_name_0_10= CALL )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:299:1: (lv_name_0_1= SWAP | lv_name_0_2= OVER | lv_name_0_3= NIP | lv_name_0_4= UNDER | lv_name_0_5= TUCK | lv_name_0_6= ROT | lv_name_0_7= ROT_1 | lv_name_0_8= NEGATE | lv_name_0_9= DUP | lv_name_0_10= CALL )
            int alt5=10;
            switch ( input.LA(1) ) {
            case SWAP:
                {
                alt5=1;
                }
                break;
            case OVER:
                {
                alt5=2;
                }
                break;
            case NIP:
                {
                alt5=3;
                }
                break;
            case UNDER:
                {
                alt5=4;
                }
                break;
            case TUCK:
                {
                alt5=5;
                }
                break;
            case ROT:
                {
                alt5=6;
                }
                break;
            case ROT_1:
                {
                alt5=7;
                }
                break;
            case NEGATE:
                {
                alt5=8;
                }
                break;
            case DUP:
                {
                alt5=9;
                }
                break;
            case CALL:
                {
                alt5=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:300:3: lv_name_0_1= SWAP
                    {
                    lv_name_0_1=(Token)match(input,SWAP,FOLLOW_SWAP_in_ruleKeywords635); 

                            newLeafNode(lv_name_0_1, grammarAccess.getKeywordsAccess().getNameSWAPKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKeywordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:313:8: lv_name_0_2= OVER
                    {
                    lv_name_0_2=(Token)match(input,OVER,FOLLOW_OVER_in_ruleKeywords663); 

                            newLeafNode(lv_name_0_2, grammarAccess.getKeywordsAccess().getNameOVERKeyword_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKeywordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:326:8: lv_name_0_3= NIP
                    {
                    lv_name_0_3=(Token)match(input,NIP,FOLLOW_NIP_in_ruleKeywords691); 

                            newLeafNode(lv_name_0_3, grammarAccess.getKeywordsAccess().getNameNIPKeyword_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKeywordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_3, null);
                    	    

                    }
                    break;
                case 4 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:339:8: lv_name_0_4= UNDER
                    {
                    lv_name_0_4=(Token)match(input,UNDER,FOLLOW_UNDER_in_ruleKeywords719); 

                            newLeafNode(lv_name_0_4, grammarAccess.getKeywordsAccess().getNameUNDERKeyword_0_3());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKeywordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_4, null);
                    	    

                    }
                    break;
                case 5 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:352:8: lv_name_0_5= TUCK
                    {
                    lv_name_0_5=(Token)match(input,TUCK,FOLLOW_TUCK_in_ruleKeywords747); 

                            newLeafNode(lv_name_0_5, grammarAccess.getKeywordsAccess().getNameTUCKKeyword_0_4());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKeywordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_5, null);
                    	    

                    }
                    break;
                case 6 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:365:8: lv_name_0_6= ROT
                    {
                    lv_name_0_6=(Token)match(input,ROT,FOLLOW_ROT_in_ruleKeywords775); 

                            newLeafNode(lv_name_0_6, grammarAccess.getKeywordsAccess().getNameROTKeyword_0_5());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKeywordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_6, null);
                    	    

                    }
                    break;
                case 7 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:378:8: lv_name_0_7= ROT_1
                    {
                    lv_name_0_7=(Token)match(input,ROT_1,FOLLOW_ROT_1_in_ruleKeywords803); 

                            newLeafNode(lv_name_0_7, grammarAccess.getKeywordsAccess().getNameROTKeyword_0_6());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKeywordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_7, null);
                    	    

                    }
                    break;
                case 8 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:391:8: lv_name_0_8= NEGATE
                    {
                    lv_name_0_8=(Token)match(input,NEGATE,FOLLOW_NEGATE_in_ruleKeywords831); 

                            newLeafNode(lv_name_0_8, grammarAccess.getKeywordsAccess().getNameNEGATEKeyword_0_7());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKeywordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_8, null);
                    	    

                    }
                    break;
                case 9 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:404:8: lv_name_0_9= DUP
                    {
                    lv_name_0_9=(Token)match(input,DUP,FOLLOW_DUP_in_ruleKeywords859); 

                            newLeafNode(lv_name_0_9, grammarAccess.getKeywordsAccess().getNameDUPKeyword_0_8());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKeywordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_9, null);
                    	    

                    }
                    break;
                case 10 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:417:8: lv_name_0_10= CALL
                    {
                    lv_name_0_10=(Token)match(input,CALL,FOLLOW_CALL_in_ruleKeywords887); 

                            newLeafNode(lv_name_0_10, grammarAccess.getKeywordsAccess().getNameCALLKeyword_0_9());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKeywordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_10, null);
                    	    

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
    // $ANTLR end "ruleKeywords"


    // $ANTLR start "entryRuleInstruction"
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:441:1: entryRuleInstruction returns [EObject current=null] : iv_ruleInstruction= ruleInstruction EOF ;
    public final EObject entryRuleInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstruction = null;


        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:442:2: (iv_ruleInstruction= ruleInstruction EOF )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:443:2: iv_ruleInstruction= ruleInstruction EOF
            {
             newCompositeNode(grammarAccess.getInstructionRule()); 
            pushFollow(FOLLOW_ruleInstruction_in_entryRuleInstruction935);
            iv_ruleInstruction=ruleInstruction();

            state._fsp--;

             current =iv_ruleInstruction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstruction945); 

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
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:450:1: ruleInstruction returns [EObject current=null] : (this_Keywords_0= ruleKeywords | this_Word_1= ruleWord | ( (lv_name_2_0= ruleLiteral ) ) ) ;
    public final EObject ruleInstruction() throws RecognitionException {
        EObject current = null;

        EObject this_Keywords_0 = null;

        EObject this_Word_1 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;


         enterRule(); 
            
        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:453:28: ( (this_Keywords_0= ruleKeywords | this_Word_1= ruleWord | ( (lv_name_2_0= ruleLiteral ) ) ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:454:1: (this_Keywords_0= ruleKeywords | this_Word_1= ruleWord | ( (lv_name_2_0= ruleLiteral ) ) )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:454:1: (this_Keywords_0= ruleKeywords | this_Word_1= ruleWord | ( (lv_name_2_0= ruleLiteral ) ) )
            int alt6=3;
            switch ( input.LA(1) ) {
            case NEGATE:
            case UNDER:
            case ROT_1:
            case CALL:
            case OVER:
            case SWAP:
            case TUCK:
            case DUP:
            case NIP:
            case ROT:
                {
                alt6=1;
                }
                break;
            case RULE_ID:
            case RULE_OPERATOR:
                {
                alt6=2;
                }
                break;
            case RULE_INT:
            case RULE_DOUBLE:
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:455:5: this_Keywords_0= ruleKeywords
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getKeywordsParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleKeywords_in_ruleInstruction992);
                    this_Keywords_0=ruleKeywords();

                    state._fsp--;


                            current = this_Keywords_0;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:465:5: this_Word_1= ruleWord
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getWordParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleWord_in_ruleInstruction1019);
                    this_Word_1=ruleWord();

                    state._fsp--;


                            current = this_Word_1;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:474:6: ( (lv_name_2_0= ruleLiteral ) )
                    {
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:474:6: ( (lv_name_2_0= ruleLiteral ) )
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:475:1: (lv_name_2_0= ruleLiteral )
                    {
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:475:1: (lv_name_2_0= ruleLiteral )
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:476:3: lv_name_2_0= ruleLiteral
                    {
                     
                    	        newCompositeNode(grammarAccess.getInstructionAccess().getNameLiteralParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleLiteral_in_ruleInstruction1045);
                    lv_name_2_0=ruleLiteral();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInstructionRule());
                    	        }
                           		set(
                           			current, 
                           			"name",
                            		lv_name_2_0, 
                            		"Literal");
                    	        afterParserOrEnumRuleCall();
                    	    

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
    // $ANTLR end "ruleInstruction"


    // $ANTLR start "entryRuleLiteral"
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:500:1: entryRuleLiteral returns [String current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final String entryRuleLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLiteral = null;


        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:501:1: (iv_ruleLiteral= ruleLiteral EOF )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:502:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral1081);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral1092); 

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
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:509:1: ruleLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | this_DOUBLE_1= RULE_DOUBLE ) ;
    public final AntlrDatatypeRuleToken ruleLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token this_DOUBLE_1=null;

         enterRule(); 
            
        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:513:6: ( (this_INT_0= RULE_INT | this_DOUBLE_1= RULE_DOUBLE ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:514:1: (this_INT_0= RULE_INT | this_DOUBLE_1= RULE_DOUBLE )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:514:1: (this_INT_0= RULE_INT | this_DOUBLE_1= RULE_DOUBLE )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_INT) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_DOUBLE) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:514:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleLiteral1132); 

                    		current.merge(this_INT_0);
                        
                     
                        newLeafNode(this_INT_0, grammarAccess.getLiteralAccess().getINTTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:522:10: this_DOUBLE_1= RULE_DOUBLE
                    {
                    this_DOUBLE_1=(Token)match(input,RULE_DOUBLE,FOLLOW_RULE_DOUBLE_in_ruleLiteral1158); 

                    		current.merge(this_DOUBLE_1);
                        
                     
                        newLeafNode(this_DOUBLE_1, grammarAccess.getLiteralAccess().getDOUBLETerminalRuleCall_1()); 
                        

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
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleWord"
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:537:1: entryRuleWord returns [EObject current=null] : iv_ruleWord= ruleWord EOF ;
    public final EObject entryRuleWord() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWord = null;


        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:538:2: (iv_ruleWord= ruleWord EOF )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:539:2: iv_ruleWord= ruleWord EOF
            {
             newCompositeNode(grammarAccess.getWordRule()); 
            pushFollow(FOLLOW_ruleWord_in_entryRuleWord1202);
            iv_ruleWord=ruleWord();

            state._fsp--;

             current =iv_ruleWord; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWord1212); 

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
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:546:1: ruleWord returns [EObject current=null] : ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_OPERATOR ) ) ) ;
    public final EObject ruleWord() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;

         enterRule(); 
            
        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:549:28: ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_OPERATOR ) ) ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:550:1: ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_OPERATOR ) ) )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:550:1: ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_OPERATOR ) ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:551:1: ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_OPERATOR ) )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:551:1: ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_OPERATOR ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:552:1: (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_OPERATOR )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:552:1: (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_OPERATOR )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_OPERATOR) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:553:3: lv_name_0_1= RULE_ID
                    {
                    lv_name_0_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleWord1255); 

                    			newLeafNode(lv_name_0_1, grammarAccess.getWordAccess().getNameIDTerminalRuleCall_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getWordRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_0_1, 
                            		"ID");
                    	    

                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:568:8: lv_name_0_2= RULE_OPERATOR
                    {
                    lv_name_0_2=(Token)match(input,RULE_OPERATOR,FOLLOW_RULE_OPERATOR_in_ruleWord1275); 

                    			newLeafNode(lv_name_0_2, grammarAccess.getWordAccess().getNameOPERATORTerminalRuleCall_0_1()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getWordRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_0_2, 
                            		"OPERATOR");
                    	    

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
    // $ANTLR end "ruleWord"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleForth_in_entryRuleForth67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleForth77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGlobalInstruction_in_ruleForth122 = new BitSet(new long[]{0x0000000003C17FF2L});
    public static final BitSet FOLLOW_ruleGlobalInstruction_in_entryRuleGlobalInstruction157 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGlobalInstruction167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreate_in_ruleGlobalInstruction214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_ruleGlobalInstruction241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleGlobalInstruction268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_entryRuleFunction302 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunction312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Colon_in_ruleFunction350 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFunction366 = new BitSet(new long[]{0x0000000003C37FF0L});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleFunction392 = new BitSet(new long[]{0x0000000003C37FF0L});
    public static final BitSet FOLLOW_Semicolon_in_ruleFunction406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreate_in_entryRuleCreate440 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCreate450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Create_in_ruleCreate488 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCreate504 = new BitSet(new long[]{0x0000000003C1FFF2L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleCreate531 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_Comma_in_ruleCreate544 = new BitSet(new long[]{0x0000000003C1FFF2L});
    public static final BitSet FOLLOW_ruleKeywords_in_entryRuleKeywords580 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeywords590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SWAP_in_ruleKeywords635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OVER_in_ruleKeywords663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NIP_in_ruleKeywords691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNDER_in_ruleKeywords719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUCK_in_ruleKeywords747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROT_in_ruleKeywords775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROT_1_in_ruleKeywords803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEGATE_in_ruleKeywords831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DUP_in_ruleKeywords859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CALL_in_ruleKeywords887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_entryRuleInstruction935 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstruction945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywords_in_ruleInstruction992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWord_in_ruleInstruction1019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleInstruction1045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral1081 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral1092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleLiteral1132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOUBLE_in_ruleLiteral1158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWord_in_entryRuleWord1202 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWord1212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleWord1255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OPERATOR_in_ruleWord1275 = new BitSet(new long[]{0x0000000000000002L});

}