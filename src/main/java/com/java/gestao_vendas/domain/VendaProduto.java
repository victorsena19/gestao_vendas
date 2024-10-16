package com.java.gestao_vendas.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "vendas_produtos")
public class VendaProduto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Produto produto;

    @ManyToOne(cascade = CascadeType.ALL)
    private Venda venda;

    private int quantidade;

    @Column(name = "valor_total_produto")
    private double valorTotalProduto;

    @OneToOne(cascade = CascadeType.ALL)
    private Empresa empresa;

    public VendaProduto() {}
}
