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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void insertar(Objetivo objetivo) {
        ConexionBaseDeDatos conexionBaseDeDatos = new ConexionBaseDeDatos();
        try(Connection connection=conexionBaseDeDatos.getConectar()){
         String pregunta ="INSERT INTO objetivo (id,DescripcionObjetivo,EstadoObjetivo,TituloObjetivo)"
               +"values( ',' ,' ,' ,')"; 
         PreparedStatement estado = connection.prepareStatement(pregunta);
         estado.setInt(1,objetivo.getIdObjetivo());
         estado.setString(2,objetivo.getDescripcionObjetivo());
         estado.setString(3,objetivo.getEstadoObjetivo());
         estado.setString(4,objetivo.getTituloObjetivo());
         estado.execute();
        }  catch (SQLException ex) {
            Logger.getLogger(MinutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    @Override
    public void actualizar(Objetivo objetivo) {
        
    }

    @Override
    public void eliminar(int id) {
         ConexionBaseDeDatos conexionBaseDeDatos = new ConexionBaseDeDatos();
        try(Connection connection=conexionBaseDeDatos.getConectar()){
            String pregunta = "DROP TABLE Objetivo FROM";
            PreparedStatement estado = connection.prepareStatement(pregunta);
            estado.setInt(1,id);
        }catch (SQLException ex){
             Logger.getLogger(MinutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    
}
