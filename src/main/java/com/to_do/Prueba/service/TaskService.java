package com.to_do.Prueba.service;

import com.to_do.Prueba.dtos.request.RequestTask;
import com.to_do.Prueba.dtos.response.ResponseList;
import com.to_do.Prueba.service.implemt.IListTransaction;

public class TaskService implements IListTransaction {
    @Override
    public ResponseList createTask(RequestTask task) {
        return null;
    }
}
