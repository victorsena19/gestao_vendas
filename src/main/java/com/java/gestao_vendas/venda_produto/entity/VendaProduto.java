package com.java.gestao_vendas.venda_produto.entity;

import com.java.gestao_vendas.empresa.entity.Empresa;
import com.java.gestao_vendas.produto.entity.Produto;
import com.java.gestao_vendas.venda.entity.Venda;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
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
}
