package com.java.gestao_vendas.cupom_fiscal.entity;

import com.java.gestao_vendas.empresa.entity.Empresa;
import com.java.gestao_vendas.venda.entity.Venda;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
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
    @JoinColumn(name = "venda_id")
    private Venda venda;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
}
