package testdataacess;

import SGP_CA.Bussineslogic.AccesoDAO;
import org.junit.Assert;

import org.junit.Test;

/**
 *
 * @author Alberto
 */
public class PruebaAccesoDAO {
    
    @Test
    public void pruebaValidarUsuarioContraseñaIntegrante(){
        AccesoDAO accesoDAO = new AccesoDAO();
        String usuario = "Juan Carlos";
        String contraseña = "Contraseña123";
        Assert.assertTrue(accesoDAO.validarUsuarioContraseñaIntegrante(usuario, contraseña));
    }
      
    @Test
    public void pruebaValidarUsuarioContraseñaResponsable(){
        AccesoDAO accesoDAO = new AccesoDAO();
        String usuario = "Paco";
        String contraseña = "Pacohz54";
        Assert.assertTrue(accesoDAO.validarUsuarioContraseñaResponsable(usuario, contraseña));
    }  
}
