/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussineslogic;

import Domain.Acuerdo;
import java.util.List;

/**
 *
 * @author Alberto
 */
public interface IAcuerdoDAO {
   List<Acuerdo> obtenerAcuerdo();
   public void insertar(Acuerdo acuerdo);
   public void actualizar(Acuerdo acuerdo);
   public void eliminar(int id);
}
