package SGP_CA.Bussineslogic;

import SGP_CA.Domain.PlanTrabajo;
import java.util.ArrayList;
/**
 *
 * @author Alberto
 */
public interface IPlanTrabajoDAO {
      
   public String obtenerNombreEncargado(String tituloPlanTrabajo); 
   public ArrayList<String> obtenerNombrePlanTrabajo();
   public ArrayList<PlanTrabajo> obtenerPlanTrabajo();
   public boolean insertar(PlanTrabajo planTrabajo);
   public boolean actualizar(PlanTrabajo planTrabajo);
   public boolean eliminar(int id);
}
