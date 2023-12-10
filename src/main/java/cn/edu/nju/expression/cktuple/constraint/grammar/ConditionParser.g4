parser grammar ConditionParser;

options {
    tokenVocab=ConditionLexer;
}

parse
 : expression? EOF
 ;

expression
 : LPAREN expression RPAREN                                     #parenExpression
 | NOT expression                                               #notExpression
 | left=expression op=comparator right=expression               #comparatorExpression
 | left=expression op=AND right=expression                      #andExpression
 | left=expression op=OR right=expression                       #orExpression
 | bool                                                         #boolExpression
 | functionName LPAREN expression (COMMA expression)* RPAREN    #functionExpression
 | table=identifer DOT column=identifer                         #columnExpression
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