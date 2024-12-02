package com.java.gestao_vendas.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StatusPagamentoDTO {
    private Long id;
    private String nomeStatus;

}
