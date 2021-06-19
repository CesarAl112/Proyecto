
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
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Alberto
 */
public class InterfazObjetivoModificar extends JFrame implements ActionListener{
           
    private Objetivo objetivo= new Objetivo();
    private ObjetivoDAO objetivoDAO = new ObjetivoDAO();   
    private JTextField JTIdObjetivo;
    private JTextField JTDescripcionObjetivo;
    private JTextField JTTituloObjetivo;
    private JComboBox<String> JCEstadoObjetivo;
    private JButton JBConfirmar;
    private JButton JBSalir;
    
    public void MenuObjetivoModificar(){
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
         
         JTDescripcionObjetivo = new JTextField();
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

      public void cargarDatosEdicion(JTable tabla){	        
	JTIdObjetivo.setText((String) tabla.getValueAt(tabla.getSelectedRow(), 0));
        JTDescripcionObjetivo.setText((String) tabla.getValueAt(tabla.getSelectedRow(), 2));
	JTTituloObjetivo.setText((String) tabla.getValueAt(tabla.getSelectedRow(), 1));
        JCEstadoObjetivo.setSelectedItem((String) tabla.getValueAt(tabla.getSelectedRow(), 3));
    	}
    
    private void editarDatosAcuerdo(){
        int idObjetivo = Integer.parseInt(JTIdObjetivo.getText());
        String descripcionObjetivo = JTDescripcionObjetivo.getText();
        String tituloObjetivo = JTTituloObjetivo.getText();
        String estadoObjetivo = (String) JCEstadoObjetivo.getSelectedItem();
        
        objetivo.setIdObjetivo(idObjetivo);
        objetivo.setDescripcionObjetivo(descripcionObjetivo);
        objetivo.setTituloObjetivo(tituloObjetivo);
        objetivo.setEstadoObjetivo(estadoObjetivo);
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
            enviarObjetivoEditado();
            JOptionPane.showMessageDialog(this,"los datos han sido registrados");
            }
	}
    }
    
    private void enviarObjetivoEditado(){
        objetivoDAO = new ObjetivoDAO();
        objetivoDAO.actualizarObjetivo(objetivo);
    }
}
