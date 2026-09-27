package com.alonso.api_produtos.controller;

import com.alonso.api_produtos.dto.ProdutoDTO;
import com.alonso.api_produtos.dto.ProdutoResponseDTO;
import com.alonso.api_produtos.model.Produto;
import com.alonso.api_produtos.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Produto criar (@Valid @RequestBody ProdutoDTO produtoDTO){

        Produto produto = new Produto(
                produtoDTO.getNome(),
                produtoDTO.getPreco(),
                produtoDTO.getQuantidade()
        );

        return produtoService.salvar(produto);
    }

    @GetMapping
    public List<ProdutoResponseDTO> listar(){

        List<Produto> produto = produtoService.listar();

        List<ProdutoResponseDTO> produtosDTO = produto.stream()
         .map(produtos -> new ProdutoResponseDTO(produtos))
                .toList();

        return produtosDTO;
    }

    @GetMapping("/{id}")
    public ProdutoResponseDTO buscarPorId(@PathVariable Long id){

        Produto produto = produtoService.buscarPorId(id);

        ProdutoResponseDTO produtoDTO = new ProdutoResponseDTO(produto);

        return produtoDTO;
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id,@Valid @RequestBody ProdutoDTO produtoDTO){

        Produto produto = new Produto(

                produtoDTO.getNome(),
        produtoDTO.getPreco(),
        produtoDTO.getQuantidade()
                );

        return produtoService.atualizar(id,produto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> excluir (@PathVariable Long id){

        produtoService.excluir(id);

       return ResponseEntity.noContent().build();
    }
}
