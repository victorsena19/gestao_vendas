package com.java.gestao_vendas.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_pagamento_id")
    private StatusPagamento status;

    @Column(name = "data_venda")
    private LocalDateTime dataVenda;

    private double desconto;

    @Column(name = "total_venda")
    private double totalVenda;

    @JoinColumn(name = "tipo_pagamento_id")
    @OneToOne(cascade = CascadeType.ALL)
    private TipoPagamento tipoPagamento;

    @OneToOne(cascade = CascadeType.ALL)
    private Pessoa pessoa;

    @OneToOne(cascade = CascadeType.ALL)
    private Vendedor vendedor;

    @OneToMany(cascade = CascadeType.ALL)
    @Column(name = "venda_produto_id")
    private List<VendaProduto> vendaProduto;

    @OneToOne(cascade = CascadeType.ALL)
    private Empresa empresa;

    public Venda() {
    }
}

