package com.java.gestao_vendas.venda.entity;

import com.java.gestao_vendas.venda_produto.entity.VendaProduto;
import com.java.gestao_vendas.vendedor.entity.Vendedor;
import com.java.gestao_vendas.empresa.entity.Empresa;
import com.java.gestao_vendas.pessoa.entity.Pessoa;
import com.java.gestao_vendas.status_pagamento.entity.StatusPagamento;
import com.java.gestao_vendas.tipo_pagamento.entity.TipoPagamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "vendas")
public class Venda implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venda")
    private Long id;

    @Column(name = "tipo_documento")
    private String tipoDocumento;

    @Column(name = "numero_documento")
    private String numeroDocumento;

    @Column(name = "chave_acesso")
    private String chaveAcesso;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_pagamento_id")
    private StatusPagamento status;

    @Column(name = "data_venda")
    private LocalDateTime dataVenda;

    private double desconto;

    @Column(name = "total_venda")
    private double totalVenda;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_pagamento_id")
    private TipoPagamento tipoPagamento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "venda_produto_id")
    private List<VendaProduto> vendaProduto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
}

