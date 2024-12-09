package com.java.gestao_vendas.produto.controller;

import com.java.gestao_vendas.produto.dto.ProdutoDTO;
import com.java.gestao_vendas.produto.entity.Produto;
import com.java.gestao_vendas.produto.service.ProdutoService;
import com.java.gestao_vendas.utils.Messege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    public ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos(){
        List<Produto> produtos = produtoService.listarProdutos();
        return ResponseEntity.ok(produtos);
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> criarProduto(ProdutoDTO produtoDTO){
        ProdutoDTO novaProduto = produtoService.criarProduto(produtoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaProduto);
    }

    @PutMapping(value = {"{/id}"})
    public ResponseEntity<ProdutoDTO> atualizaProduto(@PathVariable Long id, @RequestParam ProdutoDTO produtoDTO){
        ProdutoDTO produtoAtualizada = produtoService.atualizaProduto(id, produtoDTO);
        return ResponseEntity.ok().body(produtoAtualizada);
    }

    @DeleteMapping(value = {"/{id}"})
    public ResponseEntity<Messege> deleteProduto(@PathVariable Long id){
        Messege produtoExcluida = produtoService.deletarProduto(id);
        return ResponseEntity.ok().body(produtoExcluida);
    }
}
