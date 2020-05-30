package codigo;

import java.util.ArrayList;

public class TokenError {
    private String IDTokenError;     //Se tiene un ID y una lista de parejas String de {Línea, CantidadDeApariciones}
    private ArrayList<String[]> lineasDeTokenError = new ArrayList<>(); 
    
    public TokenError(String msjError, int linea){
        setIDTokenError(msjError);
        setLineaTokenError(linea, 1); //Número de apariciones es 1 la primera vez que se construye
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
                listaLineasError += "       Líneas:"+ lineasDeTokenError.get(i)[0];
                primeraLinea = false;
            }
            else{
                listaLineasError += ", " + lineasDeTokenError.get(i)[0];
            }
            if(Integer.parseInt(lineasDeTokenError.get(i)[1]) > 1){ //No me gusta estarlo pasando constantemente de Str a Int y viceversa. :I
                listaLineasError += "("+lineasDeTokenError.get(i)[1]+")";
            }
        }
        strTokenError += getIDTokenError();
        strTokenError += listaLineasError + "\n";
        return strTokenError;
    }
    
    public void setLineaTokenError(int lineaNueva, int numApariciones){
        String lineaStr = Integer.toString(lineaNueva);
        String numAparStr = Integer.toString(numApariciones);
        String[] contenidoLinea = {lineaStr, numAparStr};
        lineasDeTokenError.add(contenidoLinea);
    }
    
    public void agregarLineaTokenError(String lineaNueva){
        boolean lineaAgregada = false;
        int cantidadAparicionesInt;
        for (int numLinea = 0; numLinea < lineasDeTokenError.size(); numLinea++) {
           if(lineasDeTokenError.get(numLinea)[0].equals(lineaNueva)){ 
               lineaAgregada = true;
               cantidadAparicionesInt = Integer.parseInt(lineasDeTokenError.get(numLinea)[1]);
               cantidadAparicionesInt += 1;                               //Se le agregó 1 a la cant actual de errores en esa línea.
               lineasDeTokenError.get(numLinea)[1] = Integer.toString(cantidadAparicionesInt);
               break;
           }
        }
        if(!lineaAgregada){
            setLineaTokenError(Integer.parseInt(lineaNueva), 1); //Cantidad de apariciones es 1
        }
    }
}
