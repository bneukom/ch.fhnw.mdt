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

    public InternalUForthLexer() {;} 
    public InternalUForthLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalUForthLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g"; }

    // $ANTLR start "CARRY_RESET"
    public final void mCARRY_RESET() throws RecognitionException {
        try {
            int _type = CARRY_RESET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:19:13: ( ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'R' | 'r' ) ( 'Y' | 'y' ) '_' ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'T' | 't' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:19:15: ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'R' | 'r' ) ( 'Y' | 'y' ) '_' ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'T' | 't' )
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

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
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

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match('_'); 
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

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
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
    // $ANTLR end "CARRY_RESET"

    // $ANTLR start "TorBranch"
    public final void mTorBranch() throws RecognitionException {
        try {
            int _type = TorBranch;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:21:11: ( ( 'T' | 't' ) ( 'O' | 'o' ) ( 'R' | 'r' ) '-' ( 'B' | 'b' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'H' | 'h' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:21:13: ( 'T' | 't' ) ( 'O' | 'o' ) ( 'R' | 'r' ) '-' ( 'B' | 'b' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'H' | 'h' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match('-'); 
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
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

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
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

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
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
    // $ANTLR end "TorBranch"

    // $ANTLR start "Branch_2"
    public final void mBranch_2() throws RecognitionException {
        try {
            int _type = Branch_2;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:23:10: ( '0' '<' '>' ( 'B' | 'b' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'H' | 'h' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:23:12: '0' '<' '>' ( 'B' | 'b' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'H' | 'h' )
            {
            match('0'); 
            match('<'); 
            match('>'); 
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
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

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
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

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
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
    // $ANTLR end "Branch_2"

    // $ANTLR start "CARRYSET"
    public final void mCARRYSET() throws RecognitionException {
        try {
            int _type = CARRYSET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:25:10: ( ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'R' | 'r' ) ( 'Y' | 'y' ) '-' ( 'S' | 's' ) ( 'E' | 'e' ) ( 'T' | 't' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:25:12: ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'R' | 'r' ) ( 'Y' | 'y' ) '-' ( 'S' | 's' ) ( 'E' | 'e' ) ( 'T' | 't' )
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

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
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

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match('-'); 
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
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
    // $ANTLR end "CARRYSET"

    // $ANTLR start "NcBranch"
    public final void mNcBranch() throws RecognitionException {
        try {
            int _type = NcBranch;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:27:10: ( ( 'N' | 'n' ) ( 'C' | 'c' ) '-' ( 'B' | 'b' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'H' | 'h' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:27:12: ( 'N' | 'n' ) ( 'C' | 'c' ) '-' ( 'B' | 'b' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'H' | 'h' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
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

            match('-'); 
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
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

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
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

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
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
    // $ANTLR end "NcBranch"

    // $ANTLR start "NoBranch"
    public final void mNoBranch() throws RecognitionException {
        try {
            int _type = NoBranch;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:29:10: ( ( 'N' | 'n' ) ( 'O' | 'o' ) '-' ( 'B' | 'b' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'H' | 'h' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:29:12: ( 'N' | 'n' ) ( 'O' | 'o' ) '-' ( 'B' | 'b' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'H' | 'h' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
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

            match('-'); 
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
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

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
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

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
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
    // $ANTLR end "NoBranch"

    // $ANTLR start "NsBranch"
    public final void mNsBranch() throws RecognitionException {
        try {
            int _type = NsBranch;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:31:10: ( ( 'N' | 'n' ) ( 'S' | 's' ) '-' ( 'B' | 'b' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'H' | 'h' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:31:12: ( 'N' | 'n' ) ( 'S' | 's' ) '-' ( 'B' | 'b' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'H' | 'h' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match('-'); 
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
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

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
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

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
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
    // $ANTLR end "NsBranch"

    // $ANTLR start "Branch"
    public final void mBranch() throws RecognitionException {
        try {
            int _type = Branch;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:33:8: ( '0' '=' ( 'B' | 'b' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'H' | 'h' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:33:10: '0' '=' ( 'B' | 'b' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'H' | 'h' )
            {
            match('0'); 
            match('='); 
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
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

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
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

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
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
    // $ANTLR end "Branch"

    // $ANTLR start "Branch_1"
    public final void mBranch_1() throws RecognitionException {
        try {
            int _type = Branch_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:35:10: ( '?' '-' ( 'B' | 'b' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'H' | 'h' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:35:12: '?' '-' ( 'B' | 'b' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'H' | 'h' )
            {
            match('?'); 
            match('-'); 
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
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

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
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

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
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
    // $ANTLR end "Branch_1"

    // $ANTLR start "SBranch"
    public final void mSBranch() throws RecognitionException {
        try {
            int _type = SBranch;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:37:9: ( ( 'S' | 's' ) '-' ( 'B' | 'b' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'H' | 'h' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:37:11: ( 'S' | 's' ) '-' ( 'B' | 'b' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'H' | 'h' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match('-'); 
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
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

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
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

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
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
    // $ANTLR end "SBranch"

    // $ANTLR start "DNEGATE"
    public final void mDNEGATE() throws RecognitionException {
        try {
            int _type = DNEGATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:39:9: ( ( 'D' | 'd' ) ( 'N' | 'n' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:39:11: ( 'D' | 'd' ) ( 'N' | 'n' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
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
    // $ANTLR end "DNEGATE"

    // $ANTLR start "NzExit"
    public final void mNzExit() throws RecognitionException {
        try {
            int _type = NzExit;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:41:8: ( ( 'N' | 'n' ) ( 'Z' | 'z' ) '-' ( 'E' | 'e' ) ( 'X' | 'x' ) ( 'I' | 'i' ) ( 'T' | 't' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:41:10: ( 'N' | 'n' ) ( 'Z' | 'z' ) '-' ( 'E' | 'e' ) ( 'X' | 'x' ) ( 'I' | 'i' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Z'||input.LA(1)=='z' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match('-'); 
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
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
    // $ANTLR end "NzExit"

    // $ANTLR start "ASHIFT"
    public final void mASHIFT() throws RecognitionException {
        try {
            int _type = ASHIFT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:43:8: ( ( 'A' | 'a' ) ( 'S' | 's' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'F' | 'f' ) ( 'T' | 't' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:43:10: ( 'A' | 'a' ) ( 'S' | 's' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'F' | 'f' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
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

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
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
    // $ANTLR end "ASHIFT"

    // $ANTLR start "EXTEND"
    public final void mEXTEND() throws RecognitionException {
        try {
            int _type = EXTEND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:45:8: ( ( 'E' | 'e' ) ( 'X' | 'x' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'D' | 'd' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:45:10: ( 'E' | 'e' ) ( 'X' | 'x' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'D' | 'd' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXTEND"

    // $ANTLR start "NEGATE"
    public final void mNEGATE() throws RecognitionException {
        try {
            int _type = NEGATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:47:8: ( ( 'N' | 'n' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:47:10: ( 'N' | 'n' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' )
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

    // $ANTLR start "RCLEAR"
    public final void mRCLEAR() throws RecognitionException {
        try {
            int _type = RCLEAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:49:8: ( ( 'R' | 'r' ) ( 'C' | 'c' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'R' | 'r' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:49:10: ( 'R' | 'r' ) ( 'C' | 'c' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
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

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
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
    // $ANTLR end "RCLEAR"

    // $ANTLR start "UNPACK"
    public final void mUNPACK() throws RecognitionException {
        try {
            int _type = UNPACK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:51:8: ( ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'K' | 'k' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:51:10: ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'K' | 'k' )
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

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
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
    // $ANTLR end "UNPACK"

    // $ANTLR start "Create"
    public final void mCreate() throws RecognitionException {
        try {
            int _type = Create;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:53:8: ( ( 'C' | 'c' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:53:10: ( 'C' | 'c' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' )
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

    // $ANTLR start "ZExit"
    public final void mZExit() throws RecognitionException {
        try {
            int _type = ZExit;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:55:7: ( ( 'Z' | 'z' ) '-' ( 'E' | 'e' ) ( 'X' | 'x' ) ( 'I' | 'i' ) ( 'T' | 't' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:55:9: ( 'Z' | 'z' ) '-' ( 'E' | 'e' ) ( 'X' | 'x' ) ( 'I' | 'i' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='Z'||input.LA(1)=='z' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match('-'); 
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
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
    // $ANTLR end "ZExit"

    // $ANTLR start "DROP_1"
    public final void mDROP_1() throws RecognitionException {
        try {
            int _type = DROP_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:57:8: ( '2' ( 'D' | 'd' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'P' | 'p' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:57:10: '2' ( 'D' | 'd' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'P' | 'p' )
            {
            match('2'); 
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
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

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
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
    // $ANTLR end "DROP_1"

    // $ANTLR start "OVER_1"
    public final void mOVER_1() throws RecognitionException {
        try {
            int _type = OVER_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:59:8: ( '2' ( 'O' | 'o' ) ( 'V' | 'v' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:59:10: '2' ( 'O' | 'o' ) ( 'V' | 'v' ) ( 'E' | 'e' ) ( 'R' | 'r' )
            {
            match('2'); 
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
    // $ANTLR end "OVER_1"

    // $ANTLR start "SWAP_1"
    public final void mSWAP_1() throws RecognitionException {
        try {
            int _type = SWAP_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:61:8: ( '2' ( 'S' | 's' ) ( 'W' | 'w' ) ( 'A' | 'a' ) ( 'P' | 'p' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:61:10: '2' ( 'S' | 's' ) ( 'W' | 'w' ) ( 'A' | 'a' ) ( 'P' | 'p' )
            {
            match('2'); 
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
    // $ANTLR end "SWAP_1"

    // $ANTLR start "CELL"
    public final void mCELL() throws RecognitionException {
        try {
            int _type = CELL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:63:6: ( ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'L' | 'l' ) '+' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:63:8: ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'L' | 'l' ) '+'
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
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

            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CELL"

    // $ANTLR start "CELL_1"
    public final void mCELL_1() throws RecognitionException {
        try {
            int _type = CELL_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:65:8: ( ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'L' | 'l' ) '-' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:65:10: ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'L' | 'l' ) '-'
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
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

            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CELL_1"

    // $ANTLR start "CLEAR"
    public final void mCLEAR() throws RecognitionException {
        try {
            int _type = CLEAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:67:7: ( ( 'C' | 'c' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'R' | 'r' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:67:9: ( 'C' | 'c' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
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
    // $ANTLR end "CLEAR"

    // $ANTLR start "COUNT"
    public final void mCOUNT() throws RecognitionException {
        try {
            int _type = COUNT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:69:7: ( ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'T' | 't' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:69:9: ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
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
    // $ANTLR end "COUNT"

    // $ANTLR start "ERASE"
    public final void mERASE() throws RecognitionException {
        try {
            int _type = ERASE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:71:7: ( ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'E' | 'e' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:71:9: ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'E' | 'e' )
            {
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

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
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
    // $ANTLR end "ERASE"

    // $ANTLR start "FALSE"
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:73:7: ( ( 'F' | 'f' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'S' | 's' ) ( 'E' | 'e' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:73:9: ( 'F' | 'f' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'S' | 's' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
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

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
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
    // $ANTLR end "FALSE"

    // $ANTLR start "PLACE"
    public final void mPLACE() throws RecognitionException {
        try {
            int _type = PLACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:75:7: ( ( 'P' | 'p' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'E' | 'e' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:75:9: ( 'P' | 'p' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
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

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
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
    // $ANTLR end "PLACE"

    // $ANTLR start "RDROP"
    public final void mRDROP() throws RecognitionException {
        try {
            int _type = RDROP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:77:7: ( ( 'R' | 'r' ) ( 'D' | 'd' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'P' | 'p' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:77:9: ( 'R' | 'r' ) ( 'D' | 'd' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'P' | 'p' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
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
    // $ANTLR end "RDROP"

    // $ANTLR start "SHIFT"
    public final void mSHIFT() throws RecognitionException {
        try {
            int _type = SHIFT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:79:7: ( ( 'S' | 's' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'F' | 'f' ) ( 'T' | 't' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:79:9: ( 'S' | 's' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'F' | 'f' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
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

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
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
    // $ANTLR end "SHIFT"

    // $ANTLR start "UNDER"
    public final void mUNDER() throws RecognitionException {
        try {
            int _type = UNDER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:81:7: ( ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:81:9: ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'R' | 'r' )
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
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:83:7: ( '-' ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'T' | 't' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:83:9: '-' ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'T' | 't' )
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

    // $ANTLR start "DUP_1"
    public final void mDUP_1() throws RecognitionException {
        try {
            int _type = DUP_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:85:7: ( '2' ( 'D' | 'd' ) ( 'U' | 'u' ) ( 'P' | 'p' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:85:9: '2' ( 'D' | 'd' ) ( 'U' | 'u' ) ( 'P' | 'p' )
            {
            match('2'); 
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
    // $ANTLR end "DUP_1"

    // $ANTLR start "DUP_2"
    public final void mDUP_2() throws RecognitionException {
        try {
            int _type = DUP_2;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:87:7: ( '?' ( 'D' | 'd' ) ( 'U' | 'u' ) ( 'P' | 'p' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:87:9: '?' ( 'D' | 'd' ) ( 'U' | 'u' ) ( 'P' | 'p' )
            {
            match('?'); 
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
    // $ANTLR end "DUP_2"

    // $ANTLR start "DABS"
    public final void mDABS() throws RecognitionException {
        try {
            int _type = DABS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:89:6: ( ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'B' | 'b' ) ( 'S' | 's' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:89:8: ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'B' | 'b' ) ( 'S' | 's' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
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

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
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
    // $ANTLR end "DABS"

    // $ANTLR start "DROL"
    public final void mDROL() throws RecognitionException {
        try {
            int _type = DROL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:91:6: ( ( 'D' | 'd' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'L' | 'l' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:91:8: ( 'D' | 'd' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'L' | 'l' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
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

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
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
    // $ANTLR end "DROL"

    // $ANTLR start "DROP"
    public final void mDROP() throws RecognitionException {
        try {
            int _type = DROP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:93:6: ( ( 'D' | 'd' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'P' | 'p' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:93:8: ( 'D' | 'd' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'P' | 'p' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
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

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
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
    // $ANTLR end "DROP"

    // $ANTLR start "DROR"
    public final void mDROR() throws RecognitionException {
        try {
            int _type = DROR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:95:6: ( ( 'D' | 'd' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'R' | 'r' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:95:8: ( 'D' | 'd' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
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

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
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
    // $ANTLR end "DROR"

    // $ANTLR start "FILL"
    public final void mFILL() throws RecognitionException {
        try {
            int _type = FILL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:97:6: ( ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'L' | 'l' ) ( 'L' | 'l' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:97:8: ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'L' | 'l' ) ( 'L' | 'l' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
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
    // $ANTLR end "FILL"

    // $ANTLR start "MOVE"
    public final void mMOVE() throws RecognitionException {
        try {
            int _type = MOVE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:99:6: ( ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'V' | 'v' ) ( 'E' | 'e' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:99:8: ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'V' | 'v' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MOVE"

    // $ANTLR start "OVER"
    public final void mOVER() throws RecognitionException {
        try {
            int _type = OVER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:101:6: ( ( 'O' | 'o' ) ( 'V' | 'v' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:101:8: ( 'O' | 'o' ) ( 'V' | 'v' ) ( 'E' | 'e' ) ( 'R' | 'r' )
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

    // $ANTLR start "PACK"
    public final void mPACK() throws RecognitionException {
        try {
            int _type = PACK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:103:6: ( ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'K' | 'k' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:103:8: ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'K' | 'k' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
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
    // $ANTLR end "PACK"

    // $ANTLR start "SWAP"
    public final void mSWAP() throws RecognitionException {
        try {
            int _type = SWAP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:105:6: ( ( 'S' | 's' ) ( 'W' | 'w' ) ( 'A' | 'a' ) ( 'P' | 'p' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:105:8: ( 'S' | 's' ) ( 'W' | 'w' ) ( 'A' | 'a' ) ( 'P' | 'p' )
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

    // $ANTLR start "TRUE"
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:107:6: ( ( 'T' | 't' ) ( 'R' | 'r' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:107:8: ( 'T' | 't' ) ( 'R' | 'r' ) ( 'U' | 'u' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
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
    // $ANTLR end "TRUE"

    // $ANTLR start "TUCK"
    public final void mTUCK() throws RecognitionException {
        try {
            int _type = TUCK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:109:6: ( ( 'T' | 't' ) ( 'U' | 'u' ) ( 'C' | 'c' ) ( 'K' | 'k' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:109:8: ( 'T' | 't' ) ( 'U' | 'u' ) ( 'C' | 'c' ) ( 'K' | 'k' )
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

    // $ANTLR start "ST_1"
    public final void mST_1() throws RecognitionException {
        try {
            int _type = ST_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:111:6: ( '+' ( 'S' | 's' ) ( 'T' | 't' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:111:8: '+' ( 'S' | 's' ) ( 'T' | 't' )
            {
            match('+'); 
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
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
    // $ANTLR end "ST_1"

    // $ANTLR start "DigitZeroLessThanSignGreaterThanSign"
    public final void mDigitZeroLessThanSignGreaterThanSign() throws RecognitionException {
        try {
            int _type = DigitZeroLessThanSignGreaterThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:113:38: ( '0' '<' '>' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:113:40: '0' '<' '>'
            {
            match('0'); 
            match('<'); 
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DigitZeroLessThanSignGreaterThanSign"

    // $ANTLR start "DigitTwoAsteriskAsterisk"
    public final void mDigitTwoAsteriskAsterisk() throws RecognitionException {
        try {
            int _type = DigitTwoAsteriskAsterisk;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:115:26: ( '2' '*' '*' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:115:28: '2' '*' '*'
            {
            match('2'); 
            match('*'); 
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DigitTwoAsteriskAsterisk"

    // $ANTLR start "ABS"
    public final void mABS() throws RecognitionException {
        try {
            int _type = ABS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:117:5: ( ( 'A' | 'a' ) ( 'B' | 'b' ) ( 'S' | 's' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:117:7: ( 'A' | 'a' ) ( 'B' | 'b' ) ( 'S' | 's' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
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
    // $ANTLR end "ABS"

    // $ANTLR start "DEC"
    public final void mDEC() throws RecognitionException {
        try {
            int _type = DEC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:119:5: ( ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'C' | 'c' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:119:7: ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'C' | 'c' )
            {
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

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
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
    // $ANTLR end "DEC"

    // $ANTLR start "DUP"
    public final void mDUP() throws RecognitionException {
        try {
            int _type = DUP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:121:5: ( ( 'D' | 'd' ) ( 'U' | 'u' ) ( 'P' | 'p' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:121:7: ( 'D' | 'd' ) ( 'U' | 'u' ) ( 'P' | 'p' )
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

    // $ANTLR start "INC"
    public final void mINC() throws RecognitionException {
        try {
            int _type = INC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:123:5: ( ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'C' | 'c' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:123:7: ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'C' | 'c' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
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

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
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
    // $ANTLR end "INC"

    // $ANTLR start "LLD"
    public final void mLLD() throws RecognitionException {
        try {
            int _type = LLD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:125:5: ( ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'D' | 'd' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:125:7: ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'D' | 'd' )
            {
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

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
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
    // $ANTLR end "LLD"

    // $ANTLR start "LST"
    public final void mLST() throws RecognitionException {
        try {
            int _type = LST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:127:5: ( ( 'L' | 'l' ) ( 'S' | 's' ) ( 'T' | 't' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:127:7: ( 'L' | 'l' ) ( 'S' | 's' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
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
    // $ANTLR end "LST"

    // $ANTLR start "NIP"
    public final void mNIP() throws RecognitionException {
        try {
            int _type = NIP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:129:5: ( ( 'N' | 'n' ) ( 'I' | 'i' ) ( 'P' | 'p' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:129:7: ( 'N' | 'n' ) ( 'I' | 'i' ) ( 'P' | 'p' )
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

    // $ANTLR start "OFF"
    public final void mOFF() throws RecognitionException {
        try {
            int _type = OFF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:131:5: ( ( 'O' | 'o' ) ( 'F' | 'f' ) ( 'F' | 'f' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:131:7: ( 'O' | 'o' ) ( 'F' | 'f' ) ( 'F' | 'f' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
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
    // $ANTLR end "OFF"

    // $ANTLR start "ROL"
    public final void mROL() throws RecognitionException {
        try {
            int _type = ROL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:133:5: ( ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'L' | 'l' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:133:7: ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'L' | 'l' )
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
    // $ANTLR end "ROL"

    // $ANTLR start "ROR"
    public final void mROR() throws RecognitionException {
        try {
            int _type = ROR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:135:5: ( ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'R' | 'r' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:135:7: ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'R' | 'r' )
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
    // $ANTLR end "ROR"

    // $ANTLR start "ROT"
    public final void mROT() throws RecognitionException {
        try {
            int _type = ROT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:137:5: ( ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'T' | 't' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:137:7: ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'T' | 't' )
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

    // $ANTLR start "TLD"
    public final void mTLD() throws RecognitionException {
        try {
            int _type = TLD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:139:5: ( ( 'T' | 't' ) ( 'L' | 'l' ) ( 'D' | 'd' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:139:7: ( 'T' | 't' ) ( 'L' | 'l' ) ( 'D' | 'd' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
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
    // $ANTLR end "TLD"

    // $ANTLR start "TST"
    public final void mTST() throws RecognitionException {
        try {
            int _type = TST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:141:5: ( ( 'T' | 't' ) ( 'S' | 's' ) ( 'T' | 't' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:141:7: ( 'T' | 't' ) ( 'S' | 's' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
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
    // $ANTLR end "TST"

    // $ANTLR start "D0"
    public final void mD0() throws RecognitionException {
        try {
            int _type = D0;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:143:4: ( ( 'D' | 'd' ) '0' '=' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:143:6: ( 'D' | 'd' ) '0' '='
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match('0'); 
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "D0"

    // $ANTLR start "Jsr"
    public final void mJsr() throws RecognitionException {
        try {
            int _type = Jsr;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:145:5: ( ( 'J' | 'j' ) ( 'S' | 's' ) ( 'R' | 'r' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:145:7: ( 'J' | 'j' ) ( 'S' | 's' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='J'||input.LA(1)=='j' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
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
    // $ANTLR end "Jsr"

    // $ANTLR start "U2"
    public final void mU2() throws RecognitionException {
        try {
            int _type = U2;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:147:4: ( ( 'U' | 'u' ) '2' '/' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:147:6: ( 'U' | 'u' ) '2' '/'
            {
            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match('2'); 
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "U2"

    // $ANTLR start "PlusSignExclamationMark"
    public final void mPlusSignExclamationMark() throws RecognitionException {
        try {
            int _type = PlusSignExclamationMark;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:149:25: ( '+' '!' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:149:27: '+' '!'
            {
            match('+'); 
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PlusSignExclamationMark"

    // $ANTLR start "DigitZeroLessThanSign"
    public final void mDigitZeroLessThanSign() throws RecognitionException {
        try {
            int _type = DigitZeroLessThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:151:23: ( '0' '<' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:151:25: '0' '<'
            {
            match('0'); 
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DigitZeroLessThanSign"

    // $ANTLR start "DigitZeroEqualsSign"
    public final void mDigitZeroEqualsSign() throws RecognitionException {
        try {
            int _type = DigitZeroEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:153:21: ( '0' '=' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:153:23: '0' '='
            {
            match('0'); 
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DigitZeroEqualsSign"

    // $ANTLR start "DigitOnePlusSign"
    public final void mDigitOnePlusSign() throws RecognitionException {
        try {
            int _type = DigitOnePlusSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:155:18: ( '1' '+' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:155:20: '1' '+'
            {
            match('1'); 
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DigitOnePlusSign"

    // $ANTLR start "DigitOneHyphenMinus"
    public final void mDigitOneHyphenMinus() throws RecognitionException {
        try {
            int _type = DigitOneHyphenMinus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:157:21: ( '1' '-' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:157:23: '1' '-'
            {
            match('1'); 
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DigitOneHyphenMinus"

    // $ANTLR start "DigitTwoExclamationMark"
    public final void mDigitTwoExclamationMark() throws RecognitionException {
        try {
            int _type = DigitTwoExclamationMark;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:159:25: ( '2' '!' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:159:27: '2' '!'
            {
            match('2'); 
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DigitTwoExclamationMark"

    // $ANTLR start "DigitTwoAsterisk"
    public final void mDigitTwoAsterisk() throws RecognitionException {
        try {
            int _type = DigitTwoAsterisk;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:161:18: ( '2' '*' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:161:20: '2' '*'
            {
            match('2'); 
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DigitTwoAsterisk"

    // $ANTLR start "DigitTwoSolidus"
    public final void mDigitTwoSolidus() throws RecognitionException {
        try {
            int _type = DigitTwoSolidus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:163:17: ( '2' '/' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:163:19: '2' '/'
            {
            match('2'); 
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DigitTwoSolidus"

    // $ANTLR start "DigitTwoCommercialAt"
    public final void mDigitTwoCommercialAt() throws RecognitionException {
        try {
            int _type = DigitTwoCommercialAt;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:165:22: ( '2' '@' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:165:24: '2' '@'
            {
            match('2'); 
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DigitTwoCommercialAt"

    // $ANTLR start "R"
    public final void mR() throws RecognitionException {
        try {
            int _type = R;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:167:3: ( '>' ( 'R' | 'r' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:167:5: '>' ( 'R' | 'r' )
            {
            match('>'); 
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
    // $ANTLR end "R"

    // $ANTLR start "L"
    public final void mL() throws RecognitionException {
        try {
            int _type = L;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:169:3: ( ( 'L' | 'l' ) '!' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:169:5: ( 'L' | 'l' ) '!'
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "L"

    // $ANTLR start "L_1"
    public final void mL_1() throws RecognitionException {
        try {
            int _type = L_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:171:5: ( ( 'L' | 'l' ) '@' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:171:7: ( 'L' | 'l' ) '@'
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "L_1"

    // $ANTLR start "LD"
    public final void mLD() throws RecognitionException {
        try {
            int _type = LD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:173:4: ( ( 'L' | 'l' ) ( 'D' | 'd' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:173:6: ( 'L' | 'l' ) ( 'D' | 'd' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LD"

    // $ANTLR start "ON"
    public final void mON() throws RecognitionException {
        try {
            int _type = ON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:175:4: ( ( 'O' | 'o' ) ( 'N' | 'n' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:175:6: ( 'O' | 'o' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ON"

    // $ANTLR start "R_1"
    public final void mR_1() throws RecognitionException {
        try {
            int _type = R_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:177:5: ( ( 'R' | 'r' ) '@' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:177:7: ( 'R' | 'r' ) '@'
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "R_1"

    // $ANTLR start "ST"
    public final void mST() throws RecognitionException {
        try {
            int _type = ST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:179:4: ( ( 'S' | 's' ) ( 'T' | 't' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:179:6: ( 'S' | 's' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
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
    // $ANTLR end "ST"

    // $ANTLR start "T"
    public final void mT() throws RecognitionException {
        try {
            int _type = T;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:181:3: ( ( 'T' | 't' ) '!' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:181:5: ( 'T' | 't' ) '!'
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T"

    // $ANTLR start "T_1"
    public final void mT_1() throws RecognitionException {
        try {
            int _type = T_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:183:5: ( ( 'T' | 't' ) '@' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:183:7: ( 'T' | 't' ) '@'
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T_1"

    // $ANTLR start "R_2"
    public final void mR_2() throws RecognitionException {
        try {
            int _type = R_2;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:185:5: ( ( 'R' | 'r' ) '>' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:185:7: ( 'R' | 'r' ) '>'
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "R_2"

    // $ANTLR start "ExclamationMark"
    public final void mExclamationMark() throws RecognitionException {
        try {
            int _type = ExclamationMark;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:187:17: ( '!' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:187:19: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ExclamationMark"

    // $ANTLR start "Asterisk"
    public final void mAsterisk() throws RecognitionException {
        try {
            int _type = Asterisk;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:189:10: ( '*' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:189:12: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Asterisk"

    // $ANTLR start "PlusSign"
    public final void mPlusSign() throws RecognitionException {
        try {
            int _type = PlusSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:191:10: ( '+' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:191:12: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PlusSign"

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:193:7: ( ',' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:193:9: ','
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

    // $ANTLR start "HyphenMinus"
    public final void mHyphenMinus() throws RecognitionException {
        try {
            int _type = HyphenMinus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:195:13: ( '-' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:195:15: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HyphenMinus"

    // $ANTLR start "Solidus"
    public final void mSolidus() throws RecognitionException {
        try {
            int _type = Solidus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:197:9: ( '/' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:197:11: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Solidus"

    // $ANTLR start "Colon"
    public final void mColon() throws RecognitionException {
        try {
            int _type = Colon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:199:7: ( ':' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:199:9: ':'
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
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:201:11: ( ';' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:201:13: ';'
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

    // $ANTLR start "CommercialAt"
    public final void mCommercialAt() throws RecognitionException {
        try {
            int _type = CommercialAt;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:203:14: ( '@' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:203:16: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CommercialAt"

    // $ANTLR start "RULE_DIGIT"
    public final void mRULE_DIGIT() throws RecognitionException {
        try {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:207:21: ( '0' .. '9' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:207:23: '0' .. '9'
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
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:209:22: ( ( RULE_DIGIT )+ )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:209:24: ( RULE_DIGIT )+
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:209:24: ( RULE_DIGIT )+
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
            	    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:209:24: RULE_DIGIT
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
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:211:17: ( '(' (~ ( ( '\\n' | '\\r' ) ) )* ')' ( RULE_WS )* )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:211:19: '(' (~ ( ( '\\n' | '\\r' ) ) )* ')' ( RULE_WS )*
            {
            match('('); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:211:23: (~ ( ( '\\n' | '\\r' ) ) )*
            loop2:
            do {
                int alt2=2;
                alt2 = dfa2.predict(input);
                switch (alt2) {
            	case 1 :
            	    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:211:23: ~ ( ( '\\n' | '\\r' ) )
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
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:211:43: ( RULE_WS )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\t' && LA3_0<='\n')||LA3_0=='\r'||LA3_0==' ') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:211:43: RULE_WS
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
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:213:10: ( ( '-' )? ( '0' .. '9' | 'A' .. 'F' )+ )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:213:12: ( '-' )? ( '0' .. '9' | 'A' .. 'F' )+
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:213:12: ( '-' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='-') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:213:12: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:213:17: ( '0' .. '9' | 'A' .. 'F' )+
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
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:215:13: ( RULE_DECINT ( '.' ( RULE_DIGIT )* | ( '.' ( RULE_DIGIT )* )? ( 'E' | 'e' ) ( '-' | '+' )? RULE_DECINT ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:215:15: RULE_DECINT ( '.' ( RULE_DIGIT )* | ( '.' ( RULE_DIGIT )* )? ( 'E' | 'e' ) ( '-' | '+' )? RULE_DECINT )
            {
            mRULE_DECINT(); 
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:215:27: ( '.' ( RULE_DIGIT )* | ( '.' ( RULE_DIGIT )* )? ( 'E' | 'e' ) ( '-' | '+' )? RULE_DECINT )
            int alt10=2;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:215:28: '.' ( RULE_DIGIT )*
                    {
                    match('.'); 
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:215:32: ( RULE_DIGIT )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:215:32: RULE_DIGIT
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
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:215:44: ( '.' ( RULE_DIGIT )* )? ( 'E' | 'e' ) ( '-' | '+' )? RULE_DECINT
                    {
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:215:44: ( '.' ( RULE_DIGIT )* )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='.') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:215:45: '.' ( RULE_DIGIT )*
                            {
                            match('.'); 
                            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:215:49: ( RULE_DIGIT )*
                            loop7:
                            do {
                                int alt7=2;
                                int LA7_0 = input.LA(1);

                                if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                                    alt7=1;
                                }


                                switch (alt7) {
                            	case 1 :
                            	    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:215:49: RULE_DIGIT
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

                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:215:73: ( '-' | '+' )?
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
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:217:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '!' | '@' | '?' | ',' | '<' | '>' | '=' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '!' | '?' | '@' | '<' | '>' | '0' .. '9' | ',' | '=' )* )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:217:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '!' | '@' | '?' | ',' | '<' | '>' | '=' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '!' | '?' | '@' | '<' | '>' | '0' .. '9' | ',' | '=' )*
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:217:11: ( '^' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='^') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:217:11: '^'
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

            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:217:68: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '!' | '?' | '@' | '<' | '>' | '0' .. '9' | ',' | '=' )*
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

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:219:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:219:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:219:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:219:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:219:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:219:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:219:28: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:219:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:219:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:219:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:219:61: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:221:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:221:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:221:24: ( options {greedy=false; } : . )*
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
            	    // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:221:52: .
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
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:223:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:223:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:223:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:225:16: ( . )
            // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:225:18: .
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
        // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:8: ( CARRY_RESET | TorBranch | Branch_2 | CARRYSET | NcBranch | NoBranch | NsBranch | Branch | Branch_1 | SBranch | DNEGATE | NzExit | ASHIFT | EXTEND | NEGATE | RCLEAR | UNPACK | Create | ZExit | DROP_1 | OVER_1 | SWAP_1 | CELL | CELL_1 | CLEAR | COUNT | ERASE | FALSE | PLACE | RDROP | SHIFT | UNDER | ROT_1 | DUP_1 | DUP_2 | DABS | DROL | DROP | DROR | FILL | MOVE | OVER | PACK | SWAP | TRUE | TUCK | ST_1 | DigitZeroLessThanSignGreaterThanSign | DigitTwoAsteriskAsterisk | ABS | DEC | DUP | INC | LLD | LST | NIP | OFF | ROL | ROR | ROT | TLD | TST | D0 | Jsr | U2 | PlusSignExclamationMark | DigitZeroLessThanSign | DigitZeroEqualsSign | DigitOnePlusSign | DigitOneHyphenMinus | DigitTwoExclamationMark | DigitTwoAsterisk | DigitTwoSolidus | DigitTwoCommercialAt | R | L | L_1 | LD | ON | R_1 | ST | T | T_1 | R_2 | ExclamationMark | Asterisk | PlusSign | Comma | HyphenMinus | Solidus | Colon | Semicolon | CommercialAt | RULE_SL_COMMENT | RULE_INT | RULE_DOUBLE | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt18=101;
        alt18 = dfa18.predict(input);
        switch (alt18) {
            case 1 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:10: CARRY_RESET
                {
                mCARRY_RESET(); 

                }
                break;
            case 2 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:22: TorBranch
                {
                mTorBranch(); 

                }
                break;
            case 3 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:32: Branch_2
                {
                mBranch_2(); 

                }
                break;
            case 4 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:41: CARRYSET
                {
                mCARRYSET(); 

                }
                break;
            case 5 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:50: NcBranch
                {
                mNcBranch(); 

                }
                break;
            case 6 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:59: NoBranch
                {
                mNoBranch(); 

                }
                break;
            case 7 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:68: NsBranch
                {
                mNsBranch(); 

                }
                break;
            case 8 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:77: Branch
                {
                mBranch(); 

                }
                break;
            case 9 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:84: Branch_1
                {
                mBranch_1(); 

                }
                break;
            case 10 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:93: SBranch
                {
                mSBranch(); 

                }
                break;
            case 11 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:101: DNEGATE
                {
                mDNEGATE(); 

                }
                break;
            case 12 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:109: NzExit
                {
                mNzExit(); 

                }
                break;
            case 13 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:116: ASHIFT
                {
                mASHIFT(); 

                }
                break;
            case 14 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:123: EXTEND
                {
                mEXTEND(); 

                }
                break;
            case 15 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:130: NEGATE
                {
                mNEGATE(); 

                }
                break;
            case 16 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:137: RCLEAR
                {
                mRCLEAR(); 

                }
                break;
            case 17 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:144: UNPACK
                {
                mUNPACK(); 

                }
                break;
            case 18 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:151: Create
                {
                mCreate(); 

                }
                break;
            case 19 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:158: ZExit
                {
                mZExit(); 

                }
                break;
            case 20 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:164: DROP_1
                {
                mDROP_1(); 

                }
                break;
            case 21 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:171: OVER_1
                {
                mOVER_1(); 

                }
                break;
            case 22 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:178: SWAP_1
                {
                mSWAP_1(); 

                }
                break;
            case 23 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:185: CELL
                {
                mCELL(); 

                }
                break;
            case 24 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:190: CELL_1
                {
                mCELL_1(); 

                }
                break;
            case 25 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:197: CLEAR
                {
                mCLEAR(); 

                }
                break;
            case 26 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:203: COUNT
                {
                mCOUNT(); 

                }
                break;
            case 27 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:209: ERASE
                {
                mERASE(); 

                }
                break;
            case 28 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:215: FALSE
                {
                mFALSE(); 

                }
                break;
            case 29 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:221: PLACE
                {
                mPLACE(); 

                }
                break;
            case 30 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:227: RDROP
                {
                mRDROP(); 

                }
                break;
            case 31 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:233: SHIFT
                {
                mSHIFT(); 

                }
                break;
            case 32 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:239: UNDER
                {
                mUNDER(); 

                }
                break;
            case 33 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:245: ROT_1
                {
                mROT_1(); 

                }
                break;
            case 34 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:251: DUP_1
                {
                mDUP_1(); 

                }
                break;
            case 35 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:257: DUP_2
                {
                mDUP_2(); 

                }
                break;
            case 36 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:263: DABS
                {
                mDABS(); 

                }
                break;
            case 37 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:268: DROL
                {
                mDROL(); 

                }
                break;
            case 38 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:273: DROP
                {
                mDROP(); 

                }
                break;
            case 39 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:278: DROR
                {
                mDROR(); 

                }
                break;
            case 40 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:283: FILL
                {
                mFILL(); 

                }
                break;
            case 41 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:288: MOVE
                {
                mMOVE(); 

                }
                break;
            case 42 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:293: OVER
                {
                mOVER(); 

                }
                break;
            case 43 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:298: PACK
                {
                mPACK(); 

                }
                break;
            case 44 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:303: SWAP
                {
                mSWAP(); 

                }
                break;
            case 45 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:308: TRUE
                {
                mTRUE(); 

                }
                break;
            case 46 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:313: TUCK
                {
                mTUCK(); 

                }
                break;
            case 47 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:318: ST_1
                {
                mST_1(); 

                }
                break;
            case 48 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:323: DigitZeroLessThanSignGreaterThanSign
                {
                mDigitZeroLessThanSignGreaterThanSign(); 

                }
                break;
            case 49 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:360: DigitTwoAsteriskAsterisk
                {
                mDigitTwoAsteriskAsterisk(); 

                }
                break;
            case 50 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:385: ABS
                {
                mABS(); 

                }
                break;
            case 51 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:389: DEC
                {
                mDEC(); 

                }
                break;
            case 52 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:393: DUP
                {
                mDUP(); 

                }
                break;
            case 53 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:397: INC
                {
                mINC(); 

                }
                break;
            case 54 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:401: LLD
                {
                mLLD(); 

                }
                break;
            case 55 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:405: LST
                {
                mLST(); 

                }
                break;
            case 56 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:409: NIP
                {
                mNIP(); 

                }
                break;
            case 57 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:413: OFF
                {
                mOFF(); 

                }
                break;
            case 58 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:417: ROL
                {
                mROL(); 

                }
                break;
            case 59 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:421: ROR
                {
                mROR(); 

                }
                break;
            case 60 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:425: ROT
                {
                mROT(); 

                }
                break;
            case 61 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:429: TLD
                {
                mTLD(); 

                }
                break;
            case 62 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:433: TST
                {
                mTST(); 

                }
                break;
            case 63 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:437: D0
                {
                mD0(); 

                }
                break;
            case 64 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:440: Jsr
                {
                mJsr(); 

                }
                break;
            case 65 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:444: U2
                {
                mU2(); 

                }
                break;
            case 66 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:447: PlusSignExclamationMark
                {
                mPlusSignExclamationMark(); 

                }
                break;
            case 67 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:471: DigitZeroLessThanSign
                {
                mDigitZeroLessThanSign(); 

                }
                break;
            case 68 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:493: DigitZeroEqualsSign
                {
                mDigitZeroEqualsSign(); 

                }
                break;
            case 69 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:513: DigitOnePlusSign
                {
                mDigitOnePlusSign(); 

                }
                break;
            case 70 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:530: DigitOneHyphenMinus
                {
                mDigitOneHyphenMinus(); 

                }
                break;
            case 71 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:550: DigitTwoExclamationMark
                {
                mDigitTwoExclamationMark(); 

                }
                break;
            case 72 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:574: DigitTwoAsterisk
                {
                mDigitTwoAsterisk(); 

                }
                break;
            case 73 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:591: DigitTwoSolidus
                {
                mDigitTwoSolidus(); 

                }
                break;
            case 74 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:607: DigitTwoCommercialAt
                {
                mDigitTwoCommercialAt(); 

                }
                break;
            case 75 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:628: R
                {
                mR(); 

                }
                break;
            case 76 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:630: L
                {
                mL(); 

                }
                break;
            case 77 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:632: L_1
                {
                mL_1(); 

                }
                break;
            case 78 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:636: LD
                {
                mLD(); 

                }
                break;
            case 79 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:639: ON
                {
                mON(); 

                }
                break;
            case 80 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:642: R_1
                {
                mR_1(); 

                }
                break;
            case 81 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:646: ST
                {
                mST(); 

                }
                break;
            case 82 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:649: T
                {
                mT(); 

                }
                break;
            case 83 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:651: T_1
                {
                mT_1(); 

                }
                break;
            case 84 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:655: R_2
                {
                mR_2(); 

                }
                break;
            case 85 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:659: ExclamationMark
                {
                mExclamationMark(); 

                }
                break;
            case 86 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:675: Asterisk
                {
                mAsterisk(); 

                }
                break;
            case 87 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:684: PlusSign
                {
                mPlusSign(); 

                }
                break;
            case 88 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:693: Comma
                {
                mComma(); 

                }
                break;
            case 89 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:699: HyphenMinus
                {
                mHyphenMinus(); 

                }
                break;
            case 90 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:711: Solidus
                {
                mSolidus(); 

                }
                break;
            case 91 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:719: Colon
                {
                mColon(); 

                }
                break;
            case 92 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:725: Semicolon
                {
                mSemicolon(); 

                }
                break;
            case 93 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:735: CommercialAt
                {
                mCommercialAt(); 

                }
                break;
            case 94 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:748: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 95 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:764: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 96 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:773: RULE_DOUBLE
                {
                mRULE_DOUBLE(); 

                }
                break;
            case 97 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:785: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 98 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:793: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 99 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:805: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 100 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:821: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 101 :
                // ../ch.fhnw.mdt.forthlang.ui/src-gen/ch/fhnw/mdt/ui/contentassist/antlr/lexer/InternalUForthLexer.g:1:829: RULE_ANY_OTHER
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
        "\1\0\1\1\1\uffff\1\2\1\uffff}>";
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
            return "()* loopback of 211:23: (~ ( ( '\\n' | '\\r' ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA2_0 = input.LA(1);

                        s = -1;
                        if ( (LA2_0==')') ) {s = 1;}

                        else if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\f')||(LA2_0>='\u000E' && LA2_0<='(')||(LA2_0>='*' && LA2_0<='\uFFFF')) ) {s = 2;}

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
                        int LA2_3 = input.LA(1);

                        s = -1;
                        if ( (LA2_3=='\t'||LA2_3==' ') ) {s = 3;}

                        else if ( ((LA2_3>='\u0000' && LA2_3<='\b')||(LA2_3>='\u000B' && LA2_3<='\f')||(LA2_3>='\u000E' && LA2_3<='\u001F')||(LA2_3>='!' && LA2_3<='\uFFFF')) ) {s = 2;}

                        else s = 4;

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
            return "215:27: ( '.' ( RULE_DIGIT )* | ( '.' ( RULE_DIGIT )* )? ( 'E' | 'e' ) ( '-' | '+' )? RULE_DECINT )";
        }
    }
    static final String DFA18_eotS =
        "\1\uffff\1\63\1\67\1\63\3\67\3\63\3\67\2\63\1\67\1\163\2\67\1\172"+
        "\3\67\1\63\1\67\1\u0085\1\uffff\1\u0087\1\u0089\2\uffff\1\u008c"+
        "\1\55\5\67\2\63\1\55\1\uffff\2\55\2\uffff\1\63\1\67\1\63\2\67\1"+
        "\uffff\2\67\1\63\1\uffff\5\67\1\u009b\1\u009c\1\u009e\1\u00a0\1"+
        "\63\1\uffff\1\63\6\67\1\uffff\1\67\1\uffff\2\67\1\u00ab\1\67\1\63"+
        "\1\67\1\63\1\67\1\63\3\67\1\63\6\67\1\u00bd\1\u00be\2\67\1\uffff"+
        "\1\63\2\uffff\1\u00c5\4\uffff\1\63\4\67\2\uffff\3\67\1\u00cd\3\uffff"+
        "\3\67\1\u00d1\1\u00d2\1\u00d3\1\67\2\uffff\1\u00d5\11\uffff\1\67"+
        "\2\uffff\10\67\1\u00de\1\u00df\2\uffff\1\u00e1\3\uffff\1\63\4\uffff"+
        "\1\67\1\u00e3\3\67\1\uffff\1\67\1\63\2\67\2\u00ec\1\u00ed\1\u00ee"+
        "\1\67\1\u00f0\4\67\1\u00f5\1\u00f6\1\u00f7\2\uffff\2\67\5\uffff"+
        "\6\67\1\u0100\1\uffff\1\u0101\1\u0102\1\u0103\3\uffff\1\u0104\1"+
        "\uffff\5\67\1\uffff\1\u010b\1\u010c\4\uffff\1\67\1\uffff\1\u010e"+
        "\1\67\1\u0110\1\67\1\u0112\1\u0113\1\u0114\1\u0115\3\uffff\1\67"+
        "\1\uffff\4\67\3\uffff\3\67\1\u011e\1\67\1\u0120\1\u0121\1\u0122"+
        "\5\uffff\2\67\2\uffff\1\u0126\1\u0127\2\uffff\1\67\1\uffff\1\u0129"+
        "\1\uffff\1\67\4\uffff\2\67\1\u012d\1\67\1\u012f\1\67\1\u0131\1\u0132"+
        "\1\uffff\1\u0133\3\uffff\1\67\1\uffff\1\u0135\2\uffff\1\u0136\1"+
        "\uffff\1\67\1\u0138\1\u0139\1\uffff\1\u013a\1\uffff\1\u013b\3\uffff"+
        "\1\67\2\uffff\1\u013d\4\uffff\1\67\1\uffff\2\67\1\u0141\1\uffff";
    static final String DFA18_eofS =
        "\u0142\uffff";
    static final String DFA18_minS =
        "\1\0\2\41\1\56\1\103\2\55\3\41\1\76\1\62\1\55\2\41\1\101\1\60\1"+
        "\117\1\106\1\41\1\116\1\41\1\123\1\53\1\122\1\41\1\uffff\1\41\1"+
        "\52\2\uffff\1\41\1\0\1\101\1\60\1\102\1\122\1\101\1\56\2\41\1\uffff"+
        "\2\0\2\uffff\1\41\1\105\1\41\1\105\1\125\1\uffff\1\122\1\114\1\41"+
        "\1\uffff\1\122\1\125\1\103\1\104\1\124\2\41\1\76\1\102\1\53\1\uffff"+
        "\1\56\4\55\1\107\1\120\1\uffff\1\125\1\uffff\1\111\1\101\1\41\1"+
        "\105\1\41\1\117\1\41\1\120\1\41\1\102\1\103\1\110\1\41\1\123\1\124"+
        "\1\101\1\114\1\122\1\114\2\41\1\104\1\57\1\uffff\1\122\2\uffff\1"+
        "\52\3\uffff\1\122\1\41\2\114\1\101\1\103\2\uffff\1\126\1\105\1\106"+
        "\1\41\3\uffff\1\103\1\104\1\124\3\41\1\122\2\uffff\1\41\11\uffff"+
        "\1\75\2\uffff\1\122\1\101\1\114\1\101\1\116\1\55\1\105\1\113\2\41"+
        "\2\uffff\1\102\3\uffff\1\60\4\uffff\1\101\1\41\1\120\1\106\1\120"+
        "\1\uffff\1\107\1\41\1\123\1\114\4\41\1\111\1\41\1\105\1\123\1\105"+
        "\1\117\3\41\2\uffff\1\101\1\105\5\uffff\1\123\1\114\1\103\1\113"+
        "\1\105\1\122\1\41\1\uffff\3\41\3\uffff\1\41\1\uffff\1\131\1\124"+
        "\1\53\1\122\1\124\1\uffff\2\41\4\uffff\1\124\1\uffff\1\41\1\124"+
        "\1\41\1\101\4\41\3\uffff\1\106\1\uffff\1\116\1\105\1\101\1\120\3"+
        "\uffff\1\103\1\122\1\105\1\41\1\105\3\41\5\uffff\1\55\1\105\2\uffff"+
        "\2\41\2\uffff\1\105\1\uffff\1\41\1\uffff\1\124\4\uffff\1\124\1\104"+
        "\1\41\1\122\1\41\1\113\2\41\1\uffff\1\41\3\uffff\1\122\1\uffff\1"+
        "\41\2\uffff\1\41\1\uffff\1\105\2\41\1\uffff\1\41\1\uffff\1\41\3"+
        "\uffff\1\105\2\uffff\1\41\4\uffff\1\123\1\uffff\1\105\1\124\1\41"+
        "\1\uffff";
    static final String DFA18_maxS =
        "\1\uffff\1\172\1\165\1\145\1\172\1\144\1\167\3\172\1\157\1\156"+
        "\1\55\1\163\1\172\1\154\1\162\1\157\1\166\1\163\1\156\2\163\1\145"+
        "\1\162\1\172\1\uffff\1\172\1\52\2\uffff\1\172\1\uffff\1\162\1\165"+
        "\1\163\1\170\1\151\1\145\2\172\1\uffff\2\uffff\2\uffff\1\172\1\145"+
        "\1\172\1\145\1\165\1\uffff\1\162\1\154\1\172\1\uffff\1\162\1\165"+
        "\1\143\1\144\1\164\2\172\1\76\1\142\1\71\1\uffff\1\145\4\55\1\147"+
        "\1\160\1\uffff\1\165\1\uffff\1\151\1\141\1\172\1\145\1\172\1\157"+
        "\1\172\1\160\1\172\1\142\1\143\1\150\1\172\1\163\1\164\1\141\1\154"+
        "\1\162\1\164\2\172\1\160\1\57\1\uffff\1\165\2\uffff\1\52\3\uffff"+
        "\1\165\1\172\2\154\1\141\1\143\2\uffff\1\166\1\145\1\146\1\172\3"+
        "\uffff\1\143\1\144\1\164\3\172\1\162\2\uffff\1\172\11\uffff\1\75"+
        "\2\uffff\1\162\1\141\1\154\1\141\1\156\1\55\1\145\1\153\2\172\2"+
        "\uffff\1\142\3\uffff\1\71\4\uffff\1\141\1\172\1\160\1\146\1\160"+
        "\1\uffff\1\147\1\172\1\163\1\162\4\172\1\151\1\172\1\145\1\163\1"+
        "\145\1\157\3\172\2\uffff\1\141\1\145\5\uffff\1\163\1\154\1\143\1"+
        "\153\1\145\1\162\1\172\1\uffff\3\172\3\uffff\1\172\1\uffff\1\171"+
        "\1\164\1\55\1\162\1\164\1\uffff\2\172\4\uffff\1\164\1\uffff\1\172"+
        "\1\164\1\172\1\141\4\172\3\uffff\1\146\1\uffff\1\156\1\145\1\141"+
        "\1\160\3\uffff\1\143\1\162\1\145\1\172\1\145\3\172\5\uffff\1\137"+
        "\1\145\2\uffff\2\172\2\uffff\1\145\1\uffff\1\172\1\uffff\1\164\4"+
        "\uffff\1\164\1\144\1\172\1\162\1\172\1\153\2\172\1\uffff\1\172\3"+
        "\uffff\1\162\1\uffff\1\172\2\uffff\1\172\1\uffff\1\145\2\172\1\uffff"+
        "\1\172\1\uffff\1\172\3\uffff\1\145\2\uffff\1\172\4\uffff\1\163\1"+
        "\uffff\1\145\1\164\1\172\1\uffff";
    static final String DFA18_acceptS =
        "\32\uffff\1\126\2\uffff\1\133\1\134\12\uffff\1\141\2\uffff\1\144"+
        "\1\145\5\uffff\1\137\3\uffff\1\141\12\uffff\1\140\7\uffff\1\11\1"+
        "\uffff\1\12\27\uffff\1\23\1\uffff\1\25\1\26\1\uffff\1\107\1\111"+
        "\1\112\6\uffff\1\41\1\131\4\uffff\1\57\1\102\1\127\7\uffff\1\105"+
        "\1\106\1\uffff\1\125\1\126\1\130\1\143\1\132\1\133\1\134\1\135\1"+
        "\136\1\uffff\1\142\1\144\12\uffff\1\122\1\123\1\uffff\1\103\1\10"+
        "\1\104\1\uffff\1\5\1\6\1\7\1\14\5\uffff\1\121\21\uffff\1\120\1\124"+
        "\2\uffff\1\101\1\24\1\42\1\61\1\110\7\uffff\1\117\3\uffff\1\114"+
        "\1\115\1\116\1\uffff\1\113\5\uffff\1\2\2\uffff\1\75\1\76\1\3\1\60"+
        "\1\uffff\1\70\10\uffff\1\63\1\64\1\77\1\uffff\1\62\4\uffff\1\72"+
        "\1\73\1\74\10\uffff\1\71\1\65\1\66\1\67\1\100\2\uffff\1\27\1\30"+
        "\2\uffff\1\55\1\56\1\uffff\1\43\1\uffff\1\54\1\uffff\1\44\1\45\1"+
        "\46\1\47\10\uffff\1\50\1\uffff\1\53\1\51\1\52\1\uffff\1\4\1\uffff"+
        "\1\31\1\32\1\uffff\1\37\3\uffff\1\33\1\uffff\1\36\1\uffff\1\40\1"+
        "\34\1\35\1\uffff\1\22\1\17\1\uffff\1\15\1\16\1\20\1\21\1\uffff\1"+
        "\13\3\uffff\1\1";
    static final String DFA18_specialS =
        "\1\1\37\uffff\1\0\11\uffff\1\3\1\2\u0116\uffff}>";
    static final String[] DFA18_transitionS = {
            "\11\55\2\54\2\55\1\54\22\55\1\54\1\31\1\52\4\55\1\53\1\40\1"+
            "\55\1\32\1\23\1\33\1\20\1\55\1\34\1\3\1\27\1\15\7\46\1\35\1"+
            "\36\2\51\1\30\1\5\1\37\1\10\1\47\1\1\1\7\1\11\1\16\2\51\1\24"+
            "\1\26\1\51\1\25\1\21\1\4\1\22\1\17\1\51\1\12\1\6\1\2\1\13\4"+
            "\51\1\14\3\55\1\50\1\51\1\55\1\43\1\51\1\41\1\42\1\44\1\45\2"+
            "\51\1\24\1\26\1\51\1\25\1\21\1\4\1\22\1\17\1\51\1\12\1\6\1\2"+
            "\1\13\4\51\1\14\uff85\55",
            "\1\67\12\uffff\1\67\3\uffff\12\66\2\uffff\5\67\1\56\3\66\1"+
            "\60\1\66\5\67\1\61\2\67\1\62\2\67\1\57\10\67\4\uffff\1\67\1"+
            "\uffff\1\64\3\67\1\65\6\67\1\61\2\67\1\62\2\67\1\57\10\67",
            "\1\75\36\uffff\1\76\13\uffff\1\73\2\uffff\1\70\2\uffff\1\71"+
            "\1\74\1\uffff\1\72\26\uffff\1\73\2\uffff\1\70\2\uffff\1\71\1"+
            "\74\1\uffff\1\72",
            "\1\102\1\uffff\12\103\2\uffff\1\77\1\100\7\uffff\1\101\37"+
            "\uffff\1\102",
            "\1\104\1\uffff\1\110\3\uffff\1\111\5\uffff\1\105\3\uffff\1"+
            "\106\6\uffff\1\107\10\uffff\1\104\1\uffff\1\110\3\uffff\1\111"+
            "\5\uffff\1\105\3\uffff\1\106\6\uffff\1\107",
            "\1\112\26\uffff\1\113\37\uffff\1\113",
            "\1\114\32\uffff\1\115\13\uffff\1\117\2\uffff\1\116\20\uffff"+
            "\1\115\13\uffff\1\117\2\uffff\1\116",
            "\1\67\12\uffff\1\67\3\uffff\1\125\11\66\2\uffff\5\67\1\121"+
            "\3\66\1\123\1\66\7\67\1\120\3\67\1\122\2\67\1\124\5\67\4\uffff"+
            "\1\67\1\uffff\1\126\3\67\1\127\10\67\1\120\3\67\1\122\2\67\1"+
            "\124\5\67",
            "\1\67\12\uffff\1\67\3\uffff\12\66\2\uffff\5\67\1\66\1\131"+
            "\4\66\14\67\1\130\7\67\4\uffff\1\67\1\uffff\1\67\1\132\20\67"+
            "\1\130\7\67",
            "\1\67\12\uffff\1\67\3\uffff\12\66\2\uffff\5\67\6\66\13\67"+
            "\1\134\5\67\1\133\2\67\4\uffff\1\67\1\uffff\21\67\1\134\5\67"+
            "\1\133\2\67",
            "\1\141\1\uffff\1\140\2\uffff\1\135\1\136\12\uffff\1\137\23"+
            "\uffff\1\135\1\136\12\uffff\1\137",
            "\1\143\33\uffff\1\142\37\uffff\1\142",
            "\1\144",
            "\1\151\10\uffff\1\150\3\uffff\1\102\1\152\12\103\6\uffff\1"+
            "\153\3\uffff\1\145\1\101\11\uffff\1\146\3\uffff\1\147\20\uffff"+
            "\1\154\1\102\11\uffff\1\146\3\uffff\1\147",
            "\1\67\12\uffff\1\67\3\uffff\12\66\2\uffff\5\67\1\155\5\66"+
            "\2\67\1\156\21\67\4\uffff\1\67\1\uffff\1\157\7\67\1\156\21\67",
            "\1\161\12\uffff\1\160\24\uffff\1\161\12\uffff\1\160",
            "\12\63\7\uffff\6\63\13\uffff\1\162\37\uffff\1\162",
            "\1\164\37\uffff\1\164",
            "\1\166\7\uffff\1\167\7\uffff\1\165\17\uffff\1\166\7\uffff"+
            "\1\167\7\uffff\1\165",
            "\1\171\61\uffff\1\170\37\uffff\1\170",
            "\1\173\37\uffff\1\173",
            "\1\176\36\uffff\1\177\3\uffff\1\u0080\7\uffff\1\174\6\uffff"+
            "\1\175\20\uffff\1\u0080\7\uffff\1\174\6\uffff\1\175",
            "\1\u0081\37\uffff\1\u0081",
            "\1\u0082\1\uffff\1\u0083\1\102\1\uffff\12\103\13\uffff\1\101"+
            "\37\uffff\1\102",
            "\1\u0084\37\uffff\1\u0084",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "\1\u0088",
            "",
            "",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "\12\u008d\1\uffff\2\u008d\1\uffff\ufff2\u008d",
            "\1\64\3\uffff\1\65\6\uffff\1\61\2\uffff\1\62\2\uffff\1\57"+
            "\16\uffff\1\64\3\uffff\1\65\6\uffff\1\61\2\uffff\1\62\2\uffff"+
            "\1\57",
            "\1\u008e\20\uffff\1\126\3\uffff\1\127\10\uffff\1\120\3\uffff"+
            "\1\122\2\uffff\1\124\13\uffff\1\126\3\uffff\1\127\10\uffff\1"+
            "\120\3\uffff\1\122\2\uffff\1\124",
            "\1\132\20\uffff\1\130\16\uffff\1\132\20\uffff\1\130",
            "\1\134\5\uffff\1\133\31\uffff\1\134\5\uffff\1\133",
            "\1\157\7\uffff\1\156\27\uffff\1\157\7\uffff\1\156",
            "\1\102\1\uffff\12\103\13\uffff\1\101\37\uffff\1\102",
            "\1\67\12\uffff\1\67\3\uffff\12\66\2\uffff\5\67\6\66\24\67"+
            "\4\uffff\1\67\1\uffff\32\67",
            "\1\67\12\uffff\1\67\17\uffff\37\67\4\uffff\1\67\1\uffff\32"+
            "\67",
            "",
            "\0\u008f",
            "\0\u008f",
            "",
            "",
            "\1\67\12\uffff\1\67\3\uffff\12\66\2\uffff\5\67\6\66\13\67"+
            "\1\u0091\10\67\4\uffff\1\67\1\uffff\21\67\1\u0091\10\67",
            "\1\u0092\37\uffff\1\u0092",
            "\1\67\12\uffff\1\67\3\uffff\12\66\2\uffff\5\67\6\66\5\67\1"+
            "\u0093\16\67\4\uffff\1\67\1\uffff\13\67\1\u0093\16\67",
            "\1\u0094\37\uffff\1\u0094",
            "\1\u0095\37\uffff\1\u0095",
            "",
            "\1\u0091\37\uffff\1\u0091",
            "\1\u0093\37\uffff\1\u0093",
            "\1\67\12\uffff\1\67\3\uffff\12\66\2\uffff\5\67\6\66\24\67"+
            "\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\u0096\37\uffff\1\u0096",
            "\1\u0097\37\uffff\1\u0097",
            "\1\u0098\37\uffff\1\u0098",
            "\1\u0099\37\uffff\1\u0099",
            "\1\u009a\37\uffff\1\u009a",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "\1\u009d",
            "\1\u009f\37\uffff\1\u009f",
            "\1\102\1\uffff\1\102\2\uffff\12\u00a1",
            "",
            "\1\102\1\uffff\12\103\13\uffff\1\101\37\uffff\1\102",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6\37\uffff\1\u00a6",
            "\1\u00a7\37\uffff\1\u00a7",
            "",
            "\1\u00a8\37\uffff\1\u00a8",
            "",
            "\1\u00a9\37\uffff\1\u00a9",
            "\1\u00aa\37\uffff\1\u00aa",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "\1\u00ac\37\uffff\1\u00ac",
            "\1\67\12\uffff\1\67\3\uffff\12\66\2\uffff\5\67\1\66\1\u00ad"+
            "\4\66\24\67\4\uffff\1\67\1\uffff\1\67\1\u00ae\30\67",
            "\1\u00af\37\uffff\1\u00af",
            "\1\67\12\uffff\1\67\3\uffff\12\66\2\uffff\5\67\2\66\1\u00b0"+
            "\3\66\24\67\4\uffff\1\67\1\uffff\2\67\1\u00b1\27\67",
            "\1\u00b2\37\uffff\1\u00b2",
            "\1\67\12\uffff\1\67\3\uffff\12\66\2\uffff\1\67\1\u00b3\3\67"+
            "\6\66\24\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u00ae\37\uffff\1\u00ae",
            "\1\u00b1\37\uffff\1\u00b1",
            "\1\u00b4\37\uffff\1\u00b4",
            "\1\67\12\uffff\1\67\3\uffff\12\66\2\uffff\5\67\6\66\14\67"+
            "\1\u00b5\7\67\4\uffff\1\67\1\uffff\22\67\1\u00b5\7\67",
            "\1\u00b5\37\uffff\1\u00b5",
            "\1\u00b6\37\uffff\1\u00b6",
            "\1\u00b7\37\uffff\1\u00b7",
            "\1\u00b8\37\uffff\1\u00b8",
            "\1\u00b9\37\uffff\1\u00b9",
            "\1\u00ba\5\uffff\1\u00bb\1\uffff\1\u00bc\27\uffff\1\u00ba"+
            "\5\uffff\1\u00bb\1\uffff\1\u00bc",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "\1\u00c0\13\uffff\1\u00bf\23\uffff\1\u00c0\13\uffff\1\u00bf",
            "\1\u00c1",
            "",
            "\1\u00c2\2\uffff\1\u00c3\34\uffff\1\u00c2\2\uffff\1\u00c3",
            "",
            "",
            "\1\u00c4",
            "",
            "",
            "",
            "\1\u00c2\2\uffff\1\u00c3\34\uffff\1\u00c2\2\uffff\1\u00c3",
            "\1\67\12\uffff\1\67\3\uffff\12\66\2\uffff\5\67\6\66\5\67\1"+
            "\u00c6\16\67\4\uffff\1\67\1\uffff\13\67\1\u00c6\16\67",
            "\1\u00c7\37\uffff\1\u00c7",
            "\1\u00c6\37\uffff\1\u00c6",
            "\1\u00c8\37\uffff\1\u00c8",
            "\1\u00c9\37\uffff\1\u00c9",
            "",
            "",
            "\1\u00ca\37\uffff\1\u00ca",
            "\1\u00cb\37\uffff\1\u00cb",
            "\1\u00cc\37\uffff\1\u00cc",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "",
            "",
            "",
            "\1\u00ce\37\uffff\1\u00ce",
            "\1\u00cf\37\uffff\1\u00cf",
            "\1\u00d0\37\uffff\1\u00d0",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "\1\u00d4\37\uffff\1\u00d4",
            "",
            "",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00b3",
            "",
            "",
            "\1\u00d6\37\uffff\1\u00d6",
            "\1\u00d7\37\uffff\1\u00d7",
            "\1\u00d8\37\uffff\1\u00d8",
            "\1\u00d9\37\uffff\1\u00d9",
            "\1\u00da\37\uffff\1\u00da",
            "\1\u00db",
            "\1\u00dc\37\uffff\1\u00dc",
            "\1\u00dd\37\uffff\1\u00dd",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "",
            "",
            "\1\u00e0\37\uffff\1\u00e0",
            "",
            "",
            "",
            "\12\u00a1",
            "",
            "",
            "",
            "",
            "\1\u00e2\37\uffff\1\u00e2",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "\1\u00e4\37\uffff\1\u00e4",
            "\1\u00e5\37\uffff\1\u00e5",
            "\1\u00e6\37\uffff\1\u00e6",
            "",
            "\1\u00e7\37\uffff\1\u00e7",
            "\1\67\12\uffff\1\67\3\uffff\12\66\2\uffff\5\67\6\66\14\67"+
            "\1\u00e8\7\67\4\uffff\1\67\1\uffff\22\67\1\u00e8\7\67",
            "\1\u00e8\37\uffff\1\u00e8",
            "\1\u00e9\3\uffff\1\u00ea\1\uffff\1\u00eb\31\uffff\1\u00e9"+
            "\3\uffff\1\u00ea\1\uffff\1\u00eb",
            "\1\67\12\uffff\1\67\3\uffff\12\66\2\uffff\5\67\6\66\24\67"+
            "\4\uffff\1\67\1\uffff\32\67",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "\1\u00ef\37\uffff\1\u00ef",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "\1\u00f1\37\uffff\1\u00f1",
            "\1\u00f2\37\uffff\1\u00f2",
            "\1\u00f3\37\uffff\1\u00f3",
            "\1\u00f4\37\uffff\1\u00f4",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "",
            "",
            "\1\u00f8\37\uffff\1\u00f8",
            "\1\u00f9\37\uffff\1\u00f9",
            "",
            "",
            "",
            "",
            "",
            "\1\u00fa\37\uffff\1\u00fa",
            "\1\u00fb\37\uffff\1\u00fb",
            "\1\u00fc\37\uffff\1\u00fc",
            "\1\u00fd\37\uffff\1\u00fd",
            "\1\u00fe\37\uffff\1\u00fe",
            "\1\u00ff\37\uffff\1\u00ff",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "",
            "",
            "",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "",
            "\1\u0105\37\uffff\1\u0105",
            "\1\u0106\37\uffff\1\u0106",
            "\1\u0107\1\uffff\1\u0108",
            "\1\u0109\37\uffff\1\u0109",
            "\1\u010a\37\uffff\1\u010a",
            "",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "",
            "",
            "",
            "",
            "\1\u010d\37\uffff\1\u010d",
            "",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "\1\u010f\37\uffff\1\u010f",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "\1\u0111\37\uffff\1\u0111",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "",
            "",
            "",
            "\1\u0116\37\uffff\1\u0116",
            "",
            "\1\u0117\37\uffff\1\u0117",
            "\1\u0118\37\uffff\1\u0118",
            "\1\u0119\37\uffff\1\u0119",
            "\1\u011a\37\uffff\1\u011a",
            "",
            "",
            "",
            "\1\u011b\37\uffff\1\u011b",
            "\1\u011c\37\uffff\1\u011c",
            "\1\u011d\37\uffff\1\u011d",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "\1\u011f\37\uffff\1\u011f",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "",
            "",
            "",
            "",
            "",
            "\1\u0124\61\uffff\1\u0123",
            "\1\u0125\37\uffff\1\u0125",
            "",
            "",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "",
            "",
            "\1\u0128\37\uffff\1\u0128",
            "",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "",
            "\1\u012a\37\uffff\1\u012a",
            "",
            "",
            "",
            "",
            "\1\u012b\37\uffff\1\u012b",
            "\1\u012c\37\uffff\1\u012c",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "\1\u012e\37\uffff\1\u012e",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "\1\u0130\37\uffff\1\u0130",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "",
            "",
            "",
            "\1\u0134\37\uffff\1\u0134",
            "",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "",
            "",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "",
            "\1\u0137\37\uffff\1\u0137",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "",
            "",
            "",
            "\1\u013c\37\uffff\1\u013c",
            "",
            "",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
            "",
            "",
            "",
            "",
            "\1\u013e\37\uffff\1\u013e",
            "",
            "\1\u013f\37\uffff\1\u013f",
            "\1\u0140\37\uffff\1\u0140",
            "\1\67\12\uffff\1\67\3\uffff\12\67\2\uffff\37\67\4\uffff\1"+
            "\67\1\uffff\32\67",
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
            return "1:1: Tokens : ( CARRY_RESET | TorBranch | Branch_2 | CARRYSET | NcBranch | NoBranch | NsBranch | Branch | Branch_1 | SBranch | DNEGATE | NzExit | ASHIFT | EXTEND | NEGATE | RCLEAR | UNPACK | Create | ZExit | DROP_1 | OVER_1 | SWAP_1 | CELL | CELL_1 | CLEAR | COUNT | ERASE | FALSE | PLACE | RDROP | SHIFT | UNDER | ROT_1 | DUP_1 | DUP_2 | DABS | DROL | DROP | DROR | FILL | MOVE | OVER | PACK | SWAP | TRUE | TUCK | ST_1 | DigitZeroLessThanSignGreaterThanSign | DigitTwoAsteriskAsterisk | ABS | DEC | DUP | INC | LLD | LST | NIP | OFF | ROL | ROR | ROT | TLD | TST | D0 | Jsr | U2 | PlusSignExclamationMark | DigitZeroLessThanSign | DigitZeroEqualsSign | DigitOnePlusSign | DigitOneHyphenMinus | DigitTwoExclamationMark | DigitTwoAsterisk | DigitTwoSolidus | DigitTwoCommercialAt | R | L | L_1 | LD | ON | R_1 | ST | T | T_1 | R_2 | ExclamationMark | Asterisk | PlusSign | Comma | HyphenMinus | Solidus | Colon | Semicolon | CommercialAt | RULE_SL_COMMENT | RULE_INT | RULE_DOUBLE | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA18_32 = input.LA(1);

                        s = -1;
                        if ( ((LA18_32>='\u0000' && LA18_32<='\t')||(LA18_32>='\u000B' && LA18_32<='\f')||(LA18_32>='\u000E' && LA18_32<='\uFFFF')) ) {s = 141;}

                        else s = 45;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA18_0 = input.LA(1);

                        s = -1;
                        if ( (LA18_0=='C') ) {s = 1;}

                        else if ( (LA18_0=='T'||LA18_0=='t') ) {s = 2;}

                        else if ( (LA18_0=='0') ) {s = 3;}

                        else if ( (LA18_0=='N'||LA18_0=='n') ) {s = 4;}

                        else if ( (LA18_0=='?') ) {s = 5;}

                        else if ( (LA18_0=='S'||LA18_0=='s') ) {s = 6;}

                        else if ( (LA18_0=='D') ) {s = 7;}

                        else if ( (LA18_0=='A') ) {s = 8;}

                        else if ( (LA18_0=='E') ) {s = 9;}

                        else if ( (LA18_0=='R'||LA18_0=='r') ) {s = 10;}

                        else if ( (LA18_0=='U'||LA18_0=='u') ) {s = 11;}

                        else if ( (LA18_0=='Z'||LA18_0=='z') ) {s = 12;}

                        else if ( (LA18_0=='2') ) {s = 13;}

                        else if ( (LA18_0=='F') ) {s = 14;}

                        else if ( (LA18_0=='P'||LA18_0=='p') ) {s = 15;}

                        else if ( (LA18_0=='-') ) {s = 16;}

                        else if ( (LA18_0=='M'||LA18_0=='m') ) {s = 17;}

                        else if ( (LA18_0=='O'||LA18_0=='o') ) {s = 18;}

                        else if ( (LA18_0=='+') ) {s = 19;}

                        else if ( (LA18_0=='I'||LA18_0=='i') ) {s = 20;}

                        else if ( (LA18_0=='L'||LA18_0=='l') ) {s = 21;}

                        else if ( (LA18_0=='J'||LA18_0=='j') ) {s = 22;}

                        else if ( (LA18_0=='1') ) {s = 23;}

                        else if ( (LA18_0=='>') ) {s = 24;}

                        else if ( (LA18_0=='!') ) {s = 25;}

                        else if ( (LA18_0=='*') ) {s = 26;}

                        else if ( (LA18_0==',') ) {s = 27;}

                        else if ( (LA18_0=='/') ) {s = 28;}

                        else if ( (LA18_0==':') ) {s = 29;}

                        else if ( (LA18_0==';') ) {s = 30;}

                        else if ( (LA18_0=='@') ) {s = 31;}

                        else if ( (LA18_0=='(') ) {s = 32;}

                        else if ( (LA18_0=='c') ) {s = 33;}

                        else if ( (LA18_0=='d') ) {s = 34;}

                        else if ( (LA18_0=='a') ) {s = 35;}

                        else if ( (LA18_0=='e') ) {s = 36;}

                        else if ( (LA18_0=='f') ) {s = 37;}

                        else if ( ((LA18_0>='3' && LA18_0<='9')) ) {s = 38;}

                        else if ( (LA18_0=='B') ) {s = 39;}

                        else if ( (LA18_0=='^') ) {s = 40;}

                        else if ( ((LA18_0>='<' && LA18_0<='=')||(LA18_0>='G' && LA18_0<='H')||LA18_0=='K'||LA18_0=='Q'||(LA18_0>='V' && LA18_0<='Y')||LA18_0=='_'||LA18_0=='b'||(LA18_0>='g' && LA18_0<='h')||LA18_0=='k'||LA18_0=='q'||(LA18_0>='v' && LA18_0<='y')) ) {s = 41;}

                        else if ( (LA18_0=='\"') ) {s = 42;}

                        else if ( (LA18_0=='\'') ) {s = 43;}

                        else if ( ((LA18_0>='\t' && LA18_0<='\n')||LA18_0=='\r'||LA18_0==' ') ) {s = 44;}

                        else if ( ((LA18_0>='\u0000' && LA18_0<='\b')||(LA18_0>='\u000B' && LA18_0<='\f')||(LA18_0>='\u000E' && LA18_0<='\u001F')||(LA18_0>='#' && LA18_0<='&')||LA18_0==')'||LA18_0=='.'||(LA18_0>='[' && LA18_0<=']')||LA18_0=='`'||(LA18_0>='{' && LA18_0<='\uFFFF')) ) {s = 45;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA18_43 = input.LA(1);

                        s = -1;
                        if ( ((LA18_43>='\u0000' && LA18_43<='\uFFFF')) ) {s = 143;}

                        else s = 45;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA18_42 = input.LA(1);

                        s = -1;
                        if ( ((LA18_42>='\u0000' && LA18_42<='\uFFFF')) ) {s = 143;}

                        else s = 45;

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