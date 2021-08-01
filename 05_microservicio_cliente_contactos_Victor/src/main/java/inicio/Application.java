package inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;



@ComponentScan(basePackages = {"controller"})
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	// Este bean que anota la clase restTemplate convertirá este servicio
	// en cliente de otro para consumir los recursos que aquel presente.
	// La clase RestTemplate tiene sus propios métodos para realizar estas tareas
	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}

}
