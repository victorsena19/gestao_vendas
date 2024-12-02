package com.java.gestao_vendas.mapper;

import com.java.gestao_vendas.domain.DTO.CategoriaDTO;
import com.java.gestao_vendas.domain.entity.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    CategoriaDTO toDTO(Categoria categoria);
    Categoria toEntity(CategoriaDTO categoriaDTO);
}
