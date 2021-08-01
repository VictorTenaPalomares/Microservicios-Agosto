package service;

import java.util.List;

import model.Contacto;

/*El paquete de servicio especifica qué va a hacer la aplicación independientemente
 * del correcto acceso a datos que ya se ha implementado en la capa dao.
 * Esto separa amabas capas pudiendo en un futuro cambiar aisladamente solo una de ellas
 * por ejemplo, cambiando la fuente de datos, en vez de ser una base de datos mysql
 *  que fuera de otro tipo...*/
public interface AgendaService {
	boolean agregarContacto(Contacto contacto);
	List<Contacto>recuperarContactos();
	void actualizarContacto(Contacto contacto);
	boolean eliminarContacto(int idContacto);
	Contacto buscarContacto(int idContacto);
}
