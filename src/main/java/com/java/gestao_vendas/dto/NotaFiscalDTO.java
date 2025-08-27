package com.java.gestao_vendas.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotaFiscalDTO{
    private Long idNotaFiscal;
    private String numeroNota;
    private String chaveAcesso;
    private String serie;
    private LocalDateTime dataEmissao;
    private String naturezaOperacao;
    private String protocolo;
    private String observacao;
    private VendaDTO venda;
    private EmpresaDTO empresa;

}
