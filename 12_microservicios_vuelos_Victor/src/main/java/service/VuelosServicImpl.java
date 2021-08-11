package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.VuelosDao;
import model.Vuelo;

@Service
public class VuelosServicImpl implements VuelosService {

	@Autowired
	VuelosDao dao;

	@Override
	public List<Vuelo> recuperarVuelosDisponibles(int plazas) {
		return dao.devolverVuelos().stream() // flujo de datos
				.filter(param -> param.getPlazas() >= plazas) // filtramos los vuelos quedándonos solo con los que
																// tienen las mismas o más plazas que necesitamos
				.collect(Collectors.toList()); // El resultado que hemos obtenido lo volvemos a pasar a una lista
	}

	@Override
	public void actualizarPlazas(int idVuelo, int plazas) {

		Vuelo vuelo = dao.devolverVuelo(idVuelo); // accedemos a un vuelo a traves de su id
		if (vuelo != null) {
			vuelo.setPlazas(vuelo.getPlazas() - plazas); // cuando lo tenemos le aplicamos el método de establecer
															// plazas restando las plazas actuales de las existentes
			dao.actualizarVuelo(vuelo); // llamamos al método que actualiza con la nueva información
		}
	}

}
