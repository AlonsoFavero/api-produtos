package com.alonso.api_produtos.service;

import com.alonso.api_produtos.exception.ProdutoNotFoundException;
import com.alonso.api_produtos.model.Produto;
import com.alonso.api_produtos.repository.ProdutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProdutoService {

    ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){

        this.produtoRepository = produtoRepository;
    }

    public Produto salvar(Produto produto){

        return produtoRepository.save(produto);
    }

    public Page<Produto> listar(String nome , Pageable pageable) {
        return produtoRepository.findByNomeContainingIgnoreCase( nome,pageable);
    }

    public Produto buscarPorId(Long id){

        return produtoRepository.findById(id).orElseThrow(() -> new ProdutoNotFoundException("produto não encontrado"));
    }

    public Produto atualizar(Long id, Produto produto){

        Produto produtoExistente = produtoRepository.findById(id).orElseThrow(() -> new ProdutoNotFoundException("produto não encontrado"));

        produtoExistente.setNome(produto.getNome());
        produtoExistente.setPreco(produto.getPreco());
        produtoExistente.setQuantidade(produto.getQuantidade());

        return produtoRepository.save(produtoExistente);
    }

    public void excluir(Long id){

        Produto produtoExcluido = produtoRepository.findById(id).orElseThrow(() -> new ProdutoNotFoundException("produto não encontrado"));

         produtoRepository.delete(produtoExcluido);
    }

    public Page<Produto> filtroDePreco(BigDecimal precoMin, BigDecimal precoMax, Pageable pageable){

        return produtoRepository.findByPrecoGreaterThanEqualAndPrecoLessThanEqual(precoMin,precoMax,pageable);
    }
}
