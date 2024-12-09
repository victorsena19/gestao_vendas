package com.java.gestao_vendas.repository;

import com.java.gestao_vendas.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByPessoa_NomePessoaContainingIgnoreCase(String nome);

    List<Pedido> findByVendedor_Pessoa_NomePessoaContainingIgnoreCase(String nome);

}
