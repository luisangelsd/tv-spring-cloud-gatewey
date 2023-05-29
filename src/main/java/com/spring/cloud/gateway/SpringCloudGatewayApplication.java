package com.spring.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringCloudGatewayApplication  {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudGatewayApplication.class, args);
	}

}



/* Configuración sin Oauth2:
 * - Es servidor Spring Cloud Gatawey
 * - Es cliente de Spring Cloud Config Server
 * - Es cliente de Spring Eureka Server
 * - Configura las rutas de acceso a los microservicios
 */

/* Configuracion con Oauth2*/