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
 	
 	y tambien: https://github.com/jwtk/jjwt#install-jdk-maven
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt-api</artifactId>
			<version>0.11.2</version>
		</dependency>
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt-impl</artifactId>
			<version>0.11.2</version>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt-jackson</artifactId>
			<version>0.11.2</version>
			<scope>runtime</scope>
		</dependency>

 	
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
 	
 	2) Añade el servicio Oauth2 a la configuracion (properties)
 	      - id: spring-oauth2
        	uri: lb://api/spring-oauth2
        	predicates:
         	- Path=/api/oauth2/**
         	- Method= GET, POST, PUT, DELETE
        		filters:
         	- StripPrefix=2  
         	
    3) Configuramos Boostrap: 
    
    	3.1) Añadimos lo siguiente en el properties:
    	#spring.config.import=optional:configserver
    	
    	3.2) Creamos archivo bootstrap.properties y añadimos
    	spring.application.name=spring-cloud-gateway
		spring.cloud.config.uri=http://localhost:8888
 	
 	4) Configuramos la classe "SpringSecurityConfig"
 	
 	
 	5) Configuramos la classe "AuthenticationManagerJwt"
 	
 	
 	6) Configura la clase "JwtAuthenticationFilter"
 	
 	
 		 
 		 
 		 
 */


/* Errores:
	1) Please set spring.main.web-application-type=reactive or remove spring-boot-starter-web dependency.
	Solo eliminala
	

 
 * 
 */
