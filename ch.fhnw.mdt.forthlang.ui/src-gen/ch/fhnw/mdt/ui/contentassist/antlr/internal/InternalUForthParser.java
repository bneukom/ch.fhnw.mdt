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
    public String getGrammarFileName() { return "../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g"; }


     
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



    // $ANTLR start "entryRuleForth"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:77:1: entryRuleForth : ruleForth EOF ;
    public final void entryRuleForth() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:78:1: ( ruleForth EOF )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:79:1: ruleForth EOF
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:86:1: ruleForth : ( ( rule__Forth__InstructionsAssignment )* ) ;
    public final void ruleForth() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:90:5: ( ( ( rule__Forth__InstructionsAssignment )* ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:91:1: ( ( rule__Forth__InstructionsAssignment )* )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:91:1: ( ( rule__Forth__InstructionsAssignment )* )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:92:1: ( rule__Forth__InstructionsAssignment )*
            {
             before(grammarAccess.getForthAccess().getInstructionsAssignment()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:93:1: ( rule__Forth__InstructionsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=NEGATE && LA1_0<=ROT)||LA1_0==Colon||(LA1_0>=RULE_INT && LA1_0<=RULE_OPERATOR)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:93:2: rule__Forth__InstructionsAssignment
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:105:1: entryRuleGlobalInstruction : ruleGlobalInstruction EOF ;
    public final void entryRuleGlobalInstruction() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:106:1: ( ruleGlobalInstruction EOF )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:107:1: ruleGlobalInstruction EOF
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:114:1: ruleGlobalInstruction : ( ( rule__GlobalInstruction__Alternatives ) ) ;
    public final void ruleGlobalInstruction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:118:5: ( ( ( rule__GlobalInstruction__Alternatives ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:119:1: ( ( rule__GlobalInstruction__Alternatives ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:119:1: ( ( rule__GlobalInstruction__Alternatives ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:120:1: ( rule__GlobalInstruction__Alternatives )
            {
             before(grammarAccess.getGlobalInstructionAccess().getAlternatives()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:121:1: ( rule__GlobalInstruction__Alternatives )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:121:2: rule__GlobalInstruction__Alternatives
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:133:1: entryRuleFunction : ruleFunction EOF ;
    public final void entryRuleFunction() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:134:1: ( ruleFunction EOF )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:135:1: ruleFunction EOF
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:142:1: ruleFunction : ( ( rule__Function__Group__0 ) ) ;
    public final void ruleFunction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:146:5: ( ( ( rule__Function__Group__0 ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:147:1: ( ( rule__Function__Group__0 ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:147:1: ( ( rule__Function__Group__0 ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:148:1: ( rule__Function__Group__0 )
            {
             before(grammarAccess.getFunctionAccess().getGroup()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:149:1: ( rule__Function__Group__0 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:149:2: rule__Function__Group__0
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:161:1: entryRuleCreate : ruleCreate EOF ;
    public final void entryRuleCreate() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:162:1: ( ruleCreate EOF )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:163:1: ruleCreate EOF
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:170:1: ruleCreate : ( ( rule__Create__Group__0 ) ) ;
    public final void ruleCreate() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:174:5: ( ( ( rule__Create__Group__0 ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:175:1: ( ( rule__Create__Group__0 ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:175:1: ( ( rule__Create__Group__0 ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:176:1: ( rule__Create__Group__0 )
            {
             before(grammarAccess.getCreateAccess().getGroup()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:177:1: ( rule__Create__Group__0 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:177:2: rule__Create__Group__0
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


    // $ANTLR start "entryRuleKeywords"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:189:1: entryRuleKeywords : ruleKeywords EOF ;
    public final void entryRuleKeywords() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:190:1: ( ruleKeywords EOF )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:191:1: ruleKeywords EOF
            {
             before(grammarAccess.getKeywordsRule()); 
            pushFollow(FOLLOW_ruleKeywords_in_entryRuleKeywords311);
            ruleKeywords();

            state._fsp--;

             after(grammarAccess.getKeywordsRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeywords318); 

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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:198:1: ruleKeywords : ( ( rule__Keywords__NameAssignment ) ) ;
    public final void ruleKeywords() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:202:5: ( ( ( rule__Keywords__NameAssignment ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:203:1: ( ( rule__Keywords__NameAssignment ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:203:1: ( ( rule__Keywords__NameAssignment ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:204:1: ( rule__Keywords__NameAssignment )
            {
             before(grammarAccess.getKeywordsAccess().getNameAssignment()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:205:1: ( rule__Keywords__NameAssignment )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:205:2: rule__Keywords__NameAssignment
            {
            pushFollow(FOLLOW_rule__Keywords__NameAssignment_in_ruleKeywords348);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:217:1: entryRuleInstruction : ruleInstruction EOF ;
    public final void entryRuleInstruction() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:218:1: ( ruleInstruction EOF )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:219:1: ruleInstruction EOF
            {
             before(grammarAccess.getInstructionRule()); 
            pushFollow(FOLLOW_ruleInstruction_in_entryRuleInstruction375);
            ruleInstruction();

            state._fsp--;

             after(grammarAccess.getInstructionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstruction382); 

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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:226:1: ruleInstruction : ( ( rule__Instruction__Alternatives ) ) ;
    public final void ruleInstruction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:230:5: ( ( ( rule__Instruction__Alternatives ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:231:1: ( ( rule__Instruction__Alternatives ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:231:1: ( ( rule__Instruction__Alternatives ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:232:1: ( rule__Instruction__Alternatives )
            {
             before(grammarAccess.getInstructionAccess().getAlternatives()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:233:1: ( rule__Instruction__Alternatives )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:233:2: rule__Instruction__Alternatives
            {
            pushFollow(FOLLOW_rule__Instruction__Alternatives_in_ruleInstruction412);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:245:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:246:1: ( ruleLiteral EOF )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:247:1: ruleLiteral EOF
            {
             before(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral439);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral446); 

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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:254:1: ruleLiteral : ( ( rule__Literal__Alternatives ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:258:5: ( ( ( rule__Literal__Alternatives ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:259:1: ( ( rule__Literal__Alternatives ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:259:1: ( ( rule__Literal__Alternatives ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:260:1: ( rule__Literal__Alternatives )
            {
             before(grammarAccess.getLiteralAccess().getAlternatives()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:261:1: ( rule__Literal__Alternatives )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:261:2: rule__Literal__Alternatives
            {
            pushFollow(FOLLOW_rule__Literal__Alternatives_in_ruleLiteral476);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:273:1: entryRuleWord : ruleWord EOF ;
    public final void entryRuleWord() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:274:1: ( ruleWord EOF )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:275:1: ruleWord EOF
            {
             before(grammarAccess.getWordRule()); 
            pushFollow(FOLLOW_ruleWord_in_entryRuleWord503);
            ruleWord();

            state._fsp--;

             after(grammarAccess.getWordRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWord510); 

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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:282:1: ruleWord : ( ( rule__Word__NameAssignment ) ) ;
    public final void ruleWord() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:286:5: ( ( ( rule__Word__NameAssignment ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:287:1: ( ( rule__Word__NameAssignment ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:287:1: ( ( rule__Word__NameAssignment ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:288:1: ( rule__Word__NameAssignment )
            {
             before(grammarAccess.getWordAccess().getNameAssignment()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:289:1: ( rule__Word__NameAssignment )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:289:2: rule__Word__NameAssignment
            {
            pushFollow(FOLLOW_rule__Word__NameAssignment_in_ruleWord540);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:301:1: rule__GlobalInstruction__Alternatives : ( ( ruleCreate ) | ( ruleFunction ) | ( ruleInstruction ) );
    public final void rule__GlobalInstruction__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:305:1: ( ( ruleCreate ) | ( ruleFunction ) | ( ruleInstruction ) )
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
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:306:1: ( ruleCreate )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:306:1: ( ruleCreate )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:307:1: ruleCreate
                    {
                     before(grammarAccess.getGlobalInstructionAccess().getCreateParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleCreate_in_rule__GlobalInstruction__Alternatives576);
                    ruleCreate();

                    state._fsp--;

                     after(grammarAccess.getGlobalInstructionAccess().getCreateParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:312:6: ( ruleFunction )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:312:6: ( ruleFunction )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:313:1: ruleFunction
                    {
                     before(grammarAccess.getGlobalInstructionAccess().getFunctionParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleFunction_in_rule__GlobalInstruction__Alternatives593);
                    ruleFunction();

                    state._fsp--;

                     after(grammarAccess.getGlobalInstructionAccess().getFunctionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:318:6: ( ruleInstruction )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:318:6: ( ruleInstruction )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:319:1: ruleInstruction
                    {
                     before(grammarAccess.getGlobalInstructionAccess().getInstructionParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleInstruction_in_rule__GlobalInstruction__Alternatives610);
                    ruleInstruction();

                    state._fsp--;

                     after(grammarAccess.getGlobalInstructionAccess().getInstructionParserRuleCall_2()); 

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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:329:1: rule__Keywords__NameAlternatives_0 : ( ( SWAP ) | ( OVER ) | ( NIP ) | ( UNDER ) | ( TUCK ) | ( ROT ) | ( ROT_1 ) | ( NEGATE ) | ( DUP ) | ( CALL ) );
    public final void rule__Keywords__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:333:1: ( ( SWAP ) | ( OVER ) | ( NIP ) | ( UNDER ) | ( TUCK ) | ( ROT ) | ( ROT_1 ) | ( NEGATE ) | ( DUP ) | ( CALL ) )
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
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:334:1: ( SWAP )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:334:1: ( SWAP )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:335:1: SWAP
                    {
                     before(grammarAccess.getKeywordsAccess().getNameSWAPKeyword_0_0()); 
                    match(input,SWAP,FOLLOW_SWAP_in_rule__Keywords__NameAlternatives_0643); 
                     after(grammarAccess.getKeywordsAccess().getNameSWAPKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:342:6: ( OVER )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:342:6: ( OVER )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:343:1: OVER
                    {
                     before(grammarAccess.getKeywordsAccess().getNameOVERKeyword_0_1()); 
                    match(input,OVER,FOLLOW_OVER_in_rule__Keywords__NameAlternatives_0663); 
                     after(grammarAccess.getKeywordsAccess().getNameOVERKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:350:6: ( NIP )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:350:6: ( NIP )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:351:1: NIP
                    {
                     before(grammarAccess.getKeywordsAccess().getNameNIPKeyword_0_2()); 
                    match(input,NIP,FOLLOW_NIP_in_rule__Keywords__NameAlternatives_0683); 
                     after(grammarAccess.getKeywordsAccess().getNameNIPKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:358:6: ( UNDER )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:358:6: ( UNDER )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:359:1: UNDER
                    {
                     before(grammarAccess.getKeywordsAccess().getNameUNDERKeyword_0_3()); 
                    match(input,UNDER,FOLLOW_UNDER_in_rule__Keywords__NameAlternatives_0703); 
                     after(grammarAccess.getKeywordsAccess().getNameUNDERKeyword_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:366:6: ( TUCK )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:366:6: ( TUCK )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:367:1: TUCK
                    {
                     before(grammarAccess.getKeywordsAccess().getNameTUCKKeyword_0_4()); 
                    match(input,TUCK,FOLLOW_TUCK_in_rule__Keywords__NameAlternatives_0723); 
                     after(grammarAccess.getKeywordsAccess().getNameTUCKKeyword_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:374:6: ( ROT )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:374:6: ( ROT )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:375:1: ROT
                    {
                     before(grammarAccess.getKeywordsAccess().getNameROTKeyword_0_5()); 
                    match(input,ROT,FOLLOW_ROT_in_rule__Keywords__NameAlternatives_0743); 
                     after(grammarAccess.getKeywordsAccess().getNameROTKeyword_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:382:6: ( ROT_1 )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:382:6: ( ROT_1 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:383:1: ROT_1
                    {
                     before(grammarAccess.getKeywordsAccess().getNameROTKeyword_0_6()); 
                    match(input,ROT_1,FOLLOW_ROT_1_in_rule__Keywords__NameAlternatives_0763); 
                     after(grammarAccess.getKeywordsAccess().getNameROTKeyword_0_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:390:6: ( NEGATE )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:390:6: ( NEGATE )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:391:1: NEGATE
                    {
                     before(grammarAccess.getKeywordsAccess().getNameNEGATEKeyword_0_7()); 
                    match(input,NEGATE,FOLLOW_NEGATE_in_rule__Keywords__NameAlternatives_0783); 
                     after(grammarAccess.getKeywordsAccess().getNameNEGATEKeyword_0_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:398:6: ( DUP )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:398:6: ( DUP )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:399:1: DUP
                    {
                     before(grammarAccess.getKeywordsAccess().getNameDUPKeyword_0_8()); 
                    match(input,DUP,FOLLOW_DUP_in_rule__Keywords__NameAlternatives_0803); 
                     after(grammarAccess.getKeywordsAccess().getNameDUPKeyword_0_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:406:6: ( CALL )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:406:6: ( CALL )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:407:1: CALL
                    {
                     before(grammarAccess.getKeywordsAccess().getNameCALLKeyword_0_9()); 
                    match(input,CALL,FOLLOW_CALL_in_rule__Keywords__NameAlternatives_0823); 
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:419:1: rule__Instruction__Alternatives : ( ( ruleKeywords ) | ( ruleWord ) | ( ( rule__Instruction__NameAssignment_2 ) ) );
    public final void rule__Instruction__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:423:1: ( ( ruleKeywords ) | ( ruleWord ) | ( ( rule__Instruction__NameAssignment_2 ) ) )
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
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:424:1: ( ruleKeywords )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:424:1: ( ruleKeywords )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:425:1: ruleKeywords
                    {
                     before(grammarAccess.getInstructionAccess().getKeywordsParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleKeywords_in_rule__Instruction__Alternatives857);
                    ruleKeywords();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getKeywordsParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:430:6: ( ruleWord )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:430:6: ( ruleWord )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:431:1: ruleWord
                    {
                     before(grammarAccess.getInstructionAccess().getWordParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleWord_in_rule__Instruction__Alternatives874);
                    ruleWord();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getWordParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:436:6: ( ( rule__Instruction__NameAssignment_2 ) )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:436:6: ( ( rule__Instruction__NameAssignment_2 ) )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:437:1: ( rule__Instruction__NameAssignment_2 )
                    {
                     before(grammarAccess.getInstructionAccess().getNameAssignment_2()); 
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:438:1: ( rule__Instruction__NameAssignment_2 )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:438:2: rule__Instruction__NameAssignment_2
                    {
                    pushFollow(FOLLOW_rule__Instruction__NameAssignment_2_in_rule__Instruction__Alternatives891);
                    rule__Instruction__NameAssignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getInstructionAccess().getNameAssignment_2()); 

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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:447:1: rule__Literal__Alternatives : ( ( RULE_INT ) | ( RULE_DOUBLE ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:451:1: ( ( RULE_INT ) | ( RULE_DOUBLE ) )
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
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:452:1: ( RULE_INT )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:452:1: ( RULE_INT )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:453:1: RULE_INT
                    {
                     before(grammarAccess.getLiteralAccess().getINTTerminalRuleCall_0()); 
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Literal__Alternatives924); 
                     after(grammarAccess.getLiteralAccess().getINTTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:458:6: ( RULE_DOUBLE )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:458:6: ( RULE_DOUBLE )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:459:1: RULE_DOUBLE
                    {
                     before(grammarAccess.getLiteralAccess().getDOUBLETerminalRuleCall_1()); 
                    match(input,RULE_DOUBLE,FOLLOW_RULE_DOUBLE_in_rule__Literal__Alternatives941); 
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:469:1: rule__Word__NameAlternatives_0 : ( ( RULE_ID ) | ( RULE_OPERATOR ) );
    public final void rule__Word__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:473:1: ( ( RULE_ID ) | ( RULE_OPERATOR ) )
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
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:474:1: ( RULE_ID )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:474:1: ( RULE_ID )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:475:1: RULE_ID
                    {
                     before(grammarAccess.getWordAccess().getNameIDTerminalRuleCall_0_0()); 
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Word__NameAlternatives_0973); 
                     after(grammarAccess.getWordAccess().getNameIDTerminalRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:480:6: ( RULE_OPERATOR )
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:480:6: ( RULE_OPERATOR )
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:481:1: RULE_OPERATOR
                    {
                     before(grammarAccess.getWordAccess().getNameOPERATORTerminalRuleCall_0_1()); 
                    match(input,RULE_OPERATOR,FOLLOW_RULE_OPERATOR_in_rule__Word__NameAlternatives_0990); 
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:493:1: rule__Function__Group__0 : rule__Function__Group__0__Impl rule__Function__Group__1 ;
    public final void rule__Function__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:497:1: ( rule__Function__Group__0__Impl rule__Function__Group__1 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:498:2: rule__Function__Group__0__Impl rule__Function__Group__1
            {
            pushFollow(FOLLOW_rule__Function__Group__0__Impl_in_rule__Function__Group__01020);
            rule__Function__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Function__Group__1_in_rule__Function__Group__01023);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:505:1: rule__Function__Group__0__Impl : ( Colon ) ;
    public final void rule__Function__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:509:1: ( ( Colon ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:510:1: ( Colon )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:510:1: ( Colon )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:511:1: Colon
            {
             before(grammarAccess.getFunctionAccess().getColonKeyword_0()); 
            match(input,Colon,FOLLOW_Colon_in_rule__Function__Group__0__Impl1051); 
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:524:1: rule__Function__Group__1 : rule__Function__Group__1__Impl rule__Function__Group__2 ;
    public final void rule__Function__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:528:1: ( rule__Function__Group__1__Impl rule__Function__Group__2 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:529:2: rule__Function__Group__1__Impl rule__Function__Group__2
            {
            pushFollow(FOLLOW_rule__Function__Group__1__Impl_in_rule__Function__Group__11082);
            rule__Function__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Function__Group__2_in_rule__Function__Group__11085);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:536:1: rule__Function__Group__1__Impl : ( ( rule__Function__NameAssignment_1 ) ) ;
    public final void rule__Function__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:540:1: ( ( ( rule__Function__NameAssignment_1 ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:541:1: ( ( rule__Function__NameAssignment_1 ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:541:1: ( ( rule__Function__NameAssignment_1 ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:542:1: ( rule__Function__NameAssignment_1 )
            {
             before(grammarAccess.getFunctionAccess().getNameAssignment_1()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:543:1: ( rule__Function__NameAssignment_1 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:543:2: rule__Function__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Function__NameAssignment_1_in_rule__Function__Group__1__Impl1112);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:553:1: rule__Function__Group__2 : rule__Function__Group__2__Impl rule__Function__Group__3 ;
    public final void rule__Function__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:557:1: ( rule__Function__Group__2__Impl rule__Function__Group__3 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:558:2: rule__Function__Group__2__Impl rule__Function__Group__3
            {
            pushFollow(FOLLOW_rule__Function__Group__2__Impl_in_rule__Function__Group__21142);
            rule__Function__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Function__Group__3_in_rule__Function__Group__21145);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:565:1: rule__Function__Group__2__Impl : ( ( rule__Function__WordsAssignment_2 )* ) ;
    public final void rule__Function__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:569:1: ( ( ( rule__Function__WordsAssignment_2 )* ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:570:1: ( ( rule__Function__WordsAssignment_2 )* )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:570:1: ( ( rule__Function__WordsAssignment_2 )* )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:571:1: ( rule__Function__WordsAssignment_2 )*
            {
             before(grammarAccess.getFunctionAccess().getWordsAssignment_2()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:572:1: ( rule__Function__WordsAssignment_2 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==NEGATE||(LA7_0>=UNDER && LA7_0<=ROT)||(LA7_0>=RULE_INT && LA7_0<=RULE_OPERATOR)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:572:2: rule__Function__WordsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Function__WordsAssignment_2_in_rule__Function__Group__2__Impl1172);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:582:1: rule__Function__Group__3 : rule__Function__Group__3__Impl ;
    public final void rule__Function__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:586:1: ( rule__Function__Group__3__Impl )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:587:2: rule__Function__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Function__Group__3__Impl_in_rule__Function__Group__31203);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:593:1: rule__Function__Group__3__Impl : ( Semicolon ) ;
    public final void rule__Function__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:597:1: ( ( Semicolon ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:598:1: ( Semicolon )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:598:1: ( Semicolon )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:599:1: Semicolon
            {
             before(grammarAccess.getFunctionAccess().getSemicolonKeyword_3()); 
            match(input,Semicolon,FOLLOW_Semicolon_in_rule__Function__Group__3__Impl1231); 
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:620:1: rule__Create__Group__0 : rule__Create__Group__0__Impl rule__Create__Group__1 ;
    public final void rule__Create__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:624:1: ( rule__Create__Group__0__Impl rule__Create__Group__1 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:625:2: rule__Create__Group__0__Impl rule__Create__Group__1
            {
            pushFollow(FOLLOW_rule__Create__Group__0__Impl_in_rule__Create__Group__01270);
            rule__Create__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Create__Group__1_in_rule__Create__Group__01273);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:632:1: rule__Create__Group__0__Impl : ( Create ) ;
    public final void rule__Create__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:636:1: ( ( Create ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:637:1: ( Create )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:637:1: ( Create )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:638:1: Create
            {
             before(grammarAccess.getCreateAccess().getCreateKeyword_0()); 
            match(input,Create,FOLLOW_Create_in_rule__Create__Group__0__Impl1301); 
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:651:1: rule__Create__Group__1 : rule__Create__Group__1__Impl rule__Create__Group__2 ;
    public final void rule__Create__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:655:1: ( rule__Create__Group__1__Impl rule__Create__Group__2 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:656:2: rule__Create__Group__1__Impl rule__Create__Group__2
            {
            pushFollow(FOLLOW_rule__Create__Group__1__Impl_in_rule__Create__Group__11332);
            rule__Create__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Create__Group__2_in_rule__Create__Group__11335);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:663:1: rule__Create__Group__1__Impl : ( ( rule__Create__NameAssignment_1 ) ) ;
    public final void rule__Create__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:667:1: ( ( ( rule__Create__NameAssignment_1 ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:668:1: ( ( rule__Create__NameAssignment_1 ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:668:1: ( ( rule__Create__NameAssignment_1 ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:669:1: ( rule__Create__NameAssignment_1 )
            {
             before(grammarAccess.getCreateAccess().getNameAssignment_1()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:670:1: ( rule__Create__NameAssignment_1 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:670:2: rule__Create__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Create__NameAssignment_1_in_rule__Create__Group__1__Impl1362);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:680:1: rule__Create__Group__2 : rule__Create__Group__2__Impl ;
    public final void rule__Create__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:684:1: ( rule__Create__Group__2__Impl )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:685:2: rule__Create__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Create__Group__2__Impl_in_rule__Create__Group__21392);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:691:1: rule__Create__Group__2__Impl : ( ( rule__Create__Group_2__0 )* ) ;
    public final void rule__Create__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:695:1: ( ( ( rule__Create__Group_2__0 )* ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:696:1: ( ( rule__Create__Group_2__0 )* )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:696:1: ( ( rule__Create__Group_2__0 )* )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:697:1: ( rule__Create__Group_2__0 )*
            {
             before(grammarAccess.getCreateAccess().getGroup_2()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:698:1: ( rule__Create__Group_2__0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_INT) ) {
                    int LA8_2 = input.LA(2);

                    if ( (LA8_2==Comma) ) {
                        alt8=1;
                    }


                }
                else if ( (LA8_0==RULE_DOUBLE) ) {
                    int LA8_3 = input.LA(2);

                    if ( (LA8_3==Comma) ) {
                        alt8=1;
                    }


                }


                switch (alt8) {
            	case 1 :
            	    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:698:2: rule__Create__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Create__Group_2__0_in_rule__Create__Group__2__Impl1419);
            	    rule__Create__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:714:1: rule__Create__Group_2__0 : rule__Create__Group_2__0__Impl rule__Create__Group_2__1 ;
    public final void rule__Create__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:718:1: ( rule__Create__Group_2__0__Impl rule__Create__Group_2__1 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:719:2: rule__Create__Group_2__0__Impl rule__Create__Group_2__1
            {
            pushFollow(FOLLOW_rule__Create__Group_2__0__Impl_in_rule__Create__Group_2__01456);
            rule__Create__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Create__Group_2__1_in_rule__Create__Group_2__01459);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:726:1: rule__Create__Group_2__0__Impl : ( ( rule__Create__LitAssignment_2_0 ) ) ;
    public final void rule__Create__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:730:1: ( ( ( rule__Create__LitAssignment_2_0 ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:731:1: ( ( rule__Create__LitAssignment_2_0 ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:731:1: ( ( rule__Create__LitAssignment_2_0 ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:732:1: ( rule__Create__LitAssignment_2_0 )
            {
             before(grammarAccess.getCreateAccess().getLitAssignment_2_0()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:733:1: ( rule__Create__LitAssignment_2_0 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:733:2: rule__Create__LitAssignment_2_0
            {
            pushFollow(FOLLOW_rule__Create__LitAssignment_2_0_in_rule__Create__Group_2__0__Impl1486);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:743:1: rule__Create__Group_2__1 : rule__Create__Group_2__1__Impl ;
    public final void rule__Create__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:747:1: ( rule__Create__Group_2__1__Impl )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:748:2: rule__Create__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Create__Group_2__1__Impl_in_rule__Create__Group_2__11516);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:754:1: rule__Create__Group_2__1__Impl : ( Comma ) ;
    public final void rule__Create__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:758:1: ( ( Comma ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:759:1: ( Comma )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:759:1: ( Comma )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:760:1: Comma
            {
             before(grammarAccess.getCreateAccess().getCommaKeyword_2_1()); 
            match(input,Comma,FOLLOW_Comma_in_rule__Create__Group_2__1__Impl1544); 
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:778:1: rule__Forth__InstructionsAssignment : ( ruleGlobalInstruction ) ;
    public final void rule__Forth__InstructionsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:782:1: ( ( ruleGlobalInstruction ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:783:1: ( ruleGlobalInstruction )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:783:1: ( ruleGlobalInstruction )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:784:1: ruleGlobalInstruction
            {
             before(grammarAccess.getForthAccess().getInstructionsGlobalInstructionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleGlobalInstruction_in_rule__Forth__InstructionsAssignment1584);
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:793:1: rule__Function__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Function__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:797:1: ( ( RULE_ID ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:798:1: ( RULE_ID )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:798:1: ( RULE_ID )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:799:1: RULE_ID
            {
             before(grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Function__NameAssignment_11615); 
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:808:1: rule__Function__WordsAssignment_2 : ( ruleInstruction ) ;
    public final void rule__Function__WordsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:812:1: ( ( ruleInstruction ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:813:1: ( ruleInstruction )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:813:1: ( ruleInstruction )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:814:1: ruleInstruction
            {
             before(grammarAccess.getFunctionAccess().getWordsInstructionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleInstruction_in_rule__Function__WordsAssignment_21646);
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


    // $ANTLR start "rule__Create__NameAssignment_1"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:823:1: rule__Create__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Create__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:827:1: ( ( RULE_ID ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:828:1: ( RULE_ID )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:828:1: ( RULE_ID )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:829:1: RULE_ID
            {
             before(grammarAccess.getCreateAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Create__NameAssignment_11677); 
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
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:838:1: rule__Create__LitAssignment_2_0 : ( ruleLiteral ) ;
    public final void rule__Create__LitAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:842:1: ( ( ruleLiteral ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:843:1: ( ruleLiteral )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:843:1: ( ruleLiteral )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:844:1: ruleLiteral
            {
             before(grammarAccess.getCreateAccess().getLitLiteralParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_ruleLiteral_in_rule__Create__LitAssignment_2_01708);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getCreateAccess().getLitLiteralParserRuleCall_2_0_0()); 

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


    // $ANTLR start "rule__Keywords__NameAssignment"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:853:1: rule__Keywords__NameAssignment : ( ( rule__Keywords__NameAlternatives_0 ) ) ;
    public final void rule__Keywords__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:857:1: ( ( ( rule__Keywords__NameAlternatives_0 ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:858:1: ( ( rule__Keywords__NameAlternatives_0 ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:858:1: ( ( rule__Keywords__NameAlternatives_0 ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:859:1: ( rule__Keywords__NameAlternatives_0 )
            {
             before(grammarAccess.getKeywordsAccess().getNameAlternatives_0()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:860:1: ( rule__Keywords__NameAlternatives_0 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:860:2: rule__Keywords__NameAlternatives_0
            {
            pushFollow(FOLLOW_rule__Keywords__NameAlternatives_0_in_rule__Keywords__NameAssignment1739);
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


    // $ANTLR start "rule__Instruction__NameAssignment_2"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:869:1: rule__Instruction__NameAssignment_2 : ( ruleLiteral ) ;
    public final void rule__Instruction__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:873:1: ( ( ruleLiteral ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:874:1: ( ruleLiteral )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:874:1: ( ruleLiteral )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:875:1: ruleLiteral
            {
             before(grammarAccess.getInstructionAccess().getNameLiteralParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleLiteral_in_rule__Instruction__NameAssignment_21772);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getInstructionAccess().getNameLiteralParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__Instruction__NameAssignment_2"


    // $ANTLR start "rule__Word__NameAssignment"
    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:884:1: rule__Word__NameAssignment : ( ( rule__Word__NameAlternatives_0 ) ) ;
    public final void rule__Word__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:888:1: ( ( ( rule__Word__NameAlternatives_0 ) ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:889:1: ( ( rule__Word__NameAlternatives_0 ) )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:889:1: ( ( rule__Word__NameAlternatives_0 ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:890:1: ( rule__Word__NameAlternatives_0 )
            {
             before(grammarAccess.getWordAccess().getNameAlternatives_0()); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:891:1: ( rule__Word__NameAlternatives_0 )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/internal/InternalUForthParser.g:891:2: rule__Word__NameAlternatives_0
            {
            pushFollow(FOLLOW_rule__Word__NameAlternatives_0_in_rule__Word__NameAssignment1803);
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
    public static final BitSet FOLLOW_rule__Forth__InstructionsAssignment_in_ruleForth91 = new BitSet(new long[]{0x0000000003C17FF2L});
    public static final BitSet FOLLOW_ruleGlobalInstruction_in_entryRuleGlobalInstruction119 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGlobalInstruction126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GlobalInstruction__Alternatives_in_ruleGlobalInstruction156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_entryRuleFunction183 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunction190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__0_in_ruleFunction220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreate_in_entryRuleCreate247 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCreate254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Create__Group__0_in_ruleCreate284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywords_in_entryRuleKeywords311 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeywords318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keywords__NameAssignment_in_ruleKeywords348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_entryRuleInstruction375 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstruction382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Alternatives_in_ruleInstruction412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral439 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__Alternatives_in_ruleLiteral476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWord_in_entryRuleWord503 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWord510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Word__NameAssignment_in_ruleWord540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCreate_in_rule__GlobalInstruction__Alternatives576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_rule__GlobalInstruction__Alternatives593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_rule__GlobalInstruction__Alternatives610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SWAP_in_rule__Keywords__NameAlternatives_0643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OVER_in_rule__Keywords__NameAlternatives_0663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NIP_in_rule__Keywords__NameAlternatives_0683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNDER_in_rule__Keywords__NameAlternatives_0703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUCK_in_rule__Keywords__NameAlternatives_0723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROT_in_rule__Keywords__NameAlternatives_0743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROT_1_in_rule__Keywords__NameAlternatives_0763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEGATE_in_rule__Keywords__NameAlternatives_0783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DUP_in_rule__Keywords__NameAlternatives_0803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CALL_in_rule__Keywords__NameAlternatives_0823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywords_in_rule__Instruction__Alternatives857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWord_in_rule__Instruction__Alternatives874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__NameAssignment_2_in_rule__Instruction__Alternatives891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Literal__Alternatives924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOUBLE_in_rule__Literal__Alternatives941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Word__NameAlternatives_0973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OPERATOR_in_rule__Word__NameAlternatives_0990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__0__Impl_in_rule__Function__Group__01020 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__Function__Group__1_in_rule__Function__Group__01023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Colon_in_rule__Function__Group__0__Impl1051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__1__Impl_in_rule__Function__Group__11082 = new BitSet(new long[]{0x0000000003C37FF0L});
    public static final BitSet FOLLOW_rule__Function__Group__2_in_rule__Function__Group__11085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__NameAssignment_1_in_rule__Function__Group__1__Impl1112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__2__Impl_in_rule__Function__Group__21142 = new BitSet(new long[]{0x0000000003C37FF0L});
    public static final BitSet FOLLOW_rule__Function__Group__3_in_rule__Function__Group__21145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__WordsAssignment_2_in_rule__Function__Group__2__Impl1172 = new BitSet(new long[]{0x0000000003C17FF2L});
    public static final BitSet FOLLOW_rule__Function__Group__3__Impl_in_rule__Function__Group__31203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Semicolon_in_rule__Function__Group__3__Impl1231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Create__Group__0__Impl_in_rule__Create__Group__01270 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__Create__Group__1_in_rule__Create__Group__01273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Create_in_rule__Create__Group__0__Impl1301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Create__Group__1__Impl_in_rule__Create__Group__11332 = new BitSet(new long[]{0x0000000003C17FF0L});
    public static final BitSet FOLLOW_rule__Create__Group__2_in_rule__Create__Group__11335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Create__NameAssignment_1_in_rule__Create__Group__1__Impl1362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Create__Group__2__Impl_in_rule__Create__Group__21392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Create__Group_2__0_in_rule__Create__Group__2__Impl1419 = new BitSet(new long[]{0x0000000003C17FF2L});
    public static final BitSet FOLLOW_rule__Create__Group_2__0__Impl_in_rule__Create__Group_2__01456 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Create__Group_2__1_in_rule__Create__Group_2__01459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Create__LitAssignment_2_0_in_rule__Create__Group_2__0__Impl1486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Create__Group_2__1__Impl_in_rule__Create__Group_2__11516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Comma_in_rule__Create__Group_2__1__Impl1544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGlobalInstruction_in_rule__Forth__InstructionsAssignment1584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Function__NameAssignment_11615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_rule__Function__WordsAssignment_21646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Create__NameAssignment_11677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rule__Create__LitAssignment_2_01708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Keywords__NameAlternatives_0_in_rule__Keywords__NameAssignment1739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rule__Instruction__NameAssignment_21772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Word__NameAlternatives_0_in_rule__Word__NameAssignment1803 = new BitSet(new long[]{0x0000000000000002L});

}