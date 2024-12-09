package com.java.gestao_vendas.endereco.repository;

import com.java.gestao_vendas.endereco.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    List<Endereco> findByLogradouroContainingIgnoreCase(String logradouro);

    List<Endereco> findByCep(String cep);

    List<Endereco> findByNumero(int numero);

}
