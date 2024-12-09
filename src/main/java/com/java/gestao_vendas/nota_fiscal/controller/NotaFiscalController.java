package com.java.gestao_vendas.nota_fiscal.controller;

import com.java.gestao_vendas.nota_fiscal.entity.NotaFiscal;
import com.java.gestao_vendas.nota_fiscal.service.NotaFiscalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notafiscal")
public class NotaFiscalController {
    public NotaFiscalService notaFiscalService;

    @Autowired
    public NotaFiscalController(NotaFiscalService notaFiscalService){
        this.notaFiscalService = notaFiscalService;
    }

    @GetMapping
    public ResponseEntity<List<NotaFiscal>> listarNotaFiscals(){
        List<NotaFiscal> notaFiscals = notaFiscalService.listarNotasFiscais();
        return ResponseEntity.ok(notaFiscals);
    }
}
