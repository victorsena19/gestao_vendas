package com.java.gestao_vendas.repository;

import com.java.gestao_vendas.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByPessoa_NomePessoaContainingIgnoreCase(String nome);

    List<Pedido> findByVendedor_Pessoa_NomePessoaContainingIgnoreCase(String nome);

}
