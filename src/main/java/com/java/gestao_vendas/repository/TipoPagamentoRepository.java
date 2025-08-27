package com.java.gestao_vendas.repository;

import com.java.gestao_vendas.model.TipoPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoPagamentoRepository extends JpaRepository<TipoPagamento, Long> {

    boolean existsByNomePagamentoIgnoreCase(String nome);

    List<TipoPagamento> findByNomePagamentoContainsIgnoreCase(String nome);

}
