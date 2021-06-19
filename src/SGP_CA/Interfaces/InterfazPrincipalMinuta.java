package SGP_CA.Interfaces;

import SGP_CA.Domain.Reunion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
/**
 *
 * @author Alberto
 */
public class InterfazPrincipalMinuta extends JFrame implements ActionListener{
    
    private JTextField JTNombreReunion;
    private JTextField JTFechaReunion;
    private JTextField JTFechaRegistro;
    private JTextField JTNotas;
    private JTextField JTPendientes;
    private JTextField JTNombreEncargado;
    private JTextField JTParticipante;
    private JButton JBVerAcuerdo;    
    private JButton JBSalir;
    
    public void menuPrincipalMinuta(){
        this.setTitle("Minutas");
        this.setSize(700,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);       
        inicializarComponentes();   
        
        setVisible(true);
    }
    
    private void inicializarComponentes(){
               
        JLabel nombreReunion = new JLabel("Reunion: ");
        nombreReunion.setBounds(50,50,100,30);
                
        JTNombreReunion = new JTextField();
        JTNombreReunion.setBounds(200,50,150,30);
        
        JLabel nombreEncargado = new JLabel("Encargado de la reunion: ");
        nombreEncargado.setBounds(50,100,200,30);                
        
        JTNombreEncargado = new JTextField();
        JTNombreEncargado.setBounds(200, 100, 150, 30);
        
        JLabel nombreParticipante = new JLabel("participante: ");
        nombreParticipante.setBounds(50,150,100,30);
        
        JTParticipante = new JTextField();
        JTParticipante.setBounds(200, 150, 150, 30);
        
        JLabel fechaReunion = new JLabel("Fecha de la reunion: ");
        fechaReunion.setBounds(50, 200, 200, 30);
        
        JTFechaReunion = new JTextField();
        JTFechaReunion.setBounds(200, 200, 150, 30);  
        
        JLabel fechaRegistro = new JLabel("Fecha de registro: ");
        fechaRegistro.setBounds(50, 250, 200, 30);               
        
        JTFechaRegistro = new JTextField();
        JTFechaRegistro.setBounds(200, 250, 150, 30);
        
        JLabel Notas = new JLabel("Notas: ");
        Notas.setBounds(50, 280, 100, 30);
        
        JTNotas = new JTextField();
        JTNotas.setBounds(50, 310, 250, 70);
        
        JLabel pendientes = new JLabel("Pendientes: ");
        pendientes.setBounds(400, 280, 100, 30);
        
        JTPendientes = new JTextField();
        JTPendientes.setBounds(390, 310, 250, 70);   
        
        JBVerAcuerdo = new JButton("Ver acuerdo");
        JBVerAcuerdo.setBounds(500, 50, 150, 30);
        JBVerAcuerdo.addActionListener(this);
        
        JBSalir = new JButton("Regresar");
        JBSalir.setBounds(570, 400, 100, 30);
        JBSalir.addActionListener(this);
        
        this.add(nombreReunion);
        this.add(JTNombreReunion);
        this.add(nombreEncargado);
        this.add(JTNombreEncargado);       
        this.add(nombreParticipante);
        this.add(JTParticipante);
        this.add(fechaReunion);
        this.add(JTFechaReunion);
        this.add(fechaRegistro);
        this.add(JTFechaRegistro);
        this.add(Notas);
        this.add(JTNotas);
        this.add(pendientes);
        this.add(JTPendientes);
        this.add(JBSalir);    
        this.add(JBVerAcuerdo);
    }
 
    public void obtenerReunion(JTable tabla){
        JTNombreReunion.setText((String) tabla.getValueAt(tabla.getSelectedRow(), 0));
        JTFechaReunion.setText((String) tabla.getValueAt(tabla.getSelectedRow(), 8));
        JTNombreEncargado.setText((String) tabla.getValueAt(tabla.getSelectedRow(), 4));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(JBSalir)){
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "menu",JOptionPane.OK_CANCEL_OPTION);
            if(confirmar == JOptionPane.OK_OPTION){                  
                this.dispose();
            }                    
        }
        if(e.getSource().equals(JBVerAcuerdo)){            
            InterfazPrincipalAcuerdo interfazAcuerdo = new InterfazPrincipalAcuerdo();
            interfazAcuerdo.menuPrincipalAcuerdo();
            this.dispose();  
        }
    }

}
