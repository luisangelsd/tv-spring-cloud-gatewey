package com.spring.cloud.gateway.security;

import java.util.Base64;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import reactor.core.publisher.Mono;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class AuthenticationManagerJwt implements ReactiveAuthenticationManager {

	
	//--
	@Value("${config.security.oauth.jwt.key}")
	private String llaveJwt;
	
	@Override
	public Mono<Authentication> authenticate(Authentication authentication) {
		
		return null;
	}

	

}
