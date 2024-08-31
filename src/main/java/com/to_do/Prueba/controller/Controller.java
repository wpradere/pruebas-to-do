package com.to_do.Prueba.controller;

import com.to_do.Prueba.Model.entity.ListEntity;
import com.to_do.Prueba.Model.entity.UserEntity;
import com.to_do.Prueba.dtos.request.RequestDeleteTask;
import com.to_do.Prueba.dtos.request.RequestTask;
import com.to_do.Prueba.dtos.request.RequestTaskUpdate;
import com.to_do.Prueba.dtos.response.ResponUpdateTask;
import com.to_do.Prueba.dtos.response.ResponseTask;
import com.to_do.Prueba.service.implemt.IListTransaction;
import com.to_do.Prueba.service.implemt.IUserTransactions;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Component
@AllArgsConstructor
@RequestMapping("todo")
@Tag(name = "resource Methos")
public class Controller {

    private final IUserTransactions iUserTransactions;
    private final IListTransaction iListTransaction;



    @GetMapping("/users")
    public List<UserEntity>  allData(){
    return iUserTransactions.AllUsers();
    }

    @Operation(summary ="get task by user" )
    @GetMapping("/usersTask")
    public List<ListEntity> alluserTask(){
        return iUserTransactions.ListTaskUser();
    }

    @Operation(summary ="Create a  task " )
    @PostMapping("createTask")
    public  ResponseEntity<ResponseTask> createTask (@RequestBody RequestTask request){
        return ResponseEntity.ok(iListTransaction.createTask(request));
    }
    @Operation(summary ="Update Task  " )
    @PutMapping("updateTask")
    public  ResponseEntity<ResponUpdateTask> UpdateTask (@RequestBody RequestTaskUpdate request){
        return ResponseEntity.ok(iListTransaction.updateTask(request));
    }

    @Operation(summary ="Delete  Task by id  " )
    @DeleteMapping("deleteTask/{id}")
    public  ResponseEntity<ResponseTask> deleteTask (@PathVariable Long id){
        RequestDeleteTask request = new RequestDeleteTask();
        request.setId(id);
        return ResponseEntity.ok(iListTransaction.deleteTask(request));
    }


}
