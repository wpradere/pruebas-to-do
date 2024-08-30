package com.to_do.Prueba.service.implemt;

public interface CrudGeneric  <REQUEST, RESPONSE ,ID>{

    RESPONSE create (REQUEST request);
}
