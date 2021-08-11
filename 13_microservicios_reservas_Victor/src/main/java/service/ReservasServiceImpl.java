package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dao.ReservasDao;
import model.Reserva;

//8. Creamos la clase que implementa la lógica y la anotamos con @Service
@Service
public class ReservasServiceImpl implements ReservasService {

	// 9. Inyectamos la capa dao
	@Autowired
	ReservasDao dao;

	// 10. Inyectamos el restTemplate que hay que crealo en la clase main, ya que
	// este servicio se va a conectar como cliente al de vuelos y va a compartir
	// información modificando las plazas restantes de los mismos en función de
	// las reservass que aquí se lleven a cabo
	@Autowired
	RestTemplate template; // Lo que hace de puente con otro microservicio 
	String url = "http://servicio-vuelos"; // identificdor de dirección con la que tenemos registrado el servicio de
											// vuelos en el servidor eureka

	// 11. En este caso no hay más lógica que llamar a los métodos de la capa dao
	@Override
	public List<Reserva> recuperareservas() {
		return dao.recuperarReservas();
	}

	// 12. en este método se combina l arealización de la reserva y la comunicación con el servicio de vuelos
	@Override
	public void efectuaReserva(Reserva reserva, int totalPersonas) {
		dao.realizarReserva(reserva);
		/*
		 * El parámetro total personas lo utilizamos para hacer un llamada al método put
		 * de el servicio de vuelos
		 */
		template.put(url + "/vuelos" + reserva.getVuelo() + "/" + totalPersonas, null);
		/*
		 * en el método put estamos pasando toda la información necesaria para la
		 * actualización en la url, como no hacemos uso de pasar objeto en el cuerpo de
		 * la petición pondremos null en el segundo argumento del método
		 */
	}

}
