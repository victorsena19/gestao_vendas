package com.java.gestao_vendas.domain.DTO;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class VendaDTO{
    private Long id;
    private String tipoDocumento;
    private String numeroDocumento;
    private String chaveAcesso;
    private StatusPagamentoDTO status;
    private LocalDateTime dataVenda;
    private double desconto;
    private double totalVenda;
    private TipoPagamentoDTO tipoPagamento;
    private PessoaDTO pessoa;
    private VendedorDTO vendedor;
    private List<VendaProdutoDTO> vendaProduto;
    private EmpresaDTO empresa;

    public VendaDTO() {
    }
}

