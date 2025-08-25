package com.java.gestao_vendas.usuario.controller;

import com.java.gestao_vendas.email.EmailDTO;
import com.java.gestao_vendas.redefinir_senha.RedefinirSenhaDTO;
import com.java.gestao_vendas.redefinir_senha.RedefinirSenhaService;
import com.java.gestao_vendas.usuario.dto.ListaUsuarioDTO;
import com.java.gestao_vendas.usuario.dto.UsuarioDTO;
import com.java.gestao_vendas.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;
    private final RedefinirSenhaService redefinirSenhaService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService, RedefinirSenhaService redefinirSenhaService){
        this.usuarioService = usuarioService;
        this.redefinirSenhaService = redefinirSenhaService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<ListaUsuarioDTO>> listarUsuarios(@RequestParam(required = false) String nome){
        return (nome != null)
                ? ResponseEntity.ok().body(usuarioService.listarUsuarioPorNome(nome))
                : ResponseEntity.ok().body(usuarioService.listarUsuarios());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ListaUsuarioDTO> listarUsuarioId(@PathVariable UUID id){
        ListaUsuarioDTO registro = usuarioService.listarUsuarioId(id);
        return ResponseEntity.ok().body(registro);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastrarUsuario(@RequestBody UsuarioDTO usuario){
        UsuarioDTO novoUsuario = usuarioService.cadastroUsuario(usuario);
        return  ResponseEntity.status(HttpStatusCode.valueOf(201)).body(novoUsuario);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@PathVariable UUID id, @RequestBody UsuarioDTO usuario){
        UsuarioDTO usuarioAtualizado = usuarioService.atualizarUsuario(id,usuario);
        return  ResponseEntity.ok().body(usuarioAtualizado);
    }

    @PostMapping(path = "/solicitar-redefinicao-senha")
    public ResponseEntity<?> solicitarRedefinicaoSenha(@RequestBody EmailDTO emailDTO){
        redefinirSenhaService.solicitarRedefinicaoSenha(emailDTO);
        return ResponseEntity.ok("Solicitação de redefinição de senha enviada com sucesso, verifique seu Email");
    }

    @PatchMapping(path = "/redefinir-senha")
    public ResponseEntity<?> redefinirSenha(@RequestBody RedefinirSenhaDTO redefinirSenhaDTO){
        redefinirSenhaService.redefinirSenha(redefinirSenhaDTO.getToken(), redefinirSenhaDTO.getNovaSenha());
        return ResponseEntity.ok("Senha redefinida com sucesso");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<UsuarioDTO> deletarUsuario(@PathVariable UUID id){
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
