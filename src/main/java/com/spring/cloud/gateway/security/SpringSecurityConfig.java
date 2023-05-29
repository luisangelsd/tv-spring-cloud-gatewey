package com.spring.cloud.gateway.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class SpringSecurityConfig {
	
	
	//-- Creamos metodo Metodo: Configuramos acceso a las rutas
	@Bean
	public SecurityWebFilterChain configure(ServerHttpSecurity http) {
		return http.authorizeExchange()
				.pathMatchers("/api/security/**").permitAll()
				.pathMatchers("/api/traveling/agencias/**").permitAll()
				.pathMatchers("/api/traveling/destinos/**").hasAnyRole("ADMIN")
				.anyExchange().authenticated()
				.and().csrf().disable()  //-- Deshabilitamos el formulario de login
				.build();
	}

}
