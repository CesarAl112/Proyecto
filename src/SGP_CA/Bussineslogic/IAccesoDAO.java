/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SGP_CA.Bussineslogic;

import java.util.ArrayList;

/**
 *
 * @author Alberto
 */
public interface IAccesoDAO {
    public boolean validarUsuarioContraseñaIntegrante(String usuario, String contraseña);
    public boolean validarUsuarioContraseñaResponsable(String usuario, String contraseña);
}
