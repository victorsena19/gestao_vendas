package com.java.gestao_vendas.mapper;

import com.java.gestao_vendas.dto.PedidoDTO;
import com.java.gestao_vendas.model.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PedidoMapper {
    PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);

    PedidoDTO toDTO(Pedido pedido);
    Pedido toEntity(PedidoDTO pedidoDTO);
}
