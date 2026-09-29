package com.alonso.api_produtos.repository;

import com.alonso.api_produtos.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Page<Produto> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
    Page<Produto> findByPrecoGreaterThanEqualAndPrecoLessThanEqual(BigDecimal precoMin , BigDecimal precoMax, Pageable pageable);

}
