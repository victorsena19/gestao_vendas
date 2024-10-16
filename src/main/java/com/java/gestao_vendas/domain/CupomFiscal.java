package com.java.gestao_vendas.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cupons_fiscais")
public class CupomFiscal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cupom_fiscal")
    private Long id;

    @Column(name = "numero_cupom")
    private String numeroCupom;

    @Column(name = "chave_acesso")
    private String chaveAcesso;

    @Column(name = "data_emissao")
    private LocalDateTime dataEmissao;

    private String serie;

    @Column(name = "protocolo_autorizacao")
    private String protocolo;

    private String observacao;

    @OneToOne(cascade = CascadeType.ALL)
    private Venda venda;

    @OneToOne(cascade = CascadeType.ALL)
    private Empresa empresa;

    public CupomFiscal() {
    }
}
