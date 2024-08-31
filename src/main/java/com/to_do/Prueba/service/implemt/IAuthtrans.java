package com.to_do.Prueba.service.implemt;

import com.to_do.Prueba.dtos.request.LoginRequest;
import com.to_do.Prueba.dtos.request.RegisterRequest;
import com.to_do.Prueba.dtos.response.AuthResponse;

public interface IAuthtrans extends CrudGeneric <LoginRequest, AuthResponse,Long>{

    AuthResponse login (LoginRequest request);

    AuthResponse register (RegisterRequest request);

}
