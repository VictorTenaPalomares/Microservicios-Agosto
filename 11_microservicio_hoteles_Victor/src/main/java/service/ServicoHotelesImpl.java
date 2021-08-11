package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.HotelesDao;
import model.Hotel;
@Service // Anotación imprescindible para que se pueda inyectar este servicio en el controlador a través de autowired, pero recordar que lo que se tiene que inyectar es la interfaz
public class ServicoHotelesImpl implements ServiceHoteles {

	@Autowired
	HotelesDao dao; // Inyectamos la capa de acceso a datos desde la capa de servicios para poder
					// llamar a ese método devolver hoteles

	@Override
	public List<Hotel> devolverHotelesDisponibles() {
		// 1. Crear la lista que se va a devolver e igualarla a devolver hoteles
		List<Hotel> hoteles = dao.devolverHoteles();

		// 2. Devolvemos filtrando a través de streams Java8
		return hoteles.stream().filter(param -> param.getDisponible() == 1).collect(Collectors.toList());
		/*
		 * Explicación: A partit de la lista, llamo a stream y le aplicamos un filtro en
		 * el cual le decimos que a cada objeto de esa lista solo queremos almacenar aquellos que tienen
		 * el estado disponible que en este caso es representado por el entero 1.
		 *  A continuación el resultado se empaqueta en una nueva lista a través del método collect.
		 */
	}

}
