package com.java.gestao_vendas.empresa.entity;

import com.java.gestao_vendas.endereco.entity.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
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
    @JoinColumn(name = "categoria_id")
    private Endereco endereco;

}
