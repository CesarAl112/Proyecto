package SGP_CA.Interfaces;

import SGP_CA.Domain.Objetivo;
import SGP_CA.Bussineslogic.ObjetivoDAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author Alberto
 */
public class InterfazPrincipalObjetivo extends JFrame implements ActionListener{
    
    private String datosSeleccionados;
    private ArrayList<Objetivo> objetivoLista= new ArrayList<>();
    private DefaultTableModel tablaObjetivo;   
    private JTable JTObjetivo;
    private JButton JBInsertar;
    private JButton JBEditar;
    private JButton JBEliminar;
    private JButton JBSalir;
    private JButton JBRecargar;
    
    public void MenuPrincipalObjetivo(){
        this.setTitle("Objetivos");
        this.setSize(700,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);       
        inicializarComponentes(); 
        tablaObjetivo.setRowCount(0);
        cargarListaAcuerdo();  
        cargarDatosTabla();                
        setVisible(true);
    }             
    
    private void inicializarComponentes(){
        JLabel JLInfoObjetivo = new JLabel("Objetivos");
        JLInfoObjetivo.setBounds(20, 20, 210, 40);
        
        tablaObjetivo = new DefaultTableModel();
        JTObjetivo = new JTable(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        JTObjetivo.setCellSelectionEnabled(true);
        ListSelectionModel SeleccionarCelda = JTObjetivo.getSelectionModel();
        SeleccionarCelda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);     
        SeleccionarCelda.addListSelectionListener((ListSelectionEvent e) -> {
            datosSeleccionados = null;
            
            int[] seleccionarFila = JTObjetivo.getSelectedRows();
            int[] seleccionarColumna = JTObjetivo.getSelectedColumns();
            
            for(int i = 0; i<seleccionarFila.length;i++){
                for(int j = 0; j<seleccionarColumna.length;j++){
                    datosSeleccionados = (String) JTObjetivo.getValueAt(seleccionarFila[i], seleccionarColumna[j]);
                }                
            }
        });               

        JTObjetivo.setModel(tablaObjetivo);
        
        tablaObjetivo.addColumn("Identificador");
        tablaObjetivo.addColumn("Titulo");
        tablaObjetivo.addColumn("Descripcion");
        tablaObjetivo.addColumn("Estado");        

        
        JScrollPane desplazamiento = new JScrollPane(JTObjetivo);
        desplazamiento.setBounds(20, 70, 650, 300);    
        
        JBRecargar = new JButton("Recargar");
        JBRecargar.setBounds(120, 25, 100, 30);
        JBRecargar.addActionListener(this);
        
        JBInsertar = new JButton("Agregar");
        JBInsertar.setBounds(240, 25, 100, 30);
        JBInsertar.addActionListener(this);
        
        JBEditar = new JButton("Editar");
        JBEditar.setBounds(360, 25, 100, 30);
        JBEditar.addActionListener(this);
        
        JBEliminar = new JButton("Eliminar");
        JBEliminar.setBounds(480, 25, 100, 30);
        JBEliminar.addActionListener(this);
        
        JBSalir = new JButton("Salir");
        JBSalir.setBounds(560, 400, 100, 30);
        JBSalir.addActionListener(this);        
        
        
        this.add(JLInfoObjetivo);
        this.add(desplazamiento);
        this.add(JBRecargar);
        this.add(JBInsertar);
        this.add(JBEditar);
        this.add(JBEliminar);
        this.add(JBSalir);  
    }
    
     private void eliminarTabla(){
        ObjetivoDAO objetivoDAO = new ObjetivoDAO();
        int idObjetivo = Integer.parseInt(datosSeleccionados);
        objetivoDAO.eliminarObjetivo(idObjetivo);     
    }    
    
    private void cargarListaAcuerdo(){        
        ObjetivoDAO objetivoDAO = new ObjetivoDAO();  
        objetivoLista = objetivoDAO.obtenerObjetivo();
    }     

    private void cargarDatosTabla(){ 
        objetivoLista.forEach((objetivo) -> {  
            tablaObjetivo.addRow(filaAcuerdo(objetivo));  
        });        
    }      
 
    private String[] filaAcuerdo(Objetivo objetivo){
        int idObjetivo = objetivo.getIdObjetivo();
        String tituloObjetivo = objetivo.getTituloObjetivo();
        String descripcionObjetivo = objetivo.getDescripcionObjetivo();
        String estadoObjetivo = objetivo.getEstadoObjetivo();
        String[] fila ={Integer.toString(idObjetivo), tituloObjetivo, descripcionObjetivo, estadoObjetivo};
        return fila;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(JBRecargar)){
            tablaObjetivo.setRowCount(0);
            cargarListaAcuerdo();
            cargarDatosTabla();
            JTObjetivo.setModel(tablaObjetivo);
        }
        
        if(e.getSource().equals(JBInsertar)){
            InterfazObjetivoInsertar interfazInsertar = new InterfazObjetivoInsertar();
            interfazInsertar.menuRegistrarAcuerdo();
        }
        
        if(e.getSource().equals(JBEditar)){
            int seleccion = JTObjetivo.getSelectedRow();
            if(seleccion!=-1){
                InterfazObjetivoModificar interfazModificar = new InterfazObjetivoModificar();
                interfazModificar.cargarDatosEdicion(JTObjetivo);
                interfazModificar.MenuObjetivoModificar();                
            }else{
                JOptionPane.showMessageDialog(null, "Debe seleccionar un identificador", "Error", JOptionPane.ERROR_MESSAGE);                             
            }
        }
        
        if(e.getSource().equals(JBEliminar)){
            int seleccion = JTObjetivo.getSelectedRow();
            if(seleccion != -1){                
                eliminarTabla();                
                JOptionPane.showMessageDialog(null, "La fila fue eliminada correctamente");
            }else{
                JOptionPane.showMessageDialog(null, "Debe seleccionar un identificador", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if(e.getSource().equals(JBSalir)){
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "menu",JOptionPane.OK_CANCEL_OPTION);
            if(confirmar == JOptionPane.OK_OPTION){
                this.dispose();                
            }
        }
    }       
    
    
}
