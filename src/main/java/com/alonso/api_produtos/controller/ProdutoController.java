package com.alonso.api_produtos.controller;

import com.alonso.api_produtos.dto.ProdutoDTO;
import com.alonso.api_produtos.dto.ProdutoResponseDTO;
import com.alonso.api_produtos.model.Produto;
import com.alonso.api_produtos.service.ProdutoService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){

        this.produtoService = produtoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoResponseDTO criar (@Valid @RequestBody ProdutoDTO produtoDTO){

        Produto produto = new Produto(
                produtoDTO.getNome(),
                produtoDTO.getPreco(),
                produtoDTO.getQuantidade()
        );

        Produto produtoCriar = produtoService.salvar(produto);

        ProdutoResponseDTO produtoResponseDTO = new ProdutoResponseDTO(produtoCriar);

        return produtoResponseDTO;
    }

    @GetMapping
    public Page<ProdutoResponseDTO> listar(@RequestParam String nome, Pageable pageable){

        Page<Produto> produtos = produtoService.listar(nome, pageable);

        return produtos.map(produto -> new ProdutoResponseDTO(produto));

    }

    @GetMapping("/{id}")
    public ProdutoResponseDTO buscarPorId(@PathVariable Long id){

        Produto produto = produtoService.buscarPorId(id);

        ProdutoResponseDTO produtoDTO = new ProdutoResponseDTO(produto);

        return produtoDTO;
    }

    @PutMapping("/{id}")
    public ProdutoResponseDTO atualizar(@PathVariable Long id,@Valid @RequestBody ProdutoDTO produtoDTO){

        Produto produto = new Produto(

                produtoDTO.getNome(),
                produtoDTO.getPreco(),
                produtoDTO.getQuantidade()
        );

        Produto produtoAtualizado = produtoService.atualizar(id, produto);

        ProdutoResponseDTO produtoResponseDTO = new ProdutoResponseDTO(produtoAtualizado);

        return produtoResponseDTO;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> excluir (@PathVariable Long id){

        produtoService.excluir(id);

       return ResponseEntity.noContent().build();
    }
}
