package codigo;

import java.util.*;

public class TablaSimbolos{
    HashMap t;
    String erroresLex = "";
    
    //Registro de últimos ingresados.
    Simbolo ultimoSimboloIngresado;
    public String ultimoTipoIngresado = "";
    public String ultimoIdentificadorIngresado = "";
    public String ultimoIdIngresado = "";
    
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
    
    public boolean revisarContantFoldingBinario(String exp1, String op, String exp2){
        
        if (exp1 == null && exp2 == null) {
            return false;
        }
        try {
            int expInt1 = Integer.parseInt(exp1);
            int expInt2 = Integer.parseInt(exp2);
        } catch (NumberFormatException nfe) {
            return false;
        }
        
        System.out.println("Sí se puede constant folding Binario");
        return true;
        
    }
    
    public int aplicarContantFoldingBinario(int exp1, String op, int exp2){
        int resultConstantFolding = 0;
        if(op.equals("+")){
            resultConstantFolding = exp1 + exp2;
        }
        else if (op.equals("-")) {
            resultConstantFolding = exp1 - exp2;
        }
        
        return resultConstantFolding;
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
        
        System.err.println("Var: "+nombreId);
        System.err.println(varParamet);
        System.err.println(varLocal);
        System.err.println(varGlobal);
        System.err.println(funcion);
        
        if(varParamet){
           scope = "Parámetro"; 
        }
        else if(varLocal){
           scope = "Var. Local"; 
        }
        else if(varGlobal){
           scope = "Var. Global"; 
        }
        else if(funcion){
           scope = "Función"; 
        }

        for (int i = 0; i < t.size(); i++) {
            idSimInd = Integer.toString(i);
            simTest = (Simbolo)(t.get(idSimInd));

            if(varParamet && simTest.getNombre().equals(nombreId) && simTest.getScope().equals("Var. Global")){
                continue;
            }
            else if(simTest.getNombre().equals(nombreId)){
                if(simTest.getTipo().equals("int") && !funcion){
                    simTest.setScope(scope);
                }
                else if(!simTest.getTipo().equals("int") && funcion){
                    simTest.setScope(scope);
                }   
            }       
        }
    }
    
    public void insertarIdValorVariable(String id){
        if(buscarNombre(id)){
            this.erroresLex += "Identificador " + id + " usado pero no declarado\n";
        }else{
            ultimoSimboloIngresado.setValor(id);
            //Asignar id como valor
        }       
    }
    
    public void asignarComoUltimoTipo(String tipo){
        ultimoTipoIngresado = tipo;
    }
    
    public Simbolo buscarSimVar(String ultimoNombreIngresado){
        Simbolo simTest;
        String idSimInd = "";

        for (int i = 0; i < t.size(); i++) {
            idSimInd = Integer.toString(i);
            simTest = (Simbolo)(t.get(idSimInd));

            if(simTest.getNombre().equals(ultimoNombreIngresado)){
                return simTest;
            }       
        }
        return null;
    }
    
    public Boolean buscarBool(String ultimoNombreIngresado){
        Simbolo simTest;
        String idSimInd = "";

        for (int i = 0; i < t.size(); i++) {
            idSimInd = Integer.toString(i);
            simTest = (Simbolo)(t.get(idSimInd));

            if(simTest.getNombre().equals(ultimoNombreIngresado)){
                if(simTest.getTipo().equals(ultimoTipoIngresado)){
                    if(varParamet){
                       // varParamet = false;
                        return true;
                    }
                    else{
                        return false;   
                    }
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
            if(s.tipo.equals("function")){
                strTabla += s.nombre + "-----> Scope: "+s.tipo+"\n";
            }else{
                strTabla += s.nombre + "-----> Valor: "+ s.valor + "----Tipo: "+s.tipo+"----Scope: "+s.scope+"\n";
            }
            
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