parser grammar ConditionParser;

options {
    tokenVocab=ConditionLexer;
}

parse
 : expression? EOF
 ;

expression
 : LPAREN parenExpression RPAREN                                #multiParenExpression
 | parenExpression                                              #singleParenExpression

// Involution Law	(A’)’ = A
 | NOT LPAREN* NOT expression RPAREN*                           #involutionLawExpression

 | NOT expression                                               #notExpression

 | andExpression                                                #andAllExpression
 | orExpression                                                 #orAllExpression
 | expression (AND expression)+                                 #andBasicExpression
 | expression (OR expression)+                                  #orBasicExpression


 | expression AND result=FALSE                                  #annulmentLawExpression
 | result=FALSE AND expression                                  #annulmentLawExpression
 | expression OR result=TRUE                                    #annulmentLawExpression
 | result=TRUE OR expression                                    #annulmentLawExpression

 | expression OR FALSE                                          #identityLawExpression
 | FALSE OR expression                                          #identityLawExpression
 | expression AND TRUE                                          #identityLawExpression
 | TRUE AND expression                                          #identityLawExpression

 | leftOr=orExpression AND rightOr=orExpression                 #andDistributiveLawExpression
 | leftBasic=basicExpression AND rightOr=orExpression           #andDistributiveLawExpression
 | leftOr=orExpression AND rightBasic=basicExpression           #andDistributiveLawExpression
// | andExpression OR andExpression                               #ordistributiveLawExpression
// | left=basicExpression OR rigth=andExpression                  #ordistributiveLawExpression
// | left=andExpression OR rigth=basicExpression                  #ordistributiveLawExpression

 | not=NOT andExpression                                        #andDeMorganLawExpression
// | NOT orExpression                                             #deMorganLawExpression

 | basicExpression                                              #basicBlockExpression
 ;

parenExpression
 : LPAREN expression RPAREN
 ;

andExpression
 : LPAREN expression (AND expression)+ RPAREN
 ;

orExpression
 : LPAREN expression (OR expression)+ RPAREN
 ;

basicExpression
 : left=basicExpression op=comparator right=basicExpression     #compareExpression
 | bool                                                         #boolExpression
 | funcExpression                                               #functionExpression
 | colExpression                                                #columnExpression
 | atom                                                         #atomExpression
 ;

funcExpression
 : functionName LPAREN expression (COMMA expression)* RPAREN
 ;

colExpression
 : table=identifer DOT column=identifer
 ;

functionName
 : identifer
 ;

comparator
 : GT | GE | LT | LE | EQ
 ;

atom
 : (bool | IDENTIFIER | DECIMAL | PUNCTUATION)*
 ;

bool
 : TRUE | FALSE
 ;

identifer
 : IDENTIFIER
 ;