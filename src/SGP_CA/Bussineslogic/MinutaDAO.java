package SGP_CA.Bussineslogic;

import SGP_CA.Domain.Minuta;

import SGP_CA.Dataaccess.ConexionBaseDeDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import java.util.List;
import java.util.Date;
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
    public boolean insertar(Minuta minuta){
        boolean retorno=false;
        Date fecha;
        fecha = minuta.getFechaCreacion();
        String fechaAString = fecha.toInstant().atOffset(ZoneOffset.UTC).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
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
         estado.setString(7,fechaAString);
         estado.executeUpdate();
         retorno=true;
        }  catch (SQLException ex) {
            Logger.getLogger(MinutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
        conexionBaseDeDatos.cerrarConexion();
        return retorno;
    }
    
    @Override
    public boolean eliminar(int id){
        boolean retorno=false;
        ConexionBaseDeDatos conexionBaseDeDatos = new ConexionBaseDeDatos();
        try(Connection connection=conexionBaseDeDatos.getConectar()){
            String orden = "DELETE FROM minuta WHERE idMinuta=?";
            PreparedStatement estado = connection.prepareStatement(orden);
            estado.setInt(1,id);
            estado.executeUpdate();
            retorno=true;
        }catch (SQLException ex){
             Logger.getLogger(MinutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexionBaseDeDatos.cerrarConexion();
        return retorno;
    }
    
}