package com.java.gestao_vendas.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private String nome;
    @NotNull
    private BigDecimal preco;
    @NotNull
    private int quantidadeEstoque;
    private BigDecimal aliquotaIpi;
    private BigDecimal aliquotaIcms;
    private String ncm;
    @NotNull
    private CategoriaDTO categoria;
    @NotNull
    private PessoaDTO fornecedor;

}
