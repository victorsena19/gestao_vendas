package com.java.gestao_vendas.tentativa_login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TentativaLoginDTO {

    private String username;

    private int tentativas;

    private boolean bloqueado;

    private LocalDateTime ultimaTentativa;

    private LocalDateTime desbloqueioAutomatico;
}
