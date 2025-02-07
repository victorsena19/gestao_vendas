package com.java.gestao_vendas.tipo_pagamento.dto;

import com.java.gestao_vendas.venda.dto.VendaDTO;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TipoPagamentoDTO{
    private Long id;
    @NotNull
    @NotEmpty
    private String nomePagamento;
    List<VendaDTO> venda;
}
