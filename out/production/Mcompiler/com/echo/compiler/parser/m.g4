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
    :   typeSpecifier Identifier '(' formalParameters? ')' blockStat
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
    |   type = 'void'
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
    :   'if' cond = expr  thenbody = stat ('else' elsebody = stat)?
    ;

iterationStat
    :   'while' '(' cond = expr ')' whilebody = stat                                                #while
    |   'for' '(' init = expr? ';' cond = expr?  ';' step = expr? ')' forbody = stat                #for
    |   'for' '(' declinit = variableDeclare  cond = expr? ';' step = expr? ')' forbody = stat      #for
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
    |   nonArrayTypeSpecifier                                                   # creatorNonArray
    ;

//constant
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

Identifier
    :   Letter (Nondigit|Digit)*
    ;

fragment
Letter
    :   [a-zA-Z]
    ;

fragment
Nondigit
    :   [a-zA-Z_]
    ;

fragment
Digit
    :   [0-9]
    ;

IntegerConstant                             //not set to negative Numbers
    :   NonzeroDigit Digit*
    |   '0'
    ;

CharacterConstant
    :   '\'' CCharSequence '\''
    ;

StringLiteral
    :   '"' SCharSequence? '"'
    ;

NullLiteral
    :   'null'
    ;

LogicalConstant
    :   'true'
    |   'false'
    ;

fragment
NonzeroDigit
    :   [1-9]
    ;

fragment
CCharSequence
    :   CChar+
    ;

fragment
CChar
    :   ~['\\\r\n]
    |   EscapeSequence
    ;

fragment
EscapeSequence
    :   SimpleEscapeSequence
    ;

fragment
SimpleEscapeSequence
    :   '\\' ['"?abfnrtv\\]
    ;

fragment
SCharSequence
    :   SChar+
    ;

fragment
SChar
    :   ~["\\\r\n]
    |   EscapeSequence
    ;

Whitespace
    :   [ \t]+  -> skip
    ;

Newline
    :   '\r'?'\n'    -> skip
    ;

BlockComment
    :   '/*' .*? '*/'   -> skip
    ;

LineComment
    :   '//' ~[\r\n]*   -> skip
    ;