package com.java.gestao_vendas.mapper;

import com.java.gestao_vendas.dto.ProdutoDTO;
import com.java.gestao_vendas.model.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {
    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    ProdutoDTO toDTO(Produto produto);
    Produto toEntity(ProdutoDTO produtoDTO);
}
