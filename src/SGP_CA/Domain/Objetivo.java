package SGP_CA.Domain;

/**
 *
 * @author Alberto
 */
public class Objetivo {
    private int idObjetivo;
    private String TituloObjetivo;
    private String DescripcionObjetivo;
    private String EstadoObjetivo;

    public int getIdObjetivo() {
        return idObjetivo;
    }

    public void setIdObjetivo(int idObjetivo) {
        this.idObjetivo = idObjetivo;
    }

    public String getTituloObjetivo() {
        return TituloObjetivo;
    }

    public void setTituloObjetivo(String TituloObjetivo) {
        this.TituloObjetivo = TituloObjetivo;
    }

    public String getDescripcionObjetivo() {
        return DescripcionObjetivo;
    }

    public void setDescripcionObjetivo(String DescripcionObjetivo) {
        this.DescripcionObjetivo = DescripcionObjetivo;
    }

    public String getEstadoObjetivo() {
        return EstadoObjetivo;
    }

    public void setEstadoObjetivo(String EstadoObjetivo) {
        this.EstadoObjetivo = EstadoObjetivo;
    }

}
