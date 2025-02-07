package com.java.gestao_vendas.venda_produto.repository;

import com.java.gestao_vendas.venda_produto.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {

    /*
    @Query("FROM VendaProduto vp WHERE vp.venda.id = :id")
    Optional<VendaProduto> getIdVenda(@Param("id") Long id);
*/
    @Query("FROM VendaProduto vp WHERE vp.produto.id = :id")
    Optional<Item> getIdProduto(@Param("id") UUID id);


}
