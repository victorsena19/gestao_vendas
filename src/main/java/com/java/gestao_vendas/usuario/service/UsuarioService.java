package com.java.gestao_vendas.usuario.service;

import com.java.gestao_vendas.global_exception.model.MensagemException;
import com.java.gestao_vendas.usuario.dto.ListaUsuarioDTO;
import com.java.gestao_vendas.usuario.dto.UsuarioDTO;
import com.java.gestao_vendas.usuario.entity.Usuario;
import com.java.gestao_vendas.usuario.mapper.UsuarioMapper;
import com.java.gestao_vendas.usuario.repository.UsuarioRepository;
import com.java.gestao_vendas.utils.UtilitariosGerais;
import com.java.gestao_vendas.utils.enums.MensagensErrosGenericas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 *  Classe com CRUD de Usuário com as devidas validações para cada função
 */
@Service
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final UtilitariosGerais utilitariosGerais;



    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository,
                          UsuarioMapper usuarioMapper,
                          UtilitariosGerais utilitariosGerais){
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
        this.utilitariosGerais = utilitariosGerais;
    }

    @Transactional(readOnly = true)
    public UserDetails listarEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    @Transactional(readOnly = true)
    public List<ListaUsuarioDTO> listarUsuarios(){
        List<Usuario> usuario = usuarioRepository.findAll();
        return usuarioMapper.listaUsuarioToDTO(usuario);
    }

    @Transactional(readOnly = true)
    public ListaUsuarioDTO listarUsuarioId(UUID id){
        Usuario usuario = utilitariosGerais
                .buscarEntidadeId(usuarioRepository, id, "Usuario");
        return usuarioMapper.listaUsuarioIdToDTO(usuario);
    }

    @Transactional(readOnly = true)
    public List<ListaUsuarioDTO> listarUsuarioPorNome(String nome){
        List<Usuario> usuario = usuarioRepository.findByNomeContainsIgnoreCase(nome);
        if (usuario.isEmpty()){
            throw new MensagemException(MensagensErrosGenericas.ARGUMENTONAOEXISTENTE.getErro());
        }
        return usuarioMapper.listaUsuarioToDTO(usuario);
    }

    @Transactional
    public UsuarioDTO cadastroUsuario(UsuarioDTO usuarioDTO){
        boolean email = usuarioRepository.existsByEmailIgnoreCase(usuarioDTO.getEmail());
        if(email){
            throw new MensagemException("Esse email já existe no sistema : " + usuarioDTO.getEmail());
        }
        //Encriptografa a senha antes de salvar
        String encryptedPassword = new BCryptPasswordEncoder().encode(usuarioDTO.getPassword());
        usuarioDTO.setPassword(encryptedPassword);

        Usuario novaUsuario = usuarioRepository.save(usuarioMapper.toEntity(usuarioDTO));

        return usuarioMapper.toDTO(novaUsuario);
    }

    @Transactional
    public UsuarioDTO atualizarUsuario(UUID id, UsuarioDTO usuarioDTO){
        Usuario usuarioExistente = utilitariosGerais
                .buscarEntidadeId(usuarioRepository, id, "Usuário");

        // Atualiza apenas os campos não nulos
        if (usuarioDTO.getNome() != null && !usuarioDTO.getNome().isBlank()) {
            usuarioExistente.setNome(usuarioDTO.getNome());
        }

        if (usuarioDTO.getEmail() != null && !usuarioDTO.getEmail().isBlank()) {
            usuarioExistente.setEmail(usuarioDTO.getEmail());
        }

        if (usuarioDTO.getPassword() != null && !usuarioDTO.getPassword().isBlank()) {
            String encryptedPassword = new BCryptPasswordEncoder().encode(usuarioDTO.getPassword());
            usuarioExistente.setPassword(encryptedPassword);
        }

        usuarioExistente.setAtivo(usuarioDTO.isAtivo());

        if (usuarioDTO.getPermissao() != null) {
            usuarioExistente.setPermissao(usuarioDTO.getPermissao());
        }

        Usuario salvo = usuarioRepository.save(usuarioExistente);

        return usuarioMapper.toDTO(salvo);
    }

    @Transactional
    public void deletarUsuario(UUID id){
        Usuario usuario = utilitariosGerais
                .buscarEntidadeId(usuarioRepository, id, "Usuário");


        usuarioRepository.delete(usuario);
    }

    //Sobrescrita de método do UserDetailsService
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(username);
    }
}
