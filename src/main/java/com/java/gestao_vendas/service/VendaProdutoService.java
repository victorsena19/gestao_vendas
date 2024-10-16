package com.java.gestao_vendas.service;

import com.java.gestao_vendas.domain.VendaProduto;

public class VendaProdutoService {
    public static void valorPorProduto(VendaProduto vp) {
        double valorUnitario = 0;
        valorUnitario = vp.getProduto().getPreco() * vp.getQuantidade();
        vp.setValorTotalProduto(valorUnitario);
    }
}


