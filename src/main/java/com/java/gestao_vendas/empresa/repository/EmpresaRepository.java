package com.java.gestao_vendas.empresa.repository;


import com.java.gestao_vendas.empresa.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {


}
