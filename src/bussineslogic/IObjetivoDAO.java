/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussineslogic;

import Domain.Objetivo;
import java.util.List;

/**
 *
 * @author Alberto
 */
public interface IObjetivoDAO {
    List<Objetivo> obtenerObjetivo();
   public void insertar(Objetivo objetivo);
   public void actualizar(Objetivo objetivo);
   public void eliminar(int id);
}
