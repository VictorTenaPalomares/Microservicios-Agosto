package inicio;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity // Anotaciones necesarias para una clase que defina condiciones de seguridad
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter { // Extender de esta clase y sobreescribir los métodos necesarios

	// Definición de roles y usuarios a traves de la sobreescritura de los métodos:
	
	//1. En este método definimos que estos 2 users van a poder acceder con estos credenciales
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth
		.inMemoryAuthentication()// Para definir en memoria las credenciales de usuario que va a aceptar la seguridad del servicio
		.withUser("User1")
		.password("{noop}user1")//noop se pone para no obligar a usar mecanismo de encriptación
		.roles("USER")
		.and()
		.withUser("User2")
		.password("{noop}admin")
		.roles("USER","ADMIN");		
	}
	
	//2. Definición de las políticas de seguridad
	// En este método restringimos la petición post únicamente para los administradores
	public void configure(HttpSecurity http	) throws Exception {
		http.csrf().disable() // se desactivan ciertas funciones para que no se tenga que autenticar cada vez que usa el servicio ya levantado
		.authorizeRequests()
		.antMatchers(HttpMethod.POST,"/contactos").hasRole("ADMIN") // le estamos diciendo que queremos proteger la url contactos con la petición http de tipo post, de modo que solo los usuarios del rol admin la puedan ejecutar
		.antMatchers("/contactos").authenticated()// por otro lado solo la van a poder lanzar users que hayan sido previemente autenticados
		.and().httpBasic(); // establecemos que la autenticación será básica,es decir usuario y contraseña
	}
	
	
	
	
	
	
	
}
