package com.java.gestao_vendas.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnderecoDTO{
    private Long id;
    private String logradouro;
    private String bairro;
    private int numero;
    private String cidade;
    private String estado;
    private String cep;

}

