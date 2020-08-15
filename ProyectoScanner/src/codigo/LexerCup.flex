package codigo;
import java_cup.runtime.Symbol;
import java.io.*;
%%
%{
private static TablaSimbolos tabla = new TablaSimbolos();
    public LexerCup(Reader in, TablaSimbolos t){
        this(in);
        this.tabla = t;
    }
%}
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
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
//espacio=[ \n,\t,\r]+
espacio=[ \t\r\n\f]+

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
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}

%%

"/*"|"*/" { return new Symbol(sym.ERROR_Comentario, yychar, yyline, yytext());}
{FLE} { return new Symbol(sym.ERROR_LiteralCero, yychar, yyline, yytext());}
{CientError} { return new Symbol(sym.ERROR_NotacionCientifica, yychar, yyline, yytext());}

//Reservadas
( address ) { return new Symbol(sym.Address, yychar, yyline, yytext());}
( as ) { return new Symbol(sym.As, yychar, yyline, yytext());}
( bool ) { tabla.asignarComoUltimoTipo(yytext()); return new Symbol(sym.Bool, yychar, yyline, yytext());}
( break ) { return new Symbol(sym.Break, yychar, yyline, yytext());}
( byte ) { return new Symbol(sym.Byte, yychar, yyline, yytext());}
( bytes ) { return new Symbol(sym.Bytes, yychar, yyline, yytext());}
( constructor ) { return new Symbol(sym.Constructor, yychar, yyline, yytext());}
( continue ) { return new Symbol(sym.Continue, yychar, yyline, yytext());}
( contract ) { tabla.asignarComoUltimoTipo(yytext()); return new Symbol(sym.Contract, yychar, yyline, yytext());}
( delete ) { return new Symbol(sym.Delete, yychar, yyline, yytext());}
( do ) { return new Symbol(sym.Do, yychar, yyline, yytext());}
( else ) { return new Symbol(sym.Else, yychar, yyline, yytext());}
( enum ) { tabla.asignarComoUltimoTipo(yytext()); return new Symbol(sym.Enum, yychar, yyline, yytext());}
( for ) { return new Symbol(sym.For, yychar, yyline, yytext());}
( from ) { return new Symbol(sym.From, yychar, yyline, yytext());}
( function ) { tabla.asignarComoUltimoTipo(yytext()); return new Symbol(sym.Function, yychar, yyline, yytext());}
( hex ) { return new Symbol(sym.Hex, yychar, yyline, yytext());}
( if ) { return new Symbol(sym.If, yychar, yyline, yytext());}
( import ) { return new Symbol(sym.Import, yychar, yyline, yytext());}
( int ) { tabla.asignarComoUltimoTipo(yytext()); return new Symbol(sym.Int, yychar, yyline, yytext());}
( internal ) { return new Symbol(sym.Internal, yychar, yyline, yytext());}
( mapping ) { return new Symbol(sym.Mapping, yychar, yyline, yytext());}
( modifier ) { return new Symbol(sym.Modifier, yychar, yyline, yytext());}
( payable ) { return new Symbol(sym.Payable, yychar, yyline, yytext());}
( private ) { return new Symbol(sym.Private, yychar, yyline, yytext());}
( pragma ) { return new Symbol(sym.Pragma, yychar, yyline, yytext());}
( public ) { return new Symbol(sym.Public, yychar, yyline, yytext());}
( return ) { return new Symbol(sym.Return, yychar, yyline, yytext());}
( returns ) { return new Symbol(sym.Returns, yychar, yyline, yytext());}
( solidity ) { return new Symbol(sym.Solidity, yychar, yyline, yytext());}
( string ) { tabla.asignarComoUltimoTipo(yytext()); return new Symbol(sym.String, yychar, yyline, yytext());}
( struct ) { tabla.asignarComoUltimoTipo(yytext()); return new Symbol(sym.Struct, yychar, yyline, yytext());}
( this ) { return new Symbol(sym.This, yychar, yyline, yytext());}
( true | false) { return new Symbol(sym.Op_Booleano, yychar, yyline, yytext());}
( ufixed ) { tabla.asignarComoUltimoTipo(yytext()); return new Symbol(sym.Ufixed, yychar, yyline, yytext());}
( uint ) { tabla.asignarComoUltimoTipo(yytext()); return new Symbol(sym.Uint, yychar, yyline, yytext());}
( var ) { return new Symbol(sym.Var, yychar, yyline, yytext());}
( view ) { return new Symbol(sym.View, yychar, yyline, yytext());}
( while ) { return new Symbol(sym.While, yychar, yyline, yytext());}

//Transac
( balance | call | callcode | delegate | call | send | transfer ) { return new Symbol(sym.Transac, yychar, yyline, yytext());}

//Units
( days | ether | finney | hours | minutes | seconds | szabo | weeks | wei | years ) { return new Symbol(sym.Units, yychar, yyline, yytext());}

