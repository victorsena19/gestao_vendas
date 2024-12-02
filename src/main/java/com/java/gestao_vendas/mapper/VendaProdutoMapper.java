package com.java.gestao_vendas.mapper;

import com.java.gestao_vendas.domain.DTO.VendaProdutoDTO;
import com.java.gestao_vendas.domain.entity.VendaProduto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VendaProdutoMapper {
    VendaProdutoMapper INSTANCE = Mappers.getMapper(VendaProdutoMapper.class);

    VendaProdutoDTO toDTO(VendaProduto vendaProduto);
    VendaProduto toEntity(VendaProdutoDTO vendaProdutoDTO);
}
