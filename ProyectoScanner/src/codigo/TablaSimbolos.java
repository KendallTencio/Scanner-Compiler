package codigo;

import java.util.*;

public class TablaSimbolos{
    HashMap t;
    String erroresLex = "";
    Simbolo ultimoSimboloIngresado;
    
    public TablaSimbolos(){
        t = new HashMap();
    }
    
    public Simbolo insertar(String nombre, String tipo){
        Simbolo s = new Simbolo(nombre, new Integer(0), tipo);
        
        ultimoSimboloIngresado = s;
        
        t.put(nombre, s);
        return s;
    }
    
    public void insertarValorVariable(String valorStr){
        int valor = Integer.parseInt(valorStr);
        buscar(ultimoSimboloIngresado.getNombre()).setValor(valor);
    }
    
    public Simbolo buscar(String nombre){
        return (Simbolo)(t.get(nombre));
    }
    
    public void imprimir(){
        Iterator it = t.values().iterator();
        while(it.hasNext()){
            Simbolo s = (Simbolo)it.next();
            System.out.println(s.nombre + ": "+ s.valor+".Tipo: "+s.tipo);
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