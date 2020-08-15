package codigo;

import java.util.*;

public class TablaSimbolos{
    HashMap t;
    String erroresLex = "";
    public String ultimoTipoIngresado = "";
    Simbolo ultimoSimboloIngresado;
    public String ultimoIdentificadorIngresado = "";
    public boolean returnEnFuncion = false;
    
    
    public TablaSimbolos(){
        t = new HashMap();
    }

    public void reiniciarTipo(){
        ultimoTipoIngresado = "";
    }
    
    public Simbolo insertar(String nombre){
        String idSim = Integer.toString(t.size());
        Simbolo s = new Simbolo(idSim ,nombre, new Integer(0), ultimoTipoIngresado);
        
        ultimoSimboloIngresado = s;
        
        t.put(idSim, s);
        if(ultimoTipoIngresado.equals("function")){
            reiniciarTipo();
        }
        return s;
    }
    
    public void insertarValorVariable(String valorStr){
        int valor = Integer.parseInt(valorStr);

        Simbolo simTest;
        String idSimInd = "";
        //System.err.println("Tamaño Tabla: "+t.size());
        for (int i = 0; i < t.size(); i++) {
            idSimInd = Integer.toString(i);
            simTest = (Simbolo)(t.get(idSimInd));
            //System.err.println("simTestNombre "+simTest.getNombre()+" Ultimo nombre: "+ultimoNombreIngresado);
            if(simTest.getNombre().equals(ultimoIdentificadorIngresado)){
                if(simTest.getTipo().equals("int") || simTest.getTipo().equals("string") || simTest.getTipo().equals("uint")){
                    simTest.setValor(valor);
                }
            }       
        }
    }
    
    public void asignarComoUltimoTipo(String tipo){
        ultimoTipoIngresado = tipo;
    }
    
    public Boolean buscarBool(String ultimoNombreIngresado){
        Simbolo simTest;
        String idSimInd = "";
        //System.err.println("Tamaño Tabla: "+t.size());
        for (int i = 0; i < t.size(); i++) {
            idSimInd = Integer.toString(i);
            simTest = (Simbolo)(t.get(idSimInd));
            //System.err.println("simTestNombre "+simTest.getNombre()+" Ultimo nombre: "+ultimoNombreIngresado);
            if(simTest.getNombre().equals(ultimoNombreIngresado)){
                if(simTest.getTipo().equals(ultimoTipoIngresado)){
                    return false;
                }
                else{
                    return true;
                }
            }       
        }
        return true;
    }
    
    public Boolean revisarDeclaracion(String ultimoNombreIngresado){
        Simbolo simTest;
        String idSimInd = "";
        for (int i = 0; i < t.size(); i++) {
            idSimInd = Integer.toString(i);
            simTest = (Simbolo)(t.get(idSimInd));
            if(simTest.getNombre().equals(ultimoNombreIngresado)){
                if(simTest.getTipo().equals("int") || simTest.getTipo().equals("string") || simTest.getTipo().equals("uint")){
                    System.out.println("Declarada");
                    return false;
                } //Aquí también se puede manejar para funciones.
                else{
                    System.out.println("No Declarada");
                    return true;
                }
            }       
        }
        System.out.println("No Declarada");
        return true;
    }
    
    public void imprimir(){
        Iterator it = t.values().iterator();
        while(it.hasNext()){
            Simbolo s = (Simbolo)it.next();
           // System.out.println(s.nombre + ": "+ s.valor+".Tipo: "+s.tipo);
        }
    }
    
    public String generarString(){
        String strTabla = "";
        Iterator it = t.values().iterator();
        while(it.hasNext()){
            Simbolo s = (Simbolo)it.next();
            strTabla += s.nombre + ": "+ s.valor + ".Tipo: "+s.tipo+"\n";
        }
        return strTabla;
    }
    
    public String getErroresDeLex(){
        return this.erroresLex;
    }
    
    public void limpiar(){
        this.erroresLex = "";
        this.t.clear();
    }
}