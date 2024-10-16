package com.java.gestao_vendas.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "vendedores")
public class Vendedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vendedor")
    private Long id;

    @Column(name = "data_contratacao")
    private LocalDateTime dataContratacao;

    private double comissao;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Pessoa pessoa;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Empresa empresa;

    public Vendedor() {
    }
}

