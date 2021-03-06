package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import model.Curso;

@RestController
public class CursosController {

	// Creamos una lista, simulando que estos datos vienen de una BBDD
	private List<Curso> cursos;

	// Instanciamos la lista una vez se construye el controlador : post-construct ;)
	@PostConstruct // significa que este método se ejecuta después de que instancie el controlador
					// a través de @RestController
	public void init() {
		cursos = new ArrayList<>();
		cursos.add(new Curso("Spring", "tarde", 25));
		cursos.add(new Curso("Spring boot", "tarde", 125));
		cursos.add(new Curso("Phyton", "tarde", 225));
		cursos.add(new Curso("Java EE", "tarde", 425));
		cursos.add(new Curso("Java Básico", "tarde", 525));
	}

	// Devolvemos la lista cuando se haga la petición desde dameCursos
	@GetMapping(value = "dameCursos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> getCursos() {
		return cursos;
	}
	
	
    // Devolvemos un curso en particular cuando se haga una petición pasando el nombre
	// de un curso por parámetro desde buscarCursos
	@GetMapping(value = "buscaCursos/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> buscarCursos(@PathVariable("nombre") String nombre) {

		// Creamos un array list auxiliar
		List<Curso> auxCursos = new ArrayList<>();
		// Recorremos el arrayList principal en busca de un curso con igual nombre,
		// en caso de encontrarlo lo añadimos al arrayList que hemos creado
		for (Curso curso : cursos) {
			if (curso.getNombre().contains(nombre)) {
				auxCursos.add(curso);
			}
		}
		return auxCursos;

	}

	/*
	 * En este método respondemos a la petición curso con un objeto en formato JSON
	 */
	@GetMapping(value = "curso", produces = MediaType.APPLICATION_JSON_VALUE)
	public Curso getCurso() {
		return new Curso("Java", "mañana", 100);
	}

}
