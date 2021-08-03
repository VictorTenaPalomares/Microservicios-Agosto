package dao;

import java.util.List;

import model.Hotel;

/*Interfaz de acceso a datos que contiene los métodos que queremos
 * exponer a la capa de servicio, esta interfaz debe ser implementada
 * por la clase y dentro de ella  instanciar la que hereda de jparepository
 *  a través de @autowired*/

public interface HotelesDao {
	
	public List<Hotel> devolverHoteles();

}
