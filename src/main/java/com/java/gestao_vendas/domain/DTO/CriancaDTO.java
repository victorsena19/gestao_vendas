package com.java.gestao_vendas.domain.DTO;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CriancaDTO{
    private Long id;
    private String nome;
    private LocalDateTime data_nascimento;
    private String nomeMae;
    private String nomePai;
    private String telefoneMae;
    private String telefonePai;
    private PessoaDTO pessoa;

    public CriancaDTO() {}
}
