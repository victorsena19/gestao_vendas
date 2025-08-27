package com.java.gestao_vendas.controller;

import com.java.gestao_vendas.dto.TipoPagamentoDTO;
import com.java.gestao_vendas.model.TipoPagamento;
import com.java.gestao_vendas.service.TipoPagamentoService;
import com.java.gestao_vendas.utils.Messege;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipopagamento")
public class TipoPagamentoController {

    public TipoPagamentoService tipoPagamentoService;

    @Autowired
    public TipoPagamentoController(TipoPagamentoService tipoPagamentoService){
        this.tipoPagamentoService = tipoPagamentoService;
    }

    @GetMapping
    public ResponseEntity<List<TipoPagamento>> listarTipoPagamentos(){
        List<TipoPagamento> tipoPagamentos = tipoPagamentoService.listarTipoPagamentos();
        return ResponseEntity.ok(tipoPagamentos);
    }

    @PostMapping
    public ResponseEntity<TipoPagamentoDTO> criarTipoPagamento(@Valid @RequestBody TipoPagamentoDTO tipoPagamentoDTO){
        TipoPagamentoDTO novaTipoPagamento = tipoPagamentoService.criarTipoPagamento(tipoPagamentoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTipoPagamento);
    }

    @PutMapping(value = {"/{id}"})
    public ResponseEntity<TipoPagamentoDTO> atualizaTipoPagamento(@Valid @PathVariable Long id, @RequestParam TipoPagamentoDTO tipoPagamentoDTO){
        TipoPagamentoDTO tipoPagamentoAtualizada = tipoPagamentoService.atualizaTipoPagamento(id, tipoPagamentoDTO);
        return ResponseEntity.ok().body(tipoPagamentoAtualizada);
    }

    @DeleteMapping(value = {"/{id}"})
    public ResponseEntity<Messege> deleteTipoPagamento(@PathVariable Long id){
        Messege tipoPagamentoExcluida = tipoPagamentoService.deletarTipoPagamento(id);
        return ResponseEntity.ok().body(tipoPagamentoExcluida);
    }
}
