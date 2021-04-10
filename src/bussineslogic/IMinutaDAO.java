package bussineslogic;
import Domain.Minuta;
import java.util.List;

public interface IMinutaDAO {
    public List<Minuta> obtenerMinuta();
    public void actualizar(int id);
    public void insertar(Minuta minuta);
    public void eliminar(int id);

}
