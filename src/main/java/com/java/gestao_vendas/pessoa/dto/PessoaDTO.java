package com.java.gestao_vendas.pessoa.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.java.gestao_vendas.endereco.dto.EnderecoDTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoaDTO{
    private Long id;
    @NotNull
    @NotEmpty
    private String cnpjCpf;
    @NotNull
    @NotEmpty
    private String nomePessoa;
    @NotNull
    @NotEmpty
    @Email
    private String email;
    @NotNull
    @NotEmpty
    private String telefone;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    @NotNull
    private EnderecoDTO endereco;
    @NotNull
    private boolean fornecedor;
    @NotNull
    private int tipoPessoa;
}
