package com.java.gestao_vendas.repository;

import com.java.gestao_vendas.domain.VendaProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VendaProdutoRepository extends JpaRepository<VendaProduto, Long> {

}
