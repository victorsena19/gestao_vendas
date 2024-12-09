package com.java.gestao_vendas.repository;

import com.java.gestao_vendas.domain.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    List<Categoria> findByNomeContainsIgnoreCase(String nome);

}
