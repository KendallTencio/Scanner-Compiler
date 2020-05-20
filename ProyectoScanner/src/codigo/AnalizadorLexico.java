package codigo;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Constructor;

public class AnalizadorLexico {
    private String errores = "";
    
    public AnalizadorLexico(){
        
    }
    
    public void anadirError(int linea, String error){
        errores += "Línea: "+ linea + "\n" + error;
    }
    
    public String getErrores(){
        return errores;
    }
    
    public String analizarLexico(String txtEntrada) throws IOException{
        int contLinea = 1;
        
        String expr = (String) txtEntrada;
        Lexer lexer = new Lexer(new StringReader(expr));
        String resultado = "\nLínea: " + contLinea + "\tTipo\n";
        String errorMsj = "";
        while(true){
            Tokens token = lexer.yylex();
            if(token == null){;
                return resultado;
            }
            switch (token) {
                    case Linea:
                        contLinea++;
                        resultado += "\nLínea: " + contLinea + "\n";
                    break;  
                    case ERROR:
                        errorMsj += "Símbolo no definido\n";
                        anadirError(contLinea, errorMsj);
                        break;
                    case Identificador: case Literal: case Reservadas:
                        resultado += lexer.lexeme + "\t" + token + "\n";
                        break;  
                    default:
                        resultado += lexer.lexeme + "\t" + token + "\n";
                        break;
                }
        }
    }
}
