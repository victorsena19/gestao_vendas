package com.java.gestao_vendas.venda_produto.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.java.gestao_vendas.empresa.entity.Empresa;
import com.java.gestao_vendas.produto.entity.Produto;
import com.java.gestao_vendas.venda.entity.Venda;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "itens")
public class Item extends Persistence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Produto produto;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Venda venda;

    private int quantidade;

    private double desconto;

    @Column(name = "valor_total_produto")
    private double precoUnitario;

    @Column(name = "valor_total")
    private double valorTotal;

    @OneToOne(cascade = CascadeType.ALL)
    private Empresa empresa;
}
