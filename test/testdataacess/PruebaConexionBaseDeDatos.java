package testdataacess;

import java.sql.Connection;
import java.sql.SQLException;

import SGP_CA.Dataaccess.ConexionBaseDeDatos;

import org.junit.Test;
import org.junit.Assert;
/**
 *
 * @author Alberto
 */
public class PruebaConexionBaseDeDatos {
    @Test
    public void PruebaConexionBaseDeDatos() throws SQLException{
        Connection conexionActual=new ConexionBaseDeDatos().getConectar();
        Assert.assertNotNull(conexionActual);
    }   
   
}