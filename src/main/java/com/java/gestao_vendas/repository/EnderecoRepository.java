package com.java.gestao_vendas.repository;

import com.java.gestao_vendas.domain.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query("FROM Endereco e WHERE e.endereco LIKE %:endereco%")
    List<Endereco> getEnderecos(@Param("endereco") String endereco);

    @Query("FROM Endereco e WHERE e.endereco LIKE %:cep%")
    List<Endereco> getCep(@Param("cep") String cep);
}
