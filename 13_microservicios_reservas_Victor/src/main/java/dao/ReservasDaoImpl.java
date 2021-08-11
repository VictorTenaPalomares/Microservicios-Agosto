package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Reserva;

// 4. Anotamos con @Repository
@Repository
public class ReservasDaoImpl implements ReservasDao {

	// 5. Inyectamos capa de acceso a datos a través de la interfaz que hereda de
	// JpaRepository
	@Autowired
	ReservasJpaSring reservas;

	// 6. Recuperamos toda la información bruta de la capa de acceso a datos
	@Override
	public List<Reserva> recuperarReservas() {
		return reservas.findAll();
	}

	// 6. Recuperamos toda la información bruta de la capa de acceso a datos
	@Override
	public void realizarReserva(Reserva reserva) {
		reservas.save(reserva);
	}

}
