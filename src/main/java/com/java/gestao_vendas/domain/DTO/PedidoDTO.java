package com.java.gestao_vendas.domain.DTO;

import com.java.gestao_vendas.enuns.Status;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PedidoDTO{
    private Long idPedido;
    private String produto;
    private int quantidade;
    private PessoaDTO pessoa;
    private VendedorDTO vendedor;
    private Status statusPagamento;
    private LocalDateTime dataPedido;
    private EmpresaDTO empresa;

    public PedidoDTO() {}
}
