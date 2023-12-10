grammar Constraint;

parse
 : expression EOF
 ;

expression
 : LPAREN expression RPAREN                                     #parenExpression
 | NOT expression                                               #notExpression
 | left=expression op=comparator right=expression               #comparatorExpression
 | left=expression op=AND right=expression                      #andExpression
 | left=expression op=OR right=expression                       #orExpression
 | bool                                                         #boolExpression
 | functionName LPAREN expression (',' expression)* RPAREN      #functionExpression
 | table=identifer '.' column=identifer                         #columnExpression
 | (IDENTIFIER | DECIMAL | PUNCTUATION)*                        #atomExpression
 ;

functionName
    : identifer
    ;

comparator
 : GT | GE | LT | LE | EQ
 ;

binary
 : AND | OR
 ;

bool
 : TRUE | FALSE
 ;

identifer
 : IDENTIFIER
 ;

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
DECIMAL    : '-'? [0-9]+ ( '.' [0-9]+ )? ;
IDENTIFIER : [a-zA-Z_] [a-zA-Z_0-9]* ;
PUNCTUATION: ','|'.'|'\''|'/'|';'|'['|']'|'-'|'+'|'\\'|'@'|'#'|'$'|'%'|'^'|'&'|'*'|LPAREN|RPAREN|'`'|'~'|'{'|'}';
WS         : [ \r\t\u000C\n]+ -> skip;