package com.to_do.Prueba.service.implemt;

import com.to_do.Prueba.dtos.request.RequestDeleteTask;
import com.to_do.Prueba.dtos.request.RequestTask;
import com.to_do.Prueba.dtos.request.RequestTaskUpdate;
import com.to_do.Prueba.dtos.response.ResponUpdateTask;
import com.to_do.Prueba.dtos.response.ResponseTask;

public interface IListTransaction  extends CrudGeneric<RequestTask, ResponseTask,Long>{

    ResponseTask createTask (RequestTask task);

    ResponUpdateTask updateTask (RequestTaskUpdate task);
    ResponUpdateTask deleteTask (RequestDeleteTask task);

}
