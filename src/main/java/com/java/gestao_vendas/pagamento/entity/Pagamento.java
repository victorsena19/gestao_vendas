package com.java.gestao_vendas.tipo_pagamento.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.java.gestao_vendas.venda.entity.Venda;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tipos_pagamentos")
public class TipoPagamento extends Persistence {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome_pagamento")
    private String nomePagamento;

    @ManyToMany(mappedBy = "tipoPagamento")
    @JsonBackReference
    List<Venda> venda = new ArrayList<>();
}
