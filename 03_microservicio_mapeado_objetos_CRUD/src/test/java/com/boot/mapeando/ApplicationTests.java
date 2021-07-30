package com.boot.mapeando;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


@AutoConfigureMockMvc // dejamos que spring autoconfigure el objeto para las pruebas
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class) // anotación quq nos sirve para decirle a esta clase que queremos odenar la
										// ejecución de las pruebas
class ApplicationTests {

	// Para hacer las pruebas de los recursos que expone nuestro servicio
	// usaremos el objeto MockMVC el cual lo anotaremos con autowired
	@Autowired
	MockMvc mock; //

	// A continuación escribimos nuestras pruebas.En este caso se va a lanzar una
	// petición http de tipo get con la dirección dameCursos cuyo resultado nos lo
	// va a imprimir en consola
	@Test
	@Order(1)
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
	@Test
	@Order(0)
	void eliminarCurso() {
		try {
			mock.perform(delete("/curso/Spring")).andDo(print());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@Order(2)
	void testAlta() throws Exception {
		mock.perform(post("/curso").contentType(MediaType.APPLICATION_JSON)
				.content("{\"nombre\":\"Angular 10\",\"duracion\":40,\"horario\":\"tarde\"}")).andDo(print());

	}
	
	@Test
	@Order(3)
	void testActualizacion() throws Exception{
		mock.perform(put("/curso")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"nombre\":\"Angular 10\",\"duracion\":80,\"horario\":\"mañana\"}")
				).andDo(print());
	}
}
