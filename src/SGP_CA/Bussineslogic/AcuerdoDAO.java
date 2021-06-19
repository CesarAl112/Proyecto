package SGP_CA.Bussineslogic;

import SGP_CA.Dataaccess.ConexionBaseDeDatos;
import SGP_CA.Domain.Acuerdo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AcuerdoDAO implements IAcuerdoDAO{
    
    private ConexionBaseDeDatos conexionBaseDeDatos = new ConexionBaseDeDatos();           
    
    @Override
    public ArrayList<Acuerdo> obtenerAcuerdo(){
        ResultSet obtenerResultado;                       
        ArrayList<Acuerdo> acuerdoLista = new ArrayList<>();
        try(Connection conexion=conexionBaseDeDatos.getConectar()){           
            String orden = "SELECT * FROM acuerdo";            
            PreparedStatement estado = conexion.prepareStatement(orden);                                      
            obtenerResultado = estado.executeQuery();  
            
            while(obtenerResultado.next()){               
                try{
                Acuerdo listaAcuerdo = new Acuerdo();
                String[] datos = new String[5];
                
                datos[0] = Integer.toString(obtenerResultado.getInt("idAcuerdo"));
                datos[1] = obtenerResultado.getString("tituloAcuerdo");
                datos[2] = obtenerResultado.getString("responsableAcuerdo");
                datos[3] = obtenerResultado.getString("cumplimientoAcuerdo");
                datos[4] = Integer.toString(obtenerResultado.getInt("numeroAcuerdo"));
                
                listaAcuerdo.setIdAcuerdo(Integer.parseInt(datos[0])); 
                listaAcuerdo.setTituloAcuerdo(datos[1]);
                listaAcuerdo.setResponsableAcuerdo(datos[2]);
                listaAcuerdo.setCumplimientoAcuerdo(datos[3]);
                listaAcuerdo.setNumeroAcuerdo(Integer.parseInt(datos[4]));
                
                acuerdoLista.add(listaAcuerdo);
                }catch(NullPointerException npe){                    
                }
            }

        }catch(SQLException ex){
            Logger.getLogger(AcuerdoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return acuerdoLista;
    }

    @Override
    public boolean agregarAcuerdo(Acuerdo acuerdo) {
        boolean retorno = false;
        try(Connection conexion = conexionBaseDeDatos.getConectar()){
         String orden = "INSERT INTO acuerdo (tituloAcuerdo,responsableAcuerdo,numeroAcuerdo,cumplimientoAcuerdo,idAcuerdo) values(?,?,?,?,?)";
         PreparedStatement estado = conexion.prepareStatement(orden);
         estado.setString(1,acuerdo.getTituloAcuerdo());
         estado.setString(2,acuerdo.getResponsableAcuerdo());
         estado.setInt(3,acuerdo.getNumeroAcuerdo());
         estado.setString(4,acuerdo.getCumplimientoAcuerdo());
         estado.setInt(5,acuerdo.getIdAcuerdo());
         estado.executeUpdate();
         retorno = true;
        }  catch (SQLException ex) {
            Logger.getLogger(AcuerdoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  

       return retorno;
    }

    @Override
    public boolean actualizarAcuerdo(Acuerdo acuerdo) {
        boolean retorno = false;
        try(Connection conexion = conexionBaseDeDatos.getConectar()){
            String orden = "UPDATE acuerdo SET tituloAcuerdo=?,responsableAcuerdo=?,numeroAcuerdo=?,cumplimientoAcuerdo=?"
                    + " WHERE idAcuerdo=?";
            PreparedStatement estado = conexion.prepareStatement(orden);
            estado.setInt(5,acuerdo.getIdAcuerdo());
            estado.setString(4,acuerdo.getCumplimientoAcuerdo());
            estado.setInt(3,acuerdo.getNumeroAcuerdo());
            estado.setString(2,acuerdo.getResponsableAcuerdo());
            estado.setString(1,acuerdo.getTituloAcuerdo());
            estado.executeUpdate();
            retorno = true;
        }catch(SQLException ex){
            Logger.getLogger(AcuerdoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }

    @Override
    public boolean eliminarAcuerdo(int idAcuerdo) {
        boolean retorno = false;
        try(Connection conexion  =conexionBaseDeDatos.getConectar()){
            String orden = "DELETE FROM acuerdo WHERE idAcuerdo = ?";        
            PreparedStatement estado = conexion.prepareStatement(orden);
            estado.setInt(1, idAcuerdo);
            estado.executeUpdate();
            retorno = true;
        }catch (SQLException ex){
             Logger.getLogger(AcuerdoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
}
