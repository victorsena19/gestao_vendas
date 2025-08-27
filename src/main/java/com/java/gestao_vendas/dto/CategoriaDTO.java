package com.java.gestao_vendas.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoriaDTO{
    private Long id;
    @NotNull
    @NotEmpty
    @Size(min = 3)
    @Size(max = 60)
    private String nome;
    @NotNull
    @NotEmpty
    @Size(min = 3)
    @Size(max = 500)
    private String descricao;
}
