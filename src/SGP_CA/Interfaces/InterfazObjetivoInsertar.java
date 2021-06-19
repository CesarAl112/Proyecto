/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SGP_CA.Interfaces;

import SGP_CA.Domain.Objetivo;
import SGP_CA.Bussineslogic.ObjetivoDAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Alberto
 */
public class InterfazObjetivoInsertar extends JFrame implements ActionListener{
    
    private ArrayList<Objetivo> listaObjetivo = new ArrayList<>();
    private Objetivo objetivoLista = new Objetivo();
    private ObjetivoDAO objetivoDAO = new ObjetivoDAO();   
    private JTextField JTIdObjetivo;
    private JTextArea JTDescripcionObjetivo;
    private JTextField JTTituloObjetivo;
    private JComboBox<String> JCEstadoObjetivo;
    private JButton JBConfirmar;
    private JButton JBSalir;
    
     public void menuRegistrarAcuerdo(){
        setTitle("Registrar Objetivo");
	setSize(600, 500);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(null);
        inicializarComponentes();   
        
	setLocationRelativeTo(null);
	setVisible(true);
    }
     
     private void inicializarComponentes(){
         JLabel idObjetivo = new JLabel("ingresar la clave del objetivo");
         idObjetivo.setBounds(50, 50, 200, 25);
         
         JTIdObjetivo = new JTextField();
         JTIdObjetivo.setBounds(250, 50, 200, 25);
         JTIdObjetivo.setText("La clave ");
         
         JLabel descripcionObjetivo = new JLabel("Ingrese la descripcion del objetivo");
         descripcionObjetivo.setBounds(50, 100, 250, 25);
         
         JTDescripcionObjetivo = new JTextArea();
         JTDescripcionObjetivo.setBounds(250, 100, 200, 25);
         JTDescripcionObjetivo.setText(" ");
         
         JLabel tituloObjetivo = new JLabel("ingrese el nombre del objetivo");
         tituloObjetivo.setBounds(50, 150, 200, 25);
         
         JTTituloObjetivo = new JTextField();
         JTTituloObjetivo.setBounds(250, 150, 200, 25);
         JTTituloObjetivo.setText("El nombre..");               
         
         JLabel estadoObjetivo = new JLabel ("seleccione el estado del objetivo");
         estadoObjetivo.setBounds(50, 200, 200, 25);
         
         JCEstadoObjetivo = new JComboBox();
         JCEstadoObjetivo.setBounds(250, 200, 200, 25);
         JCEstadoObjetivo.addItem("Finalizado");
         JCEstadoObjetivo.addItem("Inicializado");
         JCEstadoObjetivo.addItem("No inicializado");
         
         JBConfirmar = new JButton("Confirmar");
         JBConfirmar.setBounds(50, 250, 200, 30);	
         JBConfirmar.addActionListener(this);

         JBSalir = new JButton("Salir");
         JBSalir.setBounds(300, 250, 200, 30);
         JBSalir.addActionListener(this);
         
         this.add(JTIdObjetivo);
         this.add(idObjetivo);
         this.add(JTDescripcionObjetivo);
         this.add(descripcionObjetivo);
         this.add(JTTituloObjetivo);
         this.add(tituloObjetivo);
         this.add(JCEstadoObjetivo);
         this.add(estadoObjetivo);
         this.add(JBSalir);
         this.add(JBConfirmar);
     }   

    public ArrayList<Objetivo> enviarAcuerdo(){
        int idObjetivo = Integer.parseInt(JTIdObjetivo.getText());        
        String descripcionObjetivo = JTDescripcionObjetivo.getText();
        String tituloObjetivo = JTTituloObjetivo.getText();
        String estadoObjetivo = (String)JCEstadoObjetivo.getSelectedItem();  
        
        objetivoLista.setIdObjetivo(idObjetivo);
        objetivoLista.setDescripcionObjetivo(descripcionObjetivo);
        objetivoLista.setTituloObjetivo(tituloObjetivo);
        objetivoLista.setEstadoObjetivo(estadoObjetivo);
        listaObjetivo.add(objetivoLista);
                            
        objetivoDAO = new ObjetivoDAO();
        objetivoDAO.agregarObjetivo(objetivoLista);
                           
        return listaObjetivo;
    }   
     
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource().equals(JBSalir)){
            int confirmarAccion = JOptionPane.showConfirmDialog(null, "Desea salir", "salir", JOptionPane.OK_CANCEL_OPTION);
	if(confirmarAccion == JOptionPane.OK_OPTION){
            this.dispose();
		}
	}
	if(actionEvent.getSource().equals(JBConfirmar)){
            int confirmarAccion;
            confirmarAccion = JOptionPane.showConfirmDialog(null, "desesa confirmar", "confirmar", JOptionPane.OK_CANCEL_OPTION);
	if(confirmarAccion == JOptionPane.OK_OPTION){                       
               JOptionPane.showMessageDialog(this,"los datos han sido registrados");                
               enviarAcuerdo();
            }
	}
    }      
}

