package com.java.gestao_vendas.categoria.dto;

import com.java.gestao_vendas.empresa.dto.EmpresaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoriaDTO{
    private Long id;
    private String nome;
    private String descricao;
    private EmpresaDTO empresa;
}
