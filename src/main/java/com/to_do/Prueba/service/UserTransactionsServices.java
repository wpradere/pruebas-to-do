package com.to_do.Prueba.service;

import com.to_do.Prueba.Model.entity.ListEntity;
import com.to_do.Prueba.Model.entity.UserEntity;
import com.to_do.Prueba.Model.repository.ListRepository;
import com.to_do.Prueba.Model.repository.UserRepository;
import com.to_do.Prueba.dtos.request.LoginRequest;
import com.to_do.Prueba.dtos.request.RegisterRequest;
import com.to_do.Prueba.dtos.request.RequestUsers;
import com.to_do.Prueba.dtos.response.AuthResponse;
import com.to_do.Prueba.dtos.response.ResponseUser;
import com.to_do.Prueba.jwt.JwtAutenticationFilter;
import com.to_do.Prueba.service.implemt.IUserTransactions;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Transactional
@Service
@Slf4j
@AllArgsConstructor

public class UserTransactionsServices implements IUserTransactions {

    private final UserRepository userRepository;
    private final ListRepository listRepository;
    private final JwtService jwtService;
    private  final JwtAutenticationFilter jwtAutenticationFilter;
    @Override
    public List<UserEntity> AllUsers() {return userRepository.findAll();
    }

    @Override
    public List<ListEntity> ListTaskUser() {
        String token = jwtAutenticationFilter.getTokenFilter();
        String user= jwtService.getUsernameFromToken(token);
        UserEntity userSession =  userRepository.findByUsername(user).orElseThrow();
       var listTaskUser = listRepository.findByIdUser(userSession.getId());
        return listTaskUser;
    }


}
