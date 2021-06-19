/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SGP_CA.Bussineslogic;
import SGP_CA.Dataaccess.ConexionBaseDeDatos;

import SGP_CA.Domain.Reunion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Alberto
 */
public class ReunionDAO implements IReunionDAO{
    
    private DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    private DateFormat formatoHora = new SimpleDateFormat("HH:mm");
    private ConexionBaseDeDatos conexionBaseDeDatos = new ConexionBaseDeDatos();
    
    @Override
    public ArrayList<String> obtenerParticipantes(){
        ResultSet obtenerResultado;  
        ArrayList<String> participanteLista = new ArrayList<>();
        try(Connection conexion = conexionBaseDeDatos.getConectar()){
            String orden = "SELECT nombre FROM integrante";
            PreparedStatement estado = conexion.prepareStatement(orden);
            obtenerResultado = estado.executeQuery();
            while(obtenerResultado.next()){
                String nombre;                
                nombre = obtenerResultado.getString("nombre");
                
                participanteLista.add(nombre);
            }
        }catch(SQLException ex){
            Logger.getLogger(ReunionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return participanteLista;
    }

    @Override
    public ArrayList<Reunion> obtenerReunion() {        
        ResultSet obtenerResultado;         
        ArrayList<Reunion> reunionLista = new ArrayList<>();          
        try(Connection conexion = conexionBaseDeDatos.getConectar()){
            String orden = "SELECT * FROM reunion";
            PreparedStatement estado = conexion.prepareStatement(orden);
            obtenerResultado = estado.executeQuery();
            
            while(obtenerResultado.next()){                
                try{
                    Reunion datosReunion = new Reunion();
                    String[] datos = new String[9];                                                                                      
                    
                    datos[0] = Integer.toString(obtenerResultado.getInt("idReunion"));
                    datos[1] = obtenerResultado.getString("tituloReunion");
                    datos[2] = obtenerResultado.getString("responsableRegistro");
                    datos[3] = obtenerResultado.getString("asunto");
                    datos[4] = formatoHora.format(obtenerResultado.getTime("horaInicio"));
                    datos[5] = formatoHora.format(obtenerResultado.getTime("horaFin"));
                    datos[6] = obtenerResultado.getString("lider");
                    datos[7] = obtenerResultado.getString("lugarReunion");
                    datos[8] = formatoFecha.format(obtenerResultado.getDate("fechaReunion"));

                    datosReunion.setIdReunion(Integer.parseInt(datos[0]));
                    datosReunion.setTituloReunion(datos[1]);
                    datosReunion.setResponsableRegistro(datos[2]);
                    datosReunion.setAsunto(datos[3]);                    
                    datosReunion.setHoraInicio(formatoHora.parse(datos[4]));
                    datosReunion.setHoraFin(formatoHora.parse(datos[5])); 
                    datosReunion.setLider(datos[6]);
                    datosReunion.setLugarReunion(datos[7]);
                    datosReunion.setFechaReunion(formatoFecha.parse(datos[8]));
                    
                    reunionLista.add(datosReunion);
                }catch(NullPointerException | ParseException npe){
                    
                }
            }                        
        }catch(SQLException ex){
            Logger.getLogger(ReunionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return reunionLista;
    }    
    
    @Override
    public boolean insertar(Reunion reunion){
        boolean retorno=false;                         
        try(Connection conexion=conexionBaseDeDatos.getConectar()){
         String orden ="INSERT INTO reunion (idReunion,tituloReunion,responsableRegistro,"
                 + "asunto,horaInicio,horaFin,lider,lugarReunion,fechaReunion) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";          
         PreparedStatement estado = conexion.prepareStatement(orden);
         estado.setInt(1,reunion.getIdReunion());
         estado.setString(2, reunion.getTituloReunion());
         estado.setString(3, reunion.getResponsableRegistro());
         estado.setString(4, reunion.getAsunto());
         estado.setString(5, formatoHora.format(reunion.getHoraInicio()));  
         estado.setString(6, formatoHora.format(reunion.getHoraFin()));
         estado.setString(7, reunion.getLider());
         estado.setString(8, reunion.getLugarReunion());
         estado.setDate(9, new java.sql.Date(reunion.getFechaReunion().getTime()));
         estado.executeUpdate();
         retorno=true;
        }  catch (SQLException ex) {
            Logger.getLogger(ReunionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  

        return retorno;
    }

    @Override
    public boolean actualizar(Reunion reunion) {
        boolean retorno=false;
        try(Connection conexion=conexionBaseDeDatos.getConectar()){
         String orden ="UPDATE reunion SET tituloReunion=?,responsableRegistro=?,asunto = ?,horaInicio=?,"
                 + "horaFin=?,lider=?,lugarReunion=?,fechaReunion=? WHERE idReunion=?";
         PreparedStatement estado = conexion.prepareStatement(orden);
         estado.setString(1, reunion.getTituloReunion());
         estado.setString(2, reunion.getResponsableRegistro());
         estado.setString(3, reunion.getAsunto());
         estado.setString(4, formatoHora.format(reunion.getHoraInicio()));
         estado.setString(5, formatoHora.format(reunion.getHoraFin()));
         estado.setString(6, reunion.getLider());
         estado.setString(7, reunion.getLugarReunion());
         estado.setDate(8, new java.sql.Date(reunion.getFechaReunion().getTime()));
         estado.setInt(9,reunion.getIdReunion());
         estado.executeUpdate();
         retorno=true;
        }catch(SQLException ex){
            Logger.getLogger(ReunionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }

    @Override
    public boolean eliminar(int id) {
        boolean retorno=false;
        try(Connection conexion=conexionBaseDeDatos.getConectar()){
            String pregunta = "DELETE FROM reunion WHERE idReunion=?";
            PreparedStatement estado = conexion.prepareStatement(pregunta);
            estado.setInt(1,id);
            estado.executeUpdate();
            retorno=true;
        }catch (SQLException ex){
             Logger.getLogger(ReunionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
    }
       
}