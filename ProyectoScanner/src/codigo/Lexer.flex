package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
E = "e"
H=[0-9a-fA-F]+

FL = [-]? ({FL1}|{FL2}|{FL3}|{FL4}){EX}?
FL1 = [0-9]+ \. [0-9]* 
FL2 = \. [0-9]+ 
FL3 = [0-9]+ \.
FL4 = \. [0-9]+ [eE] [+-]? [0-9]+
EX = [0-9]+ [eE] [+-]? [0-9]+
espacio=[ ,\t,\r]+
%{
    public String lexeme;
%}

%%
(hex\"{H}{H}{H}{H}{H}{H}{H}{H}\")|(hex'{H}{H}{H}{H}{H}{H}{H}{H}') {lexeme=yytext(); return Literal;}
"\n" {return Linea;}
\"({L}|{D}|{espacio}|(\\u{H}{H}{H}{H})|(\\x{H}{H})|(\\n)|(\\t)|(\\r))*\" {lexeme=yytext(); return Literal;}
{FL} {lexeme=yytext(); return Literal;}
address|as|bool|break|byte|bytes|constructor|
continue|contract|delete|do|else|enum|false|
for|from|function|hex|if|import|int|internal|
mapping|modifier|payable|Pragma|private|public|
return|returns|solidity|string|struct|this|true|
ufixed|uint|var|view|while|uint8|uint32|int16|
bytes4|bytes8|exc {lexeme=yytext(); return Reservadas;}
balance|call|callcode|delegate|call|send|transfer {lexeme=yytext(); return Transac;}
days|ether|finney|hours|minutes|seconds|szabo|weeks|wei|years {lexeme=yytext(); return Units;}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"/*"("\n"|{L}|{D}|{espacio})*"*/" {/*Ignore*/}
"!="|"&&"|"=="|"!"|"|"|"<="|"<<"|">="|">>"|
"**"|"/"|"%"|"*"|"<"|">"|","|";"|"."|"("|")"|
"["|"]"|"?"|":"|"{"|"}"|"+="|"-="|"*="|"/="|"&"|
"^"|"~"|"+"|"-"|"=" {lexeme=yytext(); return Operador;}
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}

("-"{D}+"")|{D}+ {lexeme=yytext(); return Literal;}
(("-"{D}+"")|{D}+){E}(("-"{D}+"")|{D}+) {lexeme=yytext(); return Literal;}

(\"(({espacio})*({L}|{D})*({espacio})*({L}|{D})*({espacio})*)*\")|('({L}|{D})') {lexeme=yytext(); return Literal;} 
 . {return ERROR;}