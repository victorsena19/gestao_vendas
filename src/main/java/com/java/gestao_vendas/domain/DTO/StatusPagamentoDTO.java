package com.java.gestao_vendas.domain.DTO;

import lombok.Data;

@Data
public class StatusPagamentoDTO {
    private Long id;
    private String nomeStatus;

    public StatusPagamentoDTO() {}
}
