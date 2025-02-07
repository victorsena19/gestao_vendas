package com.java.gestao_vendas.venda_produto.dto;

import com.java.gestao_vendas.empresa.dto.EmpresaDTO;
import com.java.gestao_vendas.produto.dto.ProdutoDTO;
import com.java.gestao_vendas.venda.dto.VendaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO{
    private UUID id;
    private VendaDTO venda;
    private ProdutoDTO produto;
    private double desconto;
    private int quantidade;
    private double precoUnitario;
    private double valorTotal;
    private EmpresaDTO empresa;

}
