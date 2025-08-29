package com.java.gestao_vendas.dto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TipoPagamentoDTO{
    private Long id;
    @NotNull
    @NotEmpty
    private String nome;
}
