package inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
@ComponentScan(basePackages = {"controller","service"}) // para mapear los paquetes necesarios
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public RestTemplate template() { // Creamos la estructura que hace este servicio cliente de otro y luego la inyectamos en el service a través de autowired. Esto traerá a este servicio toda la información que el otro presente haciendo una llamada a sus url
		return new RestTemplate();
	}

}
