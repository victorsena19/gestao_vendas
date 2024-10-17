package com.java.gestao_vendas.domain.entity;

import com.java.gestao_vendas.enuns.Status;
import com.java.gestao_vendas.enuns.TipoPagamento;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "vendas")
public class Venda implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venda")
    private Long id;

    @Column(name = "tipo_documento")
    private String tipoDocumento;

    @Column(name = "numero_documento")
    private String numeroDocumento;

    @Column(name = "chave_acesso")
    private String chaveAcesso;

    private Status status;

    @Column(name = "data_venda")
    private LocalDateTime dataVenda;

    private double desconto;

    @Column(name = "total_venda")
    private double totalVenda;

    @Column(name = "tipo_pagamento")
    private TipoPagamento tipoPagamento;

    @OneToOne(cascade = CascadeType.ALL)
    private Pessoa pessoa;

    @OneToOne(cascade = CascadeType.ALL)
    private Vendedor vendedor;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "venda_produto_id")
    private List<VendaProduto> vendaProduto;

    @OneToOne(cascade = CascadeType.ALL)
    private Empresa empresa;

    public Venda() {
    }
}

