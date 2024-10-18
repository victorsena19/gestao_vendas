package com.java.gestao_vendas.utils;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class Messege{

    private String status;
    private String mensagem;

    public Messege() {
    }
    public Messege(String status, String mensagem) {
        this.status = status;
        this.mensagem = mensagem;
    }
}

