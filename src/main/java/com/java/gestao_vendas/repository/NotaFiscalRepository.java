package com.java.gestao_vendas.repository;

import com.java.gestao_vendas.model.NotaFiscal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Long> {


}
