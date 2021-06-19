/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SGP_CA.Bussineslogic;

import SGP_CA.Dataaccess.ConexionBaseDeDatos;

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
public class AccesoDAO implements IAccesoDAO{
    
    private ConexionBaseDeDatos conexionBaseDeDatos = new ConexionBaseDeDatos();
    
    @Override
    public boolean validarUsuarioContraseñaIntegrante(String usuario, String contraseña) {
        boolean retorno = false;
        ResultSet obtenerResultado;          
        try(Connection conexion = conexionBaseDeDatos.getConectar()){
            String orden = "SELECT usuario FROM integrante WHERE usuario = '"+usuario+"' AND contraseña = '"+contraseña+"' ";
            PreparedStatement estado = conexion.prepareStatement(orden);
            obtenerResultado = estado.executeQuery();        
            
            if(obtenerResultado.next()){
                retorno=true;
            }            
        }catch(SQLException ex){
            Logger.getLogger(ReunionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
  
    @Override
    public boolean validarUsuarioContraseñaResponsable(String usuario, String contraseña) {
        boolean retorno = false;
        ResultSet obtenerResultado;          
        try(Connection conexion = conexionBaseDeDatos.getConectar()){
            String orden = "SELECT * FROM responsable WHERE usuario = '"+usuario+"' AND contraseña = '"+contraseña+"' ";
            PreparedStatement estado = conexion.prepareStatement(orden);
            obtenerResultado = estado.executeQuery();
            
            if(obtenerResultado.next()){
                retorno = true;
            }
        }catch(SQLException ex){
            Logger.getLogger(ReunionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
    
}
