package com.java.gestao_vendas.domain.DTO;
import lombok.Data;
import jakarta.validation.constraints.*;
@Data
public class ProdutoDTO {
    private Long idProduto;

    @NotEmpty
    @Max(100)
    private String nomeProduto;
    @Max(200)
    private String descricao;

    @NotEmpty
    private double preco;

    private int quantidadeEstoque;
    @NotEmpty
    private double aliquotaIpi;
    @NotEmpty
    private double aliquotaIcms;
    @NotEmpty
    private String ncmProduto;
    @NotNull
    private CategoriaDTO categoria;
    @NotNull
    private PessoaDTO pessoa;
    @NotNull
    private EmpresaDTO empresa;

    public ProdutoDTO() {}
}
