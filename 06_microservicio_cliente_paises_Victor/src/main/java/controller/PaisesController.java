package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import model.Pais;
import service.PaisesService;

@RestController // convertimos esta clase en el controlador

public class PaisesController {
	
	/*Expone al cliente final los dos recursos get que se han desarrolado en la capa service*/
	
	@Autowired //instanciamos la interfaz de la capa de servicio
	PaisesService service;
	
	// Mapeamos la petición get desde la url /paises Que producirá un JSON llamando al resultado de lo que devuelve la lógica implementada en el método obtener paises de la capa de servicio
	@GetMapping(value = "/paises",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pais>paises(){
		return service.obtenerPaises();
	}
	
	@GetMapping(value = "/paises/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pais>paises(@PathVariable("name")String name){
		return service.buscarPaises(name);
	}

}
