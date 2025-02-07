package com.java.gestao_vendas.item.repository;

import com.java.gestao_vendas.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    /*
    @Query("FROM Item i WHERE i.venda.id = :id")
    Optional<Item> getIdVenda(@Param("id") Long id);
*/
    @Query("FROM Item i WHERE i.produto.id = :id")
    Optional<Item> getIdProduto(@Param("id") Long id);


}
