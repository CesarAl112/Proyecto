package testdataacess;


import SGP_CA.Domain.Acuerdo;
import SGP_CA.Bussineslogic.AcuerdoDAO;
import org.junit.Assert;

import org.junit.Test;

public class PruebaAcuerdoDAO {
    
    @Test
    public void pruebaObtenerDatosAcuerdo(){       
        AcuerdoDAO acuerdoDAO = new AcuerdoDAO();
        Assert.assertNotNull(acuerdoDAO.obtenerAcuerdo());
    }
    
    @Test
    public void pruebaActualizarDatosAcuerdo(){
        Acuerdo acuerdo = new Acuerdo();        
        acuerdo.setTituloAcuerdo("Computacion");
        acuerdo.getIdAcuerdo();
        acuerdo.setNumeroAcuerdo(14);
        acuerdo.setResponsableAcuerdo("Pedro");
        acuerdo.setCumplimientoAcuerdo("En proceso");
        AcuerdoDAO acuerdoDAO = new AcuerdoDAO();
        Assert.assertTrue(acuerdoDAO.actualizarAcuerdo(acuerdo));
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
        Assert.assertTrue(acuerdoDAO.agregarAcuerdo(acuerdo));
    }
    
    @Test
    public void pruebaEliminarDatosAcuerdo(){
        int idAcuerdo = 2;
        AcuerdoDAO acuerdoDAO = new AcuerdoDAO();
        Assert.assertTrue(acuerdoDAO.eliminarAcuerdo(idAcuerdo));
    }
}