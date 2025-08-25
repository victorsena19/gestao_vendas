package com.java.gestao_vendas.usuario.mapper;

import com.java.gestao_vendas.usuario.dto.ListaUsuarioDTO;
import com.java.gestao_vendas.usuario.dto.UsuarioDTO;
import com.java.gestao_vendas.usuario.entity.Usuario;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioDTO toDTO(Usuario usuario);
    List<UsuarioDTO> toDTO(List<Usuario> usuarios);
    Usuario toEntity(UsuarioDTO usuarioDTO);

    List<ListaUsuarioDTO> listaUsuarioToDTO(List<Usuario> usuarios);
    ListaUsuarioDTO listaUsuarioIdToDTO(Usuario usuario);
}
