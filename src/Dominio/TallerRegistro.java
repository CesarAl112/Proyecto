package Dominio;

public class TallerRegistro{

	private String nombreTaller;
	private String fechaTaller;
	private String ubicacionTaller;
	private String encargadoTaller;
        
        public TallerRegistro(){
            
        }

	public TallerRegistro(String nombreTaller, String fechaTaller, String ubicacionTaller, String encargadoTaller){
		this.nombreTaller = nombreTaller;
		this.fechaTaller = fechaTaller;
		this.ubicacionTaller = ubicacionTaller;
		this.encargadoTaller = encargadoTaller;
	}

	public void setNombreTaller(String nombreTaller){
		this.nombreTaller = nombreTaller;
	}

	public String getNombreTaller(){
		return nombreTaller;
	}

	public void setFechaTaller(String fechaTaller){
		this.fechaTaller = fechaTaller;
	}

	public String getFechaTaller(){
		return fechaTaller;
	}

	public void setUbicacionTaller(String ubicacionTaller){
		this.ubicacionTaller = ubicacionTaller;
	}

	public String getLugarTaller(){
		return ubicacionTaller;
	}

	public void setEncargadoTaller(String encargadoTaller){
		this.encargadoTaller = encargadoTaller;
	}

	public String getEncargadoLugar(){
		return encargadoTaller;
	}

}