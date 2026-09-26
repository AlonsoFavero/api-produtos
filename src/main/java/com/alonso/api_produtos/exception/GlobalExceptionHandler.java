package com.alonso.api_produtos.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.NoSuchElementException;

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

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> tratarNaoEncontrado(NoSuchElementException exception){

        return ResponseEntity.status(404).body("produto não encontrado");
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> tratarErroDeTipo(MethodArgumentTypeMismatchException exception) {

        return ResponseEntity.badRequest().body("ID inválido");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> tratarErroInterno(Exception exception){

        return ResponseEntity.status(500).body("Erro interno no servidor");
    }
}


