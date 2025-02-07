package com.java.gestao_vendas.pedido.dto;

import com.java.gestao_vendas.pagamento.dto.PagamentoDTO;
import com.java.gestao_vendas.pessoa.dto.PessoaDTO;
import com.java.gestao_vendas.vendedor.dto.VendedorDTO;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoDTO{
    private Long id;
    @NotEmpty
    @NotNull
    private String produto;
    @NotNull
    private int quantidade;
    @NotNull
    private PessoaDTO pessoa;
    @NotNull
    private VendedorDTO vendedor;
    private PagamentoDTO pagamento;
    private LocalDateTime dataPedido;
}
