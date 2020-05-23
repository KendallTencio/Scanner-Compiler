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

/*
(\"({L}|{D}|{espacio}|(\\u{H}{H}{H}{H})|(\\x{H}{H})|(\\n)|(\\t)|(\\r))*\")| ('({L}|{D}|{espacio}|(\\u{H}{H}{H}{H})|(\\x{H}{H})|(\\n)|(\\t)|(\\r))*') {lexeme=yytext(); return Literal;}
*/
('([^(\n)(\\n)(\\t)(\\r)]|(\\n)|(\\t)|(\\r))*')|(\"([^(\n)(\\n)(\\t)(\\r)]|(\\n)|(\\t)|(\\r))*\") {lexeme=yytext(); return Literal;}

{FL} {lexeme=yytext(); return Literal;}

address|as|bool|break|byte|bytes|constructor|
continue|contract|delete|do|else|enum|false|
for|from|function|hex|if|import|int|internal|
mapping|modifier|payable|Pragma|private|public|
return|returns|solidity|string|struct|this|true|
ufixed|uint|var|view|while {lexeme=yytext(); return Reservadas;}

int8|int16|int24|int32|int40|int48|int56|int64|int72|
int80|int88|int96|int104|int112|int120|int128|int136|
int144|int152|int160|int168|int176|int184|int192|int200|
int208|int216|int224|int232|int240|int248|int256 {lexeme=yytext(); return Reservadas;}

uint|uint8|uint16|uint24|uint32|uint40|uint48|uint56|
uint64|uint72|uint80|uint88|uint96|uint104|uint112|
uint120|uint128|uint136|uint144|uint152|uint160|uint168|
uint176|uint184|uint192|uint200|uint208|uint216|uint224|
uint232|uint240|uint248|uint256 {lexeme=yytext(); return Reservadas;}

bytes|bytes1|bytes2|bytes3|bytes4|bytes5|bytes6|bytes7|
bytes8|bytes9|bytes10|bytes11|bytes12|bytes13|bytes14|
bytes15|bytes16|bytes17|bytes18|bytes19|bytes20|bytes21|
bytes22|bytes23|bytes24|bytes25|bytes26|bytes27|bytes28|
bytes29|bytes30|bytes31|bytes32 {lexeme=yytext(); return Reservadas;}

balance|call|callcode|delegate|call|send|transfer {lexeme=yytext(); return Transac;}

days|ether|finney|hours|minutes|seconds|szabo|weeks|wei|years {lexeme=yytext(); return Units;}

{espacio} {/*Ignore*/}

"//".* {/*Ignore*/}
"/*"( [^*] | (\*+[^*/]) )*\*+\/ {/*Ignore*/}

"!="|"&&"|"=="|"!"|"|"|"<="|"<<"|">="|">>"|
"**"|"/"|"%"|"*"|"<"|">"|","|";"|"."|"("|")"|
"["|"]"|"?"|":"|"{"|"}"|"+="|"-="|"*="|"/="|"&"|
"^"|"~"|"+"|"-"|"=" {lexeme=yytext(); return Operador;}
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}

("-"{D}+"")|{D}+ {lexeme=yytext(); return Literal;}
(("-"{D}+"")|{D}+){E}(("-"{D}+"")|{D}+) {lexeme=yytext(); return Literal;}
/*
(\"(({espacio})*({L}|{D})*({espacio})*({L}|{D})*({espacio})*)*\")|('({L}|{D})') {lexeme=yytext(); return Literal;}
*/

{D}+([^( )(\n)(\t)(\r)(!=)(&&)(==)(!)(|)(<=)(<<)(>=)(>>)(**)(/)(%)(*)(<)(>)(,)(;)(.)("(")(")")("[")("]")(?)(:)({)(})(+=)(-=)(*=)(/=)(&)("^")(~)(+)("-")(=)])* {lexeme=yytext(); return ERROR_Identificador;}
 . {return ERROR;}
