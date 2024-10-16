package com.java.gestao_vendas.repository;

import com.java.gestao_vendas.domain.Pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Optional<Pessoa> findById(Long id);

    @Query("FROM Pessoa p WHERE LOWER(p.nomePessoa) LIKE %:nome%")
    List<Pessoa> getNome(@Param("nome") String nome);

    Optional<Pessoa> findBycnpjCpf(String cnpjCpf);

    @Query("FROM Pessoa p WHERE p.email LIKE %:email%")
    List<Pessoa> getEmail(@Param("email") String email);

    List<Pessoa> findByDataNascimento(LocalDateTime dataNascimento);
}
