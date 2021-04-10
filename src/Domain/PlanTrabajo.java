package Domain;

/**
 *
 * @author Alberto
 */
public class PlanTrabajo {
    private int id;
    private String nombre;
    private String fechaCreacion;
    private String nombreEncargado;
    
    public PlanTrabajo(){
        int id = 0;
        nombre = "";
        fechaCreacion = "";
        nombreEncargado = "";
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setFechaCreacion(String fechaCreacion){
        this.fechaCreacion = fechaCreacion;
    }
    
    public String getFechaCreacion(){
        return fechaCreacion;
    }
    
    public void setNombreEncargado(String nombreEncargado){
       this.nombreEncargado = nombreEncargado;
    }
    
    public String getNombreEncargado(){
        return nombreEncargado;
    }
    
}
