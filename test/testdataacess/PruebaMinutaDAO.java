package testdataacess;

import SGP_CA.Domain.Minuta;
import SGP_CA.Bussineslogic.MinutaDAO;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Alberto
 */
public class PruebaMinutaDAO {   
    
    @Test
    public void PruebaInsertarDatosMinutaDAO(){        
        Minuta minuta = new Minuta();
        DateFormat formatoFecha = new SimpleDateFormat("DD/MM/YYYY");
        minuta.setIdMinuta(1);
        minuta.setNombreEncargado("Pedro Altazar Mendoza");
        minuta.setNombreParticipante("Juan Perez Sanchez");
        minuta.setNombreReunion("Educacion");
        minuta.setNotas("Se hablo sobre");
        minuta.setPendientes("Hablar sobre este...");
        try{
            minuta.setFechaCreacion(formatoFecha.parse("14/04/14"));
        }catch(ParseException pe){
            
        }                
        MinutaDAO minutaDAO = new MinutaDAO();
        Assert.assertTrue(minutaDAO.insertar(minuta));
    }
    
    @Test
    public void PruebaEliminarDatosMinutaDAO(){
        int id=1;
        MinutaDAO minutaDAO = new MinutaDAO();
        minutaDAO.eliminar(id);
        Assert.assertTrue(minutaDAO.eliminar(id));
    }
    
}
