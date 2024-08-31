package com.to_do.Prueba.service;

import com.to_do.Prueba.Model.entity.ListEntity;
import com.to_do.Prueba.Model.entity.UserEntity;
import com.to_do.Prueba.Model.repository.ListRepository;
import com.to_do.Prueba.Model.repository.UserRepository;
import com.to_do.Prueba.dtos.request.RequestDeleteTask;
import com.to_do.Prueba.dtos.request.RequestTask;
import com.to_do.Prueba.dtos.request.RequestTaskUpdate;
import com.to_do.Prueba.dtos.response.ResponUpdateTask;
import com.to_do.Prueba.dtos.response.ResponseTask;
import com.to_do.Prueba.jwt.JwtAutenticationFilter;
import com.to_do.Prueba.service.implemt.IListTransaction;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Transactional
@Service
@Slf4j
@AllArgsConstructor
public class TaskService implements IListTransaction {
    private final JwtService jwtService;
    private  final JwtAutenticationFilter jwtAutenticationFilter;
    private final UserRepository userRepository;
    private final ListRepository listRepository;


    @Override
    public ResponseTask createTask(RequestTask request) {
        String token = jwtAutenticationFilter.getTokenFilter();
        String user= jwtService.getUsernameFromToken(token);
        UserEntity userSession =  userRepository.findByUsername(user).orElseThrow();

        var task = ListEntity.builder()
                .nameList(request.name_list)
                .state(request.state)
                .idUser(userSession.getId())
                .dateStart(LocalDate.now())
                .dateUpdate(LocalDate.now())
                .build();

        listRepository.save(task);

        return ResponseTask.builder()
                .Message("Task create sucessfull")
                .build();
    }

    @Override
    public ResponUpdateTask updateTask(RequestTaskUpdate request) {
        var taskUpdate = listRepository.findById(request.id_list).orElseThrow();
        taskUpdate.setState(request.state);
        taskUpdate.setDateUpdate(LocalDate.now());
        listRepository.save(taskUpdate);
        return this.entityToResponse(taskUpdate);
    }

    @Override
    public ResponseTask deleteTask(RequestDeleteTask task) {
        var taskDelete = listRepository.findById(task.id).orElseThrow();
        listRepository.delete(taskDelete);
        return ResponseTask.builder()
                .Message("task Was eleminated")
                .build();
    }




    private ResponUpdateTask entityToResponse(ListEntity entity){
        var response = new ResponUpdateTask();
        BeanUtils.copyProperties(entity,response);
        return response;
    }
}


