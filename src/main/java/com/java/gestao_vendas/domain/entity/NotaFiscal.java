package com.java.gestao_vendas.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "notas_fiscais")
public class NotaFiscal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota_fiscal")
    private Long idNotaFiscal;

    @Column(name = "numero_nota")
    private String numeroNota;

    @Column(name = "chave_acesso")
    private String chaveAcesso;

    private String serie;

    @Column(name = "data_emissao")
    private LocalDateTime dataEmissao;

    @Column(name = "natureza_operacao")
    private String naturezaOperacao;

    @Column(name = "protocolo_autorizacao")
    private String protocolo;

    private String observacao;

    @OneToOne(cascade = CascadeType.ALL)
    private Venda venda;

    @OneToOne(cascade = CascadeType.ALL)
    private Empresa empresa;

    public NotaFiscal() {}
}
