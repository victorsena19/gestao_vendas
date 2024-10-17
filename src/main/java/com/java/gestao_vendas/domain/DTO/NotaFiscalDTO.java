package com.java.gestao_vendas.domain.DTO;
import lombok.Data;
import java.time.LocalDateTime;

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

    public NotaFiscalDTO() {}
}
