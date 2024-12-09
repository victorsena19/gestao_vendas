package com.java.gestao_vendas.pedido.dto;

import com.java.gestao_vendas.pessoa.dto.PessoaDTO;
import com.java.gestao_vendas.status_pagamento.dto.StatusPagamentoDTO;
import com.java.gestao_vendas.tipo_pagamento.dto.TipoPagamentoDTO;
import com.java.gestao_vendas.vendedor.dto.VendedorDTO;
import com.java.gestao_vendas.empresa.dto.EmpresaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoDTO{
    private Long idPedido;
    private String produto;
    private int quantidade;
    private PessoaDTO pessoa;
    private VendedorDTO vendedor;
    private StatusPagamentoDTO statusPagamento;
    private TipoPagamentoDTO tipoPagamento;
    private LocalDateTime dataPedido;
    private EmpresaDTO empresa;
}
