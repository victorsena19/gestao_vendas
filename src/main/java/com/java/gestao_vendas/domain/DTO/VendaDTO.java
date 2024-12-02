package com.java.gestao_vendas.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
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

}

