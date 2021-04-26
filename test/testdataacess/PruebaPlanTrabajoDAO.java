/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdataacess;

import bussineslogic.PlanTrabajoDAO;
import Domain.PlanTrabajo;
import org.junit.Test;

/**
 *
 * @author Alberto
 */
public class PruebaPlanTrabajoDAO {
    @Test
    public void PruebaInsertarPlanTrabajoDAO(){
        PlanTrabajo planTrabajo = new PlanTrabajo();
        planTrabajo.setEstrategia("hablar");
        planTrabajo.setIdPlanTrabajo(1);
        planTrabajo.setMeta("Alcanzar bienestar");
        planTrabajo.setNombreEncargado("Juan Perez Arriaga");
        planTrabajo.setNumeroEstrategia(14);
        planTrabajo.setResultado("Positivo");
        planTrabajo.setFechaFin("2001-09-12");
        planTrabajo.setFechaInicio("2001-06-01");
        planTrabajo.setTituloPlanTrabajo("Elaborar un plan de bienestar");
        
       PlanTrabajoDAO planTrabajoDAO = new PlanTrabajoDAO();
       planTrabajoDAO.insertar(planTrabajo);
        
    }
    
    @Test
    public void PruebaActualizarDatosPlanTrabajoDAO(){
        PlanTrabajo planTrabajo = new PlanTrabajo();
        planTrabajo.setEstrategia("Mejorar instalaciones");
        planTrabajo.setIdPlanTrabajo(1);
        planTrabajo.setMeta("Alcanzar bienestar escolar");
        planTrabajo.setNombreEncargado("Juan Perez Arriaga");
        planTrabajo.setNumeroEstrategia(14);
        planTrabajo.setResultado("Positivo");
        planTrabajo.setFechaFin("2001-10-11");
        planTrabajo.setFechaInicio("2001-06-15");
        planTrabajo.setTituloPlanTrabajo("plan de bienestar escolar");
        
        PlanTrabajoDAO planTrabajoDAO = new PlanTrabajoDAO();
        planTrabajoDAO.actualizar(planTrabajo);
    }
    
    @Test
    public void PruebaEliminarPlanTrabajoDAO(){
        int id=1;
        PlanTrabajoDAO planTrabajoDAO = new PlanTrabajoDAO();
        planTrabajoDAO.eliminar(id);
    }
}
