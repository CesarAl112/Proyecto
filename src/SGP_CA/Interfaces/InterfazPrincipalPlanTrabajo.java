package SGP_CA.Interfaces;

import SGP_CA.Bussineslogic.ObjetivoDAO;
import SGP_CA.Bussineslogic.PlanTrabajoDAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
/**
 *
 * @author Alberto
 */
public class InterfazPrincipalPlanTrabajo extends JFrame implements ActionListener{
    
    private boolean valor = false;
    private PlanTrabajoDAO planTrabajoDAO = new PlanTrabajoDAO();
    private ObjetivoDAO objetivoDAO = new ObjetivoDAO();
    private ArrayList<String> listaObjetivo = new ArrayList<>();
    private ArrayList<String> listaPlanTrabajo = new ArrayList<>();
    private JComboBox <String> JCTituloPlanTrabajo;
    private JComboBox <String> JCObjetivo;
    private JLabel JLNombreEncargado;
    private JButton JBAdministrar;
    private JButton JBAgregarPlanTrabajo;
    private JButton JBConsultarObjetivo;
    private JButton JBSalir;   
    
    public void MenuPrincipalPlanTrabajo(){
        this.setTitle("Plan de trabajo");
        this.setSize(800, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        obtenerTitulo();
        inicializarComponentes();
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void inicializarComponentes(){
        JLabel informacion = new JLabel("Consultar plan de trabajo");
        informacion.setBounds(15, 42, 200, 40);
        
        JCTituloPlanTrabajo = new JComboBox();
        JCTituloPlanTrabajo.setBounds(200, 50, 300, 25);
        listaPlanTrabajo.forEach((String) ->{
            JCTituloPlanTrabajo.addItem(String);
        });
        JCTituloPlanTrabajo.addItemListener((ItemEvent e) -> {
            if (e.getSource().equals(JCTituloPlanTrabajo)) {
                PlanTrabajoDAO planTrabajoDAO1 = new PlanTrabajoDAO();
                JLNombreEncargado.setText(planTrabajoDAO1.obtenerNombreEncargado((String)JCTituloPlanTrabajo.getSelectedItem()));
                JLNombreEncargado.setVisible(true);  
                valor=true;
            }
        });
        
        JLabel cuerpoAcademico = new JLabel("Cuerpo Academico: Ingenierai y Tecnologia de Software");
        cuerpoAcademico.setBounds(30, 92, 350, 40);
        
        JLabel nombreEncargado = new JLabel("Nombre: ");
        nombreEncargado.setBounds(30, 122, 200, 40);
        
        JLabel objetivo = new JLabel("Lista de objetivos");
        objetivo.setBounds(30,200,200,40);
        
        JLNombreEncargado = new JLabel();        
        JLNombreEncargado.setBounds(80, 122, 200, 40);        
        
        JCObjetivo = new JComboBox();
        JCObjetivo.setBounds(30, 250, 200, 40);
        listaObjetivo.forEach((String) ->{
            JCObjetivo.addItem(String);
        });
        
        JBConsultarObjetivo = new JButton("Consultar objetivo");
        JBConsultarObjetivo.setBounds(260, 250, 200, 40);
        JBConsultarObjetivo.addActionListener(this);
        
        JBAdministrar = new JButton("Administrar");
        JBAdministrar.setBounds(600, 50, 150, 25);
        JBAdministrar.addActionListener(this);
        
        JBAgregarPlanTrabajo = new JButton ("Agregar");
        JBAgregarPlanTrabajo.setBounds(550, 400, 200, 25);
        JBAgregarPlanTrabajo.addActionListener(this);
        
        JBSalir = new JButton("Salir");
        JBSalir.setBounds(20, 400, 200, 25);
        JBSalir.addActionListener(this);
                
        this.add(informacion);
        this.add(cuerpoAcademico);
        this.add(nombreEncargado);
        this.add(JLNombreEncargado);
        this.add(JCTituloPlanTrabajo);
        this.add(objetivo);
        this.add(JCObjetivo);
        this.add(JBConsultarObjetivo);
        this.add(JBAdministrar);
        this.add(JBAgregarPlanTrabajo);
        this.add(JBSalir);
    }
    
    private void obtenerTitulo(){
        listaPlanTrabajo = planTrabajoDAO.obtenerNombrePlanTrabajo();
        listaObjetivo = objetivoDAO.obtenerNombreObjetivo();
    }    
    

    @Override
    public void actionPerformed(ActionEvent actionEvent) {                      
        
        if(actionEvent.getSource().equals(JBConsultarObjetivo)){
            InterfazPrincipalObjetivo interfazObjetivo = new InterfazPrincipalObjetivo();
            interfazObjetivo.MenuPrincipalObjetivo();
        }
        
        if(actionEvent.getSource().equals(JBAdministrar)){
            if(valor==true){
                InterfazAdministrarPlanTrabajo interfazAdministrar = new InterfazAdministrarPlanTrabajo();
                interfazAdministrar.obtenerTitulo((String) JCTituloPlanTrabajo.getSelectedItem());
                interfazAdministrar.menuAdministrarPlanTrabajo();
            }else{
                JOptionPane.showMessageDialog(null, "Seleccione un plan de trabajo");
            }

        }
        if(actionEvent.getSource().equals(JBAgregarPlanTrabajo)){
            InterfazPlanTrabajoAgregar interfazAgregar = new InterfazPlanTrabajoAgregar();
            interfazAgregar.menuAgregarPlanTrabajo();
        }
        
        if(actionEvent.getSource().equals(JBSalir)){
            int confirmarAccion = JOptionPane.showConfirmDialog(null, "Desea salir", "salir", JOptionPane.OK_CANCEL_OPTION);
	if(confirmarAccion == JOptionPane.OK_OPTION){            
            LoginPrincipal loginPrincipal = new LoginPrincipal();
            loginPrincipal.MenuLogin();
            this.dispose();
		}
        }
    }
        
    
    
}
