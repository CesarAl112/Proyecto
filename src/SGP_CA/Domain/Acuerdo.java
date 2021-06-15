package SGP_CA.Domain;
/**
 *
 * @author Alberto
 */
public class Acuerdo {
    private int idAcuerdo;
    private String responsableAcuerdo;
    private String tituloAcuerdo;
    private int numeroAcuerdo;
    private String cumplimientoAcuerdo;
    
    
    public Acuerdo(){
        idAcuerdo = 0;
        responsableAcuerdo = "";
        tituloAcuerdo = "";
        numeroAcuerdo = 0;
        cumplimientoAcuerdo = "";
    }
    
    public Acuerdo(int idAcuerdo,String responsableAcuerdo,String tituloAcuerdo, int numeroAcuerdo,String cumplimientoAcuerdo){
        this.idAcuerdo=idAcuerdo;
        this.responsableAcuerdo=responsableAcuerdo;
        this.tituloAcuerdo=tituloAcuerdo;
        this.numeroAcuerdo=numeroAcuerdo;
        this.cumplimientoAcuerdo=cumplimientoAcuerdo;
    }

    public int getIdAcuerdo() {
        return idAcuerdo;
    }

    public void setIdAcuerdo(int idAcuerdo) {
        this.idAcuerdo = idAcuerdo;
    }

    public String getResponsableAcuerdo() {
        return responsableAcuerdo;
    }

    public void setResponsableAcuerdo(String responsableAcuerdo) {
        this.responsableAcuerdo = responsableAcuerdo;
    }

    public String getTituloAcuerdo() {
        return tituloAcuerdo;
    }

    public void setTituloAcuerdo(String tituloAcuerdo) {
        this.tituloAcuerdo = tituloAcuerdo;
    }

    public int getNumeroAcuerdo() {
        return numeroAcuerdo;
    }

    public void setNumeroAcuerdo(int numeroAcuerdo) {
        this.numeroAcuerdo = numeroAcuerdo;
    }

    public String getCumplimientoAcuerdo() {
        return cumplimientoAcuerdo;
    }

    public void setCumplimientoAcuerdo(String cumplimientoAcuerdo) {
        this.cumplimientoAcuerdo = cumplimientoAcuerdo;
    }
}
