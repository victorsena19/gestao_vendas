package com.java.gestao_vendas.domain.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long idPedido;

    private String produto;

    private int quantidade;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Pessoa pessoa;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Vendedor vendedor;

    @JoinColumn(name = "status_pagamento_id")
    @OneToOne(cascade = CascadeType.ALL)
    private StatusPagamento statusPagamento;

    @JoinColumn(name = "tipo_pagamento_id")
    @OneToOne(cascade = CascadeType.ALL)
    private TipoPagamento tipoPagamento;

    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Empresa empresa;

    public Pedido() {}
}
