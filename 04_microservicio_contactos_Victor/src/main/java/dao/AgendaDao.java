package dao;

import java.util.List;

import model.Contacto;

public interface AgendaDao {
	
	// Recibe un objeto contacto y lo da de alto en la capa de persistencia
	void agregarContacto(Contacto contacto);

	// Recuperar un contacto a partir de su email
	Contacto recuperarContacto(String email);

	// Eliminar un contacto a partir de su email
	void eliminarContacto(Contacto contacto);

	// Devolver la lista de todos los contactos
	List<Contacto> devoloverContactos();

	// Eliminar un contacto a partir de su identificador
	void eliminarContacto(int idContacto);

	// Recuperar un contacto a partir de su identificador
	Contacto recuperarContacto(Contacto idContacto);

	// Actualizar un contacto a partir de su identificador
	void actualizarContacto(Contacto contacto);

	Contacto recuperarContacto(int idContacto);

}
