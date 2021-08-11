package inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//IMPORTANTE:
@EntityScan(basePackages = {"model"}) // Para decirle donde tiene que buscar las entidades que se han formado desde la BBDD
@EnableJpaRepositories(basePackages = {"dao"}) // Para decirle el paquete donde se encuentra la interfaz de JPArepositry
@ComponentScan(basePackages = { "controller", "dao", " service"}) // Los paquetes donde hay clase que tiene que instanciar spring


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
