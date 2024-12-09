package com.java.gestao_vendas.vendedor.dto;

import com.java.gestao_vendas.empresa.dto.EmpresaDTO;
import com.java.gestao_vendas.pessoa.dto.PessoaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VendedorDTO{
    private Long id;
    private LocalDateTime dataContratacao;
    private double comissao;
    private PessoaDTO pessoa;
    private EmpresaDTO empresa;
}

