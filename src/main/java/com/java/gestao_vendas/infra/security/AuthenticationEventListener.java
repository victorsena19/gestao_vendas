package com.java.gestao_vendas.infra.security;

import com.java.gestao_vendas.service.TentativaLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationEventListener {

    private final TentativaLoginService tentativaLoginService;

    @Autowired
    public AuthenticationEventListener(TentativaLoginService tentativaLoginService) {
        this.tentativaLoginService = tentativaLoginService;
    }

    @EventListener
    public void onFailure(AuthenticationFailureBadCredentialsEvent event){
        String username = (String) event.getAuthentication().getPrincipal();
        tentativaLoginService.falhaLogin(username);
    }

    @EventListener
    public void onSuccess(AuthenticationSuccessEvent event){
        String username = event.getAuthentication().getName();
        tentativaLoginService.sucessoLogin(username);
    }
}
