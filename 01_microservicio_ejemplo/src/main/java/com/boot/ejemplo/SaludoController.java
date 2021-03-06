package com.boot.ejemplo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// Esta anotación convierte esta clase en controlador.
// Quiere decir que recoge y procesa las peticiones que se realizan al servicio
@RestController
public class SaludoController {

	// Dentro de la clase implementamos métodos que procesan la petición
	// Para que sea posible hay que anotar con @GetMapping, que en este caso
	// asocia un método a una petición de tipo GET, como atributo le pasamos
	// la URL que le vamos a asociar y el tipo de dato que va a devolver...
	@GetMapping(value = "saludo",produces=MediaType.TEXT_PLAIN_VALUE)
	public String getSaludo	() {
		
		return "Este es el primer microservicio que desarrollo";
		
	}
	
	/*En este caso la petición aporta datos, que serán procesados y devueltos
	 * en la respuesta. Dentro de los parámetros del método asignamos el dato
	 * pasado a una variable a través de la anotación @PathVariable*/
	@GetMapping(value = "saludo/{name}",produces=MediaType.TEXT_PLAIN_VALUE)
	public String getSaludo(@PathVariable("name") String nombre) {
		
		return "Hola soy " + nombre + " este es el primer microservicio que desarrollo";
		
	}
	
}
