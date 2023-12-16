parser grammar SpliterParser;

options {
    tokenVocab=SpliterLexer;
}

parse
 : rootExpression? EOF
 ;

rootExpression
 : multiAndsExpression                                      #rootAndsExpression
 | multiOrsExpression                                       #rootOrsExpression
 | LPAREN rootExpression RPAREN                             #multiRootExpression
 | orSplitExpression                                        #orSplitsExression
 | expression                                               #cantSplitExpression
 ;

orSplitExpression
 : LPAREN orSplitExpression RPAREN                          #orSplitParenExpression
 | orSplitExpression OR orSplitExpression                   #orSplitRecursiveExpression
 | unitExpression (OR unitExpression)+                      #orSplitBasicExpression
 ;

expression
 : multiAndsExpression                                      #andsExpression
 | multiOrsExpression                                       #orsExpression

 | basicExpression                                          #basicBlockExpression

 | parenExpression                                          #parensExpression
 | expression AND expression                                #andExpression
 | expression OR expression                                 #orExpression
 | NOT expression                                           #notExpression
 ;

multiAndsExpression
 : LPAREN multiAndsExpression AND expression RPAREN                      #multiAndsRecursiveExpression
 | LPAREN expression AND multiAndsExpression RPAREN                      #multiAndsRecursiveExpression
 | LPAREN LPAREN expression AND expression RPAREN AND expression RPAREN  #multiAndsBasicExpression
 | LPAREN expression AND LPAREN expression AND expression RPAREN RPAREN  #multiAndsBasicExpression
 ;

multiOrsExpression
 : LPAREN multiOrsExpression OR expression RPAREN                        #multiOrsRecursiveExpression
 | LPAREN expression OR multiOrsExpression RPAREN                        #multiOrsRecursiveExpression
 | LPAREN LPAREN expression OR expression RPAREN OR expression RPAREN    #multiOrsBasicExpression
 | LPAREN expression OR LPAREN expression OR expression RPAREN RPAREN    #multiOrsBasicExpression
 ;

parenExpression
 : LPAREN parenExpression RPAREN                                         #multiParenExpression
 | LPAREN expression RPAREN                                              #singleParenExpression
 ;

unitExpression
 : basicExpression                                                       #unitBasicExpression
 | parenExpression                                                       #unitParenExpression
 ;

basicExpression
 : LPAREN basicExpression RPAREN                                         #parenBasicExpression
 | left=basicExpression op=comparator right=basicExpression              #compareExpression
 | bool                                                                  #boolExpression
 | funcExpression                                                        #functionExpression
 | colExpression                                                         #columnExpression
 | atom                                                                  #atomExpression
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