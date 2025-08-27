package com.java.gestao_vendas.mapper;

import com.java.gestao_vendas.dto.ItemDTO;
import com.java.gestao_vendas.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    ItemDTO toDTO(Item item);
    Item toEntity(ItemDTO itemDTO);
}
