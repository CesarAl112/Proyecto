/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SGP_CA.Bussineslogic;

import SGP_CA.Dataaccess.ConexionBaseDeDatos;

import SGP_CA.Domain.PlanTrabajo;

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
public class PlanTrabajoDAO implements IPlanTrabajoDAO{
    
    private DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    private ConexionBaseDeDatos conexionBaseDeDatos = new ConexionBaseDeDatos();
    
    @Override 
    public String obtenerNombreEncargado(String tituloPlanTrabajo){
        ResultSet obtenerResultado;
        String nombreEncargado = "";
        try(Connection conexion = conexionBaseDeDatos.getConectar()){
            String orden = "SELECT nombreEncargado FROM plantrabajo WHERE tituloPlanTrabajo = ?";            
            PreparedStatement estado = conexion.prepareCall(orden);
            estado.setString(1, tituloPlanTrabajo);
            obtenerResultado = estado.executeQuery();
            while(obtenerResultado.next()){                
                nombreEncargado = obtenerResultado.getString("nombreEncargado");                                             
            }  
            conexion.close();
        }catch(SQLException ex){
            Logger.getLogger(PlanTrabajoDAO.class.getName()).log(Level.SEVERE,null, ex);
        }
        return nombreEncargado;
    }
    
    @Override
    public ArrayList<String> obtenerNombrePlanTrabajo(){
        ResultSet obtenerResultado;
        ArrayList<String> nombrePlanTrabajoLista = new ArrayList<>();
        try(Connection conexion = conexionBaseDeDatos.getConectar()){
            String orden = "SELECT tituloPlanTrabajo FROM plantrabajo";
            PreparedStatement estado = conexion.prepareCall(orden);
            obtenerResultado = estado.executeQuery();
            while(obtenerResultado.next()){
                String tituloPlanTrabajo;
                tituloPlanTrabajo = obtenerResultado.getString("tituloPlanTrabajo");
                
                nombrePlanTrabajoLista.add(tituloPlanTrabajo);                
            }                  
        }catch(SQLException ex){
            Logger.getLogger(PlanTrabajoDAO.class.getName()).log(Level.SEVERE,null, ex);
        }
 
        return nombrePlanTrabajoLista;
    }        
    
    @Override
    public PlanTrabajo obtenerPorTitulo(String titulo) {
        ResultSet obtenerResultado;         
        PlanTrabajo datosPlanTrabajo = new PlanTrabajo();
        try(Connection conexion = conexionBaseDeDatos.getConectar()){
            String orden = "SELECT * FROM plantrabajo where tituloPlanTrabajo=?";
            PreparedStatement estado = conexion.prepareStatement(orden);
            estado.setString(1, titulo);
            obtenerResultado = estado.executeQuery();
            
            while(obtenerResultado.next()){        
               try{
               String[] datos = new String[9];
                    
               datos[0] = Integer.toString(obtenerResultado.getInt("idPlanTrabajo"));
               datos[1] = obtenerResultado.getString("tituloPlanTrabajo");
               datos[2] = obtenerResultado.getString("nombreEncargado");
               datos[3] = obtenerResultado.getString("meta");
               datos[4] = obtenerResultado.getString("estrategia");
               datos[5] = Integer.toString(obtenerResultado.getInt("numeroEstrategia"));
               datos[6] = obtenerResultado.getString("resultado");
               datos[7] = formatoFecha.format(obtenerResultado.getDate("fechaInicio"));
               datos[8] = formatoFecha.format(obtenerResultado.getDate("fechaFin"));
               
               datosPlanTrabajo.setIdPlanTrabajo(Integer.parseInt(datos[0]));
               datosPlanTrabajo.setTituloPlanTrabajo(datos[1]);
               datosPlanTrabajo.setNombreEncargado(datos[2]);
               datosPlanTrabajo.setMeta(datos[3]);
               datosPlanTrabajo.setEstrategia(datos[4]);
               datosPlanTrabajo.setNumeroEstrategia(Integer.parseInt(datos[5]));
               datosPlanTrabajo.setResultado(datos[6]);
               datosPlanTrabajo.setFechaInicio(formatoFecha.parse(datos[7]));
               datosPlanTrabajo.setFechaFin(formatoFecha.parse(datos[8]));               
               
               }catch(ParseException npe){
                   
               }
            }
        }catch(SQLException ex){
            Logger.getLogger(PlanTrabajoDAO.class.getName()).log(Level.SEVERE,null, ex);
        }

        return datosPlanTrabajo;
    }
    
