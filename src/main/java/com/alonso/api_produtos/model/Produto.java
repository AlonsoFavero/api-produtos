package com.alonso.api_produtos.model;

import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Produto{

    @Id
    @GeneratedValue
    Long id;
    String nome;
    BigDecimal preco;
    Integer quantidade;

    public Produto(
            String nome,
            BigDecimal preco,
            Integer quantidade
    ){
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Produto(){


    }
}
