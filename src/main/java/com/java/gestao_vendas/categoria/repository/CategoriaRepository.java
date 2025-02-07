package com.java.gestao_vendas.categoria.repository;

import com.java.gestao_vendas.categoria.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    boolean existsByNomeIgnoreCase(String nome);

    List<Categoria> findByNomeContainsIgnoreCase(String nome);

}
