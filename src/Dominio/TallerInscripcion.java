package Dominio;

public class TallerInscripcion{

	private String nombreTaller;
	private String ubicacionTaller;
        
        

	public TallerInscripcion(String nombreTaller, String ubicacionTaller){
		this.nombreTaller = nombreTaller;
		this.ubicacionTaller = ubicacionTaller;
	}

	public void setNombreTaller(String nombreTaller){
		this.nombreTaller = nombreTaller;
	}

	public String getNombreTaller(){
		return nombreTaller;
	}

	public void setUbicacionTaller(String ubicacionTaller){
		this.ubicacionTaller = ubicacionTaller;
	}

	public String getUbicacionTaller(){
		return ubicacionTaller;
	}

}