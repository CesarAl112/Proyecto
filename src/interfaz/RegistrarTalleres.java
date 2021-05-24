package interfaz;

import Dominio.TallerRegistro;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.util.ArrayList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarTalleres extends JFrame implements ActionListener{

	private JTextField campoTextoNombreTaller;
	private JTextField campoTextoFechaTaller;
	private JTextField campoTextoUbicacionTaller;
	private JTextField campoTextoEncargadoTaller;
	private ArrayList<TallerRegistro> arrayTaller = new ArrayList<>();
	private JButton botonConfirmar;
	private JButton botonCancelar;

	public RegistrarTalleres(){
		setTitle("Registrar talleres");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		inicializarComponentes();

		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void inicializarComponentes(){
		JLabel nombreTaller = new JLabel("Ingrese el nombre del taller");
		nombreTaller.setBounds(50, 50, 200, 25);

		campoTextoNombreTaller = new JTextField();
		campoTextoNombreTaller.setBounds(250, 50, 200, 25);
		campoTextoNombreTaller.setText("Escriba el taller aqui");

		JLabel fechaTaller = new JLabel("Ingrese la fecha del taller");
		fechaTaller.setBounds(50, 100, 200, 25);

		campoTextoFechaTaller = new JTextField();
		campoTextoFechaTaller.setBounds(250, 100, 200, 25);
		campoTextoFechaTaller.setText("Escriba la fecha del taller");

		JLabel ubicacionTaller = new JLabel("Ingrese la ubicacion del taller");
		ubicacionTaller.setBounds(50, 150, 200, 25);

		campoTextoUbicacionTaller = new JTextField();
		campoTextoUbicacionTaller.setBounds(250, 150, 200, 25);
		campoTextoUbicacionTaller.setText("Escriba la ubicacion aqui");

		JLabel encargadoTaller = new JLabel("Ingrese su nombre");
		encargadoTaller.setBounds(50, 200, 200, 25);

		campoTextoEncargadoTaller = new JTextField();
		campoTextoEncargadoTaller.setBounds(250, 200, 200, 25);
		campoTextoEncargadoTaller.setText("Escriba su nombre aqui");


		botonConfirmar = new JButton("Confirmar");
		botonConfirmar.setBounds(50, 300, 200, 30);	
		botonConfirmar.addActionListener(this);

		botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(300, 300, 200, 30);
		botonCancelar.addActionListener(this);

		this.add(nombreTaller);
		this.add(campoTextoNombreTaller);
		this.add(fechaTaller);
		this.add(campoTextoFechaTaller);
		this.add(ubicacionTaller);
		this.add(campoTextoUbicacionTaller);
		this.add(encargadoTaller);
		this.add(campoTextoEncargadoTaller);
		this.add(botonConfirmar);
		this.add(botonCancelar);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent){
		if(actionEvent.getSource().equals(botonCancelar)){
			int confirmarAccion = JOptionPane.showConfirmDialog(null, "Desea salir", "salir", JOptionPane.OK_CANCEL_OPTION);
			if(confirmarAccion == JOptionPane.OK_OPTION){
				MenuPrincipal programaPrincipal = new MenuPrincipal();
				this.dispose();
			}
		}
		if(actionEvent.getSource().equals(botonConfirmar)){
			int confirmarAccion;
			confirmarAccion = JOptionPane.showConfirmDialog(null, "desesa confirmar", "confirmar", JOptionPane.OK_CANCEL_OPTION);
			if(confirmarAccion == JOptionPane.OK_OPTION){
				guardarDatosRegistroTaller();
			}
		}
	}

	private void guardarDatosRegistroTaller(){
		String nombreTaller = campoTextoNombreTaller.getText();
		String fechaTaller = campoTextoFechaTaller.getText();
		String ubicacionTaller = campoTextoUbicacionTaller.getText();
		String encargadoTaller = campoTextoEncargadoTaller.getText();
		
		TallerRegistro datosTaller = new TallerRegistro(nombreTaller, fechaTaller, ubicacionTaller, encargadoTaller);
		arrayTaller.add(datosTaller);

	}





}