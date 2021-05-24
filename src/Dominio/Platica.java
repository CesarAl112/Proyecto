package Dominio;

public class Platica{

	private String nombrePlatica;
	private String fechaPlatica;
	private String ubicacionPlatica;
        
        public Platica(){
            
        }
        
	public Platica(String nombrePlatica, String fechaPlatica, String ubicacionPlatica){
		this.nombrePlatica = nombrePlatica;
		this.fechaPlatica = fechaPlatica;
		this.ubicacionPlatica = ubicacionPlatica;
	}

	public void setNombrePlatica(String nombrePlatica){
		this.nombrePlatica = nombrePlatica;
	}

	public String getNombrePlatica(){
		return nombrePlatica;
	}

	public void setFechaPlatica(String fechaPlatica){
		this.fechaPlatica = fechaPlatica;
	}

	public String getFechaPlatica(){
		return fechaPlatica;
	}

	public void setUbicacionPlatica(String ubicacionPlatica){
		this.ubicacionPlatica = ubicacionPlatica;
	}

	public String getUbicacionPlatica(){
		return ubicacionPlatica;
	}


}