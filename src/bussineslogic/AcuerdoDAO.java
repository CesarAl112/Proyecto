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
         String orden ="INSERT INTO acuerdo (tituloAcuerdo,responsableAcuerdo,numeroAcuerdo,cumplimientoAcuerdo,idAcuerdo) values( ?, ?, ?, ?, ?)";
         PreparedStatement estado = connection.prepareStatement(orden);
         estado.setString(1,acuerdo.getTituloAcuerdo());
         estado.setString(2,acuerdo.getResponsableAcuerdo());
         estado.setInt(3,acuerdo.getNumeroAcuerdo());
         estado.setString(4,acuerdo.getCumplimientoAcuerdo());
         estado.setInt(5,acuerdo.getIdAcuerdo());
         estado.executeUpdate();
        }  catch (SQLException ex) {
            Logger.getLogger(AcuerdoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    @Override
    public void actualizar(Acuerdo acuerdo) {
        ConexionBaseDeDatos conexionBaseDeDatos = new ConexionBaseDeDatos();
        try(Connection connection=conexionBaseDeDatos.getConectar()){
            String orden = "UPDATE acuerdo SET tituloAcuerdo=?,responsableAcuerdo=?,numeroAcuerdo=?,cumplimientoAcuerdo=?"
                    + " WHERE idAcuerdo=?";
            PreparedStatement estado = connection.prepareStatement(orden);
            estado.setInt(5,acuerdo.getIdAcuerdo());
            estado.setString(4,acuerdo.getCumplimientoAcuerdo());
            estado.setInt(3,acuerdo.getNumeroAcuerdo());
            estado.setString(2,acuerdo.getResponsableAcuerdo());
            estado.setString(1,acuerdo.getTituloAcuerdo());
            estado.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger(AcuerdoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(int idAcuerdo) {
       ConexionBaseDeDatos conexionBaseDeDatos = new ConexionBaseDeDatos();
        try(Connection connection=conexionBaseDeDatos.getConectar()){
            String orden ="DELETE FROM acuerdo WHERE idAcuerdo=?";        
            PreparedStatement estado = connection.prepareStatement(orden);
            estado.setInt(idAcuerdo, idAcuerdo);
            estado.executeUpdate();
        }catch (SQLException ex){
             Logger.getLogger(AcuerdoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
