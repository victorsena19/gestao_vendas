package com.java.gestao_vendas.venda.dto;

import com.java.gestao_vendas.venda_produto.dto.VendaProdutoDTO;
import com.java.gestao_vendas.vendedor.dto.VendedorDTO;
import com.java.gestao_vendas.empresa.dto.EmpresaDTO;
import com.java.gestao_vendas.pessoa.dto.PessoaDTO;
import com.java.gestao_vendas.status_pagamento.dto.StatusPagamentoDTO;
import com.java.gestao_vendas.tipo_pagamento.dto.TipoPagamentoDTO;
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

