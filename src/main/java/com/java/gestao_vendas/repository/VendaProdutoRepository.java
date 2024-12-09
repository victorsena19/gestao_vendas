package com.java.gestao_vendas.repository;

import com.java.gestao_vendas.domain.entity.VendaProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface VendaProdutoRepository extends JpaRepository<VendaProduto, Long> {

    @Query("FROM VendaProduto vp WHERE vp.venda.id = :id")
    Optional<VendaProduto> getIdVenda(@Param("id") Long id);

    @Query("FROM VendaProduto vp WHERE vp.produto.idProduto = :id")
    Optional<VendaProduto> getIdProduto(@Param("id") Long id);


}
