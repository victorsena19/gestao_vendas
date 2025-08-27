package com.java.gestao_vendas.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "pessoas")
public class Pessoa  extends Persistence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cnpj_cpf")
    private String cnpjCpf;

    @Column(name = "nome_pessoa")
    private String nomePessoa;

    private String email;

    private String telefone;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    private boolean fornecedor;

    @Column(name = "tipo_pessoa")
    private int tipoPessoa;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public Pessoa() {}
}
