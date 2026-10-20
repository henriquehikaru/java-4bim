package com.produto.cadastro_produto.business;

import com.produto.cadastro_produto.infrastructure.entitys.Produto;
import com.produto.cadastro_produto.infrastructure.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public void salvarProduto(Produto produto) {
        repository.saveAndFlush(produto);
    }

    public Produto buscarProdutoPorDescricao(String descricao) {
        return repository.findByDescricao(descricao).orElseThrow(
                () -> new RuntimeException("Produto não encontrado")
        );
    }

    public void deletarProdutoPorDescricao(String descricao) {
        repository.deleteByDescricao(descricao);
    }

    public void atualizarProdutoPorId(Integer id, Produto produto) {
        Produto produtoEntity = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Produto não encontrado"));
        Produto produtoAtualizado = Produto.builder()
                .id(id)
                .descricao(produto.getDescricao() != null ? produto.getDescricao() : produtoEntity.getDescricao())
                .categoria(produto.getCategoria() != null ? produto.getCategoria() : produtoEntity.getCategoria())
                .preco(produto.getPreco() != null ? produto.getPreco() : produtoEntity.getPreco())
                .build();

        repository.saveAndFlush(produtoAtualizado);
    }

}
