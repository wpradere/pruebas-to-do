package com.to_do.Prueba.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.to_do.Prueba.Model.entity.UserEntity;
import com.to_do.Prueba.Model.repository.UserRepository;
import com.to_do.Prueba.dtos.request.LoginRequest;
import com.to_do.Prueba.dtos.request.RegisterRequest;
import com.to_do.Prueba.dtos.response.AuthResponse;
import com.to_do.Prueba.service.implemt.IAuthtrans;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Transactional
@Service
@AllArgsConstructor
public class AuthService  implements IAuthtrans {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;



    @Override
    public AuthResponse login(LoginRequest request) {


        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        System.out.println(user);
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    @Override
    public AuthResponse register(RegisterRequest request) {

        UserEntity user = UserEntity.builder()
                .username(request.getUsername())
                .fullName(request.getFullname())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();

    }
}
