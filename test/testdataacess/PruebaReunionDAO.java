/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdataacess;

import Domain.Reunion;
import bussineslogic.ReunionDAO;

import org.junit.Test;

/**
 *
 * @author Alberto
 */
public class PruebaReunionDAO {
    
    @Test
    public void pruebaInsertarReunionDAO(){
        Reunion reunion = new Reunion();
        reunion.setId(1);
        reunion.setAsunto("Prosperidad");
        reunion.setFechaReunion("2014-04-15");
        reunion.setHoraFin("14:00");
        reunion.setHoraInicio("12:00");
        reunion.setLider("Oscar Sanchez Perez");
        reunion.setLugarReunion("Xalapa");
        reunion.setResponsableRegistro("Alejandro Trujillo");
        reunion.setTituloReunion("Revision de la prosperidad");
        
        ReunionDAO reunionDAO = new ReunionDAO();
        reunionDAO.insertar(reunion);
    }
    
    @Test
    public void pruebaActualizarDatosReunionDAO(){
        Reunion reunion = new Reunion();
        reunion.setId(1);
        reunion.setAsunto("Mejorar las instalaciones");
        reunion.setFechaReunion("2011-04-18");
        reunion.setHoraFin("17:00");
        reunion.setHoraInicio("19:30");
        reunion.setLider("Omar López Martinez");
        reunion.setLugarReunion("Xalapa");
        reunion.setResponsableRegistro("Valeria Fernandez Vasquez");
        reunion.setTituloReunion("Revision de las instalaciones");
        
        ReunionDAO reunionDAO = new ReunionDAO();
        reunionDAO.actualizar(reunion);
    }
    
    @Test
    public void pruebaEliminarDatosReunionDAO(){
       int id=1;
       ReunionDAO reunionDAO = new ReunionDAO();
       reunionDAO.eliminar(id);
    }
}
