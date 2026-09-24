package com.alonso.api_produtos.service;

import com.alonso.api_produtos.model.Produto;
import com.alonso.api_produtos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){

        this.produtoRepository = produtoRepository;
    }

    public Produto salvar(Produto produto){

        return produtoRepository.save(produto);
    }
}
