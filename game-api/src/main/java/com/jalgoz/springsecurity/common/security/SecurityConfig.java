package com.jalgoz.springsecurity.common.security;

import com.jalgoz.springsecurity.common.utils.Path;
import com.jalgoz.springsecurity.common.utils.SecurityConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
  private final JwtAuthConverter jwtAuthConverter;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests()
        .requestMatchers(HttpMethod.GET, Path.GAME, Path.GAME_ALL).permitAll()
        .requestMatchers(Path.GAME, Path.GAME + "/*").hasRole(SecurityConstants.ADMIN)
        .requestMatchers(Path.COMMENTS_ID_ALLOWED).hasAnyRole(SecurityConstants.ADMIN, SecurityConstants.USER)
        .requestMatchers(Path.USER).hasAnyRole(SecurityConstants.ADMIN, SecurityConstants.USER)
        .anyRequest().authenticated();
    http.oauth2ResourceServer()
        .jwt()
        .jwtAuthenticationConverter(jwtAuthConverter);
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    http.cors().and().csrf().disable();
    return http.build();
  }
}
