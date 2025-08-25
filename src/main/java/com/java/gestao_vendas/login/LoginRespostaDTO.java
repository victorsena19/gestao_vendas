package com.java.gestao_vendas.login;

import com.java.gestao_vendas.usuario.dto.UsuarioRespostaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRespostaDTO {
    private String token;
    private UsuarioRespostaDTO usuario;
}
