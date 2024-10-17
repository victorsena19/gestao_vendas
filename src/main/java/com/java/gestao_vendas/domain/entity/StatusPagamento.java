package com.java.gestao_vendas.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "status_pagamentos")
public class StatusPagamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_status")
    private String nomeStatus;

    public StatusPagamento() {}
}
