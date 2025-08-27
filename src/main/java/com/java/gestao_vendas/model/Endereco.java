package com.java.gestao_vendas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "enderecos")
public class Endereco extends Persistence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String logradouro;

    private String bairro;

    private int numero;

    private String cidade;

    private String estado;

    private String cep;
}

