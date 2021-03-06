package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		cursos.add(new Curso("Python", "tarde", 225));
		cursos.add(new Curso("Java EE", "tarde", 425));
		cursos.add(new Curso("Java Básico", "tarde", 525));
	}

	/************************
	 * Peticiones HTTP GET(para consultas SELECT)
	 ********************************/

	// Devolvemos la lista cuando se haga la petición desde dameCursos
	@GetMapping(value = "dameCursos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> getCursos() {
		return cursos;
	}

	// Devolvemos un curso en particular cuando se haga una petición pasando el
	// nombre
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

	/***************************
	 * Peticiones HTTP DELETE
	 *****************************/

	@DeleteMapping(value = "curso/{name}")
	public void eliminarCurso(@PathVariable("name") String nombre) {

		// Para eliminar el curso nos apoyamos en el método de colección "removeIf"
		// al que hay que pasarle por parámetro una interfaz funcional de tipo
		// Predicate. En este caso vamos a utilizar una expresión Lambda donde c
		// es el nombre del parámetro del método y después de la flecha se desarrollan
		// las instrucciones a realizar

		cursos.removeIf(c -> c.getNombre().equals(nombre));
	}

	/***************************
	 * Peticiones HTTP POST(para consultas INSERT)
	 *****************************/

	/*
	 * Esta parte del servicio va a dar de alta un deteminado curso que recibirá en
	 * una petición post, pero además también va a devolver una lista con la
	 * relación actual de los cursos por lo tanto utilizará los atributos consumes y
	 * produces, porque consume un recurso y también lo produce
	 */
	@PostMapping(value = "curso", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> crearCurso(@RequestBody Curso curso) {

		cursos.add(curso);
		return cursos;
	}

	/***************************
	 * Peticiones HTTP PUT(para consultas UPDATE)
	 *****************************/

	/*
	 * En esta parte se recibe un curso y se devuelve una lista, por eso también
	 * usamos los atributos consumes y produces. En la declaración del método Usamos
	 * la anotación que rescata lo que hay en el cuerpo de la petición @RequestBody
	 * asignándole el nombre del curso que se pasa al parámetro del método
	 */
	@PutMapping(value = "curso", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> actualizaCurso(@RequestBody Curso curso) {
		// Recorremos la lista a través de los métodos habilitados a tal efecto
		// Y nos preguntamos si alguno de la lista coincide exáctamente con el nombre
		// que le hemos proporcionado.

		// En caso de que sea así, usamos el método set en la posición dela lista
		// afectada pasándole el curso que la va a sustituir
		for (int i = 0; i < cursos.size(); i++) {
			
			if (cursos.get(i).getNombre().equals(curso.getNombre())) {
				
				cursos.set(i, curso);
			}
		}
		return cursos;
	}

}
