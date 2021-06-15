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
import javax.swing.JTable;
import javax.swing.JTextField;
/**
 *
 * @author Alberto
 */
public class InterfazAcuerdoModificar extends JFrame implements ActionListener{
    
    private ArrayList<String> listaParticipante = new ArrayList<>();
    private Acuerdo acuerdo = new Acuerdo();
    private AcuerdoDAO acuerdoDAO = new AcuerdoDAO();
    private JTextField JTIdAcuerdo;
    private JComboBox<String> JCResponsableAcuerdo;
    private JTextField JTTituloAcuerdo;
    private JComboBox<String> JCCumplimientoAcuerdo;
    private JButton JBConfirmar;
    private JButton JBSalir;
    
    public void menuModificarAcuerdo(){
        setTitle("modificar Acuerdo");
	setSize(600, 500);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(null);
        obtenerParticipante();
        inicializarComponentes(); 
        
	setLocationRelativeTo(null);
	setVisible(true);
    }
    
    private void inicializarComponentes(){
         JLabel idAcuerdo = new JLabel("Identificador del acuerdo");
         idAcuerdo.setBounds(50, 50, 200, 25);
         
         JTIdAcuerdo = new JTextField();
         JTIdAcuerdo.setBounds(250, 50, 200, 25);
         
         JLabel responsableAcuerdo = new JLabel("Nombre del responsable");
         responsableAcuerdo.setBounds(50, 100, 250, 25);
         
         JCResponsableAcuerdo = new JComboBox();
         JCResponsableAcuerdo.setBounds(250, 100, 200, 25);
         listaParticipante.forEach((String)->{
            JCResponsableAcuerdo.addItem(String); 
         });          
         
         JLabel tituloAcuerdo = new JLabel("Nombre del acuerdo");
         tituloAcuerdo.setBounds(50, 150, 200, 25);
         
         JTTituloAcuerdo = new JTextField();
         JTTituloAcuerdo.setBounds(250, 150, 200, 25);        
         
         JLabel cumplimientoAcuerdo = new JLabel ("Estado del acuerdo");
         cumplimientoAcuerdo.setBounds(50, 200, 200, 25);
         
         JCCumplimientoAcuerdo = new JComboBox<>();
         JCCumplimientoAcuerdo.setBounds(250, 200, 200, 25);
         JCCumplimientoAcuerdo.addItem("En uso");
         JCCumplimientoAcuerdo.addItem("En desuso");
         
         JBConfirmar = new JButton("Confirmar");
         JBConfirmar.setBounds(50, 300, 200, 30);	
         JBConfirmar.addActionListener(this);

         JBSalir = new JButton("Cancelar");
         JBSalir.setBounds(300, 300, 200, 30);
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

    public void cargarDatosEdicion(JTable tabla){	
        JTIdAcuerdo.setText((String) tabla.getValueAt(tabla.getSelectedRow(), 0));
        JTTituloAcuerdo.setText((String) tabla.getValueAt(tabla.getSelectedRow(), 1));
        JCResponsableAcuerdo.setSelectedItem((String) tabla.getValueAt(tabla.getSelectedRow(), 2));
        JCCumplimientoAcuerdo.setSelectedItem((String) tabla.getValueAt(tabla.getSelectedRow(), 3));
        
    }
    
    private void editarDatosAcuerdo(){
        int idAcuerdo = Integer.parseInt(JTIdAcuerdo.getText());
        String responsableAcuerdo = (String) JCResponsableAcuerdo.getSelectedItem();
        String tituloAcuerdo = JTTituloAcuerdo.getText();
        String cumplimientoAcuerdo = (String) JCCumplimientoAcuerdo.getSelectedItem();
        
        acuerdo.setIdAcuerdo(idAcuerdo);
        acuerdo.setResponsableAcuerdo(responsableAcuerdo);
        acuerdo.setTituloAcuerdo(tituloAcuerdo);
        acuerdo.setCumplimientoAcuerdo(cumplimientoAcuerdo);
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
            editarDatosAcuerdo();
            enviarAcuerdoEditado();
            JOptionPane.showMessageDialog(this,"los datos han sido registrados");
            }
	}
    }
    
    private void enviarAcuerdoEditado(){   
        acuerdoDAO = new AcuerdoDAO();
        acuerdoDAO.actualizarAcuerdo(acuerdo);  
    }
}