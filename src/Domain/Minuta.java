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
    private int id;
    private String notas;
    private String pendiente;
    private String nombreParticipante;
    private String nombreEncargado;
    private String nombreReunion;
    private String fechaCreacion;
    
    public Minuta(){
        id = 0;
        notas = "";
        pendiente = "";
        nombreParticipante = "";
        nombreEncargado = "";
        nombreReunion = "";
        fechaCreacion = "";
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getID(){
        return id;
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

    public String getPendiente() {
        return pendiente;
    }

    public void setPendiente(String pendiente) {
        this.pendiente = pendiente;
    }

    public String getNombreParticipante() {
        return nombreParticipante;
    }

    public void setNombreParticipante(String nombreParticipante) {
        this.nombreParticipante = nombreParticipante;
    }
}
