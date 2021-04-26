package bussineslogic;
import Domain.Minuta;
import java.util.List;

public interface IMinutaDAO {
    public List<Minuta> obtenerMinuta();
    public void actualizar(Minuta minuta);
    public void insertar(Minuta minuta);
    public void eliminar(int id);

}
