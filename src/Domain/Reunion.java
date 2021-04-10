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
public class Reunion {
    private int id;
    private String tituloReunion;
    private String fechaInicio;
    private String fechaFin;
    private String responsableRegistro;
    private String asunto;
    private String lider;
    private String lugarReunion;
    private String fechaReunion;
    
    
    public Reunion(){
        id=0;
        tituloReunion="";
        fechaInicio="";
        fechaFin="";
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){  
        return id;
    }
    
    public void setFechaInicio(String fechaInicio){
        this.fechaInicio = fechaInicio;
    }
    
    public String getFechaInicio(){
        return fechaInicio;
    }
    
    public void setFechaFin(String fechaFin){
        this.fechaFin = fechaFin;
    }
    
    public String getFechaFin(){
        return fechaFin;
    }

    public String getTituloReunion() {
        return tituloReunion;
    }

    public void setTituloReunion(String tituloReunion) {
        this.tituloReunion = tituloReunion;
    }

    public String getResponsableRegistro() {
        return responsableRegistro;
    }

    public void setResponsableRegistro(String responsableRegistro) {
        this.responsableRegistro = responsableRegistro;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getLider() {
        return lider;
    }

    public void setLider(String lider) {
        this.lider = lider;
    }

    public String getLugarReunion() {
        return lugarReunion;
    }

    public void setLugarReunion(String lugarReunion) {
        this.lugarReunion = lugarReunion;
    }

    public String getFechaReunion() {
        return fechaReunion;
    }

    public void setFechaReunion(String fechaReunion) {
        this.fechaReunion = fechaReunion;
    }
}
