package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AgendaDao;
import model.Contacto;


// Anotamos con @service para que Spring instancie esta clase y luego se pueda
// utilizar en los controladores
@Service
public class AgendaServiceImpl implements AgendaService {

	/*Como vamos a utilizar los objetos de la capa dao dentro de la capa service
	 * tenemos que inyectar una implementación de la misma con @Autowired,
	 * recuerda, el autowired SIEMPRE sobre las interfaces*/
	@Autowired
	AgendaDao dao;
	
	@Override
	public boolean agregarContacto(Contacto contacto) {
		if (dao.recuperarContacto(contacto.getIdContacto())==null) {
			dao.agregarContacto(contacto);
			return true;
		}
		return false;
	}

	@Override
	public List<Contacto> recuperarContactos() {
		return dao.devoloverContactos();
	}

	@Override
	public void actualizarContacto(Contacto contacto) {
		if (dao.recuperarContacto(contacto.getIdContacto())!=null) {
			dao.actualizarContacto(contacto);
		}
	}

	@Override
	public boolean eliminarContacto(int idContacto) {
		if (dao.recuperarContacto(idContacto)!=null) {
			dao.eliminarContacto(idContacto);
			return true;
		}
		return false;
	
	}

	@Override
	public Contacto buscarContacto(int idContacto) {
		return dao.recuperarContacto(idContacto);
	}

}
