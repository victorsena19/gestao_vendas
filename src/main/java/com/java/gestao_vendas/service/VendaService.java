package br.com.gestor_vendas.venda;

import br.com.gestor_vendas.produto.Produto;
import br.com.gestor_vendas.venda_produto.VendaProduto;

import java.util.List;
import java.util.Optional;

public class VendaService {

    public void valorTotalVenda(Venda venda) {
     double total = 0;

     for(VendaProduto vp : venda.getVendaProduto()){
         total += vp.getProduto().getPreco() * vp.getQuantidade();
     }
         if(venda.getDesconto() != 0){
            total = total - ((total * venda.getDesconto())/100);
         }
         venda.setValorTotal(total);
    }
}
