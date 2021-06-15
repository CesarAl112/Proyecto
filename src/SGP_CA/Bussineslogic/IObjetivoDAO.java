/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SGP_CA.Bussineslogic;

import SGP_CA.Domain.Objetivo;
import java.util.ArrayList;

/**
 *
 * @author Alberto
 */
public interface IObjetivoDAO {
   
   public ArrayList<String> obtenerNombreObjetivo();
   public ArrayList<Objetivo> obtenerObjetivo();
   public boolean agregarObjetivo(Objetivo objetivo);
   public boolean actualizarObjetivo(Objetivo objetivo);
   public boolean eliminarObjetivo(int idObjetivo);
}
