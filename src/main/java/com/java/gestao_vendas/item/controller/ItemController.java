package com.java.gestao_vendas.venda_produto.controller;

import com.java.gestao_vendas.venda.dto.VendaDTO;
import com.java.gestao_vendas.venda_produto.dto.VendaProdutoDTO;
import com.java.gestao_vendas.venda_produto.entity.VendaProduto;
import com.java.gestao_vendas.venda_produto.service.VendaProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<VendaProdutoDTO> createVendaProduto(@RequestBody VendaProdutoDTO vendaProdutoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(vendaProdutoService.criarVendaProduto(vendaProdutoDTO));
    }
}
