package com.java.gestao_vendas.tipo_pagamento.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TipoPagamentoDTO{
    private Long id;
    private String nomePagamento;
}
