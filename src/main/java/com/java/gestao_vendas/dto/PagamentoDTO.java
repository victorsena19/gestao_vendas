package com.java.gestao_vendas.dto;

import com.java.gestao_vendas.model.TipoPagamento;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PagamentoDTO {
    private Long id;
    private TipoPagamento tipoPagamento;
    @NotNull
    private int parcelamento;
    @NotNull
    private BigDecimal valorPago;
}
