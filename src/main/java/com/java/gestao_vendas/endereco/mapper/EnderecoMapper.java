package com.java.gestao_vendas.endereco.mapper;

import com.java.gestao_vendas.endereco.dto.EnderecoDTO;
import com.java.gestao_vendas.endereco.entity.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {
    EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);

    EnderecoDTO toDTO(Endereco endereco);
    Endereco toEntity(EnderecoDTO enderecoDTO);
}
