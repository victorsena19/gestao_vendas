package com.java.gestao_vendas.vendedor.repository;

import com.java.gestao_vendas.vendedor.entity.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

    @Query("FROM Vendedor v WHERE LOWER(v.pessoa.nomePessoa) LIKE %:nome%")
    List<Vendedor> getNome(@Param("nome") String nome);

    @Query("FROM Vendedor v WHERE v.pessoa.cnpjCpf = :cpf")
    Optional<Vendedor> findByEmail(@Param("cpf") String cpf);
}
