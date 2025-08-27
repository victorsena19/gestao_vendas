package com.java.gestao_vendas.utils;

import com.java.gestao_vendas.global_exception.MensagemException;
import com.java.gestao_vendas.enums.MensagensErrosGenericas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public final class UtilitariosGerais {
    public <T> T buscarEntidadeId(JpaRepository<T, UUID> repository, UUID id, String nomeEntidade){
        return repository.findById(id).orElseThrow(() ->
                new MensagemException(MensagensErrosGenericas.IDNAOENCONTRADO.format(nomeEntidade) + id));
    }
}
