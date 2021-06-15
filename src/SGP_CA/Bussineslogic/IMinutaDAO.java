package SGP_CA.Bussineslogic;
import SGP_CA.Domain.Minuta;
import java.util.List;




public interface IMinutaDAO {    
    
    public List<Minuta> obtenerMinuta();  
    public boolean insertar(Minuta minuta);
    public boolean eliminar(int id);

}
