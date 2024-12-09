package com.java.gestao_vendas.venda_produto.controller;

import com.java.gestao_vendas.venda_produto.entity.VendaProduto;
import com.java.gestao_vendas.venda_produto.service.VendaProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vendaproduto")
public class VendaProdutoController {
    public VendaProdutoService vendaProdutoService;

    @Autowired
    public VendaProdutoController(VendaProdutoService vendaProdutoService){
        this.vendaProdutoService = vendaProdutoService;
    }

    @GetMapping
    public ResponseEntity<List<VendaProduto>> listarVendaProdutos(){
        List<VendaProduto> vendaProdutos = vendaProdutoService.listarVendaProdutos();
        return ResponseEntity.ok(vendaProdutos);
    }
}
