 package contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Hotel;
import service.ServiceHoteles;

 @CrossOrigin (origins="*")// para permitir peticiones desde cualquier origen
@RestController // Para convertir esta clase en el controlador
public class HotelesController {
	
	@Autowired // inyectamos la interfaz que implementa la clase que contiene el servicio
	ServiceHoteles service;
	
	
	// Desde la petición get solo tenemos que llamar al método que contiene la lógica implementada en la capa se servicio
	 @GetMapping(value = "/hoteles",produces = MediaType.APPLICATION_JSON_VALUE)
	 public List<Hotel> devolverHoteles(){
		 return service.devolverHotelesDisponibles();
	 }
	
	
	
	

}
