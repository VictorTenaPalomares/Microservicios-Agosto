package exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*Clase encargada de gestionar posibles excepciones contempladas en este servicio
 * hay que anotarla con @RestControllerAdvice, no tiene que pasar por el controlador para
 * devolver información*/

@RestControllerAdvice
public class GestionExcepciones {
@ExceptionHandler(Exception.class) // anotación necesaria para poner en el método que manipula la excepción , creará un objeto del tipo que le indicamos entre paréntesis ;) 
public ResponseEntity<String>manejaError(Exception e){
	//se devuelve una respuesta con el código de error BAD_REQUEST
	//indicando en el cuerpo el mensaje de error
	return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST); // Personalizamos el error devuelto a través del mensaje propio que hemos creado y también afectamos a la cabecera HTTP modificando el código de estado, dándole el valor de 400 desde la constante que lo representa
}





}
