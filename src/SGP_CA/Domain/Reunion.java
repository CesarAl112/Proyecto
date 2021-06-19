package SGP_CA.Domain;

import java.util.Date;

/**
 *
 * @author Alberto
 */
public class Reunion {
    private int idReunion;
    private String tituloReunion;
    private Date horaInicio;
    private Date horaFin;
    private String lider;
    private String responsableRegistro;
    private String asunto;
    private String lugarReunion;
    private Date fechaReunion;
    
    
    public Reunion(){
        idReunion = 0;
        tituloReunion = "";
        horaInicio = new Date();
        horaFin = new Date();
        lider = "";
        responsableRegistro = "";
        asunto = "";
        lugarReunion ="";
        fechaReunion = new Date();
    }
    
    public void setIdReunion(int idReunion){
        this.idReunion = idReunion;
    }
    
    public int getIdReunion(){  
        return idReunion;
    }
    
    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }
    
     public String getLider() {
        return lider;
    }

    public void setLider(String lider) {
        this.lider = lider;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
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

    public String getLugarReunion() {
        return lugarReunion;
    }

    public void setLugarReunion(String lugarReunion) {
        this.lugarReunion = lugarReunion;
    }

    public Date getFechaReunion() {
        return fechaReunion;
    }

    public void setFechaReunion(Date fechaReunion) {
        this.fechaReunion = fechaReunion;
    }

    
}
