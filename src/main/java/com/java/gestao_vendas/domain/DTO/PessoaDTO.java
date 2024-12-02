package com.java.gestao_vendas.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoaDTO{
    private Long idPessoa;
    private String cnpjCpf;
    private String nomePessoa;
    private String email;
    private String telefone;
    private LocalDateTime dataNascimento;
    private EnderecoDTO endereco;
    private boolean fornecedor;
    private int tipoPessoa;
    private EmpresaDTO empresa;

}
