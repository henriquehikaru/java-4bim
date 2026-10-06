package com.produto.cadastro_produto.controller;

import com.produto.cadastro_produto.business.ProdutoService;
import com.produto.cadastro_produto.infrastructure.entitys.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @DeleteMapping
    public ResponseEntity<Void> deletarPorId(@RequestParam Integer id){
        produtoService.deletarProdutoPorId(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> salvarProdutoPorId(@RequestBody Produto produto){
        produtoService.salvarProduto(produto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Produto> buscarProdutoPorId(@RequestParam Integer id){
        return ResponseEntity.ok(produtoService.buscarProdutoPorId(id));
    }

    @PutMapping
    public ResponseEntity<Void> atualizarProdutoPorId(@RequestBody Produto produto, @RequestParam Integer id) {
        produtoService.atualizarProdutoPorId(id, produto);
        return ResponseEntity.ok().build();
    }
}
