package com.java.gestao_vendas.pedido.entity;
import com.java.gestao_vendas.pessoa.entity.Pessoa;
import com.java.gestao_vendas.status_pagamento.entity.StatusPagamento;
import com.java.gestao_vendas.tipo_pagamento.entity.TipoPagamento;
import com.java.gestao_vendas.vendedor.entity.Vendedor;
import com.java.gestao_vendas.empresa.entity.Empresa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
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
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "vendedor_id")
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
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

}
