package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
%{
    public String lexeme;
%}
%%
address|as|bool|break|byte|bytes|constructor|
continue|contract|delete|do|else|enum|false|
for|from|function|hex|if|import|int|internal|
mapping|modifier|payable|Pragma|private|public|
return|returns|solidity|string|struct|this|true|
ufixed|uint|var|view|while|uint8|uint32|int16|
bytes4|bytes8|exc {lexeme=yytext(); return Reservadas;}
balance|call|callcode|delegate|call|send|transfer {return Transac;}
days|ether|finney|hours|minutes|seconds|szabo|weeks|wei|years {return Units;}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"+"|"-"|"*"|"/"|"=" {return Operador;}
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Literal;}
 . {return ERROR;}