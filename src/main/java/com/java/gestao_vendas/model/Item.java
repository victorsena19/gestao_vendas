package com.java.gestao_vendas.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @Column(name = "preco_unitario")
    private BigDecimal precoUnitario;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

}
