package com.java.gestao_vendas.repository;

import com.java.gestao_vendas.domain.entity.Crianca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CriancaRepository extends JpaRepository<Crianca, Long> {

    @Query("FROM Crianca c WHERE LOWER(c.nome) LIKE %:nome%")
    List<Crianca> findNome(@Param("nome") String nome);

    @Query("FROM Crianca c WHERE c.dataNascimento  = :nascimento")
    List<Crianca> findDataNascimento(@Param("nascimento") LocalDateTime nascimento);

}
