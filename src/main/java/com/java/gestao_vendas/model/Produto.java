package com.java.gestao_vendas.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "produtos")
public class Produto extends Persistence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @Column(name = "preco_produto")
    private BigDecimal preco;

    @Column(name = "quantidade_estoque")
    private int quantidadeEstoque;

    @Column(name = "aliquota_ipi")
    private BigDecimal aliquotaIpi;

    @Column(name = "aliquota_icms")
    private BigDecimal aliquotaIcms;

    private String ncm;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "categoria_id")
    @JsonManagedReference
    private Categoria categoria;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Pessoa fornecedor;

}
