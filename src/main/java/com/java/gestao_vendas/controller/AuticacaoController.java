package com.java.gestao_vendas.controller;

import com.java.gestao_vendas.dto.AutenticacaoDTO;
import com.java.gestao_vendas.dto.LoginRespostaDTO;
import com.java.gestao_vendas.service.TokenService;
import com.java.gestao_vendas.dto.UsuarioRespostaDTO;
import com.java.gestao_vendas.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/auth")
public class AuticacaoController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @Autowired
    public AuticacaoController(AuthenticationManager authenticationManager,
                               TokenService tokenService){
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AutenticacaoDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.getEmail(), data.getPassword());
        var auth = authenticationManager.authenticate(usernamePassword);
        var token = tokenService.gerarTokenJwt((Usuario) auth.getPrincipal());

        Usuario usuarioLogado = (Usuario) auth.getPrincipal();
        UsuarioRespostaDTO usuario = new UsuarioRespostaDTO(
                usuarioLogado.getId(),
                usuarioLogado.getNome(),
                usuarioLogado.getEmail(),
                usuarioLogado.isAtivo(),
                usuarioLogado.getPermissao()
        );

        return ResponseEntity.ok(new LoginRespostaDTO(token, usuario));
    }

}
