package com.java.gestao_vendas.status_pagamento.repository;

import com.java.gestao_vendas.status_pagamento.entity.StatusPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusPagamentoRepository extends JpaRepository<StatusPagamento, Long> {

    boolean existsByNomeStatusIgnoreCase(String nome);

    List<StatusPagamento> findByNomeStatusContainsIgnoreCase(String nome);

}
