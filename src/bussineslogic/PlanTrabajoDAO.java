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
         String orden ="INSERT INTO plantrabajo (idPlanTrabajo,tituloPlanTrabajo,nombreEncargado,meta,estrategia,numeroEstrategia,"
                 + "resultado,fechaInicio,fechaFin) values(?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
         PreparedStatement estado = connection.prepareStatement(orden);
         estado.setInt(1,planTrabajo.getIdPlanTrabajo());
         estado.setString(2,planTrabajo.getTituloPlanTrabajo());
         estado.setString(3,planTrabajo.getNombreEncargado());
         estado.setString(4,planTrabajo.getMeta());
         estado.setString(5,planTrabajo.getEstrategia());
         estado.setInt(6,planTrabajo.getNumeroEstrategia());
         estado.setString(7,planTrabajo.getResultado());
         estado.setString(8,planTrabajo.getFechaInicio());
         estado.setString(9,planTrabajo.getFechaFin());
         estado.executeUpdate();
        }  catch (SQLException ex) {
            Logger.getLogger(PlanTrabajoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    @Override
    public void actualizar(PlanTrabajo planTrabajo) {
        ConexionBaseDeDatos conexionBaseDeDatos = new ConexionBaseDeDatos();
        try(Connection connection=conexionBaseDeDatos.getConectar()){
            String orden ="UPDATE plantrabajo SET tituloPlanTrabajo=?,nombreEncargado=?,meta=?,estrategia=?,numeroEstrategia=?,"
                 + "resultado=?,fechaInicio=?,fechaFin=? WHERE idPlanTrabajo=?";
            PreparedStatement estado = connection.prepareStatement(orden);
            estado.setString(1,planTrabajo.getTituloPlanTrabajo());
            estado.setString(2,planTrabajo.getNombreEncargado());
            estado.setString(3,planTrabajo.getMeta());
            estado.setString(4,planTrabajo.getEstrategia());
            estado.setInt(5,planTrabajo.getNumeroEstrategia());
            estado.setString(6,planTrabajo.getResultado());
            estado.setString(7,planTrabajo.getFechaInicio());
            estado.setString(8,planTrabajo.getFechaFin());
            estado.setInt(9,planTrabajo.getIdPlanTrabajo());
            estado.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger(PlanTrabajoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(int id) {
        ConexionBaseDeDatos conexionBaseDeDatos = new ConexionBaseDeDatos();
        try(Connection connection=conexionBaseDeDatos.getConectar()){
            String orden = "DELETE FROM plantrabajo WHERE idPlanTrabajo=?";
            PreparedStatement estado = connection.prepareStatement(orden);
            estado.setInt(1,id);
            estado.executeUpdate();
        }catch (SQLException ex){
             Logger.getLogger(PlanTrabajoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
