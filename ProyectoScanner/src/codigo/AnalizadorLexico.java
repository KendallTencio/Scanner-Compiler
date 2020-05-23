package codigo;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class AnalizadorLexico {
    private String errores = "";
    private ArrayList<TokenError> listaErrores = new ArrayList<TokenError>();
    
    public AnalizadorLexico(){
        
    }
    
    public String getStringErrores(){
        String strErrores = "Tipos de errores encontrados: " + listaErrores.size() + "\n\n";
        for (int i = 0; i < listaErrores.size(); i++){
            TokenError tokenError = (TokenError) listaErrores.get(i);
            strErrores += tokenError.getStringError(); 
        }
        return strErrores;
    }
    
    public boolean comprobarIdErrorNuevo(String idNueva){
        if(listaErrores == null){
            return true;
        }
        for (int numId = 0; numId < listaErrores.size(); numId++){
            if( listaErrores.get(numId).getIDTokenError().equals(idNueva)){
               return false;
            } 
        }
        return true;
    }
    
    public void agregarLineaATokenErrorExistente(String idToken, int lineaNueva){
        String lineaStr = Integer.toString(lineaNueva);
        for (int numId = 0; numId < listaErrores.size(); numId++){
            if(listaErrores.get(numId).getIDTokenError().equals(idToken)){
               listaErrores.get(numId).agregarLineaTokenError(lineaStr);
               break;
            } 
        }
    }
    
    public String analizarLexico(String txtEntrada) throws IOException{
        int contLinea = 1;
        
        String expr = (String) txtEntrada;
        Lexer lexer = new Lexer(new StringReader(expr));
        String resultado = "";
        String idError = "";
        while(true){
            Tokens token = lexer.yylex();
            contLinea = lexer.linea();
            if(token == null){;
                return resultado;
            }
            resultado += "\nLínea: " + (contLinea) + "\n";
            switch (token) {
                    case ERROR: case ERROR_Identificador: case ERROR_Simbolo:
                        idError += token; //Por el momento todos los errores son los mismos
                        //anadirError(contLinea, errorMsj);
                        if(comprobarIdErrorNuevo(idError)){
                            TokenError tokenErrorNuevo = new TokenError(idError, contLinea);
                            listaErrores.add(tokenErrorNuevo);
                        }
                        else{
                            agregarLineaATokenErrorExistente(idError, contLinea);
                        }
                        idError = "";
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