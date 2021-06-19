package SGP_CA.Dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;

public class ConexionBaseDeDatos {
    private Connection conexion;
    public String db = "jdbc:mysql://bnolc1ejdbfzv0rsa4ot-mysql.services.clever-cloud.com /bnolc1ejdbfzv0rsa4ot";
    public String usuario = "uflm615hng2ad2cc";
    public String contrasena = "T0iTnLPjUaObcOI4N4Av";


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
    