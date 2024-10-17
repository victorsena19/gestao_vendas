package com.java.gestao_vendas.service;

import com.java.gestao_vendas.domain.DTO.VendaProdutoDTO;

public class VendaProdutoService {
    public static void valorPorProduto(VendaProdutoDTO vp) {
        double valorUnitario = 0;
        valorUnitario = vp.getProduto().getPreco() * vp.getQuantidade();
        vp.setValorTotalProduto(valorUnitario);
    }
}


