package codigo;

import java.util.ArrayList;

public class Token {
    private Tokens tipoToken;
    private ArrayList lineasDeToken;
    
    public Token(Tokens tipoAsignado){
        setTipoToken(tipoAsignado);
    }
    
    public Tokens getTipoToken(){
        return tipoToken;
    }
    
    public void setTipoToken(Tokens tipo){
        tipoToken = tipo;
    }
    
    public ArrayList getLineasDeToken(){
        return lineasDeToken;
    }
    
    public void setLineasDeToken(String lineaString){
        lineasDeToken.add(lineaString);
    }
}
