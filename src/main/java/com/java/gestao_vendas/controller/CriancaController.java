package com.java.gestao_vendas.controller;

import com.java.gestao_vendas.domain.DTO.CriancaDTO;
import com.java.gestao_vendas.domain.entity.Crianca;
import com.java.gestao_vendas.service.CriancaService;
import com.java.gestao_vendas.utils.Messege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crianca")
public class CriancaController {
    public CriancaService criancaService;

    @Autowired
    public CriancaController(CriancaService criancaService){
        this.criancaService = criancaService;
    }

    @GetMapping
    public ResponseEntity<List<Crianca>> listarCriancas(){
        List<Crianca> criancas = criancaService.listarCriancas();
        return ResponseEntity.ok(criancas);
    }

    @PostMapping
    public ResponseEntity<CriancaDTO> criarCrianca(CriancaDTO criancaDTO){
        CriancaDTO novaCrianca = criancaService.criarCrianca(criancaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaCrianca);
    }

    @PutMapping(value = {"{/id}"})
    public ResponseEntity<CriancaDTO> atualizaCrianca(@PathVariable Long id, @RequestParam CriancaDTO criancaDTO){
        CriancaDTO criancaAtualizada = criancaService.atualizaCrianca(id, criancaDTO);
        return ResponseEntity.ok().body(criancaAtualizada);
    }

    @DeleteMapping(value = {"/{id}"})
    public ResponseEntity<Messege> deleteCrianca(@PathVariable Long id){
        Messege criancaExcluida = criancaService.deletarCrianca(id);
        return ResponseEntity.ok().body(criancaExcluida);
    }
}
