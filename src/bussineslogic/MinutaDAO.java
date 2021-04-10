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
    public void actualizar(int id) {
      
}

    @Override
    public void insertar(Minuta minuta){
        ConexionBaseDeDatos conexionBaseDeDatos = new ConexionBaseDeDatos();
        try(Connection connection=conexionBaseDeDatos.getConectar()){
         String pregunta ="INSERT INTO MINUTA (id,NombreParticipante,Pendiente,Notas,Fecha_creacion)"
               +"values( ',' ,' ,' ,')"; 
         PreparedStatement estado = connection.prepareStatement(pregunta);
         estado.setInt(1,minuta.getID());
         estado.setString(2,minuta.getNombreParticipante());
         estado.setString(3,minuta.getPendiente());
         estado.setString(4,minuta.getNotas());
         estado.setString(5,minuta.getFechaCreacion());
         estado.execute();
        }  catch (SQLException ex) {
            Logger.getLogger(MinutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    @Override
    public void eliminar(int id){
        ConexionBaseDeDatos conexionBaseDeDatos = new ConexionBaseDeDatos();
        try(Connection connection=conexionBaseDeDatos.getConectar()){
            String pregunta = "DROP TABLE Minuta FROM";
            PreparedStatement estado = connection.prepareStatement(pregunta);
            estado.setInt(1,id);
        }catch (SQLException ex){
             Logger.getLogger(MinutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}