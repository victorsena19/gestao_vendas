package com.java.gestao_vendas.venda_produto.mapper;

import com.java.gestao_vendas.venda_produto.dto.ItemDTO;
import com.java.gestao_vendas.venda_produto.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    ItemDTO toDTO(Item item);
    Item toEntity(ItemDTO vendaProdutoDTO);
}
