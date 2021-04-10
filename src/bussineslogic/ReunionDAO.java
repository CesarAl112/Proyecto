/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bussineslogic;
import Dataaccess.ConexionBaseDeDatos;
import Domain.Reunion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Alberto
 */
public class ReunionDAO implements IReunionDAO{

    @Override
    public List<Reunion> obtenerReunion() {
        throw new UnsupportedOperationException("Not supported yet.");
    }    
    
    @Override
    public void insertar(Reunion reunion){
         ConexionBaseDeDatos conexionBaseDeDatos = new ConexionBaseDeDatos();
        try(Connection connection=conexionBaseDeDatos.getConectar()){
         String pregunta ="INSERT INTO reunion (id,fechaFin,fechaInicio,tituloReunion"
                 + "lider,lugarReunion,responsableRegistro)"
               +"values( ',',',',',',',')"; 
         PreparedStatement estado = connection.prepareStatement(pregunta);
         estado.setInt(1,reunion.getId());
         estado.setString(2,reunion.getFechaFin());
         estado.setString(3,reunion.getFechaInicio());
         estado.setString(4,reunion.getTituloReunion());
         estado.setString(5,reunion.getLider());
         estado.setString(6,reunion.getLugarReunion());
         estado.setString(7,reunion.getResponsableRegistro());
         estado.execute();
        }  catch (SQLException ex) {
            Logger.getLogger(MinutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    @Override
    public void actualizar(Reunion reunion) {
        
    }

    @Override
    public void eliminar(int id) {
        ConexionBaseDeDatos conexionBaseDeDatos = new ConexionBaseDeDatos();
        try(Connection connection=conexionBaseDeDatos.getConectar()){
            String pregunta = "DROP TABLE reunion FROM";
            PreparedStatement estado = connection.prepareStatement(pregunta);
            estado.setInt(1,id);
        }catch (SQLException ex){
             Logger.getLogger(MinutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
}