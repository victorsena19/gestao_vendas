package com.java.gestao_vendas.domain.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "categorias")
public class Categoria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    @OneToOne(cascade = CascadeType.ALL)
    private com.java.gestao_vendas.entity.Empresa empresa;

    public Categoria() {}
}
