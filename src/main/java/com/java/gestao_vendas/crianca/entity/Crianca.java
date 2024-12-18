package com.java.gestao_vendas.crianca.entity;

import com.java.gestao_vendas.pessoa.entity.Pessoa;
import com.java.gestao_vendas.pessoa.enuns.Sexo;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "criancas")
public class Crianca implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name = "data_nascimento")
    private LocalDateTime dataNascimento;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Column(name = "nome_mae")
    private String nomeMae;

    @Column(name = "nome_pai")
    private String nomePai;

    @Column(name = "telefone_mae")
    private String telefoneMae;

    @Column(name = "telefone_pai")
    private String telefonePai;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    public Crianca() {}
}
