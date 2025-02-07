package com.java.gestao_vendas.item.mapper;

import com.java.gestao_vendas.item.dto.ItemDTO;
import com.java.gestao_vendas.item.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    ItemDTO toDTO(Item item);
    Item toEntity(ItemDTO itemDTO);
}
