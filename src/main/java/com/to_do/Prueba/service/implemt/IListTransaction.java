package com.to_do.Prueba.service.implemt;

import com.to_do.Prueba.dtos.request.RequestTask;
import com.to_do.Prueba.dtos.response.ResponseList;

public interface IListTransaction  extends CrudGeneric<RequestTask, ResponseList,Long>{

    ResponseList createTask (RequestTask task);
}
