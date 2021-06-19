package SGP_CA.Bussineslogic;
import SGP_CA.Domain.Reunion;
import java.util.ArrayList;

/**
 *
 * @author Alberto
 */
public interface IReunionDAO {
    
    public ArrayList<String> obtenerParticipantes();
    public ArrayList<Reunion> obtenerReunion();
    public boolean insertar(Reunion reunion);
    public boolean actualizar(Reunion reunion);
    public boolean eliminar(int idReunion);
}
