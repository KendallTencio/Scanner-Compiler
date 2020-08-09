package codigo;

import java.util.ArrayList;

public class SymbolTable {
    private String name;
    private String type;
    private String scope; //Variables globales, funciones y variables locales y parámetros
    
    private static String lastTypeInput = "";
    private static boolean asigSimbrepetido = false;
    private static ArrayList<ArrayList<String>> symbolTable = new ArrayList<ArrayList<String>>();
    private static ArrayList<String> elementOfTable = new ArrayList<String>();
    private static ArrayList<String> elementOfTableAsig = new ArrayList<String>();

    /*
    pragma solidity ^0.4.0;


contract Contrato{

	enum enum1{ id1, id2, id3}
	
	int z, t, y, y;
	uint y = 2;  // error     
	int z, t, y, y;
	string private a;
}
    */
    
    public SymbolTable(){
        
    }
    
    public static void limpiarListaSimbolos(){
        symbolTable.clear();
    }
    
    public static void agregarSimboloNuevo(Object id){
        sincronizarVariables(id.toString());
    }
    
    public static void agregarTypeNuevo(Object type){
        lastTypeInput = type.toString();
        elementOfTable.add(type.toString());
    }
    
    public static void agregarAsignaNueva(Object value){
        if(asigSimbrepetido){
            elementOfTableAsig.add(value.toString());
            ArrayList<String> newElement = new ArrayList<String>();
            newElement = (ArrayList<String>) elementOfTableAsig.clone();

            symbolTable.remove(symbolTable.size()-1);
            symbolTable.add(newElement);
            imprimirLista(); 
        }
    }
    
    public static void sincronizarVariables(String id){
        elementOfTable.add(id);
        
        if(!revisarSimboloExistente(id)){
            ArrayList<String> newElement = new ArrayList<String>();
            newElement = (ArrayList<String>) elementOfTable.clone();
            elementOfTableAsig  = (ArrayList<String>) elementOfTable.clone();

            symbolTable.add(newElement);
            imprimirLista(); 
        }
        elementOfTable.clear();
    }
    
    public static void sincronizarVariablesComa(String id){
        elementOfTable.clear();
        elementOfTable.add(lastTypeInput);
        elementOfTable.add(id);
        
        if(!revisarSimboloExistente(id)){
            ArrayList<String> newElement = new ArrayList<String>();
            newElement = (ArrayList<String>) elementOfTable.clone();
            elementOfTableAsig  = (ArrayList<String>) elementOfTable.clone();

            symbolTable.add(newElement);
            imprimirLista(); 
        }
        elementOfTable.clear();
    }
    
    public static void imprimirLista(){
        System.out.println("\nN°--TYPE---ID---VALUE---------------------");
        
        String listaAImprimir = "";
        
        for (int i = 0; i < symbolTable.size(); i++) {
            System.out.print("\n"+i+" | "+symbolTable.get(i).get(0)+" | "+symbolTable.get(i).get(1));
            if(symbolTable.get(i).size() == 3){
                System.out.print(" | "+symbolTable.get(i).get(2));
            }
        }
    }
    
    public static boolean revisarSimboloExistente(String idARevisar){
        for (int i = 0; i < symbolTable.size(); i++) {
            if(idARevisar.equals(symbolTable.get(i).get(1))){
                System.err.println("\nVariable es igual: "+symbolTable.get(i).get(1));
                asigSimbrepetido = !asigSimbrepetido;
                return true;
            }
        }
        return false;
    }
    
    public static void agregarFuncNuevo(Object idFunc){
        elementOfTable.add("function");
        elementOfTable.add(idFunc.toString());
        if(!revisarFuncExistente(idFunc.toString())){
            ArrayList<String> newElement = new ArrayList<String>();
            newElement = (ArrayList<String>) elementOfTable.clone();
            
            symbolTable.add(newElement);
            imprimirLista(); 
        }
        elementOfTable.clear();
    }
    
    public static boolean revisarFuncExistente(String idARevisar){
        for (int i = 0; i < symbolTable.size(); i++) {
            if(idARevisar.equals(symbolTable.get(i).get(1))){
                System.err.println("\nEs igual: "+symbolTable.get(i).get(1));
                return true;
            }
        }
        return false;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public ArrayList<ArrayList<String>> getSymbolTable() {
        return symbolTable;
    }

    public void setSymbolTable(ArrayList<ArrayList<String>> symbolTable) {
        this.symbolTable = symbolTable;
    }

    public ArrayList<String> getElementOfTable() {
        return elementOfTable;
    }

    public void setElementOfTable(ArrayList<String> elementOfTable) {
        this.elementOfTable = elementOfTable;
    }
 
    
}
