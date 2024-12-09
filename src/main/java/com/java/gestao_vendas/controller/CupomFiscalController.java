package com.java.gestao_vendas.controller;

import com.java.gestao_vendas.domain.entity.CupomFiscal;
import com.java.gestao_vendas.service.CupomFiscalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cupom fiscal")
public class CupomFiscalController {

    public CupomFiscalService cupomFiscalService;

    @Autowired
    public CupomFiscalController(CupomFiscalService cupomFiscalService){
        this.cupomFiscalService = cupomFiscalService;
    }

    @GetMapping
    public ResponseEntity<List<CupomFiscal>> listarCupomFiscals(){
        List<CupomFiscal> cupomFiscals = cupomFiscalService.listarCuponsFiscais();
        return ResponseEntity.ok(cupomFiscals);
    }
}
