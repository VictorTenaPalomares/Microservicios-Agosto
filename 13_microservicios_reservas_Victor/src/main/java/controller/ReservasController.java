package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Reserva;
import service.ReservasService;

// 13. Capa que se va dedicar de administrar las peticiones a este servicio, por eso la anotamos con @restcontroller
@CrossOrigin(origins="*") //para que se puedan hacer peticiones desde múltiples origenes
@RestController
public class ReservasController {
	
	@Autowired
	ReservasService service;
	
	
	@GetMapping(value="reservas",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Reserva> recuperaReservas(){
		return service.recuperareservas();
		
	}
	
	//14. Como ya está implementado en la capa de servicio derivamos la llamada
	// pasando la reserva que llega en el body por ser una petición de tipo post
	// y las personas que las pasamos como segundo parámetro que como vienen en la url cambian de anotación 
	
	@PostMapping(value="reservas/{personas}",consumes = MediaType.APPLICATION_JSON_VALUE) 
	public void efectuaReserva(@RequestBody Reserva reserva, @PathVariable ("personas") int totalPersonas) {
		service.efectuaReserva(reserva, totalPersonas);
	}
	
	
	

}
