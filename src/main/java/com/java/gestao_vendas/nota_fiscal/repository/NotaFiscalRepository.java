package com.java.gestao_vendas.nota_fiscal.repository;

import com.java.gestao_vendas.nota_fiscal.entity.NotaFiscal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Long> {


}
