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
         String orden ="INSERT INTO reunion (idReunion,tituloReunion,responsableRegistro,"
                 + "asunto,horaInicio,horaFin,lider,lugarReunion,fechaReunion) values(?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
         PreparedStatement estado = connection.prepareStatement(orden);
         estado.setInt(1,reunion.getId());
         estado.setString(2,reunion.getTituloReunion());
         estado.setString(3,reunion.getResponsableRegistro());
         estado.setString(4,reunion.getAsunto());
         estado.setString(5,reunion.getHoraInicio());
         estado.setString(6,reunion.getHoraFin());
         estado.setString(7,reunion.getLider());
         estado.setString(8,reunion.getLugarReunion());
         estado.setString(9,reunion.getFechaReunion());
         estado.executeUpdate();
        }  catch (SQLException ex) {
            Logger.getLogger(ReunionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    @Override
    public void actualizar(Reunion reunion) {
        ConexionBaseDeDatos conexionBaseDeDatos = new ConexionBaseDeDatos();
        try(Connection connection=conexionBaseDeDatos.getConectar()){
         String orden ="UPDATE reunion SET tituloReunion=?,responsableRegistro=?,asunto = ?,horaInicio=?,"
                 + "horaFin=?,lider=?,lugarReunion=?,fechaReunion=? WHERE idReunion=?";
         PreparedStatement estado = connection.prepareStatement(orden);
         estado.setString(1,reunion.getTituloReunion());
         estado.setString(2,reunion.getResponsableRegistro());
         estado.setString(3,reunion.getAsunto());
         estado.setString(4,reunion.getHoraInicio());
         estado.setString(5,reunion.getHoraFin());
         estado.setString(6,reunion.getLider());
         estado.setString(7,reunion.getLugarReunion());
         estado.setString(8,reunion.getFechaReunion());
         estado.setInt(9,reunion.getId());
         estado.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger(ReunionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(int id) {
        ConexionBaseDeDatos conexionBaseDeDatos = new ConexionBaseDeDatos();
        try(Connection connection=conexionBaseDeDatos.getConectar()){
            String pregunta = "DELETE FROM reunion WHERE idReunion=?";
            PreparedStatement estado = connection.prepareStatement(pregunta);
            estado.setInt(1,id);
            estado.executeUpdate();
        }catch (SQLException ex){
             Logger.getLogger(ReunionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
}