package com.java.gestao_vendas.domain.DTO;
import lombok.Data;

@Data
public class ProdutoDTO {
    private Long idProduto;
    private String nomeProduto;
    private String descricao;
    private double preco;
    private int quantidadeEstoque;
    private double aliquotaIpi;
    private double aliquotaIcms;
    private String ncmProduto;
    private CategoriaDTO categoria;
    private PessoaDTO pessoa;
    private EmpresaDTO empresa;

    public ProdutoDTO() {}
}
