package com.java.gestao_vendas.utils.enums;

import lombok.Getter;

@Getter
public enum MensagensErrosGenericas {
    PERMISSAOUSUARIONEGADA("Voce não tem permissão para acessar essa rota"),
    IDNAOENCONTRADO("Não foi possível encontrar um(a) %s com esse ID: "),
    ARGUMENTOJAEXISTENTE("%s já encontra-se cadastrada no sistema!"),
    ARGUMENTONAOEXISTENTE("Nenhum registro foi localizado");
    private final String erro;

     MensagensErrosGenericas(String erro) {
        this.erro = erro;
    }

    public String format(Object... args){
         return String.format(erro, args);
    }


}
