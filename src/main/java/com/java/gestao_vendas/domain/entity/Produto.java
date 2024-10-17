package com.java.gestao_vendas.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "produtos")
public class Produto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long idProduto;

    @Column(name = "nome_produto")
    private String nomeProduto;

    @Column(name = "descricao_produto")
    private String descricao;

    @Column(name = "preco_produto")
    private double preco;

    @Column(name = "quantidade_estoque")
    private int quantidadeEstoque;

    @Column(name = "aliquota_ipi")
    private double aliquotaIpi;

    @Column(name = "aliquota_icms")
    private double aliquotaIcms;

    @Column(name = "ncm_produto")
    private String ncmProduto;

    @OneToOne(cascade = CascadeType.ALL)
    private Categoria categoria;

    @OneToOne(cascade = CascadeType.ALL)
    private Pessoa pessoa;

    @OneToOne(cascade = CascadeType.ALL)
    private Empresa empresa;

    public Produto() {}
}
