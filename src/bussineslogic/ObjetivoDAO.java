/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussineslogic;

import Dataaccess.ConexionBaseDeDatos;
import Domain.Objetivo;
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
public class ObjetivoDAO implements IObjetivoDAO{

     @Override
    public List<Objetivo> obtenerObjetivo() {
        return null;
    }
    
    @Override
    public void insertar(Objetivo objetivo) {
        ConexionBaseDeDatos conexionBaseDeDatos = new ConexionBaseDeDatos();
        try(Connection connection=conexionBaseDeDatos.getConectar()){
         String orden ="INSERT INTO objetivo (idObjetivo,tituloObjetivo,descripcionObjetivo,estadoObjetivo)"
               +"values( ?, ?, ?, ?)"; 
         PreparedStatement estado = connection.prepareStatement(orden);
         estado.setInt(1,objetivo.getIdObjetivo());
         estado.setString(2,objetivo.getTituloObjetivo());
         estado.setString(3,objetivo.getDescripcionObjetivo());
         estado.setString(4,objetivo.getEstadoObjetivo());
         estado.executeUpdate();
        }  catch (SQLException ex) {
            Logger.getLogger(ObjetivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    @Override
    public void actualizar(Objetivo objetivo) {
        ConexionBaseDeDatos conexionBaseDeDatos = new ConexionBaseDeDatos();
        try(Connection connection=conexionBaseDeDatos.getConectar()){
            String orden="UPDATE objetivo SET TituloObjetivo=?,descripcionObjetivo=?,estadoObjetivo=? WHERE idObjetivo=?";
            PreparedStatement estado = connection.prepareStatement(orden);
            estado.setString(1, objetivo.getDescripcionObjetivo());
            estado.setString(2, objetivo.getEstadoObjetivo());
            estado.setString(3, objetivo.getTituloObjetivo());
            estado.setInt(4, objetivo.getIdObjetivo());
            estado.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger(ObjetivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(int id) {
         ConexionBaseDeDatos conexionBaseDeDatos = new ConexionBaseDeDatos();
        try(Connection connection=conexionBaseDeDatos.getConectar()){
            String pregunta = "DELETE FROM objetivo WHERE idObjetivo=?";
            PreparedStatement estado = connection.prepareStatement(pregunta);
            estado.setInt(1,id);
            estado.executeUpdate();
        }catch (SQLException ex){
             Logger.getLogger(ObjetivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    
}
