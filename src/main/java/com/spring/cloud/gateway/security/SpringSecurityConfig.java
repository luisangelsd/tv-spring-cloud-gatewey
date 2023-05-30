package com.spring.cloud.gateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class SpringSecurityConfig {
	
	@Autowired
	private JwtAuthenticationFilter authenticationFilter;
	
	
	//-- Creamos metodo Metodo: Configuramos acceso a las rutas
	@Bean
	public SecurityWebFilterChain configure(ServerHttpSecurity http) {
		return http.authorizeExchange()
				.pathMatchers("/api/security/**").permitAll()
				.pathMatchers("/api/traveling/agencias/**").hasAnyRole("ADMIN")
				.pathMatchers("/api/traveling/destinos/**").hasAnyRole("USER")
				.anyExchange().authenticated()
				.and()
				.addFilterAfter(authenticationFilter, SecurityWebFiltersOrder.AUTHENTICATION)
				.csrf().disable()  //-- Deshabilitamos el formulario de login
				.build();
	}

}
