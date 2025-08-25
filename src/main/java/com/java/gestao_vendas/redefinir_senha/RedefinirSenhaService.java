package com.java.gestao_vendas.redefinir_senha;

import com.java.gestao_vendas.email.EmailDTO;
import com.java.gestao_vendas.email.EmailService;
import com.java.gestao_vendas.global_exception.model.MensagemException;
import com.java.gestao_vendas.usuario.entity.Usuario;
import com.java.gestao_vendas.usuario.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class RedefinirSenhaService {
    private final UsuarioRepository usuarioRepository;
    private final EmailService emailService;

    public RedefinirSenhaService(UsuarioRepository usuarioRepository, EmailService emailService) {
        this.usuarioRepository = usuarioRepository;
        this.emailService = emailService;
    }

    // Função para solicitar redefinição de senha
    public void solicitarRedefinicaoSenha(EmailDTO emailDTO){

        Usuario usuario = usuarioRepository.findByEmailIgnoreCase(emailDTO.getEmail());
        if (usuario == null){
            throw  new MensagemException("Usuário não encontrado");
        }

        String token = UUID.randomUUID().toString();

        usuario.setTokenRedefinirSenha(token);
        usuario.setExpiracaoToken(LocalDateTime.now().plusMinutes(30));
        usuarioRepository.save(usuario);

        String linkFront = emailDTO.getLink()+"/"+token;
        emailService.enviarEmailRedefinicaoSenha(usuario.getEmail(), usuario.getNome(),linkFront);
    }

    public void redefinirSenha(String token, String novaSenha){
        Usuario usuario = usuarioRepository.findByTokenRedefinirSenha(token);
        if (usuario == null){
            throw new MensagemException("Token inválido");
        }

        if (usuario.getTokenRedefinirSenha() == null || usuario.getExpiracaoToken().isBefore(LocalDateTime.now())){
            throw new MensagemException("Token expirado");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(novaSenha);
        usuario.setPassword(encryptedPassword);
        usuario.setTokenRedefinirSenha(null);
        usuario.setExpiracaoToken(null);
        usuarioRepository.save(usuario);
    }
}
