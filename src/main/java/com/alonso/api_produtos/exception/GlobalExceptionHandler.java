package com.alonso.api_produtos.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> tratarErroDeValidacao(MethodArgumentNotValidException exception) {

        HashMap<String, String> tratarErros = new HashMap<>();

        for(var erro : exception.getBindingResult().getFieldErrors()){

            tratarErros.put(erro.getField(), erro.getDefaultMessage());

        }
        return ResponseEntity.badRequest().body(tratarErros);
    }
}


