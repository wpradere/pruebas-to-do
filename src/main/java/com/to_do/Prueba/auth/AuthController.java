package com.to_do.Prueba.auth;


import com.to_do.Prueba.dtos.request.LoginRequest;
import com.to_do.Prueba.dtos.request.RegisterRequest;
import com.to_do.Prueba.dtos.response.AuthResponse;
import com.to_do.Prueba.service.implemt.IAuthtrans;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private  final IAuthtrans authtrans;

    @PostMapping("login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authtrans.login(request));
    }

    @PostMapping("register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authtrans.register(request));
    }
}
