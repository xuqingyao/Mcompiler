grammar m;

program
    :   programBody*EOF
    ;

//program structure
programBody
    :   functionDeclare
    |   classDeclare
    |   variableDeclare
    ;

functionDeclare
    :   functype? Identifier '(' formalParameters? ')' blockStat
    ;

functype
    :   typeSpecifier
    |   'void'
    ;

formalParameters
    :   formalParameter (',' formalParameter)*
    ;

formalParameter
    :   typeSpecifier Identifier
    ;

classDeclare
    :   'class' Identifier '{' classBody* '}'
    ;

classBody
    :   functionDeclare
    |   variableDeclare
    ;

variableDeclare
    :   typeSpecifier variableDeclarator (',' variableDeclarator)* ';'
    ;


variableDeclarator
    :    Identifier ('=' expr)?
    ;

typeSpecifier
    :   typeSpecifier '[' ']'
    |   nonArrayTypeSpecifier                  
    ;

nonArrayTypeSpecifier
    :   type = 'bool'
    |   type = 'int'
    |   type = 'string'
    |   type = Identifier
    ;

stat
    :   blockStat                           #block
    |   expressionStat                      #expression
    |   ifStat                              #if
    |   iterationStat                       #iter
    |   jumpStat                            #jump
    ;

blockStat
    :  '{' blockItemList* '}'
    ;

blockItemList
    :   stat                                #statement
    |   variableDeclare                     #variableDec
    ;

expressionStat
    :   expr? ';'
    ;

ifStat
    :   'if' '(' cond = expr ')' thenbody = stat ('else' elsebody = stat)?
    ;

iterationStat
    :   'while' '(' cond = expr ')' whilebody = stat                                                #while
    |   'for' '(' init = expr? ';' cond = expr?  ';' step = expr? ')' forbody = stat                #for
    ;

jumpStat
    :   'continue' ';'                                          #continue
    |   'break' ';'                                             #break
    |   'return' expr? ';'                                      #return
    ;

expr
    :   array = expr '[' sub = expr ']'                         #subscriptExpr
    |   expr '(' exprs? ')'                                     #funccallExpr
    |   expr '.' Identifier                                     #memAccessExpr
    |   expr op = ('++'|'--')                                   #suffixExpr
    |   <assoc = right> op = ('++'|'--') expr                   #prefixExpr
    |   <assoc = right> op = ('+'|'-') expr                     #prefixExpr
    |   <assoc = right> op = '!' expr                           #prefixExpr
    |   <assoc = right> op = '~' expr                           #prefixExpr
    |   <assoc = right> 'new' creator                           #newExpr
    |   lhs = expr op = ('*'|'/'|'%') rhs = expr                #binaryExpr
    |   lhs = expr op = ('+'|'-') rhs = expr                    #binaryExpr
    |   lhs = expr op = ('<<'|'>>') rhs = expr                  #binaryExpr
    |   lhs = expr op = ('>'|'>='|'<'|'<=') rhs = expr          #binaryExpr
    |   lhs = expr op = ('=='|'!=') rhs = expr                  #binaryExpr
    |   lhs = expr op = '&' rhs = expr                          #binaryExpr
    |   lhs = expr op = '^' rhs = expr                          #binaryExpr
    |   lhs = expr op = '|' rhs = expr                          #binaryExpr
    |   lhs = expr op = '&&' rhs = expr                         #binaryExpr
    |   lhs = expr op = '||' rhs = expr                         #binaryExpr
    |   <assoc = right> lhs = expr op = '=' rhs = expr          #assignExpr
    |   Identifier                                              #identifierExpr
    |   This                                                    #thisExpr
    |   constant                                                #constantExpr
    |   '(' expr ')'                                            #subExpr
    ;

exprs
    :   expr (',' expr)*
    ;

creator
    :   nonArrayTypeSpecifier ('[' expr ']') + ('[' ']') + ('[' expr ']')+      # creatorError
    |   nonArrayTypeSpecifier ('[' expr ']') + ('[' ']')*                       # creatorArray
    |   nonArrayTypeCreator                                                     # creatorNonArray
    ;

nonArrayTypeCreator
    :   'int'
    |   'bool'
    |   'string'
    |   Identifier ('(' ')')?
    ;

constant
    :   type = LogicalConstant
    |   type = IntegerConstant
    |   type = StringLiteral
    |   type = NullLiteral
    ;

//reserved words
Bool : 'bool';
Int : 'int';
String : 'string';
fragment Null : 'null';
Void : 'void';
fragment True : 'true';
fragment False : 'false';
If : 'if';
For : 'for';
While : 'while';
Break : 'break';
Continue : 'continue';
Return : 'return';
New : 'new';
Class : 'class';
This : 'this';

//operator
//arithmetic operator
Plus : '+';
Minus : '-';
Star : '*';
Div : '/';
Mod : '%';

//relational operator
Less : '<';
Greater : '>';
Equal : '==';
NotEqual : '!=';
LessEqual : '<=';
GreaterEqual : '>=';

//logical operator
AndAnd : '&&';
OrOr : '||';
Not : '!';

//bitwise operator
LeftShift : '<<';
RightShift : '>>';
Tilde : '~';
Or : '|';
Caret : '^';
And : '&';

//assigning operator
Assign : '=';

//increment operator and subtraction operator
PlusPlus : '++';
MinusMinus : '--';

//Component operator
Dot : '.';

//subscript operator
LeftBracket : '[';
RightBracket : ']';

//bracket
LeftParen : '(';
RightParen : ')';
LeftBrace : '{';
RightBrace : '}';

Question : '?';
Colon : ':';
Semi : ';';
Comma : ',';

//constant
IntegerConstant
    :   [1-9] [0-9]*
    |   '0'
    ;

StringLiteral
    :   '"' StringCharacter* '"'
    ;

fragment StringCharacter
    :   ~["\\\r\n]
    |   '\\' ["n\\]
    ;

NullLiteral
    :   Null
    ;

LogicalConstant
    :   True
    |   False
    ;

Identifier
    :   IdentifierNonDigitUnderline (IdentifierNonDigit | Digit)*
    ;

fragment IdentifierNonDigitUnderline
    :   [a-zA-Z]
    ;

fragment IdentifierNonDigit
    :   [a-zA-Z_]
    ;

fragment Digit
    :   [0-9]
    ;

//skip
WhiteSpace
    :   [ \t]+ -> skip
    ;

NewLine
    :   '\r'? '\n' -> skip
    ;

LineComment
    :   '//' ~[\r\n]* -> skip
    ;

BlockComment
    :   '/*' .*? '*/' -> skip
    ;