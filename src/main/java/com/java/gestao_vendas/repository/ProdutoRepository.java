package com.java.gestao_vendas.repository;

import com.java.gestao_vendas.domain.Pessoa;
import com.java.gestao_vendas.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Optional<Produto> findByIdProduto(Long id);

    @Query("FROM Produto p WHERE p.nomeProduto LIKE %:nome%")
    List<Produto> getNomeProduto(@Param("nome") String nome);

    @Query("FROM Produto p WHERE LOWER(p.pessoa.nomePessoa) LIKE %:fornecedor%")
    List<Produto> getFornecedor(@Param("fornecedor") Pessoa fornecedor);

    @Query("FROM Produto p WHERE LOWER(p.categoria.nome) LIKE %:nome%")
    List<Produto> getNomeCategoria(@Param("nome") String nome);
}
