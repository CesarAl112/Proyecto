/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Domain;

/**
 *
 * @author Alberto
 */
public class Minuta {
    private int idMinuta;
    private String notas;
    private String pendientes;
    private String nombreParticipante;
    private String nombreEncargado;
    private String nombreReunion;
    private String fechaCreacion;
    
    public Minuta(){
        idMinuta = 0;
        notas = "";
        pendientes = "";
        nombreParticipante = "";
        nombreEncargado = "";
        nombreReunion = "";
        fechaCreacion = "";
    }
    
    public void setIdMinuta(int idMinuta){
        this.idMinuta = idMinuta;
    }
    
    public int getIDMinuta(){
        return idMinuta;
    }
    
    public void setTitulo(String notas){
        this.setNotas(notas);
    }
    
    public String getNotas(){
        return notas;
    }
    
    public void setNombreEncargado(String nombreEncargado){
        this.nombreEncargado = nombreEncargado;
    }
    
    public String getNombreEncargado(){
        return nombreEncargado;
    }
    
    public void setNombreReunion(String nombreReunion){
        this.nombreReunion = nombreReunion;
    }
    
    public String getNombreReunion(){
        return nombreReunion;
    }
    
    public void setFechaCreacion(String fechaCreacion){
        this.fechaCreacion = fechaCreacion;
    }
    
    public String getFechaCreacion(){
        return fechaCreacion;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getPendientes() {
        return pendientes;
    }

    public void setPendientes(String pendientes) {
        this.pendientes = pendientes;
    }

    public String getNombreParticipante() {
        return nombreParticipante;
    }

    public void setNombreParticipante(String nombreParticipante) {
        this.nombreParticipante = nombreParticipante;
    }
}
