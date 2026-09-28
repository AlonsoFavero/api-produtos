package com.alonso.api_produtos.dto;

import com.alonso.api_produtos.model.Produto;

import java.math.BigDecimal;

public class ProdutoResponseDTO {

   private Long id;
   private String nome;
   private BigDecimal preco;
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

    public void setId(Long id){

        this.id = id ;
    }

    public Long getId(){

        return id;
    }

    public ProdutoResponseDTO(){

    }

    public ProdutoResponseDTO(Produto produto){

        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.quantidade = produto.getQuantidade();
        this.id = produto.getId();

    }
}
