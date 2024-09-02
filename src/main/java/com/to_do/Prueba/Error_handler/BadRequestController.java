package com.to_do.Prueba.Error_handler;

import com.to_do.Prueba.dtos.response.BaseErrorREsponse;
import com.to_do.Prueba.dtos.response.ErrorAllREsponse;
import com.to_do.Prueba.dtos.response.ErrorResponse;
import com.to_do.Prueba.utils.exceptions.IdNotFoundExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;

@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestController {

    @ExceptionHandler(IdNotFoundExceptions.class)
    public BaseErrorREsponse handleIdNotFound(IdNotFoundExceptions exception){
        return ErrorResponse.builder()
                .error(exception.getMessage())
                .status(HttpStatus.BAD_REQUEST.name())
                .codeError(HttpStatus.BAD_REQUEST.value())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseErrorREsponse handleIdNotFound(MethodArgumentNotValidException exception){
        var errors = new ArrayList<String>();
        exception.getAllErrors()
                .forEach(error -> errors.add(error.getDefaultMessage()));

        return ErrorAllREsponse.builder()
                .errors(errors)
                .status(HttpStatus.BAD_REQUEST.name())
                .codeError(HttpStatus.BAD_REQUEST.value())
                .build();
    }

}
