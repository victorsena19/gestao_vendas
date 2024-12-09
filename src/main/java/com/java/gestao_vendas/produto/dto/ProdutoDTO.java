package com.java.gestao_vendas.produto.dto;
import com.java.gestao_vendas.categoria.dto.CategoriaDTO;
import com.java.gestao_vendas.empresa.dto.EmpresaDTO;
import com.java.gestao_vendas.pessoa.dto.PessoaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.validation.constraints.*;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
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

}
