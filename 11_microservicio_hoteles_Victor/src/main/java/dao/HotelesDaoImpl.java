package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Hotel;


/* @Repository un mecanismo para encapsular el comportamiento de almacenamiento, 
 * recuperación y búsqueda que emula una colección de objetos*/
@Repository
public class HotelesDaoImpl implements HotelesDao{	
	
	@Autowired
	HotelesJpaSpring hoteles; // Aquí es donde se hace la magia
	
	@Override
	public List<Hotel> devolverHoteles() {
		return hoteles.findAll(); // Con esta combinación de anotaciones e implementaciones de 
		// interfaces, hemos devuelto todas los registros de hoteles que hay en una base de datos
		// sin escribir ni una sola sentencia sql
	}

}
