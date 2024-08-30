package com.to_do.Prueba.jwt;



import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;




/*Clase filtro de autenticacion  y extiende de OncePerRequestFilter clase abstracta para filtros personalizados
*  se garantiza que solo se ejecute una vez por cada peticion http
* el flterchain es la cadena de filtros configurada en la clase securityConfig */

@Component
@RequiredArgsConstructor
public class JwtAutenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String token = getTokenFromRequest(request);

        if(token==null){
            filterChain.doFilter(request,response);
            return;
        }

        filterChain.doFilter(request,response);

    }

    /*se toma el token del request y se divide despues del Bearer */
    private String getTokenFromRequest(HttpServletRequest request) {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if(StringUtils.hasText(authHeader)&& authHeader.startsWith("Bearer "))
        {
            return authHeader.substring(7);
        }
        return null;
    }


}
