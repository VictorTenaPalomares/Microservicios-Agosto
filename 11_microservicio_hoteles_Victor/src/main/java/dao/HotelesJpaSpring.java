package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Hotel;

public interface HotelesJpaSpring extends JpaRepository<Hotel, Integer>{

	/*En esta interfaz extendemos de jpa repository indicando la (Hotel)La clase 
	 * persistente para la tabla de la base de datos de hoteles (Que JPA ha
	 * creado automáticamente en model, y el tipo de dato que va a utilizar la clave 
	 * primaria de la tabla hoteles. Como la lógica de negocio es que nos devuelva 
	 * la lista de hoteles, no tenemos que implementar métodos que luego
	 * marque reglas a implementar por la clase que implemente esta interfaz
	 * 
	 * Porque el devolver la lista de hoteles ya es una funcionalidad que brinda jparepository). */
	
}
