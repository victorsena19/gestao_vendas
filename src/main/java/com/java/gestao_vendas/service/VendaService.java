package com.java.gestao_vendas.service;

import com.java.gestao_vendas.domain.DTO.VendaDTO;

public class VendaService {

    public void valorTotalVenda(VendaDTO venda) {
     double total = 0;
/*
     for(VendaProduto vp : venda.getVendaProduto()){
         total += vp.getProduto().getPreco() * vp.getQuantidade();
     }
         if(venda.getDesconto() != 0){
            total = total - ((total * venda.getDesconto())/100);
         }
         venda.setValorTotal(total);
 */
    }



}
