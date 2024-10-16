package com.java.gestao_vendas.venda;

import com.java.gestao_vendas.domain.Produto;
import com.java.gestao_vendas.domain.Venda;
import com.java.gestao_vendas.domain.VendaProduto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class VendaTest {
    @Test
    public void testVenda(){

        Venda venda = new Venda();
        Produto p1 = new Produto();
        p1.setNomeProduto("mustang");
        p1.setPreco(2590);

        Produto p2 = new Produto();
        p2.setNomeProduto("fusca");
        p2.setPreco(3290);

        VendaProduto vp1 = new VendaProduto();
        vp1.setProduto(p1);
        vp1.setQuantidade(5);

        VendaProduto vp2 = new VendaProduto();
        vp2.setProduto(p2);
        vp2.setQuantidade(10);

        List<VendaProduto> vp = new ArrayList<>();

        vp.add(vp1);
        vp.add(vp2);


        venda.setVendaProduto(vp);

        System.out.println(venda.getVendaProduto());
    }
}
