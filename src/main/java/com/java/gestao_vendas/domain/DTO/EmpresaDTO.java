package com.java.gestao_vendas.domain.DTO;

import lombok.Data;

@Data
public class EmpresaDTO{
    private Long idEmpresa;
    private String nomeEmpresa;
    private String cnpj;
    private String telefone;
    private EnderecoDTO endereco;

    public EmpresaDTO() {}

}
