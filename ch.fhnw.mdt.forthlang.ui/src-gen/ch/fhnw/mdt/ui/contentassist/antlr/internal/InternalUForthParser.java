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
    public String getGrammarFileName() { return "../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g"; }


     
     	private UForthGrammarAccess grammarAccess;
     	
     	private final Map<String, String> tokenNameToValue = new HashMap<String, String>();
     	
     	{
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:75:1: entryRuleForth : ruleForth EOF ;
    public final void entryRuleForth() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:76:1: ( ruleForth EOF )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:77:1: ruleForth EOF
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:84:1: ruleForth : ( ( rule__Forth__InstructionsAssignment )* ) ;
    public final void ruleForth() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:88:5: ( ( ( rule__Forth__InstructionsAssignment )* ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:89:1: ( ( rule__Forth__InstructionsAssignment )* )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:89:1: ( ( rule__Forth__InstructionsAssignment )* )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:90:1: ( rule__Forth__InstructionsAssignment )*
            {
             before(grammarAccess.getForthAccess().getInstructionsAssignment()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:91:1: ( rule__Forth__InstructionsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=NEGATE && LA1_0<=Colon)||(LA1_0>=RULE_INT && LA1_0<=RULE_OPERATOR)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:91:2: rule__Forth__InstructionsAssignment
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:103:1: entryRuleGlobalInstruction : ruleGlobalInstruction EOF ;
    public final void entryRuleGlobalInstruction() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:104:1: ( ruleGlobalInstruction EOF )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:105:1: ruleGlobalInstruction EOF
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:112:1: ruleGlobalInstruction : ( ( rule__GlobalInstruction__Alternatives ) ) ;
    public final void ruleGlobalInstruction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:116:5: ( ( ( rule__GlobalInstruction__Alternatives ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:117:1: ( ( rule__GlobalInstruction__Alternatives ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:117:1: ( ( rule__GlobalInstruction__Alternatives ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:118:1: ( rule__GlobalInstruction__Alternatives )
            {
             before(grammarAccess.getGlobalInstructionAccess().getAlternatives()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:119:1: ( rule__GlobalInstruction__Alternatives )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:119:2: rule__GlobalInstruction__Alternatives
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:131:1: entryRuleFunction : ruleFunction EOF ;
    public final void entryRuleFunction() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:132:1: ( ruleFunction EOF )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:133:1: ruleFunction EOF
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:140:1: ruleFunction : ( ( rule__Function__Group__0 ) ) ;
    public final void ruleFunction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:144:5: ( ( ( rule__Function__Group__0 ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:145:1: ( ( rule__Function__Group__0 ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:145:1: ( ( rule__Function__Group__0 ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:146:1: ( rule__Function__Group__0 )
            {
             before(grammarAccess.getFunctionAccess().getGroup()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:147:1: ( rule__Function__Group__0 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:147:2: rule__Function__Group__0
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


    // $ANTLR start "entryRuleKeywords"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:159:1: entryRuleKeywords : ruleKeywords EOF ;
    public final void entryRuleKeywords() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:160:1: ( ruleKeywords EOF )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:161:1: ruleKeywords EOF
            {
             before(grammarAccess.getKeywordsRule()); 
            pushFollow(FOLLOW_ruleKeywords_in_entryRuleKeywords247);
            ruleKeywords();

            state._fsp--;

             after(grammarAccess.getKeywordsRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeywords254); 

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
    // $ANTLR end "entryRuleKeywords"


    // $ANTLR start "ruleKeywords"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:168:1: ruleKeywords : ( ( rule__Keywords__NameAssignment ) ) ;
    public final void ruleKeywords() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:172:5: ( ( ( rule__Keywords__NameAssignment ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:173:1: ( ( rule__Keywords__NameAssignment ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:173:1: ( ( rule__Keywords__NameAssignment ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:174:1: ( rule__Keywords__NameAssignment )
            {
             before(grammarAccess.getKeywordsAccess().getNameAssignment()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:175:1: ( rule__Keywords__NameAssignment )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:175:2: rule__Keywords__NameAssignment
            {
            pushFollow(FOLLOW_rule__Keywords__NameAssignment_in_ruleKeywords284);
            rule__Keywords__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getKeywordsAccess().getNameAssignment()); 

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
    // $ANTLR end "ruleKeywords"


    // $ANTLR start "entryRuleInstruction"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:187:1: entryRuleInstruction : ruleInstruction EOF ;
    public final void entryRuleInstruction() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:188:1: ( ruleInstruction EOF )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:189:1: ruleInstruction EOF
            {
             before(grammarAccess.getInstructionRule()); 
            pushFollow(FOLLOW_ruleInstruction_in_entryRuleInstruction311);
            ruleInstruction();

            state._fsp--;

             after(grammarAccess.getInstructionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstruction318); 

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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:196:1: ruleInstruction : ( ( rule__Instruction__Alternatives ) ) ;
    public final void ruleInstruction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:200:5: ( ( ( rule__Instruction__Alternatives ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:201:1: ( ( rule__Instruction__Alternatives ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:201:1: ( ( rule__Instruction__Alternatives ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:202:1: ( rule__Instruction__Alternatives )
            {
             before(grammarAccess.getInstructionAccess().getAlternatives()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:203:1: ( rule__Instruction__Alternatives )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:203:2: rule__Instruction__Alternatives
            {
            pushFollow(FOLLOW_rule__Instruction__Alternatives_in_ruleInstruction348);
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


    // $ANTLR start "entryRuleLiteral"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:215:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:216:1: ( ruleLiteral EOF )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:217:1: ruleLiteral EOF
            {
             before(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral375);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral382); 

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
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:224:1: ruleLiteral : ( ( rule__Literal__Alternatives ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:228:5: ( ( ( rule__Literal__Alternatives ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:229:1: ( ( rule__Literal__Alternatives ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:229:1: ( ( rule__Literal__Alternatives ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:230:1: ( rule__Literal__Alternatives )
            {
             before(grammarAccess.getLiteralAccess().getAlternatives()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:231:1: ( rule__Literal__Alternatives )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:231:2: rule__Literal__Alternatives
            {
            pushFollow(FOLLOW_rule__Literal__Alternatives_in_ruleLiteral412);
            rule__Literal__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLiteralAccess().getAlternatives()); 

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
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleWord"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:243:1: entryRuleWord : ruleWord EOF ;
    public final void entryRuleWord() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:244:1: ( ruleWord EOF )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:245:1: ruleWord EOF
            {
             before(grammarAccess.getWordRule()); 
            pushFollow(FOLLOW_ruleWord_in_entryRuleWord439);
            ruleWord();

            state._fsp--;

             after(grammarAccess.getWordRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWord446); 

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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:252:1: ruleWord : ( ( rule__Word__NameAssignment ) ) ;
    public final void ruleWord() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:256:5: ( ( ( rule__Word__NameAssignment ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:257:1: ( ( rule__Word__NameAssignment ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:257:1: ( ( rule__Word__NameAssignment ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:258:1: ( rule__Word__NameAssignment )
            {
             before(grammarAccess.getWordAccess().getNameAssignment()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:259:1: ( rule__Word__NameAssignment )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:259:2: rule__Word__NameAssignment
            {
            pushFollow(FOLLOW_rule__Word__NameAssignment_in_ruleWord476);
            rule__Word__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getWordAccess().getNameAssignment()); 

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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:271:1: rule__GlobalInstruction__Alternatives : ( ( ruleFunction ) | ( ruleInstruction ) );
    public final void rule__GlobalInstruction__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:275:1: ( ( ruleFunction ) | ( ruleInstruction ) )
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
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:276:1: ( ruleFunction )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:276:1: ( ruleFunction )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:277:1: ruleFunction
                    {
                     before(grammarAccess.getGlobalInstructionAccess().getFunctionParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleFunction_in_rule__GlobalInstruction__Alternatives512);
                    ruleFunction();

                    state._fsp--;

                     after(grammarAccess.getGlobalInstructionAccess().getFunctionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:282:6: ( ruleInstruction )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:282:6: ( ruleInstruction )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:283:1: ruleInstruction
                    {
                     before(grammarAccess.getGlobalInstructionAccess().getInstructionParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleInstruction_in_rule__GlobalInstruction__Alternatives529);
                    ruleInstruction();

                    state._fsp--;

                     after(grammarAccess.getGlobalInstructionAccess().getInstructionParserRuleCall_1()); 

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


    // $ANTLR start "rule__Keywords__NameAlternatives_0"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:293:1: rule__Keywords__NameAlternatives_0 : ( ( SWAP ) | ( OVER ) | ( NIP ) | ( UNDER ) | ( TUCK ) | ( ROT ) | ( ROT_1 ) | ( NEGATE ) | ( DUP ) | ( CALL ) );
    public final void rule__Keywords__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:297:1: ( ( SWAP ) | ( OVER ) | ( NIP ) | ( UNDER ) | ( TUCK ) | ( ROT ) | ( ROT_1 ) | ( NEGATE ) | ( DUP ) | ( CALL ) )
            int alt3=10;
            switch ( input.LA(1) ) {
            case SWAP:
                {
                alt3=1;
                }
                break;
            case OVER:
                {
                alt3=2;
                }
                break;
            case NIP:
                {
                alt3=3;
                }
                break;
            case UNDER:
                {
                alt3=4;
                }
                break;
            case TUCK:
                {
                alt3=5;
                }
                break;
            case ROT:
                {
                alt3=6;
                }
                break;
            case ROT_1:
                {
                alt3=7;
                }
                break;
            case NEGATE:
                {
                alt3=8;
                }
                break;
            case DUP:
                {
                alt3=9;
                }
                break;
            case CALL:
                {
                alt3=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:298:1: ( SWAP )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:298:1: ( SWAP )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:299:1: SWAP
                    {
                     before(grammarAccess.getKeywordsAccess().getNameSWAPKeyword_0_0()); 
                    match(input,SWAP,FOLLOW_SWAP_in_rule__Keywords__NameAlternatives_0562); 
                     after(grammarAccess.getKeywordsAccess().getNameSWAPKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:306:6: ( OVER )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:306:6: ( OVER )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:307:1: OVER
                    {
                     before(grammarAccess.getKeywordsAccess().getNameOVERKeyword_0_1()); 
                    match(input,OVER,FOLLOW_OVER_in_rule__Keywords__NameAlternatives_0582); 
                     after(grammarAccess.getKeywordsAccess().getNameOVERKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:314:6: ( NIP )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:314:6: ( NIP )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:315:1: NIP
                    {
                     before(grammarAccess.getKeywordsAccess().getNameNIPKeyword_0_2()); 
                    match(input,NIP,FOLLOW_NIP_in_rule__Keywords__NameAlternatives_0602); 
                     after(grammarAccess.getKeywordsAccess().getNameNIPKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:322:6: ( UNDER )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:322:6: ( UNDER )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:323:1: UNDER
                    {
                     before(grammarAccess.getKeywordsAccess().getNameUNDERKeyword_0_3()); 
                    match(input,UNDER,FOLLOW_UNDER_in_rule__Keywords__NameAlternatives_0622); 
                     after(grammarAccess.getKeywordsAccess().getNameUNDERKeyword_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:330:6: ( TUCK )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:330:6: ( TUCK )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:331:1: TUCK
                    {
                     before(grammarAccess.getKeywordsAccess().getNameTUCKKeyword_0_4()); 
                    match(input,TUCK,FOLLOW_TUCK_in_rule__Keywords__NameAlternatives_0642); 
                     after(grammarAccess.getKeywordsAccess().getNameTUCKKeyword_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:338:6: ( ROT )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:338:6: ( ROT )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:339:1: ROT
                    {
                     before(grammarAccess.getKeywordsAccess().getNameROTKeyword_0_5()); 
                    match(input,ROT,FOLLOW_ROT_in_rule__Keywords__NameAlternatives_0662); 
                     after(grammarAccess.getKeywordsAccess().getNameROTKeyword_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:346:6: ( ROT_1 )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:346:6: ( ROT_1 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:347:1: ROT_1
                    {
                     before(grammarAccess.getKeywordsAccess().getNameROTKeyword_0_6()); 
                    match(input,ROT_1,FOLLOW_ROT_1_in_rule__Keywords__NameAlternatives_0682); 
                     after(grammarAccess.getKeywordsAccess().getNameROTKeyword_0_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:354:6: ( NEGATE )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:354:6: ( NEGATE )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:355:1: NEGATE
                    {
                     before(grammarAccess.getKeywordsAccess().getNameNEGATEKeyword_0_7()); 
                    match(input,NEGATE,FOLLOW_NEGATE_in_rule__Keywords__NameAlternatives_0702); 
                     after(grammarAccess.getKeywordsAccess().getNameNEGATEKeyword_0_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:362:6: ( DUP )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:362:6: ( DUP )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:363:1: DUP
                    {
                     before(grammarAccess.getKeywordsAccess().getNameDUPKeyword_0_8()); 
                    match(input,DUP,FOLLOW_DUP_in_rule__Keywords__NameAlternatives_0722); 
                     after(grammarAccess.getKeywordsAccess().getNameDUPKeyword_0_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:370:6: ( CALL )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:370:6: ( CALL )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:371:1: CALL
                    {
                     before(grammarAccess.getKeywordsAccess().getNameCALLKeyword_0_9()); 
                    match(input,CALL,FOLLOW_CALL_in_rule__Keywords__NameAlternatives_0742); 
                     after(grammarAccess.getKeywordsAccess().getNameCALLKeyword_0_9()); 

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
    // $ANTLR end "rule__Keywords__NameAlternatives_0"


    // $ANTLR start "rule__Instruction__Alternatives"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:383:1: rule__Instruction__Alternatives : ( ( ruleKeywords ) | ( ruleWord ) | ( ( rule__Instruction__LitAssignment_2 ) ) );
    public final void rule__Instruction__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:387:1: ( ( ruleKeywords ) | ( ruleWord ) | ( ( rule__Instruction__LitAssignment_2 ) ) )
            int alt4=3;
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
                alt4=1;
                }
                break;
            case RULE_ID:
            case RULE_OPERATOR:
                {
                alt4=2;
                }
                break;
            case RULE_INT:
            case RULE_DOUBLE:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:388:1: ( ruleKeywords )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:388:1: ( ruleKeywords )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:389:1: ruleKeywords
                    {
                     before(grammarAccess.getInstructionAccess().getKeywordsParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleKeywords_in_rule__Instruction__Alternatives776);
                    ruleKeywords();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getKeywordsParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:394:6: ( ruleWord )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:394:6: ( ruleWord )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:395:1: ruleWord
                    {
                     before(grammarAccess.getInstructionAccess().getWordParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleWord_in_rule__Instruction__Alternatives793);
                    ruleWord();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getWordParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:400:6: ( ( rule__Instruction__LitAssignment_2 ) )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:400:6: ( ( rule__Instruction__LitAssignment_2 ) )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:401:1: ( rule__Instruction__LitAssignment_2 )
                    {
                     before(grammarAccess.getInstructionAccess().getLitAssignment_2()); 
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:402:1: ( rule__Instruction__LitAssignment_2 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:402:2: rule__Instruction__LitAssignment_2
                    {
                    pushFollow(FOLLOW_rule__Instruction__LitAssignment_2_in_rule__Instruction__Alternatives810);
                    rule__Instruction__LitAssignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getInstructionAccess().getLitAssignment_2()); 

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


    // $ANTLR start "rule__Literal__Alternatives"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:411:1: rule__Literal__Alternatives : ( ( RULE_INT ) | ( RULE_DOUBLE ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:415:1: ( ( RULE_INT ) | ( RULE_DOUBLE ) )
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
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:416:1: ( RULE_INT )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:416:1: ( RULE_INT )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:417:1: RULE_INT
                    {
                     before(grammarAccess.getLiteralAccess().getINTTerminalRuleCall_0()); 
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Literal__Alternatives843); 
                     after(grammarAccess.getLiteralAccess().getINTTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:422:6: ( RULE_DOUBLE )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:422:6: ( RULE_DOUBLE )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:423:1: RULE_DOUBLE
                    {
                     before(grammarAccess.getLiteralAccess().getDOUBLETerminalRuleCall_1()); 
                    match(input,RULE_DOUBLE,FOLLOW_RULE_DOUBLE_in_rule__Literal__Alternatives860); 
                     after(grammarAccess.getLiteralAccess().getDOUBLETerminalRuleCall_1()); 

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
    // $ANTLR end "rule__Literal__Alternatives"


    // $ANTLR start "rule__Word__NameAlternatives_0"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:433:1: rule__Word__NameAlternatives_0 : ( ( RULE_ID ) | ( RULE_OPERATOR ) );
    public final void rule__Word__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:437:1: ( ( RULE_ID ) | ( RULE_OPERATOR ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_OPERATOR) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:438:1: ( RULE_ID )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:438:1: ( RULE_ID )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:439:1: RULE_ID
                    {
                     before(grammarAccess.getWordAccess().getNameIDTerminalRuleCall_0_0()); 
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Word__NameAlternatives_0892); 
                     after(grammarAccess.getWordAccess().getNameIDTerminalRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:444:6: ( RULE_OPERATOR )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:444:6: ( RULE_OPERATOR )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:445:1: RULE_OPERATOR
                    {
                     before(grammarAccess.getWordAccess().getNameOPERATORTerminalRuleCall_0_1()); 
                    match(input,RULE_OPERATOR,FOLLOW_RULE_OPERATOR_in_rule__Word__NameAlternatives_0909); 
                     after(grammarAccess.getWordAccess().getNameOPERATORTerminalRuleCall_0_1()); 

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
    // $ANTLR end "rule__Word__NameAlternatives_0"


    // $ANTLR start "rule__Function__Group__0"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:457:1: rule__Function__Group__0 : rule__Function__Group__0__Impl rule__Function__Group__1 ;
    public final void rule__Function__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:461:1: ( rule__Function__Group__0__Impl rule__Function__Group__1 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:462:2: rule__Function__Group__0__Impl rule__Function__Group__1
            {
            pushFollow(FOLLOW_rule__Function__Group__0__Impl_in_rule__Function__Group__0939);
            rule__Function__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Function__Group__1_in_rule__Function__Group__0942);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:469:1: rule__Function__Group__0__Impl : ( Colon ) ;
    public final void rule__Function__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:473:1: ( ( Colon ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:474:1: ( Colon )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:474:1: ( Colon )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:475:1: Colon
            {
             before(grammarAccess.getFunctionAccess().getColonKeyword_0()); 
            match(input,Colon,FOLLOW_Colon_in_rule__Function__Group__0__Impl970); 
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:488:1: rule__Function__Group__1 : rule__Function__Group__1__Impl rule__Function__Group__2 ;
    public final void rule__Function__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:492:1: ( rule__Function__Group__1__Impl rule__Function__Group__2 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:493:2: rule__Function__Group__1__Impl rule__Function__Group__2
            {
            pushFollow(FOLLOW_rule__Function__Group__1__Impl_in_rule__Function__Group__11001);
            rule__Function__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Function__Group__2_in_rule__Function__Group__11004);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:500:1: rule__Function__Group__1__Impl : ( ( rule__Function__NameAssignment_1 ) ) ;
    public final void rule__Function__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:504:1: ( ( ( rule__Function__NameAssignment_1 ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:505:1: ( ( rule__Function__NameAssignment_1 ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:505:1: ( ( rule__Function__NameAssignment_1 ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:506:1: ( rule__Function__NameAssignment_1 )
            {
             before(grammarAccess.getFunctionAccess().getNameAssignment_1()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:507:1: ( rule__Function__NameAssignment_1 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:507:2: rule__Function__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Function__NameAssignment_1_in_rule__Function__Group__1__Impl1031);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:517:1: rule__Function__Group__2 : rule__Function__Group__2__Impl rule__Function__Group__3 ;
    public final void rule__Function__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:521:1: ( rule__Function__Group__2__Impl rule__Function__Group__3 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:522:2: rule__Function__Group__2__Impl rule__Function__Group__3
            {
            pushFollow(FOLLOW_rule__Function__Group__2__Impl_in_rule__Function__Group__21061);
            rule__Function__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Function__Group__3_in_rule__Function__Group__21064);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:529:1: rule__Function__Group__2__Impl : ( ( rule__Function__WordsAssignment_2 )* ) ;
    public final void rule__Function__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:533:1: ( ( ( rule__Function__WordsAssignment_2 )* ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:534:1: ( ( rule__Function__WordsAssignment_2 )* )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:534:1: ( ( rule__Function__WordsAssignment_2 )* )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:535:1: ( rule__Function__WordsAssignment_2 )*
            {
             before(grammarAccess.getFunctionAccess().getWordsAssignment_2()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:536:1: ( rule__Function__WordsAssignment_2 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=NEGATE && LA7_0<=ROT)||(LA7_0>=RULE_INT && LA7_0<=RULE_OPERATOR)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:536:2: rule__Function__WordsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Function__WordsAssignment_2_in_rule__Function__Group__2__Impl1091);
            	    rule__Function__WordsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:546:1: rule__Function__Group__3 : rule__Function__Group__3__Impl ;
    public final void rule__Function__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:550:1: ( rule__Function__Group__3__Impl )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:551:2: rule__Function__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Function__Group__3__Impl_in_rule__Function__Group__31122);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:557:1: rule__Function__Group__3__Impl : ( Semicolon ) ;
    public final void rule__Function__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:561:1: ( ( Semicolon ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:562:1: ( Semicolon )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:562:1: ( Semicolon )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:563:1: Semicolon
            {
             before(grammarAccess.getFunctionAccess().getSemicolonKeyword_3()); 
            match(input,Semicolon,FOLLOW_Semicolon_in_rule__Function__Group__3__Impl1150); 
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


    // $ANTLR start "rule__Forth__InstructionsAssignment"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:585:1: rule__Forth__InstructionsAssignment : ( ruleGlobalInstruction ) ;
    public final void rule__Forth__InstructionsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:589:1: ( ( ruleGlobalInstruction ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:590:1: ( ruleGlobalInstruction )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:590:1: ( ruleGlobalInstruction )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:591:1: ruleGlobalInstruction
            {
             before(grammarAccess.getForthAccess().getInstructionsGlobalInstructionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleGlobalInstruction_in_rule__Forth__InstructionsAssignment1194);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:600:1: rule__Function__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Function__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:604:1: ( ( RULE_ID ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:605:1: ( RULE_ID )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:605:1: ( RULE_ID )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:606:1: RULE_ID
            {
             before(grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Function__NameAssignment_11225); 
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:615:1: rule__Function__WordsAssignment_2 : ( ruleInstruction ) ;
    public final void rule__Function__WordsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:619:1: ( ( ruleInstruction ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:620:1: ( ruleInstruction )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:620:1: ( ruleInstruction )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:621:1: ruleInstruction
            {
             before(grammarAccess.getFunctionAccess().getWordsInstructionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleInstruction_in_rule__Function__WordsAssignment_21256);
            ruleInstruction();

            state._fsp--;

             after(grammarAccess.getFunctionAccess().getWordsInstructionParserRuleCall_2_0()); 

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


    // $ANTLR start "rule__Keywords__NameAssignment"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:630:1: rule__Keywords__NameAssignment : ( ( rule__Keywords__NameAlternatives_0 ) ) ;
    public final void rule__Keywords__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:634:1: ( ( ( rule__Keywords__NameAlternatives_0 ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:635:1: ( ( rule__Keywords__NameAlternatives_0 ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:635:1: ( ( rule__Keywords__NameAlternatives_0 ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:636:1: ( rule__Keywords__NameAlternatives_0 )
            {
             before(grammarAccess.getKeywordsAccess().getNameAlternatives_0()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:637:1: ( rule__Keywords__NameAlternatives_0 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:637:2: rule__Keywords__NameAlternatives_0
            {
            pushFollow(FOLLOW_rule__Keywords__NameAlternatives_0_in_rule__Keywords__NameAssignment1287);
            rule__Keywords__NameAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getKeywordsAccess().getNameAlternatives_0()); 

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
    // $ANTLR end "rule__Keywords__NameAssignment"


    // $ANTLR start "rule__Instruction__LitAssignment_2"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:646:1: rule__Instruction__LitAssignment_2 : ( ruleLiteral ) ;
    public final void rule__Instruction__LitAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:650:1: ( ( ruleLiteral ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:651:1: ( ruleLiteral )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:651:1: ( ruleLiteral )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:652:1: ruleLiteral
            {
             before(grammarAccess.getInstructionAccess().getLitLiteralParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleLiteral_in_rule__Instruction__LitAssignment_21320);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getInstructionAccess().getLitLiteralParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__Instruction__LitAssignment_2"


    // $ANTLR start "rule__Word__NameAssignment"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:661:1: rule__Word__NameAssignment : ( ( rule__Word__NameAlternatives_0 ) ) ;
    public final void rule__Word__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:665:1: ( ( ( rule__Word__NameAlternatives_0 ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:666:1: ( ( rule__Word__NameAlternatives_0 ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:666:1: ( ( rule__Word__NameAlternatives_0 ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:667:1: ( rule__Word__NameAlternatives_0 )
            {
             before(grammarAccess.getWordAccess().getNameAlternatives_0()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:668:1: ( rule__Word__NameAlternatives_0 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:668:2: rule__Word__NameAlternatives_0
            {
            pushFollow(FOLLOW_rule__Word__NameAlternatives_0_in_rule__Word__NameAssignment1351);
            rule__Word__NameAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getWordAccess().getNameAlternatives_0()); 

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
    // $ANTLR end "rule__Word__NameAssignment"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleForth_in_entryRuleForth54 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleForth61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Forth__InstructionsAssignment_in_ruleForth91 = new BitSet(new long[]{0x0000000000F07FF2L});
    public static final BitSet FOLLOW_ruleGlobalInstruction_in_entryRuleGlobalInstruction119 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGlobalInstruction126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GlobalInstruction__Alternatives_in_ruleGlobalInstruction156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_entryRuleFunction183 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunction190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__0_in_ruleFunction220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywords_in_entryRuleKeywords247 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeywords254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keywords__NameAssignment_in_ruleKeywords284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_entryRuleInstruction311 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstruction318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Alternatives_in_ruleInstruction348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral375 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__Alternatives_in_ruleLiteral412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWord_in_entryRuleWord439 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWord446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Word__NameAssignment_in_ruleWord476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_rule__GlobalInstruction__Alternatives512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_rule__GlobalInstruction__Alternatives529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SWAP_in_rule__Keywords__NameAlternatives_0562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OVER_in_rule__Keywords__NameAlternatives_0582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NIP_in_rule__Keywords__NameAlternatives_0602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNDER_in_rule__Keywords__NameAlternatives_0622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUCK_in_rule__Keywords__NameAlternatives_0642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROT_in_rule__Keywords__NameAlternatives_0662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROT_1_in_rule__Keywords__NameAlternatives_0682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEGATE_in_rule__Keywords__NameAlternatives_0702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DUP_in_rule__Keywords__NameAlternatives_0722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CALL_in_rule__Keywords__NameAlternatives_0742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywords_in_rule__Instruction__Alternatives776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWord_in_rule__Instruction__Alternatives793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__LitAssignment_2_in_rule__Instruction__Alternatives810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Literal__Alternatives843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOUBLE_in_rule__Literal__Alternatives860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Word__NameAlternatives_0892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OPERATOR_in_rule__Word__NameAlternatives_0909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__0__Impl_in_rule__Function__Group__0939 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__Function__Group__1_in_rule__Function__Group__0942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Colon_in_rule__Function__Group__0__Impl970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__1__Impl_in_rule__Function__Group__11001 = new BitSet(new long[]{0x0000000000F0FFF0L});
    public static final BitSet FOLLOW_rule__Function__Group__2_in_rule__Function__Group__11004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__NameAssignment_1_in_rule__Function__Group__1__Impl1031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__2__Impl_in_rule__Function__Group__21061 = new BitSet(new long[]{0x0000000000F0FFF0L});
    public static final BitSet FOLLOW_rule__Function__Group__3_in_rule__Function__Group__21064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__WordsAssignment_2_in_rule__Function__Group__2__Impl1091 = new BitSet(new long[]{0x0000000000F07FF2L});
    public static final BitSet FOLLOW_rule__Function__Group__3__Impl_in_rule__Function__Group__31122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Semicolon_in_rule__Function__Group__3__Impl1150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGlobalInstruction_in_rule__Forth__InstructionsAssignment1194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Function__NameAssignment_11225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_rule__Function__WordsAssignment_21256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keywords__NameAlternatives_0_in_rule__Keywords__NameAssignment1287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rule__Instruction__LitAssignment_21320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Word__NameAlternatives_0_in_rule__Word__NameAssignment1351 = new BitSet(new long[]{0x0000000000000002L});

}