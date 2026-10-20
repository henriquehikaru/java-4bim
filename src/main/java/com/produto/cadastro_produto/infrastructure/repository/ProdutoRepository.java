package com.produto.cadastro_produto.infrastructure.repository;

import com.produto.cadastro_produto.infrastructure.entitys.Produto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    Optional<Produto> findByDescricao(String descricao);

    @Transactional
    void deleteByDescricao(String descricao);
}
