package com.java.gestao_vendas.domain.DTO;


import lombok.Data;

import java.time.LocalDateTime;

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

    public CupomFiscalDTO() {
    }
}
