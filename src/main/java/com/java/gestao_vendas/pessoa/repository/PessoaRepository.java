package com.java.gestao_vendas.pessoa.repository;

import com.java.gestao_vendas.pessoa.entity.Pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    List<Pessoa> getNomeContainingIgnoreCase(String nome);

    Optional<Pessoa> findBycnpjCpf(String cnpjCpf);

    Optional<Pessoa> findByEmailIgnoreCase(String email);

    List<Pessoa> findByDataNascimento(LocalDateTime dataNascimento);
}
