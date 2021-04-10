package bussineslogic;
import Domain.Reunion;
import java.util.List;
/**
 *
 * @author Alberto
 */
public interface IReunionDAO {
    List<Reunion> obtenerReunion();
    public void insertar(Reunion reunion);
    public void actualizar(Reunion reunion);
    public void eliminar(int id);
}
