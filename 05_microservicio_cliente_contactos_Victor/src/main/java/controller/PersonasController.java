package controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import model.Persona;

@RestController
public class PersonasController {

	// Inyectamos la dependencia que nos va a permitir acceder al servicio externo
	@Autowired
	RestTemplate template;

	// Metemos en una variable la dirección base url con la que vamos a invocar el
	// servicio
	String url = "http://localhost:8080";

	// Método que va a dar de alta una persona desde la url y
	// va a devolver la lista de objetos Persona que hay actualizada
	@GetMapping(value = "/personas/{nombre},{email},{edad}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Persona> altaPersona(@PathVariable("nombre") String nombre, @PathVariable("email") String email,
			@PathVariable("edad") int edad) {
		/*
		 * Este método hace 2 cosas, por un lado da de alta a una persona, para ello
		 * debemos construir un objeto persona y pasarlo al servicio externo en una
		 * petición POST
		 */
		Persona persona = new Persona(nombre, edad, email);
		template.postForLocation(url + "/contactos", persona); // Url de servicio destinatario
		
		/*En la segunda parte del método, una vez que ya se ha introducido la persona
		 * recuperamos la lista actualizada*/
		Persona[] personas= template.getForObject(url+"/contactos", Persona[].class); // Mapeamos la respuesta a objetos persona
		return Arrays.asList(personas);// Devolvemos el array convertido en lista dado que ese es el tipo que el método declara

	}

}
