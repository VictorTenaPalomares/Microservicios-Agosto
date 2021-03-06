package com.boot.mapeando;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*En este caso como el controlador se encuentra en un paquete distinto al
 * de la clase main, debemos incluir la anotación correspondiente @ComponentScan
 *  para que lo escanee, le pasamos el nombre del paquete por parámetro:*/
@SpringBootApplication
@ComponentScan(basePackages = { "controllers" })//***************//
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
