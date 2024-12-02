package com.java.gestao_vendas.domain.DTO;

import com.java.gestao_vendas.enuns.Sexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CriancaDTO{
    private Long id;
    private String nome;
    private LocalDateTime data_nascimento;
    private Sexo sexo;
    private String nomeMae;
    private String nomePai;
    private String telefoneMae;
    private String telefonePai;
    private PessoaDTO pessoa;
}
