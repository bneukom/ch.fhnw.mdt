
/*
 * generated by Xtext
 */
lexer grammar InternalUForthLexer;


@header {
package ch.fhnw.mdt.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}




CARRY_RESET : ('C'|'c')('A'|'a')('R'|'r')('R'|'r')('Y'|'y')'_'('R'|'r')('E'|'e')('S'|'s')('E'|'e')('T'|'t');

TorBranch : ('T'|'t')('O'|'o')('R'|'r')'-'('B'|'b')('R'|'r')('A'|'a')('N'|'n')('C'|'c')('H'|'h');

Branch_2 : '0''<''>'('B'|'b')('R'|'r')('A'|'a')('N'|'n')('C'|'c')('H'|'h');

CARRYSET : ('C'|'c')('A'|'a')('R'|'r')('R'|'r')('Y'|'y')'-'('S'|'s')('E'|'e')('T'|'t');

NcBranch : ('N'|'n')('C'|'c')'-'('B'|'b')('R'|'r')('A'|'a')('N'|'n')('C'|'c')('H'|'h');

NoBranch : ('N'|'n')('O'|'o')'-'('B'|'b')('R'|'r')('A'|'a')('N'|'n')('C'|'c')('H'|'h');

NsBranch : ('N'|'n')('S'|'s')'-'('B'|'b')('R'|'r')('A'|'a')('N'|'n')('C'|'c')('H'|'h');

Branch : '0''='('B'|'b')('R'|'r')('A'|'a')('N'|'n')('C'|'c')('H'|'h');

Branch_1 : '?''-'('B'|'b')('R'|'r')('A'|'a')('N'|'n')('C'|'c')('H'|'h');

SBranch : ('S'|'s')'-'('B'|'b')('R'|'r')('A'|'a')('N'|'n')('C'|'c')('H'|'h');

DNEGATE : ('D'|'d')('N'|'n')('E'|'e')('G'|'g')('A'|'a')('T'|'t')('E'|'e');

NzExit : ('N'|'n')('Z'|'z')'-'('E'|'e')('X'|'x')('I'|'i')('T'|'t');

ASHIFT : ('A'|'a')('S'|'s')('H'|'h')('I'|'i')('F'|'f')('T'|'t');

EXTEND : ('E'|'e')('X'|'x')('T'|'t')('E'|'e')('N'|'n')('D'|'d');

NEGATE : ('N'|'n')('E'|'e')('G'|'g')('A'|'a')('T'|'t')('E'|'e');

RCLEAR : ('R'|'r')('C'|'c')('L'|'l')('E'|'e')('A'|'a')('R'|'r');

UNPACK : ('U'|'u')('N'|'n')('P'|'p')('A'|'a')('C'|'c')('K'|'k');

Create : ('C'|'c')('R'|'r')('E'|'e')('A'|'a')('T'|'t')('E'|'e');

ZExit : ('Z'|'z')'-'('E'|'e')('X'|'x')('I'|'i')('T'|'t');

DROP_1 : '2'('D'|'d')('R'|'r')('O'|'o')('P'|'p');

OVER_1 : '2'('O'|'o')('V'|'v')('E'|'e')('R'|'r');

SWAP_1 : '2'('S'|'s')('W'|'w')('A'|'a')('P'|'p');

CELL : ('C'|'c')('E'|'e')('L'|'l')('L'|'l')'+';

CELL_1 : ('C'|'c')('E'|'e')('L'|'l')('L'|'l')'-';

CLEAR : ('C'|'c')('L'|'l')('E'|'e')('A'|'a')('R'|'r');

COUNT : ('C'|'c')('O'|'o')('U'|'u')('N'|'n')('T'|'t');

ERASE : ('E'|'e')('R'|'r')('A'|'a')('S'|'s')('E'|'e');

FALSE : ('F'|'f')('A'|'a')('L'|'l')('S'|'s')('E'|'e');

PLACE : ('P'|'p')('L'|'l')('A'|'a')('C'|'c')('E'|'e');

RDROP : ('R'|'r')('D'|'d')('R'|'r')('O'|'o')('P'|'p');

SHIFT : ('S'|'s')('H'|'h')('I'|'i')('F'|'f')('T'|'t');

