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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NEGATE", "UNDER", "ROT_1", "CALL", "OVER", "SWAP", "TUCK", "DUP", "NIP", "ROT", "Colon", "Semicolon", "RULE_DIGIT", "RULE_DECINT", "RULE_WS", "RULE_SL_COMMENT", "RULE_INT", "RULE_DOUBLE", "RULE_ID", "RULE_OPERATOR", "RULE_STRING", "RULE_ML_COMMENT", "RULE_ANY_OTHER"
    };
    public static final int ROT_1=6;
    public static final int CALL=7;
    public static final int NEGATE=4;
    public static final int RULE_STRING=24;
    public static final int TUCK=10;
    public static final int RULE_SL_COMMENT=19;
    public static final int RULE_DOUBLE=21;
    public static final int Colon=14;
    public static final int RULE_DECINT=17;
    public static final int EOF=-1;
    public static final int DUP=11;
    public static final int RULE_OPERATOR=23;
    public static final int RULE_ID=22;
    public static final int RULE_WS=18;
    public static final int RULE_DIGIT=16;
    public static final int UNDER=5;
    public static final int RULE_ANY_OTHER=26;
    public static final int Semicolon=15;
    public static final int OVER=8;
    public static final int SWAP=9;
    public static final int NIP=12;
    public static final int ROT=13;
    public static final int RULE_INT=20;
    public static final int RULE_ML_COMMENT=25;

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

                if ( ((LA1_0>=NEGATE && LA1_0<=Colon)||(LA1_0>=RULE_INT && LA1_0<=RULE_OPERATOR)) ) {
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
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:109:1: ruleGlobalInstruction returns [EObject current=null] : (this_Function_0= ruleFunction | this_Instruction_1= ruleInstruction ) ;
    public final EObject ruleGlobalInstruction() throws RecognitionException {
        EObject current = null;

        EObject this_Function_0 = null;

        EObject this_Instruction_1 = null;


         enterRule(); 
            
        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:112:28: ( (this_Function_0= ruleFunction | this_Instruction_1= ruleInstruction ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:113:1: (this_Function_0= ruleFunction | this_Instruction_1= ruleInstruction )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:113:1: (this_Function_0= ruleFunction | this_Instruction_1= ruleInstruction )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==Colon) ) {
                alt2=1;
            }
            else if ( ((LA2_0>=NEGATE && LA2_0<=ROT)||(LA2_0>=RULE_INT && LA2_0<=RULE_OPERATOR)) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:114:5: this_Function_0= ruleFunction
                    {
                     
                            newCompositeNode(grammarAccess.getGlobalInstructionAccess().getFunctionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleFunction_in_ruleGlobalInstruction214);
                    this_Function_0=ruleFunction();

                    state._fsp--;


                            current = this_Function_0;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:124:5: this_Instruction_1= ruleInstruction
                    {
                     
                            newCompositeNode(grammarAccess.getGlobalInstructionAccess().getInstructionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleInstruction_in_ruleGlobalInstruction241);
                    this_Instruction_1=ruleInstruction();

                    state._fsp--;


                            current = this_Instruction_1;
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
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:140:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:141:2: (iv_ruleFunction= ruleFunction EOF )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:142:2: iv_ruleFunction= ruleFunction EOF
            {
             newCompositeNode(grammarAccess.getFunctionRule()); 
            pushFollow(FOLLOW_ruleFunction_in_entryRuleFunction275);
            iv_ruleFunction=ruleFunction();

            state._fsp--;

             current =iv_ruleFunction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunction285); 

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
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:149:1: ruleFunction returns [EObject current=null] : (otherlv_0= Colon ( (lv_name_1_0= RULE_ID ) ) ( (lv_words_2_0= ruleInstruction ) )* otherlv_3= Semicolon ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        EObject lv_words_2_0 = null;


         enterRule(); 
            
        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:152:28: ( (otherlv_0= Colon ( (lv_name_1_0= RULE_ID ) ) ( (lv_words_2_0= ruleInstruction ) )* otherlv_3= Semicolon ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:153:1: (otherlv_0= Colon ( (lv_name_1_0= RULE_ID ) ) ( (lv_words_2_0= ruleInstruction ) )* otherlv_3= Semicolon )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:153:1: (otherlv_0= Colon ( (lv_name_1_0= RULE_ID ) ) ( (lv_words_2_0= ruleInstruction ) )* otherlv_3= Semicolon )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:154:2: otherlv_0= Colon ( (lv_name_1_0= RULE_ID ) ) ( (lv_words_2_0= ruleInstruction ) )* otherlv_3= Semicolon
            {
            otherlv_0=(Token)match(input,Colon,FOLLOW_Colon_in_ruleFunction323); 

                	newLeafNode(otherlv_0, grammarAccess.getFunctionAccess().getColonKeyword_0());
                
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:158:1: ( (lv_name_1_0= RULE_ID ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:159:1: (lv_name_1_0= RULE_ID )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:159:1: (lv_name_1_0= RULE_ID )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:160:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFunction339); 

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

            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:176:2: ( (lv_words_2_0= ruleInstruction ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=NEGATE && LA3_0<=ROT)||(LA3_0>=RULE_INT && LA3_0<=RULE_OPERATOR)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:177:1: (lv_words_2_0= ruleInstruction )
            	    {
            	    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:177:1: (lv_words_2_0= ruleInstruction )
            	    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:178:3: lv_words_2_0= ruleInstruction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getFunctionAccess().getWordsInstructionParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleInstruction_in_ruleFunction365);
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

            otherlv_3=(Token)match(input,Semicolon,FOLLOW_Semicolon_in_ruleFunction379); 

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


    // $ANTLR start "entryRuleKeywords"
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:207:1: entryRuleKeywords returns [EObject current=null] : iv_ruleKeywords= ruleKeywords EOF ;
    public final EObject entryRuleKeywords() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeywords = null;


        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:208:2: (iv_ruleKeywords= ruleKeywords EOF )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:209:2: iv_ruleKeywords= ruleKeywords EOF
            {
             newCompositeNode(grammarAccess.getKeywordsRule()); 
            pushFollow(FOLLOW_ruleKeywords_in_entryRuleKeywords413);
            iv_ruleKeywords=ruleKeywords();

            state._fsp--;

             current =iv_ruleKeywords; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeywords423); 

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
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:216:1: ruleKeywords returns [EObject current=null] : ( ( (lv_name_0_1= SWAP | lv_name_0_2= OVER | lv_name_0_3= NIP | lv_name_0_4= UNDER | lv_name_0_5= TUCK | lv_name_0_6= ROT | lv_name_0_7= ROT_1 | lv_name_0_8= NEGATE | lv_name_0_9= DUP | lv_name_0_10= CALL ) ) ) ;
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
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:219:28: ( ( ( (lv_name_0_1= SWAP | lv_name_0_2= OVER | lv_name_0_3= NIP | lv_name_0_4= UNDER | lv_name_0_5= TUCK | lv_name_0_6= ROT | lv_name_0_7= ROT_1 | lv_name_0_8= NEGATE | lv_name_0_9= DUP | lv_name_0_10= CALL ) ) ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:220:1: ( ( (lv_name_0_1= SWAP | lv_name_0_2= OVER | lv_name_0_3= NIP | lv_name_0_4= UNDER | lv_name_0_5= TUCK | lv_name_0_6= ROT | lv_name_0_7= ROT_1 | lv_name_0_8= NEGATE | lv_name_0_9= DUP | lv_name_0_10= CALL ) ) )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:220:1: ( ( (lv_name_0_1= SWAP | lv_name_0_2= OVER | lv_name_0_3= NIP | lv_name_0_4= UNDER | lv_name_0_5= TUCK | lv_name_0_6= ROT | lv_name_0_7= ROT_1 | lv_name_0_8= NEGATE | lv_name_0_9= DUP | lv_name_0_10= CALL ) ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:221:1: ( (lv_name_0_1= SWAP | lv_name_0_2= OVER | lv_name_0_3= NIP | lv_name_0_4= UNDER | lv_name_0_5= TUCK | lv_name_0_6= ROT | lv_name_0_7= ROT_1 | lv_name_0_8= NEGATE | lv_name_0_9= DUP | lv_name_0_10= CALL ) )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:221:1: ( (lv_name_0_1= SWAP | lv_name_0_2= OVER | lv_name_0_3= NIP | lv_name_0_4= UNDER | lv_name_0_5= TUCK | lv_name_0_6= ROT | lv_name_0_7= ROT_1 | lv_name_0_8= NEGATE | lv_name_0_9= DUP | lv_name_0_10= CALL ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:222:1: (lv_name_0_1= SWAP | lv_name_0_2= OVER | lv_name_0_3= NIP | lv_name_0_4= UNDER | lv_name_0_5= TUCK | lv_name_0_6= ROT | lv_name_0_7= ROT_1 | lv_name_0_8= NEGATE | lv_name_0_9= DUP | lv_name_0_10= CALL )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:222:1: (lv_name_0_1= SWAP | lv_name_0_2= OVER | lv_name_0_3= NIP | lv_name_0_4= UNDER | lv_name_0_5= TUCK | lv_name_0_6= ROT | lv_name_0_7= ROT_1 | lv_name_0_8= NEGATE | lv_name_0_9= DUP | lv_name_0_10= CALL )
            int alt4=10;
            switch ( input.LA(1) ) {
            case SWAP:
                {
                alt4=1;
                }
                break;
            case OVER:
                {
                alt4=2;
                }
                break;
            case NIP:
                {
                alt4=3;
                }
                break;
            case UNDER:
                {
                alt4=4;
                }
                break;
            case TUCK:
                {
                alt4=5;
                }
                break;
            case ROT:
                {
                alt4=6;
                }
                break;
            case ROT_1:
                {
                alt4=7;
                }
                break;
            case NEGATE:
                {
                alt4=8;
                }
                break;
            case DUP:
                {
                alt4=9;
                }
                break;
            case CALL:
                {
                alt4=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:223:3: lv_name_0_1= SWAP
                    {
                    lv_name_0_1=(Token)match(input,SWAP,FOLLOW_SWAP_in_ruleKeywords468); 

                            newLeafNode(lv_name_0_1, grammarAccess.getKeywordsAccess().getNameSWAPKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKeywordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:236:8: lv_name_0_2= OVER
                    {
                    lv_name_0_2=(Token)match(input,OVER,FOLLOW_OVER_in_ruleKeywords496); 

                            newLeafNode(lv_name_0_2, grammarAccess.getKeywordsAccess().getNameOVERKeyword_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKeywordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:249:8: lv_name_0_3= NIP
                    {
                    lv_name_0_3=(Token)match(input,NIP,FOLLOW_NIP_in_ruleKeywords524); 

                            newLeafNode(lv_name_0_3, grammarAccess.getKeywordsAccess().getNameNIPKeyword_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKeywordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_3, null);
                    	    

                    }
                    break;
                case 4 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:262:8: lv_name_0_4= UNDER
                    {
                    lv_name_0_4=(Token)match(input,UNDER,FOLLOW_UNDER_in_ruleKeywords552); 

                            newLeafNode(lv_name_0_4, grammarAccess.getKeywordsAccess().getNameUNDERKeyword_0_3());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKeywordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_4, null);
                    	    

                    }
                    break;
                case 5 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:275:8: lv_name_0_5= TUCK
                    {
                    lv_name_0_5=(Token)match(input,TUCK,FOLLOW_TUCK_in_ruleKeywords580); 

                            newLeafNode(lv_name_0_5, grammarAccess.getKeywordsAccess().getNameTUCKKeyword_0_4());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKeywordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_5, null);
                    	    

                    }
                    break;
                case 6 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:288:8: lv_name_0_6= ROT
                    {
                    lv_name_0_6=(Token)match(input,ROT,FOLLOW_ROT_in_ruleKeywords608); 

                            newLeafNode(lv_name_0_6, grammarAccess.getKeywordsAccess().getNameROTKeyword_0_5());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKeywordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_6, null);
                    	    

                    }
                    break;
                case 7 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:301:8: lv_name_0_7= ROT_1
                    {
                    lv_name_0_7=(Token)match(input,ROT_1,FOLLOW_ROT_1_in_ruleKeywords636); 

                            newLeafNode(lv_name_0_7, grammarAccess.getKeywordsAccess().getNameROTKeyword_0_6());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKeywordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_7, null);
                    	    

                    }
                    break;
                case 8 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:314:8: lv_name_0_8= NEGATE
                    {
                    lv_name_0_8=(Token)match(input,NEGATE,FOLLOW_NEGATE_in_ruleKeywords664); 

                            newLeafNode(lv_name_0_8, grammarAccess.getKeywordsAccess().getNameNEGATEKeyword_0_7());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKeywordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_8, null);
                    	    

                    }
                    break;
                case 9 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:327:8: lv_name_0_9= DUP
                    {
                    lv_name_0_9=(Token)match(input,DUP,FOLLOW_DUP_in_ruleKeywords692); 

                            newLeafNode(lv_name_0_9, grammarAccess.getKeywordsAccess().getNameDUPKeyword_0_8());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKeywordsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_9, null);
                    	    

                    }
                    break;
                case 10 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:340:8: lv_name_0_10= CALL
                    {
                    lv_name_0_10=(Token)match(input,CALL,FOLLOW_CALL_in_ruleKeywords720); 

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
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:364:1: entryRuleInstruction returns [EObject current=null] : iv_ruleInstruction= ruleInstruction EOF ;
    public final EObject entryRuleInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstruction = null;


        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:365:2: (iv_ruleInstruction= ruleInstruction EOF )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:366:2: iv_ruleInstruction= ruleInstruction EOF
            {
             newCompositeNode(grammarAccess.getInstructionRule()); 
            pushFollow(FOLLOW_ruleInstruction_in_entryRuleInstruction768);
            iv_ruleInstruction=ruleInstruction();

            state._fsp--;

             current =iv_ruleInstruction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstruction778); 

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
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:373:1: ruleInstruction returns [EObject current=null] : (this_Keywords_0= ruleKeywords | this_Word_1= ruleWord | ( (lv_lit_2_0= ruleLiteral ) ) ) ;
    public final EObject ruleInstruction() throws RecognitionException {
        EObject current = null;

        EObject this_Keywords_0 = null;

        EObject this_Word_1 = null;

        AntlrDatatypeRuleToken lv_lit_2_0 = null;


         enterRule(); 
            
        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:376:28: ( (this_Keywords_0= ruleKeywords | this_Word_1= ruleWord | ( (lv_lit_2_0= ruleLiteral ) ) ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:377:1: (this_Keywords_0= ruleKeywords | this_Word_1= ruleWord | ( (lv_lit_2_0= ruleLiteral ) ) )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:377:1: (this_Keywords_0= ruleKeywords | this_Word_1= ruleWord | ( (lv_lit_2_0= ruleLiteral ) ) )
            int alt5=3;
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
                alt5=1;
                }
                break;
            case RULE_ID:
            case RULE_OPERATOR:
                {
                alt5=2;
                }
                break;
            case RULE_INT:
            case RULE_DOUBLE:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:378:5: this_Keywords_0= ruleKeywords
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getKeywordsParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleKeywords_in_ruleInstruction825);
                    this_Keywords_0=ruleKeywords();

                    state._fsp--;


                            current = this_Keywords_0;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:388:5: this_Word_1= ruleWord
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getWordParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleWord_in_ruleInstruction852);
                    this_Word_1=ruleWord();

                    state._fsp--;


                            current = this_Word_1;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:397:6: ( (lv_lit_2_0= ruleLiteral ) )
                    {
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:397:6: ( (lv_lit_2_0= ruleLiteral ) )
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:398:1: (lv_lit_2_0= ruleLiteral )
                    {
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:398:1: (lv_lit_2_0= ruleLiteral )
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:399:3: lv_lit_2_0= ruleLiteral
                    {
                     
                    	        newCompositeNode(grammarAccess.getInstructionAccess().getLitLiteralParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleLiteral_in_ruleInstruction878);
                    lv_lit_2_0=ruleLiteral();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInstructionRule());
                    	        }
                           		set(
                           			current, 
                           			"lit",
                            		lv_lit_2_0, 
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
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:423:1: entryRuleLiteral returns [String current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final String entryRuleLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLiteral = null;


        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:424:1: (iv_ruleLiteral= ruleLiteral EOF )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:425:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral914);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral925); 

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
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:432:1: ruleLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | this_DOUBLE_1= RULE_DOUBLE ) ;
    public final AntlrDatatypeRuleToken ruleLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token this_DOUBLE_1=null;

         enterRule(); 
            
        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:436:6: ( (this_INT_0= RULE_INT | this_DOUBLE_1= RULE_DOUBLE ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:437:1: (this_INT_0= RULE_INT | this_DOUBLE_1= RULE_DOUBLE )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:437:1: (this_INT_0= RULE_INT | this_DOUBLE_1= RULE_DOUBLE )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_INT) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_DOUBLE) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:437:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleLiteral965); 

                    		current.merge(this_INT_0);
                        
                     
                        newLeafNode(this_INT_0, grammarAccess.getLiteralAccess().getINTTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:445:10: this_DOUBLE_1= RULE_DOUBLE
                    {
                    this_DOUBLE_1=(Token)match(input,RULE_DOUBLE,FOLLOW_RULE_DOUBLE_in_ruleLiteral991); 

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
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:460:1: entryRuleWord returns [EObject current=null] : iv_ruleWord= ruleWord EOF ;
    public final EObject entryRuleWord() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWord = null;


        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:461:2: (iv_ruleWord= ruleWord EOF )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:462:2: iv_ruleWord= ruleWord EOF
            {
             newCompositeNode(grammarAccess.getWordRule()); 
            pushFollow(FOLLOW_ruleWord_in_entryRuleWord1035);
            iv_ruleWord=ruleWord();

            state._fsp--;

             current =iv_ruleWord; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWord1045); 

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
    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:469:1: ruleWord returns [EObject current=null] : ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_OPERATOR ) ) ) ;
    public final EObject ruleWord() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;

         enterRule(); 
            
        try {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:472:28: ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_OPERATOR ) ) ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:473:1: ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_OPERATOR ) ) )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:473:1: ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_OPERATOR ) ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:474:1: ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_OPERATOR ) )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:474:1: ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_OPERATOR ) )
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:475:1: (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_OPERATOR )
            {
            // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:475:1: (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_OPERATOR )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_OPERATOR) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:476:3: lv_name_0_1= RULE_ID
                    {
                    lv_name_0_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleWord1088); 

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
                    // ../ch.fhnw.mdt.forthlang/src-gen/ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.g:491:8: lv_name_0_2= RULE_OPERATOR
                    {
                    lv_name_0_2=(Token)match(input,RULE_OPERATOR,FOLLOW_RULE_OPERATOR_in_ruleWord1108); 

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
    public static final BitSet FOLLOW_ruleGlobalInstruction_in_ruleForth122 = new BitSet(new long[]{0x0000000000F07FF2L});
    public static final BitSet FOLLOW_ruleGlobalInstruction_in_entryRuleGlobalInstruction157 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGlobalInstruction167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_ruleGlobalInstruction214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleGlobalInstruction241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_entryRuleFunction275 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunction285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Colon_in_ruleFunction323 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFunction339 = new BitSet(new long[]{0x0000000000F0FFF0L});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleFunction365 = new BitSet(new long[]{0x0000000000F0FFF0L});
    public static final BitSet FOLLOW_Semicolon_in_ruleFunction379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywords_in_entryRuleKeywords413 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeywords423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SWAP_in_ruleKeywords468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OVER_in_ruleKeywords496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NIP_in_ruleKeywords524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNDER_in_ruleKeywords552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUCK_in_ruleKeywords580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROT_in_ruleKeywords608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROT_1_in_ruleKeywords636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEGATE_in_ruleKeywords664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DUP_in_ruleKeywords692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CALL_in_ruleKeywords720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_entryRuleInstruction768 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstruction778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywords_in_ruleInstruction825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWord_in_ruleInstruction852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleInstruction878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral914 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleLiteral965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOUBLE_in_ruleLiteral991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWord_in_entryRuleWord1035 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWord1045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleWord1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OPERATOR_in_ruleWord1108 = new BitSet(new long[]{0x0000000000000002L});

}