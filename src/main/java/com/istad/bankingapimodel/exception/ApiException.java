package com.istad.bankingapimodel.exception;

import com.istad.bankingapimodel.base.BaseApi;
import com.istad.bankingapimodel.base.BaseError;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ApiException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseError<?> handleValidationException(MethodArgumentNotValidException e){
        List<Map<String,String>> errors= new ArrayList<>();
        for(FieldError fieldError: e.getFieldErrors()){
            Map<String,String> error = new HashMap<>();
            error.put("field",fieldError.getField());
            error.put("detail",fieldError.getDefaultMessage());
            errors.add(error);
        }
        return BaseError.builder()
                .status(false)
                .code(HttpStatus.BAD_REQUEST.value())
                .message("Something is wrong , please check in error detail!")
                .timestamp(LocalDateTime.now())
                .errors(errors)
                .build();
    }


}
