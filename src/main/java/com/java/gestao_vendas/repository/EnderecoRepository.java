package com.java.gestao_vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    List<Endereco> findByLogradouroContainingIgnoreCase(String logradouro);

    boolean existsByLogradouroContainingIgnoreCase(String logradouro);

    boolean existsByNumero(int numero);

    List<Endereco> findByCep(String cep);

    List<Endereco> findByNumero(int numero);

}
