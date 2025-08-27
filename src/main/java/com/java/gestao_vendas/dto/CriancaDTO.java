package com.java.gestao_vendas.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CriancaDTO{
    private Long id;
    @NotNull
    @NotEmpty
    private String nome;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    @NotNull
    @NotEmpty
    private String sexo;
    @NotNull
    @NotEmpty
    private String nomeMae;
    private String nomePai;
    private String telefoneMae;
    private String telefonePai;
    @NotNull
    private PessoaDTO pessoa;
}
