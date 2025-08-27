package com.java.gestao_vendas.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.java.gestao_vendas.enums.StatusVenda;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "vendas")
public class Venda extends Persistence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tipo_documento")
    private String tipoDocumento;

    @Column(name = "numero_documento")
    private String numeroDocumento;

    @Column(name = "chave_acesso")
    private String chaveAcesso;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonManagedReference
    private List<Item> item;

    @Enumerated(EnumType.STRING)
    private StatusVenda statusVenda;

    @Column(name = "data_venda")
    private LocalDateTime dataVenda;

    private BigDecimal desconto;

    @Column(name = "total_venda")
    private BigDecimal totalVenda;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonManagedReference
    private List<Pagamento> pagamento;

    @Column(name = "restante_venda")
    private BigDecimal restanteVenda;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
}

