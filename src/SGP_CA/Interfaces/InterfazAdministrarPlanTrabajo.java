package SGP_CA.Interfaces;

import SGP_CA.Bussineslogic.PlanTrabajoDAO;
import SGP_CA.Domain.PlanTrabajo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
public class InterfazAdministrarPlanTrabajo extends JFrame implements ActionListener{
    
    private DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    private String titulo;
    private boolean valor;
    private int idPlanTrabajo;
    private JTextField JTTituloPlanTrabajo;   
    private JTextField JTEncargado;
    private JTextField JTFechaInicio;
    private JTextField JTFechaFin;
    private JTextArea JTMeta;
    private JTextArea JTEstrategia;
    private JButton JBModificar;
    private JButton JBGuardar;
    private JButton JBSalir;

    public void menuAdministrarPlanTrabajo(){
        setTitle("Administrar");
        setSize(800,850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);        
        valor=false;
        inicializarComponentes();        
        obtenerDatos();
        
        setVisible(true);
    }
    
    private void inicializarComponentes(){        
        JLabel tituloPlan = new JLabel("titulo: ");
        tituloPlan.setBounds(50, 100, 200, 30); 
        
        JTTituloPlanTrabajo = new JTextField();
        JTTituloPlanTrabajo.setBounds(100, 100, 200, 30);    
        JTTituloPlanTrabajo.setEnabled(false);
        
        JLabel encargado = new JLabel("Nombre del encargado: ");
        encargado.setBounds(50, 60, 200, 30);        
        
        JTEncargado = new JTextField();
        JTEncargado.setBounds(190, 60, 200, 30);
        JTEncargado.setEnabled(false);
        
        JLabel fechaInicio = new JLabel("Fecha Inicio: ");
        fechaInicio.setBounds(50, 140, 200, 30);  
        
        JTFechaInicio = new JTextField("dd/mm/yyyy");
        JTFechaInicio.setBounds(120, 140, 100, 25);
        JTFechaInicio.setEnabled(false);
        
        JLabel fechaFin = new JLabel("Fecha fin :");
        fechaFin.setBounds(50, 180, 200, 30);
        
        JTFechaFin = new JTextField("dd/mm/yyyy");
        JTFechaFin.setBounds(120, 180, 100, 25);  
        JTFechaFin.setEnabled(false);
        
        JLabel meta = new JLabel("Meta");
        meta.setBounds(50, 210, 200, 30);
        
        JTMeta = new JTextArea();
        JTMeta.setBounds(50, 240, 500, 150);   
        JTMeta.setEnabled(false);
        
        JLabel estrategia = new JLabel("Estrategia");
        estrategia.setBounds(50, 410, 200, 30);
        
        JTEstrategia = new JTextArea();
        JTEstrategia.setBounds(50, 440, 500, 150);  
        JTEstrategia.setEnabled(false);
        
        JBModificar = new JButton("Modificar");
        JBModificar.setBounds(550, 100, 200, 30);
        JBModificar.addActionListener(this);
        
        JBGuardar = new JButton("Guardar");
        JBGuardar.setBounds(30, 660, 200, 30);
        JBGuardar.addActionListener(this);        
        
        JBSalir = new JButton("Salir");
        JBSalir.setBounds(550, 660, 200, 30);
        JBSalir.addActionListener(this);
                
        this.add(encargado);
        this.add(JTEncargado);
        this.add(tituloPlan);
        this.add(JTTituloPlanTrabajo);
        this.add(fechaInicio);
        this.add(JTFechaInicio);
        this.add(fechaFin);  
        this.add(JTFechaFin); 
        this.add(meta);
        this.add(JTMeta);
        this.add(estrategia);
        this.add(JTEstrategia);     
        this.add(JBModificar);
        this.add(JBGuardar);
        this.add(JBSalir);
    }
    
    public void obtenerTitulo(String titulo){
        this.titulo = titulo;
    }

    private void obtenerDatos(){
        PlanTrabajoDAO planTrabajoDAO = new PlanTrabajoDAO();
        PlanTrabajo planTrabajo;
        planTrabajo = planTrabajoDAO.obtenerPorTitulo(titulo);
        JTEncargado.setText(planTrabajo.getNombreEncargado());
        idPlanTrabajo = planTrabajo.getIdPlanTrabajo();
        JTTituloPlanTrabajo.setText(titulo);
        JTMeta.setText(planTrabajo.getMeta());
        JTEstrategia.setText(planTrabajo.getEstrategia());
        JTFechaInicio.setText(formatoFecha.format(planTrabajo.getFechaInicio()));
        JTFechaFin.setText(formatoFecha.format(planTrabajo.getFechaFin()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(JBModificar)){
            JTEncargado.setEnabled(true);
            JTMeta.setEnabled(true);
            JTEstrategia.setEnabled(true);
            JTFechaInicio.setEnabled(true);
            JTFechaFin.setEnabled(true);
            JTTituloPlanTrabajo.setEnabled(true);   
            valor = true;
        }
        if(e.getSource().equals(JBGuardar)){
             if(valor==true){
                 enviarDatos();
                 JOptionPane.showMessageDialog(null, "Se enviaron los datos");
             }else{
                 JOptionPane.showMessageDialog(null, "Primero da clic en modificar");
             }
        }
        
        if(e.getSource().equals(JBSalir)){
            int confirmarAccion = JOptionPane.showConfirmDialog(null, "Desea salir", "salir", JOptionPane.OK_CANCEL_OPTION);
	if(confirmarAccion == JOptionPane.OK_OPTION){
            this.dispose();
		}
        }
    }
    
    public void enviarDatos(){
        PlanTrabajo planTrabajo = new PlanTrabajo();
        PlanTrabajoDAO planTrabajoDAO = new PlanTrabajoDAO();
                
        String meta = JTMeta.getText();
        String estrategia = JTEstrategia.getText();
        String fechaInicio = JTFechaInicio.getText();
        String fechaFin = JTFechaFin.getText();
        String tituloPlanTrabajo = JTTituloPlanTrabajo.getText();
        
        planTrabajo.setIdPlanTrabajo(idPlanTrabajo);
        planTrabajo.setMeta(meta);
        planTrabajo.setEstrategia(estrategia);
        try{
            planTrabajo.setFechaInicio(formatoFecha.parse(fechaInicio));
            planTrabajo.setFechaFin(formatoFecha.parse(fechaFin));
        }catch(ParseException pe){
            
        }
        planTrabajo.setTituloPlanTrabajo(tituloPlanTrabajo);
        
        planTrabajoDAO.actualizar(planTrabajo);
    }    

}
