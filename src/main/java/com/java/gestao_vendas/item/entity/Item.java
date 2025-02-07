package com.java.gestao_vendas.item.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.java.gestao_vendas.empresa.entity.Empresa;
import com.java.gestao_vendas.produto.entity.Produto;
import com.java.gestao_vendas.venda.entity.Venda;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "itens")
public class Item extends Persistence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id")
    private Produto produto;


    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "venda_id")
    @JsonBackReference
    private Venda venda;

    private int quantidade;

    private BigDecimal desconto;

    @Column(name = "valor_total_produto")
    private BigDecimal precoUnitario;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @OneToOne(cascade = CascadeType.ALL)
    private Empresa empresa;
}
