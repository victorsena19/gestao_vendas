package com.java.gestao_vendas.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.java.gestao_vendas.enums.TipoPessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pessoas")
public class Pessoa  extends Persistence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cnpj_cpf")
    private String cnpjCpf;

    private String nome;

    private String telefone;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    private String endereco;

    private boolean fornecedor;

    @Column(name = "tipo_pessoa")
    private TipoPessoa tipoPessoa;

}
