package com.java.gestao_vendas.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO {
    private Long id;
    @NotNull
    @NotEmpty
    private ProdutoDTO produto;
    @PositiveOrZero
    private BigDecimal desconto;
    @NotNull
    @NotEmpty
    private int quantidade;
    @NotNull
    @NotEmpty
    private BigDecimal precoUnitario;
    @NotNull
    @NotEmpty
    private BigDecimal valorTotal;

}
