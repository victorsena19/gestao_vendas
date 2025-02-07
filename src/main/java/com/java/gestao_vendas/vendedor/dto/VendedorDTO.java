package com.java.gestao_vendas.vendedor.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.java.gestao_vendas.pessoa.dto.PessoaDTO;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VendedorDTO{
    private Long id;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataContratacao;
    @PositiveOrZero
    @NotNull
    private double comissao;
    @NotNull
    private PessoaDTO pessoa;
}

