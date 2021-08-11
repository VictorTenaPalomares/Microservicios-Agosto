package dao;

import java.util.List;

import model.Vuelo;

// 3. Interfaz que presenta los métodos que implementan la lógica
// deben ser desarrolladaos en la clase pero al inyectar con autowired 
// en el servicio lo haremos desde esta interfaz
public interface VuelosDao {
	public List<Vuelo> devolverVuelos();
	
	public Vuelo devolverVuelo(int idVuelo); // Devuelve un determinado vuelo a través de su identificador
	
	public void actualizarVuelo(Vuelo vuelo); // 
}
