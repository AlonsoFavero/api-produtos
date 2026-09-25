package com.alonso.api_produtos.controller;

import com.alonso.api_produtos.model.Produto;
import com.alonso.api_produtos.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){

        this.produtoService = produtoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto criar (@Valid @RequestBody Produto produto){

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
    public Produto atualizar(@PathVariable Long id,@Valid @RequestBody Produto produto){

        return produtoService.atualizar(id,produto);
    }

    @DeleteMapping("/{id}")
    public void excluir (@PathVariable Long id){

        produtoService.excluir(id);
    }
}
