package Dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author Alberto
 */
public class ConexionBaseDeDatos {
    private Connection conexion;
    public String db = "jdbc:mysql://db4free.net/proyectofinalcu";
    public String usuario = "axel28";
    public String contrasena = "Panama123";


   public Connection getConectar() throws SQLException{
       connect();
       return conexion;
   }

    private void connect() throws SQLException {
        conexion=DriverManager.getConnection(db,usuario,contrasena);
    }
    
    public void cerrarConexion(){
        if(conexion!=null){
            try{
                if(!conexion.isClosed()){
                    conexion.close();
                }
            }catch(SQLException ex) {
                Logger.getLogger(ConexionBaseDeDatos.class.getName()).log(Level.SEVERE,null, ex);
                }
        }
    }
}   
    