package com.boot.mapeando;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc // dejamos que spring autoconfigure el objeto para las pruebas
@SpringBootTest
class ApplicationTests {

	// Para hacer las pruebas de los recursos que expone nuestro servicio
	// usaremos el objeto MockMVC el cual lo anotaremos con autowired
	@Autowired
	MockMvc mock; //

	// A continuación escribimos nuestras pruebas.En este caso se va a lanzar una 
	// petición http de tipo get con la dirección dameCursos cuyo resultado nos lo va a imprimir en consola
	@Test
	void testCursos() {
		try {
			mock.perform(get("/dameCursos")).andDo(print());
		} catch (Exception e) {
			System.out.println("Ha ocurrido un probelma de tipo: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	// Ahora probamos el método delete, al ser una petición HTTP que no se puede
	// realizar vía navegador, esta es la forma óptima de probar que funciona 
	// correctamente
	
	
	
	
	
	
	
	
	
	
	
	
}
