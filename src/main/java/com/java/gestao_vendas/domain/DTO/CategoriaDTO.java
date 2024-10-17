package com.java.gestao_vendas.domain.DTO;

import lombok.Data;


@Data
public class CategoriaDTO{
    private Long id;
    private String nome;
    private String descricao;
    private EmpresaDTO empresa;

    public CategoriaDTO() {}
}
