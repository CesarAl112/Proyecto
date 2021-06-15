package SGP_CA.Domain;

import java.util.Date;

/**
 *
 * @author Alberto
 */
public class PlanTrabajo {
    
    private int idPlanTrabajo;
    private String tituloPlanTrabajo;
    private String meta;
    private String estrategia;
    private int numeroEstrategia;
    private String resultado;
    private Date fechaInicio;
    private Date fechaFin;
    private String nombreEncargado;
    
    public PlanTrabajo(){
        idPlanTrabajo = 0;
        tituloPlanTrabajo = "";
        nombreEncargado = "";
        meta = "";
        estrategia = "";
        numeroEstrategia = 0;
        resultado = "";
        fechaInicio = new Date();
        fechaFin = new Date();
    }
    
   
    
    
    public void setNombreEncargado(String nombreEncargado){
       this.nombreEncargado = nombreEncargado;
    }
    
    public String getNombreEncargado(){
        return nombreEncargado;
    }

    public int getIdPlanTrabajo() {
        return idPlanTrabajo;
    }

    public void setIdPlanTrabajo(int idPlanTrabajo) {
        this.idPlanTrabajo = idPlanTrabajo;
    }

    public String getTituloPlanTrabajo() {
        return tituloPlanTrabajo;
    }

    public void setTituloPlanTrabajo(String tituloPlanTrabajo) {
        this.tituloPlanTrabajo = tituloPlanTrabajo;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(String estrategia) {
        this.estrategia = estrategia;
    }

    public int getNumeroEstrategia() {
        return numeroEstrategia;
    }

    public void setNumeroEstrategia(int numeroEstrategia) {
        this.numeroEstrategia = numeroEstrategia;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    
}
