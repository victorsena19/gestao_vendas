package com.java.gestao_vendas.domain.DTO;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class VendedorDTO{
    private Long id;
    private LocalDateTime dataContratacao;
    private double comissao;
    private PessoaDTO pessoa;
    private EmpresaDTO empresa;

    public VendedorDTO() {
    }
}

