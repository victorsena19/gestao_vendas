package venda_produto;

import br.com.gestor_vendas.produto.Produto;
import br.com.gestor_vendas.venda_produto.VendaProduto;
import br.com.gestor_vendas.venda_produto.VendaProdutoService;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VendaProdutoServiceTest {
    @Test
    public void testValorUnitario(){
        Produto produto = new Produto();
        produto.setNomeProduto("mustang");
        produto.setPreco(2590);

        VendaProduto vp1 = new VendaProduto();
        vp1.setProduto(produto);
        vp1.setQuantidade(5);

        VendaProdutoService.valorPorProduto(vp1);

        double esperado = produto.getPreco()*vp1.getQuantidade();
        assertEquals(esperado, vp1.getValorTotalProduto(), 0.01);

        System.out.println(vp1.getValorTotalProduto());
    }

}
