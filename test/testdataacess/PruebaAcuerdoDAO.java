package testdataacess;


import Domain.Acuerdo;
import bussineslogic.AcuerdoDAO;

import org.junit.Test;

/**
 *
 * @author Alberto
 */
public class PruebaAcuerdoDAO {
    
    
    
    @Test
    public void pruebaActualizarDatosAcuerdo(){
        Acuerdo acuerdo = new Acuerdo();
        
        acuerdo.setTituloAcuerdo("Computacion");
        acuerdo.setIdAcuerdo(1);
        acuerdo.setNumeroAcuerdo(14);
        acuerdo.setResponsableAcuerdo("Pedro");
        acuerdo.setCumplimientoAcuerdo("En proceso");
        
        AcuerdoDAO acuerdoDAO = new AcuerdoDAO();
        acuerdoDAO.actualizar(acuerdo);
    }
    
 
    
    @Test
    public void pruebaInsertarDatosAcuerdo(){
        Acuerdo acuerdo = new Acuerdo();
        String titulo = "Educacion";
        String nombre = "Juan";
        int numero = 12;
        String cumplimiento = "Acuerdo";
        int id = 1;
        
        acuerdo.setTituloAcuerdo(titulo);
        acuerdo.setResponsableAcuerdo(nombre);
        acuerdo.setNumeroAcuerdo(numero);
        acuerdo.setCumplimientoAcuerdo(cumplimiento);
        acuerdo.setIdAcuerdo(id);
       
        AcuerdoDAO acuerdoDAO = new AcuerdoDAO();
        acuerdoDAO.insertar(acuerdo);
    }
    
    @Test
    public void pruebaEliminarDatosAcuerdo(){
        int idAcuerdo =1;
        AcuerdoDAO acuerdoDAO = new AcuerdoDAO();
        acuerdoDAO.eliminar(idAcuerdo);
        
    }
}
