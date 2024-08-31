package com.to_do.Prueba.controller;

import com.to_do.Prueba.Model.entity.UserEntity;
import com.to_do.Prueba.dtos.request.RequestTask;
import com.to_do.Prueba.dtos.request.RequestTaskUpdate;
import com.to_do.Prueba.dtos.response.ResponUpdateTask;
import com.to_do.Prueba.dtos.response.ResponseTask;
import com.to_do.Prueba.service.implemt.IListTransaction;
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

    private final IUserTransactions iUserTransactions;
    private final IListTransaction iListTransaction;



    @GetMapping("/users")
    public List<UserEntity>  allData(){
    return iUserTransactions.AllUsers();
    }


    @PostMapping("createTask")
    public  ResponseEntity<ResponseTask> createTask (@RequestBody RequestTask request){
        return ResponseEntity.ok(iListTransaction.createTask(request));
    }

    @PutMapping("updateTask")
    public  ResponseEntity<ResponUpdateTask> UpdateTask (@RequestBody RequestTaskUpdate request){
        return ResponseEntity.ok(iListTransaction.updateTask(request));
    }


}
