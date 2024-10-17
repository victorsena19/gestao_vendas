package com.java.gestao_vendas.domain.DTO;

import lombok.Data;
import java.time.LocalDateTime;

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

    public PessoaDTO() {}
}
