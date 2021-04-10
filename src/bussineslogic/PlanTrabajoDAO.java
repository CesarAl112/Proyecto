/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bussineslogic;

import Dataaccess.ConexionBaseDeDatos;
import Domain.PlanTrabajo;
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
public class PlanTrabajoDAO implements IPlanTrabajoDAO{

    @Override
    public List<PlanTrabajo> obtenerPlanTrabajo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertar(PlanTrabajo planTrabajo) {
       ConexionBaseDeDatos conexionBaseDeDatos = new ConexionBaseDeDatos();
        try(Connection connection=conexionBaseDeDatos.getConectar()){
         String pregunta ="INSERT INTO planTrabajo (id,nombre,nombreEncargado,fechaCreacion)"
               +"values( ',' ,' ,' ,')"; 
         PreparedStatement estado = connection.prepareStatement(pregunta);
         estado.setInt(1,planTrabajo.getId());
         estado.setString(2,planTrabajo.getNombre());
         estado.setString(3,planTrabajo.getNombreEncargado());
         estado.setString(4,planTrabajo.getFechaCreacion());
         estado.execute();
        }  catch (SQLException ex) {
            Logger.getLogger(MinutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    @Override
    public void actualizar(PlanTrabajo plan_Trabajo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int id) {
        ConexionBaseDeDatos conexionBaseDeDatos = new ConexionBaseDeDatos();
        try(Connection connection=conexionBaseDeDatos.getConectar()){
            String pregunta = "DROP TABLE PlanTrabajo FROM";
            PreparedStatement estado = connection.prepareStatement(pregunta);
            estado.setInt(1,id);
        }catch (SQLException ex){
             Logger.getLogger(MinutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
