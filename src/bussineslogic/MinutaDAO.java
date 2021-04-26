/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bussineslogic;

import Domain.Minuta;
import Dataaccess.ConexionBaseDeDatos;
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
public class MinutaDAO implements IMinutaDAO{

    @Override
    public List<Minuta> obtenerMinuta(){
        return null;
    }
    
    @Override
    public void actualizar(Minuta minuta) {
         ConexionBaseDeDatos conexionBaseDeDatos = new ConexionBaseDeDatos();
         try(Connection connection=conexionBaseDeDatos.getConectar()){
             String orden = "UPDATE minuta SET nombreParticipante=?,nombreEncargado=?, nombreReunion=?,"
                     + "pendientes=?,notas=?,fechaCreacion=? WHERE idMinuta=?";
             PreparedStatement estado = connection.prepareStatement(orden);
             estado.setInt(7, minuta.getIDMinuta());
             estado.setString(1,minuta.getNombreParticipante());
             estado.setString(2,minuta.getNombreEncargado());
             estado.setString(3,minuta.getNombreReunion());
             estado.setString(4,minuta.getPendientes());
             estado.setString(5,minuta.getNotas());
             estado.setString(6,minuta.getFechaCreacion());
             estado.executeUpdate();
         }catch(SQLException ex){
             Logger.getLogger(MinutaDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @Override
    public void insertar(Minuta minuta){
        ConexionBaseDeDatos conexionBaseDeDatos = new ConexionBaseDeDatos();
        try(Connection connection=conexionBaseDeDatos.getConectar()){
         String orden ="INSERT INTO minuta (idMinuta,nombreParticipante,nombreEncargado,nombreReunion,"
                 + "pendientes,notas,fechaCreacion)values( ?, ?, ?, ?, ?, ?, ?)"; 
         PreparedStatement estado = connection.prepareStatement(orden);
         estado.setInt(1,minuta.getIDMinuta());
         estado.setString(2,minuta.getNombreParticipante());
         estado.setString(3,minuta.getNombreEncargado());
         estado.setString(4,minuta.getNombreReunion());
         estado.setString(5,minuta.getPendientes());
         estado.setString(6,minuta.getNotas());
         estado.setString(7,minuta.getFechaCreacion());
         estado.executeUpdate();
        }  catch (SQLException ex) {
            Logger.getLogger(MinutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    @Override
    public void eliminar(int id){
        ConexionBaseDeDatos conexionBaseDeDatos = new ConexionBaseDeDatos();
        try(Connection connection=conexionBaseDeDatos.getConectar()){
            String orden = "DELETE FROM minuta WHERE idMinuta=?";
            PreparedStatement estado = connection.prepareStatement(orden);
            estado.setInt(1,id);
            estado.executeUpdate();
        }catch (SQLException ex){
             Logger.getLogger(MinutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}