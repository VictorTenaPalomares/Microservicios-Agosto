package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Contacto;

/*Esta es la clase que implementa las reglas de acceso a datos que hemos definido
 * en la interfaz agendaDao. Para que funcione todo hay que crar una instancia 
 * de la interfaz AgendaJpaSpring que es la que hereda del repositorio Spring
 *  y anotarla con @Autowired.*/
@Repository
public class AgendaDaoImpl implements AgendaDao {

	@Autowired
	AgendaJpaSpring agenda;

	@Override
	public void agregarContacto(Contacto contacto) {
		if (contacto != null) {
			agenda.save(contacto);
		}

	}

	@Override
	public Contacto recuperarContacto(String email) {
		if (email != null) {
			agenda.findByEmail(email);
		}
		return null;
	}

	@Override
	public void eliminarContacto(Contacto contacto) {
		if (contacto!=null) {
			agenda.delete(contacto);
		}
		
		

	}
	// Método que hemos añadido en la interfaz que hereda del repositorio por ser diferente a las habituales
	public void eliminarContacto(String email) {
		agenda.eliminarPorEmail(email);		
	}

	@Override
	public List<Contacto> devoloverContactos() {
		
		return agenda.findAll();
	}

	@Override
	public void eliminarContacto(int idContacto) {
		agenda.deleteById(idContacto);

	}

	@Override
	public Contacto recuperarContacto(int idContacto) {
		
		return agenda.findById(idContacto).orElse(null);
	}

	@Override
	public void actualizarContacto(Contacto contacto) {
		agenda.save(contacto);

	}

	@Override
	public Contacto recuperarContacto(Contacto contacto) {
		return null;
	}

}
