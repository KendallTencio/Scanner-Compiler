package codigo;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

public class AnalizadorLexico {
    private String errores = "";
    private ArrayList<TokenError> listaErrores = new ArrayList<TokenError>();
    
    private Report report = new Report();
    
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
        int lineaActualToken = 1;
        
        String expr = (String) txtEntrada;
        Lexer lexer = new Lexer(new StringReader(expr));
        while(true){
            Tokens token = lexer.yylex();
            lineaActualToken = lexer.linea();
            if(token == null){;
                return this.report.generateReport();
            }
            switch (token) {
                    case ERROR: case ERROR_Identificador: case ERROR_Simbolo:
                        if(comprobarIdErrorNuevo(token.toString())){
                            TokenError tokenErrorNuevo = new TokenError(token.toString(), lineaActualToken);
                            listaErrores.add(tokenErrorNuevo);
                        }
                        else{
                            agregarLineaATokenErrorExistente(token.toString(), lineaActualToken);
                        }
                        break;
                    case Identificador: case Literal: case Reservadas:
                        this.report.analyze(lexer.lexeme, token.toString(), String.valueOf(lineaActualToken));
                        break;  
                    default:
                        this.report.analyze(lexer.lexeme, token.toString(), String.valueOf(lineaActualToken));
                        break;
                }
        }
        
    }
}