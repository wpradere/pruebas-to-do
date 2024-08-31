package com.to_do.Prueba.service.implemt;

import com.to_do.Prueba.Model.entity.UserEntity;
import com.to_do.Prueba.dtos.request.RequestUsers;
import com.to_do.Prueba.dtos.response.ResponseUser;

import java.util.List;

public interface IUserTransactions extends CrudGeneric<RequestUsers, ResponseUser,Long> {
   List<UserEntity>  AllUsers();


}
