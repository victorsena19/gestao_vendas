package com.java.gestao_vendas.pessoa.mapper;

import com.java.gestao_vendas.pessoa.dto.PessoaDTO;
import com.java.gestao_vendas.pessoa.entity.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PessoaMapper {
    PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

    PessoaDTO toDTO(Pessoa pessoa);
    Pessoa toEntity(PessoaDTO pessoaDTO);
}
