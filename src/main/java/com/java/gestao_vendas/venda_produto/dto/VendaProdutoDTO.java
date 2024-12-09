package com.java.gestao_vendas.venda_produto.dto;

import com.java.gestao_vendas.empresa.dto.EmpresaDTO;
import com.java.gestao_vendas.produto.dto.ProdutoDTO;
import com.java.gestao_vendas.venda.dto.VendaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VendaProdutoDTO{
    private Long id;
    private ProdutoDTO produto;
    private VendaDTO venda;
    private int quantidade;
    private double valorTotalProduto;
    private EmpresaDTO empresa;

}
