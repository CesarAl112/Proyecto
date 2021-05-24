package Dominio;

public class Asistente{
	
	private String nombrePila;
	private String apellidos;
	private String correoElectronico;
        
        public Asistente(){
            nombrePila="";
            apellidos="";
            correoElectronico="";
        }

	public Asistente(String nombrePila, String apellidos, String correoElectronico){
		this.nombrePila = nombrePila;
		this.apellidos = apellidos;
		this.correoElectronico = correoElectronico;
	}

	public void setNombrePila(String nombrePila){
		this.nombrePila = nombrePila;
	}

	public String getNombrePila(){
		return nombrePila;
	}

	public void setApellidos(String apellidos){
		this.apellidos = apellidos;
	}

	public String getApellidos(){
		return apellidos;
	}

	public void setCorreoElectronico(String correoElectronico){
		this.correoElectronico = correoElectronico;
	}

	public String getCorreoElectronico(){
		return correoElectronico;
	}

}