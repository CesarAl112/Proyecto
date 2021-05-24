package interfaz;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame implements ActionListener{
    
    private JButton RegistrarAsistentes;
    private JButton RegistrarPlaticas;
    private JButton InscribirTaller;
    
    public MenuPrincipal(){
        setTitle("Menu principal");
	setSize(600, 500);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(null);
        inicializar();

	setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void inicializar(){
        RegistrarAsistentes = new JButton("Registrar Asistentes");
        RegistrarAsistentes.setBounds(50, 50, 200, 30);
        RegistrarAsistentes.addActionListener(this);
        
        RegistrarPlaticas = new JButton("Registrar Platicas");
        RegistrarPlaticas.setBounds(50, 100, 200, 30);
        RegistrarPlaticas.addActionListener(this);
        
        InscribirTaller = new JButton("Inscribir taller");
        InscribirTaller.setBounds(50, 150, 200, 30);
        InscribirTaller.addActionListener(this);
        
        this.add(RegistrarAsistentes);
        this.add(RegistrarPlaticas);
        this.add(InscribirTaller);
    }
    
    @Override
    public void actionPerformed(ActionEvent actionEvent){
	if(actionEvent.getSource().equals(RegistrarAsistentes)){
            RegistrarAsistentes registrarAsistentes = new RegistrarAsistentes();
            this.dispose();
	}
        if(actionEvent.getSource().equals(RegistrarPlaticas)){
            RegistrarPlaticas registrarPlaticas = new RegistrarPlaticas();
            this.dispose();
            }
        if(actionEvent.getSource().equals(InscribirTaller)){
            RegistrarTalleres inscribirTaller = new RegistrarTalleres();
            this.dispose();
            }
    }
}