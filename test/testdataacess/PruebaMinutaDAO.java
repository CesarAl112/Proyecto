/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdataacess;

import Dataaccess.ConexionBaseDeDatos;
import Domain.Minuta;
import bussineslogic.MinutaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;

/**
 *
 * @author Alberto
 */
public class PruebaMinutaDAO {
    
    @Test
    public void PruebaActualizarDatosMinutaDAO(){
        Minuta minuta = new Minuta();
        minuta.setFechaCreacion("2001-08-22");
        minuta.setIdMinuta(1);
        minuta.setNombreEncargado("Carlos Perez Arriaga ");
        minuta.setNombreParticipante("Oscar Alonso Dominguez");
        minuta.setNombreReunion("Computacion en la eduacion");
        minuta.setNotas("Se hablo sobre el tema...");
        minuta.setPendientes("Se hablara sobre...");
        
        MinutaDAO minutaDAO = new MinutaDAO();
        minutaDAO.actualizar(minuta);
    }
    
    @Test
    public void PruebaInsertarDatosMinutaDAO(){
        Minuta minuta = new Minuta();
        minuta.setFechaCreacion("2000-07-21");
        minuta.setIdMinuta(1);
        minuta.setNombreEncargado("Pedro Altazar Mendoza");
        minuta.setNombreParticipante("Juan Perez Sanchez");
        minuta.setNombreReunion("Educacion");
        minuta.setNotas("Se hablo sobre");
        minuta.setPendientes("Hablar sobre este...");
        
        MinutaDAO minutaDAO = new MinutaDAO();
        minutaDAO.insertar(minuta);
    }
    
    @Test
    public void PruebaEliminarDatosMinutaDAO(){
        int id=1;
        MinutaDAO minutaDAO = new MinutaDAO();
        minutaDAO.eliminar(id);
    }
    
}
