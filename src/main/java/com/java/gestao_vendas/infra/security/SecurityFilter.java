package com.java.gestao_vendas.infra.security;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.java.gestao_vendas.global_exception.ErroPadronizado;
import com.java.gestao_vendas.service.TokenService;
import com.java.gestao_vendas.service.UsuarioService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenService tokenService;

    private final UsuarioService usuarioService;

    private final ObjectMapper mapper;

    @Autowired
    public SecurityFilter(TokenService tokenService,
                          UsuarioService usuarioService,
                          ObjectMapper mapper) {
        this.tokenService = tokenService;
        this.usuarioService = usuarioService;
        this.mapper = mapper;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recuperarToken(request);
        try{
            if (token != null){
                var email = tokenService.validarTokenJwt(token);
                UserDetails usuario = usuarioService.listarEmail(email);

                var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            filterChain.doFilter(request, response);
        }catch (TokenExpiredException ex){
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.setContentType("application/json");
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            response.getWriter().write(
                    mapper.writeValueAsString(
                            new ErroPadronizado(
                                    LocalDateTime.now(),
                                    HttpStatus.FORBIDDEN.value(),
                                    "Token expirado. Faça login novamente.",
                                    request.getRequestURI()
                            )
                    ));
        }

    }

    private String recuperarToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if(authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }


}
