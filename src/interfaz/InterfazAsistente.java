package interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InterfazAsistente extends JFrame{
    
    private JTextField JTNombrePila;
    private JTextField JTApellidos;
    private JTextField JTCorreoElectronico;
    
    public InterfazAsistente(){
         
    }
     
    public void menu(){
        setTitle("Registrar Asistentes");
	setSize(600, 500);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(null);
        inicializar();   
        
	setLocationRelativeTo(null);
	setVisible(true);
    }
    
    public void inicializar(){
       JLabel nombrePila = new JLabel("Ingrese su nombre");
       nombrePila.setBounds(50, 50, 200, 25);

       JTNombrePila = new JTextField();
       JTNombrePila.setBounds(250, 50, 200, 25);
       JTNombrePila.setText("Su nombre aqui");

        JLabel apellidos = new JLabel("Ingrese sus apellidos");
	apellidos.setBounds(50, 100, 200, 25);

        JTApellidos = new JTextField();
	JTApellidos.setBounds(250, 100, 200, 25);
	JTApellidos.setText("Sus apellidos aqui");

	JLabel correoElectronico = new JLabel("Ingrese su correo electronico");
	correoElectronico.setBounds(50, 150, 200, 25);

	JTCorreoElectronico = new JTextField();
	JTCorreoElectronico.setBounds(250, 150, 200, 25);
	JTCorreoElectronico.setText("Su correo electronico");
        
        this.add(JTNombrePila);
        this.add(JTApellidos);
        this.add(JTCorreoElectronico);
    }
    
    public void setNombrePila(JTextField JTNombrePila){
        this.JTNombrePila = JTNombrePila;
    }
    
    public JTextField getNombrePila(){
        return JTNombrePila;
    }
    
    public void setApellidos(JTextField JTApellidos){
        this.JTApellidos = JTApellidos;
    }
    
    public JTextField getApellidos(){
        return JTApellidos;
    }
    
    public void setCorreoElectronico(JTextField JTCorreoElectronico){
        this.JTCorreoElectronico = JTCorreoElectronico;
    }
    
    public JTextField getCorreoElectronico(){
        return JTCorreoElectronico;
    }
    
}
