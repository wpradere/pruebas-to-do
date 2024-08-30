package com.to_do.Prueba.controller;

import com.to_do.Prueba.Model.entity.UserEntity;
import com.to_do.Prueba.dtos.response.ResponseUser;
import com.to_do.Prueba.service.implemt.IUserTransactions;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@Component
@AllArgsConstructor
@RequestMapping("todo")
public class RestController {

    IUserTransactions iUserTransactions;

    @GetMapping("/users")
    public List<UserEntity>  allData(){
    return iUserTransactions.AllUsers();
    }

}