UNDER : ('U'|'u')('N'|'n')('D'|'d')('E'|'e')('R'|'r');

ROT_1 : '-'('R'|'r')('O'|'o')('T'|'t');

DUP_1 : '2'('D'|'d')('U'|'u')('P'|'p');

DUP_2 : '?'('D'|'d')('U'|'u')('P'|'p');

DABS : ('D'|'d')('A'|'a')('B'|'b')('S'|'s');

DROL : ('D'|'d')('R'|'r')('O'|'o')('L'|'l');

DROP : ('D'|'d')('R'|'r')('O'|'o')('P'|'p');

DROR : ('D'|'d')('R'|'r')('O'|'o')('R'|'r');

FILL : ('F'|'f')('I'|'i')('L'|'l')('L'|'l');

MOVE : ('M'|'m')('O'|'o')('V'|'v')('E'|'e');

OVER : ('O'|'o')('V'|'v')('E'|'e')('R'|'r');

PACK : ('P'|'p')('A'|'a')('C'|'c')('K'|'k');

SWAP : ('S'|'s')('W'|'w')('A'|'a')('P'|'p');

TRUE : ('T'|'t')('R'|'r')('U'|'u')('E'|'e');

TUCK : ('T'|'t')('U'|'u')('C'|'c')('K'|'k');

ST_1 : '+'('S'|'s')('T'|'t');

DigitZeroLessThanSignGreaterThanSign : '0''<''>';

DigitTwoAsteriskAsterisk : '2''*''*';

ABS : ('A'|'a')('B'|'b')('S'|'s');

DEC : ('D'|'d')('E'|'e')('C'|'c');

DUP : ('D'|'d')('U'|'u')('P'|'p');

INC : ('I'|'i')('N'|'n')('C'|'c');

LLD : ('L'|'l')('L'|'l')('D'|'d');

LST : ('L'|'l')('S'|'s')('T'|'t');

NIP : ('N'|'n')('I'|'i')('P'|'p');

OFF : ('O'|'o')('F'|'f')('F'|'f');

ROL : ('R'|'r')('O'|'o')('L'|'l');

ROR : ('R'|'r')('O'|'o')('R'|'r');

ROT : ('R'|'r')('O'|'o')('T'|'t');

TLD : ('T'|'t')('L'|'l')('D'|'d');

TST : ('T'|'t')('S'|'s')('T'|'t');

D0 : ('D'|'d')'0''=';

Jsr : ('J'|'j')('S'|'s')('R'|'r');

U2 : ('U'|'u')'2''/';

PlusSignExclamationMark : '+''!';

DigitZeroLessThanSign : '0''<';

DigitZeroEqualsSign : '0''=';

DigitOnePlusSign : '1''+';

DigitOneHyphenMinus : '1''-';

DigitTwoExclamationMark : '2''!';

DigitTwoAsterisk : '2''*';

DigitTwoSolidus : '2''/';

DigitTwoCommercialAt : '2''@';

R : '>'('R'|'r');

L : ('L'|'l')'!';

L_1 : ('L'|'l')'@';

LD : ('L'|'l')('D'|'d');

ON : ('O'|'o')('N'|'n');

R_1 : ('R'|'r')'@';

ST : ('S'|'s')('T'|'t');

T : ('T'|'t')'!';

T_1 : ('T'|'t')'@';

R_2 : ('R'|'r')'>';

ExclamationMark : '!';

Asterisk : '*';

PlusSign : '+';

Comma : ',';

HyphenMinus : '-';

Solidus : '/';

Colon : ':';

Semicolon : ';';

CommercialAt : '@';



fragment RULE_DIGIT : '0'..'9';

fragment RULE_DECINT : RULE_DIGIT+;

RULE_SL_COMMENT : '(' ~(('\n'|'\r'))* ')' RULE_WS*;

RULE_INT : '-'? ('0'..'9'|'A'..'F')+;

RULE_DOUBLE : RULE_DECINT ('.' RULE_DIGIT*|('.' RULE_DIGIT*)? ('E'|'e') ('-'|'+')? RULE_DECINT);

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_'|'!'|'@'|'?'|','|'<'|'>'|'=') ('a'..'z'|'A'..'Z'|'_'|'!'|'?'|'@'|'<'|'>'|'0'..'9'|','|'=')*;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;



