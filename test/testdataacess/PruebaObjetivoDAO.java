
package testdataacess;

import SGP_CA.Domain.Objetivo;
import SGP_CA.Bussineslogic.ObjetivoDAO;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Alberto
 */
public class PruebaObjetivoDAO {
    
    @Test
    public void PruebaObtenerNombre(){
        ObjetivoDAO objetivoDAO = new ObjetivoDAO();
        Assert.assertNotNull(objetivoDAO.obtenerNombreObjetivo());
    }
    
    @Test
    public void PruebaObtenerPorId(){
        int idObjetivo = 1;
        ObjetivoDAO objetivoDAO = new ObjetivoDAO();
        Assert.assertNotNull(objetivoDAO.obtenerPorId(idObjetivo));
    }
    
    @Test
    public void PruebaObtenerObjetivo(){
        ObjetivoDAO objetivoDAO = new ObjetivoDAO();
        Assert.assertNotNull(objetivoDAO.obtenerObjetivo());
    }
    
    @Test
    public void PruebaInsertarObjetivoDAO(){
        Objetivo objetivo = new Objetivo();
        objetivo.setDescripcionObjetivo("En esta reunion");
        objetivo.setEstadoObjetivo("En proceso");
        objetivo.setIdObjetivo(1);
        objetivo.setTituloObjetivo("Educacion");
        
        ObjetivoDAO objetivoDAO = new ObjetivoDAO();
        Assert.assertTrue(objetivoDAO.agregarObjetivo(objetivo));
    }
    
    @Test
    public void PruebaActualizarDatosObjetivoDAO(){
        Objetivo objetivo = new Objetivo();
        objetivo.setDescripcionObjetivo("El objetivo es...");
        objetivo.setEstadoObjetivo("Cumplido");
        objetivo.setIdObjetivo(1);
        objetivo.setTituloObjetivo("Computacion");
        
        ObjetivoDAO objetivoDAO = new ObjetivoDAO();
        Assert.assertTrue(objetivoDAO.actualizarObjetivo(objetivo));        
    }
    
    @Test 
    public void PruebaEliminarObjetivoDAO(){
       int id=1;
       ObjetivoDAO objetivoDAO = new ObjetivoDAO();
       Assert.assertTrue(objetivoDAO.eliminarObjetivo(id));
    }
    
    
}
