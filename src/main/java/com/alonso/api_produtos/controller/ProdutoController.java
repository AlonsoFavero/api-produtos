package com.alonso.api_produtos.controller;

import com.alonso.api_produtos.model.Produto;
import com.alonso.api_produtos.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<Produto> listar(){

        return produtoService.listar();
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id){

        return produtoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id,@RequestBody Produto produto){

        return produtoService.atualizar(id,produto);
    }
}
