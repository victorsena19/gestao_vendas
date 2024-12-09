package com.java.gestao_vendas.cupom_fiscal.repository;

import com.java.gestao_vendas.cupom_fiscal.entity.CupomFiscal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CupomFiscalRepository extends JpaRepository<CupomFiscal, Long> {


}
