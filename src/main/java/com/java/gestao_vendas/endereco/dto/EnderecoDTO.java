package com.java.gestao_vendas.endereco.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnderecoDTO{
    private Long id;
    @NotNull
    @NotEmpty
    @Size(max = 100)
    private String logradouro;
    @NotNull
    @NotEmpty
    @Size(max = 50)
    private String bairro;
    @NotNull
    @PositiveOrZero
    private int numero;
    @NotNull
    @NotEmpty
    @Size(max = 50)
    private String cidade;
    @NotNull
    @NotEmpty
    @Size(max = 2)
    private String estado;
    @NotNull
    @NotEmpty
    private String cep;

}

