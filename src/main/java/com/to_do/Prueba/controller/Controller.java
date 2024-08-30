package com.to_do.Prueba.controller;

import com.to_do.Prueba.Model.entity.UserEntity;
import com.to_do.Prueba.dtos.request.RequestUsers;
import com.to_do.Prueba.dtos.response.ResponseUser;
import com.to_do.Prueba.service.implemt.IUserTransactions;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
@AllArgsConstructor
@RequestMapping("todo")
public class Controller {

    IUserTransactions iUserTransactions;

    @GetMapping("/users")
    public List<UserEntity>  allData(){
    return iUserTransactions.AllUsers();
    }


    @PostMapping("/createUser")
    public ResponseEntity<ResponseUser> createUser ( @RequestBody RequestUsers user){
       return ResponseEntity.ok( iUserTransactions.create(user));
    }

}
