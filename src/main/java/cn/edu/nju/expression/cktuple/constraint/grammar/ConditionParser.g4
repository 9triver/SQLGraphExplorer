parser grammar ConditionParser;

options {
    tokenVocab=ConditionLexer;
}

parse
 : expression? EOF
 ;

expression
 : basicExpression                                              #basicBlockExpression

 | parenExpression AND falseExpression                          #annulmentLawExpression
 | falseExpression AND parenExpression                          #annulmentLawExpression
 | parenExpression OR trueExpression                            #annulmentLawExpression
 | trueExpression OR parenExpression                            #annulmentLawExpression

 | parenExpression OR falseExpression                           #identityLawExpression
 | falseExpression OR parenExpression                           #identityLawExpression
 | parenExpression AND trueExpression                           #identityLawExpression
 | trueExpression AND parenExpression                           #identityLawExpression

 | leftOr=orExpression AND rightOr=orExpression                 #andDistributiveLawExpression
 | leftBasic=parenExpression AND rightOr=orExpression           #andDistributiveLawExpression
 | leftOr=orExpression AND rightBasic=parenExpression           #andDistributiveLawExpression
// | leftAnd=andExpression OR rightAnd=andExpression                #ordistributiveLawExpression
// | leftBasic=parenExpression OR rightAnd=andExpression                  #ordistributiveLawExpression
// | leftAnd=andExpression OR rightBasic=parenExpression                  #ordistributiveLawExpression

 | andExpression                                                #andAllExpression
 | orExpression                                                 #orAllExpression
 | parenExpression (AND parenExpression)+                       #andBasicExpression
 | parenExpression (OR parenExpression)+                        #orBasicExpression

 | notExpression                                                #notsExpression

 | parenExpression                                              #parensExpression
 ;

parenExpression
 : LPAREN parenExpression RPAREN                                #multiParenExpression
 | LPAREN expression RPAREN                                     #singleParenExpression
 ;

notExpression
 : NOT andExpression                                            #andDeMorganLawExpression
// | NOT orExpression                                             #deMorganLawExpression
 | NOT NOT parenExpression                                           #involutionLawExpression
 | NOT LPAREN NOT parenExpression RPAREN                             #involutionLawExpression
 | NOT parenExpression                                               #singleNotExpression
 ;

andExpression
 : LPAREN parenExpression (AND parenExpression)+ RPAREN
 ;

orExpression
 : LPAREN parenExpression (OR parenExpression)+ RPAREN
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

trueExpression
 : TRUE
 | LPAREN trueExpression RPAREN
 | NOT falseExpression
 ;

falseExpression
 : FALSE
 | LPAREN falseExpression RPAREN
 | NOT trueExpression
 ;


comparator
 : GT | GE | LT | LE | EQ
 ;

atom
 : (bool | IDENTIFIER | DECIMAL | PUNCTUATION)*
 ;

bool
 : trueExpression | falseExpression
 ;

identifer
 : IDENTIFIER
 ;