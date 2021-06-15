/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdataacess;

import SGP_CA.Bussineslogic.PlanTrabajoDAO;
import SGP_CA.Domain.PlanTrabajo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Alberto
 */
public class PruebaPlanTrabajoDAO {
    
    @Test
    public void PruebaObtenerNombreEncargado(){
        String tituloPlanTrabajo = "Avanzar en educacion";
        PlanTrabajoDAO planTrabajoDAO = new PlanTrabajoDAO();
        Assert.assertNotNull(planTrabajoDAO.obtenerNombreEncargado(tituloPlanTrabajo));
    }
    
    @Test
    public void PruebaObtenerNombrePlanTrabajoDAO(){
        PlanTrabajoDAO planTrabajoDAO = new PlanTrabajoDAO();
        Assert.assertNotNull(planTrabajoDAO.obtenerNombrePlanTrabajo());
    }
    
    @Test
    public void PruebaObtenerPorIdPlanTrabajoDAO(){
        int id = 1;
        PlanTrabajoDAO planTrabajoDAO = new PlanTrabajoDAO();
        Assert.assertNotNull(planTrabajoDAO.obtenerPorId(id));
    }
    
    @Test
    public void PruebaObtenerPlanTrabajoDAO(){
        PlanTrabajoDAO planTrabajoDAO = new PlanTrabajoDAO();
        Assert.assertNotNull(planTrabajoDAO.obtenerPlanTrabajo());
    }
    
    @Test
    public void PruebaInsertarPlanTrabajoDAO(){
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");        
        
        PlanTrabajo planTrabajo = new PlanTrabajo();
        
        planTrabajo.setEstrategia("Seguir con la reestructuracion de la educacion");
        planTrabajo.setIdPlanTrabajo(1);
        planTrabajo.setMeta("Lograr un nivel superior de educacion");
        planTrabajo.setNombreEncargado("Juan Perez Arriaga");
        planTrabajo.setNumeroEstrategia(2);
        planTrabajo.setResultado("Positivo");
        try{            
            planTrabajo.setFechaFin(formatoFecha.parse("2011-09-12"));
        planTrabajo.setFechaInicio(formatoFecha.parse("2011-06-01")); 
        }catch(ParseException pe){
    
        }
        planTrabajo.setTituloPlanTrabajo("Avanzar en educacion");
        
       PlanTrabajoDAO planTrabajoDAO = new PlanTrabajoDAO();
       Assert.assertTrue(planTrabajoDAO.insertar(planTrabajo));
    }
    
    @Test
    public void PruebaActualizarDatosPlanTrabajoDAO(){
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy"); 
        
        PlanTrabajo planTrabajo = new PlanTrabajo();
        
        planTrabajo.setEstrategia("Mejorar instalaciones");
        planTrabajo.setIdPlanTrabajo(1);
        planTrabajo.setMeta("Alcanzar bienestar escolar");
        planTrabajo.setNombreEncargado("Oscar Sanchez");
        planTrabajo.setNumeroEstrategia(14);
        planTrabajo.setResultado("Positivo");
        try{
            planTrabajo.setFechaFin(formatoFecha.parse("2001-10-11"));
            planTrabajo.setFechaInicio(formatoFecha.parse("2001-06-15"));
        }catch(ParseException pe){
            
        }

        planTrabajo.setTituloPlanTrabajo("plan de bienestar escolar");
        
        PlanTrabajoDAO planTrabajoDAO = new PlanTrabajoDAO();
        Assert.assertTrue(planTrabajoDAO.actualizar(planTrabajo));
    }
    
    @Test
    public void PruebaEliminarPlanTrabajoDAO(){
        int id=0;
        PlanTrabajoDAO planTrabajoDAO = new PlanTrabajoDAO();
        Assert.assertTrue(planTrabajoDAO.eliminar(id));
    }
}
