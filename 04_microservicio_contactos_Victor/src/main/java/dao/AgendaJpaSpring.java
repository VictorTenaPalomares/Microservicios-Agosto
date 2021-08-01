package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import model.Contacto;
/*Esta interfaz hereda del repositorio que nos ofrece Spring para realizar
 * sin tener que codificar nada las operaciones crud más habituales contra una base de datos
 * Tenemos que indicarle en los corchetes la clase que contiene las entidades y 
 * el tipo de dato que forma la clave primaria*/
public interface AgendaJpaSpring extends JpaRepository<Contacto, Integer>{
	
	
	/*Como nuestro programa va a usar cconsultas que se salen de las habituales
	 * que soporta JPARepository debemos programarlas de la siguiente forma:*/
	Contacto findByEmail(String email);
	@Transactional
	@Modifying
	@Query("Delete from(Contacto c Where c.email=?1)")
	void eliminarPorEmail(String email);
	
	
	
	
	

}
