package SGP_CA.Interfaces;

import SGP_CA.Bussineslogic.ObjetivoDAO;
import SGP_CA.Bussineslogic.PlanTrabajoDAO;
import SGP_CA.Bussineslogic.ReunionDAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Alberto
 */
public class LoginPrincipal extends JFrame implements ActionListener{       
    
    private JButton JBPlanDeTrabajo;
    private JButton JBReunion;    
    private JButton JBSalir;    
    
    public void MenuLogin(){
        this.setTitle("Menu Princial");
        this.setSize(700,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);       
        inicializarComponentes();
        
        setVisible(true);
    }           
    
    private void inicializarComponentes(){
        JLabel JLMenu = new JLabel("Login");
        JLMenu.setBounds(20,20, 210, 50);
        
        JBPlanDeTrabajo = new JButton("Plan de trabajo");
        JBPlanDeTrabajo.setBounds(120, 80, 200, 50);
        JBPlanDeTrabajo.addActionListener(this);
        
        JBReunion = new JButton("Reunion");
        JBReunion.setBounds(350, 80, 200, 50);
        JBReunion.addActionListener(this);
        
        JBSalir = new JButton("Salir");
        JBSalir.setBounds(230, 200, 200, 50);
        JBSalir.addActionListener(this);
        
        this.add(JLMenu);
        this.add(JBPlanDeTrabajo);
        this.add(JBReunion);
        this.add(JBSalir);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
       if(actionEvent.getSource().equals(JBPlanDeTrabajo)){           
           InterfazPrincipalPlanTrabajo interfazPlanTrabajo = new InterfazPrincipalPlanTrabajo();
           interfazPlanTrabajo.MenuPrincipalPlanTrabajo();
           this.dispose();
       }
       
       if(actionEvent.getSource().equals(JBReunion)){                             
           InterfazPrincipalReunion interfazReunion = new InterfazPrincipalReunion();
           interfazReunion.MenuReunionPrincipal();
           this.dispose();     
       }
       
       if(actionEvent.getSource().equals(JBSalir)){
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "menu",JOptionPane.OK_CANCEL_OPTION);
            if(confirmar == JOptionPane.OK_OPTION){
                this.dispose();
            }
    }
    
    
    }       
}
