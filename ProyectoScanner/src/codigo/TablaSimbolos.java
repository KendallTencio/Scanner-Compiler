package codigo;

import java.util.*;

public class TablaSimbolos{
    HashMap t;
    String erroresLex = "";
    
    //Registro de últimos ingresados.
    Simbolo ultimoSimboloIngresado;
    public String ultimoTipoIngresado = "";
    public String ultimoIdentificadorIngresado = "";
    
    public boolean posibleIdSiendoAsignado = false;
    
    //Bandera de return en función ingresada
    public boolean returnsEnFuncion = false;
    public boolean returnIngresado = false;
    
    //Variables de Scope
    public boolean varGlobal = false;
    public boolean varLocal = false;
    public boolean varParamet = false;
    public boolean funcion = false;
    
    
    public TablaSimbolos(){
        t = new HashMap();
    }

    public void reiniciarTipo(){
        ultimoTipoIngresado = "";
        posibleIdSiendoAsignado = false;
    }
    
    public Simbolo insertar(String nombre){
        if(!posibleIdSiendoAsignado){
            String idSim = Integer.toString(t.size());
            Simbolo s = new Simbolo(idSim ,nombre, "", ultimoTipoIngresado, "");

            ultimoSimboloIngresado = s;

            t.put(idSim, s);
            if(ultimoTipoIngresado.equals("function")){
                reiniciarTipo();
            }
            return s;
        }
        posibleIdSiendoAsignado = false;
        return null;
    }
    
    public void insertarValorVariable(String valor){

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
    
    public void insertarValorScope(String nombreId){
        String scope = "Sin ámbito definido";
        Simbolo simTest;
        String idSimInd = "";
        
        /*System.out.println("Insertar Scope:");
        System.out.println("varGScope: "+varGlobal + " ID: "+nombreId);
        System.out.println("varLScope: "+varLocal + " ID: "+nombreId);
        System.out.println("varPScope: "+varParamet + " ID: "+nombreId);
        System.out.println("FunScope: "+funcion + " ID: "+nombreId);
        */
        if(varGlobal){
           scope = "Var. Global"; 
        }
        else if(varLocal){
           scope = "Var. Local"; 
        }
        else if(varParamet){
           scope = "Parámetro"; 
        }
        else if(funcion){
           scope = "Función"; 
        }

        for (int i = 0; i < t.size(); i++) {
            idSimInd = Integer.toString(i);
            simTest = (Simbolo)(t.get(idSimInd));

            if(simTest.getNombre().equals(nombreId)){
                    simTest.setScope(scope);
            }       
        }
    }
    
    public void insertarIdValorVariable(String id){
        if(buscarNombre(id)){
            this.erroresLex += "Identificador " + id + " usado pero no declarado\n";
        }
    }
    
    public void asignarComoUltimoTipo(String tipo){
        ultimoTipoIngresado = tipo;
    }
    
    public Boolean buscarBool(String ultimoNombreIngresado){
        Simbolo simTest;
        String idSimInd = "";

        for (int i = 0; i < t.size(); i++) {
            idSimInd = Integer.toString(i);
            simTest = (Simbolo)(t.get(idSimInd));

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
    
        public Boolean buscarNombre(String nombreBusq){
        Simbolo simTest;
        String idSimInd = "";

        for (int i = 0; i < t.size(); i++) {
            idSimInd = Integer.toString(i);
            simTest = (Simbolo)(t.get(idSimInd));

            if(simTest.getNombre().equals(nombreBusq)){
                return false;
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
                    return false;
                } //Aquí también se puede manejar para funciones.
                else{
                    return true;
                }
            }       
        }
        return true;
    }
    
    public void returnsEnFuncion(){
        returnsEnFuncion = true;
    }
    
    public void returnEnFuncionIngresado(){
        returnIngresado = true;
    }
    
    public void validarReturnFuncion(){
        if(returnsEnFuncion & returnIngresado || !returnsEnFuncion & !returnIngresado){
            System.out.println("Todo bien con el return");
        }
        else if(returnIngresado){
            this.erroresLex += "Función sin returns declarado, pero con return";
            System.out.println("Return pero returns no indicado");
        }
        else{
            this.erroresLex += "Función con returns declarado, pero sin return";
            System.out.println("Falta return");
        }
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
            strTabla += s.nombre + "-----> Valor: "+ s.valor + "----Tipo: "+s.tipo+"----Scope: "+s.scope+"\n";
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