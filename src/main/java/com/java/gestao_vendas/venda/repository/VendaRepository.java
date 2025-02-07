package com.java.gestao_vendas.venda.repository;

import com.java.gestao_vendas.venda.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface VendaRepository extends JpaRepository<Venda, UUID> {

    @Query("FROM Venda v WHERE LOWER(v.pessoa.nomePessoa) LIKE %:nome%")
    List<Venda> findClienteNome(@Param("nome") String nome);

    @Query("FROM Venda v WHERE LOWER(v.vendedor.pessoa.nomePessoa) LIKE %:nome%")
    List<Venda> findVendedorNome(@Param("nome") String nome);

}
