package com.java.gestao_vendas.service;

import com.java.gestao_vendas.dto.TentativaLoginDTO;
import com.java.gestao_vendas.mapper.TentativaLoginMapper;
import com.java.gestao_vendas.model.TentativaLogin;
import com.java.gestao_vendas.repository.TentativaLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TentativaLoginService {

    private final TentativaLoginMapper tentativaLoginMapper;
    private static final int MAX_TENTATIVAS = 5;
    private static final int TEMPO_BLOQUEIO_MINUTOS = 10;

    private final TentativaLoginRepository tentativaLoginRepository;

    @Autowired
    public TentativaLoginService(TentativaLoginMapper tentativaLoginMapper,
                                 TentativaLoginRepository tentativaLoginRepository) {
        this.tentativaLoginMapper = tentativaLoginMapper;
        this.tentativaLoginRepository = tentativaLoginRepository;
    }

    public void falhaLogin(String username){
        System.out.println("aqui esta as tentativas" + MAX_TENTATIVAS);

        TentativaLogin tentativaLogin = tentativaLoginRepository.findById(username)
                .orElse(tentativaLoginMapper
                        .toEntity( new TentativaLoginDTO(username,
                                0,
                                false,
                                null,
                                null)));
        tentativaLogin.setTentativas(tentativaLogin.getTentativas() + 1);
        tentativaLogin.setUltimaTentativa(LocalDateTime.now());

        if (tentativaLogin.getTentativas() >= MAX_TENTATIVAS) {
            tentativaLogin.setBloqueado(true);
            tentativaLogin.setDesbloqueioAutomatico(LocalDateTime.now().plusMinutes(TEMPO_BLOQUEIO_MINUTOS));
        }
        tentativaLoginRepository.save(tentativaLogin);

    }

    public void sucessoLogin(String username){
        tentativaLoginRepository.deleteById(username);
    }

    public boolean bloqueado(String username){
        return tentativaLoginRepository.findById(username).map(TentativaLogin::isBloqueado).orElse(false);
    }
}
