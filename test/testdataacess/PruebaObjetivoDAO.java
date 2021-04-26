
package testdataacess;

import Domain.Objetivo;
import bussineslogic.ObjetivoDAO;
import org.junit.Test;

/**
 *
 * @author Alberto
 */
public class PruebaObjetivoDAO {
    @Test
    public void PruebaInsertarObjetivoDAO(){
        Objetivo objetivo = new Objetivo();
        objetivo.setDescripcionObjetivo("En esta reunion");
        objetivo.setEstadoObjetivo("En proceso");
        objetivo.setIdObjetivo(1);
        objetivo.setTituloObjetivo("Educacion");
        
        ObjetivoDAO objetivoDAO = new ObjetivoDAO();
        objetivoDAO.insertar(objetivo);
    }
    
    @Test
    public void PruebaActualizarDatosObjetivoDAO(){
        Objetivo objetivo = new Objetivo();
        objetivo.setDescripcionObjetivo("El objetivo es...");
        objetivo.setEstadoObjetivo("Cumplido");
        objetivo.setIdObjetivo(1);
        objetivo.setTituloObjetivo("Computacion");
        
        ObjetivoDAO objetivoDAO = new ObjetivoDAO();
        objetivoDAO.actualizar(objetivo);
    }
    
    @Test 
    public void PruebaEliminarObjetivoDAO(){
       int id=1;
       ObjetivoDAO objetivoDAO = new ObjetivoDAO();
       objetivoDAO.eliminar(id);
    }
    
    
}
