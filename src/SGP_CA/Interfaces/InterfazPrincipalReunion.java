package SGP_CA.Interfaces;

import SGP_CA.Domain.Reunion;
import SGP_CA.Bussineslogic.ReunionDAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alberto
 */
public class InterfazPrincipalReunion extends JFrame implements ActionListener{
        
    private String datosSeleccionados;
    private int contador;
    private Reunion datosReunion = new Reunion();
    private ArrayList<Reunion> reunionLista = new ArrayList<>();
    private JTable JTReunion;
    private DefaultTableModel tablaReunion;
    private JButton JBAgendarReunion;
    private JButton JBEditar;
    private JButton JBVerMinuta;  
    private JButton JBRecargar;
    private JButton JBSalir;
    
    public void MenuReunionPrincipal(){
        this.setTitle("Reunión");
        this.setSize(800,550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);       
        inicializarComponentes(); 
        tablaReunion.setRowCount(0);
        cargarListaReunion();  
        cargarDatosTabla();  
        
        setVisible(true);
    }
    
    private void inicializarComponentes(){
        JLabel JLInfoReunion = new JLabel("Reunion");
        JLInfoReunion.setBounds(20, 20, 210, 40);
        
        tablaReunion = new DefaultTableModel();          
        JTReunion = new JTable(){            
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        JTReunion.setCellSelectionEnabled(true);        
        ListSelectionModel SeleccionarCelda = JTReunion.getSelectionModel();
        SeleccionarCelda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);     
        SeleccionarCelda.addListSelectionListener((ListSelectionEvent e) -> {
            datosSeleccionados = null;
            
            int[] seleccionarFila = JTReunion.getSelectedRows();
            int[] seleccionarColumna = JTReunion.getSelectedColumns();
            
            for(int i = 0; i<seleccionarFila.length;i++){
                for(int j = 0; j<seleccionarColumna.length;j++){
                    datosSeleccionados = (String) JTReunion.getValueAt(seleccionarFila[i], seleccionarColumna[j]);
                }                
            }
        });            
        JTReunion.setModel(tablaReunion);        
        tablaReunion.addColumn("Identificador");
        tablaReunion.addColumn("Nombre reunion");
        tablaReunion.addColumn("Hora inicio");
        tablaReunion.addColumn("Hora fin");
        tablaReunion.addColumn("Lider");
        tablaReunion.addColumn("Responsable del registro");
        tablaReunion.addColumn("Asunto");
        tablaReunion.addColumn("Lugar de la reunion");
        tablaReunion.addColumn("Fecha de la reunion");        
        
        JScrollPane desplazamiento = new JScrollPane(JTReunion);
        desplazamiento.setBounds(50, 70, 650, 290); 
        
        JBRecargar = new JButton("Recargar");
        JBRecargar.setBounds(100, 25, 100, 30);
        JBRecargar.addActionListener(this);
        
        JBEditar = new JButton("Editar");
        JBEditar.setBounds(250, 25, 100, 30);
        JBEditar.addActionListener(this);
        
        JBAgendarReunion= new JButton("Agregar reunion");
        JBAgendarReunion.setBounds(370, 25, 150, 30);
        JBAgendarReunion.addActionListener(this);
        
        JBVerMinuta = new JButton("Ver minuta");
        JBVerMinuta.setBounds(540, 25, 100, 30);
        JBVerMinuta.addActionListener(this);
        
        JBSalir = new JButton("Salir");
        JBSalir.setBounds(490, 370, 210, 40);
        JBSalir.addActionListener(this);
        
        this.add(JLInfoReunion);
        this.add(desplazamiento);
        this.add(JBRecargar);
        this.add(JBEditar);
        this.add(JBAgendarReunion);
        this.add(JBVerMinuta);
        this.add(JBSalir);
    }    
    
    private void cargarListaReunion(){                
        ReunionDAO reunionDAO = new ReunionDAO();
        reunionLista = reunionDAO.obtenerReunion();
    }     

    private void cargarDatosTabla(){ 
        reunionLista.forEach((reunion) -> {  
            tablaReunion.addRow(filaAcuerdo(reunion));  
        });                
    }            
 
    public String[] filaAcuerdo(Reunion reunion){
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat formatoHora = new SimpleDateFormat("HH:mm");
        
        int idReunion = reunion.getIdReunion();                
        String fechaReunion = formatoFecha.format(reunion.getFechaReunion());
        String horaInicio = formatoHora.format(reunion.getHoraInicio());
        String horaFin = formatoHora.format(reunion.getHoraFin()); 
        String tituloReunion = reunion.getTituloReunion();
        String lider = reunion.getLider();
        String responsableRegistro = reunion.getResponsableRegistro();
        String asunto = reunion.getAsunto();
        String lugarReunion = reunion.getLugarReunion();                
        
        String[] fila ={Integer.toString(idReunion), tituloReunion, horaInicio, 
            horaFin, lider, responsableRegistro, asunto, lugarReunion, fechaReunion};        
        return fila;
    }   

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(JBEditar)){
            InterfazReunionModificar interfazReunion = new InterfazReunionModificar();            
            interfazReunion.menuRegistrarReunion();
            interfazReunion.cargarDatosEdicion(JTReunion);
        }
        
        if(e.getSource().equals((JBAgendarReunion))){
            InterfazReunionInsertar interfazReunion = new InterfazReunionInsertar();
            interfazReunion.menuRegistrarReunion();
        }
        
        if(e.getSource().equals(JBVerMinuta)){
            InterfazPrincipalMinuta interfazMinuta = new InterfazPrincipalMinuta();
            interfazMinuta.menuPrincipalMinuta();
            interfazMinuta.obtenerReunion(JTReunion);
        }
        
        if(e.getSource().equals(JBSalir)){
            LoginPrincipal loginPrincipal = new LoginPrincipal();
            loginPrincipal.MenuLogin();
            this.dispose();
        }
    }
}
