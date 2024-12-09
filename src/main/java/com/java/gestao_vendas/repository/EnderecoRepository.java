package com.java.gestao_vendas.repository;

import com.java.gestao_vendas.domain.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    List<Endereco> findByLogradouroContainingIgnoreCase(String logradouro);

    List<Endereco> findByCep(String cep);

    List<Endereco> findByNumero(int numero);

}
