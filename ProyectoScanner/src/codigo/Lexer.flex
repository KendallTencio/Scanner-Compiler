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
FLE4 = [0][0-9]+

%{
    public String lexeme;
    public int linea(){return yyline+1;};
%}

%%

//{ lexeme=yytext(); return ;}

"/*"|"*/" {return ERROR_Comentario;}
{FLE} { lexeme=yytext(); return ERROR_LiteralCero;}
{CientError} { lexeme=yytext(); return ERROR_NotacionCientifica;}

//Reservadas
( address ) { lexeme=yytext(); return Address;}
( as ) { lexeme=yytext(); return As;}
( bool ) { lexeme=yytext(); return Bool;}
( break ) { lexeme=yytext(); return Break;}
( byte ) { lexeme=yytext(); return Byte;}
( bytes ) { lexeme=yytext(); return Bytes;}
( constructor ) { lexeme=yytext(); return Constructor;}
( continue ) { lexeme=yytext(); return Continue;}
( contract ) { lexeme=yytext(); return Contract;}
( delete ) { lexeme=yytext(); return Delete;}
( do ) { lexeme=yytext(); return Do;}
( else ) { lexeme=yytext(); return Else;}
( enum ) { lexeme=yytext(); return Enum;}
( for ) { lexeme=yytext(); return For;}
( from ) { lexeme=yytext(); return From;}
( function ) { lexeme=yytext(); return Function;}
( hex ) { lexeme=yytext(); return Hex;}
( if ) { lexeme=yytext(); return If;}
( import ) { lexeme=yytext(); return Import;}
( int ) { lexeme=yytext(); return Int;}
( internal ) { lexeme=yytext(); return Internal;}
( mapping ) { lexeme=yytext(); return Mapping;}
( modifier ) { lexeme=yytext(); return Modifier;}
( payable ) { lexeme=yytext(); return Payable;}
( private ) { lexeme=yytext(); return Private;}
( pragma ) { lexeme=yytext(); return Pragma;}
( public ) { lexeme=yytext(); return Public;}
( return ) { lexeme=yytext(); return Return;}
( returns ) { lexeme=yytext(); return Returns;}
( solidity ) { lexeme=yytext(); return Solidity;}
( string ) { lexeme=yytext(); return String;}
( struct ) { lexeme=yytext(); return Struct;}
( this ) { lexeme=yytext(); return This;}
( true | false) { lexeme=yytext(); return Op_Booleano;}
( ufixed ) { lexeme=yytext(); return Ufixed;}
( uint ) { lexeme=yytext(); return Uint;}
( var ) { lexeme=yytext(); return Var;}
( view ) { lexeme=yytext(); return View;}
( while ) { lexeme=yytext(); return While;}

//Transac
( balance | call | callcode | delegate | call | send | transfer ) { lexeme=yytext(); return Transac;}

//Units
( days | ether | finney | hours | minutes | seconds | szabo | weeks | wei | years ) { lexeme=yytext(); return Units;}

//Operadores
( "|" ) { lexeme=yytext(); return Pipe;}
( "<<" ) { lexeme=yytext(); return ShiftLeft;}
( ">>" ) { lexeme=yytext(); return ShiftRight;}
( "**" ) { lexeme=yytext(); return DobleAsterisco;}
( "," ) { lexeme=yytext(); return Coma;}
( ";" ) { lexeme=yytext(); return PuntoComa;}
( "." ) { lexeme=yytext(); return Punto;}
( "[" ) { lexeme=yytext(); return ParenCuadAbre;}
( "]" ) { lexeme=yytext(); return ParenCuadCierra;}
( "?" ) { lexeme=yytext(); return SignoPregunta;}
( ":" ) { lexeme=yytext(); return DosPuntos;}
( "{" ) { lexeme=yytext(); return LlaveAbre;}
( "}" ) { lexeme=yytext(); return LlaveCierra;}
( "&" ) { lexeme=yytext(); return Ampersand;}
( "^" ) { lexeme=yytext(); return Elevar;}
( "~" ) { lexeme=yytext(); return Virgulilla;}

//Operadores aritméticos
( "+" ) { lexeme=yytext(); return Suma;}
( "-" ) { lexeme=yytext(); return Resta;}
( "*" ) { lexeme=yytext(); return Mult;}
( "/" ) { lexeme=yytext(); return Div;}
( "%" ) { lexeme=yytext(); return Mod;}
( "(" ) { lexeme=yytext(); return ParentAbre;}
( ")" ) { lexeme=yytext(); return ParentCierre;}

// Operadores Atribucion 
( "+=" | "-="  | "*=" | "/=" | "=" ) { lexeme=yytext(); return Op_atribucion;}

// Operadores Incrementales
( "++" | "--" ) { lexeme=yytext(); return Op_Incremental;}

//Operadores relacional
( ">" | "<" | "==" | "!=" | ">=" | "<=" | "<<" | ">>" | "||" | "&&") { lexeme=yytext(); return Op_relacional;}
( "!" ) { lexeme=yytext(); return Not;}

//Valores Int
( int8|int16|int24|int32|int40|int48|int56|int64|int72|int80|int88|int96|int104|int112|int120|int128|int136|int144|int152|int160|int168|int176|int184|int192|int200|int208|int216|int224|int232|int240|int248|int256 ) { lexeme=yytext(); return IntValue;}

//Valores Uint
( uint|uint8|uint16|uint24|uint32|uint40|uint48|uint56|uint64|uint72|uint80|uint88|uint96|uint104|uint112|uint120|uint128|uint136|uint144|uint152|uint160|uint168|uint176|uint184|uint192|uint200|uint208|uint216|uint224|uint232|uint240|uint248|uint256 ) { lexeme=yytext(); return UintValue;}

//Valores Bytes
( bytes|bytes1|bytes2|bytes3|bytes4|bytes5|bytes6|bytes7|bytes8|bytes9|bytes10|bytes11|bytes12|bytes13|bytes14|bytes15|bytes16|bytes17|bytes18|bytes19|bytes20|bytes21|bytes22|bytes23|bytes24|bytes25|bytes26|bytes27|bytes28|bytes29|bytes30|bytes31|bytes32 ) { lexeme=yytext(); return BytesValue;}

( "/*"([^])*"*/" ) {/*Ignore*/}
{espacio} {/*Ignore*/}
( "//".* ) {/*Ignore*/}


//Valores Hex
( (hex\"{H}{H}{H}{H}{H}{H}{H}{H}\")|(hex'{H}{H}{H}{H}{H}{H}{H}{H}') ) { lexeme=yytext(); return Literal;}

//Literales
( {FL} ) { lexeme=yytext(); return Literal;}
( ('([^(\n)(')])*')|(\"([^(\n)(\")])*\") ) { lexeme=yytext(); return Literal;}

//Identificadores
( {FL3}([^( )(\n)(\t)(\r)(!=)(&&)(==)(!)(|)(<=)(<<)(>=)(>>)(**)(/)(%)(*)(<)(>)(,)(;)(.)("(")(")")("[")("]")(?)(:)({)(})(+=)(-=)(*=)(/=)(&)("^")(~)(+)("-")(=)])* ) { lexeme=yytext(); return ERROR_Identificador;}
( {L}({L}|{FL3})* ) { lexeme=yytext(); return Identificador;}

//Versión
( "^0.4.0" ) { lexeme=yytext(); return Version;}

/* Error de analisis */
 . { return ERROR;}
