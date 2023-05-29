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



/* 
 * ========= Configuracion con Oauth2 =========
 1) Añadir las siguientes dependencias
 
 	Spring Security
 	CloudBoostrap
 	ConfigClient (Servidor de configuraciones)
 	
 	1.1) Modificamos la siguiente dependencia
 	
 	antes:
 		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter</artifactId>
		</dependency>
		
	despues:
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-bootstrap</artifactId>
		</dependency>
 
 	1.2 Elimina la siguiente dependecia porque no es compatible
 		 spring-boot-starter-web
 		 
 		 
 */


/* Errores:
	1) Please set spring.main.web-application-type=reactive or remove spring-boot-starter-web dependency.
	Solo eliminala
	

 
 * 
 */
