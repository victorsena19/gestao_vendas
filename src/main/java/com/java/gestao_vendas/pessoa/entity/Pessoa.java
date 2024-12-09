package com.java.gestao_vendas.pessoa.entity;

import com.java.gestao_vendas.empresa.entity.Empresa;
import com.java.gestao_vendas.endereco.entity.Endereco;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pessoas")
public class Pessoa  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pessoa")
    private Long idPessoa;

    @Column(name = "cnpj_cpf")
    private String cnpjCpf;

    @Column(name = "nome_pessoa")
    private String nomePessoa;

    private String email;

    private String telefone;

    @Column(name = "data_nascimento")
    private LocalDateTime dataNascimento;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    private boolean fornecedor;

    @Column(name = "tipo_pessoa")
    private int tipoPessoa;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public Pessoa() {}
}
