package com.java.gestao_vendas.domain.DTO;

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

