package SGP_CA.Interfaces;

import SGP_CA.Domain.Reunion;
import SGP_CA.Bussineslogic.ReunionDAO;

import com.toedter.calendar.JCalendar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 *
 * @author Alberto
 */
public class InterfazReunionInsertar extends JFrame implements ActionListener{
    
    private DateFormat formatoHora = new SimpleDateFormat("HH:mm");
    private ArrayList<String> listaParticipante = new ArrayList<>();
    private ArrayList<Reunion> listaReunion = new ArrayList<>();
    private Reunion reunionLista = new Reunion();
    private ReunionDAO reunionDAO = new ReunionDAO();
    private JTextField JTIdReunion;
    private JTextField JTTituloReunion;
    private JTextField JTHoraInicio;
    private JTextField JTHoraFin;
    private JComboBox<String> JCLider;
    private JComboBox<String> JCResponsableRegistro;
    private JTextField JTAsunto;
    private JTextField JTLugarReunion;
    private JCalendar JCFechaReunion;
    private JButton JBConfirmar;
    private JButton JBSalir;    
    
    public void menuRegistrarReunion(){
        setTitle("Registrar reunion");
        setSize(700, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        obtenerParticipante();
        inicializarComponentes();        
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void inicializarComponentes(){
        JLabel idReunion = new JLabel("ingresar la clave de la reunion");
        idReunion.setBounds(100, 90, 200, 25);
        
        JTIdReunion = new JTextField();
        JTIdReunion.setBounds(100, 120, 150, 25);
        
        JLabel tituloReunion = new JLabel("Ingrese el titulo de la reunion");
        tituloReunion.setBounds(350, 90, 200, 25);
        
        JTTituloReunion = new JTextField();
        JTTituloReunion.setBounds(350, 120, 200, 25);
        
        JLabel horaInicio = new JLabel("Ingrese la hora de inicio");
        horaInicio.setBounds(100, 160, 150, 25);  
        
        JTHoraInicio = new JTextField();
        JTHoraInicio.setBounds(100, 190, 100, 25);
        
        JLabel horaFin = new JLabel("ingrese la hora de cierre");
        horaFin.setBounds(350, 150, 190, 25);
        
        JTHoraFin = new JTextField();
        JTHoraFin.setBounds(350, 190, 100, 25);
        
        JLabel lider = new JLabel("ingrese el lider de la reunion");
        lider.setBounds(50, 280, 200, 25);
        
        JCLider = new JComboBox();
        JCLider.setBounds(100, 300, 200, 25);
        listaParticipante.forEach((String) ->{
            JCLider.addItem(String);
        });        
                
        JLabel responsableRegistro = new JLabel("ingrese el nombre del responsable del registro");
        responsableRegistro.setBounds(350, 280, 280, 25);
        
        JCResponsableRegistro = new JComboBox();
        JCResponsableRegistro.setBounds(350, 300, 200, 25);
        listaParticipante.forEach((String) ->{
            JCResponsableRegistro.addItem(String);
        });        
        
        JLabel asunto = new JLabel("ingrese el asunto de la reunion");
        asunto.setBounds(100, 210, 200, 25);
        
        JTAsunto = new JTextField();
        JTAsunto.setBounds(100, 250, 200, 25);
        
        JLabel lugarReunion = new JLabel("ingrese el lugar de la reunion");
        lugarReunion.setBounds(350, 210, 200, 25);
        
        JTLugarReunion = new JTextField();
        JTLugarReunion.setBounds(350, 250, 200, 25);
        
        JLabel fechaReunion = new JLabel("Seleccione la fecha");
        fechaReunion.setBounds(240, 350, 150, 25);
        
        JCFechaReunion = new JCalendar();
        JCFechaReunion.setBounds(210, 370, 200, 200);        
        
        JBConfirmar = new JButton("Confirmar");
        JBConfirmar.setBounds(100, 600, 200, 30);	
        JBConfirmar.addActionListener(this);

        JBSalir = new JButton("Salir");
        JBSalir.setBounds(350, 600, 200, 30);
        JBSalir.addActionListener(this);
        
        this.add(idReunion);
        this.add(JTIdReunion);
        this.add(tituloReunion);
        this.add(JTTituloReunion);
        this.add(horaInicio);
        this.add(JTHoraInicio);
        this.add(horaFin);
        this.add(JTHoraFin);
        this.add(lider);
        this.add(JCLider);
        this.add(responsableRegistro);
        this.add(JCResponsableRegistro);
        this.add(asunto);
        this.add(JTAsunto);
        this.add(lugarReunion);
        this.add(JTLugarReunion);
        this.add(fechaReunion);
        this.add(JCFechaReunion);
        this.add(JBConfirmar);
        this.add(JBSalir);
    }
    
       private void obtenerParticipante(){
        reunionDAO = new ReunionDAO();
        listaParticipante = reunionDAO.obtenerParticipantes();
    }
    
    
    public ArrayList<Reunion> enviarReunion() throws ParseException{
        Reunion reunion = new Reunion();
        reunionDAO = new ReunionDAO();
        
        String horaInicio = JTHoraInicio.getText();
        String horaFin = JTHoraFin.getText();
        Date fechaReunion = JCFechaReunion.getDate();         
        int idReunion = Integer.parseInt(JTIdReunion.getText());
        String tituloReunion = JTTituloReunion.getText();
        String lider = (String) JCLider.getSelectedItem();
        String responsableRegistro = (String) JCResponsableRegistro.getSelectedItem();
        String asunto = JTAsunto.getText();
        String lugarReunion = JTLugarReunion.getText();        
        
        reunion.setIdReunion(idReunion);
        reunion.setTituloReunion(tituloReunion);
        reunion.setLider(lider);
        reunion.setHoraInicio(formatoHora.parse(horaInicio));
        reunion.setHoraFin(formatoHora.parse(horaFin));
        reunion.setResponsableRegistro(responsableRegistro);
        reunion.setAsunto(asunto);
        reunion.setLugarReunion(lugarReunion);
        reunion.setFechaReunion(fechaReunion);
                
        listaReunion.add(reunionLista);
        reunionDAO.insertar(reunion);
        
        return listaReunion;
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
               JOptionPane.showMessageDialog(this,"los datos han sido registrados");   
               
                try {
                    enviarReunion();
                } catch (ParseException ex) {
                    Logger.getLogger(InterfazReunionInsertar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }    
    }
    
}
