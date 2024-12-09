package com.java.gestao_vendas.controller;

import com.java.gestao_vendas.domain.entity.VendaProduto;
import com.java.gestao_vendas.service.VendaProdutoService;
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
