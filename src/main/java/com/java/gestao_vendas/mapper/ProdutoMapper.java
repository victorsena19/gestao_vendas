package com.java.gestao_vendas.mapper;

import com.java.gestao_vendas.domain.DTO.ProdutoDTO;
import com.java.gestao_vendas.domain.entity.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProdutoMapper {
    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    ProdutoDTO toDTO(Produto produto);
    Produto toEntity(ProdutoDTO produtoDTO);
}
