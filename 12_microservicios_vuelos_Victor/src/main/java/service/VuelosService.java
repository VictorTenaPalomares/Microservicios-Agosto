package service;

import java.util.List;

import model.Vuelo;

public interface VuelosService {
	
	List<Vuelo>recuperarVuelosDisponibles(int plazas); // Recupera un vuelo pasándole el número de plazas necesarias
	void actualizarPlazas(int idVuelo, int plazas); // actualiza las plazas de un determinado vuelo

}
