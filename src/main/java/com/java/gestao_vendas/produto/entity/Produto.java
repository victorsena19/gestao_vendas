package com.java.gestao_vendas.produto.entity;

import com.java.gestao_vendas.categoria.entity.Categoria;
import com.java.gestao_vendas.empresa.entity.Empresa;
import com.java.gestao_vendas.pessoa.entity.Pessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "produtos")
public class Produto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long idProduto;

    @Column(name = "nome_produto")
    private String nomeProduto;

    @Column(name = "descricao_produto")
    private String descricao;

    @Column(name = "preco_produto")
    private double preco;

    @Column(name = "quantidade_estoque")
    private int quantidadeEstoque;

    @Column(name = "aliquota_ipi")
    private double aliquotaIpi;

    @Column(name = "aliquota_icms")
    private double aliquotaIcms;

    @Column(name = "ncm_produto")
    private String ncmProduto;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

}
