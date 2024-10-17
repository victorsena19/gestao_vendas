package com.java.gestao_vendas.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "empresas")
public class Empresa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    Long idEmpresa;

    @Column(name = "nome_empresa")
    String nomeEmpresa;

    String cnpj;

    String telefone;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    com.java.gestao_vendas.entity.Endereco endereco;

    public Empresa() {}

}
