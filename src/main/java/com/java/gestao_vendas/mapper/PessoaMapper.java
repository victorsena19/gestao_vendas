package com.java.gestao_vendas.mapper;

import com.java.gestao_vendas.domain.DTO.PessoaDTO;
import com.java.gestao_vendas.domain.entity.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PessoaMapper {
    PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

    PessoaDTO toDTO(Pessoa pessoa);
    Pessoa toEntity(PessoaDTO pessoaDTO);
}
