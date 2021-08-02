package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import model.Pais;

@Service // anotamos para que esta clase pueda ser instanciada por Spring
public class PaisesServiceImpl implements PaisesService {

	String url="https://restcountries.eu/rest/v2/all"; //url del servicio al que vamos a acceder
	
	@Autowired
	RestTemplate template; // inyección del template para convertir a este servicio en cliente de otro (se encuentra en la clase main)
	
	@Override
	public List<Pais> obtenerPaises() { // Obtener una lista de paises
		String resultado=template.getForObject(url, String.class); //Lanzamos una petición http de tipo get al servicio y la envolvemos en un Stirng muy grande. Recordemos que el objetivo de esta práctica es elegir solamente unos pocos datos del total que nos ofrece el servicio
		ObjectMapper maper=new ObjectMapper(); // Objeto de la librería Jackson que nos permite mapear objetos JSON para pasarlos a objetos Java cuando la conversión de un modelo de datos a otro presenta incompatibilidades
		List<Pais>paises=new ArrayList<>(); // Creamos el tipo de lista en la que vamos a guardar el resultado obtenido
		ArrayNode array; //Representación de un array mapeado sobre un contenido JSON
		
		try {
			// Obtenemos array JSON con los datos de la respuesta
			array=(ArrayNode)maper.readTree(resultado); // casting del object mapper a un array de tipo JSON. Se usa el método readtree para desserializar la información
			for (Object objeto : array) {	// Obtenbemos el objeto Json y extraemos las propiedades que nos interesan
				ObjectNode json=(ObjectNode) objeto; 
				paises.add(new Pais(json.get("name").asText(),
						json.get("capital").asText(),
						json.get("population").asInt(),
						json.get("flag").asText()));
				
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return paises;
	}

	@Override
	public List<Pais> buscarPaises(String name) { // Obtener un lista de paises a partir de un nombre dado
		// Hacemos uso del método anterior y filtramos por nombre a través de una implementación stream de Java 8 formando finalmente una lista con los paises que contienen esa cadena de caracteres
		return obtenerPaises().stream().filter(p->p.getNombre().contains(name)).collect(Collectors.toList());
	}

}
 