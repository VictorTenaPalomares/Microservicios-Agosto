package inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;



//16. Anotaciones para indicarle a spring donde estan las entidades
@EntityScan(basePackages = {"model"})
@EnableJpaRepositories(basePackages = {"dao"})
@ComponentScan (basePackages = {"controller","dao","service"})
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	//17. MUY IMPORTANTE
	//Activa Ribbon para conectar este micro con otro
	@LoadBalanced // consulta en eureka el id dela dirección del otro micro
	@Bean	// Para poder inyectar con autowired, en este caso en la capa de servicio
	public RestTemplate crearTemplate() {
		 return new RestTemplate();
	 }

}
