package com.java.gestao_vendas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedefinirSenhaDTO {

    private String token;
    private String novaSenha;
}
