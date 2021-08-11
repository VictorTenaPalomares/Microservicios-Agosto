package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Vuelo;

//2. Declarar una interfaz que hereda de JpaRepositori y como las funcionalidades
// van a ser básicas no tenemos que implementar ningún método adicional

public interface VuelosJpaSpring extends JpaRepository<Vuelo, Integer>{

}
