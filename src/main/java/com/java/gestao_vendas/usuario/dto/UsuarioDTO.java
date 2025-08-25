package com.java.gestao_vendas.usuario.dto;

import com.java.gestao_vendas.usuario.enums.UsuarioPermissao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private UUID id;
    private String nome;
    private String email;
    private boolean ativo;
    private String password;
    private UsuarioPermissao permissao;
}

