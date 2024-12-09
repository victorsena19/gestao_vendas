package com.java.gestao_vendas.cupom_fiscal.controller;

import com.java.gestao_vendas.cupom_fiscal.entity.CupomFiscal;
import com.java.gestao_vendas.cupom_fiscal.service.CupomFiscalService;
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
