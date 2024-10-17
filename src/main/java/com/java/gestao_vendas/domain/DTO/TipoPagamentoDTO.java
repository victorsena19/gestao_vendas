package com.java.gestao_vendas.domain.DTO;

import lombok.Data;

@Data
public class TipoPagamentoDTO{
    private Long id;
    private String nomePagamento;

    public TipoPagamentoDTO() {}
}
