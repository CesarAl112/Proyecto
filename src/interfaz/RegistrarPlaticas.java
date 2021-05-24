package interfaz;

import Dominio.Platica;
import Dominio.Asistente;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.util.ArrayList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarPlaticas extends JFrame implements ActionListener{

	private JComboBox<String> comboBoxNombrePlatica;
	private JComboBox<String> comboBoxFechaPlatica;
	private	JComboBox<String> comboBoxUbicacionPlatica;
	private JTextField campoTextoNombrePila;
	private JTextField campoTextoApellidos;
	private JTextField campoTextoCorreoElectronico;
	private JButton botonConfirmar;
	private JButton botonCancelar;
	private String nombrePlaticas[];
	private String fechaPlaticas[];
	private String ubicacionPlaticas[];
	private ArrayList<Platica> arrayPlatica;
	private ArrayList<Asistente> arrayAsistente;

	public RegistrarPlaticas(){
            this.arrayAsistente = new ArrayList<>();
            this.arrayPlatica = new ArrayList<>();
            this.nombrePlaticas = new String[]{"--Seleccione una opcion", "Electricidad", "Computacion", "Biologia"};
            this.fechaPlaticas = new String[]{"--Seleccione una opcion", "28/02/2021", "02/02/2021" , "04/02/2021"};
            this.ubicacionPlaticas = new String[]{"--Seleccione una opcion", "Xalapa", "Perote", "Orizaba"};
            setTitle("Registrarse a platica");
            setSize(600, 600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(null);
            inicializarComponentes();

            setLocationRelativeTo(null);
            setVisible(true);
	}

	private void inicializarComponentes(){
            JLabel nombrePlatica = new JLabel("Seleccion una platica");
            nombrePlatica.setBounds(50, 50, 200, 25);

            comboBoxNombrePlatica = new JComboBox<>(nombrePlaticas);
            comboBoxNombrePlatica.setBounds(250, 50, 200, 25);
            comboBoxNombrePlatica.addActionListener(this);

            JLabel fechaPlatica = new JLabel("Seleccione una fecha");
            fechaPlatica.setBounds(50, 100, 200, 25);

            comboBoxFechaPlatica = new JComboBox<>(fechaPlaticas);
            comboBoxFechaPlatica.setBounds(250, 100, 200, 25);
            comboBoxFechaPlatica.addActionListener(this);

            JLabel ubicacionPlatica = new JLabel("Seleccione una ubicacion");
            ubicacionPlatica.setBounds(50, 150, 200, 25);

            comboBoxUbicacionPlatica = new JComboBox<>(ubicacionPlaticas);
            comboBoxUbicacionPlatica.setBounds(250, 150, 200, 25);
            comboBoxUbicacionPlatica.addActionListener(this);

            JLabel nombrePila = new JLabel("Ingrese su nombre");
            nombrePila.setBounds(50, 200, 200, 25);

            campoTextoNombrePila = new JTextField();
            campoTextoNombrePila.setBounds(250, 200, 200, 25);
            campoTextoNombrePila.setText("Su nombre aqui");

            JLabel apellidos = new JLabel("Ingrese sus apellidos");
            apellidos.setBounds(50, 250, 200, 25);

            campoTextoApellidos = new JTextField();
            campoTextoApellidos.setBounds(250, 250, 200, 25);
            campoTextoApellidos.setText("Sus apellidos aqui");

            JLabel correoElectronico = new JLabel("Ingrese su correo electronico");
            correoElectronico.setBounds(50, 300, 200, 25);

            campoTextoCorreoElectronico = new JTextField();
            campoTextoCorreoElectronico.setBounds(250, 300, 200, 25);
            campoTextoCorreoElectronico.setText("Su correo electronico");

            botonConfirmar = new JButton("Confirmar");
            botonConfirmar.setBounds(50, 350, 200, 30);	
            botonConfirmar.addActionListener(this);

            botonCancelar = new JButton("Cancelar");
            botonCancelar.setBounds(300, 350, 200, 30);
            botonCancelar.addActionListener(this);

            this.add(nombrePlatica);
            this.add(comboBoxNombrePlatica);
            this.add(fechaPlatica);
            this.add(comboBoxFechaPlatica);
            this.add(ubicacionPlatica);
            this.add(comboBoxUbicacionPlatica);
            this.add(nombrePila);
            this.add(campoTextoNombrePila);
            this.add(apellidos);
            this.add(campoTextoApellidos);
            this.add(correoElectronico);
            this.add(campoTextoCorreoElectronico);
            this.add(botonConfirmar);
            this.add(botonCancelar);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent){
		if(actionEvent.getSource().equals(botonCancelar)){
			int confirmarAccion = JOptionPane.showConfirmDialog(null, "Desea salir", "salir", JOptionPane.OK_CANCEL_OPTION);
			if(confirmarAccion == JOptionPane.OK_OPTION){
				MenuPrincipal menuPrincipal = new MenuPrincipal();
				this.dispose();
			}
		}
		if(actionEvent.getSource().equals(botonConfirmar)){
			int confirmarAccion;
			confirmarAccion = JOptionPane.showConfirmDialog(null, "desesa confirmar", "confirmar", JOptionPane.OK_CANCEL_OPTION);
			if(confirmarAccion == JOptionPane.OK_OPTION){
				guardarDatosPlatica();
			}
		}
	}

	private void guardarDatosPlatica(){
		String nombrePlatica = (String)comboBoxNombrePlatica.getSelectedItem();
		String fechaPlatica = (String)comboBoxFechaPlatica.getSelectedItem();
		String ubicacionPlatica = (String)comboBoxUbicacionPlatica.getSelectedItem();
		String nombrePila = campoTextoNombrePila.getText();
		String apellidos = campoTextoApellidos.getText();
		String correoElectronico = campoTextoCorreoElectronico.getText();

		Platica datosPlatica = new Platica();
                datosPlatica.setFechaPlatica(fechaPlatica);
                datosPlatica.setNombrePlatica(nombrePlatica);
                datosPlatica.setUbicacionPlatica(ubicacionPlatica);
		arrayPlatica.add(datosPlatica);

		Asistente datosAsistente = new Asistente();
                datosAsistente.setNombrePila(nombrePila);
                datosAsistente.setApellidos(apellidos);
                datosAsistente.setCorreoElectronico(correoElectronico);
		arrayAsistente.add(datosAsistente);
	}

}