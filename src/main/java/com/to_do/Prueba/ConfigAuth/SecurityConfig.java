package com.to_do.Prueba.ConfigAuth;

import com.to_do.Prueba.jwt.JwtAutenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private static final String[] WHITE_LIST_URL = { "/auth/**","/api/v1/auth/**", "/v2/api-docs", "/v3/api-docs",
            "/v3/api-docs/**", "/swagger-resources", "/swagger-resources/**", "/configuration/ui",
            "/configuration/security", "/swagger-ui/**", "/webjars/**", "/swagger-ui.html",
            "/api/test/**"};



    /* crea metodo de filtros de seguridad donde se deshabilita el csrf y se crean rutas privadas y publicas */
    /*se indica que la politica de creacion de sessiones no las utilice con la opcion  STATELESS*/


    private final JwtAutenticationFilter jwtAutenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {
        return  httpSecurity
                .csrf(
                        csrf ->
                                csrf.disable()
                )
                .authorizeHttpRequests(authRequest ->
                 authRequest
                         .requestMatchers(WHITE_LIST_URL)
                         .permitAll()
                         .anyRequest().authenticated()
                )
                .sessionManagement( sessionManagement ->
                        sessionManagement
                                .sessionCreationPolicy( SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAutenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
