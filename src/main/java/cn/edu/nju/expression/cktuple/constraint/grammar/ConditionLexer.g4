lexer grammar ConditionLexer;

options {
    caseInsensitive = true;
}

AND        : 'AND' ;
OR         : 'OR' ;
NOT        : 'NOT';
TRUE       : 'TRUE' ;
FALSE      : 'FALSE' ;
GT         : '>' ;
GE         : '>=' ;
LT         : '<' ;
LE         : '<=' ;
EQ         : '=' ;
LPAREN     : '(' ;
RPAREN     : ')' ;
COMMA      : ',' ;
DOT        : '.' ;
DECIMAL    : '-'? [0-9]+ ( '.' [0-9]+ )? ;
IDENTIFIER : [a-zA-Z_] [a-zA-Z_0-9]* ;
PUNCTUATION: COMMA|DOT|'\''|'/'|';'|'['|']'|'-'|'+'|'\\'|'@'|'#'|'$'|'%'|'^'|'&'|'*'|LPAREN|RPAREN|'`'|'~'|'{'|'}';
WS         : [ \r\t\u000C\n]+ -> skip;