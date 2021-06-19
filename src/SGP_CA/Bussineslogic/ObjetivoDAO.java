/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SGP_CA.Bussineslogic;

import SGP_CA.Dataaccess.ConexionBaseDeDatos;

import SGP_CA.Domain.Objetivo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alberto
 */
public class ObjetivoDAO implements IObjetivoDAO{
    
    private ConexionBaseDeDatos conexionBaseDeDatos = new ConexionBaseDeDatos();
    
    @Override
    public ArrayList<String> obtenerNombreObjetivo(){
        ResultSet obtenerResultado;  
        ArrayList<String> objetivoLista = new ArrayList<>();
        try(Connection conexion = conexionBaseDeDatos.getConectar()){
            String orden = "SELECT tituloObjetivo FROM objetivo";
            PreparedStatement estado = conexion.prepareStatement(orden);
            obtenerResultado = estado.executeQuery();
            while(obtenerResultado.next()){
                String nombre;
                nombre = obtenerResultado.getString("tituloObjetivo");
                
                objetivoLista.add(nombre);
            }
        }catch(SQLException ex){
            Logger.getLogger(ReunionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return objetivoLista;
    }  
    
     @Override
    public ArrayList<Objetivo> obtenerObjetivo() {
          ResultSet obtenerResultado;         
        ArrayList<Objetivo> objetivoLista = new ArrayList<>();          
        try(Connection conexion = conexionBaseDeDatos.getConectar()){
            String orden = "SELECT * FROM objetivo";
            PreparedStatement estado = conexion.prepareStatement(orden);
            obtenerResultado = estado.executeQuery();
            
            while(obtenerResultado.next()){                
                try{
                    Objetivo listaObjetivo = new Objetivo();
                    String[] datos = new String[4];                                                                                      
                    
                    datos[0] = Integer.toString(obtenerResultado.getInt("idObjetivo"));
                    datos[1] = obtenerResultado.getString("tituloObjetivo");
                    datos[2] = obtenerResultado.getString("descripcionObjetivo");
                    datos[3] = obtenerResultado.getString("estadoObjetivo");              

                    listaObjetivo.setIdObjetivo(Integer.parseInt(datos[0]));
                    listaObjetivo.setTituloObjetivo(datos[1]);
                    listaObjetivo.setDescripcionObjetivo(datos[2]);
                    listaObjetivo.setEstadoObjetivo(datos[3]);                                      
                    
                    objetivoLista.add(listaObjetivo);
                }catch(NullPointerException npe){
                    
                }
            }                        
        }catch(SQLException ex){
            Logger.getLogger(ReunionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return objetivoLista;
    }
    
    @Override
    public boolean agregarObjetivo(Objetivo objetivo) {
        boolean retorno=false;
        try(Connection connection=conexionBaseDeDatos.getConectar()){
         String orden ="INSERT INTO objetivo (idObjetivo,tituloObjetivo,descripcionObjetivo,estadoObjetivo)"
               +"values( ?, ?, ?, ?)"; 
         PreparedStatement estado = connection.prepareStatement(orden);
         estado.setInt(1,objetivo.getIdObjetivo());
         estado.setString(2,objetivo.getTituloObjetivo());
         estado.setString(3,objetivo.getDescripcionObjetivo());
         estado.setString(4,objetivo.getEstadoObjetivo());
         estado.executeUpdate();
         retorno=true;
        }  catch (SQLException ex) {
            Logger.getLogger(ObjetivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  

        return retorno;
    }

    @Override
    public boolean actualizarObjetivo(Objetivo objetivo) {
        boolean retorno=false;
        try(Connection connection=conexionBaseDeDatos.getConectar()){
            String orden="UPDATE objetivo SET TituloObjetivo=?,descripcionObjetivo=?,estadoObjetivo=? WHERE idObjetivo=?";
            PreparedStatement estado = connection.prepareStatement(orden);
            estado.setString(1, objetivo.getDescripcionObjetivo());
            estado.setString(2, objetivo.getEstadoObjetivo());
            estado.setString(3, objetivo.getTituloObjetivo());
            estado.setInt(4, objetivo.getIdObjetivo());
            estado.executeUpdate();
            retorno=true;
        }catch(SQLException ex){
            Logger.getLogger(ObjetivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }

    @Override
    public boolean eliminarObjetivo(int id) {
        boolean retorno=false;
        try(Connection connection=conexionBaseDeDatos.getConectar()){
            String pregunta = "DELETE FROM objetivo WHERE idObjetivo=?";
            PreparedStatement estado = connection.prepareStatement(pregunta);
            estado.setInt(1,id);
            estado.executeUpdate();
            retorno=true;
        }catch (SQLException ex){
             Logger.getLogger(ObjetivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }

   
    
}
