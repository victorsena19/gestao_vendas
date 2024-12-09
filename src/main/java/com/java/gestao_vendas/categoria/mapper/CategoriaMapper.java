package com.java.gestao_vendas.categoria.mapper;

import com.java.gestao_vendas.categoria.dto.CategoriaDTO;
import com.java.gestao_vendas.categoria.entity.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    CategoriaDTO toDTO(Categoria categoria);
    Categoria toEntity(CategoriaDTO categoriaDTO);
}
