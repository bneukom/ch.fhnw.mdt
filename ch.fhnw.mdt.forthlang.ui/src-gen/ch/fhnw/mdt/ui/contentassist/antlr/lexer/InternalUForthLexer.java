package ch.fhnw.mdt.ui.contentassist.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUForthLexer extends Lexer {
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

    public InternalUForthLexer() {;} 
    public InternalUForthLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalUForthLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g"; }

    // $ANTLR start "NEGATE"
    public final void mNEGATE() throws RecognitionException {
        try {
            int _type = NEGATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:19:8: ( ( 'N' | 'n' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:19:10: ( 'N' | 'n' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NEGATE"

    // $ANTLR start "Create"
    public final void mCreate() throws RecognitionException {
        try {
            int _type = Create;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:21:8: ( ( 'C' | 'c' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:21:10: ( 'C' | 'c' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Create"

    // $ANTLR start "UNDER"
    public final void mUNDER() throws RecognitionException {
        try {
            int _type = UNDER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:23:7: ( ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:23:9: ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UNDER"

    // $ANTLR start "ROT_1"
    public final void mROT_1() throws RecognitionException {
        try {
            int _type = ROT_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:25:7: ( '-' ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'T' | 't' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:25:9: '-' ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'T' | 't' )
            {
            match('-'); 
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ROT_1"

    // $ANTLR start "CALL"
    public final void mCALL() throws RecognitionException {
        try {
            int _type = CALL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:27:6: ( ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'L' | 'l' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:27:8: ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'L' | 'l' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CALL"

    // $ANTLR start "OVER"
    public final void mOVER() throws RecognitionException {
        try {
            int _type = OVER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:29:6: ( ( 'O' | 'o' ) ( 'V' | 'v' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:29:8: ( 'O' | 'o' ) ( 'V' | 'v' ) ( 'E' | 'e' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OVER"

    // $ANTLR start "SWAP"
    public final void mSWAP() throws RecognitionException {
        try {
            int _type = SWAP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:31:6: ( ( 'S' | 's' ) ( 'W' | 'w' ) ( 'A' | 'a' ) ( 'P' | 'p' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:31:8: ( 'S' | 's' ) ( 'W' | 'w' ) ( 'A' | 'a' ) ( 'P' | 'p' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SWAP"

    // $ANTLR start "TUCK"
    public final void mTUCK() throws RecognitionException {
        try {
            int _type = TUCK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:33:6: ( ( 'T' | 't' ) ( 'U' | 'u' ) ( 'C' | 'c' ) ( 'K' | 'k' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:33:8: ( 'T' | 't' ) ( 'U' | 'u' ) ( 'C' | 'c' ) ( 'K' | 'k' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TUCK"

    // $ANTLR start "DUP"
    public final void mDUP() throws RecognitionException {
        try {
            int _type = DUP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:35:5: ( ( 'D' | 'd' ) ( 'U' | 'u' ) ( 'P' | 'p' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:35:7: ( 'D' | 'd' ) ( 'U' | 'u' ) ( 'P' | 'p' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DUP"

    // $ANTLR start "NIP"
    public final void mNIP() throws RecognitionException {
        try {
            int _type = NIP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:37:5: ( ( 'N' | 'n' ) ( 'I' | 'i' ) ( 'P' | 'p' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:37:7: ( 'N' | 'n' ) ( 'I' | 'i' ) ( 'P' | 'p' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NIP"

    // $ANTLR start "ROT"
    public final void mROT() throws RecognitionException {
        try {
            int _type = ROT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:39:5: ( ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'T' | 't' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:39:7: ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ROT"

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:41:7: ( ',' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:41:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Comma"

    // $ANTLR start "Colon"
    public final void mColon() throws RecognitionException {
        try {
            int _type = Colon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:43:7: ( ':' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:43:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Colon"

    // $ANTLR start "Semicolon"
    public final void mSemicolon() throws RecognitionException {
        try {
            int _type = Semicolon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:45:11: ( ';' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:45:13: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Semicolon"

    // $ANTLR start "RULE_DIGIT"
    public final void mRULE_DIGIT() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:49:21: ( '0' .. '9' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:49:23: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_DIGIT"

    // $ANTLR start "RULE_DECINT"
    public final void mRULE_DECINT() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:51:22: ( ( RULE_DIGIT )+ )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:51:24: ( RULE_DIGIT )+
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:51:24: ( RULE_DIGIT )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:51:24: RULE_DIGIT
            	    {
            	    mRULE_DIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_DECINT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:53:17: ( '(' (~ ( ( '\\n' | '\\r' ) ) )* ')' ( RULE_WS )* )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:53:19: '(' (~ ( ( '\\n' | '\\r' ) ) )* ')' ( RULE_WS )*
            {
            match('('); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:53:23: (~ ( ( '\\n' | '\\r' ) ) )*
            loop2:
            do {
                int alt2=2;
                alt2 = dfa2.predict(input);
                switch (alt2) {
            	case 1 :
            	    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:53:23: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match(')'); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:53:43: ( RULE_WS )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\t' && LA3_0<='\n')||LA3_0=='\r'||LA3_0==' ') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:53:43: RULE_WS
            	    {
            	    mRULE_WS(); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:55:10: ( ( '-' )? ( '0' .. '9' | 'A' .. 'F' )+ )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:55:12: ( '-' )? ( '0' .. '9' | 'A' .. 'F' )+
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:55:12: ( '-' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='-') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:55:12: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:55:17: ( '0' .. '9' | 'A' .. 'F' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')||(LA5_0>='A' && LA5_0<='F')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_DOUBLE"
    public final void mRULE_DOUBLE() throws RecognitionException {
        try {
            int _type = RULE_DOUBLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:57:13: ( RULE_DECINT ( '.' ( RULE_DIGIT )* | ( '.' ( RULE_DIGIT )* )? ( 'E' | 'e' ) ( '-' | '+' )? RULE_DECINT ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:57:15: RULE_DECINT ( '.' ( RULE_DIGIT )* | ( '.' ( RULE_DIGIT )* )? ( 'E' | 'e' ) ( '-' | '+' )? RULE_DECINT )
            {
            mRULE_DECINT(); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:57:27: ( '.' ( RULE_DIGIT )* | ( '.' ( RULE_DIGIT )* )? ( 'E' | 'e' ) ( '-' | '+' )? RULE_DECINT )
            int alt10=2;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:57:28: '.' ( RULE_DIGIT )*
                    {
                    match('.'); 
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:57:32: ( RULE_DIGIT )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:57:32: RULE_DIGIT
                    	    {
                    	    mRULE_DIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:57:44: ( '.' ( RULE_DIGIT )* )? ( 'E' | 'e' ) ( '-' | '+' )? RULE_DECINT
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:57:44: ( '.' ( RULE_DIGIT )* )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='.') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:57:45: '.' ( RULE_DIGIT )*
                            {
                            match('.'); 
                            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:57:49: ( RULE_DIGIT )*
                            loop7:
                            do {
                                int alt7=2;
                                int LA7_0 = input.LA(1);

                                if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                                    alt7=1;
                                }


                                switch (alt7) {
                            	case 1 :
                            	    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:57:49: RULE_DIGIT
                            	    {
                            	    mRULE_DIGIT(); 

                            	    }
                            	    break;

                            	default :
                            	    break loop7;
                                }
                            } while (true);


                            }
                            break;

                    }

                    if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:57:73: ( '-' | '+' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='+'||LA9_0=='-') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:
                            {
                            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}


                            }
                            break;

                    }

                    mRULE_DECINT(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DOUBLE"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:59:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '!' | '@' | '?' | ',' | '<' | '>' | '=' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '!' | '?' | '@' | '<' | '>' | '0' .. '9' | ',' | '=' )* )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:59:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '!' | '@' | '?' | ',' | '<' | '>' | '=' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '!' | '?' | '@' | '<' | '>' | '0' .. '9' | ',' | '=' )*
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:59:11: ( '^' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='^') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:59:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( input.LA(1)=='!'||input.LA(1)==','||(input.LA(1)>='<' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:59:68: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '!' | '?' | '@' | '<' | '>' | '0' .. '9' | ',' | '=' )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0=='!'||LA12_0==','||(LA12_0>='0' && LA12_0<='9')||(LA12_0>='<' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='a' && LA12_0<='z')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:
            	    {
            	    if ( input.LA(1)=='!'||input.LA(1)==','||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='<' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_OPERATOR"
    public final void mRULE_OPERATOR() throws RecognitionException {
        try {
            int _type = RULE_OPERATOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:61:15: ( ( '+' | '-' | '*' | '/' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:61:17: ( '+' | '-' | '*' | '/' )
            {
            if ( (input.LA(1)>='*' && input.LA(1)<='+')||input.LA(1)=='-'||input.LA(1)=='/' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_OPERATOR"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:63:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:63:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:63:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='\"') ) {
                alt15=1;
            }
            else if ( (LA15_0=='\'') ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:63:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:63:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop13:
                    do {
                        int alt13=3;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0=='\\') ) {
                            alt13=1;
                        }
                        else if ( ((LA13_0>='\u0000' && LA13_0<='!')||(LA13_0>='#' && LA13_0<='[')||(LA13_0>=']' && LA13_0<='\uFFFF')) ) {
                            alt13=2;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:63:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:63:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:63:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:63:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop14:
                    do {
                        int alt14=3;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0=='\\') ) {
                            alt14=1;
                        }
                        else if ( ((LA14_0>='\u0000' && LA14_0<='&')||(LA14_0>='(' && LA14_0<='[')||(LA14_0>=']' && LA14_0<='\uFFFF')) ) {
                            alt14=2;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:63:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:63:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:65:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:65:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:65:24: ( options {greedy=false; } : . )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0=='*') ) {
                    int LA16_1 = input.LA(2);

                    if ( (LA16_1=='/') ) {
                        alt16=2;
                    }
                    else if ( ((LA16_1>='\u0000' && LA16_1<='.')||(LA16_1>='0' && LA16_1<='\uFFFF')) ) {
                        alt16=1;
                    }


                }
                else if ( ((LA16_0>='\u0000' && LA16_0<=')')||(LA16_0>='+' && LA16_0<='\uFFFF')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:65:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:67:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:67:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:67:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>='\t' && LA17_0<='\n')||LA17_0=='\r'||LA17_0==' ') ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:69:16: ( . )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:69:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:8: ( NEGATE | Create | UNDER | ROT_1 | CALL | OVER | SWAP | TUCK | DUP | NIP | ROT | Comma | Colon | Semicolon | RULE_SL_COMMENT | RULE_INT | RULE_DOUBLE | RULE_ID | RULE_OPERATOR | RULE_STRING | RULE_ML_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt18=23;
        alt18 = dfa18.predict(input);
        switch (alt18) {
            case 1 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:10: NEGATE
                {
                mNEGATE(); 

                }
                break;
            case 2 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:17: Create
                {
                mCreate(); 

                }
                break;
            case 3 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:24: UNDER
                {
                mUNDER(); 

                }
                break;
            case 4 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:30: ROT_1
                {
                mROT_1(); 

                }
                break;
            case 5 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:36: CALL
                {
                mCALL(); 

                }
                break;
            case 6 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:41: OVER
                {
                mOVER(); 

                }
                break;
            case 7 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:46: SWAP
                {
                mSWAP(); 

                }
                break;
            case 8 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:51: TUCK
                {
                mTUCK(); 

                }
                break;
            case 9 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:56: DUP
                {
                mDUP(); 

                }
                break;
            case 10 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:60: NIP
                {
                mNIP(); 

                }
                break;
            case 11 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:64: ROT
                {
                mROT(); 

                }
                break;
            case 12 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:68: Comma
                {
                mComma(); 

                }
                break;
            case 13 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:74: Colon
                {
                mColon(); 

                }
                break;
            case 14 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:80: Semicolon
                {
                mSemicolon(); 

                }
                break;
            case 15 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:90: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 16 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:106: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 17 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:115: RULE_DOUBLE
                {
                mRULE_DOUBLE(); 

                }
                break;
            case 18 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:127: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 19 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:135: RULE_OPERATOR
                {
                mRULE_OPERATOR(); 

                }
                break;
            case 20 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:149: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 21 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:161: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 22 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:177: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 23 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:185: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA10 dfa10 = new DFA10(this);
    protected DFA18 dfa18 = new DFA18(this);
    static final String DFA2_eotS =
        "\1\uffff\1\4\1\uffff\1\4\1\uffff";
    static final String DFA2_eofS =
        "\5\uffff";
    static final String DFA2_minS =
        "\2\0\1\uffff\1\0\1\uffff";
    static final String DFA2_maxS =
        "\2\uffff\1\uffff\1\uffff\1\uffff";
    static final String DFA2_acceptS =
        "\2\uffff\1\1\1\uffff\1\2";
    static final String DFA2_specialS =
        "\1\2\1\1\1\uffff\1\0\1\uffff}>";
    static final String[] DFA2_transitionS = {
            "\12\2\1\uffff\2\2\1\uffff\33\2\1\1\uffd6\2",
            "\11\2\1\3\1\uffff\2\2\1\uffff\22\2\1\3\uffdf\2",
            "",
            "\11\2\1\3\1\uffff\2\2\1\uffff\22\2\1\3\uffdf\2",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "()* loopback of 53:23: (~ ( ( '\\n' | '\\r' ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA2_3 = input.LA(1);

                        s = -1;
                        if ( ((LA2_3>='\u0000' && LA2_3<='\b')||(LA2_3>='\u000B' && LA2_3<='\f')||(LA2_3>='\u000E' && LA2_3<='\u001F')||(LA2_3>='!' && LA2_3<='\uFFFF')) ) {s = 2;}

                        else if ( (LA2_3=='\t'||LA2_3==' ') ) {s = 3;}

                        else s = 4;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA2_1 = input.LA(1);

                        s = -1;
                        if ( ((LA2_1>='\u0000' && LA2_1<='\b')||(LA2_1>='\u000B' && LA2_1<='\f')||(LA2_1>='\u000E' && LA2_1<='\u001F')||(LA2_1>='!' && LA2_1<='\uFFFF')) ) {s = 2;}

                        else if ( (LA2_1=='\t'||LA2_1==' ') ) {s = 3;}

                        else s = 4;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA2_0 = input.LA(1);

                        s = -1;
                        if ( (LA2_0==')') ) {s = 1;}

                        else if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\f')||(LA2_0>='\u000E' && LA2_0<='(')||(LA2_0>='*' && LA2_0<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 2, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA10_eotS =
        "\1\uffff\1\4\1\uffff\1\4\1\uffff";
    static final String DFA10_eofS =
        "\5\uffff";
    static final String DFA10_minS =
        "\1\56\1\60\1\uffff\1\60\1\uffff";
    static final String DFA10_maxS =
        "\2\145\1\uffff\1\145\1\uffff";
    static final String DFA10_acceptS =
        "\2\uffff\1\2\1\uffff\1\1";
    static final String DFA10_specialS =
        "\5\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\1\26\uffff\1\2\37\uffff\1\2",
            "\12\3\13\uffff\1\2\37\uffff\1\2",
            "",
            "\12\3\13\uffff\1\2\37\uffff\1\2",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "57:27: ( '.' ( RULE_DIGIT )* | ( '.' ( RULE_DIGIT )* )? ( 'E' | 'e' ) ( '-' | '+' )? RULE_DECINT )";
        }
    }
    static final String DFA18_eotS =
        "\1\uffff\1\34\1\37\1\34\1\44\3\34\1\37\1\34\1\52\2\uffff\1\31\2"+
        "\34\2\37\1\31\1\uffff\1\44\2\31\3\uffff\2\34\1\uffff\1\34\1\37\1"+
        "\uffff\1\34\1\37\1\34\2\uffff\5\34\4\uffff\1\37\1\uffff\1\37\3\uffff"+
        "\1\34\1\100\6\34\1\107\1\110\1\37\1\34\1\uffff\1\34\1\113\1\34\1"+
        "\115\1\116\1\117\2\uffff\2\34\1\uffff\1\122\3\uffff\1\123\1\124"+
        "\3\uffff";
    static final String DFA18_eofS =
        "\125\uffff";
    static final String DFA18_minS =
        "\1\0\1\105\1\41\1\116\1\60\1\126\1\127\1\125\1\41\1\117\1\41\2"+
        "\uffff\1\0\1\101\1\125\1\56\2\41\1\uffff\1\52\2\0\3\uffff\1\107"+
        "\1\120\1\uffff\1\105\1\41\1\uffff\1\114\1\41\1\104\2\uffff\1\105"+
        "\1\101\1\103\1\120\1\124\4\uffff\1\53\1\uffff\1\56\3\uffff\1\101"+
        "\1\41\1\101\1\114\1\105\1\122\1\120\1\113\2\41\1\60\1\124\1\uffff"+
        "\1\124\1\41\1\122\3\41\2\uffff\2\105\1\uffff\1\41\3\uffff\2\41\3"+
        "\uffff";
    static final String DFA18_maxS =
        "\1\uffff\1\151\1\172\1\156\1\162\1\166\1\167\1\165\1\172\1\157"+
        "\1\172\2\uffff\1\uffff\1\162\1\165\1\145\2\172\1\uffff\1\52\2\uffff"+
        "\3\uffff\1\147\1\160\1\uffff\1\145\1\172\1\uffff\1\154\1\172\1\144"+
        "\2\uffff\1\145\1\141\1\143\1\160\1\164\4\uffff\1\71\1\uffff\1\145"+
        "\3\uffff\1\141\1\172\1\141\1\154\1\145\1\162\1\160\1\153\2\172\1"+
        "\71\1\164\1\uffff\1\164\1\172\1\162\3\172\2\uffff\2\145\1\uffff"+
        "\1\172\3\uffff\2\172\3\uffff";
    static final String DFA18_acceptS =
        "\13\uffff\1\15\1\16\6\uffff\1\22\3\uffff\1\23\1\26\1\27\2\uffff"+
        "\1\22\2\uffff\1\20\3\uffff\1\4\1\23\5\uffff\1\14\1\15\1\16\1\17"+
        "\1\uffff\1\21\1\uffff\1\25\1\24\1\26\14\uffff\1\12\6\uffff\1\11"+
        "\1\13\2\uffff\1\5\1\uffff\1\6\1\7\1\10\2\uffff\1\3\1\1\1\2";
    static final String DFA18_specialS =
        "\1\2\14\uffff\1\0\7\uffff\1\3\1\1\76\uffff}>";
    static final String[] DFA18_transitionS = {
            "\11\31\2\30\2\31\1\30\22\31\1\30\1\23\1\25\4\31\1\26\1\15\1"+
            "\31\2\27\1\12\1\4\1\31\1\24\12\20\1\13\1\14\5\23\2\21\1\2\1"+
            "\10\2\21\7\23\1\1\1\5\2\23\1\11\1\6\1\7\1\3\5\23\3\31\1\22\1"+
            "\23\1\31\2\23\1\16\1\17\11\23\1\1\1\5\2\23\1\11\1\6\1\7\1\3"+
            "\5\23\uff85\31",
            "\1\32\3\uffff\1\33\33\uffff\1\32\3\uffff\1\33",
            "\1\34\12\uffff\1\34\3\uffff\12\41\2\uffff\5\34\1\36\5\41\13"+
            "\34\1\35\10\34\4\uffff\1\34\1\uffff\1\40\20\34\1\35\10\34",
            "\1\42\37\uffff\1\42",
            "\12\37\7\uffff\6\37\13\uffff\1\43\37\uffff\1\43",
            "\1\45\37\uffff\1\45",
            "\1\46\37\uffff\1\46",
            "\1\47\37\uffff\1\47",
            "\1\34\12\uffff\1\34\3\uffff\12\41\2\uffff\5\34\6\41\16\34"+
            "\1\50\5\34\4\uffff\1\34\1\uffff\24\34\1\50\5\34",
            "\1\51\37\uffff\1\51",
            "\1\34\12\uffff\1\34\3\uffff\12\34\2\uffff\37\34\4\uffff\1"+
            "\34\1\uffff\32\34",
            "",
            "",
            "\12\55\1\uffff\2\55\1\uffff\ufff2\55",
            "\1\40\20\uffff\1\35\16\uffff\1\40\20\uffff\1\35",
            "\1\50\37\uffff\1\50",
            "\1\57\1\uffff\12\60\13\uffff\1\56\37\uffff\1\57",
            "\1\34\12\uffff\1\34\3\uffff\12\41\2\uffff\5\34\6\41\24\34"+
            "\4\uffff\1\34\1\uffff\32\34",
            "\1\34\12\uffff\1\34\17\uffff\37\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "",
            "\1\61",
            "\0\62",
            "\0\62",
            "",
            "",
            "",
            "\1\64\37\uffff\1\64",
            "\1\65\37\uffff\1\65",
            "",
            "\1\66\37\uffff\1\66",
            "\1\34\12\uffff\1\34\3\uffff\12\41\2\uffff\5\34\6\41\5\34\1"+
            "\67\16\34\4\uffff\1\34\1\uffff\13\34\1\67\16\34",
            "",
            "\1\67\37\uffff\1\67",
            "\1\34\12\uffff\1\34\3\uffff\12\41\2\uffff\5\34\6\41\24\34"+
            "\4\uffff\1\34\1\uffff\32\34",
            "\1\70\37\uffff\1\70",
            "",
            "",
            "\1\71\37\uffff\1\71",
            "\1\72\37\uffff\1\72",
            "\1\73\37\uffff\1\73",
            "\1\74\37\uffff\1\74",
            "\1\75\37\uffff\1\75",
            "",
            "",
            "",
            "",
            "\1\57\1\uffff\1\57\2\uffff\12\76",
            "",
            "\1\57\1\uffff\12\60\13\uffff\1\56\37\uffff\1\57",
            "",
            "",
            "",
            "\1\77\37\uffff\1\77",
            "\1\34\12\uffff\1\34\3\uffff\12\34\2\uffff\37\34\4\uffff\1"+
            "\34\1\uffff\32\34",
            "\1\101\37\uffff\1\101",
            "\1\102\37\uffff\1\102",
            "\1\103\37\uffff\1\103",
            "\1\104\37\uffff\1\104",
            "\1\105\37\uffff\1\105",
            "\1\106\37\uffff\1\106",
            "\1\34\12\uffff\1\34\3\uffff\12\34\2\uffff\37\34\4\uffff\1"+
            "\34\1\uffff\32\34",
            "\1\34\12\uffff\1\34\3\uffff\12\34\2\uffff\37\34\4\uffff\1"+
            "\34\1\uffff\32\34",
            "\12\76",
            "\1\111\37\uffff\1\111",
            "",
            "\1\112\37\uffff\1\112",
            "\1\34\12\uffff\1\34\3\uffff\12\34\2\uffff\37\34\4\uffff\1"+
            "\34\1\uffff\32\34",
            "\1\114\37\uffff\1\114",
            "\1\34\12\uffff\1\34\3\uffff\12\34\2\uffff\37\34\4\uffff\1"+
            "\34\1\uffff\32\34",
            "\1\34\12\uffff\1\34\3\uffff\12\34\2\uffff\37\34\4\uffff\1"+
            "\34\1\uffff\32\34",
            "\1\34\12\uffff\1\34\3\uffff\12\34\2\uffff\37\34\4\uffff\1"+
            "\34\1\uffff\32\34",
            "",
            "",
            "\1\120\37\uffff\1\120",
            "\1\121\37\uffff\1\121",
            "",
            "\1\34\12\uffff\1\34\3\uffff\12\34\2\uffff\37\34\4\uffff\1"+
            "\34\1\uffff\32\34",
            "",
            "",
            "",
            "\1\34\12\uffff\1\34\3\uffff\12\34\2\uffff\37\34\4\uffff\1"+
            "\34\1\uffff\32\34",
            "\1\34\12\uffff\1\34\3\uffff\12\34\2\uffff\37\34\4\uffff\1"+
            "\34\1\uffff\32\34",
            "",
            "",
            ""
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( NEGATE | Create | UNDER | ROT_1 | CALL | OVER | SWAP | TUCK | DUP | NIP | ROT | Comma | Colon | Semicolon | RULE_SL_COMMENT | RULE_INT | RULE_DOUBLE | RULE_ID | RULE_OPERATOR | RULE_STRING | RULE_ML_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA18_13 = input.LA(1);

                        s = -1;
                        if ( ((LA18_13>='\u0000' && LA18_13<='\t')||(LA18_13>='\u000B' && LA18_13<='\f')||(LA18_13>='\u000E' && LA18_13<='\uFFFF')) ) {s = 45;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA18_22 = input.LA(1);

                        s = -1;
                        if ( ((LA18_22>='\u0000' && LA18_22<='\uFFFF')) ) {s = 50;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA18_0 = input.LA(1);

                        s = -1;
                        if ( (LA18_0=='N'||LA18_0=='n') ) {s = 1;}

                        else if ( (LA18_0=='C') ) {s = 2;}

                        else if ( (LA18_0=='U'||LA18_0=='u') ) {s = 3;}

                        else if ( (LA18_0=='-') ) {s = 4;}

                        else if ( (LA18_0=='O'||LA18_0=='o') ) {s = 5;}

                        else if ( (LA18_0=='S'||LA18_0=='s') ) {s = 6;}

                        else if ( (LA18_0=='T'||LA18_0=='t') ) {s = 7;}

                        else if ( (LA18_0=='D') ) {s = 8;}

                        else if ( (LA18_0=='R'||LA18_0=='r') ) {s = 9;}

                        else if ( (LA18_0==',') ) {s = 10;}

                        else if ( (LA18_0==':') ) {s = 11;}

                        else if ( (LA18_0==';') ) {s = 12;}

                        else if ( (LA18_0=='(') ) {s = 13;}

                        else if ( (LA18_0=='c') ) {s = 14;}

                        else if ( (LA18_0=='d') ) {s = 15;}

                        else if ( ((LA18_0>='0' && LA18_0<='9')) ) {s = 16;}

                        else if ( ((LA18_0>='A' && LA18_0<='B')||(LA18_0>='E' && LA18_0<='F')) ) {s = 17;}

                        else if ( (LA18_0=='^') ) {s = 18;}

                        else if ( (LA18_0=='!'||(LA18_0>='<' && LA18_0<='@')||(LA18_0>='G' && LA18_0<='M')||(LA18_0>='P' && LA18_0<='Q')||(LA18_0>='V' && LA18_0<='Z')||LA18_0=='_'||(LA18_0>='a' && LA18_0<='b')||(LA18_0>='e' && LA18_0<='m')||(LA18_0>='p' && LA18_0<='q')||(LA18_0>='v' && LA18_0<='z')) ) {s = 19;}

                        else if ( (LA18_0=='/') ) {s = 20;}

                        else if ( (LA18_0=='\"') ) {s = 21;}

                        else if ( (LA18_0=='\'') ) {s = 22;}

                        else if ( ((LA18_0>='*' && LA18_0<='+')) ) {s = 23;}

                        else if ( ((LA18_0>='\t' && LA18_0<='\n')||LA18_0=='\r'||LA18_0==' ') ) {s = 24;}

                        else if ( ((LA18_0>='\u0000' && LA18_0<='\b')||(LA18_0>='\u000B' && LA18_0<='\f')||(LA18_0>='\u000E' && LA18_0<='\u001F')||(LA18_0>='#' && LA18_0<='&')||LA18_0==')'||LA18_0=='.'||(LA18_0>='[' && LA18_0<=']')||LA18_0=='`'||(LA18_0>='{' && LA18_0<='\uFFFF')) ) {s = 25;}

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA18_21 = input.LA(1);

                        s = -1;
                        if ( ((LA18_21>='\u0000' && LA18_21<='\uFFFF')) ) {s = 50;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 18, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}