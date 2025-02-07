package com.java.gestao_vendas.cupom_fiscal.dto;


import com.java.gestao_vendas.empresa.dto.EmpresaDTO;
import com.java.gestao_vendas.venda.dto.VendaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CupomFiscalDTO {
    private Long id;
    private String numeroCupom;
    private String chaveAcesso;
    private LocalDateTime dataEmissao;
    private String serie;
    private String protocolo;
    private String observacao;
    private VendaDTO venda;
    private EmpresaDTO empresa;
}
