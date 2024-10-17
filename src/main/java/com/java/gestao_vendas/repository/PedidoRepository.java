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

    Optional<Pedido> findByidPedido(Long id);

    @Query("FROM Pedido p WHERE LOWER(p.pessoa.nomePessoa) LIKE %:nome%")
    List<Pedido> getPedidoCliente(@Param("nome") String nome);

    @Query("FROM Pedido p WHERE LOWER(p.vendedor.pessoa.nomePessoa) LIKE %:nome%")
    List<Pedido> getPedidoVendedor(String nome);

}
