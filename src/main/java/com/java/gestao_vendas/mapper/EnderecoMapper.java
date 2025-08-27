package com.java.gestao_vendas.mapper;

import com.java.gestao_vendas.dto.EnderecoDTO;
import com.java.gestao_vendas.model.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {
    EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);

    EnderecoDTO toDTO(Endereco endereco);
    Endereco toEntity(EnderecoDTO enderecoDTO);
}
