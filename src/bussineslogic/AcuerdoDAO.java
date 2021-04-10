/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussineslogic;

import Dataaccess.ConexionBaseDeDatos;
import Domain.Acuerdo;
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
public class AcuerdoDAO implements IAcuerdoDAO{

    @Override
    public List<Acuerdo> obtenerAcuerdo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertar(Acuerdo acuerdo) {
         ConexionBaseDeDatos conexionBaseDeDatos = new ConexionBaseDeDatos();
        try(Connection connection=conexionBaseDeDatos.getConectar()){
         String pregunta ="INSERT INTO acuerdo (id,CumplimientoAcuerdo,numeroAcuerdo,responsableAcuerdo,tituloAcuerdo)"
               +"values( ',' ,' ,' ,')"; 
         PreparedStatement estado = connection.prepareStatement(pregunta);
         estado.setInt(1,acuerdo.getIdAcuerdo());
         estado.setString(2,acuerdo.getCumplimientoAcuerdo());
         estado.setString(3,acuerdo.getNumeroAcuerdo());
         estado.setString(4,acuerdo.getResponsableAcuerdo());
         estado.setString(5,acuerdo.getTituloAcuerdo());
         estado.execute();
        }  catch (SQLException ex) {
            Logger.getLogger(MinutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    @Override
    public void actualizar(Acuerdo acuerdo) {
        
    }

    @Override
    public void eliminar(int id) {
       ConexionBaseDeDatos conexionBaseDeDatos = new ConexionBaseDeDatos();
        try(Connection connection=conexionBaseDeDatos.getConectar()){
            PreparedStatement estado = connection.prepareStatement(pregunta);
            estado.setInt(1,id);
        }catch (SQLException ex){
             Logger.getLogger(MinutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
