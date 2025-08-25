package com.java.gestao_vendas.usuario.repository;

import com.java.gestao_vendas.usuario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    boolean existsByEmailIgnoreCase(String email);

    UserDetails findByEmail(String email);

    Usuario findByEmailIgnoreCase(String email);

    Usuario findByTokenRedefinirSenha(String token);

    List<Usuario> findByNomeContainsIgnoreCase(String nome);
}
