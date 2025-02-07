package com.java.gestao_vendas.venda.mapper;

import com.java.gestao_vendas.venda.dto.VendaDTO;
import com.java.gestao_vendas.venda.entity.Venda;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VendaMapper {

    @Mapping(target = "itens.venda", ignore = true)
    VendaDTO toDTO(Venda venda);

    @Mapping(target = "itens.venda", ignore = true)
    Venda toEntity(VendaDTO vendaDTO);
}
