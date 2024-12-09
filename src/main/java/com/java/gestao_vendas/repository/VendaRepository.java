package com.java.gestao_vendas.repository;

import com.java.gestao_vendas.domain.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

    @Query("FROM Venda v WHERE LOWER(v.pessoa.nomePessoa) LIKE %:nome%")
    List<Venda> findClienteNome(@Param("nome") String nome);

    @Query("FROM Venda v WHERE LOWER(v.vendedor.pessoa.nomePessoa) LIKE %:nome%")
    List<Venda> findVendedorNome(@Param("nome") String nome);

}
