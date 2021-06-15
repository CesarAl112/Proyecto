package SGP_CA.Interfaces;

import SGP_CA.Domain.Acuerdo;
import SGP_CA.Bussineslogic.AcuerdoDAO;
import SGP_CA.Bussineslogic.ReunionDAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class InterfazAcuerdoInsertar extends JFrame implements ActionListener{
    
    private ArrayList<String> listaParticipante = new ArrayList<>();
    private ArrayList<Acuerdo> listaAcuerdo = new ArrayList<>();
    private Acuerdo acuerdoLista = new Acuerdo();
    private AcuerdoDAO acuerdoDAO = new AcuerdoDAO();   
    private JTextField JTIdAcuerdo;
    private JComboBox<String> JCResponsableAcuerdo;
    private JTextField JTTituloAcuerdo;
    private JComboBox<String> JCCumplimientoAcuerdo;
    private JButton JBConfirmar;
    private JButton JBSalir;
    
     public void menuRegistrarAcuerdo(){
        setTitle("Registrar Acuerdo");
	setSize(600, 500);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(null);
        obtenerParticipante();
        inicializarComponentes();   
        
	setLocationRelativeTo(null);
	setVisible(true);
    }
     
     private void inicializarComponentes(){
         JLabel idAcuerdo = new JLabel("ingresar la clave del acuerdo");
         idAcuerdo.setBounds(50, 50, 200, 25);
         
         JTIdAcuerdo = new JTextField();
         JTIdAcuerdo.setBounds(250, 50, 200, 25);
         JTIdAcuerdo.setText("La clave ");
         
         JLabel responsableAcuerdo = new JLabel("Ingrese el nombre del responsable");
         responsableAcuerdo.setBounds(50, 100, 250, 25);
         
         JCResponsableAcuerdo = new JComboBox();
         JCResponsableAcuerdo.setBounds(250, 100, 200, 25);
         listaParticipante.forEach((String) ->{
            JCResponsableAcuerdo.addItem(String); 
         });
         
         JLabel tituloAcuerdo = new JLabel("ingrese el nombre del acuerdo");
         tituloAcuerdo.setBounds(50, 150, 200, 25);
         
         JTTituloAcuerdo = new JTextField();
         JTTituloAcuerdo.setBounds(250, 150, 200, 25);
         JTTituloAcuerdo.setText("El nombre..");               
         
         JLabel cumplimientoAcuerdo = new JLabel ("seleccione el estado del acuerdo");
         cumplimientoAcuerdo.setBounds(50, 200, 200, 25);
         
         JCCumplimientoAcuerdo = new JComboBox();
         JCCumplimientoAcuerdo.setBounds(250, 200, 200, 25);
         JCCumplimientoAcuerdo.addItem("En uso");
         JCCumplimientoAcuerdo.addItem("En desuso");
         
         JBConfirmar = new JButton("Confirmar");
         JBConfirmar.setBounds(50, 250, 200, 30);	
         JBConfirmar.addActionListener(this);

         JBSalir = new JButton("Salir");
         JBSalir.setBounds(300, 250, 200, 30);
         JBSalir.addActionListener(this);
         
         this.add(JTIdAcuerdo);
         this.add(idAcuerdo);
         this.add(JCResponsableAcuerdo);
         this.add(responsableAcuerdo);
         this.add(JTTituloAcuerdo);
         this.add(tituloAcuerdo);
         this.add(JCCumplimientoAcuerdo);
         this.add(cumplimientoAcuerdo);
         this.add(JBSalir);
         this.add(JBConfirmar);
     }   
     
    private void obtenerParticipante(){        
        ReunionDAO reunionDAO = new ReunionDAO();
        listaParticipante = reunionDAO.obtenerParticipantes();
    }

    public ArrayList<Acuerdo> enviarAcuerdo(){
        int idAcuerdo = Integer.parseInt(JTIdAcuerdo.getText());
        int cantidadAcuerdo = 0;
        String responsableAcuerdo = (String) JCResponsableAcuerdo.getSelectedItem();
        String tituloAcuerdo = JTTituloAcuerdo.getText();
        String cumplimientoAcuerdo = (String)JCCumplimientoAcuerdo.getSelectedItem();  
        
        acuerdoLista.setIdAcuerdo(idAcuerdo);
        acuerdoLista.setResponsableAcuerdo(responsableAcuerdo);
        acuerdoLista.setTituloAcuerdo(tituloAcuerdo);
        acuerdoLista.setCumplimientoAcuerdo(cumplimientoAcuerdo);
        listaAcuerdo.add(acuerdoLista);
        
        if(tituloAcuerdo.equals(acuerdoLista.getTituloAcuerdo())){
            cantidadAcuerdo++;
            acuerdoLista.setNumeroAcuerdo(cantidadAcuerdo);
            acuerdoDAO = new AcuerdoDAO();
            acuerdoDAO.agregarAcuerdo(acuerdoLista);
        } else {
            acuerdoDAO.agregarAcuerdo(acuerdoLista);
        }    
        return listaAcuerdo;
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