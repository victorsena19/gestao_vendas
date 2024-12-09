package com.java.gestao_vendas.venda.controller;

import com.java.gestao_vendas.venda.dto.VendaDTO;
import com.java.gestao_vendas.venda.entity.Venda;
import com.java.gestao_vendas.venda.service.VendaService;
import com.java.gestao_vendas.utils.Messege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venda")
public class VendaController {
    public VendaService vendaService;

    @Autowired
    public VendaController(VendaService vendaService){
        this.vendaService = vendaService;
    }

    @GetMapping
    public ResponseEntity<List<Venda>> listarVendas(){
        List<Venda> vendas = vendaService.listarVendas();
        return ResponseEntity.ok(vendas);
    }

    @PostMapping
    public ResponseEntity<VendaDTO> criarVenda(VendaDTO vendaDTO){
        VendaDTO novaVenda = vendaService.criarVenda(vendaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaVenda);
    }

    @PutMapping(value = {"{/id}"})
    public ResponseEntity<VendaDTO> atualizaVenda(@PathVariable Long id, @RequestParam VendaDTO vendaDTO){
        VendaDTO vendaAtualizada = vendaService.atualizaVenda(id, vendaDTO);
        return ResponseEntity.ok().body(vendaAtualizada);
    }

    @DeleteMapping(value = {"/{id}"})
    public ResponseEntity<Messege> deleteVenda(@PathVariable Long id){
        Messege vendaExcluida = vendaService.deletarVenda(id);
        return ResponseEntity.ok().body(vendaExcluida);
    }
}
