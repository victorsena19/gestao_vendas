package com.java.gestao_vendas.produto.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.java.gestao_vendas.categoria.dto.CategoriaDTO;
import com.java.gestao_vendas.pessoa.dto.PessoaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.validation.constraints.*;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProdutoDTO {
    private Long id;
    @NotEmpty
    @NotNull
    @Size(max = 100)
    private String nomeProduto;
    @Size(max = 200)
    private String descricao;
    @NotNull
    private BigDecimal preco;
    @NotNull
    private int quantidadeEstoque;
    private BigDecimal aliquotaIpi;
    private BigDecimal aliquotaIcms;
    private String ncmProduto;
    @NotNull
    private CategoriaDTO categoria;
    @NotNull
    private PessoaDTO pessoa;

}
