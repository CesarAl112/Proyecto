package interfaz;

import Dominio.Asistente;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import java.util.ArrayList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarAsistentes extends JFrame implements ActionListener{
    private InterfazAsistente interfaz = new InterfazAsistente();
    private ArrayList<Asistente> arrayAsistente = new ArrayList<>();
    private JButton botonConfirmar;
    private JButton botonCancelar;
    
    public RegistrarAsistentes(){
        interfaz.menu();
    }
    
    private void inicializarComponentes(){
                
	botonConfirmar = new JButton("Confirmar");
	botonConfirmar.setBounds(50, 350, 200, 30);	
	botonConfirmar.addActionListener(this);

	botonCancelar = new JButton("Cancelar");
	botonCancelar.setBounds(300, 350, 200, 30);
	botonCancelar.addActionListener(this);

        this.add(botonConfirmar);
        this.add(botonCancelar);
    }

       @Override
        public void actionPerformed(ActionEvent actionEvent){
            if(actionEvent.getSource().equals(botonCancelar)){
		int confirmarAccion = JOptionPane.showConfirmDialog(null, "Desea salir", "salir", JOptionPane.OK_CANCEL_OPTION);
                if(confirmarAccion == JOptionPane.OK_OPTION){
                    MenuPrincipal menu = new MenuPrincipal();
                    this.dispose();
                }
            }
            if(actionEvent.getSource().equals(botonConfirmar)){
		int confirmarAccion;
		confirmarAccion = JOptionPane.showConfirmDialog(null, "desesa confirmar", "confirmar", JOptionPane.OK_CANCEL_OPTION);
                if(confirmarAccion == JOptionPane.OK_OPTION){
                    guardarDatosAsistente();
                }
            }
	}

    public void guardarDatosAsistente(){
        String nombrePila = interfaz.getNombrePila().getText();
	String apellidos = interfaz.getApellidos().getText();
	String correoElectronico = interfaz.getCorreoElectronico().getText();

	Asistente datosAsistente = new Asistente(nombrePila, apellidos, correoElectronico);
	arrayAsistente.add(datosAsistente);
	}



}