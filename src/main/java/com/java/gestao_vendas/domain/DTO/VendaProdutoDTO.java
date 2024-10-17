package com.java.gestao_vendas.domain.DTO;

import lombok.Data;

@Data
public class VendaProdutoDTO{
    private Long id;
    private ProdutoDTO produto;
    private VendaDTO venda;
    private int quantidade;
    private double valorTotalProduto;
    private EmpresaDTO empresa;

    public VendaProdutoDTO() {}
}
