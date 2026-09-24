package com.alonso.api_produtos.service;

import com.alonso.api_produtos.model.Produto;
import com.alonso.api_produtos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){

        this.produtoRepository = produtoRepository;
    }

    public Produto salvar(Produto produto){

        return produtoRepository.save(produto);
    }

    public List<Produto> listar(){

        return produtoRepository.findAll();
    }

    public Produto buscarPoId(Long id){

        return produtoRepository.findById(id).orElseThrow();
    }
}
