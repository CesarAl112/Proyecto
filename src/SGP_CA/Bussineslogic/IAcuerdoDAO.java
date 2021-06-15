/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SGP_CA.Bussineslogic;

import SGP_CA.Domain.Acuerdo;
import java.util.ArrayList;

/**
 *
 * @author Alberto
 */
public interface IAcuerdoDAO {

   public ArrayList<Acuerdo> obtenerAcuerdo();
   public boolean agregarAcuerdo(Acuerdo acuerdo);
   public boolean actualizarAcuerdo(Acuerdo acuerdo);
   public boolean eliminarAcuerdo(int idAcuerdo);
}
