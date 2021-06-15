/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdataacess;

import SGP_CA.Domain.Reunion;
import SGP_CA.Bussineslogic.ReunionDAO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.Assert;

import org.junit.Test;

/**
 *
 * @author Alberto
 */
public class PruebaReunionDAO {
    
    @Test
    public void pruebaObtenerParticipante(){
        ReunionDAO reunionDAO = new ReunionDAO();
        Assert.assertNotNull(reunionDAO.obtenerParticipantes());
    }
    
    @Test 
    public void pruebaObtenerReunionDAO(){
        ReunionDAO reunionDAO = new ReunionDAO();
        Assert.assertNotNull(reunionDAO.obtenerReunion());
    }
    
    @Test
    public void pruebaObtenerReunionPorIdDAO(){
        int idReunion = 24;
        ReunionDAO reunionDAO = new ReunionDAO();
        Assert.assertNotNull(reunionDAO.obtenerPorId(idReunion));
    }
    
    @Test
    public void pruebaInsertarReunionDAO(){
        Reunion reunion = new Reunion();
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat formatoHora = new SimpleDateFormat("HH:mm");
        try{
            reunion.setFechaReunion(formatoFecha.parse("2014-04-15"));
            reunion.setHoraInicio(formatoHora.parse("14:00"));
            reunion.setHoraFin(formatoHora.parse("16:00"));
        }catch(ParseException pe){
            
        } 
        reunion.setIdReunion(1);
        reunion.setAsunto("Prosperidad");
        reunion.setLider("Oscar Sanchez Perez");
        reunion.setLugarReunion("Xalapa");
        reunion.setResponsableRegistro("Alejandro Trujillo");
        reunion.setTituloReunion("Revision de la prosperidad");
        
        ReunionDAO reunionDAO = new ReunionDAO();
        Assert.assertTrue(reunionDAO.insertar(reunion));
    }
    
    @Test
    public void pruebaActualizarDatosReunionDAO(){
        Reunion reunion = new Reunion();
        reunion.setIdReunion(1);
        
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat formatoHora = new SimpleDateFormat("HH:mm");
        try{
            reunion.setFechaReunion(formatoFecha.parse("2014-04-15"));
            reunion.setHoraInicio(formatoHora.parse("14:00"));
            reunion.setHoraFin(formatoHora.parse("16:00"));
        }catch(ParseException pe){
            
        } 
        reunion.setAsunto("Mejorar las instalaciones");
        reunion.setLider("Omar López Martinez");
        reunion.setLugarReunion("Xalapa");
        reunion.setResponsableRegistro("Valeria Fernandez Vasquez");
        reunion.setTituloReunion("Revision de las instalaciones");
        
        ReunionDAO reunionDAO = new ReunionDAO();
        Assert.assertTrue(reunionDAO.actualizar(reunion));
    }
    
    @Test
    public void pruebaEliminarDatosReunionDAO(){
       int id=1;
       ReunionDAO reunionDAO = new ReunionDAO();
       Assert.assertTrue(reunionDAO.eliminar(id));
    }
}
