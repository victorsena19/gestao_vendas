package com.java.gestao_vendas.venda_produto.mapper;

import com.java.gestao_vendas.venda_produto.dto.VendaProdutoDTO;
import com.java.gestao_vendas.venda_produto.entity.VendaProduto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VendaProdutoMapper {
    VendaProdutoMapper INSTANCE = Mappers.getMapper(VendaProdutoMapper.class);

    VendaProdutoDTO toDTO(VendaProduto vendaProduto);
    VendaProduto toEntity(VendaProdutoDTO vendaProdutoDTO);
}
