package com.java.gestao_vendas.repository;

import com.java.gestao_vendas.domain.Categoria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Optional<Categoria> findById(Long id);

    @Query("FROM Categoria c WHERE c.nome LIKE %:nome%")
    List<Categoria> getNomeCategoria(@Param("nome") String nome);

}
