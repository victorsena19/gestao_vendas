package com.java.gestao_vendas.repository;

import com.java.gestao_vendas.domain.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

    Optional<Venda> findById(Long id);

    List<Venda> findByClienteId(Long id);
}
