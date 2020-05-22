package codigo;

import java.util.ArrayList;

public class TokenError {
    private String IDTokenError;
    private ArrayList<String> lineasDeTokenError = new ArrayList<String>();
    
    public TokenError(String msjError, int linea){
        setIDTokenError(msjError);
        setLineaTokenError(linea);
    }
    
    public String getIDTokenError(){
        return IDTokenError;
    }
    
    public void setIDTokenError(String idNuevo){
        IDTokenError = idNuevo;
    }
    
    public ArrayList getLineasDeToken(){
        return lineasDeTokenError;
    }
    
    public String getStringError(){
        String strTokenError = "";
        String listaLineasError = "";
        boolean primeraLinea = true;
        for (int i = 0; i < lineasDeTokenError.size(); i++) {
            if(primeraLinea){
                listaLineasError += " ("+ lineasDeTokenError.get(i);
                primeraLinea = false;
            }
            else{
                listaLineasError += ", " + lineasDeTokenError.get(i);
            }
        }
        strTokenError += getIDTokenError();
        strTokenError += listaLineasError + ")\n";
        return strTokenError;
    }
    
    public void setLineaTokenError(int lineaNueva){
        String lineaStr = Integer.toString(lineaNueva);
        lineasDeTokenError.add(lineaStr);
    }
    
    public void agregarLineaTokenError(String lineaNueva){
        boolean lineaAgregada = false;
        for (int numLinea = 0; numLinea < lineasDeTokenError.size(); numLinea++) {
           if(lineasDeTokenError.get(numLinea).equals(lineaNueva)){
               lineaAgregada = true;
               break;
           }
        }
        if(!lineaAgregada){
            lineasDeTokenError.add(lineaNueva);
            
        }
    }
}
