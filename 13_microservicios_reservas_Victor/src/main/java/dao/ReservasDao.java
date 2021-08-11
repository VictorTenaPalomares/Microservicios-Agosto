package dao;

import java.util.List;

import model.Reserva;
// 3. Creación de interfaz para desarrollar en clase que la implemente
public interface ReservasDao {
	
	public List<Reserva> recuperarReservas(); // Devuelve la lista de reservas esistentes
	
	public void realizarReserva(Reserva reserva); // Genera una nueva reserva que se le pasa como argumento

}