    @Override
    public ArrayList<PlanTrabajo> obtenerPlanTrabajo() {
        ResultSet obtenerResultado;         
        ArrayList<PlanTrabajo> listaPlanTrabajo  = new ArrayList<>();          
        try(Connection conexion = conexionBaseDeDatos.getConectar()){
            String orden = "SELECT * FROM plantrabajo";
            PreparedStatement estado = conexion.prepareStatement(orden);
            obtenerResultado = estado.executeQuery();
            
            while(obtenerResultado.next()){        
               try{
               PlanTrabajo datosPlanTrabajo = new PlanTrabajo();
               String[] datos = new String[9];
                    
               datos[0] = Integer.toString(obtenerResultado.getInt("idPlanTrabajo"));
               datos[1] = obtenerResultado.getString("tituloPlanTrabajo");
               datos[2] = obtenerResultado.getString("nombreEncargado");
               datos[3] = obtenerResultado.getString("meta");
               datos[4] = obtenerResultado.getString("estrategia");
               datos[5] = Integer.toString(obtenerResultado.getInt("numeroEstrategia"));
               datos[6] = obtenerResultado.getString("resultado");
               datos[7] = formatoFecha.format(obtenerResultado.getDate("fechaInicio"));
               datos[8] = formatoFecha.format(obtenerResultado.getDate("fechaFin"));
               
               datosPlanTrabajo.setIdPlanTrabajo(Integer.parseInt(datos[0]));
               datosPlanTrabajo.setTituloPlanTrabajo(datos[1]);
               datosPlanTrabajo.setNombreEncargado(datos[2]);
               datosPlanTrabajo.setMeta(datos[3]);
               datosPlanTrabajo.setEstrategia(datos[4]);
               datosPlanTrabajo.setNumeroEstrategia(Integer.parseInt(datos[5]));
               datosPlanTrabajo.setResultado(datos[6]);
               datosPlanTrabajo.setFechaInicio(formatoFecha.parse(datos[7]));
               datosPlanTrabajo.setFechaFin(formatoFecha.parse(datos[8]));
               
               listaPlanTrabajo.add(datosPlanTrabajo);
               
               }catch(ParseException npe){
                   
               }
            }
        }catch(SQLException ex){
            Logger.getLogger(PlanTrabajoDAO.class.getName()).log(Level.SEVERE,null, ex);
        }

        return listaPlanTrabajo;
    }

    @Override
    public boolean insertar(PlanTrabajo planTrabajo) {
        boolean retorno=false;
        try(Connection conexion=conexionBaseDeDatos.getConectar()){
         String orden ="INSERT INTO plantrabajo (idPlanTrabajo,tituloPlanTrabajo,nombreEncargado,meta,estrategia,numeroEstrategia,"
                 + "resultado,fechaInicio,fechaFin) values(?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
         PreparedStatement estado = conexion.prepareStatement(orden);
         estado.setInt(1,planTrabajo.getIdPlanTrabajo());
         estado.setString(2,planTrabajo.getTituloPlanTrabajo());
         estado.setString(3,planTrabajo.getNombreEncargado());
         estado.setString(4,planTrabajo.getMeta());
         estado.setString(5,planTrabajo.getEstrategia());
         estado.setInt(6,planTrabajo.getNumeroEstrategia());
         estado.setString(7,planTrabajo.getResultado());
         estado.setDate(8,new java.sql.Date(planTrabajo.getFechaFin().getTime()));
         estado.setDate(9,new java.sql.Date(planTrabajo.getFechaFin().getTime()));
         estado.executeUpdate();
         retorno=true;
        }  catch (SQLException ex) {
            Logger.getLogger(PlanTrabajoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  

        return retorno;
    }

    @Override
    public boolean actualizar(PlanTrabajo planTrabajo) {
        boolean retorno=false;
        try(Connection conexion=conexionBaseDeDatos.getConectar()){
            String orden ="UPDATE plantrabajo SET tituloPlanTrabajo=?,nombreEncargado=?,meta=?,estrategia=?,numeroEstrategia=?,"
                 + "resultado=?,fechaInicio=?,fechaFin=? WHERE idPlanTrabajo=?";
            PreparedStatement estado = conexion.prepareStatement(orden);
            estado.setString(1,planTrabajo.getTituloPlanTrabajo());
            estado.setString(2,planTrabajo.getNombreEncargado());
            estado.setString(3,planTrabajo.getMeta());
            estado.setString(4,planTrabajo.getEstrategia());
            estado.setInt(5,planTrabajo.getNumeroEstrategia());
            estado.setString(6,planTrabajo.getResultado());
            estado.setDate(7,new java.sql.Date(planTrabajo.getFechaInicio().getTime()));
            estado.setDate(8,new java.sql.Date(planTrabajo.getFechaFin().getTime()));
            estado.setInt(9,planTrabajo.getIdPlanTrabajo());
            estado.executeUpdate();
            retorno=true;
        }catch(SQLException ex){
            Logger.getLogger(PlanTrabajoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexionBaseDeDatos.cerrarConexion();
        return retorno;
    }

    @Override
    public boolean eliminar(int id) {
        boolean retorno=false;
        try(Connection conexion=conexionBaseDeDatos.getConectar()){
            String orden = "DELETE FROM plantrabajo WHERE idPlanTrabajo=?";
            PreparedStatement estado = conexion.prepareStatement(orden);
            estado.setInt(1,id);
            estado.executeUpdate();
            retorno=true;
        }catch (SQLException ex){
             Logger.getLogger(PlanTrabajoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }
    
}
