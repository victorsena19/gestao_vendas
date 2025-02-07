package com.java.gestao_vendas.pessoa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.java.gestao_vendas.empresa.entity.Empresa;
import com.java.gestao_vendas.endereco.entity.Endereco;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
