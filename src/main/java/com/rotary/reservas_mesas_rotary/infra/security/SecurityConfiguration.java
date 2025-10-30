package com.rotary.reservas_mesas_rotary.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return  httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()

                        // Baile - somente ADMIN
                        .requestMatchers(HttpMethod.POST, "/baile").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/baile").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/baile/**").hasRole("ADMIN")

                        // Baile - acesso USER e ADMIN
                        .requestMatchers(HttpMethod.GET, "/baile").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.GET, "/baile/**").hasAnyRole("ADMIN", "USER")

                        // Reservas — USER e ADMIN podem criar e cancelar
                        .requestMatchers(HttpMethod.POST, "/reservas").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.DELETE, "/reservas/**").hasAnyRole("ADMIN", "USER")

                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return  authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}