package com.java.gestao_vendas.mapper;

import com.java.gestao_vendas.domain.DTO.VendaDTO;
import com.java.gestao_vendas.domain.entity.Venda;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VendaMapper {
    VendaMapper INSTANCE = Mappers.getMapper(VendaMapper.class);

    VendaDTO toDTO(Venda venda);
    Venda toEntity(VendaDTO vendaDTO);
}
