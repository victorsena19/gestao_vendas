package com.java.gestao_vendas.dto;


import com.java.gestao_vendas.enums.UsuarioPermissao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaUsuarioDTO {
    private UUID id;
    private String nome;
    private String email;
    private boolean ativo;
    private UsuarioPermissao permissao;
}
