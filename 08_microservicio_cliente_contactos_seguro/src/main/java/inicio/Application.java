package inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

@ComponentScan(basePackages = {"controller"})
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	/*En esta ocasión este servicio cliente va a acceder a un servicio
	 * segurizado. Por lo tanto en la petición que se realiza hay que pasarle
	 * unos interceptores con las credenciales correctas que nos permitan acceder a él*/
	@Bean
	public RestTemplate template() { // Sincroniza un cliente para realizar peticiones HTTP
		BasicAuthenticationInterceptor intercep= new BasicAuthenticationInterceptor("User2", "admin"); // se usa para aplicar una autenticación HTTP básica(user/password))
		RestTemplate template=new RestTemplate(); 
		template.getInterceptors().add(intercep); // añadimos el interceptor que acabamos de crear a la llamda http que será manipulada en el controlador
		return template;
	}

}
