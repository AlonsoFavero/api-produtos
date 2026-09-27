package com.alonso.api_produtos.exception;

public class ProdutoNotFoundException extends RuntimeException{

   public ProdutoNotFoundException(String mensagem){

       super(mensagem);
    }
}
