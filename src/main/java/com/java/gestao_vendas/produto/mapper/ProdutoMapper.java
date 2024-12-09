package com.java.gestao_vendas.produto.mapper;

import com.java.gestao_vendas.produto.dto.ProdutoDTO;
import com.java.gestao_vendas.produto.entity.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {
    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    ProdutoDTO toDTO(Produto produto);
    Produto toEntity(ProdutoDTO produtoDTO);
}
