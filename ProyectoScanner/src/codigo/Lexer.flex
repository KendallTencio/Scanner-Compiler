package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
%line
L=[a-zA-Z_]+
E = "e"
H=[0-9a-fA-F]+

FL = ({FL1}|{FL2}|{FL3}|{Cient1}|{Cient2}|{Cient3})
FL1 = [0-9]+ \. [0-9]*
FL2 = \. [0-9]+
FL3 = [0-9]+
Cient1 = \. [0-9]+ [eE] [+-]? [0-9]+
Cient2 = [0-9]+ [eE] [+-]? [0-9]+
Cient3 = [0-9]+ \. [0-9]+ [eE] [+-]? [0-9]+
espacio=[ \n,\t,\r]+

CientError = ({CientE1}|{CientE2}|{CientE3}|{CientE4}|{CientE5}|{CientE6})
CientE1 = \. [0-9]+ [eE] [+-]? [0-9]+ \. [0-9]*?
CientE2 = [0-9]+ [eE] [+-]? [0-9]+ \. [0-9]*?
CientE3 = [0-9]+ \. [0-9]+ [eE] [+-]? [0-9]+ \. [0-9]*?
CientE4 = [0][0] \. [0-9]+ [eE] [+-]? [0-9]+ 
CientE5 = [0][0-9]+ [eE] [+-]? [0-9]+ 
CientE6 = [0][0-9]+ \. [0-9]+ [eE] [+-]? [0-9]+ 

FLE = ({FLE1}|{FLE2}|{FLE4})
FLE1 = [0][0-9]+ \. [0-9]*
FLE2 = [0][0] \. [0-9]+
FLE4 = [0][0-9]*

%{
    public String lexeme;
    public int linea(){return yyline+1;};
%}

%%
"/*"|"*/" {return ERROR_Comentario;}
{FLE} { lexeme=yytext(); return ERROR_LiteralCero;}
{CientError} { lexeme=yytext(); return ERROR_NotacionCientifica;}
{FL3}([^( )(\n)(\t)(\r)(!=)(&&)(==)(!)(|)(<=)(<<)(>=)(>>)(**)(/)(%)(*)(<)(>)(,)(;)(.)("(")(")")("[")("]")(?)(:)({)(})(+=)(-=)(*=)(/=)(&)("^")(~)(+)("-")(=)])* { lexeme=yytext(); return ERROR_Identificador;}


(hex\"{H}{H}{H}{H}{H}{H}{H}{H}\")|(hex'{H}{H}{H}{H}{H}{H}{H}{H}') { lexeme=yytext(); return Literal;}

('([^(\n)(')])*')|(\"([^(\n)(\")])*\") { lexeme=yytext(); return Literal;}
("/*"([^])*"*/") {/*Ignore*/}


{FL} { lexeme=yytext(); return Literal;}


address|as|bool|break|byte|bytes|constructor|
continue|contract|delete|do|else|enum|false|
for|from|function|hex|if|import|int|internal|
mapping|modifier|payable|Pragma|private|public|
return|returns|solidity|string|struct|this|true|
ufixed|uint|var|view|while { lexeme=yytext(); return Reservadas;}

int8|int16|int24|int32|int40|int48|int56|int64|int72|
int80|int88|int96|int104|int112|int120|int128|int136|
int144|int152|int160|int168|int176|int184|int192|int200|
int208|int216|int224|int232|int240|int248|int256 { lexeme=yytext(); return Reservadas;}

uint|uint8|uint16|uint24|uint32|uint40|uint48|uint56|
uint64|uint72|uint80|uint88|uint96|uint104|uint112|
uint120|uint128|uint136|uint144|uint152|uint160|uint168|
uint176|uint184|uint192|uint200|uint208|uint216|uint224|
uint232|uint240|uint248|uint256 { lexeme=yytext(); return Reservadas;}

bytes|bytes1|bytes2|bytes3|bytes4|bytes5|bytes6|bytes7|
bytes8|bytes9|bytes10|bytes11|bytes12|bytes13|bytes14|
bytes15|bytes16|bytes17|bytes18|bytes19|bytes20|bytes21|
bytes22|bytes23|bytes24|bytes25|bytes26|bytes27|bytes28|
bytes29|bytes30|bytes31|bytes32 { lexeme=yytext(); return Reservadas;}

balance|call|callcode|delegate|call|send|transfer { lexeme=yytext(); return Transac;}

days|ether|finney|hours|minutes|seconds|szabo|weeks|wei|years { lexeme=yytext(); return Units;}

{espacio} {/*Ignore*/}

"//".* {/*Ignore*/}
//"/*"( [^*] | (\*+[^*/]) )*\*+\/ {/*Ignore*/}

"!="|"&&"|"=="|"!"|"|"|"<="|"<<"|">="|">>"|
"**"|"/"|"%"|"*"|"<"|">"|","|";"|"."|"("|")"|
"["|"]"|"?"|":"|"{"|"}"|"+="|"-="|"*="|"/="|"&"|
"^"|"~"|"+"|"-"|"=" { lexeme=yytext(); return Operador;}
{L}({L}|{FL3})* { lexeme=yytext(); return Identificador;}


 . { return ERROR;}
