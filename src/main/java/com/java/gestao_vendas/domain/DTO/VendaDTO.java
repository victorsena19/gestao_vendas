package com.java.gestao_vendas.domain.DTO;

import com.java.gestao_vendas.enuns.Status;
import com.java.gestao_vendas.domain.entity.TipoPagamento;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class VendaDTO{
    private Long id;
    private String tipoDocumento;
    private String numeroDocumento;
    private String chaveAcesso;
    private Status status;
    private LocalDateTime dataVenda;
    private double desconto;
    private double totalVenda;
    private TipoPagamento tipoPagamento;
    private PessoaDTO pessoa;
    private VendedorDTO vendedor;
    private List<VendaProdutoDTO> vendaProduto;
    private EmpresaDTO empresa;

    public VendaDTO() {
    }
}

