package com.alonso.api_produtos.controller;

import com.alonso.api_produtos.model.Produto;
import com.alonso.api_produtos.service.ProdutoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){

        this.produtoService = produtoService;
    }

    @PostMapping
    public Produto criar (@RequestBody Produto produto){

        return produtoService.salvar(produto);
    }
}
