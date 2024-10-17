package com.java.gestao_vendas.domain.DTO;

import lombok.Data;

@Data
public class EnderecoDTO{
    private Long id;
    private String logradouro;
    private String bairro;
    private String endereco;
    private String cidade;
    private String estado;
    private String cep;

    public EnderecoDTO() {}

}

