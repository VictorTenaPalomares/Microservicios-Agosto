package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Reserva;
//2. Creamos una interfaz que herede de JpaRepository para poder realizar operaciones CRUD sobre las entidades que nos brinda JPA en la clase POJO
// Una vez más, como las tareas que vamos a realizar son tipicament crud no desarrollamaos nada más
public interface ReservasJpaSring extends JpaRepository<Reserva,Integer > {

}
