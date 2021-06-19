package SGP_CA.Interfaces;

import SGP_CA.Domain.Acuerdo;
import SGP_CA.Bussineslogic.AcuerdoDAO;

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
public class InterfazPrincipalAcuerdo extends JFrame implements ActionListener{        
    
    private String datosSeleccionados;
    private ArrayList<Acuerdo> acuerdoLista= new ArrayList<>();
    private DefaultTableModel tablaAcuerdo;   
    private JTable JTAcuerdo;
    private JButton JBInsertar;
    private JButton JBEditar;
    private JButton JBEliminar;
    private JButton JBSalir;
    private JButton JBRecargar;
     
    public void menuPrincipalAcuerdo(){
        this.setTitle("Acuerdos");
        this.setSize(700,550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);       
        inicializarComponentes();                
        cargarListaAcuerdo();  
        cargarDatosTabla();           
        
        setVisible(true);
    }
    
    private void inicializarComponentes(){
        JLabel JLInfoAcuerdo = new JLabel("Acuerdos");
        JLInfoAcuerdo.setBounds(20, 20, 210, 40);
        
        tablaAcuerdo = new DefaultTableModel();
        JTAcuerdo = new JTable(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        JTAcuerdo.setCellSelectionEnabled(true);
        ListSelectionModel SeleccionarCelda = JTAcuerdo.getSelectionModel();
        SeleccionarCelda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);     
        SeleccionarCelda.addListSelectionListener((ListSelectionEvent e) -> {
            datosSeleccionados = null;
            
            int[] seleccionarFila = JTAcuerdo.getSelectedRows();
            int[] seleccionarColumna = JTAcuerdo.getSelectedColumns();
            
            for(int i = 0; i<seleccionarFila.length;i++){
                for(int j = 0; j<seleccionarColumna.length;j++){
                    datosSeleccionados = (String) JTAcuerdo.getValueAt(seleccionarFila[i], seleccionarColumna[j]);
                }                
            }
        });               

        JTAcuerdo.setModel(tablaAcuerdo);
        
        tablaAcuerdo.addColumn("Identificador");
        tablaAcuerdo.addColumn("Titulo");
        tablaAcuerdo.addColumn("Responsable");
        tablaAcuerdo.addColumn("Cumplimiento");
        tablaAcuerdo.addColumn("Cantidad");

        
        JScrollPane desplazamiento = new JScrollPane(JTAcuerdo);
        desplazamiento.setBounds(20, 70, 560, 290);    
        
        JBRecargar = new JButton("Recargar");
        JBRecargar.setBounds(130, 25, 100, 30);
        JBRecargar.addActionListener(this);
        
        JBInsertar = new JButton("Agregar");
        JBInsertar.setBounds(240, 25, 100, 30);
        JBInsertar.addActionListener(this);
        
        JBEditar = new JButton("Editar");
        JBEditar.setBounds(350, 25, 100, 30);
        JBEditar.addActionListener(this);
        
        JBEliminar = new JButton("Eliminar");
        JBEliminar.setBounds(460, 25, 100, 30);
        JBEliminar.addActionListener(this);
        
        JBSalir = new JButton("Salir");
        JBSalir.setBounds(430, 380, 150, 40);
        JBSalir.addActionListener(this);        
        
        
        this.add(JLInfoAcuerdo);
        this.add(desplazamiento);
        this.add(JBRecargar);
        this.add(JBInsertar);
        this.add(JBEditar);
        this.add(JBEliminar);
        this.add(JBSalir);    
    }            

    private void eliminarTabla(){
        AcuerdoDAO acuerdoDAO = new AcuerdoDAO();
        int idAcuerdo = Integer.parseInt(datosSeleccionados);
        acuerdoDAO.eliminarAcuerdo(idAcuerdo);     
    }    
    
    private void cargarListaAcuerdo(){        
        AcuerdoDAO acuerdoDAO = new AcuerdoDAO();  
        acuerdoLista = acuerdoDAO.obtenerAcuerdo();
    }     

    private void cargarDatosTabla(){ 
        acuerdoLista.forEach((acuerdo) -> {  
            tablaAcuerdo.addRow(filaAcuerdo(acuerdo));  
        });        
    }      

    private String[] filaAcuerdo(Acuerdo acuerdo){
        int idAcuerdo = acuerdo.getIdAcuerdo();
        String tituloAcuerdo = acuerdo.getTituloAcuerdo();
        String responsableAcuerdo = acuerdo.getResponsableAcuerdo();
        String cumplimientoAcuerdo = acuerdo.getCumplimientoAcuerdo();
        int numeroAcuerdo = acuerdo.getNumeroAcuerdo();
        String[] fila ={Integer.toString(idAcuerdo), tituloAcuerdo, responsableAcuerdo, cumplimientoAcuerdo, Integer.toString(numeroAcuerdo)};
        return fila;
    }          
    
    @Override
    public void actionPerformed(ActionEvent e){        
        
        if(e.getSource().equals(JBRecargar)){
            tablaAcuerdo.setRowCount(0);
            cargarListaAcuerdo();
            cargarDatosTabla();
            JTAcuerdo.setModel(tablaAcuerdo);            
            setVisible(true);
        }
        
        if(e.getSource().equals(JBInsertar)){
            InterfazAcuerdoInsertar interfazAcuerdoRegistrar = new InterfazAcuerdoInsertar();
            interfazAcuerdoRegistrar.menuRegistrarAcuerdo();
        }
        
        if(e.getSource().equals(JBEditar)){            
                InterfazAcuerdoModificar interfazAcuerdoModificar = new InterfazAcuerdoModificar();                               
                interfazAcuerdoModificar.menuModificarAcuerdo();
                interfazAcuerdoModificar.cargarDatosEdicion(JTAcuerdo);                                                                    
        }
        
        if(e.getSource().equals(JBEliminar)){                      
                eliminarTabla();                
                JOptionPane.showMessageDialog(null, "La fila fue eliminada correctamente");          
        }
        
        if(e.getSource().equals(JBSalir)){
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "menu",JOptionPane.OK_CANCEL_OPTION);
            if(confirmar == JOptionPane.OK_OPTION){
                this.dispose();
                InterfazPrincipalMinuta interfazMinuta = new InterfazPrincipalMinuta();
                interfazMinuta.menuPrincipalMinuta();
            }
        }
    }       
    
}
