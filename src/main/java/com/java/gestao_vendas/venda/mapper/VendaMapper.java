package com.java.gestao_vendas.venda.mapper;

import com.java.gestao_vendas.venda.dto.VendaDTO;
import com.java.gestao_vendas.venda.entity.Venda;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VendaMapper {
    VendaMapper INSTANCE = Mappers.getMapper(VendaMapper.class);

    VendaDTO toDTO(Venda venda);
    Venda toEntity(VendaDTO vendaDTO);
}
