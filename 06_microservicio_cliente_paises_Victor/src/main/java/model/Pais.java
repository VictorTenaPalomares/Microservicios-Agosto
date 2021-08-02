package model;

public class Pais {
	
	private String nombre;
	private String capital;
	private String bandera;
	private int poblacion;
	
	public Pais(String nombre, String capital,int poblacion, String bandera ) {
		super();
		this.nombre = nombre;
		this.capital = capital;
		this.bandera = bandera;
		this.poblacion = poblacion;
	}

	public Pais() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getBandera() {
		return bandera;
	}

	public void setBandera(String bandera) {
		this.bandera = bandera;
	}

	public int getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}
	
	
	
	
	
	

}
