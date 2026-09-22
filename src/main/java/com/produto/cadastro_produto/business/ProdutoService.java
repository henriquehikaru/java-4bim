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

    public Produto buscarProdutoPorId(Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Produto não encontrado")
        );
    }

    public void deletarProdutoPorId(Integer id) {
        repository.deleteById(id);
    }

}
