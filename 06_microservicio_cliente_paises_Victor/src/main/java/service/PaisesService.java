package service;
/*Implementamos una lógica de negocio que nos permita
 * llevar los datos que hemos definido en POJO hacia la
 * capa del controlador*/

import java.util.List;

import model.Pais;

public interface PaisesService {
	List<Pais> obtenerPaises();
	List<Pais> buscarPaises(String name);
}
