package inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer // Registramos un servicio que despliega el eureka-server. Nos va a servir como administrador de diversos servicios para diversos clientes. La madre del cordero está en el archivo de configuración application.yml
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
