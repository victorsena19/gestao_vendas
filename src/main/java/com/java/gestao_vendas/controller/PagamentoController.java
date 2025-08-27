package com.java.gestao_vendas.controller;

import com.java.gestao_vendas.dto.PagamentoDTO;
import com.java.gestao_vendas.model.Pagamento;
import com.java.gestao_vendas.service.PagamentoService;
import com.java.gestao_vendas.utils.Messege;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    public PagamentoService pagamentoService;

    @Autowired
    public PagamentoController(PagamentoService pagamentoService){
        this.pagamentoService = pagamentoService;
    }

    @GetMapping
    public ResponseEntity<List<Pagamento>> listarPagamentos(){
        List<Pagamento> pagamentos = pagamentoService.listarPagamentos();
        return ResponseEntity.ok(pagamentos);
    }

    @PostMapping
    public ResponseEntity<PagamentoDTO> criarPagamento(@Valid @RequestBody PagamentoDTO pagamentoDTO){
        PagamentoDTO novaPagamento = pagamentoService.criarPagamento(pagamentoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaPagamento);
    }

    @PutMapping(value = {"/{id}"})
    public ResponseEntity<PagamentoDTO> atualizaPagamento(@Valid @PathVariable Long id, @RequestParam PagamentoDTO pagamentoDTO){
        PagamentoDTO pagamentoAtualizada = pagamentoService.atualizaPagamento(id, pagamentoDTO);
        return ResponseEntity.ok().body(pagamentoAtualizada);
    }

    @DeleteMapping(value = {"/{id}"})
    public ResponseEntity<Messege> deletePagamento(@PathVariable Long id){
        Messege pagamentoExcluida = pagamentoService.deletarPagamento(id);
        return ResponseEntity.ok().body(pagamentoExcluida);
    }
}
