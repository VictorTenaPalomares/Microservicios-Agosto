package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Vuelo;
// 4. Anotar esta clase como la que ofrece el repositorio
@Repository
public class VuelosDaoImpl implements VuelosDao {

	// 5. Inyectar lo que nos viene del modelo
	@Autowired
	VuelosJpaSpring vuelos;
	
	
	@Override
	public List<Vuelo> devolverVuelos() {
		
		return vuelos.findAll();
	}

	@Override
	public Vuelo devolverVuelo(int idVuelo) {
		return vuelos.findById(idVuelo).orElse(null); // Como es u optional hay que, o bien lanzar una excepción o devolverlo con or else null
	}

	
	
	@Override
	public void actualizarVuelo(Vuelo vuelo) {
		vuelos.save(vuelo);
		
	}

}
