package com.to_do.Prueba.service;

import com.to_do.Prueba.Model.entity.UserEntity;
import com.to_do.Prueba.Model.repository.UserRepository;
import com.to_do.Prueba.dtos.request.RequestUsers;
import com.to_do.Prueba.dtos.response.ResponseUser;
import com.to_do.Prueba.service.implemt.IUserTransactions;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
@Slf4j
@AllArgsConstructor

public class UserTransactionsServices implements IUserTransactions {

    private final UserRepository userRepository;


    @Override
    public List<UserEntity> AllUsers() {
        return userRepository.findAll();
    }
    @Override
    public ResponseUser create(RequestUsers requestUsers) {

        var userCreateBd = UserEntity.builder()
                .fullName(requestUsers.getFullName())
                .userName(requestUsers.getUserName())
                .password(requestUsers.getPassword())
                .build();

        this.userRepository.save(userCreateBd);
        ResponseUser response = new ResponseUser();
        response.setMessage("user was generate");

        return response;
    }
}
