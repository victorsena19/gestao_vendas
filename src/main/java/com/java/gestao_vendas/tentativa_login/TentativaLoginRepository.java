package com.java.gestao_vendas.tentativa_login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TentativaLoginRepository extends JpaRepository<TentativaLogin, String> {
}
