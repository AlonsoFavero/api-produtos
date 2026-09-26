package com.alonso.api_produtos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class ProdutoDTO {

    @NotBlank
  private String nome;

    @NotNull
    @Positive
   private BigDecimal preco;

    @NotNull
    @Positive
   private Integer quantidade;

    public void setNome(String nome){

        this.nome = nome;
    }

    public String getNome(){

        return nome;
    }

    public void setPreco(BigDecimal preco){

        this.preco = preco;
    }

    public BigDecimal getPreco(){

        return preco;
    }

    public void setQuantidade(Integer quantidade){

        this.quantidade = quantidade;
    }

    public Integer getQuantidade(){

        return quantidade;
    }
}
