package codigo;

import java.util.*;

public class TablaSimbolos{
    HashMap t;
    String erroresLex = "";
    
    public TablaSimbolos(){
        t = new HashMap();
    }
    
    public Simbolo insertar(String nombre){
        Simbolo s = new Simbolo(nombre, new Integer(0));
        t.put(nombre, s);
        return s;
    }
    
    public Simbolo buscar(String nombre){
        return (Simbolo)(t.get(nombre));
    }
    
    public void imprimir(){
        Iterator it = t.values().iterator();
        while(it.hasNext()){
            Simbolo s = (Simbolo)it.next();
            System.out.println(s.nombre + ": "+ s.valor);
        }
    }
    
    public String generarString(){
        String strTabla = "";
        Iterator it = t.values().iterator();
        while(it.hasNext()){
            Simbolo s = (Simbolo)it.next();
            strTabla += s.nombre + ": "+ s.valor + "\n";
        }
        return strTabla;
    }
    
    public String getErroresDeLex(){
        return this.erroresLex;
    }
}