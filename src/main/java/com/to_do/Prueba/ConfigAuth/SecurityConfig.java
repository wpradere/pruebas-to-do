package com.to_do.Prueba.ConfigAuth;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {


    /* crea metodo de filtros de seguridad donde se deshabilita el csrf y se crean rutas privadas y publicas */
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {
        return  httpSecurity
                .csrf(
                        csrf ->
                                csrf.disable()
                )
                .authorizeHttpRequests(authRequest ->
                 authRequest
                         .requestMatchers("/auth/**").permitAll()
                         .anyRequest().authenticated()
                )
                .formLogin(withDefaults())
                .build();
    }
}
