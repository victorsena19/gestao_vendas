package com.java.gestao_vendas.venda;

import com.java.gestao_vendas.entity.Produto;
import com.java.gestao_vendas.entity.Venda;
import com.java.gestao_vendas.venda.service.VendaService;
import com.java.gestao_vendas.entity.VendaProduto;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendaServiceTest {
    @Test
    public void testValorTotalSemDesconto() {
        Venda venda = new Venda();

        Produto p1 = new Produto();
        p1.setNomeProduto("mustang");
        p1.setPreco(2590);

        Produto p2 = new Produto();
        p2.setNomeProduto("fusca");
        p2.setPreco(3290);

        VendaProduto vp1 = new VendaProduto();
        VendaProduto vp2 = new VendaProduto();

        vp1.setProduto(p1);
        vp1.setQuantidade(5);
        vp1.setVenda(venda);

        vp2.setProduto(p2);
        vp2.setQuantidade(3);
        vp2.setVenda(venda);

        List<VendaProduto> vp = new ArrayList<>();
        vp.add(vp1);
        vp.add(vp2);

        venda.setVendaProduto(vp);

        VendaService service = new VendaService();

        //service.valorTotalVenda(vendaEntity);

        double esperado = p1.getPreco()* vp1.getQuantidade()+p2.getPreco()* vp2.getQuantidade();

        System.out.println(esperado);
        assertEquals(esperado, venda.getValorTotal(), 0.01);

    }

    @Test
    public void valorTotalVendaComDescontoTest(){
        Produto produto = new Produto();
        produto.setNomeProduto("mustang");
        produto.setPreco(2590);

        VendaProduto vp1 = new VendaProduto();
        vp1.setProduto(produto);
        vp1.setQuantidade(5);

        //vp.add(vp1);

        Venda v = new Venda();
        //v.setVendaProduto(vp);
        v.setDesconto(15);


        VendaService service = new VendaService();

        //service.valorTotalVenda(v);

        double valorTotalSemDesconto = produto.getPreco()*vp1.getQuantidade();
        double valorTotalComDesconto = valorTotalSemDesconto - (valorTotalSemDesconto*v.getDesconto()/100);

        assertEquals(valorTotalComDesconto, v.getValorTotal(), 0.01);
    }
}
