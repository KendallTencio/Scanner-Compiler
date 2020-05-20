package codigo;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Constructor;

public class AnalizadorLexico {
    
    public AnalizadorLexico(){
        
    }
    
    public String analizarLexico(String txtEntrada) throws IOException{
        int cont = 1;
        
        String expr = (String) txtEntrada;
        Lexer lexer = new Lexer(new StringReader(expr));
        String resultado = "Línea: " + cont + "\tTipo\n";
        while(true){
            Tokens token = lexer.yylex();
            if(token == null){;
                return resultado;
            }
            switch (token) {
                    case Linea:
                        cont++;
                        resultado += "Línea: " + cont + "\n";
                    break;  
                    case ERROR:
                        resultado += "Símbolo no definido\n";
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
