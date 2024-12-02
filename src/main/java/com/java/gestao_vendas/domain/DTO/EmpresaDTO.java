package com.java.gestao_vendas.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpresaDTO{
    private Long idEmpresa;
    private String nomeEmpresa;
    private String cnpj;
    private String telefone;
    private EnderecoDTO endereco;

}
