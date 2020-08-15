/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

class Simbolo{
    String idSim = "";
    String nombre = "";
    Integer valor = 0;
    String tipo = "";
    String scope = "";
    public Simbolo(String idSim, String nombre, Integer valor, String tipo, String scope){
        this.idSim = idSim;
        this.nombre = nombre;
        this.valor = valor;
        this.tipo = tipo;
        this.scope = scope;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getIdSim() {
        return idSim;
    }

    public void setIdSim(String idSim) {
        this.idSim = idSim;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }
    
    
}