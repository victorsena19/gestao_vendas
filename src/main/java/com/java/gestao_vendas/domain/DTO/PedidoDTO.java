package com.java.gestao_vendas.domain.DTO;

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
