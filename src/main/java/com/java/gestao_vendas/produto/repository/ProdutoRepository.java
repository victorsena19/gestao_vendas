package com.java.gestao_vendas.produto.repository;

import com.java.gestao_vendas.pessoa.entity.Pessoa;
import com.java.gestao_vendas.produto.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByNomeProdutoContainingIgnoreCase(String nome);

    @Query("FROM Produto p WHERE LOWER(p.pessoa.nomePessoa) LIKE %:fornecedor%")
    List<Produto> getFornecedor(@Param("fornecedor") Pessoa fornecedor);

    List<Produto> getNomeCategoria(String nome);
}
