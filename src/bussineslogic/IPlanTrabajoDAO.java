package bussineslogic;

import Domain.PlanTrabajo;
import java.util.List;
/**
 *
 * @author Alberto
 */
public interface IPlanTrabajoDAO {
   List<PlanTrabajo> obtenerPlanTrabajo();
   public void insertar(PlanTrabajo planTrabajo);
   public void actualizar(PlanTrabajo planTrabajo);
   public void eliminar(int id);
}
