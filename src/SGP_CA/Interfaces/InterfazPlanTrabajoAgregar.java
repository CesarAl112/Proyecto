package SGP_CA.Interfaces;

import SGP_CA.Bussineslogic.ObjetivoDAO;
import SGP_CA.Bussineslogic.PlanTrabajoDAO;
import SGP_CA.Domain.PlanTrabajo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 *
 * @author Alberto
 */
public class InterfazPlanTrabajoAgregar extends JFrame implements ActionListener{
    
    private DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    private PlanTrabajoDAO planTrabajoDAO = new PlanTrabajoDAO();
    private ArrayList<String> listaObjetivo = new ArrayList<>();
    private JComboBox <String> JCObjetivo;
    private JTextField JTEncargado;
    private JTextField JTTituloPlanTrabajo;   
    private JTextField JTFechaInicio;
    private JTextField JTFechaFin;
    private JTextArea JTMeta;
    private JTextArea JTEstrategia;
    private JButton JBConfirmar;
    private JButton JBSalir;
    
    public void menuAgregarPlanTrabajo(){
        setTitle("Agregar plan de trabajo");
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);        
        inicializarComponentes();        
        
        setVisible(true);
    }
    
    public static void main(String[] args){
        InterfazPlanTrabajoAgregar interfazPlanTrabajoAgregar = new InterfazPlanTrabajoAgregar();
        interfazPlanTrabajoAgregar.menuAgregarPlanTrabajo();
    }
    
    public void inicializarComponentes(){                     
        
        JLabel encargado = new JLabel("Nombre del encargado: ");
        encargado.setBounds(50, 60, 200, 30);        
        
        JTEncargado = new JTextField();
        JTEncargado.setBounds(190, 60, 200, 30);
        
        JLabel tituloPlan = new JLabel("titulo: ");
        tituloPlan.setBounds(50, 100, 200, 30); 
        
        JTTituloPlanTrabajo = new JTextField();
        JTTituloPlanTrabajo.setBounds(100, 100, 200, 30);     
        
        JLabel fechaInicio = new JLabel("Fecha Inicio: ");
        fechaInicio.setBounds(50, 140, 200, 30);  
        
        JTFechaInicio = new JTextField("dd/mm/yyyy");
        JTFechaInicio.setBounds(120, 140, 100, 25);
        
        JLabel fechaFin = new JLabel("Fecha fin :");
        fechaFin.setBounds(50, 180, 200, 30);
        
        JTFechaFin = new JTextField("dd/mm/yyyy");
        JTFechaFin.setBounds(120, 180, 100, 25);  
        
        JLabel meta = new JLabel("Meta");
        meta.setBounds(50, 210, 200, 30);
        
        JTMeta = new JTextArea();
        JTMeta.setBounds(50, 240, 500, 150);   
        
        JLabel estrategia = new JLabel("Estrategia");
        estrategia.setBounds(50, 410, 200, 30);
        
        JTEstrategia = new JTextArea();
        JTEstrategia.setBounds(50, 440, 500, 150);                
        
        JBConfirmar = new JButton("Confirmar");
        JBConfirmar.setBounds(30, 660, 200, 30);
        JBConfirmar.addActionListener(this);        
        
        JBSalir = new JButton("Salir");
        JBSalir.setBounds(550, 660, 200, 30);
        JBSalir.addActionListener(this);
        
        this.add(meta);
        this.add(JTMeta);
        this.add(tituloPlan);
        this.add(JTTituloPlanTrabajo);
        this.add(encargado);
        this.add(JTEncargado);
        this.add(estrategia);
        this.add(JTEstrategia);
        this.add(fechaInicio);
        this.add(JTFechaInicio);
        this.add(JTFechaFin);
        this.add(fechaFin);        
        this.add(JBConfirmar);
        this.add(JBSalir);
    }
    
      public void enviarDatos(){
        PlanTrabajo planTrabajo = new PlanTrabajo();
        planTrabajoDAO = new PlanTrabajoDAO();
                
        String meta = JTMeta.getText();
        String estrategia = JTEstrategia.getText();
        String fechaInicio = JTFechaInicio.getText();
        String fechaFin = JTFechaFin.getText();
        String tituloPlanTrabajo = JTTituloPlanTrabajo.getText();
               
        planTrabajo.setMeta(meta);
        planTrabajo.setEstrategia(estrategia);
        try{
            planTrabajo.setFechaInicio(formatoFecha.parse(fechaInicio));
            planTrabajo.setFechaFin(formatoFecha.parse(fechaFin));
        }catch(ParseException pe){
            
        }
        planTrabajo.setTituloPlanTrabajo(tituloPlanTrabajo);
        
        planTrabajoDAO.insertar(planTrabajo);
    }    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(JBConfirmar)){
            enviarDatos();
            JOptionPane.showMessageDialog(null, "Los datos fueron enviados");
        }
        if(e.getSource().equals(JBSalir)){
            int confirmarAccion = JOptionPane.showConfirmDialog(null, "Desea salir", "salir", JOptionPane.OK_CANCEL_OPTION);
	if(confirmarAccion == JOptionPane.OK_OPTION){
            this.dispose();
		}
        }
    }
    
    
}
