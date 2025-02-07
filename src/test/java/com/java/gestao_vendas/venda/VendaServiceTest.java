package com.java.gestao_vendas.venda;


import com.java.gestao_vendas.item.dto.ItemDTO;

import static org.junit.Assert.assertEquals;

public class VendaServiceTest {



/*
    @Test
    public void testValorTotalSemDesconto() {
        VendaDTO vendaDTO = new VendaDTO();

        ProdutoDTO p1 = new ProdutoDTO();
        p1.setNomeProduto("mustang");
        p1.setPreco(2590);

        ProdutoDTO p2 = new ProdutoDTO();
        p2.setNomeProduto("fusca");
        p2.setPreco(3290);

        VendaProdutoDTO vp1 = new VendaProdutoDTO();
        VendaProdutoDTO vp2 = new VendaProdutoDTO();

        vp1.setProduto(p1);
        vp1.setQuantidade(5);
        vp1.setVenda(vendaDTO);

        vp2.setProduto(p2);
        vp2.setQuantidade(3);
        vp2.setVenda(vendaDTO);

        List<VendaProdutoDTO> vp = new ArrayList<>();
        vp.add(vp1);
        vp.add(vp2);

        vendaDTO.setVendaProduto(vp);

        VendaService service = new VendaService();

        service.valorTotalVenda(vendaDTO);

        double esperado = p1.getPreco()* vp1.getQuantidade()+p2.getPreco()* vp2.getQuantidade();

        System.out.println(esperado);
        assertEquals(esperado, vendaDTO.getTotalVenda(), 0.01);

    }

    @Test
    public void valorTotalVendaComDescontoTest(){
        ProdutoDTO produto = new ProdutoDTO();
        produto.setNomeProduto("mustang");
        produto.setPreco(2590);

        VendaProdutoDTO vp1 = new VendaProdutoDTO();
        vp1.setProduto(produto);
        vp1.setQuantidade(5);

        List<VendaProdutoDTO> vp = new ArrayList<>();

        vp.add(vp1);

        VendaDTO v = new VendaDTO();
        v.setVendaProduto(vp);
        v.setDesconto(15);

        VendaService vendaService = new VendaService();

        vendaService.valorTotalVenda(v);

        double valorTotalSemDesconto = produto.getPreco()*vp1.getQuantidade();
        double valorTotalComDesconto = valorTotalSemDesconto - (valorTotalSemDesconto*v.getDesconto()/100);

        System.out.println(valorTotalSemDesconto);
        System.out.println(valorTotalComDesconto);
        assertEquals(valorTotalComDesconto, v.getTotalVenda(), 0.01);
    }
    */
}
