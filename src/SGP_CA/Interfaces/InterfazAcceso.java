/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SGP_CA.Interfaces;

import SGP_CA.Bussineslogic.AccesoDAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Alberto
 */
public class InterfazAcceso extends JFrame implements ActionListener{
    
    private JTextField JTUsuario;
    private JPasswordField JTContrasenia;
    private JButton JBConfirmar;
    
    public static void main(String[] args){
        InterfazAcceso InterfazAcceso = new InterfazAcceso();
        InterfazAcceso.MenuLogin();
    }
    
    public void MenuLogin(){
        this.setTitle("Ingresar");
        this.setSize(500,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);       
        inicializarComponentes();
        
        setVisible(true);       
    }  
    
    public void inicializarComponentes(){
        JLabel usuario = new JLabel("usuario: ");
        usuario.setBounds(50, 50, 200, 30);
        
        JTUsuario = new JTextField();
        JTUsuario.setBounds(130, 50, 200, 30);
        
        JLabel contrasenia = new JLabel("contraseña: ");
        contrasenia.setBounds(50, 100, 200, 30);
        
        JTContrasenia = new JPasswordField();
        JTContrasenia.setBounds(130, 100, 200, 30);
        
        JBConfirmar = new JButton("Confirmar");
        JBConfirmar.setBounds(130, 170, 200, 30);
        JBConfirmar.addActionListener(this);
        
        this.add(usuario);
        this.add(contrasenia);
        this.add(JTUsuario);
        this.add(JTContrasenia);
        this.add(JBConfirmar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(JBConfirmar)){
            String usuario = JTUsuario.getText();
            String contraseña = String.valueOf(JTContrasenia.getPassword());
            AccesoDAO accesoDAO = new AccesoDAO();
            boolean validacionIntegrante = accesoDAO.validarUsuarioContraseñaIntegrante(usuario, contraseña);
            boolean validacionResponsable = accesoDAO.validarUsuarioContraseñaResponsable(usuario, contraseña);
            if(JTUsuario.getText().isEmpty() || JTContrasenia.getPassword().length==0){
                JOptionPane.showMessageDialog(null, "Error los campos estan vacios");
            }else{
                if(validacionIntegrante==true || validacionResponsable==true){
                    LoginPrincipal loginPrincipal = new LoginPrincipal();
                    loginPrincipal.MenuLogin();
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Error usuario o contraseña incorrectos");
            }
            }           
        }
    }
}
