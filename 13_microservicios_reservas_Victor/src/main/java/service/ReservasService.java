package service;

import java.util.List;

import model.Reserva;
//7. Creamos la interfaz de la capa de servicio que establece metodos que va a desarrollar la clase
public interface ReservasService {
	public List<Reserva> recuperareservas();
	public void efectuaReserva(Reserva reserva,int totalPersonas); // realiza la reserva y establece un número de personas a actualizar en la llamada a vuelos

}