//Operadores
( "|" ) { return new Symbol(sym.Pipe, yychar, yyline, yytext());}
( "<<" ) { return new Symbol(sym.ShiftLeft, yychar, yyline, yytext());}
( ">>" ) { return new Symbol(sym.ShiftRight, yychar, yyline, yytext());}
( "**" ) { return new Symbol(sym.DobleAsterisco, yychar, yyline, yytext());}
( "," ) { return new Symbol(sym.Coma, yychar, yyline, yytext());}
( ";" ) { tabla.reiniciarTipo(); return new Symbol(sym.PuntoComa, yychar, yyline, yytext());}
( "." ) { return new Symbol(sym.Punto, yychar, yyline, yytext());}
( "[" ) { return new Symbol(sym.ParenCuadAbre, yychar, yyline, yytext());}
( "]" ) { return new Symbol(sym.ParenCuadCierra, yychar, yyline, yytext());}
( "?" ) { return new Symbol(sym.SignoPregunta, yychar, yyline, yytext());}
( ":" ) { return new Symbol(sym.DosPuntos, yychar, yyline, yytext());}
( "{" ) { return new Symbol(sym.LlaveAbre, yychar, yyline, yytext());}
( "}" ) { return new Symbol(sym.LlaveCierra, yychar, yyline, yytext());}
( "&" ) { return new Symbol(sym.Ampersand, yychar, yyline, yytext());}
( "^" ) { return new Symbol(sym.Elevar, yychar, yyline, yytext());}
( "~" ) { return new Symbol(sym.Virgulilla, yychar, yyline, yytext());}

//Operadores aritméticos
( "+" ) { return new Symbol(sym.Suma, yychar, yyline, yytext());}
( "-" ) { return new Symbol(sym.Resta, yychar, yyline, yytext());}
( "*" ) { return new Symbol(sym.Mult, yychar, yyline, yytext());}
( "/" ) { return new Symbol(sym.Div, yychar, yyline, yytext());}
( "%" ) { return new Symbol(sym.Mod, yychar, yyline, yytext());}
( "(" ) { return new Symbol(sym.ParentAbre, yychar, yyline, yytext());}
( ")" ) { tabla.reiniciarTipo(); return new Symbol(sym.ParentCierre, yychar, yyline, yytext());}

// Operadores Atribucion 
( "+=" | "-="  | "*=" | "/=" | "=" ) {return new Symbol(sym.Op_atribucion, yychar, yyline, yytext());}

// Operadores Incrementales
( "++" | "--" ) {return new Symbol(sym.Op_Incremental, yychar, yyline, yytext());}

//Operadores relacional
( ">" | "<" | "==" | "!=" | ">=" | "<=" | "<<" | ">>" | "||" | "&&" ) {return new Symbol(sym.Op_relacional, yychar, yyline, yytext());}
 ( "!" ) {return new Symbol(sym.Not, yychar, yyline, yytext());}

//Valores Int
( int8|int16|int24|int32|int40|int48|int56|int64|int72|int80|int88|int96|int104|int112|int120|int128|int136|int144|int152|int160|int168|int176|int184|int192|int200|int208|int216|int224|int232|int240|int248|int256 ) { 
        tabla.asignarComoUltimoTipo(yytext());
        return new Symbol(sym.IntValue, yychar, yyline, yytext());}

//Valores Uint
( uint|uint8|uint16|uint24|uint32|uint40|uint48|uint56|uint64|uint72|uint80|uint88|uint96|uint104|uint112|uint120|uint128|uint136|uint144|uint152|uint160|uint168|uint176|uint184|uint192|uint200|uint208|uint216|uint224|uint232|uint240|uint248|uint256 ) { 
        tabla.asignarComoUltimoTipo(yytext());
        return new Symbol(sym.UintValue, yychar, yyline, yytext());}

//Valores Bytes
( bytes|bytes1|bytes2|bytes3|bytes4|bytes5|bytes6|bytes7|bytes8|bytes9|bytes10|bytes11|bytes12|bytes13|bytes14|bytes15|bytes16|bytes17|bytes18|bytes19|bytes20|bytes21|bytes22|bytes23|bytes24|bytes25|bytes26|bytes27|bytes28|bytes29|bytes30|bytes31|bytes32 ) { 
        tabla.asignarComoUltimoTipo(yytext());
        return new Symbol(sym.BytesValue, yychar, yyline, yytext());}

( "/*"([^])*"*/" ) {/*Ignore*/}
{espacio} {/*Ignore*/}
( "//".* ) {/*Ignore*/}

//Valores Hex
( (hex\"{H}{H}{H}{H}{H}{H}{H}{H}\")|(hex'{H}{H}{H}{H}{H}{H}{H}{H}') ) { return new Symbol(sym.Literal, yychar, yyline, yytext());}

//Literales
( {FL} ) { 
    return new Symbol(sym.Literal, yychar, yyline, yytext());
}
( ('([^(\n)(')])*')|(\"([^(\n)(\")])*\") ) { 
    return new Symbol(sym.Literal, yychar, yyline, yytext());
}



( {L}({L}|{FL3})* | ([^( )(\n)(\t)(\r)(!=)(&&)(==)(!)(|)(<=)(<<)(>=)(>>)(**)(/)(%)(*)(<)(>)(,)(;)(.)("(")(")")("[")("]")(?)(:)({)(})(+=)(-=)(*=)(/=)(&)("^")(~)(+)("-")(=)])* ) { 
    Simbolo s;
    
    if(tabla.ultimoTipoIngresado.equals("")){
        if(tabla.revisarDeclaracion(yytext())){
            tabla.erroresLex += "Variable no declarada: "+ yytext() + ". Línea: " + (yyline+1) +"\n";
            return new Symbol(sym.Identificador, yychar, yyline, yytext());
        }
    }
    else if (tabla.buscarBool(yytext())){
        s = tabla.insertar(yytext());
    }else{
        tabla.erroresLex += "Variable repetida: "+ yytext() + ". Línea: " + (yyline+1) +"\n";
    }
    return new Symbol(sym.Identificador, yychar, yyline, yytext());
}


//Versión
( "^0.4.0" ) { return new Symbol(sym.Version, yychar, yyline, yytext());}

/* Error de analisis */
 . {return new Symbol(sym.ERROR, yychar, yyline, yytext());}
