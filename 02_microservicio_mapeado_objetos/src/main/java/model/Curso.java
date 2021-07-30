package model;


/*Esta clase es una clase POJO, contendrá la información (beans) que el servicio
 * va a procesar a traves del controlador*/


public class Curso {
	
	private String nombre, horario;
	private int duracion;
	
	public Curso(String nombre, String horario, int duracion) {
		this.nombre = nombre;
		this.horario = horario;
		this.duracion = duracion;
	}
	
	public Curso() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	
	 

}
