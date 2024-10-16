package br.com.gestor_vendas.venda_produto;

import br.com.gestor_vendas.produto.Produto;
import br.com.gestor_vendas.venda.Venda;

import java.util.List;

public class VendaProdutoService {
    public static void valorPorProduto(VendaProduto vp) {
        double valorUnitario = 0;
        valorUnitario = vp.getProduto().getPreco() * vp.getQuantidade();
         vp.setValorTotalProduto(valorUnitario);
    }
}


