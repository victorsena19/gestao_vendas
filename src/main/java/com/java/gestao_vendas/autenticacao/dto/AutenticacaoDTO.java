package com.java.gestao_vendas.autenticacao.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutenticacaoDTO {
    private String email;
    private String password;
    private String permissao;
}
