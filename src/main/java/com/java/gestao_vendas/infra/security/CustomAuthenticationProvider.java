package com.java.gestao_vendas.infra.security;

import com.java.gestao_vendas.global_exception.MensagemException;
import com.java.gestao_vendas.service.TentativaLoginService;
import com.java.gestao_vendas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomAuthenticationProvider implements AuthenticationProvider {
    private final UsuarioService usuarioService;
    private final TentativaLoginService tentativaLoginService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CustomAuthenticationProvider(UsuarioService usuarioService, TentativaLoginService tentativaLoginService, PasswordEncoder passwordEncoder) {
        this.usuarioService = usuarioService;
        this.tentativaLoginService = tentativaLoginService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String senha = authentication.getCredentials().toString();

        // Verifica bloqueio
        if (tentativaLoginService.bloqueado(email)) {
            throw new LockedException("Usuário bloqueado por múltiplas tentativas inválidas.");
        }

        UserDetails usuario = usuarioService.listarEmail(email);
        if (usuario == null) {
            throw new MensagemException("Usuário não encontrado");
        }

        if (!passwordEncoder.matches(senha, usuario.getPassword())) {
            tentativaLoginService.falhaLogin(email);
            throw new BadCredentialsException("Credenciais inválidas.");
        }

        tentativaLoginService.sucessoLogin(email); // zera tentativas

        return new UsernamePasswordAuthenticationToken(usuario, senha, usuario.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
