package com.java.gestao_vendas.categoria.entity;


import com.java.gestao_vendas.empresa.entity.Empresa;
import com.java.gestao_vendas.produto.entity.Produto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "categorias")
public class Categoria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Produto> produto;

    private String descricao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

}
