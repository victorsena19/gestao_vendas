package com.java.gestao_vendas.repository;

import com.java.gestao_vendas.model.CupomFiscal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CupomFiscalRepository extends JpaRepository<CupomFiscal, Long> {


}
