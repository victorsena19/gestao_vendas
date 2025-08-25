package com.java.gestao_vendas.global_exception.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErroValidacao {

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime timestamp;
    private int status;
    private String mensagem;
    private String caminho;
    private Map<String, String> erros;
}
