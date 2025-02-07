package com.java.gestao_vendas.pagamento.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.java.gestao_vendas.tipo_pagamento.entity.TipoPagamento;
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
@Table(name = "pagamentos")
public class Pagamento extends Persistence {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_pagamento_id")
    private TipoPagamento tipoPagamento;

    private int parcelamento;

    @Column(name = "valor_pago")
    private BigDecimal valorPago;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "venda_id")
    @JsonBackReference
    private Venda venda;
}
