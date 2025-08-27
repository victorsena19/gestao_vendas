package com.java.gestao_vendas.repository;

import com.java.gestao_vendas.model.TentativaLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TentativaLoginRepository extends JpaRepository<TentativaLogin, String> {
}
